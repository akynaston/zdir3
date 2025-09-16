import string
import time
import getpass
import os
import glob
import re
import sys
import subprocess
import json
import platform
import secrets
from datetime import datetime

#This block added by Aaron Kynaston to dump the GetPSMKeys_Settings.json file before starting, so you know when you need to reset your keys, as they're good for one hour.
try:
    with open("GetPSMKeys_Settings.json", "r") as file:
        content = file.read()
        print(content)
except FileNotFoundError:
    print("Error: The file 'your_file.txt' was not found.")
except Exception as e:
    print(f"An error occurred: {e}")



try: # Trying to import the libraries. User must pip install selenium
    import selenium
except ModuleNotFoundError:
    print("Selenium is not installed.")
    # Ask the user if they want to install Selenium
    install = input("Would you like to install Selenium now? (y/n): ").strip().lower()
    if install == "y":
        # Use subprocess to install Selenium via pip
        subprocess.check_call([sys.executable, "-m", "pip", "install", "selenium"])
        print("Selenium has been installed.")
    else:
        print("Selenium is required to run this script. Exiting.")
        sys.exit(1)  # Exit if the user declines to install Selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.options import Options
from selenium.common.exceptions import NoSuchElementException, TimeoutException
import sys

SETTINGS_FILE = "GetPSMKeys_Settings.json"
DEV_PSM = "https://pvwa-sapm.cis.dev.swacorp.com/PasswordVault/v10/PSM-SSH-MFA-Caching" # Do not edit
QA_PSM = "https://pvwa-sapm.cis.qa.swacorp.com/PasswordVault/v10/PSM-SSH-MFA-Caching" # Do not edit
PRD_PSM = "https://pvwa-sapm.cis.prod.swacorp.com/PasswordVault/v10/PSM-SSH-MFA-Caching" # Do not edit

def detectOS():
    user_OS = platform.system()
    if user_OS == "Windows":
        return "Windows"
    elif user_OS == "Darwin":
        return "MacOS"

def hideCredentials(credentials):
    hidden = ""
    for letter in range(len(credentials)): hidden += "*"
    return hidden

def setPassphrase():

    print("NOTE: Set a passphrase for your keys. It must contain at least 8 characters, one 1 upper and lower and lowercase letter, and a digit.")
    key_passphrase = getpass.getpass("SSH Key Passphrase (Hidden): ") # 8 Chars min, must have 1 digit, 1 uppercase letter, 1 lowercase letter

    while validatePassphrase(key_passphrase) == False:
        print("\nInvalid passphrase.\n")
        key_passphrase = setPassphrase()
        validatePassphrase(key_passphrase)

    hidden_passphrase = hideCredentials(key_passphrase)

    print(f"\nNOTE: Passphrase will be set to {hidden_passphrase} throughout the duration of this script run.")

    return key_passphrase

def grantWriteMac(settings, file_path):
    open_ssh_key = file_path + "/key.openssh"
    pem_key = file_path + "/key.pem"
    ppk_key = file_path + "/key.ppk"

    if settings["OS"] == "MacOS":
        subprocess.run(["chmod", "600", open_ssh_key])
        subprocess.run(["chmod", "600", pem_key])
        subprocess.run(["chmod", "600", ppk_key])
        print(f"MacOS: Granted read/write permissions to downloaded keys (chmod 600).")

def firstRun():

    if os.path.exists(SETTINGS_FILE) == False:
        print("\nSince this is your first time running this script, you will be asked to provide some settings.")
        return True
    else:
        return False

def display_settings(settings):
    """Display settings from the JSON file in a readable format."""

    # Display the settings
    print("User Settings:\n")

    # Display key downloads
    print("Last Key Downloads:")
    for env, timestamp in settings.get("key_downloads", {}).items():
        print(f"  {env.upper()}: {timestamp if timestamp else 'Not yet downloaded'}")

    # Display username
    username = settings.get("username", "Not set")
    print(f"\nUsername: {username}")

    # Display passphrase generation preference
    gen_passphrase = settings.get("GEN_PASSPHRASE", False)
    print(f"Generate Passphrase: {'Enabled' if gen_passphrase else 'Disabled'}")

    # Display key paths
    print("\nKey Paths:")
    for env, path in settings.get("keypaths", {}).items():
        print(f"  {env.upper()}: {path}")

def setup(settings):
    setUsername(settings, False)
    setGenPasskeyOption(settings)
    setKeyPath(settings, "dev")
    setKeyPath(settings, "qa")
    setKeyPath(settings, "prod")

def changeKeyPath(settings):
    setKeyPath(settings, "dev")
    setKeyPath(settings, "qa")
    setKeyPath(settings, "prod")

def setUsername(settings, skip_prompt, uid=""):
    if skip_prompt == True:
        settings["username"] = uid
        save_settings(settings)
    else:
        uid = input(f"\nID is currently set to '{uid}'. Please enter the new user ID to use (e/x ID): ")
        print(f"Updated username to {uid}.")
        settings["username"] = uid
        save_settings(settings)

def setPreferredKey(settings):
    keytype = input("\nWhat is your preferred SSH keytype? (OpenSSH, PPK, PEM): ").lower()
    while keytype not in ["openssh", "ppk", "pem"]:
        keytype = input("\nInvalid entry. Please type OpenSSH, PPK, or PEM: ").lower()
    settings["preferred_keytype"] = keytype
    save_settings(settings)
    print(f"Updated preferred keytype to {keytype}.")

def setGenPasskeyOption(settings):
    passkeyOption = input("\nEnable auto passphrase generation for your SSH keys? When keys are generated, the passphrase will be provided to you. (Y/N): ")
    if passkeyOption.lower() == "y":
        settings["GEN_PASSPHRASE"] = True
        save_settings(settings)
        print(f"\nPassphrases will be automatically generated.\n")

    elif passkeyOption.lower() == "n":
        settings["GEN_PASSPHRASE"] = False
        save_settings(settings)
        print(f"\nPassphrases must now be manually entered.\n")

def setKeyPath(settings, env=""):
    if env=="": env = getEnvironment(settings)
    keypath = input(f"\nDefine a path to save your {env.upper()} SSH keys: ")
    settings["keypaths"][env] = keypath
    save_settings(settings)
    print(f"Updated {env.upper()} keypath to {keypath}.")

def setDebugMode(settings):

    if settings["debug_mode"] == True:
        settings["debug_mode"] = False
    else:
        settings["debug_mode"] = True
    save_settings(settings)
    debug_mode = settings["debug_mode"]
    print(f"\nUpdated debug mode to {debug_mode}.\n")

def changeSettings(settings):
    menu = {1: "Change Username", 2: "Change Generate Passphrase Option", 3: "Change Key Paths", 4: "Reset all settings", 5: "Set preferred keytype", 6: "Change debug mode", 7: "Exit Settings"}
    menu_items = list(menu.keys())
    option = ""

    while option != 7:

        print("\nSettings Menu:\n")
        for key, value in menu.items():
            print(f"{key}) {value}")
        print("")

        option = int(input("Please enter the menu number to change a setting: "))
        while option not in menu_items:
            option = input("Invalid entry. Please enter the NUMBER of the setting you wish to change: ")

        if option == 1: setUsername(settings, False, settings["username"])
        elif option == 2: setGenPasskeyOption(settings)
        elif option == 3: changeKeyPath(settings)
        elif option == 4: resetSettings()
        elif option == 5: setPreferredKey(settings)
        elif option == 6: setDebugMode(settings)
    print("Exiting Settings. Rerun script to generate keys.")
    sys.exit()

def resetSettings():
    if os.path.exists(SETTINGS_FILE):
        os.remove(SETTINGS_FILE)
        print(f"{SETTINGS_FILE} has been deleted.")
        sys.exit()
    else:
        print(f"{SETTINGS_FILE} does not exist.")

def MacKeypath(opsys, env):

    if opsys == "Mac":
        dev_keypath = os.path.expanduser("~/.ssh/PSM_DEV")
        qa_keypath = os.path.expanduser("~/.ssh/PSM_QA")
        prod_keypath = os.path.expanduser("~/.ssh/PSM_PRD")

def genPassphrase(length=15):
    alphabet = string.ascii_letters + string.digits
    password = ''.join(secrets.choice(alphabet) for _ in range(length))
    while validatePassphrase(password) == False:
        alphabet = string.ascii_letters + string.digits
        password = ''.join(secrets.choice(alphabet) for _ in range(length))
    return password

def load_settings():
    """Load settings from the JSON file."""
    try:
        with open(SETTINGS_FILE, "r") as f:
            settings = json.load(f)
    except FileNotFoundError:
        operating_system = detectOS()
        # If the settings file does not exist, initialize with default settings
        settings = {
            "key_downloads": {
                "dev": "",
                "qa": "",
                "prod": ""
            },
            "username": "",
            "GEN_PASSPHRASE": "",
            "keypaths": {
                "dev": "",
                "qa" : "",
                "prod": ""
            },
            "preferred_keytype": "",
            "OS": operating_system,
            "debug_mode": False
        }
        save_settings(settings)  # Save the initial settings to create the file
    return settings

def save_settings(settings):
    """Save settings to the JSON file."""
    with open(SETTINGS_FILE, "w") as f:
        json.dump(settings, f, indent=4)

def checkKeyValidity(settings, env):
    """Check if the keys for a specified environment are still valid."""
    last_download = settings["key_downloads"].get(env, "")

    if last_download:
        elapsed = (datetime.now() - datetime.strptime(last_download, "%Y-%m-%d %H:%M:%S")).total_seconds() / 60
        if elapsed < 55:
            valid_remaining = int(60-elapsed)
            return input(f"{env} Keys are still valid for {valid_remaining} minutes. Continue anyway? (Y/N): ").strip().lower() != "y"
        else:
            print(f"{env} key downloaded {int(elapsed)} minutes ago. Fetching new keys.")
    return False

def update_key_download(settings, env):

    """Update the last download time for a specific environment."""
    if env in settings["key_downloads"]:
        settings["key_downloads"][env] = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        save_settings(settings)
        #print(f"Updated {env.upper()} key download time to {datetime.now()}.")
    else:
        print(f"Environment '{env}' not found in settings.")

def checkPaths(settings):
    paths = {"dev": settings["keypaths"]["dev"], "qa": settings["keypaths"]["qa"], "prod": settings["keypaths"]["prod"]}
    for env, path in paths.items():
        if path == "":
            print(f"Please define a path to save your SSH keys before running this script.")
            return False
    return True

def getEnvironment(settings): # Retrieves environment selection from the user
    print("\nType 'settings' to adjust settings, or 'exit' to quit.\n")
    envSelection = input("Type Dev, QA, or Prod to download keys: ").lower()

    while envSelection not in ["dev", "qa", "prod", "settings", "exit"]:
        envSelection = input("Invalid input. Please select an enviorment (DEV/QA/PROD): ").lower()

    if envSelection == "settings":
        changeSettings(settings)

    if envSelection == "exit":
        print("Exiting...")
        sys.exit()

    return envSelection

def getCredentials(settings): # Receives username, password, PingID code, and key passphrase from the user

    if settings["username"] != "":
        username = settings["username"]
    else:
        username = input("Please enter your User ID: ")
        save_user = input("Would you like your username to be saved for future reference? (Y/N): ")
        if save_user.lower() == "y":
            setUsername(settings, True, username)
            print(f"Saving {username} for future reference.")

    one_time_pass = getpass.getpass("6-Digit PingID One Time Passcode: ")

    return username, one_time_pass

def retrievePassphraseOption(settings):
    if settings["GEN_PASSPHRASE"] == True:
        key_passphrase = genPassphrase()
    else:
        key_passphrase = setPassphrase()

    return key_passphrase

def getPassword(settings):
    username = settings["username"]
    password = getpass.getpass(f"Password for {username} (Hidden): ")
    return password

def validatePassphrase(key_passphrase): # validates that the provided key passphrase meets PVWA requirements
    if len(key_passphrase) >=8 and re.search(r"\d", key_passphrase) and re.search(r"[A-Z]", key_passphrase) and re.search(r"[a-z]", key_passphrase):
        return True
    else:
        return False

def clear_old_keys(directory): # deletes old keys from the specified keypath

    filenames = ["key.pem", "key.ppk", "key.openssh"]

    for file in filenames:
        file_path = os.path.join(directory, file)
        if os.path.exists(file_path):
            os.remove(file_path)
            print(f"Deleted {file_path}")

def getKeys(settings, input_username, input_password, input_otp, input_keypass, url, env): # parses through HTML to retrieve MFA SSH keys using variables provided by user

    download_path = settings["keypaths"][env]
    preferred_keytype = settings["preferred_keytype"]

    chrome_options = Options()
    chrome_options.add_argument("--disable-extensions")  # Ensure no extensions are loaded
    chrome_options.add_argument("--log-level=3")  # Reduces logging (3=ERROR)
    chrome_options.add_argument("--disable-gpu")  # Optional, may reduce errors in some cases
    chrome_options.add_argument("--disable-logging")  # Disables logging
    chrome_options.add_argument("--no-sandbox")  # Required for certain environments
    chrome_options.add_argument("--disable-dev-shm-usage")  # Reduces memory usage
    chrome_options.add_experimental_option("prefs", {
    "download.default_directory": settings["keypaths"][env],  # Set your custom download path
    "download.prompt_for_download": False,        # Disable the download prompt
    "download.directory_upgrade": True,           # Auto-update the directory if it doesn't exist
    "safebrowsing.enabled": True                  # Enable safe browsing
    })
    if settings["debug_mode"] == False:
        chrome_options.add_argument("--headless") # Hide the Window

    print("Initializing...")
    driver = webdriver.Chrome(options=chrome_options)
    driver.get(url)
    driver.delete_all_cookies()
    print("Initialized PVWA.")


    try:
        # clicking "continue" for authentication

        continue_button = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.ID, "continue-button"))
        )
        continue_button.click()

        # entering username

        username = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.ID, "username"))
        )
        username.send_keys(input_username)

        password = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.ID, "password"))
        )
        password.send_keys(input_password)

        signOn = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.ID, "signOnButton"))
        )
        signOn.click()

        print("Entering PingID One Time Passcode ...")

        otp = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.ID, "otp"))
        )
        otp.send_keys(input_otp)

        submitOTP = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.CLASS_NAME, "primary"))
        )
        submitOTP.click()

        # Switching to iframe
        iframe = WebDriverWait(driver, 60).until(
        EC.presence_of_element_located((By.ID, "frame-psmssh"))
        )

        driver.switch_to.frame(iframe)

        key = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.CLASS_NAME, "pass-input"))
        )
        key.send_keys(input_keypass)

        print("Generating keys ...")

        generate_button = WebDriverWait(driver, 60).until(
        EC.element_to_be_clickable((By.XPATH, "//button[contains(@class, 'cyb-btn mfa-btn secondary-btn') and text()='Generate']"))
        )
        generate_button.click()

        openssh_download_icon = WebDriverWait(driver, 120).until(
        EC.element_to_be_clickable((By.XPATH, "//p[text()='OpenSSH private key']/following-sibling::p//i[contains(@class, 'ic-download')]"))
        )
        openssh_download_icon.click()  # Click the download icon

        ppk_download_icon = WebDriverWait(driver, 120).until(
        EC.element_to_be_clickable((By.XPATH, "//p[text()='PPK private key']/following-sibling::p//i[contains(@class, 'ic-download')]"))
        )
        ppk_download_icon.click()  # Click the download icon

        openssh_download_icon = WebDriverWait(driver, 120).until(
        EC.element_to_be_clickable((By.XPATH, "//p[text()='PEM private key']/following-sibling::p//i[contains(@class, 'ic-download')]"))
        )
        openssh_download_icon.click()  # Click the download icon

        time.sleep(2)
        driver.quit()
        print(f"Done. Downloaded OpenSSH, PPK, and PEM keys to {download_path}")
        if preferred_keytype != "": print(f"Preferred Keypath ({preferred_keytype}): {download_path}\key.{preferred_keytype}")
        if settings["GEN_PASSPHRASE"] == True:
            print(f"\nRandom key passphrase: {input_keypass}\n")
            print("To disable auto passphrase generation, please type 'settings'.")

        update_key_download(settings, env)
        grantWriteMac(settings, download_path)

    except TimeoutException:
        print("A timeout occurred. Please check your credentials and connection and try again.")
    except NoSuchElementException:
        print("Could not find one of the required elements. The webpage may have changed.")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")

def getKeyPath(settings, env):
    urls = {"dev": DEV_PSM, "qa": QA_PSM, "prod": PRD_PSM}
    return urls.get(env), settings["keypaths"][env]

def main(): # runs functions

    if firstRun() == True:
        settings = load_settings()
        setup(settings)
    settings = load_settings()
    password = getPassword(settings)
    keypass = retrievePassphraseOption(settings)

    while True:

        envSelection = getEnvironment(settings)
        username, Ping = getCredentials(settings)

        if checkKeyValidity(settings, envSelection) == False:
            url, keypath = getKeyPath(settings, envSelection)
            clear_old_keys(keypath)
            getKeys(settings, username, password, Ping, keypass, url, envSelection)

        elif checkKeyValidity(settings, envSelection) == True:
            print("Keys are already valid.")

main()
