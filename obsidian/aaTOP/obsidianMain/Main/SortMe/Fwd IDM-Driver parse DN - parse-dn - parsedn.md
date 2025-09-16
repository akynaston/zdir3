# Fwd: [IDM-Driver] parse DN - parse-dn - parsedn

\>>> Carl Kynaston <carlkynaston@gmail.com> 3/17/2014 1:30 PM >>>
\[IDM-Driver\] parse DN - parse-dn - parsedn

These are a few notes I typed up while experimenting with ParseDN/SourceDN. I think the most valuable part is all the examples. I am still not sure I understand how all this works yet, but I do know better how to get what I want with these.

You start at a start position. Then when you put a minus, it doesn't minus from the end, it starts going backwards from the current courser.

\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110 \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_
     0           1          2           3        4            5                       6                7                8            END OF LINE (-1 when starting at 0)
    -9          -8         -7         -6       -5           -4                     -3               -2               -1                                         

Start->Length
0->-1 is this whole string. Since 0-1 is -1 so we end at the -1 spot.
0->-2 is the string minus the CN. 0-2 = -2 so we end at the -2 spot.
1->-1 starts at com, goes back one, and doesn't arrive at the CN, so it is this whole string again.  1-1=0, so we didn't define an ending value.
1->-2 starts at com, goes back two, and doesn't arrive at the CN, so it is this whole string again. 1-2 is -1 so we end at the CN.
2->-3 starts at baesystems. 2-3 = -1 so we end on the -1 spot, the CN.

\-1->0 gets nothing
\-1->1 gets just the CN
\-1->-1 gets just the CN

\[07/05/13 11:02:37.198\]:GlobalAD ST:SRC DN 0 -> -1: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.198\]:GlobalAD ST:SRC DN 1 -> -1:                com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 2 -> -1:                       baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 2 -> -2:                       baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 0 -> -1: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 0 -> -2: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1                         \*\*\*\*\* Notice the CN is stripped with -2.
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 0 -> -3: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 1 -> -2:                com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:PARSDN 1 -> -2:               com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 2 -> -2:                       baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.230\]:GlobalAD ST:SRC DN 1 -> -3:                 com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1                        \*\*\*\*\* Notice the CN is stripped with -3, since we started at 1.
\[07/05/13 11:08:06.801\]:GlobalAD ST:SRC DN 2 -> -3: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110

07/05/13 11:02:37.198\]:GlobalAD ST:      Action: do-set-local-variable("IDVContainer",scope="policy",token-src-dn(convert="true",length="-2",start="1")).
\[07/05/13 11:02:37.198\]:GlobalAD ST:        arg-string(token-src-dn(convert="true",length="-2",start="1"))
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-src-dn(convert="true",length="-2",start="1")
\[07/05/13 11:02:37.198\]:GlobalAD ST:            Token Value: "CN=joseph.black110,OU=US\_AD1,OU=United\_States,O=BAE\_Systems,dc=baeo365d,dc=us,dc=baesystems,dc=com".
\[07/05/13 11:02:37.198\]:GlobalAD ST:          Arg Value: "CN=joseph.black110,OU=US\_AD1,OU=United\_States,O=BAE\_Systems,dc=baeo365d,dc=us,dc=baesystems,dc=com".
\[07/05/13 11:02:37.198\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 0 -> -1: "+token-src-dn()).
\[07/05/13 11:02:37.198\]:GlobalAD ST:        arg-string("SRC DN 0 -> -1: "+token-src-dn())
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-text("SRC DN 0 -> -1: ")
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-src-dn()
\[07/05/13 11:02:37.198\]:GlobalAD ST:            Token Value: "\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.198\]:GlobalAD ST:          Arg Value: "SRC DN 0 -> -1: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.198\]:GlobalAD ST:SRC DN 0 -> -1: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.198\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 1 -> -1: "+token-src-dn(start="1")).
\[07/05/13 11:02:37.198\]:GlobalAD ST:        arg-string("SRC DN 1 -> -1: "+token-src-dn(start="1"))
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-text("SRC DN 1 -> -1: ")
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-src-dn(start="1")
\[07/05/13 11:02:37.198\]:GlobalAD ST:            Token Value: "com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.198\]:GlobalAD ST:          Arg Value: "SRC DN 1 -> -1: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.198\]:GlobalAD ST:SRC DN 1 -> -1: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.198\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 2 -> -1: "+token-src-dn(start="2")).
\[07/05/13 11:02:37.198\]:GlobalAD ST:        arg-string("SRC DN 2 -> -1: "+token-src-dn(start="2"))
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-text("SRC DN 2 -> -1: ")
\[07/05/13 11:02:37.198\]:GlobalAD ST:          token-src-dn(start="2")
\[07/05/13 11:02:37.198\]:GlobalAD ST:            Token Value: "baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 2 -> -1: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 2 -> -1: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 2 -> -2: "+token-src-dn(length="-2",start="2")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 2 -> -2: "+token-src-dn(length="-2",start="2"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 2 -> -2: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(length="-2",start="2")
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 2 -> -2: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 2 -> -2: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 0 -> -1: "+token-src-dn(start="0")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 0 -> -1: "+token-src-dn(start="0"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 0 -> -1: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(start="0")
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 0 -> -1: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 0 -> -1: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 0 -> -2: "+token-src-dn(length="-2",start="0")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 0 -> -2: "+token-src-dn(length="-2",start="0"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 0 -> -2: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(length="-2",start="0")
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 0 -> -2: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 0 -> -2: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 0 -> -3: "+token-src-dn(length="-3",start="0")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 0 -> -3: "+token-src-dn(length="-3",start="0"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 0 -> -3: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(length="-3",start="0")
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 0 -> -3: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 0 -> -3: \\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 1 -> -2: "+token-src-dn(length="-2",start="1")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 1 -> -2: "+token-src-dn(length="-2",start="1"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 1 -> -2: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(length="-2",start="1")
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 1 -> -2: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 1 -> -2: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","PARSDN 1 -> -2: "+token-parse-dn(dest-dn-format="src-dn",length="-2",start="1",token-src-dn())).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("PARSDN 1 -> -2: "+token-parse-dn(dest-dn-format="src-dn",length="-2",start="1",token-src-dn()))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("PARSDN 1 -> -2: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-parse-dn(dest-dn-format="src-dn",length="-2",start="1",token-src-dn())
\[07/05/13 11:02:37.214\]:GlobalAD ST:            token-parse-dn(dest-dn-format="src-dn",length="-2",start="1",token-src-dn())
\[07/05/13 11:02:37.214\]:GlobalAD ST:              token-src-dn()
\[07/05/13 11:02:37.214\]:GlobalAD ST:                Token Value: "\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:              Arg Value: "\\BAETREE\\com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "PARSDN 1 -> -2: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:PARSDN 1 -> -2: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 2 -> -2: "+token-src-dn(length="-2",start="2")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 2 -> -2: "+token-src-dn(length="-2",start="2"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 2 -> -2: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(length="-2",start="2")
\[07/05/13 11:02:37.214\]:GlobalAD ST:            Token Value: "baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:          Arg Value: "SRC DN 2 -> -2: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:02:37.214\]:GlobalAD ST:SRC DN 2 -> -2: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110
\[07/05/13 11:02:37.214\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 1 -> -3: "+token-src-dn(length="-3",start="1")).
\[07/05/13 11:02:37.214\]:GlobalAD ST:        arg-string("SRC DN 1 -> -3: "+token-src-dn(length="-3",start="1"))
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-text("SRC DN 1 -> -3: ")
\[07/05/13 11:02:37.214\]:GlobalAD ST:          token-src-dn(length="-3",start="1")
\[07/05/13 11:02:37.230\]:GlobalAD ST:            Token Value: "com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1".
\[07/05/13 11:02:37.230\]:GlobalAD ST:          Arg Value: "SRC DN 1 -> -3: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1".
\[07/05/13 11:02:37.230\]:GlobalAD ST:SRC DN 1 -> -3: com\\baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1
\[07/05/13 11:08:06.801\]:GlobalAD ST:      Action: do-trace-message(level="6","SRC DN 2 -> -3: "+token-src-dn(length="-3",start="2")).
\[07/05/13 11:08:06.801\]:GlobalAD ST:        arg-string("SRC DN 2 -> -3: "+token-src-dn(length="-3",start="2"))
\[07/05/13 11:08:06.801\]:GlobalAD ST:          token-text("SRC DN 2 -> -3: ")
\[07/05/13 11:08:06.801\]:GlobalAD ST:          token-src-dn(length="-3",start="2")
\[07/05/13 11:08:06.801\]:GlobalAD ST:            Token Value: "baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:08:06.801\]:GlobalAD ST:          Arg Value: "SRC DN 2 -> -3: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110".
\[07/05/13 11:08:06.801\]:GlobalAD ST:SRC DN 2 -> -3: baesystems\\us\\baeo365d\\BAE\_Systems\\United\_States\\US\_AD1\\joseph.black110

CN=S-Kynaston\\, Tilley,OU=testusers,DC=trivirdev,DC=com

\----- Just the CN -----
Start -1
Length -1
     CN=S-Kynaston\\, Tilley,

\----- Just the parent container including tree-----
Start: 0
Length: -2

OU=testusers,DC=trivirdev,DC=com

\-----Grabbed everything but the end of the DN-----
Start 1
Lenght -1
     CN=S-Kynaston\\, Tilley,OU=testusers,DC=trivirdev

Start

Specify the RDN index to start with:

		Index 0 is the root-most RDN
	

		Positive indexes are an offset from the root-most RDN
	
		Index -1 is the leaf-most segment
	
		Negative indexes are an offset from the leaf-most RDN towards the root-most RDN
	

Length

Number of RDN segments to include. Negative numbers are interpreted as (total # of segments + length) + 1. For example, for a DN with 5 segments a length of -1 = (5 + (-1)) + 1 = 5, -2 = (5 + (-2)) + 1 = 4, etc.

Source DN Format

Specifies the format used to parse the source DN.

Destination DN Format

Specify the format used to output the parsed DN.

Source DN Delimiter

Specify the custom source DN delimiter set if Source DN Format is set to custom.

Destination DN Delimiter

Specify the custom destination DN delimiter set if Destination DN Format is set to custom.

## Examples of using the ParseDN Token in Identity Manager

### Author Info

9 July 2008 - 12:33pm
Submitted by: [geoffc](http://www.novell.com/communities/user/555)

[Author Blog](http://www.novell.com/communities/blog/555)
[Author Profile](http://www.novell.com/communities/user/555)

### Tags

[DirXML](http://www.novell.com/communities/taxonomy/term/6) [eDirectory](http://www.novell.com/communities/taxonomy/term/7) [Identity Manager](http://www.novell.com/communities/taxonomy/term/11) [Identity Manager 3.5](http://www.novell.com/communities/taxonomy/term/3422)
[Tags Map](http://www.novell.com/communities/site-tags)

[_(View Disclaimer)_](http://www.novell.com/communities/node/5687/examples-using-parsedn-token-identity-manager#disclaimer)

Novell Identity Manager has a number of very powerful verbs, nouns, and tokens. One that I use a lot, but drives me mad on a regular basis is ParseDN.

Watch out for known limitations, as described at:[http://www.novell.com/communities/node/4337/ parsedn-token-identity-manager-and-some-its-limitations](http://www.novell.com/communities/node/4337/parsedn-token-identity-manager-and-some-its-limitations).

ParseDN is pretty powerful and cool, but as described in the article above, it can only do what it can with the available data. (The issue above relates to [LDAP](http://www.novell.com/communities/zh-hans/glossary/term/1613)naming, when the data about whether each node is a CN=, OU=, C=, DC=, or the like is not available. If it is not in the attribute you are using the token on, it cannot, alas, magically figure it out for you. I had so hoped it would somehow magically calculate the full LDAP DN, but that was not to be.)

The thing is, the help in Designer (at least last I looked in the 3.0 beta 1 build) tries to explain the token, but could really use some better examples. Thus I thought I would try and provide some of the most common ones I use.

All my examples are going to work with DN's in the format Identity Manager uses internally. That is, a DN that would look like \\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH. In this example, the LDAP name might be CN=BSMITH,OU=ACTIVE,OU=USERS,O=LAB,T=ACME-TREE or somesuch. But for now, I will use the backslash format to explain it. The root most node, regardless of how you look at (IDM internal, or LDAP) is the ACME-TREE node, since it is closest to the root of the tree. (Ok, so it IS actually the tree name, hard to get closer to root than that, right?).

Leaf most node is the one farthest from the root, in our examples BSMITH (or CN=BSMITH in LDAP [namespace](http://www.novell.com/communities/zh-hans/glossary/term/827)).

The most common issue I use ParseDN for is changing the length of the DN. Usually I want to do one of three things. Chop off the tree name (root most node), chop off the BSMITH node (leaf most node) to get the parent container of the object, or just get the name of the object, without any of the path.

You have two controls, Start and Length.

Start is pretty easy. A start value of zero (0) means start at the beginning of the DN, which is root most. Where it gets kind of interesting, is working the other way, -1 means start at the leaf most node. So -2 would be start one node from the leaf most end.

Length is easy at first, a positive integer means go that number of nodes.

Negative one (-1), means go to the end of the nodes (leaf most). Negative 2 (-2) means go to one node before the leaf most node.

For the examples above, I would set the following values:

Chop off tree name:
Start: 1 (skip the first node)
Length: -1 (go to the end)

\\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become \\LAB\\USERS\\ACTIVE\\BSMITH

Chop off last node: (Get the parent container)
Start: 0 (start at the beginning)
Length: -2 (go to one before the end)

\\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become \\ACME-TREE\\LAB\\USERS\\ACTIVE\\

Get the name of the object:
Start: -1
Length: 1

\\ACME-TREE\\LAB\\USERS\\ACTIVE\\BSMITH would become BSMITH

It is worth noting that the Source DN() token and the Destination DN() token in Argument Builder both have the ability to specify these length and start values in a similar fashion. What ParseDN brings to the table that is additional, is conversion between formats (source, destination, LDAP (with the limits noted above), and others that you can define)

One trick to be careful of that I have noticed, is that trying to combine length changes in one move, can be fraught with peril. That is, trying to get the middle set of nodes can be tricky.

In principle to get the middle bits of a DN path, i.e. the part without the [end node](http://www.novell.com/communities/zh-hans/glossary/term/1342)and without the tree name, you should be able to:

Start: 1
Length: -2

But in practice I have had a hard time doing this. What I mean by that is, it just does not work reliably. I am not sure why exactly. What I found works the best when you run into an issue like this one is to chop of the end (leaf most) node first, either as part of the Source DN token, (which as I mentioned above can do some of ParseDN's cool stuff) with a length of -1 and a start of 1, and the nest that under a ParseDN token to chop off the tree name.

Often I have the value of the DN stored as string in some other attribute, or it is coming from an object that is not actually the current operational object, or from somewhere else, where I cannot use the Source DN or Destination DN tokens.

One common example of that would be from the XPATH of @src-dn from the results of a query for an object as is discussed in the middle of this article at:<http://www.novell.com/communities/node/4833/some-thoughts-xpath-novell-identity-manager>

The issue is that if you want to use the Query token to find the a user in either the source or destination data store, that while it is quite powerful, there is no direct way to get the [distinguished name](http://www.novell.com/communities/zh-hans/glossary/term/552) of the object you are looking for. You would think, based on Argument Builders interface, that you could Query for the SourceDN token, but alas that does not work. In fact, the attribute you would want to return is called DN, but it is not a real attribute in the usual sense, so you cannot return it directly.

Instead what you need to do is query for the object you want, as appropriate, and get a nodeset value back. Part of the reason it is not so simple to do is that you could end up with a single or multiple results. In any case, you need to then use an XPATH expression of @src-dn to get the value out. The most common way is to set a local variable, as a nodeset. The value set into the local variable is a Query token for the object you are looking for. Then in the next action, set a local variable of type string, equal to the XPATH expression. Something like the following rule:

<do-set-local-variable name="SOURCE-DN" scope="policy">
        <arg-node-set>
                <token-query datastore="src">
                        <arg-dn>
                                <token-global-variable name="eDirUserContainer"/>
                        </arg-dn>
                        <arg-match-attr name="workforceID"/>
                        <arg-string>
                                <token-text xml:space="preserve">Object Class</token-text>
                        </arg-string>
                </token-query>
                </arg-node-set>
</do-set-local-variable>
<do-set-local-variable name="SOURCE-DN" scope="policy">
        <arg-string>
                <token-xpath expression="$SOURCE-DN/@src-dn"/>
        </arg-string>
</do-set-local-variable>

In this example, we generate a Query against the source datasource (so depending on your channel (subscriber or publisher) it could be either [eDirectory](http://www.novell.com/communities/zh-hans/glossary/term/3276)of the application, for a user with the current value of workforceID.

I like to scope things so that we only search from the container I know users are stored in, in this case defined by a Global Configuration Variable called eDirUserContainer. I really like scoping my searches, since sometimes the trees can be very large, and unconstrained searches can do a lot of extra work.

Now one of the tricks is ask for the return of an attribute you know will ALWAY be there on an object, If you think about it, Object Class is implicitly a mandatory attribute. Actually it is an explicitly mandatory attribute of the Top class, which every[object class](http://www.novell.com/communities/zh-hans/glossary/term/1955) in the tree inherits from. Anyway, every object in the tree has Object Class defined, even if it is set to Unknown. Of course, in this case, you could probably also ask it to return the attribute you searched on, workforceID since if it is found, it must have it by definition.

Then once we have it set, note that the first SOURCE-DN is set as a nodeset variable, not a string, we use a second set local variable action to set the same variable name SOURCE-DN as a string, to the XPATH of $SOURCE-DN/@src-dn The $SOURCE-DN is how you represent the variable (with a leading dollar sign ($)) and then in the context of that variable get the attribute (the at sign (@)) src-dn.

If you need to ParseDN this to LDAP syntax, then you probably want to grab the attribute @qualified-src-dn instead which would look more like CN=BSMITH.OU=ACTIVE.OU=USERS.O=LAB.T=ACME-TREE. Which as discussed above can be ParseDN'ed into real LDAP syntax (which alas means mostly swapping periods with commas.)

If you have an expectation of returning more than one value in your search (I hope not for workforceID, one hopes that is unique in your tree), then you should probably iterate through the values returned inside a for-each loop, and get the value of each object returned. Otherwise you will only get the value from the first one, which may or may not be the one you want. You can always test to see how many values got returned by using an XPATH of something like count($SOURCE-DN) to get the number of nodes in the returned document, and if it is greater than 1, you may have a problem.

Whoever thought getting the distinguished name of an object could be so complex? (Wait till you try and get the DN of an object very soon after a move operation happened, and then see how much fun that can be! You often get two values returned, the old and the new, depending on when you query it).

Evernote helps you remember everything and get organized effortlessly. [Download Evernote](https://www.evernote.com/getit?email_name=emailNote&email_guid=30988f32-41c1-401f-866b-4ba6f68a51c9&email_link=download_app).
