# [FCPS] Grace Logins

We found the following behavior if the user had the following number of Grace Logins:
 - 0 Grace Logins - User gets a message "Your password has expired"
 - 1 Grace Login - User gets to the landing page. If user tries any password/challenge question change - they get SSPR Error 5071 - An error using OAuth authentication protocol has occured. Please try again later.
 - 2 Grace Login - User instantly gets: SSPR Error 5071 - An error using OAuth authentication protocol has occured. Please try again later.
 - 3+ Grace Logins - Works as anticipated.

* * *

Team,

We can talk about this at some point, but I wanted to get this conversation started now. 

In IDM Home 4.5 (Specifically the SSPR component), Grace Logins are handled differently:
 - Each time a user with an expired password logs into IDM Home, 3 Grace Logins are consumed.
 - We confirmed with Micro Focus this is working as designed.
 - This occurs because as the user gets logged in, the user authenticates to the different modules, each consuming additional Grace Logins.
 - It is important to note that when a user logs in with an expired password, **they are forced to either exit the application, or change their password right then**. Users cannot wait and just change their password later. (This is a change UserApp. UserApp did NOT force you to update your password right then).

We need to make the following changes in the system:
 - Grace Logins need to be increments of 3 since they will be consumed that way. (If users come in with 1 or 2 grace logins, problems happen).

 - We need to pick a new number of Grace Logins for Employees and Non-Employees.
 - When we update the password policy, we will also update all users who have < 3 Grace Logins in eDir to have the new amount of Grace Logins from the password policy. (This will be a one time task that we do on all staff when we update the password policies).

Right now we have these Grace Login numbers:
 - Employees: 8 Grace Logins.
 - Non-Employees 2 Grace Logins.

**Questions**
 - Should we change these to both be 9 Grace Logins? (This means users could login 3 times and click logout or close their browser before their account was unable to login any more).
 - Do users authenticate against anything else where grace logins might be consumed?

Thanks,

Carl
