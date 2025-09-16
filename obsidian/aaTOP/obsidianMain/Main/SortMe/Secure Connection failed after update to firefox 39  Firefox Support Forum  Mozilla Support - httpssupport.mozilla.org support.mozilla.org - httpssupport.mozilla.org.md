# "Secure Connection failed" after update to firefox 39 | Firefox Support Forum | Mozilla Support - https://support.mozilla.org/ [support.mozilla.org] - https://support.mozilla.org/

* [Skip to main content](https://support.mozilla.org/en-US/questions/1073420#main-content)
* [Switch language](https://support.mozilla.org/en-US/locales)
* [Skip to search](https://support.mozilla.org/en-US/questions/1073420#search-q)

[mozilla](http://www.mozilla.org/)

* [Ask a question](https://support.mozilla.org/en-US/questions/new)

* [Sign In](https://support.mozilla.org/en-US/users/auth)
* [English](https://support.mozilla.org/en-US/locales)

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/mozilla-support.png]]](https://support.mozilla.org/en-US/)

2. [Home](https://support.mozilla.org/en-US/)

* \>[Support Forum](https://support.mozilla.org/en-US/questions)
* \>[Firefox](https://support.mozilla.org/en-US/questions/firefox)
* \>"Secure Connection failed" after update ...

# Support Forum

This thread was archived. [Please ask a new question if you need help.](https://support.mozilla.org/en-US/questions/new)

## "Secure Connection failed" after update to firefox 39

* 5 replies

* 222 have this problem
* 53190 views
* [Last reply by jscher2000](https://support.mozilla.org/en-US/questions/1073420#answer-811814) 3 months ago

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/avatar.png]]](https://support.mozilla.org/en-US/user/DrMridul)
[DrMridul](https://support.mozilla.org/en-US/user/DrMridul)
Posted
7/20/15, 9:39 PM

Hi, After update of firefox to version 39 i am unable to pay online bill, shopping bill etc and got this message "Secure Connection Failed

An error occurred during a connection to [acs.onlinesbi.com](http://acs.onlinesbi.com/). SSL received a weak ephemeral Diffie-Hellman key in Server Key Exchange handshake message. (Error code: ssl\_error\_weak\_server\_ephemeral\_dh\_key)

   The page you are trying to view cannot be shown because the authenticity of the received data could not be verified.
   Please contact the website owners to inform them of this problem.

Report this error " Please help me how to fix this problem.Thanks.

### Chosen solution

This indicates that the site is defaulting to an obsolete encryption cipher which is vulnerable to the "Logjam" attack that was in the news earlier this year.

You can disable these old ciphers in Firefox to try to force the site to up its game. Here's how:

(1) In a new tab, type or paste **about:config** in the address bar and press Enter. Click the button promising to be careful.

(2) In the search box above the list, type or paste **dhe** and pause while the list is filtered

(3) Double-click the **security.ssl3.dhe\_rsa\_aes\_128\_sha** preference to switch it from true to false (disable Firefox from using this cipher)

(4) Double-click the **security.ssl3.dhe\_rsa\_aes\_256\_sha** preference to switch it from true to false (disable Firefox from using this cipher)

Then try your payment site again. Any improvement?

[Read this answer in context](https://support.mozilla.org/en-US/questions/1073420#answer-757003) ♥199

* Question tools

* Question details

* Tags

* Related

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/2011-04-24-15-03-43-b97d6b.jpg]]](https://support.mozilla.org/en-US/user/jscher2000)
[jscher2000](https://support.mozilla.org/en-US/user/jscher2000)

* Top 10 Contributor

**4792 solutions** 40433 answers
Posted
[7/20/15, 9:53 PM](https://support.mozilla.org/en-US/questions/1073420#answer-757003)

### Chosen Solution

This indicates that the site is defaulting to an obsolete encryption cipher which is vulnerable to the "Logjam" attack that was in the news earlier this year.

You can disable these old ciphers in Firefox to try to force the site to up its game. Here's how:

(1) In a new tab, type or paste **about:config** in the address bar and press Enter. Click the button promising to be careful.

(2) In the search box above the list, type or paste **dhe** and pause while the list is filtered

(3) Double-click the **security.ssl3.dhe\_rsa\_aes\_128\_sha** preference to switch it from true to false (disable Firefox from using this cipher)

(4) Double-click the **security.ssl3.dhe\_rsa\_aes\_256\_sha** preference to switch it from true to false (disable Firefox from using this cipher)

Then try your payment site again. Any improvement?

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/avatar.png]]](https://support.mozilla.org/en-US/user/DrMridul)
[DrMridul](https://support.mozilla.org/en-US/user/DrMridul)
Posted
[7/20/15, 10:58 PM](https://support.mozilla.org/en-US/questions/1073420#answer-757017)

### Helpful Reply

Its working.Thank you very much Sir.

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/avatar.png]]](https://support.mozilla.org/en-US/user/CrazySoul)
[CrazySoul](https://support.mozilla.org/en-US/user/CrazySoul) **0 solutions** 2 answers
Posted
[8/18/15, 12:49 PM](https://support.mozilla.org/en-US/questions/1073420#answer-769410)

I had exactly this same problem with this browser. now its solved. Thanks jscher2000.

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/avatar.png]]](https://support.mozilla.org/en-US/user/Jonathan_Jaffe)
[Jonathan_Jaffe](https://support.mozilla.org/en-US/user/Jonathan_Jaffe) **0 solutions** 4 answers
Posted
[11/27/15, 5:16 PM](https://support.mozilla.org/en-US/questions/1073420#answer-811326)

attempting to access <https://community.landesk.com/support/docs/DOC-39460> I am running FireFox 42.0 Other people can access that site so the problem is my installation

On the above, and more than a few other sites, and I get Secure Connection Failed

I have edited about:config so that

 security.ssl3.dhe\_rsa\_aes\_128\_sha 
 security.ssl3.dhe\_rsa\_aes\_256\_sha 

are both FALSE. Restarted FireFox

No effect.

There are many security.ssl3 settings including

  security.ssl3.ecdhe\_ecdsa\_aes\_128\_sha;true

should I turn something else off?

[![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/2011-04-24-15-03-43-b97d6b.jpg]]](https://support.mozilla.org/en-US/user/jscher2000)
[jscher2000](https://support.mozilla.org/en-US/user/jscher2000)

* Top 10 Contributor

**4792 solutions** 40433 answers
Posted
[11/29/15, 8:26 AM](https://support.mozilla.org/en-US/questions/1073420#answer-811814)

Hi Jonathan\_Jaffe, could you start a new question? Since your problem is not caused by the Logjam issue, it presumably is something else personal to your configuration.

You can start a new question at the following link. Scroll down past the suggestions to continue submitting your question: <https://support.mozilla.org/questions/new/desktop/fix-problems>

Please mention any untrusted connection errors you may have seen on other sites, and whether you use any security software known to intercept secure connections for filtering (e.g., Avast, BitDefender, ESET, Kaspersky).

![[./_resources/Secure_Connection_failed_after_update_to_firefox_39__Firefox_Support_Forum__Mozilla_Support_-_httpssupport.mozilla.org_support.mozilla.org_-_httpssupport.mozilla.org.resources/mozilla-logo.png]]

Portions of this content are ©1998–2015
by individual mozilla.org contributors. Content
available under a [Creative Commons license](https://www.mozilla.org/foundation/licensing/website-content.html).

* [Contact Us](http://www.mozilla.org/en-US/contact/spaces/)

* [Privacy Policy](http://www.mozilla.org/privacy/websites/)
* [Legal Notices](http://www.mozilla.org/about/legal.html)
* [Report Trademark Abuse](http://www.mozilla.org/legal/fraud-report/)
* [Source Code](https://github.com/mozilla/kitsune/)

* [Twitter](http://www.twitter.com/mozilla)

* [Facebook](http://www.facebook.com/mozilla)
* [Firefox Friends](http://friends.mozilla.org/)
* [Switch to mobile site](https://support.mozilla.org/en-US/questions/1073420?&mobile=1)
