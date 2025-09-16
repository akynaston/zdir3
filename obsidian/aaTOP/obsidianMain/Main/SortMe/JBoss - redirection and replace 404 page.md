# JBoss - redirection and replace 404 page

[Skip navigation](http://community.jboss.org/thread/#jive-body)

# [JBoss Community](http://www.jboss.org/)

* [Home](http://www.jboss.org/)

* [Members](http://community.jboss.org/people)
* [Projects](http://www.jboss.org/projects)
* [Products](http://www.jboss.com/products)

* [Login](https://community.jboss.org/login.jspa) |

* [Register](http://www.jboss.org/index.html?op=checkage&module=user) |
* [Cool Stuff](http://www.jboss.org/coolstuff)

## JBoss AS

* [Overview](http://www.jboss.org/jbossas)

* [Downloads](http://www.jboss.org/jbossas/downloads)
* [Documentation](http://www.jboss.org/jbossas/docs)
* [Community](http://community.jboss.org/en/jbossas)
* [Issue Tracker](https://jira.jboss.org/jira/browse/JBAS)
* 
* [Build](http://hudson.qa.jboss.com/hudson/view/JBoss AS/)

	
Welcome, Guest

Search for: Search

	[Community](http://community.jboss.org/index.jspa) > [JBoss AS](http://community.jboss.org/community/jbossas) > [Discussions](http://community.jboss.org/community/jbossas?view=discussions)
	
[Up to Discussions in JBoss AS](http://community.jboss.org/community/jbossas?view=discussions&start=0)

#### Related Issues

No Related Issues

#### Thread Actions

* [View full screen](http://community.jboss.org/thread/152621?decorator=print&displayFullThread=true)

* ShareThis

	

**2285 Views** **2 Replies** [Latest reply](http://community.jboss.org/message/545742?tstart=0#545742): Jun 2, 2010 1:37 AM by jboss q [![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.2.png]]](http://community.jboss.org/community/feeds/messages?thread=152621)

 [![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.png]]](http://community.jboss.org/people/nickwolf) ![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.4.gif]]
[nick wolf](http://community.jboss.org/people/nickwolf)
_17 posts since
Nov 27, 2009_

### Jun 1, 2010 10:11 AM

## [How to display status page when application is down?](http://community.jboss.org/message/545637#545637)

This question is **Not Answered.**

Hi fellas,

JBOSS 5.1.0 is displaying a blank page when my application is unavalable for some reason(lets i am redeploying in the background).

is there a way to display a static page telling users that "currently application is unavailable" when app is not available?

Thanks,

Nick

**Helpful Answer**by [jboss q](http://community.jboss.org/thread/#545742) 

	Like ([0](http://community.jboss.org/thread/#))
	

		 [![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.3.png]]](http://community.jboss.org/people/saltnlight5) ![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.1.gif]]
	[Zemian Deng](http://community.jboss.org/people/saltnlight5)
	_108 posts since
	Jan 14, 2010_
	
	[1.](http://community.jboss.org/message/545703#545703) Jun 1, 2010 4:57 PM ([in response to nick wolf](http://community.jboss.org/message/545637#545637))
	**[Re: How to display status page when application is down?](http://community.jboss.org/message/545703#545703)**
	
	I don't think this has nothing to do with JBoss serving blank pages. If your app is not available, how is JBoss going to know what to serve the request?
	
	To do what you want with a simple webapp setup, you can try is this:
	
	1\. Create an static html page in your ROOT.war/your-webapp-name/index.html
	
	2\. Deploy your webapp with same name as <your-webapp-name>.war
	
	With this, your default url access of <http://localhost/your-webapp-name> will load the static page at first, and as soon as your webapp is successfully loaded, it will overwrite that path.
	
		Like ([0](http://community.jboss.org/thread/#))
		
	
		 [![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.png]]](http://community.jboss.org/people/jbossq) ![[./_resources/JBoss_-_redirection_and_replace_404_page.resources/unknown_filename.4.gif]]
	[jboss q](http://community.jboss.org/people/jbossq)
	_34 posts since
	May 31, 2010_
	
	[2.](http://community.jboss.org/message/545742#545742) Jun 2, 2010 1:37 AM ([in response to nick wolf](http://community.jboss.org/message/545637#545637))
	**[****Helpful Answer****Re: How to display status page when application is down?](http://community.jboss.org/message/545742#545742)**
	
	to do so, edit web.xml in your server/xxx/deployers/jbossweb.deployer directory to add the following:
	
	<error-page>
	          <error-code>404</error-code>
	          <location>/myerror.html</location>
	</error-page>
	
	myerroy.html is the customized page you want to display when app is not available. (myerror.html need to be larger than 512 bytes , otherwise some browsers would not load your customized error page)
	
	then put the myerror.html to the root context app of your jboss instance, the default root context app is ROOT.war which is located in your server/xxx/deploy directory.
	
		Like ([0](http://community.jboss.org/thread/#))
		
	

[Go to original post](http://community.jboss.org/thread/#152621)

* [JBoss OSGi](http://www.jboss.org/jbossas/osgi)

* [Downloads](http://www.jboss.org/jbossas/downloads)
	
	* [JBoss AS6 Documentation](http://www.jboss.org/jbossas/docs/6-x)
	* [JBoss AS5 Documentation](http://www.jboss.org/jbossas/docs/5-x)
	* [Docs for Older Releases](http://www.jboss.org/jbossas/docs/Older-Releases)
	
	* [Wiki](http://community.jboss.org/en/jbossas)
	* [User Forum](http://community.jboss.org/en/jbossas?view=discussions)
	* [Developer Forum](http://community.jboss.org/en/jbossas/dev?view=discussions)
	* [Mailing Lists](https://lists.jboss.org/mailman/listinfo)
	* [Chat](http://community.jboss.org/thread/irc://irc.freenode.net#jboss)
* [Issue Tracker](https://jira.jboss.org/jira/browse/JBAS)
	* [Anonymous SVN](http://anonsvn.jboss.org/repos/jbossas/)
	* [Committer SVN](https://svn.jboss.org/repos/jbossas/)
	* [FishEye](http://fisheye.jboss.org/browse/JBossAS)
	* [ViewVC](http://viewvc.jboss.org/cgi-bin/viewvc.cgi/jbossas/)
* [Build](http://hudson.qa.jboss.com/hudson/view/JBoss AS/)

<http://www.redhat.com>

###### Red Hat, Inc.

[About Us](http://www.jboss.org/about.html) | [Contact Us](http://www.jboss.org/contact.html) | [Careers](http://www.redhat.com/about/careers) | [JBoss Enterprise](http://www.jboss.com/)

Powered by [Magnolia](http://www.magnolia-cms.com), [SBS](http://www.jivesoftware.com/poweredby/), [JBoss EAP](http://www.jboss.com/products/platforms/application), and [RHEL](http://www.redhat.com/rhel/).
