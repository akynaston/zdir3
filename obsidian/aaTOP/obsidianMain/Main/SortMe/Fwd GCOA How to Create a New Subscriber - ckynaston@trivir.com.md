# Fwd: [GCOA] How to Create a New Subscriber - ckynaston@trivir.com

\>>> Carl Kynaston <carlkynaston@gmail.com> 2/6/2014 11:07 AM >>>

|     |
| --- |
| I don't care if you use this. I just want to make sure the users look just like they do in Produciton. :)<br>Carl |
|     |
| # \[GCOA\] How to Create a New Subscriber - ckynaston@trivir.com |

The following document explains how to create a subscriber in the iManager.
It is recommended to review this document in its entirety before doing the steps.

Create a new user in the o=external container.

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.7.png]]

User is successfully created.
![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.1.png]]

Click on Roles and Tasks and choose Linux User Management -> Enable Users for Linux.
Select the user(s) that you are enabling for Linux and click Next.

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.2.png]]

Select the subscribers group.
Click Next.

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.5.png]]

Leave the defaults on the last screen.

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.8.png]]

Next, update the users Linux Home Directory to have the correct path.
Click on View Objects. 
Navigate to the user we created.
Edit the user.
Choose the Linux Profile tab.
If the user was successfully enabled we will see the user's Linux information here.
Change the Home Directory to have the correct FULL path of the directory in Linux.

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.4.png]]

Now open a Putty session to the ftp server and create the subscriber directory.

For Example: mkdir /mnt/subscribers/subscribertest2

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.9.png]] 

Change the ownership of the directory to give the user the correct rights:
For Example: chown subscribertest2 /mnt/subscribers/subscribertest2

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.6.png]]

Create a test file in the user's home directory to validate the server uses the correct home path for this user.
In this example I used the touch command to just make an empty file.

touch /mnt/subscribers/subscribertest2/testFileInSubscribertest2Dir.txt

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.3.png]]

Next use the curl command to do a quick test login to the ftp service as that user. 
If everything is configured correctly, the result of this command will display our test file.

curl -v --ftp-ssl -k -u <REPLACE\_WITH\_USERNAME>:<REPLACE\_WITH\_USER\_PASSWORD> [ftp://10.0.6.89](ftp://10.0.6.89/)

Validate that the test file that was created is displayed here. 
The following image shows that the file was successfully viewed over FTP.
Once testing is complete, the test file can be removed.

![[./_resources/Fwd_GCOA_How_to_Create_a_New_Subscriber_-_ckynaston@trivir.com.resources/unknown_filename.png]]

Next create the user in the docket application.
Remember when specifying the home directory only put the directory name with no slashes. 
For our example user it would just be "subscribertest2".

You are done!

For testing end to end, I recommend the following:
 - Create and configure the user in iManager on Production and Test.
 - Create and configure the user in the application in Production. 
(We can just copy the subscriber in the application to the test database 
instead of making him in the Test application. Or just create him in test.)

Evernote helps you remember everything and get organized effortlessly. [Download Evernote](https://www.evernote.com/getit?email_name=emailNote&email_guid=f67efe87-0cd5-4dc8-9422-829dc3a03e87&email_link=download_app).
