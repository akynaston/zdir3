5/14/2025 11:55:54 AM
More commands today . .
Discussion on on prem vs cloud: onprem much faster . .

if rename/deleted something, take care of git repo . . 
learning frodo list

frodo conn list
frodo idp list
fordo idm list

If a script is in use - use -u to check, -D to specify directory
 frodo script list -uD . trivir

Or this to check one . .
frodo script describe -n'ChooseCredentialStyling' -uD . trivir


describe example:
trivir@trivir-frodo-dev-vm:~/Work/frodo-lunch-n-learn-cloud$ frodo script describe -n'Username Input Validation Script' -uD . trivir
Connected to https://openam-trivir.forgeblocks.com/am [alpha] as service account Frodo L&L [a5c67e68-c7ba-484e-88e7-ed3327256582]
Id                       │3917d9d9-7269-43b5-8fbb-f919f907c0ac                                                                    
Name                     │Username Input Validation Script                                                                        
Language                 │JavaScript                                                                                              
Context                  │Authentication Tree Decision Node                                                                       
Description              │Custom script for username (email) input validation. Provided by professional services Lucille Bollozos.
Default                  │false                                                                                                   
Evaluator Version        │2.0                                                                                                     
Script (Base 64)         │LyoKICAtIERhdGEgbWFkZSBhdmFpbGFibGUgYnkgbm9kZXMgdGhhdCBoYXZlIGFscmVhZHkgZXhlY3V0Z                       
                         │WQgYXJlIGF2YWlsYWJsZSBpbiB0aGUgc2hhcmVkU3RhdGUgdmFyaWFibGUuCiAgLSBUaGUgc2NyaXB0IH                       
                         │Nob3VsZCBzZXQgb3V0Y29tZSB0byBlaXRoZXIgInRydWUiIG9yICJmYWxzZSIuCiAqLwoKdmFyIGNvbmZ                       
                         │pZyA9IHsKICBmaWVsZHM6IFsKICAgIHsKICAgICAgbmFtZTogInVzZXJuYW1lIiwKICAgICAgbGFiZWw6                       
                         │ICJFbWFpbCBBZGRyZXNzIiwKICAgICAgZGVmYXVsdFZhbHVlIDogIiIsCiAgICAgIHJlZ2V4OiAiXlxcc                       
                         │ypbJ19hLXpBLVowLTktXFwrXSsoXFwuWydfYS16QS1aMC05LVxcK10rKSpAW2EtekEtWjAtOS1dKyhcXC                       
                         │5bYS16QS1aMC05LV0rKSpcXC4oW2EtekEtWl17Miw2fSlcXHMqJCIsCiAgICAgIGN1c3RvbVBvbGljeU1                       
                         │lc3NhZ2VOYW1lOiAiQ1VTVE9NLWVtYWlsIgogICAgfQogIF0sCn07CiAgICAKZnVuY3Rpb24gY2FsbGJh                       
                         │Y2tzVG9TZW5kKCkKewogIHZhciByZXNwb25zZUNvbXBsZXRlID0gIWNhbGxiYWNrcy5pc0VtcHR5KCk7C                       
                         │iAgdmFyIGVycm9ycyA9IFtmYWxzZV07CgogIGlmICghY2FsbGJhY2tzLmlzRW1wdHkoKSkKICB7IAogIC                       
                         │AgY29uZmlnLmZpZWxkcy5mb3JFYWNoKGZ1bmN0aW9uIChmaWVsZCkgewogICAgICB2YXIgY3VycmVudFZ                       
                         │hbHVlID0gU3RyaW5nKGNhbGxiYWNrcy5nZXRTdHJpbmdBdHRyaWJ1dGVJbnB1dENhbGxiYWNrcygpLmdl                       
                         │dChjb25maWcuZmllbGRzLmluZGV4T2YoZmllbGQpKSk7CiAgICAgIGlmIChjdXJyZW50VmFsdWUpIAogI                       
                         │CAgICB7CiAgICAgICAgaWYgKCFjdXJyZW50VmFsdWUubWF0Y2goZmllbGQucmVnZXgpKSAKICAgICAgIC                       
                         │B7CiAgICAgICAgICByZXNwb25zZUNvbXBsZXRlID0gZmFsc2U7CiAgICAgICAgICBlcnJvcnNbY29uZml                       
                         │nLmZpZWxkcy5pbmRleE9mKGZpZWxkKV0gPSB0cnVlOwogICAgICAgIH0KICAgICAgfQogICAgfSk7CiAg                       
                         │fQogIGVsc2UKICB7CiAgICByZXNwb25zZUNvbXBsZXRlID0gZmFsc2U7CiAgfQoKICBpZiAocmVzcG9uc                       
                         │2VDb21wbGV0ZSkKICB7CiAgICAvLyBub3RoaW5nIG1vcmUgdG8gZG8KICAgIHJldHVybiByZXNwb25zZU                       
                         │NvbXBsZXRlOwogIH0KICAgIAogIGNvbmZpZy5maWVsZHMuZm9yRWFjaChmdW5jdGlvbiAoZmllbGQpIHs                       
                         │KICAgIHZhciBjdXJyZW50VmFsdWUgPSAiIjsKICAgICAgCiAgICBpZiAoIWNhbGxiYWNrcy5pc0VtcHR5                       
                         │KCkpIAogICAgewogICAgICBjdXJyZW50VmFsdWUgPSBTdHJpbmcoY2FsbGJhY2tzLmdldFN0cmluZ0F0d                       
                         │HJpYnV0ZUlucHV0Q2FsbGJhY2tzKCkuZ2V0KGNvbmZpZy5maWVsZHMuaW5kZXhPZihmaWVsZCkpKTsKIC                       
                         │AgIH0KICAgIAogICAgaWYgKGVycm9yc1tjb25maWcuZmllbGRzLmluZGV4T2YoZmllbGQpXSkgCiAgICB                       
                         │7CiAgICAgIHZhciBmYWlsZWRQb2xpY3kgPSB7CiAgICAgICAgcG9saWN5UmVxdWlyZW1lbnQ6IGZpZWxk                       
                         │LmN1c3RvbVBvbGljeU1lc3NhZ2VOYW1lLAogICAgICAgIH07CiAgICAKICAgICAgICBjYWxsYmFja3NCd                       
                         │WlsZGVyLnN0cmluZ0F0dHJpYnV0ZUlucHV0Q2FsbGJhY2soZmllbGQubmFtZSwgZmllbGQubGFiZWwsIG                       
                         │N1cnJlbnRWYWx1ZSwgdHJ1ZSwgW0pTT04uc3RyaW5naWZ5KGZhaWxlZFBvbGljeSldKTsKICAgIH0KICA                       
                         │gIGVsc2UKICAgIHsKICAgICAgY2FsbGJhY2tzQnVpbGRlci5zdHJpbmdBdHRyaWJ1dGVJbnB1dENhbGxi                       
                         │YWNrKGZpZWxkLm5hbWUsIGZpZWxkLmxhYmVsLCBjdXJyZW50VmFsdWUsIHRydWUpOyAgICAKICAgIH0KC                       
                         │iAgfSk7CgogIHJldHVybiByZXNwb25zZUNvbXBsZXRlOwp9CiAgICAKCihmdW5jdGlvbiAoKSB7CiAgdH                       
                         │J5IAogIHsKICAgIHZhciBjYWxsYmFja0xpc3QgPSBjYWxsYmFja3NUb1NlbmQoKTsKCiAgICBpZiAoIWN                       
                         │hbGxiYWNrTGlzdCkKICAgIHsKICAgICAgcmV0dXJuOwogICAgfQogICAgZWxzZQogICAgewogICAgICAg                       
                         │IC8vIENhbGxiYWNrcyByZXR1cm5lZCBmcm9tIGJyb3dzZXIsIHNhdmUgdXNlcm5hbWUKICAgICAgICAKI                       
                         │CAgICAgICB2YXIgdXNlck5hbWUgPSBjYWxsYmFja3MuZ2V0U3RyaW5nQXR0cmlidXRlSW5wdXRDYWxsYm                       
                         │Fja3MoKS5nZXQoMCk7CiAgICAgICAgbm9kZVN0YXRlLnB1dFNoYXJlZCgidXNlcm5hbWUiLCB1c2VyTmF                       
                         │tZSk7CgogICAgICAgIHZhciBvYmplY3RBdHRyaWJ1dGVzID0ge307CiAgICAgICAgb2JqZWN0QXR0cmli                       
                         │dXRlc1sidXNlck5hbWUiXSA9IHVzZXJOYW1lOwogICAgICAgIG5vZGVTdGF0ZS5wdXRTaGFyZWQoIm9ia                       
                         │mVjdEF0dHJpYnV0ZXMiLCBvYmplY3RBdHRyaWJ1dGVzKTsKICAgICAgICAKICAgICAgICBhY3Rpb24uZ2                       
                         │9UbygidHJ1ZSIpOyAKICAgIH0KICAgICAgIAogIH0gY2F0Y2ggKGUpCiAgewogICAgbG9nZ2VyLmVycm9                       
                         │yKCJVbmFibGUgdG8gcGVyc2lzdCBhdHRyaWJ1dGUuICIgKyBlKTsKICAgIGFjdGlvbi5nb1RvKCJmYWls                       
                         │ZWQiKTsKICB9Cn0pKCk7Cg==                                                                                
Usage Locations (1 total)│realm.root-alpha.trees.ResetPassword.innerNodes.066cb9bf-d798-48d6-b478-85e97d18aedc.script             
trivir@trivir-frodo-dev-vm:~/Work/frodo-lunch-n-learn-cloud$ frodo script describe -n'Username Input Validation Script' -uD . trivir


Frodo journey list
trivir@trivir-frodo-dev-vm:~/Work/frodo-lunch-n-learn-cloud$ frodo journey describe -i Temp trivir
Connected to https://openam-trivir.forgeblocks.com/am [alpha] as service account Frodo L&L [a5c67e68-c7ba-484e-88e7-ed3327256582]
[Temp]
======

Status
enabled

Classification
standard

Node Types (5):
- 1 [SetFailureUrlNode] (standard)
- 1 [ChoiceCollectorNode] (standard)
- 1 [EmailSuspendNode] (standard)
- 1 [PageNode] (standard)
- 1 [AttributeCollectorNode] (standard)

Nodes (5):
- [0f371094-b246-47b4-938d-16090a66e4d4] (standard) SetFailureUrlNode - Failure URL
- [1c599c54-87b3-4f89-b461-75e5b8ad9a51] (standard) ChoiceCollectorNode - Choice Collector
- [711a62d1-fd09-4bf0-99f0-5af33658ea31] (standard) EmailSuspendNode - Email Suspend Node
- [cf399d29-d18a-4956-9645-523500c5dbc5] (standard) PageNode - Page Node
- [67a53b92-f4a0-41e6-80cb-ed48ef3aac0e] (standard) AttributeCollectorNode - Attribute Collector

Email Templates (1):
- [registration]  - Register new account


Testing myself:
 frodo esv variable list trivir


Esv listing; not cguarnatueed to capture all; can build variable name in scripts . .
trivir@trivir-frodo-dev-vm:~/Work/frodo-lunch-n-learn-cloud$ frodo esv variable list -uD . trivir


esv-verosint-employee-mfa-reg-rule-uuid       │yes (at realm.root-alpha.script.7a966ee8-4326-4e0c-8a08-abb8e81cdb5d(name: 'Common_VerosintRiskRuleEvaluation').script.13)                          
esv-verosint-enabled                          │yes (2 uses, including: realm.root-alpha.script.04ab85ca-4fe3-471a-a805-a8dd6010554c(name: 'Common_VerosintProcessSignal').script.1)                
esv-verosint-parent-auth-rule-uuid            │yes (at realm.root-alpha.script.7a966ee8-4326-4e0c-8a08-abb8e81cdb5d(name: 'Common_VerosintRiskRuleEvaluation').script.10)                          
esv-verosint-parent-mfa-reg-rule-uuid         │yes (at realm.root-alpha.script.7a966ee8-4326-4e0c-8a08-abb8e81cdb5d(name: 'Common_VerosintRiskRuleEvaluation').script.11)                          
esv-verosint-rule-uuid                        │no                                                                                                                                                  
esv-verosint-student-auth-rule-uuid           │yes (at realm.root-alpha.script.7a966ee8-4326-4e0c-8a08-abb8e81cdb5d(name: 'Common_VerosintRiskRuleEvaluation').script.8)                           
esv-verosint-student-mfa-reg-rule-uuid        │yes (at realm.root-alpha.script.7a966ee8-4326-4e0c-8a08-abb8e81cdb5d(name: 'Common_VerosintRiskRuleEvaluation').script.9)                           
trivir@trivir-frodo-dev-vm:~/Work/frodo-lunch-n-learn-cloud$ frodo esv variable list -uD . trivir


frodo sv variable describe -l 'esv-twillio-account-edi' -uD . trivir


IN cloude, when going to delete script or esv . . won't tell you where it is being used . .

Orphan nodes don't get exported . . 
also note: delete joourney - may leave let over 'nodes' . .can use a  forod journey -h

Can clean up:
Connected to https://openam-trivir.forgeblocks.com/am [alpha] as service account Frodo L&L [a5c67e68-c7ba-484e-88e7-ed3327256582]
✔ 716 total nodes
✔ 695 active nodes
✔ 21 orphaned nodes
Prune (permanently delete) orphaned nodes? (y|n): 

orphaned nodes - if journey no longer references . .  could create new journey to point to nodes . .

Delete command
-i, -n, -a . . .don't use -a . . deletes all . . don't want to do this; if you delete default journey; tennatnis broken . .


now importing:

frodo config import -AD . trivir . .

doing this in classic . .not cloud . .


secrets exporting:
this doesn't work

frodo esv secret export -l 'output' --include-active-values trivir

Dependencies:
on import/export, can chose to say no deps . .
frodo journey export -i login trivir
 - shows everyting . . SAML, idps, scripts, etc . .
 - Export note: bug currently (5/14/2025 12:44:55 PM) use rname is different case; casues dup
--no-deps: can include/avoid these . .

frodo jouney 

no-deps example . .but this journey doesn't have any dependencies . 

.
frodo journey export --no-deps -i login -flogin-nodeps trivir

other usefulc ommands
frodo log tail

live log!  
trivir@trivir-frodo-dev-vm:~/Work/frodo-lunch-n-learn-cloud$ frodo log tail trivir
Tailing ID Cloud logs from the following sources: am-everything,idm-everything and levels [SEVERE,ERROR,FATAL] of https://openam-trivir.forgeblocks.com/am...
{"payload":"SEVERE: Scheduled service \"scheduler-service-group.LiveSyncParent\" invocation reported failure: org.forgerock.json.resource.InternalServerErrorException: Failed to get OperationOptionsBuilder: null","source":"idm-core","timestamp":"2025-05-14T18:47:59.237314491Z","type":"text/plain"}
{"payload":"SEVERE: Scheduled service \"scheduler-service-group.ReconcileParentSISToFR\" invocation reported failure: ObjectMapping specified by SISParent_to_FRParent not ready.","source":"idm-core","timestamp":"2025-05-14T18:47:59.521454624Z","type":"text/plain"}
{"payload":"SEVERE: Scheduled service \"scheduler-service-group.ReconcileParentSISToFR\" invocation reported failure: ObjectMapping specified by SISParent_to_FRParent not ready.","source":"idm-core","timestamp":"2025-05-14T18:48:04.534177729Z","type":"text/plain"}
{"payload":"SEVERE: Scheduled service \"scheduler-service-group.ReconcileParentSISToFR\" invocation reported failure: ObjectMapping specified by SISParent_to_FRParent not ready.","source":"idm-core","timestamp":"2025-05-14T18:48:09.542186265Z","type":"text/plain"}



Can be granular, see 'sources' above, and frodo log -h for options . .

Can increase log trace:

frodo log tail -l4 trivir

When we created the connection profile, the key we added during connection allows logigng to work.

note:
frodo script import -AD . --watch - save changes, imported automatically

frodo promote command . .doesn't really prmote . .more of an diff/import . . .

Sean Koo working on frodo import config create/delete etc . .

frodo esv secret create: handy when secrets are not a string; like certificate s. .

more useful info: --curlirize!! suer handy

-h very good
any substring of connection profiles
lots of progress indicators on import/export- can overwrite errors,  get full output by doing: >out.txt 2>&1

careful with imports 7 deletes - transfering configs dangerous: onprem to cloud, and back dangerous. Version differences are an issue too.
 - deleting esv's while being used . . 
can create ticket -  in clickup - trivir-ineternal >frodo
- github has some issue submission - frodo-cli/frodo-lib
- 


