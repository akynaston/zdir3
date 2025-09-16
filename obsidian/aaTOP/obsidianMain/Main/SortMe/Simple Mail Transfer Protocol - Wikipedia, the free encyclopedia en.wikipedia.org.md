# Simple Mail Transfer Protocol - Wikipedia, the free encyclopedia [en.wikipedia.org]

# Simple Mail Transfer Protocol

From Wikipedia, the free encyclopedia

Jump to: [navigation](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#mw-head), [search](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#p-search)

This article is about the Internet standard for electronic mail transmission. For the email delivery company, see [SMTP (company)](http://en.wikipedia.org/wiki/SMTP_(company)).

| [Internet protocol suite](http://en.wikipedia.org/wiki/Internet_protocol_suite) |
| --- |
| [Application layer](http://en.wikipedia.org/wiki/Application_layer) |
| * [DHCP](http://en.wikipedia.org/wiki/Dynamic_Host_Configuration_Protocol)<br>* [DHCPv6](http://en.wikipedia.org/wiki/DHCPv6)<br>* [DNS](http://en.wikipedia.org/wiki/Domain_Name_System)<br>* [FTP](http://en.wikipedia.org/wiki/File_Transfer_Protocol)<br>* [HTTP](http://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol)<br>* [IMAP](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol)<br>* [IRC](http://en.wikipedia.org/wiki/Internet_Relay_Chat)<br>* [LDAP](http://en.wikipedia.org/wiki/Lightweight_Directory_Access_Protocol)<br>* [MGCP](http://en.wikipedia.org/wiki/Media_Gateway_Control_Protocol_(MGCP))<br>* [NNTP](http://en.wikipedia.org/wiki/Network_News_Transfer_Protocol)<br>* [BGP](http://en.wikipedia.org/wiki/Border_Gateway_Protocol)<br>* [NTP](http://en.wikipedia.org/wiki/Network_Time_Protocol)<br>* [POP](http://en.wikipedia.org/wiki/Post_Office_Protocol)<br>* [RPC](http://en.wikipedia.org/wiki/Remote_procedure_call)<br>* [RTP](http://en.wikipedia.org/wiki/Real-time_Transport_Protocol)<br>* [RTSP](http://en.wikipedia.org/wiki/Real_Time_Streaming_Protocol)<br>* [SIP](http://en.wikipedia.org/wiki/Session_Initiation_Protocol)<br>* **SMTP**<br>* [SNMP](http://en.wikipedia.org/wiki/Simple_Network_Management_Protocol)<br>* [SOCKS](http://en.wikipedia.org/wiki/SOCKS)<br>* [SSH](http://en.wikipedia.org/wiki/Secure_Shell)<br>* [Telnet](http://en.wikipedia.org/wiki/Telnet)<br>* [TLS/SSL](http://en.wikipedia.org/wiki/Transport_Layer_Security)<br>* [XMPP](http://en.wikipedia.org/wiki/Extensible_Messaging_and_Presence_Protocol)<br>* [(more)](http://en.wikipedia.org/wiki/Category:Application_layer_protocols) |
| [Transport layer](http://en.wikipedia.org/wiki/Transport_layer) |
| * [TCP](http://en.wikipedia.org/wiki/Transmission_Control_Protocol)<br>* [UDP](http://en.wikipedia.org/wiki/User_Datagram_Protocol)<br>* [DCCP](http://en.wikipedia.org/wiki/Datagram_Congestion_Control_Protocol)<br>* [SCTP](http://en.wikipedia.org/wiki/Stream_Control_Transmission_Protocol)<br>* [RSVP](http://en.wikipedia.org/wiki/Resource_Reservation_Protocol)<br>* [(more)](http://en.wikipedia.org/wiki/Category:Transport_layer_protocols) |
| [Internet layer](http://en.wikipedia.org/wiki/Internet_layer) |
| * [IPv4](http://en.wikipedia.org/wiki/IPv4)<br>* [IPv6](http://en.wikipedia.org/wiki/IPv6)<br><br>* [ICMP](http://en.wikipedia.org/wiki/Internet_Control_Message_Protocol)<br>* [ICMPv6](http://en.wikipedia.org/wiki/ICMPv6)<br>* [ECN](http://en.wikipedia.org/wiki/Explicit_Congestion_Notification)<br>* [IGMP](http://en.wikipedia.org/wiki/Internet_Group_Management_Protocol)<br>* [IPsec](http://en.wikipedia.org/wiki/IPsec)<br>* [OSPF](http://en.wikipedia.org/wiki/Open_Shortest_Path_First)<br>* [RIP](http://en.wikipedia.org/wiki/Routing_Information_Protocol)<br>* [(more)](http://en.wikipedia.org/wiki/Category:Internet_layer_protocols) |
| [Link layer](http://en.wikipedia.org/wiki/Link_layer) |
| * [ARP/InARP](http://en.wikipedia.org/wiki/Address_Resolution_Protocol)<br>* [NDP](http://en.wikipedia.org/wiki/Neighbor_Discovery_Protocol)<br>	* [L2TP](http://en.wikipedia.org/wiki/Layer_2_Tunneling_Protocol)<br>* [PPP](http://en.wikipedia.org/wiki/Point-to-Point_Protocol)<br>	* [Ethernet](http://en.wikipedia.org/wiki/Ethernet)<br>	* [DSL](http://en.wikipedia.org/wiki/Digital_subscriber_line)<br>	* [ISDN](http://en.wikipedia.org/wiki/Integrated_Services_Digital_Network)<br>	* [FDDI](http://en.wikipedia.org/wiki/Fiber_Distributed_Data_Interface)<br>* [(more)](http://en.wikipedia.org/wiki/Category:Link_protocols) |
| * [v](http://en.wikipedia.org/wiki/Template:IPstack)<br><br>* [t](http://en.wikipedia.org/wiki/Template_talk:IPstack)<br>* [e](http://en.wikipedia.org/w/index.php?title=Template:IPstack&action=edit) |

**Simple Mail Transfer Protocol** (**SMTP**) is an [Internet standard](http://en.wikipedia.org/wiki/Internet_standard) for [electronic mail](http://en.wikipedia.org/wiki/E-mail) (e-mail) transmission across [Internet Protocol](http://en.wikipedia.org/wiki/Internet_Protocol) (IP) networks. SMTP was first defined by [RFC 821](http://tools.ietf.org/html/rfc821) (1982, eventually declared [STD](http://en.wikipedia.org/wiki/Internet_standard) 10),[1](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-rfc821-0) and last updated by [RFC 5321](http://tools.ietf.org/html/rfc5321) (2008)[2](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-rfc5321-1) which includes the [extended SMTP](http://en.wikipedia.org/wiki/Extended_SMTP) (ESMTP) additions, and is the protocol in widespread use today. SMTP is specified for outgoing mail transport and uses [TCP](http://en.wikipedia.org/wiki/Transmission_Control_Protocol) [port](http://en.wikipedia.org/wiki/Computer_port_(software)) 25. The protocol for new submissions is effectively the same as SMTP, but it uses port 587 instead. SMTP connections secured by [SSL](http://en.wikipedia.org/wiki/Secure_Sockets_Layer) are known by the shorthand [SMTPS](http://en.wikipedia.org/wiki/SMTPS), though SMTPS is not a protocol in its own right.

While electronic [mail servers](http://en.wikipedia.org/wiki/Mail_server) and other [mail transfer agents](http://en.wikipedia.org/wiki/Mail_transfer_agent) use SMTP to send and receive mail messages, user-level client mail applications typically only use SMTP for sending messages to a mail server for [relaying](http://en.wikipedia.org/wiki/Mail_relay). For receiving messages, client applications usually use either the [Post Office Protocol](http://en.wikipedia.org/wiki/Post_Office_Protocol) (POP) or the [Internet Message Access Protocol](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol) (IMAP) or a proprietary system (such as Microsoft Exchange or [Lotus Notes](http://en.wikipedia.org/wiki/Lotus_Notes)/[Domino](http://en.wikipedia.org/wiki/IBM_Lotus_Domino)) to access their mail box accounts on a mail server.

## Contents

 \[[hide](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#)\] 

* [1 History](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#History)
* [2 Mail processing model](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Mail_processing_model)
	
	* [3.1 SMTP vs mail retrieval](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#SMTP_vs_mail_retrieval)
	* [3.2 Remote Message Queue Starting](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Remote_Message_Queue_Starting)
	* [3.3 On-Demand Mail Relay](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#On-Demand_Mail_Relay)
	* [3.4 Internationalization](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Internationalization)
	
	* [4.1.1 Restricting access by location](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Restricting_access_by_location)
	* [4.1.2 Client authentication](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Client_authentication)
	* [4.1.3 Open relay](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Open_relay)
	
	* [4.2 Ports](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Ports)
* [5 SMTP transport example](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#SMTP_transport_example)
* [6 Optional extensions](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Optional_extensions)
* [7 Security and spamming](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Security_and_spamming)
* [8 Implementations](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Implementations)
* [9 Related Requests For Comments](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Related_Requests_For_Comments)
* [10 See also](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#See_also)
* [11 References](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#References)
* [12 Further reading](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Further_reading)
* [13 External links](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#External_links)

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=1)\] History

Various forms of one-to-one [electronic messaging](http://en.wikipedia.org/wiki/Electronic_messaging) were used in the 1960s. People communicated with one another using systems developed for specific [mainframe](http://en.wikipedia.org/wiki/Mainframe_computer) computers. As more computers were interconnected, especially in the US Government's [ARPANET](http://en.wikipedia.org/wiki/ARPANET), standards were developed to allow users of different systems to [e-mail](http://en.wikipedia.org/wiki/E-mail) one another. SMTP grew out of these standards developed during the 1970s.

SMTP can trace its roots to two implementations described in 1971, the [Mail Box Protocol](http://en.wikipedia.org/w/index.php?title=Mail_Box_Protocol&action=edit&redlink=1), which has been disputed to actually have been implemented,[3](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-2) but is discussed in [RFC 196](http://tools.ietf.org/html/rfc196) and other RFCs, and the SNDMSG program, which, according to [RFC 2235](http://tools.ietf.org/html/rfc2235), [Ray Tomlinson](http://en.wikipedia.org/wiki/Ray_Tomlinson) of [BBN](http://en.wikipedia.org/wiki/BBN_Technologies) "invents" for [TENEX](http://en.wikipedia.org/wiki/TOPS-20#TENEX) computers the sending of mail across the ARPANET.[4](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-3)[5](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-4)[6](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-5) Fewer than 50 hosts were connected to the ARPANET at this time.[7](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-6)

Further implementations include [FTP Mail](http://en.wikipedia.org/w/index.php?title=FTP_Mail&action=edit&redlink=1) [8](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-7) and [Mail Protocol](http://en.wikipedia.org/w/index.php?title=Mail_Protocol&action=edit&redlink=1), both from 1973.[9](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-8) Development work continued throughout the 1970s, until the ARPANET converted into the modern [Internet](http://en.wikipedia.org/wiki/Internet) around 1980. [Jon Postel](http://en.wikipedia.org/wiki/Jon_Postel) then proposed a [Mail Transfer Protocol](http://en.wikipedia.org/wiki/Mail_Transfer_Protocol) in 1980 that began to remove the mail's reliance on [FTP](http://en.wikipedia.org/wiki/FTP).[10](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-9) SMTP was published as [RFC 821](http://tools.ietf.org/html/rfc821) in August 1982, also by Postel.

The SMTP standard was developed around the same time as [Usenet](http://en.wikipedia.org/wiki/Usenet), a one-to-many communication network with some similarities.

SMTP became widely used in the early 1980s. At the time, it was a complement to [Unix to Unix Copy Program](http://en.wikipedia.org/wiki/UUCP) (UUCP) mail, which was better suited for handling e-mail transfers between machines that were intermittently connected. SMTP, on the other hand, works best when both the sending and receiving machines are connected to the network all the time. Both use a [store and forward](http://en.wikipedia.org/wiki/Store_and_forward) mechanism and are examples of [push technology](http://en.wikipedia.org/wiki/Push_technology). Though Usenet's [newsgroups](http://en.wikipedia.org/wiki/Newsgroups) are still propagated with UUCP between servers,[11](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-10) UUCP mail has virtually disappeared[12](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-11) along with the "[bang paths](http://en.wikipedia.org/wiki/Bang_path)" it used as message routing headers.

The article about [sender rewriting](http://en.wikipedia.org/wiki/Sender_Rewriting_Scheme) contains technical background info about the early SMTP history and source routing before [RFC 1123](http://tools.ietf.org/html/rfc1123).

[Sendmail](http://en.wikipedia.org/wiki/Sendmail) was one of the first (if not the first) mail transfer agents to implement SMTP.\[_[citation needed](http://en.wikipedia.org/wiki/Wikipedia:Citation_needed)_\] Some other popular SMTP server programs include [Postfix](http://en.wikipedia.org/wiki/Postfix_(software)), [qmail](http://en.wikipedia.org/wiki/Qmail), [Novell GroupWise](http://en.wikipedia.org/wiki/Novell_GroupWise), [Exim](http://en.wikipedia.org/wiki/Exim), [Novell NetMail](http://en.wikipedia.org/wiki/Novell_NetMail), [Microsoft Exchange Server](http://en.wikipedia.org/wiki/Microsoft_Exchange_Server), [Sun Java System Messaging Server](http://en.wikipedia.org/wiki/Sun_Java_System_Messaging_Server).

Message submission ([RFC 2476](http://tools.ietf.org/html/rfc2476)) and [SMTP-AUTH](http://en.wikipedia.org/wiki/SMTP-AUTH) ([RFC 2554](http://tools.ietf.org/html/rfc2554)) were introduced in 1998 and 1999, both describing new trends in e-mail delivery. Originally, SMTP servers were typically internal to an organization, receiving mail for the organization _from the outside_, and relaying messages from the organization _to the outside_. But as time went on, SMTP servers (Mail transfer agents), in practice, were expanding their roles to become [message submission agents](http://en.wikipedia.org/wiki/Message_submission_agent) for [Mail user agents](http://en.wikipedia.org/wiki/Mail_user_agent), some of which were now relaying mail _from the outside_ of an organization. (e.g. a company executive wishes to send e-mail while on a trip using the corporate SMTP server.) This issue, a consequence of the rapid expansion and popularity of the [World Wide Web](http://en.wikipedia.org/wiki/World_Wide_Web), meant that SMTP had to include specific rules and methods for relaying mail and authenticating users to prevent abuses such as relaying of unsolicited e-mail ([spam](http://en.wikipedia.org/wiki/E-mail_spam)).

As this protocol started out purely [ASCII](http://en.wikipedia.org/wiki/ASCII) text-based, it did not deal well with binary files, or characters in many non-English languages. Standards such as Multipurpose Internet Mail Extensions ([MIME](http://en.wikipedia.org/wiki/MIME)) were developed to encode binary files for transfer through SMTP. Mail transfer agents (MTAs) developed after [Sendmail](http://en.wikipedia.org/wiki/Sendmail) also tended to be implemented [8-bit-clean](http://en.wikipedia.org/wiki/8-bit-clean), so that the alternate "just send eight" strategy could be used to transmit arbitrary text data (in any 8-bit ASCII-like character encoding) via SMTP. [Mojibake](http://en.wikipedia.org/wiki/Mojibake) was still a problem due to differing character set mappings between vendors, although the email addresses themselves still allowed only [ASCII](http://en.wikipedia.org/wiki/ASCII). 8-bit-clean MTAs today tend to support the [8BITMIME](http://en.wikipedia.org/wiki/8BITMIME) extension, permitting binary files to be transmitted almost as easily as plain text. Recently the [SMTPUTF8](http://en.wikipedia.org/w/index.php?title=SMTPUTF8&action=edit&redlink=1) extension was created to support [UTF-8](http://en.wikipedia.org/wiki/UTF-8) text, allowing international content and addresses in non-Latin scripts like Cyrillic or Chinese.

Many people contributed to the core SMTP specifications, among them [Jon Postel](http://en.wikipedia.org/wiki/Jon_Postel), [Eric Allman](http://en.wikipedia.org/wiki/Eric_Allman), [Dave Crocker](http://en.wikipedia.org/w/index.php?title=Dave_Crocker&action=edit&redlink=1), [Ned Freed](http://en.wikipedia.org/wiki/Ned_Freed), [Randall Gellens](http://en.wikipedia.org/w/index.php?title=Randall_Gellens&action=edit&redlink=1), [John Klensin](http://en.wikipedia.org/wiki/John_Klensin), and [Keith Moore](http://en.wikipedia.org/wiki/Keith_Moore).

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=2)\] Mail processing model

[![[./_resources/Simple_Mail_Transfer_Protocol_-_Wikipedia,_the_free_encyclopedia_en.wikipedia.org.resources/unknown_filename.5.png]]](http://en.wikipedia.org/wiki/File:SMTP-transfer-model.svg)

[![[./_resources/Simple_Mail_Transfer_Protocol_-_Wikipedia,_the_free_encyclopedia_en.wikipedia.org.resources/unknown_filename.2.png]]](http://en.wikipedia.org/wiki/File:SMTP-transfer-model.svg)
Blue arrows can be implemented using SMTP variations.

Email is submitted by a mail client (MUA, [mail user agent](http://en.wikipedia.org/wiki/Mail_user_agent)) to a mail server (MSA, [mail submission agent](http://en.wikipedia.org/wiki/Mail_submission_agent)) using SMTP on [TCP](http://en.wikipedia.org/wiki/Transmission_Control_Protocol) port 587. Most mailbox providers still allow submission on traditional port 25. From there, the MSA delivers the mail to its mail transfer agent (MTA, [mail transfer agent](http://en.wikipedia.org/wiki/Mail_transfer_agent)). Often, these two agents are just different instances of the same software launched with different options on the same machine. Local processing can be done either on a single machine, or split among various appliances; in the former case, involved processes can share files; in the latter case, SMTP is used to transfer the message internally, with each host configured to use the next appliance as a [smart host](http://en.wikipedia.org/wiki/Smart_host). Each process is an MTA in its own right; that is, an SMTP server.

The boundary MTA has to locate the target host. It uses the [Domain name system](http://en.wikipedia.org/wiki/Domain_name_system) (DNS) to look up the mail exchanger record (MX record) for the recipient's domain (the part of the [address](http://en.wikipedia.org/wiki/Email_address) on the right of @). The returned MX record contains the name of the target host. The MTA next connects to the exchange server as an SMTP client. (The article on [MX record](http://en.wikipedia.org/wiki/MX_record) discusses many factors in determining which server the sending MTA connects to.)

Once the MX target accepts the incoming message, it hands it to a [mail delivery agent](http://en.wikipedia.org/wiki/Mail_delivery_agent) (MDA) for local mail delivery. An MDA is able to save messages in the relevant [mailbox](http://en.wikipedia.org/wiki/Email_mailbox) format. Again, mail reception can be done using many computers or just one —the picture displays two nearby boxes in either case. An MDA may deliver messages directly to storage, or [forward](http://en.wikipedia.org/wiki/E-mail_forwarding) them over a network using SMTP, or any other means, including the [Local Mail Transfer Protocol](http://en.wikipedia.org/wiki/Local_Mail_Transfer_Protocol) (LMTP), a derivative of SMTP designed for this purpose.

Once delivered to the local mail server, the mail is stored for batch retrieval by authenticated mail clients (MUAs). Mail is retrieved by end-user applications, called email clients, using [Internet Message Access Protocol](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol) (IMAP), a protocol that both facilitates access to mail and manages stored mail, or the [Post Office Protocol](http://en.wikipedia.org/wiki/Post_Office_Protocol) (POP) which typically uses the traditional [mbox](http://en.wikipedia.org/wiki/Mbox) mail file format or a proprietary system such as Microsoft Exchange/Outlook or [Lotus Notes](http://en.wikipedia.org/wiki/Lotus_Notes)/[Domino](http://en.wikipedia.org/wiki/IBM_Lotus_Domino). [Webmail](http://en.wikipedia.org/wiki/Webmail) clients may use either method, but the retrieval protocol is often not a formal standard.

SMTP defines message _transport_, not the message _content_. Thus, it defines the mail _envelope_ and its parameters, such as the [envelope sender](http://en.wikipedia.org/wiki/Envelope_sender), but not the header or the body of the message itself. STD 10 and [RFC 5321](http://tools.ietf.org/html/rfc5321) define SMTP (the envelope), while STD 11 and [RFC 5322](http://tools.ietf.org/html/rfc5322) define the message (header and body), formally referred to as the [Internet Message Format](http://en.wikipedia.org/wiki/Internet_Message_Format).

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=3)\] Protocol overview

SMTP is a [connection-oriented](http://en.wikipedia.org/wiki/Connection-oriented_communication), [text-based](http://en.wikipedia.org/wiki/Text-based_(computing)) protocol in which a mail sender communicates with a mail receiver by issuing command strings and supplying necessary data over a reliable ordered data stream channel, typically a [Transmission Control Protocol](http://en.wikipedia.org/wiki/Transmission_Control_Protocol) (TCP) connection. An _SMTP session_ consists of commands originated by an SMTP [client](http://en.wikipedia.org/wiki/Client_(computing)) (the initiating [agent](http://en.wikipedia.org/wiki/Software_agent), sender, or transmitter) and corresponding responses from the SMTP [server](http://en.wikipedia.org/wiki/Server_(computing)) (the listening agent, or receiver) so that the session is opened, and session parameters are exchanged. A session may include zero or more SMTP transactions. An _SMTP transaction_ consists of three command/reply sequences (see example below.) They are:

1. **MAIL** command, to establish the return address, a.k.a. Return-Path, 5321.From, mfrom, or envelope sender. This is the address for [bounce messages](http://en.wikipedia.org/wiki/Bounce_message).

* **RCPT** command, to establish a recipient of this message. This command can be issued multiple times, one for each recipient. These addresses are also part of the envelope.
* **DATA** to send the _message text_. This is the content of the message, as opposed to its envelope. It consists of a _message header_ and a _message body_ separated by an empty line. DATA is actually a group of commands, and the server replies twice: once to the _DATA command_ proper, to acknowledge that it is ready to receive the text, and the second time after the end-of-data sequence, to either accept or reject the entire message.

Besides the intermediate reply for DATA, each server's reply can be either positive (2xx reply codes) or negative. Negative replies can be permanent (5xx codes) or transient (4xx codes). A **reject** is a permanent failure by an SMTP server; in this case the SMTP client should send a bounce message. A **drop** is a positive response followed by message discard rather than delivery.

The initiating host, the SMTP client, can be either an end-user's [email client](http://en.wikipedia.org/wiki/Email_client), functionally identified as a [mail user agent](http://en.wikipedia.org/wiki/Mail_user_agent) (MUA), or a relay server's [mail transfer agent](http://en.wikipedia.org/wiki/Mail_transfer_agent) (MTA), that is an SMTP server acting as an SMTP client, in the relevant session, in order to relay mail. Fully capable SMTP servers maintain queues of messages for retrying message transmissions that resulted in transient failures.

A MUA knows the _outgoing mail_ SMTP server from its configuration. An SMTP server acting as client, i.e. _relaying_, typically determines which SMTP server to connect to by looking up the [MX](http://en.wikipedia.org/wiki/MX_record) (Mail eXchange) [DNS](http://en.wikipedia.org/wiki/Domain_Name_System) resource record for each recipient's [domain name](http://en.wikipedia.org/wiki/Domain_name). Conformant MTAs (not all) fall back to a simple [A record](http://en.wikipedia.org/wiki/A_record) in case no MX record can be found. Relaying servers can also be configured to use a [smart host](http://en.wikipedia.org/wiki/Smart_host).

An SMTP server acting as client initiates a [TCP](http://en.wikipedia.org/wiki/Transmission_Control_Protocol) connection to the server on the "[well-known port](http://en.wikipedia.org/wiki/Well-known_port)" designated for SMTP: [port](http://en.wikipedia.org/wiki/TCP_and_UDP_port) 25. MUAs should use port 587 to connect to an MSA. The main difference between an MTA and an MSA is that [SMTP Authentication](http://en.wikipedia.org/wiki/SMTP_Authentication) is mandatory for the latter only.

### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=4)\] SMTP vs mail retrieval

SMTP is a delivery protocol only. It cannot _pull_ messages from a remote server on demand. Other protocols, such as the [Post Office Protocol](http://en.wikipedia.org/wiki/Post_Office_Protocol) (POP) and the [Internet Message Access Protocol](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol) (IMAP) are specifically designed for retrieving messages and managing [mail boxes](http://en.wikipedia.org/wiki/Email_mailbox). However, SMTP has a feature to initiate mail queue processing on a remote server so that the requesting system may receive any messages destined for it (see [Remote Message Queue Starting](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#Remote_Message_Queue_Starting) below). POP and IMAP are preferred protocols when a user's personal computer is only intermittently powered up, or Internet connectivity is only transient and hosts cannot receive message during off-line periods.

### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=5)\] Remote Message Queue Starting

Remote Message Queue Starting is a feature of SMTP that permits a remote host to start processing of the mail queue on a server so it may receive messages destined to it by sending the TURN command. This feature however was deemed insecure[13](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-12) and was extended in [RFC 1985](http://tools.ietf.org/html/rfc1985) with the ETRN command which operates more securely using an [authentication](http://en.wikipedia.org/wiki/Authentication) method based on Domain Name System information.

### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=6)\] On-Demand Mail Relay

Main article: [On-Demand Mail Relay](http://en.wikipedia.org/wiki/On-Demand_Mail_Relay)

**On-Demand Mail Relay** (**ODMR**) is an [SMTP extension](http://en.wikipedia.org/wiki/SMTP_extension) standardized in [RFC 2645](http://tools.ietf.org/html/rfc2645) that allows e-mail to be relayed to an authenticated recipient.

### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=7)\] Internationalization

Many users whose native script is not Latin based have had difficulty with the Latin email address requirement. Often this leads to meaningless, but easy to type, locale addresses.

[RFC 6531](http://tools.ietf.org/html/rfc6531) was created to solve that problem, providing internationalization features for SMTP, the SMTPUTF8 extension. [RFC 6531](http://tools.ietf.org/html/rfc6531) provides support for multi-byte and non-ASCII characters in email addresses, such as Pelé@live.com (simple diacritic), δοκιμή@παράδειγμα.δοκιμή, and 测试@测试.测试. Current support is limited, but there is strong interest in broad adoption of [RFC 6531](http://tools.ietf.org/html/rfc6531) and the related RFCs in countries like China that have a large user base where Latin (ASCII) is a foreign script.

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=8)\] Outgoing mail SMTP server

An [e-mail client](http://en.wikipedia.org/wiki/E-mail_client) needs to know the IP address of an SMTP server and this has to be given as part of its configuration (usually given as a [DNS](http://en.wikipedia.org/wiki/Domain_name_system) name). The server will deliver outgoing messages on behalf of the user.

### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=9)\] Outgoing mail server access restrictions

Server administrators need to impose some control on which clients can use the server. This enables them to deal with abuse, for example [spam](http://en.wikipedia.org/wiki/Spam). Two solutions have been in common use:

* In the past, many systems imposed usage restrictions by the _location_ of the client, only permitting usage by clients whose IP address is one that the server administrators control. Usage from any other client IP address is disallowed.

* Modern SMTP servers typically offer an alternative system that requires [authentication](http://en.wikipedia.org/wiki/Authentication) of clients by credentials before allowing access.

#### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=10)\] Restricting access by location

Under this system, an _[ISP](http://en.wikipedia.org/wiki/ISP)'s_ SMTP server will not allow access by users who are 'outside the ISP's network'. More precisely, the server may only allow access to users with an IP address provided by the ISP, which is equivalent to requiring that they are connected to the Internet using that same ISP. A mobile user may often be on a network other than that of their normal ISP, and will then find that sending email fails because the configured SMTP server choice is no longer accessible.

This system has several variations. For example, an organisation's SMTP server may only provide service to users on the same network, enforcing this by firewalling to block access by users on the wider Internet. Or the server may perform range checks on the client's IP address. These methods were typically used by corporations and institutions such as universities which provided an SMTP server for outbound mail only for use internally within the organisation. However, most of these bodies now use client authentication methods, as described below.

By restricting access to certain IP addresses, server administrators can readily recognise the IP address of any abuser. As it will be a meaningful address to them, the administrators can deal with the rogue machine or user.

Where a user is mobile, and may use different ISPs to connect to the internet, this kind of usage restriction is onerous, and altering the configured outbound email SMTP server address is impractical. It is highly desirable to be able to use email client configuration information that does not need to change.

#### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=11)\] Client authentication

Modern SMTP servers typically require [authentication](http://en.wikipedia.org/wiki/Authentication) of clients by credentials before allowing access, rather than restricting access by location as described earlier. This more flexible system is friendly to mobile users and allows them to have a fixed choice of configured outbound SMTP server.

#### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=12)\] Open relay

A server that is accessible on the wider Internet and does not enforce these kinds of access restrictions is known as an [open relay](http://en.wikipedia.org/wiki/Open_relay). This is now generally considered a bad practice worthy of [blacklisting](http://en.wikipedia.org/wiki/Blacklist_(computing)).

### \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=13)\] Ports

Server administrators choose whether clients use [TCP](http://en.wikipedia.org/wiki/Transmission_Control_Protocol) port 25 (SMTP) or port 587 (Submission), as formalized in [RFC 6409](http://tools.ietf.org/html/rfc6409), for relaying outbound mail to a [mail server](http://en.wikipedia.org/wiki/Mail_server). The specifications and many servers support both. Although some servers support port 465 for legacy _secure SMTP_ in violation of the specifications, it is preferable to use standard ports and standard ESMTP commands[14](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-13) according to [RFC 3207](http://tools.ietf.org/html/rfc3207) if a secure session needs to be used between the client and the server.

Some servers are set up to reject all relaying on port 25, but valid users authenticating on port 587 are allowed to relay mail to any valid address.

Some [Internet service providers](http://en.wikipedia.org/wiki/Internet_service_provider) intercept port 25, redirecting traffic to their own SMTP server regardless of the destination address. This means that it is not possible for their users to access an SMTP server outside the ISP's network using port 25.

Some SMTP servers support authenticated access on an additional port other than 25 to allow users to connect to them even if port 25 is blocked.

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=14)\] SMTP transport example

A typical example of sending a message via SMTP to two mailboxes (_alice_ and _theboss_) located in the same mail domain (_example.com_ or _localhost.com_) is reproduced in the following session exchange.

For illustration purposes here (not part of protocol), the protocol exchanges are prefixed for the server (_S:_) and the client (_C:_).

After the message sender (SMTP client) establishes a reliable communications channel to the message receiver (SMTP server), the session is opened with a greeting by the server, usually containing its [fully qualified domain name](http://en.wikipedia.org/wiki/Fully_qualified_domain_name) (FQDN), in this case _smtp.example.com_. The client initiates its dialog by responding with a `HELO` command identifying itself in the command's parameter with its FQDN (or an address literal if none is available).[2](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-rfc5321-1)

    S: 220 smtp.example.com ESMTP Postfix
    C: HELO relay.example.org
    S: 250 Hello relay.example.org, I am glad to meet you
    C: MAIL FROM:<bob@example.org>
    S: 250 Ok
    C: RCPT TO:<alice@example.com>
    S: 250 Ok
    C: RCPT TO:<theboss@example.com>
    S: 250 Ok
    C: DATA
    S: 354 End data with <CR><LF>.<CR><LF>
    C: From: "Bob Example" <bob@example.org>
    C: To: "Alice Example" <alice@example.com>
    C: Cc: theboss@example.com
    C: Date: Tue, 15 Jan 2008 16:02:43 -0500
    C: Subject: Test message
    C:
    C: Hello Alice.
    C: This is a test message with 5 header fields and 4 lines in the message body.
    C: Your friend,
    C: Bob
    C: .
    S: 250 Ok: queued as 12345
    C: QUIT
    S: 221 Bye
    {The server closes the connection}

The client notifies the receiver of the originating email address of the message in a `MAIL FROM` command. In this example, the email message is sent to two mailboxes on the same SMTP server: one each for each recipient listed in the To and Cc header fields. The corresponding SMTP command is `RCPT TO`. Each successful reception and execution of a command is acknowledged by the server with a result code and response message (e.g., 250 Ok).

The transmission of the body of the mail message is initiated with a `DATA` command after which it is transmitted verbatim line by line and is terminated with an end-of-data sequence. This sequence consists of a new-line (<CR><LF>), a single [full stop](http://en.wikipedia.org/wiki/Full_stop) (period), followed by another new-line. Since a message body can contain a line with just a period as part of the text, the client sends _two_ periods every time a line starts with a period; correspondingly, the server replaces every sequence of two periods at the beginning of a line with a single one. Such escaping method is called _dot-stuffing_.

The server's positive reply to the end-of-data, as exemplified, implies that the server has taken the responsibility of delivering the message. A message can be doubled if there is a communication failure at this time, e.g. due to a power shortage: Until the sender has received that 250 reply, it must assume the message was not delivered. On the other hand, after the receiver has decided to accept the message, it must assume the message has been delivered to it. Thus, during this time span, both agents have active copies of the message that they will try to deliver.[15](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-14) The probability that a communication failure occurs exactly at this step is directly proportional to the amount of filtering that the server performs on the message body, most often for anti-spam purposes. The limiting timeout is specified to be 10 minutes.[16](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-15)

The `QUIT` command ends the session. If the second recipient were located elsewhere, the client would `QUIT` and connect to the appropriate SMTP server after the first message had been queued. The information that the client sends in the `HELO` and `MAIL FROM` commands are added (not seen in example code) as additional header fields to the message by the receiving server. It adds a `Received` and `Return-Path` header field, respectively.

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=15)\] Optional extensions

Although optional and not shown in this example, many clients ask the server for the SMTP extensions that the server supports, by using the `EHLO` greeting of the extended SMTP specification ([RFC 1870](http://tools.ietf.org/html/rfc1870)). Clients fall back to `HELO` only if the server does not respond to `EHLO`.

Modern clients may use the ESMTP extension keyword `SIZE` to query the server for the maximum message size that will be accepted. Older clients and servers may try to transfer excessively sized messages that will be rejected after consuming network resources, including connect time to network links that is paid by the minute.

Users can manually determine in advance the maximum size accepted by ESMTP servers. The client replaces the `HELO` command with the `EHLO` command.

S: 220 smtp2.example.com ESMTP Postfix
C: EHLO bob.example.org
S: 250-smtp2.example.com Hello bob.example.org \[192.0.2.201\]
S: 250-SIZE 14680064
S: 250-PIPELINING
S: 250 HELP

Thus _smtp2.example.com_ declares that it will accept a fixed maximum message size no larger than 14,680,064 [octets](http://en.wikipedia.org/wiki/Octet_(computing)) (8-bit bytes). Depending on the server's actual resource usage, it may be currently unable to accept a message this large. In the simplest case, an ESMTP server will declare a maximum SIZE with only the EHLO user interaction.

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=16)\] Security and spamming

Main article: [Anti-spam techniques (e-mail)](http://en.wikipedia.org/wiki/Anti-spam_techniques_(e-mail))

The original SMTP specification did not include a facility for authentication of senders. Subsequently, the [SMTP-AUTH](http://en.wikipedia.org/wiki/SMTP-AUTH) extension was defined by [RFC 2554](http://tools.ietf.org/html/rfc2554).[17](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_note-16) The [SMTP extension](http://en.wikipedia.org/wiki/ESMTP) (ESMTP) provides a mechanism for email clients to specify a security mechanism to a mail server, authenticate the exchange, and negotiate a security profile ([Simple Authentication and Security Layer](http://en.wikipedia.org/wiki/Simple_Authentication_and_Security_Layer), SASL) for subsequent message transfers.

Microsoft products implement the proprietary [Secure Password Authentication](http://en.wikipedia.org/wiki/Secure_Password_Authentication) (SPA) protocol through the use of the SMTP-AUTH extension.

However, the impracticality of widespread SMTP-AUTH implementation and management means that E-mail [spamming](http://en.wikipedia.org/wiki/Spamming) is not and cannot be addressed by it.

Modifying SMTP extensively, or replacing it completely, is not believed to be practical, due to the [network effects](http://en.wikipedia.org/wiki/Network_effect) of the huge installed base of SMTP. [Internet Mail 2000](http://en.wikipedia.org/wiki/Internet_Mail_2000) was one such proposal for replacement.

Spam is enabled by several factors, including vendors implementing [MTAs](http://en.wikipedia.org/wiki/Mail_Transfer_Agent) that are not standards-compliant, which make it difficult for other MTAs to enforce standards, security vulnerabilities within the operating system (often exacerbated by always-on broadband connections) that allow spammers to remotely control end-user PCs and cause them to send spam, and a lack of "intelligence" in many MTAs.

There are a number of proposals for sideband protocols that will assist SMTP operation. The [Anti-Spam Research Group](http://en.wikipedia.org/wiki/Anti-Spam_Research_Group) (ASRG) of the [Internet Research Task Force](http://en.wikipedia.org/wiki/Internet_Research_Task_Force) (IRTF) is working on a number of [E-mail authentication](http://en.wikipedia.org/wiki/E-mail_authentication) and other proposals for providing simple source authentication that is flexible, lightweight, and scalable. Recent [Internet Engineering Task Force](http://en.wikipedia.org/wiki/Internet_Engineering_Task_Force) (IETF) activities include [MARID](http://en.wikipedia.org/wiki/MARID) (2004) leading to two approved IETF experiments in 2005, and [DomainKeys Identified Mail](http://en.wikipedia.org/wiki/DomainKeys_Identified_Mail) in 2006.

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=17)\] Implementations

Main article: [List of mail servers](http://en.wikipedia.org/wiki/List_of_mail_servers)

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=18)\] Related Requests For Comments

* [RFC 1123](http://tools.ietf.org/html/rfc1123) – Requirements for Internet Hosts—Application and Support (STD 3)
* [RFC 1870](http://tools.ietf.org/html/rfc1870) – SMTP Service Extension for Message Size Declaration (оbsoletes: [RFC 1653](http://tools.ietf.org/html/rfc1653))
* [RFC 2505](http://tools.ietf.org/html/rfc2505) – Anti-Spam Recommendations for SMTP MTAs (BCP 30)
* [RFC 2920](http://tools.ietf.org/html/rfc2920) – SMTP Service Extension for Command Pipelining (STD 60)
* [RFC 3030](http://tools.ietf.org/html/rfc3030) – SMTP Service Extensions for Transmission of Large and Binary MIME Messages
* [RFC 3207](http://tools.ietf.org/html/rfc3207) – SMTP Service Extension for Secure SMTP over Transport Layer Security (obsoletes [RFC 2487](http://tools.ietf.org/html/rfc2487))
* [RFC 3461](http://tools.ietf.org/html/rfc3461) – SMTP Service Extension for Delivery Status Notifications (obsoletes [RFC 1891](http://tools.ietf.org/html/rfc1891))
* [RFC 3463](http://tools.ietf.org/html/rfc3463) – Enhanced Status Codes for SMTP (obsoletes [RFC 1893](http://tools.ietf.org/html/rfc1893) )
* [RFC 3464](http://tools.ietf.org/html/rfc3464) – An Extensible Message Format for Delivery Status Notifications (obsoletes [RFC 1894](http://tools.ietf.org/html/rfc1894))
* [RFC 3834](http://tools.ietf.org/html/rfc3834) – Recommendations for Automatic Responses to Electronic Mail
* [RFC 4952](http://tools.ietf.org/html/rfc4952) – Overview and Framework for Internationalized E-mail
* [RFC 4954](http://tools.ietf.org/html/rfc4954) – SMTP Service Extension for Authentication (obsoletes [RFC 2554](http://tools.ietf.org/html/rfc2554))
* [RFC 5068](http://tools.ietf.org/html/rfc5068) – E-mail Submission Operations: Access and Accountability Requirements (BCP 134)
* [RFC 5321](http://tools.ietf.org/html/rfc5321) – The Simple Mail Transfer Protocol (obsoletes [RFC 821](http://tools.ietf.org/html/rfc821) aka STD 10, [RFC 974](http://tools.ietf.org/html/rfc974), [RFC 1869](http://tools.ietf.org/html/rfc1869), [RFC 2821](http://tools.ietf.org/html/rfc2821))
* [RFC 5322](http://tools.ietf.org/html/rfc5322) – Internet Message Format (obsoletes [RFC 822](http://tools.ietf.org/html/rfc822) aka STD 11, and [RFC 2822](http://tools.ietf.org/html/rfc2822))
* [RFC 5336](http://tools.ietf.org/html/rfc5336) - SMTP Extension for Internationalized Email Addresses (updates [RFC 2821](http://tools.ietf.org/html/rfc2821), [RFC 2822](http://tools.ietf.org/html/rfc2822), and [RFC 4952](http://tools.ietf.org/html/rfc4952))
* [RFC 5504](http://tools.ietf.org/html/rfc5504) - Downgrading Mechanism for Email Address Internationalization
* [RFC 6409](http://tools.ietf.org/html/rfc6409) – Message Submission for Mail (obsoletes [RFC 4409](http://tools.ietf.org/html/rfc4409), [RFC 2476](http://tools.ietf.org/html/rfc2476))
* [RFC 6522](http://tools.ietf.org/html/rfc6522) – The Multipart/Report Content Type for the Reporting of Mail System Administrative Messages (obsoletes [RFC 3462](http://tools.ietf.org/html/rfc3462), and in turn [RFC 1892](http://tools.ietf.org/html/rfc1892))

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=19)\] See also

* [Bounce messages](http://en.wikipedia.org/wiki/Bounce_message) (SMTP non-delivery reports), [bounce address](http://en.wikipedia.org/wiki/Bounce_address)
* [Comparison of mail servers](http://en.wikipedia.org/wiki/Comparison_of_mail_servers)
* [E-mail authentication](http://en.wikipedia.org/wiki/E-mail_authentication)
* [E-mail encryption](http://en.wikipedia.org/wiki/E-mail_encryption)
* [Extended SMTP](http://en.wikipedia.org/wiki/Extended_SMTP) (ESMTP)
* [Ident](http://en.wikipedia.org/wiki/Ident)
* [List of mail servers](http://en.wikipedia.org/wiki/List_of_mail_servers)
* [POP before SMTP](http://en.wikipedia.org/wiki/POP_before_SMTP) / [SMTP after POP](http://en.wikipedia.org/wiki/SMTP_after_POP)
* [Sender Policy Framework](http://en.wikipedia.org/wiki/Sender_Policy_Framework) (SPF)
* [SMTP-AUTH](http://en.wikipedia.org/wiki/SMTP-AUTH) (ESMTPA)
* [SMTPS](http://en.wikipedia.org/wiki/SMTPS)
* [Variable envelope return path](http://en.wikipedia.org/wiki/Variable_envelope_return_path)

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=20)\] References

1. **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-rfc821_0-0)** [RFC 821](http://tools.ietf.org/html/rfc821), _Simple Mail Transfer Protocol_, J.B. Postel, The Internet Society (August 1982)

* ^ [_**a**_](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-rfc5321_1-0) [_**b**_](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-rfc5321_1-1) [RFC 5321](http://tools.ietf.org/html/rfc5321), _Simple Mail Transfer Protocol_, J. Klensin, The Internet Society (October 2008)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-2)** [The History of Electronic Mail](http://www.multicians.org/thvv/mail-history.html)_, [Tom Van Vleck](http://en.wikipedia.org/wiki/Tom_Van_Vleck): "_It is not clear this protocol was ever implemented_"_
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-3)** [_The First Network Email_](http://openmap.bbn.com/~tomlinso/ray/firstemailframe.html), [Ray Tomlinson](http://en.wikipedia.org/wiki/Ray_Tomlinson), BBN
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-4)** Picture of "[The First Email Computer](http://openmap.bbn.com/~tomlinso/ray/ka10.html)" by Dan Murphy, a [PDP-10](http://en.wikipedia.org/wiki/PDP-10)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-5)** [Dan Murphy's TENEX and TOPS-20 Papers](http://www.opost.com/dlm/tenex/)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-6)** [RFC 2235](http://tools.ietf.org/html/rfc2235)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-7)** [RFC 469](http://tools.ietf.org/html/rfc469) - Network Mail Meeting Summary
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-8)** [RFC 524](http://tools.ietf.org/html/rfc524) - A Proposed Mail Protocol
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-9)** [RFC 772](http://tools.ietf.org/html/rfc772) - Mail Transfer Protocol
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-10)** [Tldp.org](http://tldp.org/HOWTO/Usenet-News-HOWTO/x64.html)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-11)** [draft-barber-uucp-project-conclusion-05 - The Conclusion of the UUCP Mapping Project](http://tools.ietf.org/html/draft-barber-uucp-project-conclusion-05)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-12)** [RFC 1985](http://tools.ietf.org/html/rfc1985), _SMTP Service Extension for Remote Message Queue Starting_, J. De Winter, The Internet Society (August 1996)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-13)** [RFC 3207](http://tools.ietf.org/html/rfc3207) specifies only the well-known port 25 and the "Submission port," which is TCP port 587, for the STARTTLS command, the precursor for an encrypted SMTP session using [TLS](http://en.wikipedia.org/wiki/Transport_Layer_Security). It makes no mention of the unofficial port 465.
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-14)** [RFC 1047](http://tools.ietf.org/html/rfc1047)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-15)** [rfc5321#section-4.5.3.2.6](http://tools.ietf.org/html/rfc5321#section-4.5.3.2.6)
* **[^](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#cite_ref-16)** [RFC 2554](http://tools.ietf.org/html/rfc2554), _SMTP Service Extension for Authentication_, J. Myers (March 1999)

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=21)\] Further reading

* Hughes, L (1998). _Internet e-mail Protocols, Standards and Implementation_. Artech House Publishers. [ISBN](http://en.wikipedia.org/wiki/International_Standard_Book_Number) [0890069395](http://en.wikipedia.org/wiki/Special:BookSources/0890069395).
* Hunt, C (2003). _sendmail Cookbook_. O'Reilly Media. [ISBN](http://en.wikipedia.org/wiki/International_Standard_Book_Number) [0596004710](http://en.wikipedia.org/wiki/Special:BookSources/0596004710).
* Johnson, K (2000). _Internet Email Protocols: A Developer's Guide_. Addison-Wesley Professional. [ISBN](http://en.wikipedia.org/wiki/International_Standard_Book_Number) [0201432889](http://en.wikipedia.org/wiki/Special:BookSources/0201432889).
* Loshin, P (1999). _Essential Email Standards: RFCs and Protocols Made Practical_. John Wiley & Sons. [ISBN](http://en.wikipedia.org/wiki/International_Standard_Book_Number) [0471345970](http://en.wikipedia.org/wiki/Special:BookSources/0471345970).
* Rhoton, J (1999). _Programmer's Guide to Internet Mail: SMTP, POP, IMAP, and LDAP_. Elsevier. [ISBN](http://en.wikipedia.org/wiki/International_Standard_Book_Number) [1555582125](http://en.wikipedia.org/wiki/Special:BookSources/1555582125).
* Wood, D (1999). _Programming Internet Mail_. O'Reilly. [ISBN](http://en.wikipedia.org/wiki/International_Standard_Book_Number) [1565924797](http://en.wikipedia.org/wiki/Special:BookSources/1565924797).

## \[[edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit&section=22)\] External links

* [Essential Internet Protocols - SMTP](http://www.vanemery.com/Protocols/SMTP/smtp.html)
* [SMTP Sequence Diagram](http://www.eventhelix.com/RealtimeMantra/Networking/SMTP_Sequence_Diagram.pdf) (PDF)
* [Diagram of e-mail flow](http://www.openspf.org/mailflows.pdf) (PDF, [PNG](http://www.openspf.org/mailflows-l.png) )
* [The Case For E-mail Security](http://luxsci.com/extranet/articles/email-security.html) - Security and Insecurity in SMTP, POP and IMAP.
* [Picture of the first computers to send and receive a network email, 2 PDP-10s](http://history-computer.com/Internet/Maturing/Tomlinson.html)
* [Email Address Internationalization IETF Working Group](http://www.ietf.org/html.charters/eai-charter.html)
* [SMTP TLS Transport real-time test](http://www.checktls.com/TestReceiver?LEVEL=3) - Live version of above example, mostly for TLS (i.e. secure) email but useful for non-TLS too

| \[[hide](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol#)\]<br><br>* [v](http://en.wikipedia.org/wiki/Template:Email_clients)<br><br>* [t](http://en.wikipedia.org/wiki/Template_talk:Email_clients)<br>* [e](http://en.wikipedia.org/w/index.php?title=Template:Email_clients&action=edit)<br>[Email clients](http://en.wikipedia.org/wiki/Email_client) |     |     |
| --- | --- | --- |
|     |
| [Open source](http://en.wikipedia.org/wiki/Open_source_software) | * [Alpine](http://en.wikipedia.org/wiki/Alpine_(email_client))<br><br>* [Arachne](http://en.wikipedia.org/wiki/Arachne_(web_browser))<br>* [Balsa](http://en.wikipedia.org/wiki/Balsa_(email_client))<br>* [BlitzMail](http://en.wikipedia.org/wiki/BlitzMail)<br>* [Citadel/UX](http://en.wikipedia.org/wiki/Citadel/UX)<br>* [Classilla](http://en.wikipedia.org/wiki/Classilla)<br>* [Claws Mail](http://en.wikipedia.org/wiki/Claws_Mail)<br>* [Columba](http://en.wikipedia.org/wiki/Columba_(email_client))<br>* [Cone](http://en.wikipedia.org/wiki/Cone_(software))<br>* [Elm](http://en.wikipedia.org/wiki/Elm_(email_client))<br>* [Evolution](http://en.wikipedia.org/wiki/Evolution_(software))<br>* [fetchmail](http://en.wikipedia.org/wiki/Fetchmail)<br>* [getmail](http://en.wikipedia.org/wiki/Getmail)<br>* [GNUMail](http://en.wikipedia.org/wiki/GNUMail)<br>* [Gnus](http://en.wikipedia.org/wiki/Gnus)<br>* [Gnuzilla](http://en.wikipedia.org/wiki/Gnuzilla)<br>* [IMP](http://en.wikipedia.org/wiki/Internet_Messaging_Program)<br>* [KMail](http://en.wikipedia.org/wiki/KMail)<br>* [Mahogany](http://en.wikipedia.org/wiki/Mahogany_(email_client))<br>* [Mailody](http://en.wikipedia.org/wiki/Mailody)<br>* [Modest](http://en.wikipedia.org/wiki/Modest_(email_client))<br>* [Mozilla Thunderbird](http://en.wikipedia.org/wiki/Mozilla_Thunderbird)<br>* [Mulberry](http://en.wikipedia.org/wiki/Mulberry_(email_client))<br>* [Mutt](http://en.wikipedia.org/wiki/Mutt_(email_client))<br>* [nmh / MH](http://en.wikipedia.org/wiki/MH_Message_Handling_System)<br>* [Roundcube](http://en.wikipedia.org/wiki/Roundcube)<br>* [SeaMonkey](http://en.wikipedia.org/wiki/SeaMonkey)<br>* [sendEmail](http://en.wikipedia.org/wiki/SendEmail)<br>* [Spicebird](http://en.wikipedia.org/wiki/Spicebird)<br>* [SquirrelMail](http://en.wikipedia.org/wiki/SquirrelMail)<br>* [Sylpheed](http://en.wikipedia.org/wiki/Sylpheed)<br>* [Wanderlust](http://en.wikipedia.org/wiki/Wanderlust_(software))<br>* [YAM](http://en.wikipedia.org/wiki/YAM_(Yet_Another_Mailer))<br>* [Zimbra](http://en.wikipedia.org/wiki/Zimbra) | [![[./_resources/Simple_Mail_Transfer_Protocol_-_Wikipedia,_the_free_encyclopedia_en.wikipedia.org.resources/unknown_filename.png]]](http://en.wikipedia.org/wiki/File:Internet-mail.svg) |
|     |
| [Freeware](http://en.wikipedia.org/wiki/Freeware) | * [ChatterEmail](http://en.wikipedia.org/wiki/ChatterEmail)<br><br>* [Denshin 8 go](http://en.wikipedia.org/wiki/Denshin_8_go)<br>* [EmailTray](http://en.wikipedia.org/wiki/EmailTray)<br>* [Eudora](http://en.wikipedia.org/wiki/Eudora_(email_client))<br>* [Foxmail](http://en.wikipedia.org/wiki/Foxmail)<br>* [i.Scribe](http://en.wikipedia.org/wiki/Scribe_Mail)<br>* [IncrediMail](http://en.wikipedia.org/wiki/IncrediMail)<br>* [Opera Mail](http://en.wikipedia.org/wiki/Opera_Mail)<br>* [Wanderlust](http://en.wikipedia.org/wiki/Wanderlust_(software))<br>* [Windows Live Mail](http://en.wikipedia.org/wiki/Windows_Live_Mail) |
|     |
| Retail | * [Apple Mail](http://en.wikipedia.org/wiki/Mail_(application))<br><br>* [IBM Lotus Notes](http://en.wikipedia.org/wiki/IBM_Lotus_Notes)<br>* [InScribe](http://en.wikipedia.org/wiki/Scribe_Mail)<br>* [Microsoft Outlook](http://en.wikipedia.org/wiki/Microsoft_Outlook)<br>* [Novell GroupWise](http://en.wikipedia.org/wiki/Novell_GroupWise)<br>* [Sparrow](http://en.wikipedia.org/wiki/Sparrow_(email_client))<br>* [Bloomba/WordPerfect Mail](http://en.wikipedia.org/wiki/Bloomba) |
|     |
| [Shareware](http://en.wikipedia.org/wiki/Shareware) | * [Becky!](http://en.wikipedia.org/wiki/Becky!)<br><br>* [Eureka Email](http://en.wikipedia.org/wiki/Eureka_Email)<br>* [Forté Agent](http://en.wikipedia.org/wiki/Fort%C3%A9_Agent)<br>* [Gemini (mail/news)](http://en.wikipedia.org/wiki/Gemini_(mail/news))<br>* [GyazMail](http://en.wikipedia.org/wiki/GyazMail)<br>* [Pocomail](http://en.wikipedia.org/wiki/Pocomail)<br>* [The Bat!](http://en.wikipedia.org/wiki/The_Bat!) |
|     |
| [Donationware](http://en.wikipedia.org/wiki/Donationware) | * [Forté Agent](http://en.wikipedia.org/wiki/Fort%C3%A9_Agent)<br><br>* [Pegasus Mail](http://en.wikipedia.org/wiki/Pegasus_Mail) |
|     |
| Discontinued | * [Beonex Communicator](http://en.wikipedia.org/wiki/Beonex_Communicator)<br><br>* [cc:Mail](http://en.wikipedia.org/wiki/Cc:Mail)<br>* [Claris Emailer](http://en.wikipedia.org/wiki/Claris_Emailer)<br>* [Columbia MM](http://en.wikipedia.org/wiki/Columbia_MM)<br>* [Courier](http://en.wikipedia.org/wiki/Courier_(email_client))<br>* [Cyberdog](http://en.wikipedia.org/wiki/Cyberdog)<br>* [Cyberjack](http://en.wikipedia.org/wiki/Cyberjack)<br>* [Hula](http://en.wikipedia.org/wiki/Hula_(software))<br>* [Meldware Communication Suite](http://en.wikipedia.org/wiki/Meldware_Communication_Suite)<br>* [Microsoft Entourage](http://en.wikipedia.org/wiki/Microsoft_Entourage)<br>* [Microsoft Internet Mail and News](http://en.wikipedia.org/wiki/Microsoft_Internet_Mail_and_News)<br>* [MINUET](http://en.wikipedia.org/wiki/Minnesota_Internet_Users_Essential_Tool)<br>* [Mozilla Mail & Newsgroups](http://en.wikipedia.org/wiki/Mozilla_Mail_%26_Newsgroups)<br>* [NeXTMail](http://en.wikipedia.org/wiki/NeXTMail)<br>* [Netscape Mail](http://en.wikipedia.org/wiki/Netscape_Mail_%26_Newsgroups)<br>* [Netscape Messenger 9](http://en.wikipedia.org/wiki/Netscape_Messenger_9)<br>* [Omni Mobile](http://en.wikipedia.org/wiki/Omni_Mobile)<br>* [Outlook Express](http://en.wikipedia.org/wiki/Outlook_Express)<br>* [Pine](http://en.wikipedia.org/wiki/Pine_(email_client))<br>* [POPmail](http://en.wikipedia.org/wiki/POPmail)<br>* [Turnpike](http://en.wikipedia.org/wiki/Turnpike_(software))<br>* [Windows Mail](http://en.wikipedia.org/wiki/Windows_Mail)<br>* [Windows Messaging](http://en.wikipedia.org/wiki/Windows_Messaging) |
|     |
| Related technologies | * [Extended SMTP](http://en.wikipedia.org/wiki/Extended_SMTP)<br><br>* [IMAP](http://en.wikipedia.org/wiki/Internet_Message_Access_Protocol)<br>* [POP](http://en.wikipedia.org/wiki/Post_Office_Protocol)<br>* [Push-IMAP](http://en.wikipedia.org/wiki/Push-IMAP)<br>* [SMAP](http://en.wikipedia.org/wiki/Simple_Mail_Access_Protocol)<br>* **SMTP**<br>* [UUCP](http://en.wikipedia.org/wiki/UUCP) |
|     |
| Related articles | * [Email](http://en.wikipedia.org/wiki/Email)<br><br>* [Unicode and email](http://en.wikipedia.org/wiki/Unicode_and_email) |
|     |
| [Category](http://en.wikipedia.org/wiki/Category:Email_clients) **·** [Comparison](http://en.wikipedia.org/wiki/Comparison_of_email_clients) **·** [List](http://en.wikipedia.org/wiki/List_of_email_clients) |     |     |

View page ratings
Rate this page
[What's this?](http://en.wikipedia.org/wiki/Wikipedia:Article%20Feedback%20Tool)

	Trustworthy

	Objective

	Complete

	Well-written

I am highly knowledgeable about this topic (optional)

Submit ratings

[Categories](http://en.wikipedia.org/wiki/Special:Categories):

* [Email](http://en.wikipedia.org/wiki/Category:Email)

* [Internet mail protocols](http://en.wikipedia.org/wiki/Category:Internet_mail_protocols)

* [Log in / create account](http://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Simple+Mail+Transfer+Protocol&campaign=ACP3)

* [Article](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
	
* [Talk](http://en.wikipedia.org/wiki/Talk:Simple_Mail_Transfer_Protocol)
	

* [Read](http://en.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
	
* [Edit](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=edit)
	
* [View history](http://en.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&action=history)
	

![[./_resources/Simple_Mail_Transfer_Protocol_-_Wikipedia,_the_free_encyclopedia_en.wikipedia.org.resources/unknown_filename.4.png]]

<http://en.wikipedia.org/wiki/Main_Page>

* [Main page](http://en.wikipedia.org/wiki/Main_Page)

* [Contents](http://en.wikipedia.org/wiki/Portal:Contents)
* [Featured content](http://en.wikipedia.org/wiki/Portal:Featured_content)
* [Current events](http://en.wikipedia.org/wiki/Portal:Current_events)
* [Random article](http://en.wikipedia.org/wiki/Special:Random)
* [Donate to Wikipedia](http://wikimediafoundation.org/wiki/Special:Landingcheck?landing_page=WMFJA085&language=en&utm_source=donate&utm_medium=sidebar&utm_campaign=20101204SB002)

##### Interaction

* [Help](http://en.wikipedia.org/wiki/Help:Contents)

* [About Wikipedia](http://en.wikipedia.org/wiki/Wikipedia:About)
* [Community portal](http://en.wikipedia.org/wiki/Wikipedia:Community_portal)
* [Recent changes](http://en.wikipedia.org/wiki/Special:RecentChanges)
* [Contact Wikipedia](http://en.wikipedia.org/wiki/Wikipedia:Contact_us)

##### Toolbox

##### Print/export

##### Languages

* [العربية](http://ar.wikipedia.org/wiki/%D8%A8%D8%B1%D9%88%D8%AA%D9%88%D9%83%D9%88%D9%84_%D8%A5%D8%B1%D8%B3%D8%A7%D9%84_%D8%A7%D9%84%D8%A8%D8%B1%D9%8A%D8%AF_%D8%A7%D9%84%D8%A8%D8%B3%D9%8A%D8%B7)

* [Azərbaycanca](http://az.wikipedia.org/wiki/SMTP)
* [Bosanski](http://bs.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Català](http://ca.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Česky](http://cs.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Dansk](http://da.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Deutsch](http://de.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Eesti](http://et.wikipedia.org/wiki/Lihtne_meiliedastusprotokoll)
* [Ελληνικά](http://el.wikipedia.org/wiki/SMTP)
* [Español](http://es.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Esperanto](http://eo.wikipedia.org/wiki/SMTP)
* [Euskara](http://eu.wikipedia.org/wiki/SMTP)
* [فارسی](http://fa.wikipedia.org/wiki/%D9%82%D8%B1%D8%A7%D8%B1%D8%AF%D8%A7%D8%AF_%D8%B3%D8%A7%D8%AF%D9%87_%D9%86%D8%A7%D9%85%D9%87%E2%80%8C%D8%B1%D8%B3%D8%A7%D9%86%DB%8C)
* [Français](http://fr.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Galego](http://gl.wikipedia.org/wiki/SMTP)
* [한국어](http://ko.wikipedia.org/wiki/%EA%B0%84%EC%9D%B4_%EC%9A%B0%ED%8E%B8_%EC%A0%84%EC%86%A1_%ED%94%84%EB%A1%9C%ED%86%A0%EC%BD%9C)
* [Hrvatski](http://hr.wikipedia.org/wiki/SMTP)
* [Bahasa Indonesia](http://id.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Íslenska](http://is.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Italiano](http://it.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [עברית](http://he.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Kurdî](http://ku.wikipedia.org/wiki/SMTP)
* [Latviešu](http://lv.wikipedia.org/wiki/SMTP)
* [Lëtzebuergesch](http://lb.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Lietuvių](http://lt.wikipedia.org/wiki/SMTP)
* [Magyar](http://hu.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Македонски](http://mk.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [മലയാളം](http://ml.wikipedia.org/wiki/%E0%B4%B8%E0%B4%BF%E0%B4%AE%E0%B5%8D%E0%B4%AA%E0%B4%BF%E0%B5%BE_%E0%B4%AE%E0%B5%86%E0%B4%AF%E0%B4%BF%E0%B5%BD_%E0%B4%9F%E0%B5%8D%E0%B4%B0%E0%B4%BE%E0%B5%BB%E0%B4%B8%E0%B5%8D%E0%B4%AB%E0%B5%BC_%E0%B4%AA%E0%B5%8D%E0%B4%B0%E0%B5%8B%E0%B4%9F%E0%B5%8D%E0%B4%9F%E0%B5%8B%E0%B4%95%E0%B5%8B%E0%B5%BE)
* [Bahasa Melayu](http://ms.wikipedia.org/wiki/Protokol_Pindahan_Mel_Mudah)
* [Nederlands](http://nl.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [日本語](http://ja.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [‪Norsk (bokmål)‬](http://no.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [‪Norsk (nynorsk)‬](http://nn.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Олык Марий](http://mhr.wikipedia.org/wiki/SMTP)
* [Polski](http://pl.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Português](http://pt.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Română](http://ro.wikipedia.org/wiki/SMTP)
* [Русский](http://ru.wikipedia.org/wiki/SMTP)
* [Simple English](http://simple.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Slovenčina](http://sk.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Slovenščina](http://sl.wikipedia.org/wiki/SMTP)
* [Српски / Srpski](http://sr.wikipedia.org/wiki/SMTP)
* [Srpskohrvatski / Српскохрватски](http://sh.wikipedia.org/wiki/SMTP)
* [Suomi](http://fi.wikipedia.org/wiki/SMTP)
* [Svenska](http://sv.wikipedia.org/wiki/SMTP)
* [ไทย](http://th.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [Türkçe](http://tr.wikipedia.org/wiki/SMTP)
* [Українська](http://uk.wikipedia.org/wiki/SMTP)
* [Tiếng Việt](http://vi.wikipedia.org/wiki/SMTP)
* [Yorùbá](http://yo.wikipedia.org/wiki/Simple_Mail_Transfer_Protocol)
* [中文](http://zh.wikipedia.org/wiki/%E7%AE%80%E5%8D%95%E9%82%AE%E4%BB%B6%E4%BC%A0%E8%BE%93%E5%8D%8F%E8%AE%AE)

* This page was last modified on 23 March 2012 at 04:23.
	

* Text is available under the [Creative Commons Attribution-ShareAlike License](http://en.wikipedia.org/wiki/Wikipedia:Text_of_Creative_Commons_Attribution-ShareAlike_3.0_Unported_License); additional terms may apply. See [Terms of use](http://wikimediafoundation.org/wiki/Terms_of_use) for details.
	Wikipedia® is a registered trademark of the [Wikimedia Foundation, Inc.](http://www.wikimediafoundation.org/), a non-profit organization.
	
* [Contact us](http://en.wikipedia.org/wiki/Wikipedia:Contact_us)
	
	* [Privacy policy](http://wikimediafoundation.org/wiki/Privacy_policy)
	* [About Wikipedia](http://en.wikipedia.org/wiki/Wikipedia:About)
	* [Disclaimers](http://en.wikipedia.org/wiki/Wikipedia:General_disclaimer)
	* [Mobile view](http://en.m.wikipedia.org/w/index.php?title=Simple_Mail_Transfer_Protocol&useformat=mobile)
	
	* [![[./_resources/Simple_Mail_Transfer_Protocol_-_Wikipedia,_the_free_encyclopedia_en.wikipedia.org.resources/unknown_filename.3.png]]](http://wikimediafoundation.org/)
	* [![[./_resources/Simple_Mail_Transfer_Protocol_-_Wikipedia,_the_free_encyclopedia_en.wikipedia.org.resources/unknown_filename.1.png]]](http://www.mediawiki.org/)
