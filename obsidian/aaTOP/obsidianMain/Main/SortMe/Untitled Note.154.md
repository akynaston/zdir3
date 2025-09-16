# Untitled Note

New REgular expression eingine value, starting with 4.0.2. Patch 4
patch 4: 
<http://download.novell.com/Download?buildid=jif2160bxMA~&amp;donotredirect=true>
(though current patch is 7, <https://dl.netiq.com/Download?buildid=X7DYbkPceZk>~)

Exceprt from: <https://www.netiq.com/documentation/idm402/pdfdoc/designer_admin/designer_admin.pdf> (IDM 4.0.2) documentatoin:
 Regular Expression escape meta-characters This control determines the meta-characters that will be escaped while expanding the local variable when used in a regular expression context. All characters that need to be escaped must be added as a comma separated list for this control value. If a meta-character is not present in the control value, then it will not be escaped during local variable expansion containing a regular expression. While using this control, ensure the following:  The value is not left empty.  To escape any meta character, specify the meta character and include a back slash (\\). For example, to escape ^, specify the following value: ^,\\ NOTE: This control is available only from Identity Manager 4.0.2 Engine Patch 4. 

Example engine control value (appears as last one in list, and doesn't deploy to tree very well - had to put it in with Apache Directory studo)
     <definition display-name="Regular Expression escape meta-characters" display-name-ref="ecnm\_reecn" name="dirxml.engine.reg-ex-escape-chars" type="string">
               <description description-ref="ecds\_reecd">This control determines the meta-characters that will be escaped while evaluating regular expressions. If a meta-char is not present in control value then it will not be escaped during local variable expansion containing a regular expression.
To escape all the regular expression meta-characters, "\\,$,^,.,?,\*,+,\[,\],(,),|" should be added as the value.
If a meta-character need not be escaped, then remove it from the control value.
The control value should be a valid comma(,) separated list, else errors may be encountered during policy evaluation.</description>
               <value xml:space="preserve">$</value>
          </definition>
