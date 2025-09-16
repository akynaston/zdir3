# Plante Moran CONF

Plante Moran CONF

* Introduce Machine
	* First thing i want to do, is quickly go through the software I installed on this machine.
		*  eDir 8.8 sp2
		*  iManager 2.7, sp2
		* Scite
			* It's a text editor with some more features, and handles bigger files better than notepad does - makes it a great candidate for reading log files.
		* JXplorer
			*  is a small LDAP utility; has a few more features than
		* Tortoise
			*  subversion client - subversion is a source code versioning system, our perferred client is Tortoise.
			* It is accessable as a windows explorer extension.
		* Build scripts
			* As we've worked with you on the wingspan driver, we've sent regular iterations - a build script makes that possible.
			* We won't go into too much detail
			* A buildscript allows us to create customer ready deliverables that are consistent in content and format, and are easily reproduceable this enables us to deliver a clean, clear cut binary that we deliver to you that already is configured for your environment as much as possible.
			* We use a build utility called ant to run this build script.
		* You have already installed Office on this server, I also installed open office as some of our source documents are in open office format.
		* WinSCP
			*  Simply allows me to copy between our company's FTP server - it's a very handy way to transfer files to and from remote servers.
		* ANT
			* Ant is an open source tool that allows for automating a build.
		* The IDMUnit engine
			* IDMUnit is an automated testing tool uses Java to enable testing of an IDM driver.
			* Before I talk more about IDMUnit, I need to describe the Designer environment.
		* Designer
			* Designer is a Novell application that allows updating of IDM drivers directly to a tree, restart drivers, and other things.
			* Designer was built as a series of plugins to a product called Eclipse. Eclipse is an open source  Integrated development envionrment or IDE. IN other words, Designer is essentially an installation of eclipse with plugins supporting the development of an IDM driver.
			* At TriVir, we use Designer regularly. Also, whenever we're doing anything with Designer, meaning we're working on IDM, we will always be using IDmUnit at the same time.
			* We have found that we can take an installtion of Designer, then add the necessary plugins fo Java - this allows us to use a single IDE, with both the features available in Designer, and IDMUnit within the same development environment.
			* (Show Designer.)
			*  (show designer pices)
			* (Add Java workspace) - briefly show files - we'll talk about the thests in just a minute.
* Dev env - show the basic structure of a designer project
	* Project Structure
		* show projects
	* I want to give an over view of the engineering side of our process - I'm focusing ONLY on the engineering side as it directly inclues automated testing - we will run through the engineering steps that i took on thsi project:
		* Recieve, and validate an Acceptacse critieria -
			* make usre I understand the reuqirements, and that the document properly describes the requirements for the wingspan driver, and at the same time gives me enogh information to implement.
		* Next stepis to write tests - starting with one test for each AC item.
			* (Show tests) -
				* IDMUnit tests consists of the test content, and a test runner.
				* Runner: .java file
				* content: excel spreadsheet.
					* we've chosen a spreadsheet as it seemed that customers already were using them to describe functionality, so most people were already very familiar with the concept; we figured we'd allow the spreadsheets to be used to drive automated tests.
		* Implement each of the AC items, and run the corresponding test to confirm that I've completed with that piece of functionality.
			* If the test succeeds, I can move on to the next AC item.  If it fails for any reason, I can quickly see where the bug is, fix the code, and re-run the test.  This cycle of of running tests, fixing code, and re-running tests allows us to arrive at a point that we call base line.  If I have 10 tests, and they all pass, we say that we're at a baseline at all 10 tests passing.
			* When we are at a baseline for all tests, we have a functoinally complete driver - The driver at this point covers all functoinality reqested in the AC.
		* This baselineing process is quite powerful, and has two directt benefits:
			* It allows me as the programmer to have the requirements of each AC item clearly in mind when I go to implement the code.
			* As I go through the tests, I'm not only gaining a clear, wholistic view of the requrments, but I have a set of documented requirements that I can execute as automated tests!
			* As we move forward, you will see that each of these automated tests allow me to dynamically ensure that my driver meets the AC.
			* If either you or I ever seen a bug some where, I need only to add a test, and re-run - you can see that time time spent on writing automated tests - after getting into the habit of having automated tests around, you find you never want to develop software any other way.
		* Once I'm at a base line, it's very natural process to document what I've done, then I have only to execute my build script and I almost instantly have a deliverable set of files that I can send you as an iteration.
	* For our demo today, I'd like to show you IDMUnit in action, and what I see as a developer when I'm running tests.
		* (show success test #1)
		* I'm going to insert a bug in the driver. (disable time conversion)
		* (show error) test
		* When i see this error, I can immediately begin working on resolving the issue - the Test just handed me a clear report documenting the excteded value, and the one actually received.
	* This is what we mean when we say we have Test driven development.
	* Michael, did you want to add more?
