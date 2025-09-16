When back:
   - Need to avoid creating on both drivers untilw e ahve at least one role.



C:\work\trivir\custom-login-spa-tests>git lg -SSpicyp0rk
* 704f6f8 - (3 days ago) Switched Credentials to local gitignored file - Jake Hornback (HEAD -> feature/dusp_tests, tag: gold, origin/feature/dusp_tests)
...
* 24030ee - (5 days ago) pulled constants into properties files and updated environment file accordingly, moved login check into its own function, updated tests for DriverUtils updates, removed TODO, updated elements - Jake Hornback
...
* | | e81fafe - (13 days ago) Added new tests for DUSP pages. Also added form doc to handle elements for those tests - Jake Hornback
|/ /

C:\work\trivir\custom-login-spa-tests>




pick 5149422 Add tests for OATH back button
pick e7a8610 fix: Handle OATH pages correctly in Verosint tests
pick ccd4035 Update OATH tests to check for validation errors
e e81fafe Added new tests for DUSP pages. Also added form doc to handle elements for those tests
pick 7e8d1b9 Better check to see if the user is logged in.
pick 53baeb8 Fixed extra blank spaces, removed unused import
pick 89a0497 Added new create user to LdapUtils for forced reset, created forced reset tests, added element for skip button
pick 501c755 Added setting feature flag, Used create clean user for better user management
pick d8fbd3b Fix retry when fetching OTP sent to email
pick 5308b0b Refactor to reuse chrome and firefox drivers in multiple classes
pick 54bbbf1 Define the browsers to be used in running tests in DriverUtils
pick 27ebd5b Add contact management tests
pick c6b9aab Fix Typo
e 24030ee pulled constants into properties files and updated environment file accordingly, moved login check into its own function, updated tests for DriverUtils updates, removed TODO, updated elements
pick 73f02c7 fixed checkstyle error
e 704f6f8 Switched Credentials to local gitignored file

