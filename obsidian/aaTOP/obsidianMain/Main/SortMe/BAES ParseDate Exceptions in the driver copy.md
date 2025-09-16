# [BAES] ParseDate Exceptions in the driver copy

\[BAES\] ParseDate Exceptions in the driver

baestartSecDate Issue found when researching BUG299

test 2.2.5 Should trigger this error...
Screen clip - Slack call | TriVir Slack

![[./_resources/BAES_ParseDate_Exceptions_in_the_driver_copy.resources/ScreenClip.png]]

in this policy:
![[./_resources/BAES_ParseDate_Exceptions_in_the_driver_copy.resources/ScreenClip.1.png]]

* * *

\[10/05/18 08:02:49.874\]:service ST:              Arg Value: "".
\[10/05/18 08:02:49.874\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-SecondmentSwitch#XmlData:147]]: Couldn't convert date/time '': java.text.ParseException: Unparseable date: ""
\[10/05/18 08:02:49.875\]:service ST:            Token Value: "".
\[10/05/18 08:02:49.875\]:service ST:          Arg Value: "".
\[10/05/18 08:02:49.875\]:service ST:      Action: do-set-local-variable("baeEndDateSec",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec"))).
\[10/05/18 08:02:49.875\]:service ST:        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec")))
\[10/05/18 08:02:49.875\]:service ST:          token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec"))
\[10/05/18 08:02:49.876\]:service ST:            token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec"))
\[10/05/18 08:02:49.876\]:service ST:              token-attr("baeEndDateSec")
\[10/05/18 08:02:49.876\]:service ST:                Token Value: "".
\[10/05/18 08:02:49.876\]:service ST:              Arg Value: "".
\[10/05/18 08:02:49.876\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-SecondmentSwitch#XmlData:154]]: Couldn't convert date/time '': java.text.ParseException: Unparseable date: ""

* * *

10/5/2018
Carl resolved this on 10/5/2018 But then found other unparsable exceptions

* * *

I tried fixing this and I did it wrong:
![[./_resources/BAES_ParseDate_Exceptions_in_the_driver_copy.resources/servicedriver.zip]]

Search this log for this:
java.text.ParseException

I changed it to look for matching .\* rather than not matching ^$.
Running tests now.

* * *

\[10/08/18 11:06:03.785\]:service ST:      Action: do-if().
\[10/08/18 11:06:03.785\]:service ST:        Evaluating conditions.
\[10/08/18 11:06:03.785\]:service ST:          (if-op-attr 'baeStartDateSec' changing) = FALSE.
\[10/08/18 11:06:03.785\]:service ST:          (if-op-attr 'baeEndDateSec' changing) = FALSE.
\[10/08/18 11:06:03.786\]:service ST:    Evaluating selection criteria for rule 'Exit if none of our secondment related attributes are changing.'.
\[10/08/18 11:06:03.786\]:service ST:      (if-local-variable 'attrsChanging' not-match ".+") = FALSE.
\[10/08/18 11:06:03.786\]:service ST:    Rule rejected.
\[10/08/18 11:06:03.786\]:service ST:    Evaluating selection criteria for rule 'Secondment: prepare to check if we're on secondment or not.'.
\[10/08/18 11:06:03.786\]:service ST:    Rule selected.
\[10/08/18 11:06:03.786\]:service ST:    Applying rule 'Secondment: prepare to check if we're on secondment or not.'.
\[10/08/18 11:06:03.786\]:service ST:      Action: do-set-local-variable("now",scope="policy",token-time(format="!CTIME",tz="GMT")).
\[10/08/18 11:06:03.786\]:service ST:        arg-string(token-time(format="!CTIME",tz="GMT"))
\[10/08/18 11:06:03.786\]:service ST:          token-time(format="!CTIME",tz="GMT")
\[10/08/18 11:06:03.786\]:service ST:            Token Value: "1539018363".
\[10/08/18 11:06:03.786\]:service ST:          Arg Value: "1539018363".
\[10/08/18 11:06:03.787\]:service ST:      Action: do-if().
\[10/08/18 11:06:03.787\]:service ST:        Evaluating conditions.
\[10/08/18 11:06:03.787\]:service ST:          (if-attr 'baeStartDateSec' match ".\*") = FALSE.
\[10/08/18 11:06:03.787\]:service ST:        Performing else actions.
\[10/08/18 11:06:03.787\]:service ST:          Action: do-set-local-variable("baeStartDateSec",scope="policy","").
\[10/08/18 11:06:03.787\]:service ST:            arg-string("")
\[10/08/18 11:06:03.787\]:service ST:              Arg Value: "".
\[10/08/18 11:06:03.787\]:service ST:      Action: do-if().
\[10/08/18 11:06:03.787\]:service ST:        Evaluating conditions.
\[10/08/18 11:06:03.787\]:service ST:          (if-attr 'baeEndDateSec' match ".\*") = FALSE.
\[10/08/18 11:06:03.787\]:service ST:        Performing else actions.
\[10/08/18 11:06:03.787\]:service ST:          Action: do-set-local-variable("baeEndDateSec",scope="policy","").
\[10/08/18 11:06:03.787\]:service ST:            arg-string("")
\[10/08/18 11:06:03.788\]:service ST:              Arg Value: "".
\[10/08/18 11:06:03.788\]:service ST:      Action: do-if().
\[10/08/18 11:06:03.788\]:service ST:        Evaluating conditions.
\[10/08/18 11:06:03.788\]:service ST:          (if-xpath true "string-length($baeStartDateSec) = 0") = TRUE.
\[10/08/18 11:06:03.788\]:service ST:        Performing if actions.
\[10/08/18 11:06:03.788\]:service ST:          Action: do-trace-message(level="0","EMAIL: Secondment values appear to be changing; but we can't get a valid start date, defaulting to primary!.").
\[10/08/18 11:06:03.788\]:service ST:            arg-string("EMAIL: Secondment values appear to be changing; but we can't get a valid start date, defaulting to primary!.")
\[10/08/18 11:06:03.788\]:service ST:              token-text("EMAIL: Secondment values appear to be changing; but we can't get a valid start date, defaulting to primary!.")
\[10/08/18 11:06:03.788\]:service ST:              Arg Value: "EMAIL: Secondment values appear to be changing; but we can't get a valid start date, defaulting to primary!.".
\[10/08/18 11:06:03.789\]:service ST:EMAIL: Secondment values appear to be changing; but we can't get a valid start date, defaulting to primary!.
Worked great

* * *

* * *

* * *

* * *

* * *

* * *

**10/8/2018**
**Then I found these problems. First, just snippets of the errors:**

\[10/08/18 11:10:02.921\]:service ST:Applying policy: %+C%14C**sub-etp-RegularEmployeeFlagProcessin****g**%-C.
...Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-RegularEmployeeFlagProcessing#XmlData:40]]: Couldn't convert date/time '20020102030405Z': java.text.ParseException: Unparseable date: "20020102030405Z"

\[10/08/18 11:12:07.663\]:service ST:Applying policy: %+C%14C**sub-etp-EnforceValidUserDeletionDates**%-C.
...Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-EnforceValidUserDeletionDates#XmlData:26]]: Couldn't convert date/time '': java.text.ParseException: Unparseable date: ""

\[10/08/18 11:14:47.969\]:service ST:Applying policy: %+C%14C**sub-etp-ComputedAttributes**%-C.
...Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-ComputedAttributes#XmlData:146]]: Couldn't convert date/time '': java.text.ParseException: Unparseable date: ""

\[10/08/18 11:21:17.991\]:service ST:Applying policy: %+C%14C**sub-etp-SecondmentSwitch**%-C.
...Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-SecondmentSwitch#XmlData:154]]: Couldn't convert date/time '20150102030405Z': java.text.ParseException: Unparseable date: "20150102030405Z"

\[10/08/18 11:21:18.145\]:service ST:Applying policy: %+C%14C**sub-etp-ComputedAttributes**%-C.
...Message:  Code(-9131) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-ComputedAttributes#XmlData:114]] : Error evaluating XPATH expression 'token-xpath("es:getDaysBetween($start, $end)")' : com.novell.xml.xpath.XPathEvaluationException: Wrapped java.time.format.DateTimeParseException: Text '20150102030405Z' could not be parsed at index 0 (vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Tools#DirXML-Data#702]]).

**I break these out in full logs below**
Next problem: \[10/08/18 11:10:02.921\]:service ST:Applying policy: %+C%14C**sub-etp-RegularEmployeeFlagProcessin****g**%-C.
\[10/08/18 11:10:02.922\]:service ST:  Applying to modify #1.
\[10/08/18 11:10:02.922\]:service ST:    Evaluating selection criteria for rule 'Break now if a regular employee source flag is not changing.'.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeContractType' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeContractLength' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'Physical Delivery Office Name' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeDirectionAndControl' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeFullTimeExclusive' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeNDASigned' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeStaffingNoControl' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeStaffingNoAccess' not-changing) = TRUE.
\[10/08/18 11:10:02.922\]:service ST:      (if-op-attr 'baeLastWorkingDay' not-changing) = FALSE.
\[10/08/18 11:10:02.922\]:service ST:    Rule rejected.
\[10/08/18 11:10:02.923\]:service ST:    Evaluating selection criteria for rule 'Break now if the baeLastWorkingDay is changing to the past.'.
\[10/08/18 11:10:02.923\]:service ST:      (if-op-attr 'baeLastWorkingDay' changing-to ".+") = TRUE.
\[10/08/18 11:10:02.923\]:service ST:    Rule selected.
\[10/08/18 11:10:02.923\]:service ST:    Applying rule 'Break now if the baeLastWorkingDay is changing to the past.'.
\[10/08/18 11:10:02.923\]:service ST:      Action: do-set-local-variable("baeLastWorkingDay",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeLastWorkingDay"))).
\[10/08/18 11:10:02.923\]:service ST:        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeLastWorkingDay")))
\[10/08/18 11:10:02.923\]:service ST:          token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeLastWorkingDay"))
\[10/08/18 11:10:02.923\]:service ST:            token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeLastWorkingDay"))
\[10/08/18 11:10:02.924\]:service ST:              token-attr("baeLastWorkingDay")
\[10/08/18 11:10:02.924\]:service ST:                Token Value: "20020102030405Z".
\[10/08/18 11:10:02.924\]:service ST:              Arg Value: "20020102030405Z".
\[10/08/18 11:10:02.924\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-RegularEmployeeFlagProcessing#XmlData:40]]: Couldn't convert date/time '20020102030405Z': java.text.ParseException: Unparseable date: "20020102030405Z"

\[10/08/18 11:21:18.145\]:service ST:Applying policy: %+C%14C**sub-etp-ComputedAttributes**%-C.
\[10/08/18 11:21:18.145\]:service ST:  Applying to modify #1.
\[10/08/18 11:21:18.145\]:service ST:    Evaluating selection criteria for rule 'Break if processing is unnecessary.'.
\[10/08/18 11:21:18.145\]:service ST:      (if-op-attr 'baeCompanyStartDate' not-changing) = TRUE.
\[10/08/18 11:21:18.145\]:service ST:      (if-op-attr 'baeCompanyEndDate' not-changing) = TRUE.
\[10/08/18 11:21:18.145\]:service ST:      (if-op-attr 'baeStartDateSec' not-changing) = FALSE.
\[10/08/18 11:21:18.145\]:service ST:    Rule rejected.
\[10/08/18 11:21:18.145\]:service ST:    Evaluating selection criteria for rule 'Compute: baeContractLength: clear if start or end is empty.'.
\[10/08/18 11:21:18.145\]:service ST:      (if-op-attr 'baeCompanyStartDate' changing) = FALSE.
\[10/08/18 11:21:18.146\]:service ST:      (if-op-attr 'baeCompanyEndDate' changing) = FALSE.
\[10/08/18 11:21:18.146\]:service ST:    Rule rejected.
\[10/08/18 11:21:18.146\]:service ST:    Evaluating selection criteria for rule 'Compute: baeLengthSec: clear if start or end is empty.'.
\[10/08/18 11:21:18.146\]:service ST:      (if-op-attr 'baeStartDateSec' changing) = TRUE.
\[10/08/18 11:21:18.146\]:service ST:      (if-attr 'baeStartDateSec' not-available) = FALSE.
\[10/08/18 11:21:18.146\]:service ST:      (if-attr 'baeEndDateSec' not-available) = FALSE.
\[10/08/18 11:21:18.146\]:service ST:    Rule rejected.
\[10/08/18 11:21:18.146\]:service ST:    Evaluating selection criteria for rule 'Compute: baeContractLength: set to baeCompanyEnd - baeCompanyStart (in months)'.
\[10/08/18 11:21:18.146\]:service ST:      (if-op-attr 'baeCompanyStartDate' changing) = FALSE.
\[10/08/18 11:21:18.146\]:service ST:      (if-op-attr 'baeCompanyEndDate' changing) = FALSE.
\[10/08/18 11:21:18.146\]:service ST:    Rule rejected.
\[10/08/18 11:21:18.146\]:service ST:    Evaluating selection criteria for rule 'Compute: baeLengthSec: set to baeEndDateSec - baeStartDateSec (in months)'.
\[10/08/18 11:21:18.147\]:service ST:      (if-op-attr 'baeStartDateSec' changing) = TRUE.
\[10/08/18 11:21:18.147\]:service ST:    Rule selected.
\[10/08/18 11:21:18.147\]:service ST:    Applying rule 'Compute: baeLengthSec: set to baeEndDateSec - baeStartDateSec (in months)'.
\[10/08/18 11:21:18.147\]:service ST:      Action: do-set-local-variable("start",scope="policy",token-attr("baeStartDateSec")).
\[10/08/18 11:21:18.147\]:service ST:        arg-string(token-attr("baeStartDateSec"))
\[10/08/18 11:21:18.147\]:service ST:          token-attr("baeStartDateSec")
\[10/08/18 11:21:18.147\]:service ST:            Token Value: "20150102030405Z".
\[10/08/18 11:21:18.147\]:service ST:          Arg Value: "20150102030405Z".
\[10/08/18 11:21:18.147\]:service ST:      Action: do-set-local-variable("end",scope="policy",token-attr("baeEndDateSec")).
\[10/08/18 11:21:18.147\]:service ST:        arg-string(token-attr("baeEndDateSec"))
\[10/08/18 11:21:18.147\]:service ST:          token-attr("baeEndDateSec")
\[10/08/18 11:21:18.148\]:service ST:            Token Value: "20200102030405Z".
\[10/08/18 11:21:18.148\]:service ST:          Arg Value: "20200102030405Z".
\[10/08/18 11:21:18.148\]:service ST:      Action: do-set-src-attr-value("baeLengthSec",class-name="User",token-xpath("es:getDaysBetween($start, $end)")).
\[10/08/18 11:21:18.148\]:service ST:        arg-string(token-xpath("es:getDaysBetween($start, $end)"))
\[10/08/18 11:21:18.148\]:service ST:          token-xpath("es:getDaysBetween($start, $end)")
\[10/08/18 11:21:18.148\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Error
     Message:  Code(-9131) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-ComputedAttributes#XmlData:114]] : Error evaluating XPATH expression 'token-xpath("es:getDaysBetween($start, $end)")' : com.novell.xml.xpath.XPathEvaluationException: Wrapped java.time.format.DateTimeParseException: Text '20150102030405Z' could not be parsed at index 0 (vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Tools#DirXML-Data#702]]).
\[10/08/18 11:21:18.153\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Error
     Message:  Code(-9083) Error submitting event to subscriber: Code(-9131) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-ComputedAttributes#XmlData:114]] : Error evaluating XPATH expression 'token-xpath("es:getDaysBetween($start, $end)")' : com.novell.xml.xpath.XPathEvaluationException: Wrapped java.time.format.DateTimeParseException: Text '20150102030405Z' could not be parsed at index 0 (vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Tools#DirXML-Data#702]]).

\[10/08/18 11:21:17.991\]:service ST:Applying policy: %+C%14C**sub-etp-SecondmentSwitch**%-C.
...\[10/08/18 11:21:18.029\]:service ST:    Applying rule 'Secondment: prepare to check if we're on secondment or not.'.
\[10/08/18 11:21:18.029\]:service ST:      Action: do-set-local-variable("now",scope="policy",token-time(format="!CTIME",tz="GMT")).
\[10/08/18 11:21:18.029\]:service ST:        arg-string(token-time(format="!CTIME",tz="GMT"))
\[10/08/18 11:21:18.029\]:service ST:          token-time(format="!CTIME",tz="GMT")
\[10/08/18 11:21:18.029\]:service ST:            Token Value: "1539019278".
\[10/08/18 11:21:18.030\]:service ST:          Arg Value: "1539019278".
\[10/08/18 11:21:18.030\]:service ST:      Action: do-if().
\[10/08/18 11:21:18.030\]:service ST:        Evaluating conditions.
\[10/08/18 11:21:18.030\]:service ST:          (if-attr 'baeStartDateSec' match ".\*") = TRUE.
\[10/08/18 11:21:18.030\]:service ST:        Performing if actions.
\[10/08/18 11:21:18.030\]:service ST:          Action: do-set-local-variable("baeStartDateSec",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeStartDateSec"))).
\[10/08/18 11:21:18.030\]:service ST:            arg-string(token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeStartDateSec")))
\[10/08/18 11:21:18.031\]:service ST:              token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeStartDateSec"))
\[10/08/18 11:21:18.031\]:service ST:                token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeStartDateSec"))
\[10/08/18 11:21:18.031\]:service ST:                  token-attr("baeStartDateSec")
\[10/08/18 11:21:18.031\]:service ST:                    Token Value: "20150102030405Z".
\[10/08/18 11:21:18.031\]:service ST:                  Arg Value: "20150102030405Z".
\[10/08/18 11:21:18.032\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-SecondmentSwitch#XmlData:154]]: Couldn't convert date/time '20150102030405Z': java.text.ParseException: Unparseable date: "20150102030405Z"
\[10/08/18 11:21:18.032\]:service ST:                Token Value: "20150102030405Z".
\[10/08/18 11:21:18.032\]:service ST:              Arg Value: "20150102030405Z".
\[10/08/18 11:21:18.032\]:service ST:      Action: do-if().
\[10/08/18 11:21:18.032\]:service ST:        Evaluating conditions.
\[10/08/18 11:21:18.033\]:service ST:          (if-attr 'baeEndDateSec' match ".\*") = TRUE.
\[10/08/18 11:21:18.033\]:service ST:        Performing if actions.
\[10/08/18 11:21:18.033\]:service ST:          Action: do-set-local-variable("baeEndDateSec",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec"))).
\[10/08/18 11:21:18.033\]:service ST:            arg-string(token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec")))
\[10/08/18 11:21:18.033\]:service ST:              token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec"))
\[10/08/18 11:21:18.033\]:service ST:                token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeEndDateSec"))
\[10/08/18 11:21:18.033\]:service ST:                  token-attr("baeEndDateSec")
\[10/08/18 11:21:18.034\]:service ST:                    Token Value: "20200102030405Z".
\[10/08/18 11:21:18.034\]:service ST:                  Arg Value: "20200102030405Z".
\[10/08/18 11:21:18.034\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-SecondmentSwitch#XmlData:175]]: Couldn't convert date/time '20200102030405Z': java.text.ParseException: Unparseable date: "20200102030405Z"
\[10/08/18 11:21:18.034\]:service ST:                Token Value: "20200102030405Z".
\[10/08/18 11:21:18.034\]:service ST:              Arg Value: "20200102030405Z".
\[10/08/18 11:21:18.035\]:service ST:      Action: do-if().

\[10/08/18 11:14:47.969\]:service ST:Applying policy: %+C%14C**sub-etp-ComputedAttributes**%-C.
...\[10/08/18 11:14:47.977\]:service ST:    Applying rule 'Compute: baeLevelOfECTraining, baeTrainingLastCompleted.'.
\[10/08/18 11:14:47.977\]:service ST:      Action: do-clear-src-attr-value("baeLevelOfECTraining",class-name="User").
\[10/08/18 11:14:47.977\]:service ST:      Action: do-clear-src-attr-value("baeTrainingLastCompleted",class-name="User").
\[10/08/18 11:14:47.977\]:service ST:      Action: do-set-local-variable("lv-awareness-date",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingAwarenessCompleted"))).
\[10/08/18 11:14:47.978\]:service ST:        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingAwarenessCompleted")))
\[10/08/18 11:14:47.978\]:service ST:          token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingAwarenessCompleted"))
\[10/08/18 11:14:47.978\]:service ST:            token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingAwarenessCompleted"))
\[10/08/18 11:14:47.979\]:service ST:              token-attr("baeTrainingAwarenessCompleted")
\[10/08/18 11:14:47.979\]:service ST:                Token Value: "2018-10-07".
\[10/08/18 11:14:47.979\]:service ST:              Arg Value: "2018-10-07".
\[10/08/18 11:14:47.979\]:service ST:            Token Value: "1538892000".
\[10/08/18 11:14:47.979\]:service ST:          Arg Value: "1538892000".
\[10/08/18 11:14:47.979\]:service ST:      Action: do-set-local-variable("lv-enhanced-date",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingEnhancedCompleted"))).
\[10/08/18 11:14:47.980\]:service ST:        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingEnhancedCompleted")))
\[10/08/18 11:14:47.980\]:service ST:          token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingEnhancedCompleted"))
\[10/08/18 11:14:47.980\]:service ST:            token-convert-time(dest-format="!CTIME",dest-tz="UTC",src-format="yyyy-MM-dd",token-attr("baeTrainingEnhancedCompleted"))
\[10/08/18 11:14:47.980\]:service ST:              token-attr("baeTrainingEnhancedCompleted")
\[10/08/18 11:14:47.981\]:service ST:                Query from policy
\[10/08/18 11:14:47.981\]:service ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.6.2.0">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="User" dest-dn="\\TRIVIRBAES\\BAES\\Users\\idmunitUKB79999999" dest-entry-id="66394" scope="entry">
    </query>
  </input>
</nds>
\[10/08/18 11:14:47.981\]:service ST:                Pumping XDS to eDirectory.
\[10/08/18 11:14:47.982\]:service ST:                Performing operation query for \\TRIVIRBAES\\BAES\\Users\\idmunitUKB79999999.
\[10/08/18 11:14:47.982\]:service ST:                --JCLNT-- \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver : Duplicating : context = 1200357472, tempContext = 1200357550
\[10/08/18 11:14:47.983\]:service ST:                --JCLNT-- \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver : Calling free on tempContext = 1200357550
\[10/08/18 11:14:47.983\]:service ST:                Query from policy result
\[10/08/18 11:14:47.983\]:service ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.6.2.0">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <instance class-name="User" qualified-src-dn="O=BAES\\OU=Users\\CN=idmunitUKB79999999" src-dn="\\TRIVIRBAES\\BAES\\Users\\idmunitUKB79999999" src-entry-id="66394">
      <attr attr-name="baeCompanyEndDate">
        <value timestamp="1539018887#57" type="string">2018-12-31</value>
      </attr>
      <attr attr-name="baeCompanyStartDate">
        <value timestamp="1539018887#46" type="string">2001-01-01</value>
      </attr>
      <attr attr-name="baeEndDateSec">
        <value timestamp="1539018887#65" type="string">2003-12-31</value>
      </attr>
      <attr attr-name="baeStartDateSec">
        <value timestamp="1539018887#16" type="string">2002-01-01</value>
      </attr>
      <attr attr-name="baeTrainingAwarenessCompleted">
        <value timestamp="1539018887#45" type="string">2018-10-07</value>
      </attr>
    </instance>
    <status level="success"></status>
  </output>
</nds>
\[10/08/18 11:14:47.985\]:service ST:                Token Value: "".
\[10/08/18 11:14:47.985\]:service ST:              Arg Value: "".
\[10/08/18 11:14:47.985\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-ComputedAttributes#XmlData:146]]: Couldn't convert date/time '': java.text.ParseException: Unparseable date: ""
\[10/08/18 11:14:47.985\]:service ST:            Token Value: "".
\[10/08/18 11:14:47.986\]:service ST:          Arg Value: "".

\[10/08/18 11:12:07.663\]:service ST:Applying policy: %+C%14C**sub-etp-EnforceValidUserDeletionDates**%-C.
\[10/08/18 11:12:07.664\]:service ST:  Applying to modify #1.
\[10/08/18 11:12:07.664\]:service ST:    Evaluating selection criteria for rule 'Break if baeUserDeletionDate isn't changing.'.
\[10/08/18 11:12:07.664\]:service ST:      (if-op-attr 'baeUserDeletionDate' not-changing) = FALSE.
\[10/08/18 11:12:07.664\]:service ST:    Rule rejected.
\[10/08/18 11:12:07.664\]:service ST:    Evaluating selection criteria for rule 'baeUserDeletionDate: Set variables.'.
\[10/08/18 11:12:07.664\]:service ST:    Rule selected.
\[10/08/18 11:12:07.664\]:service ST:    Applying rule 'baeUserDeletionDate: Set variables.'.
\[10/08/18 11:12:07.664\]:service ST:      Action: do-set-local-variable("deleteDate",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-op-attr("baeUserDeletionDate"))).
\[10/08/18 11:12:07.664\]:service ST:        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-op-attr("baeUserDeletionDate")))
\[10/08/18 11:12:07.665\]:service ST:          token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-op-attr("baeUserDeletionDate"))
\[10/08/18 11:12:07.665\]:service ST:            token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-op-attr("baeUserDeletionDate"))
\[10/08/18 11:12:07.665\]:service ST:              token-op-attr("baeUserDeletionDate")
\[10/08/18 11:12:07.665\]:service ST:                Token Value: "2013-01-02".
\[10/08/18 11:12:07.665\]:service ST:              Arg Value: "2013-01-02".
\[10/08/18 11:12:07.665\]:service ST:            Token Value: "1357084800".
\[10/08/18 11:12:07.665\]:service ST:          Arg Value: "1357084800".
\[10/08/18 11:12:07.665\]:service ST:      Action: do-set-local-variable("deleteDateMax",scope="policy",token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeUserMaximumDeletionDate"))).
\[10/08/18 11:12:07.666\]:service ST:        arg-string(token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeUserMaximumDeletionDate")))
\[10/08/18 11:12:07.666\]:service ST:          token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeUserMaximumDeletionDate"))
\[10/08/18 11:12:07.666\]:service ST:            token-convert-time(dest-format="!CTIME",dest-tz="GMT",src-format="yyyy-MM-dd",src-tz="GMT",token-attr("baeUserMaximumDeletionDate"))
\[10/08/18 11:12:07.666\]:service ST:              token-attr("baeUserMaximumDeletionDate")
\[10/08/18 11:12:07.667\]:service ST:                Query from policy
\[10/08/18 11:12:07.667\]:service ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.6.2.0">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <input>
    <query class-name="User" dest-dn="\\TRIVIRBAES\\BAES\\Users\\idmunitUKB90000053" dest-entry-id="66382" scope="entry">
    </query>
  </input>
</nds>
\[10/08/18 11:12:07.668\]:service ST:                Pumping XDS to eDirectory.
\[10/08/18 11:12:07.668\]:service ST:                Performing operation query for \\TRIVIRBAES\\BAES\\Users\\idmunitUKB90000053.
\[10/08/18 11:12:07.668\]:service ST:                --JCLNT-- \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver : Duplicating : context = 1200357472, tempContext = 1200357546
\[10/08/18 11:12:07.669\]:service ST:                --JCLNT-- \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver : Calling free on tempContext = 1200357546
\[10/08/18 11:12:07.669\]:service ST:                Query from policy result
\[10/08/18 11:12:07.669\]:service ST:
<nds dtdversion="4.0" ndsversion="8.x">
  <source>
    <product edition="Advanced" version="4.6.2.0">DirXML</product>
    <contact>NetIQ Corporation</contact>
  </source>
  <output>
    <status level="success"></status>
  </output>
</nds>
\[10/08/18 11:12:07.670\]:service ST:                Token Value: "".
\[10/08/18 11:12:07.670\]:service ST:              Arg Value: "".
\[10/08/18 11:12:07.670\]:service ST:
DirXML Log Event -------------------
     Driver:   \\TRIVIRBAES\\services\\IDM\\Driver set\\Service-Driver
     Channel:  Subscriber
     Status:   Warning
     Message:  Code(-8033) Error in vnd.nds.[[stream://TRIVIRBAES/services/IDM/Driver+set/Service-Driver/Subscriber/sub-etp-EnforceValidUserDeletionDates#XmlData:26]]: Couldn't convert date/time '': java.text.ParseException: Unparseable date: ""
