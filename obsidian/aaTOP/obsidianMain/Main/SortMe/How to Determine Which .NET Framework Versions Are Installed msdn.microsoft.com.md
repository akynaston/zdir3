# How to: Determine Which .NET Framework Versions Are Installed [msdn.microsoft.com]

[Developer Network](http://msdn.microsoft.com/en-us)

[MSDN subscriptions](http://msdn.microsoft.com/dn369243)
[Get tools](http://go.microsoft.com/fwlink/?LinkId=309297&clcid=0x409&slcid=0x409)
[Sign in](https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=11&ct=1384368176&rver=6.0.5276.0&wp=MCLBI&wlcxt=MSDN%24MSDN%24MSDN&wreply=http%3a%2f%2fmsdn.microsoft.com%2fen-us%2flibrary%2fhh925568%2528v%3dvs.110%2529.aspx&lc=1033&id=254354&mkt=en-US)

* [Home](http://msdn.microsoft.com/dn308572)

* [Opportunity](http://msdn.microsoft.com/dn271881)
	
* [Platform](http://msdn.microsoft.com/dn271880)
* [Connect](http://msdn.microsoft.com/dn338064)
	
* [Downloads](http://msdn.microsoft.com/dn292944)
	
* [Library](http://msdn.microsoft.com/library)
* [Samples](http://code.msdn.microsoft.com/)

Join us

* <http://www.facebook.com/microsoftdeveloper>

* <https://twitter.com/msdev>
* <http://plus.google.com/111221966647232053570/>

[Export (0)](http://msdn.microsoft.com/en-us/library/export/help/?returnUrl=%2fen-us%2flibrary%2fhh925568(v%3dvs.110).aspx) [Print](http://msdn.microsoft.com/en-us/library/hh925568(d=printer,v=vs.110).aspx)
[[#|Collapse All]]

<http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#>[MSDN Library](http://msdn.microsoft.com/en-us/library/ms123401.aspx)
<http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#>[.NET Development](http://msdn.microsoft.com/en-us/library/ff361664(v=vs.110).aspx)
<http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#>[.NET Framework 4.5](http://msdn.microsoft.com/en-us/library/w0x726c2(v=vs.110).aspx)
<http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#>[What's New](http://msdn.microsoft.com/en-us/library/ms171868(v=vs.110).aspx)
<http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#>[Migration Guide](http://msdn.microsoft.com/en-us/library/ff657133(v=vs.110).aspx)
<http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#>[Versions and Dependencies](http://msdn.microsoft.com/en-us/library/bb822049(v=vs.110).aspx)
	[How to: Determine Which .NET Framework Versions Are Installed](http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx)
	[How to: Determine Which .NET Framework Updates Are Installed](http://msdn.microsoft.com/en-us/library/hh925567(v=vs.110).aspx)

[[#|![[./_resources/How_to_Determine_Which_.NET_Framework_Versions_Are_Installed_msdn.microsoft.com.resources/ImageSprite.png]]]]
	

# How to: Determine Which .NET Framework Versions Are Installed

**.NET Framework 4.5**

37 out of 66 rated this helpful \- [Rate this topic](http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#feedback)

The .NET Framework consists of two main components: a set of assemblies, which are collections of types and resources that provide the functionality for your apps, and the common language runtime (CLR), which manages and executes your app's code. These two components are versioned separately. The .NET Framework and assemblies share the same version number, and the CLR is identified by its own version number (see [.NET Framework Versions and Dependencies](http://msdn.microsoft.com/en-us/library/bb822049(v=vs.110).aspx)). You can install and run multiple versions of the .NET Framework on your computer. To see which versions of the .NET Framework are installed on your computer, you should view the entries in the Windows registry. To determine which version of the CLR is currently executing code, you can use the [System.Environment](http://msdn.microsoft.com/en-us/library/system.environment(v=vs.110).aspx) class.

This article provides instructions for detecting .NET Framework versions on a computer both manually and programmatically, and detecting the runtime version using a tool and programmatically. For information about detecting the installed updates for each version of the .NET Framework, see [How to: Determine Which .NET Framework Updates Are Installed](http://msdn.microsoft.com/en-us/library/hh925567(v=vs.110).aspx). For information about installing the .NET Framework, see the [installation guide](http://msdn.microsoft.com/en-us/library/5a4x27ek(v=vs.110).aspx).

### To find the installed .NET Framework versions manually (versions 1-4)

1. On the **Start** menu, choose **Run**.
	
2. In the **Open** box, enter **regedit.exe**.
	
	You must have administrative credentials to run regedit.exe.
	
3. In the Registry Editor, open the following subkey:
	
	HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\NET Framework Setup\\NDP
	
	The installed versions are listed under the NDP subkey. The version number is stored in the **Version** entry. For the .NET Framework 4 the **Version** entry is under the Client or Full subkey (under NDP), or under both subkeys.
	
	| ![[./_resources/How_to_Determine_Which_.NET_Framework_Versions_Are_Installed_msdn.microsoft.com.resources/clear.gif]]<br>**Note** |
	| --- |
	| The "NET Framework Setup" folder in the registry does not begin with a period. |
	

### To find the installed .NET Framework versions manually (versions 4.5 and later)

1. On the **Start** menu, choose **Run**.
	
2. In the **Open** box, enter **regedit.exe**.
	
	You must have administrative credentials to run regedit.exe.
	
3. In the Registry Editor, open the following subkey:
	
	HKEY\_LOCAL\_MACHINE\\SOFTWARE\\Microsoft\\NET Framework Setup\\NDP\\v4\\Full
	
	Check for a DWORD value named Release. The existence of the Release DWORD indicates that the .NET Framework 4.5 or newer has been installed on that computer.
	
	![[./_resources/How_to_Determine_Which_.NET_Framework_Versions_Are_Installed_msdn.microsoft.com.resources/IC664979.png]]
	
	The value of the Release DWORD indicates which version of the .NET Framework is installed.
	
	| Value of the Release DWORD | Version |
	| --- | --- |
	| 378389 | .NET Framework 4.5 |
	| 378758 | .NET Framework 4.5.1 |
	

### To find the installed .NET Framework versions by querying the registry in code (versions 1-4)

		Use the [Microsoft.Win32.RegistryKey](http://msdn.microsoft.com/en-us/library/microsoft.win32.registrykey(v=vs.110).aspx) class to access the Software\\Microsoft\\NET Framework Setup\\NDP\\ subkey under HKEY\_LOCAL\_MACHINE in the Windows registry.
	
	The following code shows an example of this query.
	
	| ![[./_resources/How_to_Determine_Which_.NET_Framework_Versions_Are_Installed_msdn.microsoft.com.resources/clear.gif]]<br>**Note** |
	| --- |
	| This code does not show how to detect .NET Framework 4.5 or later. Check the Release DWORD to detect those versions, as described in the previous section. |
	
	[VB](http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx?cs-save-lang=1&cs-lang=vb#code-snippet-1)
	
	private static void GetVersionFromRegistry(){    using (RegistryKey ndpKey = RegistryKey.OpenBaseKey(RegistryHive.LocalMachine,        RegistryView.Registry32).OpenSubKey(@"SOFTWARE\\Microsoft\\NET Framework Setup\\NDP\\"))    {        foreach (string versionKeyName in ndpKey.GetSubKeyNames())        {            if (versionKeyName.StartsWith("v"))            {                RegistryKey versionKey = ndpKey.OpenSubKey(versionKeyName);                string name = (string)versionKey.GetValue("Version", "");                string sp = versionKey.GetValue("SP", "").ToString();                string install = versionKey.GetValue("Install", "").ToString();                if (install == "") //no install info, ust be later                    Console.WriteLine(versionKeyName + "  " + name);                else                {                    if (sp != "" && install == "1")                    {                        Console.WriteLine(versionKeyName + "  " + name + "  SP" + sp);                    }                }                if (name != "")                {                    continue;                }                foreach (string subKeyName in versionKey.GetSubKeyNames())                {                    RegistryKey subKey = versionKey.OpenSubKey(subKeyName);                    name = (string)subKey.GetValue("Version", "");                    if (name != "")                        sp = subKey.GetValue("SP", "").ToString();                    install = subKey.GetValue("Install", "").ToString();                    if (install == "") //no install info, ust be later                        Console.WriteLine(versionKeyName + "  " + name);                    else                    {                        if (sp != "" && install == "1")                        {                            Console.WriteLine("  " + subKeyName + "  " + name + "  SP" + sp);                        }                        else if (install == "1")                        {                            Console.WriteLine("  " + subKeyName + "  " + name);                        }                    }                }            }        }    }}
	
	The example produces output that's similar to the following:
	
	v2.0.50727  2.0.50727.4016  SP2v3.0  3.0.30729.4037  SP2v3.5  3.5.30729.01  SP1v4  Client  4.0.30319  Full  4.0.30319
	

### To find the installed .NET Framework versions by querying the registry in code (versions 4.5 and later)

1. Use the [OpenBaseKey](http://msdn.microsoft.com/en-us/library/microsoft.win32.registrykey.openbasekey(v=vs.110).aspx) and [OpenSubKey](http://msdn.microsoft.com/en-us/library/microsoft.win32.registrykey.opensubkey(v=vs.110).aspx) methods of the [Microsoft.Win32.RegistryKey](http://msdn.microsoft.com/en-us/library/microsoft.win32.registrykey(v=vs.110).aspx) class to access the Software\\Microsoft\\NET Framework Setup\\NDP\\v4.0\\Full subkey under HKEY\_LOCAL\_MACHINE in the Windows registry.
	
2. Check the value of the Release keyword to determine the installed version.
	
	The following code shows an example of this query.
	
	[VB](http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx?cs-save-lang=1&cs-lang=vb#code-snippet-3)
	
	private static void Get45or451FromRegistry(){    using (RegistryKey ndpKey = RegistryKey.OpenBaseKey(RegistryHive.LocalMachine,       RegistryView.Registry32).OpenSubKey(@"SOFTWARE\\Microsoft\\NET Framework Setup\\NDP\\v4\\Full\\"))    {        int releaseKey = (int)ndpKey.GetValue("Release");        {            if (releaseKey == 378389)                Console.WriteLine("The .NET Framework version 4.5 is installed");            if (releaseKey == 378575)                Console.WriteLine("The .NET Framework version 4.5.1 Preview is installed");            if (releaseKey == 378681)                Console.WriteLine("The .NET Framework version 4.5.1 RC is installed");        }    }}
	
	The example produces output that's similar to the following:
	
	The .NET Framework version 4.5.1 is installed
	

### To find the current runtime version by using a tool

		Use the CLR Version Tool (Clrver.exe) to determine what versions of the common language runtime is installed on a computer.
	
	From a Visual Studio Command Prompt enter clrver. This command produces output similar to the following.
	
	Versions installed on the machine:v2.0.50727v4.0.30319
	
	For more information about using this tool, see [Clrver.exe (CLR Version Tool)](http://msdn.microsoft.com/en-us/library/ff427522(v=vs.110).aspx)
	

### To find the current runtime version by querying the Environment class in code

		Query the [Version](http://msdn.microsoft.com/en-us/library/system.environment.version(v=vs.110).aspx) property of the [Environment](http://msdn.microsoft.com/en-us/library/system.environment(v=vs.110).aspx) class to identify the version of the runtime that is currently executing the code. You can use the [Version.Major](http://msdn.microsoft.com/en-us/library/system.version.major(v=vs.110).aspx) property to get the major release identifier (for example, "3" for version 3.5), the [Version.Minor](http://msdn.microsoft.com/en-us/library/system.version.minor(v=vs.110).aspx) property to get the minor release identifier (for example, "5" for version 3.5), or the [Object.ToString](http://msdn.microsoft.com/en-us/library/system.object.tostring(v=vs.110).aspx) method to get the entire version string (for example, "4.0.30319.18010", as shown in the following code). This property returns a single value that reflects the version of the runtime that is currently executing the code; it does not return assembly versions or other versions of the runtime that may have been installed on the computer.
	
	The following code shows an example of querying the [Environment.Version](http://msdn.microsoft.com/en-us/library/system.environment.version(v=vs.110).aspx) property for runtime version information.
	
	[VB](http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx?cs-save-lang=1&cs-lang=vb#code-snippet-6)
	
	private static void GetVersionFromEnvironment(){    Console.WriteLine("Version: " + Environment.Version.ToString());}
	
	The example produces output that's similar to the following:
	
	Version: 4.0.30319.18010
	

[[#|**See Also**]]

* * *

#### Tasks

[How to: Determine Which .NET Framework Updates Are Installed](http://msdn.microsoft.com/en-us/library/hh925567(v=vs.110).aspx)

#### Concepts

[Locating Runtime Version Information](http://msdn.microsoft.com/en-us/library/tkyzwk9k(v=vs.110).aspx)
[Installing the .NET Framework 4.5](http://msdn.microsoft.com/en-us/library/5a4x27ek(v=vs.110).aspx)
[.NET Framework Versions and Dependencies](http://msdn.microsoft.com/en-us/library/bb822049(v=vs.110).aspx)

Dev centers

* [Windows](http://msdn.microsoft.com/windows)

* [Windows Phone](http://dev.windowsphone.com/)
* [Office](http://msdn.microsoft.com/office)
* [Windows Azure](http://www.windowsazure.com/en-us/documentation/)
* [Visual Studio](http://msdn.microsoft.com/vstudio)
* [More...](http://msdn.microsoft.com/aa937802)

Learning resources

* [Microsoft Virtual Academy](http://www.microsoftvirtualacademy.com/)

* [Channel 9](http://channel9.msdn.com/)
* [Interoperability Bridges](http://www.interoperabilitybridges.com/)
* [MSDN Magazine](http://msdn.microsoft.com/magazine/)

Community

* [Forums](http://social.msdn.microsoft.com/forums/en-us/home)

* [Blogs](http://blogs.msdn.com/b/developer-tools/)
* [Codeplex](http://www.codeplex.com/)

Support

* [Self support](http://msdn.microsoft.com/hh361695)

* [Other support options](http://support.microsoft.com/)

Programs

* [BizSpark (for startups)](http://www.microsoft.com/bizspark/)

* [DreamSpark](https://www.dreamspark.com/)
* [Faculty Connection](https://www.microsoft.com/faculty)
* [Microsoft Student](http://www.microsoft.com/student/)

Did you find this helpful?

Yes
No

[United States (English)](http://msdn.microsoft.com/en-us/library/hh925568(v=vs.110).aspx#)

* [Newsletter](http://msdn.microsoft.com/newsletter.aspx)

* [Privacy & cookies](http://privacy.microsoft.com/default.mspx)
* [Terms of Use](http://msdn.microsoft.com/cc300389.aspx)
* [Trademarks](http://www.microsoft.com/en-us/legal/intellectualproperty/Trademarks/EN-US.aspx)
© 2013 Microsoft
