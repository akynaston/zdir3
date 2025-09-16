11/5/2024 3:54:17 PM
Wrote this, getting permission to share; will send at 5 pm today regardless . . 



sent this: 11/5/2024 4:57:43 PM
Team,
 
If you use Gitlab, and have 1 or more cloned repos from https://gitlab-tools.swacorp.com/, read on!  We are having our repos migrated to a 'Gitlab Dedicated' instance, meaning SWA will no longer host our own Gitlab server(s).
 
Do now: Please read and familiarize yourself with these instructions: https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/410298396/How+to+Migrate+repos+to+to+Gitlab+Dedicated+SAAS
 
Up to and including end-of-business on November 12: Push all of your data as shown in the instructions.
Starting on November 13: Assuming the Gitlab team finishes the migration, update your repos as described in the instructions. 
 
Please let me know if you have any questions.





11/5/2024 3:55:34 PM
My page lazily copied here:

[  
Cybersecurity](https://southwest.atlassian.net/wiki/spaces/CYSEC/overview?homepageId=74547454)

/

/

[Aaron's Notes](https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/360426549/Aaron+s+Notes)


[How to Migrate repos to to Gitlab Dedicated SAAS](https://southwest.atlassian.net/wiki/spaces/CYSEC/pages/410298396/How+to+Migrate+repos+to+to+Gitlab+Dedicated+SAAS#)



# How to Migrate repos to to Gitlab Dedicated SAAS

- ![](https://southwest.atlassian.net/wiki/aa-avatar/712020:42a564de-7116-4fb9-83b1-7854dca5fb9a)
    

Owned by [Aaron Kynaston](https://southwest.atlassian.net/wiki/people/712020:42a564de-7116-4fb9-83b1-7854dca5fb9a?ref=confluence&src=profilecard), created with a template

Last updated: [just a moment ago](https://southwest.atlassian.net/wiki/pages/diffpagesbyversion.action?pageId=410298396&selectedPageVersions=4&selectedPageVersions=5)

3 min read

Analytics[![Initializing...](https://doc-m.comalatech.app/images/byline/workflows.svg "Initializing...")Add Workflow](https://southwest.atlassian.net/wiki/plugins/servlet/ac/com.comalatech.workflow/workflow/overview/%7Bspace.key%7D/%7Bcontent.id%7D?contentType={content.type}&contentVersion={content.version}&darkDebug={condition.feature_flag(featureKey=cwc.debug)}&page.id=410298396&space.key=CYSEC&content.id=410298396&content.version=1&page.type=page&page.title=How%20to%20Migrate%20repos%20to%20to%20Gitlab%20Dedicated%20SAAS&space.id=74554110&content.type=page&user.isExternalCollaborator=false&page.version=1)

On the evening of November 12 our csiam group of repositories is scheduled to migrate to a new Gitlab instance referred to as ‘GitLab Dedicated’ hosted area here: [https://southwest.gitlab-dedicated.com/](https://southwest.gitlab-dedicated.com/ "https://southwest.gitlab-dedicated.com/"). If you have any repositories cloned from our on prem instance of gitlab here: [https://gitlab-tools.swacorp.com/](https://gitlab-tools.swacorp.com/groups/csiam "https://gitlab-tools.swacorp.com/groups/csiam"), you will need to take these steps to connect your clones to the new instance.

**NOTE: If you ensure all of your commits, branches and tags are pushed up end-of-business on November 12th, either option below will work for you.**

1. Start by creating new SSH keys and upload your public key as described here: [![](https://docs.gitlab.com/favicon.ico?v=2)Use SSH keys to communicate with GitLab | GitLab](https://docs.gitlab.com/ee/user/ssh.html)
    
    1. Note: The new ED25519 key they recommend works great.
        
    2. Upload your new public key here: [https://southwest.gitlab-dedicated.com/-/user_settings/ssh_keys](https://southwest.gitlab-dedicated.com/-/user_settings/ssh_keys "https://southwest.gitlab-dedicated.com/-/user_settings/ssh_keys").
        
    3. Be mindful of the expiration for your keys: ideally, all of our credentials of all sorts rotate on a yearly basis.
        
    4. See ‘Example Key Generation’ below for an example.
        
2. Update your current repo clones to point to the new URL and confirm it is connected properly.
    
    1. For each of your repositories, **you have two options to get them to point to the new remote.**
        
        1. Option A: Push all, delete and re-clone.
            
        2. Option B: Push all, then remove ‘origin’, and add it back with the correct URL.
            

## **Activities Up to and including end-of-business on November 12:**

## **Push All Data**

For either option, pushing all of your data that needs to be pushed is wise: Confirm that all of your items are pushed using ‘git branch -avv’:

In this example, CSEE-4192 has ‘ahead 1’ meaning one commit has not been pushed. the CSEE-0000-NOT-PUSHED branch is not pushed or ‘connected’ to the remote at all:

Open {DFAC3759-620E-490B-9D56-55C19A6B527B}-20241105-223243.png

![](blob:https://southwest.atlassian.net/da1b79f9-5921-4453-9de2-aa1b1087db99#media-blob-url=true&id=8ea7ff2e-a88e-4d80-a4ba-7604c5b0f587&collection=contentId-410298396&contextId=410298396&mimeType=image%2Fpng&name=%7BDFAC3759-620E-490B-9D56-55C19A6B527B%7D-20241105-223243.png&size=48723&width=1038&height=186&alt=)

Ensure all of your branches that need to be on the remote have the corresponding origin/[branch name], similar to master above.

## **Activities on November 13 After Successful Migration:**

The ‘GitLab Dedicated’ team has let us know they intend to tell us when the migration is starting, and when they will complete. Once they complete, they should let us all know that the migration has been completed. When that is done, you can use either option for each of the repos you have:

Note: that as of 2024-11-05 the /csiam folder does not exist; so there won’t be anything to clone; though we should see the new repos appear around November 13.

## **Option A: Delete, and re-clone**

This option is the lowest amount of typing, but does mean that data loss is possible if you have any branches that are not pushed. See the git branch -avv call above for an example.

- Locate the clone you want to work on.
    
- After confirming you have pushed everything in the remote, delete/archive/move the repo.
    
- Go to the new URL: [https://southwest.gitlab-dedicated.com/](https://southwest.gitlab-dedicated.com/explore/groups?filter=csiam "https://southwest.gitlab-dedicated.com/explore/groups?filter=csiam"), locate your repo, and re-clone as always: the interface is very similar.
    
    - Please note:
        

## **Option B: Update your remote reference**

This option is my favorite as it leaves all of your clones intact, and requires a minor update to the remote.

- First, confirm your repo is still pointing to the old reference using ‘git remote -v’
    
- ![](blob:https://southwest.atlassian.net/6c0f2c45-c6e1-4fda-9152-17ad08b884c6)
    
- Next, Remove the old reference by typing:
    
    - git remote remove origin
        
- Then confirm it is gone by typing ‘git remote -v’ again.
    
- Get the URL of the repo from the ‘clone’ link in the new [https://southwest.gitlab-dedicated.com/](https://southwest.gitlab-dedicated.com/explore/groups?filter=csiam "https://southwest.gitlab-dedicated.com/explore/groups?filter=csiam") location, likely under a /csiam folder. (TBD on the location)
    
- When that is completed, type: git remote add origin [URL of the new repo]
    
- Then type ‘git fetch -v’
    
- Assuming everything is working properly, you should see something similar to this:
    
- ![](blob:https://southwest.atlassian.net/e411c72c-d62a-4467-b0f4-5b518c109614)
    

**Example key generation:**

C:\Users>ssh-keygen -t ed25519 -C "x266698@SY4-HW2XSQ3"  
Generating public/private ed25519 key pair.  
Enter file in which to save the key (C:\Users\x266698/.ssh/id_ed25519):  
Enter passphrase (empty for no passphrase):  
Enter same passphrase again:  
Your identification has been saved in C:\Users\x266698/.ssh/id_ed25519  
Your public key has been saved in C:\Users\x266698/.ssh/id_ed25519.pub  
The key fingerprint is:  
SHA256:I2T/Xe7sHVumKjIlPZaqdSVPmzmg6BFZ/36Z8rSyU7s x266698@SY4-HW2XSQ3  
The key's randomart image is:  
+--[ED25519 256]--+  
| |  
| |  
| o . |  
| o + . |  
| + S.+.o . |  
| +.+*O *. |  
| o o=o.O.o=o|  
| . o+...+===+|  
| o. o .+XEo.|  
+----[SHA256]-----+

C:\Users>