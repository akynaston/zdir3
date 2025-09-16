# Using MSCONFIG to troubleshoot conflicts in Windows XP

* [Apple](http://www.apple.com/)
* [Store](http://www.apple.com/store/)
* [Mac](http://www.apple.com/mac/)
* [iPod + iTunes](http://www.apple.com/itunes/)
* [iPhone](http://www.apple.com/iphone/)
* [Downloads](http://www.apple.com/downloads/)
* [Support](http://www.apple.com/support/)

Search

![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/spinner.gif]]

Search Support

[Search Tips](http://support.apple.com/kb/HE4?viewlocale=en_US) [Advanced Search](http://support.apple.com/kb/index?page=search)

[![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/i_email_adv.png]]](http://support.apple.com/kb/index?page=login&redirect=http%3A%2F%2Fsupport.apple.com%2Fkb%2Findex%3Fpage%3Dkb%26id%3DHT1275%26locale%3Den_US%26login%3Demail)
[![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/i_call_adv.png]]](http://www.apple.com/support/expert)

## <http://www.apple.com/support/>

## Browse Support

﻿

## Languages

* [Dansk](http://support.apple.com/kb/HT1275?viewlocale=da_DK)
* [Deutsch](http://support.apple.com/kb/HT1275?viewlocale=de_DE)
* [English](http://support.apple.com/kb/HT1275?viewlocale=en_US)
* [Español](http://support.apple.com/kb/HT1275?viewlocale=es_ES)
* [Suomi](http://support.apple.com/kb/HT1275?viewlocale=fi_FI)
* [Français](http://support.apple.com/kb/HT1275?viewlocale=fr_FR)
* [Italiano](http://support.apple.com/kb/HT1275?viewlocale=it_IT)
* [日本語](http://support.apple.com/kb/HT1275?viewlocale=ja_JP)
* [한국어](http://support.apple.com/kb/HT1275?viewlocale=ko_KR)
* [Nederlands](http://support.apple.com/kb/HT1275?viewlocale=nl_NL)
* [Norsk Bokmål](http://support.apple.com/kb/HT1275?viewlocale=no_NO)
* [Polski](http://support.apple.com/kb/HT1275?viewlocale=pl_PL)
* [Portuguese Brasileiro](http://support.apple.com/kb/HT1275?viewlocale=pt_BR)
* [Português](http://support.apple.com/kb/HT1275?viewlocale=pt_PT)
* [Pусский](http://support.apple.com/kb/HT1275?viewlocale=ru_RU)
* [Svenska](http://support.apple.com/kb/HT1275?viewlocale=sv_SE)
* [简体中文](http://support.apple.com/kb/HT1275?viewlocale=zh_CN)
* [繁體中文](http://support.apple.com/kb/HT1275?viewlocale=zh_TW)

﻿

## Related Articles

* [Using MSCONFIG to troubleshoot conflicts in Windows Vista and Wind...](http://support.apple.com/kb/HT2292)
* [iTunes for Windows XP: Troubleshooting unexpected quits, freezes, ...](http://support.apple.com/kb/TS1421)
* [Advanced troubleshooting for Sync Services on Windows with Microso...](http://support.apple.com/kb/TS2776)
* [iPhone: Troubleshooting Internet tethering](http://support.apple.com/kb/TS2756)
* [iTunes for Windows: iTunes Store connection troubleshooting](http://support.apple.com/kb/HT1527)

## Related Discussions

* [TC with a wired PC running XP can...](http://discussions.apple.com/thread.jspa?threadID=1476745)
* [Adding SUMIF formulas](http://discussions.apple.com/thread.jspa?threadID=2074040)
* ["A valid DVD drive could not be f...](http://discussions.apple.com/thread.jspa?threadID=2020977)
* [How does a PC user access my Publ...](http://discussions.apple.com/thread.jspa?threadID=1568935)
* [Converting duration to integer](http://discussions.apple.com/thread.jspa?threadID=2105625)

# Using MSCONFIG to troubleshoot conflicts in Windows XP

* **Last Modified:** October 26, 2009
* **Article:** HT1275

* **Old Article:** 302538

## Summary

Using MSCONFIG to troubleshoot conflicts in Windows Vista and Windows 7 is discussed in this [article](http://support.apple.com/kb/HT2292).

In Windows, some background processes can cause issues for other programs and processes. These conflicts can prevent applications such as iTunes and QuickTime Player from working correctly, opening, or even installing. You might be able to resolve these conflicts by disabling some items using the System Configuration Utility (MSCONFIG) in Windows XP. This utility is not included with Windows 2000.

## Products Affected

QuickTime 7 (Windows), iTunes 7 for Windows, iPhone, iPod, Microsoft Windows XP

**Important**: Disabling third-party System Services and Startup Items can prevent some software or OEM hardware on your computer from working correctly. For example, this can affect the CD/DVD control buttons on portable computers or prevent wireless keyboards and mice from functioning. If you are already using the Selective Startup option in Windows (see step 4 below), you will need to keep track of which items you disable and re-enable so after performing this troubleshooting, you can get your computer back to the way it was. Selecting Normal Startup may enable items that you were not using, and could cause issues.

1. On the **Start** menu, click **Run**. A Run window (command prompt) appears.
2. Type msconfig in the Open field and click OK. The System Configuration Utility opens.
3. Click the General tab.
4. Select the "Selective Startup" option.
5. Deselect the "Load Startup Items" checkbox.
	
	![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/302538_1.jpg]]
	
6. Click the Startup tab.
7. Select the "iTunesHelper" and "qttask" checkboxes in the list.
	
	![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/302538_2.jpg]]
	
8. Click the Services tab.
9. Make sure that "Hide All Microsoft Services" is selected.
10. Click Disable All.
	
	![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/302538_3.jpg]]
	
	**Note**: If you are troubleshooting an iPhone related issue, select the "Apple Mobile Device Support" checkbox.
11. Click OK.
12. Click Restart.
13. After restarting (and logging in to Windows), a window appears confirming that "You have used the System Configuration Utility to make changes to the way Windows starts." Click OK. The System Configuration Utility appears. Do not click OK here as this will prompt you to restart again. First try to reproduce the issue you were having.

If following these steps resolves the issue, you may want to use the System Configuration Utility to turn on the third-party System Services and Startup Items one or a few at a time (restarting your computer after turning on the item or items) to identify which System Service or Startup Item is causing the conflict. You can turn all of them back on by selecting the Normal Startup option under the General tab of the System Configuration Utility window, but please note that this may cause the issue to recur.

**Important:** Information about products not manufactured by Apple is provided for information purposes only and does not constitute Apple’s recommendation or endorsement. Please [contact the vendor](http://support.apple.com/kb/HT2693?viewlocale=en_US) for additional information.

**Important:** Mention of third-party websites and products is for informational purposes only and constitutes neither an endorsement nor a recommendation. Apple assumes no responsibility with regard to the selection, performance or use of information or products found at third-party websites. Apple provides this only as a convenience to our users. Apple has not tested the information found on these sites and makes no representations regarding its accuracy or reliability. There are risks inherent in the use of any information or products found on the Internet, and Apple assumes no responsibility in this regard. Please understand that a third-party site is independent from Apple and that Apple has no control over the content on that website. Please [contact the vendor](http://support.apple.com/kb/HT2693?viewlocale=en_US) for additional information.

**Rate this article:**

* [Not helpful](http://support.apple.com/kb/HT1275#)
* [Somewhat helpful](http://support.apple.com/kb/HT1275#)
* [Helpful](http://support.apple.com/kb/HT1275#)
* [Very helpful](http://support.apple.com/kb/HT1275#)
* [Solved my problem](http://support.apple.com/kb/HT1275#)

One Moment Please
Thanks for rating this article

Not helpful Somewhat helpful Helpful Very helpful Solved my problem

[![[./_resources/Using_MSCONFIG_to_troubleshoot_conflicts_in_Windows_XP.resources/max.jpg]]](http://www.apple.com/support/expert)

### Still need help? Speak to an Apple Expert

Arrange a phone call with one of our Apple Experts who specializes in your exact question. Talk to us now or later at your convenience. We'll even call you.
[Get started](http://www.apple.com/support/expert)
_NOTE: Callbacks are currently only available for **U.S. and Canada** phone numbers._

[Home](http://www.apple.com/) \> [Support](http://www.apple.com/support/)

Visit the Apple Store [online](http://www.apple.com/store/) (1-800-MY-APPLE), visit a [retail](http://www.apple.com/retail/) location, or find a [reseller](http://www.apple.com/buy/locator/).

[Site Map](http://www.apple.com/sitemap/) | [Hot News](http://www.apple.com/hotnews/) | [RSS Feeds](http://www.apple.com/rss/) | [Contact Us](http://www.apple.com/contact/)

Copyright © 2009 Apple Inc. All rights reserved. [Terms of Use](http://www.apple.com/legal/terms/site.html) | [Privacy Policy](http://www.apple.com/legal/privacy/)
