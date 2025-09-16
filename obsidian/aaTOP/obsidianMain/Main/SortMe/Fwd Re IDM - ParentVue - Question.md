# Fwd: Re: IDM - ParentVue - Question

\>>> Glen Knutti 2/4/2014 3:10 PM >>>

Great notes, Jer and thanks for the heads up. They are on Windows for the User App now so the switch to Linux would make them think twice.

Thanks,

Glen
\>>> Jeremiah Seaver 2/4/2014 1:16 PM >>>
Glen,
Just a few notes on IDM Home that we'll need to keep in mind if they are interested in it:
\- IDM Home requires IDM 4.0.2 with patch 3 or later.
\- It requires RBPM 4.0.2 with Field Patch D.
\- The Java for the RBPM needs to be upgraded to version 7.
\- The docs say that all the other drivers need to be 4.0.2 drivers with latest patches.
\- The User Application must be running on SLES 11 SP3 or SP4 (Or Red Hat).
My understanding is that FCPS is running IDM 4.0.1 and the User App is on Windows. I think they also have a customized WAR file, so that would need to be taken into account when upgrading and installing IDM Home.
There's no reason why we shouldn't be able to use IDM Home, but there is a significant amount of prep work before it can be installed.
Jeremiah Seaver
TriVir LLC
801-877-0479
801-319-6947
\>>> Glen Knutti 2/4/2014 9:59 AM >>>
Brunda,
We could host those pages on the User App server and to handle the load, we can cluster two or more User App servers.
Additionally, if we go with option D, there's a new User App skin referred to as IDM Home that is free to FCPS and provides more out of the box flexibility that the old User App web interface. The IDM Home feature runs as another .war file on the User App server so it doesn't require additional hardware.
If we can get some estimated load numbers for parent registration, we can figure out whether we would want to cluster two or three User App servers to make sure there's no problems.
Thanks,
Glen
\>>> "Arepalli, Brunda" <[BArepalli@fcps.edu](mailto:BArepalli@fcps.edu)\> 2/4/2014 11:48 AM >>>
Glen,
 
If we were to go with option D, which is Trivir developing the Parent Registration pages what is the plan to host those web pages?  Is it going to be on the UserApp Server?  
 
If so how are we going to load balance the traffic during the week when schools starts?  (New teachers, old teachers trying to change their passwords and parent registration.)
 
Brunda
 
_**Brunda Arepalli**_
_Domain Architect_
_Business Systems, EISA, IT
_Wilton Woods Center
Fairfax County Public Schools
703 329 7451
[_barepalli@fcps.edu_](mailto:barepalli@fcps.edu)
