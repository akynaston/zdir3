# Built-in Ant Properties » ghidinelli.com [www.ghidinelli.com]

 <http://www.motorsportreg.com/>
 <http://www.saferacer.com/>
 <http://haagperformance.com/>

##### [Orange is my favorite color](http://www.ghidinelli.com/)

April 1, 2008

# [Built-in Ant Properties](http://www.ghidinelli.com/2008/04/01/built-in-ant-properties)

## 

[Web/Internet](http://www.ghidinelli.com/c/webinternet) | [Trackback](http://www.ghidinelli.com/2008/04/01/built-in-ant-properties/trackback) | [del.icio.us](http://del.icio.us/post?url=http://www.ghidinelli.com/2008/04/01/built-in-ant-properties&title=Built-in%20Ant%20Properties) | [digg](http://digg.com/submit?phase=2&url=http://www.ghidinelli.com/2008/04/01/built-in-ant-properties)

I couldn’t find this easily with TEH GOOGLE so I present to you here, a complete list of the built-in properties that you can access using [Ant](http://ant.apache.org/). If you don’t know what Ant is and you’re a developer, then you probably don’t use deployment scripts and should be whipped. Check out Jim Priest’s [Ant Wiki](http://www.thecrumb.com/wiki/Ant) for a boatload of information and helpful links.

You need do nothing else other than wrap these values in with a ${} inside of a build file to use their values. They are a combination of built-in Ant properties and all of System.getProperties():

`basedir the absolute path of the project's basedir (as set with the basedir attribute of <project>). ant.file the absolute path of the buildfile. ant.version the version of Ant ant.project.name the name of the project that is currently executing; it is set in the name attribute of <project>. ant.java.version the JVM version Ant detected; currently it can hold the values "1.2", "1.3", "1.4" and "1.5". ant.home home directory of Ant java.version JRE version java.vendor JRE vendor java.vendor.url Java vendor URL java.home Java installation directory java.vm.specification.version JVM specification version java.vm.specification.vendor JVM specification vendor java.vm.specification.name JVM specification name java.vm.version JVM implementation version java.vm.vendor JVM implementation vendor java.vm.name JVM implementation name java.specification.version JRE specification version java.specification.vendor JRE specification vendor java.specification.name JRE specification name java.class.version Java class format version number java.class.path Java class path java.ext.dirs Path of extension directory or directories os.name Operating system name os.arch Operating system architecture os.version Operating system version file.separator File separator ("/" on UNIX) path.separator Path separator (":" on UNIX) line.separator Line separator ("\n" on UNIX) user.name User's account name user.home User's home directory user.dir User's current working directory`

If you want to test these, just use echo:

`<echo>OS: ${os.arch}</echo> <echo>VM: ${java.vm.name}</echo> <echo>Username: ${user.name}</echo>`

Finally, you can also get at your environment variables for your system by using the following syntax:

`<property environment="env"/>`

`<echo>Hostname: ${env.COMPUTERNAME}</echo> <echo>Path: ${env.Path}</echo>`

Note that the environment variables are case-sensitive even if your OS is not (e.g., Windows). So for Windows, the variable is env.Path but on Unix (I believe) it would be env.PATH. env.PATH at any rate doesn’t work on Windows so watch your case!

## 1 Comment

1. ### [engtech](http://internetducttape.com/) said:
	
	on April 4, 2008 at [7:26 am](http://www.ghidinelli.com/2008/04/01/built-in-ant-properties#comment-45824)
	
	Try rake.
	
	It’s the best build tool I’ve tried so far. So simple. So powerful.
	

{ [RSS feed for comments on this post](http://www.ghidinelli.com/2008/04/01/built-in-ant-properties/feed)}

	

* [![[./_resources/Built-in_Ant_Properties_»_ghidinelli.com_www.ghidinelli.com.resources/181921411870879.png]]](https://www.facebook.com/pages/Brian-Ghidinelli/181921411870879)

* [![[./_resources/Built-in_Ant_Properties_»_ghidinelli.com_www.ghidinelli.com.resources/resource.png]]](http://twitter.com/ghidinelli)
	
* [Or, on Google+](https://plus.google.com/115341623579254182666)

* [Selectively applying Hubspot (or other) tracking code](http://www.ghidinelli.com/2014/01/27/selectively-applying-hubspot-tracking-code)

* [CFPAYMENT now on GitHub](http://www.ghidinelli.com/2013/06/05/cfpayment-now-on-github)
* [Turbo Stack Traces for Tough Debugging](http://www.ghidinelli.com/2013/04/02/turbo-stack-traces-for-tough-debugging)
* [jQuery TableSorter finds new life](http://www.ghidinelli.com/2013/03/30/jquery-tablesorter-finds-new-life)
* [Faster unit tests with ColdSpring and MXUnit](http://www.ghidinelli.com/2013/03/27/faster-unit-tests-with-coldspring-and-mxunit)
* [Happy New Year](http://www.ghidinelli.com/2012/12/31/happy-new-year)
	
	* [January](http://www.ghidinelli.com/2014/01) (1)
	
	* [June](http://www.ghidinelli.com/2013/06) (1)
	* [May](http://www.ghidinelli.com/2013/05) (1)
	* [April](http://www.ghidinelli.com/2013/04) (1)
	* [March](http://www.ghidinelli.com/2013/03) (2)
	
	* [December](http://www.ghidinelli.com/2012/12) (2)
	* [November](http://www.ghidinelli.com/2012/11) (1)
	* [September](http://www.ghidinelli.com/2012/09) (1)
	* [August](http://www.ghidinelli.com/2012/08) (1)
	* [July](http://www.ghidinelli.com/2012/07) (1)
	* [April](http://www.ghidinelli.com/2012/04) (1)
	* [March](http://www.ghidinelli.com/2012/03) (3)
	* [January](http://www.ghidinelli.com/2012/01) (1)
	
	* [December](http://www.ghidinelli.com/2011/12) (5)
	* [November](http://www.ghidinelli.com/2011/11) (1)
	* [October](http://www.ghidinelli.com/2011/10) (3)
	* [September](http://www.ghidinelli.com/2011/09) (1)
	* [August](http://www.ghidinelli.com/2011/08) (3)
	* [June](http://www.ghidinelli.com/2011/06) (1)
	* [May](http://www.ghidinelli.com/2011/05) (2)
	* [February](http://www.ghidinelli.com/2011/02) (3)
	* [January](http://www.ghidinelli.com/2011/01) (3)
	
	* [December](http://www.ghidinelli.com/2010/12) (1)
	* [November](http://www.ghidinelli.com/2010/11) (2)
	
	* [Business](http://www.ghidinelli.com/c/business)
	* [Complaint Dept.](http://www.ghidinelli.com/c/complaint-dept)
	* [Food](http://www.ghidinelli.com/c/food)
	* [Italian Citizenship](http://www.ghidinelli.com/c/italian-citizenship)
	* [My Software](http://www.ghidinelli.com/c/software)
	* [Racing](http://www.ghidinelli.com/c/racing)
	* [Research/HOWTO](http://www.ghidinelli.com/c/research)
	* [Uncategorized](http://www.ghidinelli.com/c/uncategorized)
		* [ColdFusion](http://www.ghidinelli.com/c/webinternet/coldfusion)
		* [Dojo Toolkit](http://www.ghidinelli.com/c/webinternet/dojo-toolkit)
		* [jQuery](http://www.ghidinelli.com/c/webinternet/jquery)
		* [Linux](http://www.ghidinelli.com/c/webinternet/linux)
		* [PostgreSQL](http://www.ghidinelli.com/c/webinternet/postgresql)
		### Subscribe to Posts
	
	<http://feeds.feedburner.com/OrangeIsMyFavoriteColor>
	
	[![[./_resources/Built-in_Ant_Properties_»_ghidinelli.com_www.ghidinelli.com.resources/feed-icon16x16.png]]](http://feeds.feedburner.com/OrangeIsMyFavoriteColor)
	[All Categories from Feedburner](http://feeds.feedburner.com/OrangeIsMyFavoriteColor)
	
	<http://feeds.feedburner.com/OrangeIsMyFavoriteColorTech>
	
	[![[./_resources/Built-in_Ant_Properties_»_ghidinelli.com_www.ghidinelli.com.resources/feed-icon16x16.png]]](http://feeds.feedburner.com/OrangeIsMyFavoriteColorTech)
	["Tech" Only Categories](http://feeds.feedburner.com/OrangeIsMyFavoriteColorTech)
	
		### Subscribe via Email
	
	Enter your email address:
	
	All Categories
	"Tech" Categories Only
	

© powered by pollo asado, carne asada y carnitas, 1976-2014
