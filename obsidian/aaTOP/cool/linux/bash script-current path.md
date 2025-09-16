4/30/2024 10:06:13 AM

Get the current executing script's directory: https://saturncloud.io/blog/how-to-get-the-directory-where-a-bash-script-is-located/#:~:text=The%20first%20method%20to%20get,directory%20name%20from%20the%20path.
SCRIPT_DIR="( cd "( dirname "${BASH_SOURCE0}" )" &> /dev/null && pwd )"

