# How to pretty print XML from Java? - Stack Overflow [stackoverflow.com]

[Stack Exchange](http://stackexchange.com/)

[sign up](https://stackoverflow.com/users/signup?returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f139076%2fhow-to-pretty-print-xml-from-java) [log in](https://stackoverflow.com/users/login?returnurl=http%3a%2f%2fstackoverflow.com%2fquestions%2f139076%2fhow-to-pretty-print-xml-from-java) [tour](http://stackoverflow.com/tour) [help](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#) [stack overflow careers](http://careers.stackoverflow.com/?utm_source=stackoverflow.com&utm_medium=site-ui&utm_campaign=anon-topbar)

[Stack Overflow](http://stackoverflow.com/)

* [Questions](http://stackoverflow.com/questions)

* [Tags](http://stackoverflow.com/tags)
* [Users](http://stackoverflow.com/users)
* [Badges](http://stackoverflow.com/help/badges)
* [Unanswered](http://stackoverflow.com/unanswered)

* [Ask Question](http://stackoverflow.com/questions/ask)

[Take the 2-minute tour](http://stackoverflow.com/tour) 
Stack Overflow is a question and answer site for professional and enthusiast programmers. It's 100% free, no registration required.

# [How to pretty print XML from Java?](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java)

 227  [favorite](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#)
**87**

I have a Java String that contains XML, with no line feeds or indentations. I would like to turn it into a String with nicely formatted XML. How do I do this?

    String unformattedXml = "<tag><nested>hello</nested></tag>";
    String formattedXml = new [UnknownClass]().format(unformattedXml);

Note: My input is a **String**. My output is a **String**.

[java](http://stackoverflow.com/questions/tagged/java) [xml](http://stackoverflow.com/questions/tagged/xml) [pretty-print](http://stackoverflow.com/questions/tagged/pretty-print)

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/q/139076)\|[improve this question](http://stackoverflow.com/posts/139076/edit) | [edited Jul 5 '13 at 16:04](http://stackoverflow.com/posts/139076/revisions)<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/55f2a620e56c929e7f60503e3fcd6928.jpg]]](http://stackoverflow.com/users/2047725/w5m)<br>[w5m](http://stackoverflow.com/users/2047725/w5m)<br>**1,066**3832 | asked Sep 26 '08 at 12:21<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/1bf77682e06e19438854c1ea3ec5f5fa.jpg]]](http://stackoverflow.com/users/2959/steve-mcleod)<br>[Steve McLeod](http://stackoverflow.com/users/2959/steve-mcleod)<br>**20.3k**1981124 |

|     |     |
| --- | --- |
|     |     |

check this question: [stackoverflow.com/questions/1264849/…](http://stackoverflow.com/questions/1264849/pretty-printing-output-from-javax-xml-transform-transformer-with-only-standard-ja) –  [dfa](http://stackoverflow.com/users/89266/dfa) [Aug 12 '09 at 8:14](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment1092386_139076)

|     |     |
| --- | --- |
| **6** |     |

Just curious, are you sending this output to a XML file or something else where the indenting really matters? Some time ago I was very concerned about formatting my XML in order to have it properly displayed... but after spending a bunch of time on this I realized that I had to send my output to a web browser, and any relatively modern web browser will actually display the XML in a nice tree structure, so I could forget about this issue and move on. I'm mentioning this just in case you (or other user with the same problem) could have overlooked the same detail. –  [Abel Morelos](http://stackoverflow.com/users/124123/abel-morelos) [Oct 6 '10 at 17:21](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4123441_139076)

|     |     |
| --- | --- |
|     |     |

@Abel, saving to text files, inserting into an HTML textareas, and dumping to the console for debugging purposes. –  [Steve McLeod](http://stackoverflow.com/users/2959/steve-mcleod) [Oct 6 '10 at 20:48](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4125450_139076)

## 22 Answers

[active](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java?answertab=active#tab-top) [oldest](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java?answertab=oldest#tab-top) [votes](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java?answertab=votes#tab-top)

 105 

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    //initialize StreamResult with File object to save to file
    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);
    String xmlString = result.getWriter().toString();
    System.out.println(xmlString);

note: results may vary depending on the java version, search for workarounds specific to your platform

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/139096)\|[improve this answer](http://stackoverflow.com/posts/139096/edit) | answered Sep 26 '08 at 12:26<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/498e3c1a8c18f13ec34a92db50b38496.png]]](http://stackoverflow.com/users/2273540/lorenzo-boccaccia)<br>[Lorenzo Boccaccia](http://stackoverflow.com/users/2273540/lorenzo-boccaccia)<br>**3,221**2914 |

|     |     |
| --- | --- |
| **1** |     |

This almost does it, but my input is a String. In this code fragment, I require a dom Node. How do I turn the source String into a dom Node? –  [Steve McLeod](http://stackoverflow.com/users/2959/steve-mcleod) [Sep 26 '08 at 12:40](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment36819_139096)

|     |     |
| --- | --- |
| **4** |     |

new StreamSource(new StringReader(yourStringHere)) –  [Chris Jester-Young](http://stackoverflow.com/users/13/chris-jester-young) [Oct 20 '08 at 12:54](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment87713_139096)

|     |     |
| --- | --- |
| **1** |     |

I tried this, but the result wasn't indented (it did add some whitespace in the form of newlines). –  [13ren](http://stackoverflow.com/users/50979/13ren) [Mar 22 '09 at 9:46](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment484260_139096)

|     |     |
| --- | --- |
| **7** |     |

This solution DIDNT WORK for me, there is a bug in java5. The follow page offers a work around but that didnt work for me either (im using jdk1.5.0\_16): [johnsonsolutions.blogspot.com/2007/08/…](http://johnsonsolutions.blogspot.com/2007/08/xml-transformer-indent-doesnt-work-with.html) Kevin Hakanson solution below however did work. –  [Sam](http://stackoverflow.com/users/37575/sam) [May 15 '09 at 1:47](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment674297_139096)

|     |     |
| --- | --- |
| **24** |     |

Default indent is 0. Add `transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");` –  [David Blevins](http://stackoverflow.com/users/190816/david-blevins) [Feb 18 '12 at 22:25](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment11795487_139096)

[show **1** more comment](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#)

 101 

Here's an answer to my own question. I combined the answers from the various results to write a class that pretty prints XML.

No guarantees on how it responds with invalid XML or large documents.

    package ecb.sdw.pretty;
    
    import org.apache.xml.serialize.OutputFormat;
    import org.apache.xml.serialize.XMLSerializer;
    import org.w3c.dom.Document;
    import org.xml.sax.InputSource;
    import org.xml.sax.SAXException;
    
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.ParserConfigurationException;
    import java.io.IOException;
    import java.io.StringReader;
    import java.io.StringWriter;
    import java.io.Writer;
    
    /**
     * Pretty-prints xml, supplied as a string.
     * <p/>
     * eg.
     * <code>
     * String formattedXml = new XmlFormatter().format("<tag><nested>hello</nested></tag>");
     * </code>
     */
    public class XmlFormatter {
    
        public XmlFormatter() {
        }
    
        public String format(String unformattedXml) {
            try {
                final Document document = parseXmlFile(unformattedXml);
    
                OutputFormat format = new OutputFormat(document);
                format.setLineWidth(65);
                format.setIndenting(true);
                format.setIndent(2);
                Writer out = new StringWriter();
                XMLSerializer serializer = new XMLSerializer(out, format);
                serializer.serialize(document);
    
                return out.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    
        private Document parseXmlFile(String in) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(in));
                return db.parse(is);
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    
        public static void main(String[] args) {
            String unformattedXml =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?><QueryMessage\n" +
                            "        xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"\n" +
                            "        xmlns:query=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\">\n" +
                            "    <Query>\n" +
                            "        <query:CategorySchemeWhere>\n" +
                            "   \t\t\t\t\t         <query:AgencyID>ECB\n\n\n\n</query:AgencyID>\n" +
                            "        </query:CategorySchemeWhere>\n" +
                            "    </Query>\n\n\n\n\n" +
                            "</QueryMessage>";
    
            System.out.println(new XmlFormatter().format(unformattedXml));
        }
    
    }

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/139426)\|[improve this answer](http://stackoverflow.com/posts/139426/edit) | [edited Oct 31 '08 at 13:43](http://stackoverflow.com/posts/139426/revisions) | answered Sep 26 '08 at 13:13<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/1bf77682e06e19438854c1ea3ec5f5fa.jpg]]](http://stackoverflow.com/users/2959/steve-mcleod)<br>[Steve McLeod](http://stackoverflow.com/users/2959/steve-mcleod)<br>**20.3k**1981124 |

|     |     |
| --- | --- |
|     |     |

Thank you very much. This saved my day! –  [Enno Shioji](http://stackoverflow.com/users/234901/enno-shioji) [Jun 10 '10 at 6:32](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment3078476_139426)

|     |     |
| --- | --- |
| **12** |     |

Just to note that this answer requires the use of Xerces. If you don't want to add this dependency then you can simply use the standard jdk libraries and javax.xml.transform.Transformer (see my answer below) –  [khylo](http://stackoverflow.com/users/249672/khylo) [Dec 17 '10 at 16:28](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4888953_139426)

|     |     |
| --- | --- |
| **32** |     |

Back in 2008 this was a good answer, but now this can all be done with standard JDK classes rather than Apache classes. See [xerces.apache.org/xerces2-j/faq-general.html#faq-6](http://xerces.apache.org/xerces2-j/faq-general.html#faq-6). Yes this is a Xerces FAQ but the answer covers standard JDK classes. The initial 1.5 implementation of these classes had many issues but everything works fine from 1.6 on. Copy the LSSerializer example in the FAQ, chop the "..." bit and add `writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);` after the `LSSerializer writer = ...` line. –  [George Hawkins](http://stackoverflow.com/users/245602/george-hawkins) [May 4 '11 at 8:43](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment6763258_139426)

|     |     |
| --- | --- |
| **2** |     |

I've created a small class using the example Apache gave, which @GeorgeHawkins gave a link to. It was missing how the variable `document` was initialized, so I thought I might add in the deceleration and make a quick example out of it. Let me know if I should change something, [pastebin.com/XL7932aC](http://pastebin.com/XL7932aC) –  [samwell](http://stackoverflow.com/users/830545/samwell) [Jul 16 '12 at 16:52](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment15207259_139426)

|     |     |
| --- | --- |
|     |     |

it is not true that you can do that with jdk only. at least not reliably. it depends on some internal registry implementation that is not active with my jdk7u72 by default. so you still better use the apache stuff directly. –  [user1050755](http://stackoverflow.com/users/1050755/user1050755) [Nov 17 at 17:16](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment42490783_139426)

 76 

[a simpler solution based on this answer](http://stackoverflow.com/questions/1264849/pretty-printing-output-from-javax-xml-transform-transformer-with-only-standard-ja/1264872#1264872):

    public static String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer(); 
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
    }
    
    public static String prettyFormat(String input) {
        return prettyFormat(input, 2);
    }

testcase:

    prettyFormat("<root><child>aaa</child><child/></root>");

returns:

    <?xml version="1.0" encoding="UTF-8"?>
    <root>
      <child>aaa</child>
      <child/>
    </root>

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/1264912)\|[improve this answer](http://stackoverflow.com/posts/1264912/edit) | [edited Feb 23 '11 at 18:57](http://stackoverflow.com/posts/1264912/revisions)<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/5e6a380f7e90572a8120806105e484f1.png]]](http://stackoverflow.com/users/21548/bernardn)<br>[bernardn](http://stackoverflow.com/users/21548/bernardn)<br>**921**51016 | answered Aug 12 '09 at 8:22<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/f4e3a2aa40f5db0f0111395ed61d2f5b.jpg]]](http://stackoverflow.com/users/89266/dfa)<br>[dfa](http://stackoverflow.com/users/89266/dfa)<br>**58.3k**14127187 |

|     |     |
| --- | --- |
|     |     |

This is the code I've always used but at this company it didn't work, I assume they are using another XML transforming library. I created the factory as a separate line and then did `factory.setAttribute("indent-number", 4);` and now it works. –  [Adrian Smith](http://stackoverflow.com/users/220627/adrian-smith) [Oct 21 '10 at 13:25](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4268147_1264912)

|     |     |
| --- | --- |
|     |     |

How to make so that the output wont contain `<?xml version="1.0" encoding="UTF-8"?>`? –  [Thang Pham](http://stackoverflow.com/users/240337/thang-pham) [Jul 19 '11 at 19:13](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment8004820_1264912)

|     |     |
| --- | --- |
| **3** |     |

@Harry: `transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");` –  [jjmontes](http://stackoverflow.com/users/401656/jjmontes) [Oct 7 '11 at 9:06](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment9342198_1264912)

 45  accepted

Now it's 2012 and Java can do more than it used to with XML, I'd like to add an alternative to my accepted answer. This has no dependencies outside of Java 6.

    import org.w3c.dom.Node;
    import org.w3c.dom.bootstrap.DOMImplementationRegistry;
    import org.w3c.dom.ls.DOMImplementationLS;
    import org.w3c.dom.ls.LSSerializer;
    import org.xml.sax.InputSource;
    
    import javax.xml.parsers.DocumentBuilderFactory;
    import java.io.StringReader;
    
    /**
     * Pretty-prints xml, supplied as a string.
     * <p/>
     * eg.
     * <code>
     * String formattedXml = new XmlFormatter().format("<tag><nested>hello</nested></tag>");
     * </code>
     */
    public class XmlFormatter {
    
        public String format(String xml) {
    
            try {
                final InputSource src = new InputSource(new StringReader(xml));
                final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
                final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));
    
            //May need this: System.setProperty(DOMImplementationRegistry.PROPERTY,"com.sun.org.apache.xerces.internal.dom.DOMImplementationSourceImpl");
    
    
                final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
                final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
                final LSSerializer writer = impl.createLSSerializer();
    
                writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
                writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be outputted.
    
                return writer.writeToString(document);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    
        public static void main(String[] args) {
            String unformattedXml =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?><QueryMessage\n" +
                            "        xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"\n" +
                            "        xmlns:query=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\">\n" +
                            "    <Query>\n" +
                            "        <query:CategorySchemeWhere>\n" +
                            "   \t\t\t\t\t         <query:AgencyID>ECB\n\n\n\n</query:AgencyID>\n" +
                            "        </query:CategorySchemeWhere>\n" +
                            "    </Query>\n\n\n\n\n" +
                            "</QueryMessage>";
    
            System.out.println(new XmlFormatter().format(unformattedXml));
        }
    }

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/11519668)\|[improve this answer](http://stackoverflow.com/posts/11519668/edit) | [edited Jan 30 '13 at 5:46](http://stackoverflow.com/posts/11519668/revisions)<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/900fad0b78afca7d8fafdd3d2e414182.png]]](http://stackoverflow.com/users/1427124/daowen)<br>[DaoWen](http://stackoverflow.com/users/1427124/daowen)<br>**14.9k**11434 | answered Jul 17 '12 at 9:29<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/1bf77682e06e19438854c1ea3ec5f5fa.jpg]]](http://stackoverflow.com/users/2959/steve-mcleod)<br>[Steve McLeod](http://stackoverflow.com/users/2959/steve-mcleod)<br>**20.3k**1981124 |

|     |     |
| --- | --- |
|     |     |

No indention, but it does works with this: System.setProperty(DOMImplementationRegistry.PROPERTY,"com.sun.org.apache.xerces‌​.internal.dom.DOMImplementationSourceImpl"); –  [GGB667](http://stackoverflow.com/users/619895/ggb667) [Mar 20 '13 at 12:21](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment21987249_11519668)

|     |     |
| --- | --- |
|     |     |

How do you add indention to this example? –  [GGB667](http://stackoverflow.com/users/619895/ggb667) [Mar 20 '13 at 12:22](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment21987300_11519668)

|     |     |
| --- | --- |
|     |     |

Worked perfectly for me as-is. Using Java 6. –  [Lee Meador](http://stackoverflow.com/users/1932588/lee-meador) [Jun 12 '13 at 14:55](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment24683538_11519668)

|     |     |
| --- | --- |
|     |     |

That's a very nice solution... –  [kodmanyagha](http://stackoverflow.com/users/2132069/kodmanyagha) [Sep 19 '13 at 14:13](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment27893031_11519668)

|     |     |
| --- | --- |
|     |     |

Beautiful. Thank you, this should be a one-liner included in a standard library. –  [Josh A.](http://stackoverflow.com/users/933838/josh-a) [Jan 28 at 23:14](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment32312638_11519668)

[show **4** more comments](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#)

 44 

Just to note that top rated answer requires the use of xerces.

If you don't want to add this external dependency then you can simply use the standard jdk libraries (which actually are built using xerces internally).

N.B. There was a bug with jdk version 1.5 see <http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6296446> but it is resolved now.,

(Note if an error occurs this will return the original text)

    package com.test;
    
    import java.io.ByteArrayInputStream;
    import java.io.ByteArrayOutputStream;
    
    import javax.xml.transform.OutputKeys;
    import javax.xml.transform.Source;
    import javax.xml.transform.Transformer;
    import javax.xml.transform.sax.SAXSource;
    import javax.xml.transform.sax.SAXTransformerFactory;
    import javax.xml.transform.stream.StreamResult;
    
    import org.xml.sax.InputSource;
    
    public class XmlTest {
        public static void main(String[] args) {
            XmlTest t = new XmlTest();
            System.out.println(t.formatXml("<a><b><c/><d>text D</d><e value='0'/></b></a>"));
        }
    
        public String formatXml(String xml){
            try{
                Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
                serializer.setOutputProperty(OutputKeys.INDENT, "yes");
                //serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                //serializer.setOutputProperty("{http://xml.customer.org/xslt}indent-amount", "2");
                Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
                StreamResult res =  new StreamResult(new ByteArrayOutputStream());            
                serializer.transform(xmlSource, res);
                return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
            }catch(Exception e){
                //TODO log error
                return xml;
            }
        }
    
    }

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/4472580)\|[improve this answer](http://stackoverflow.com/posts/4472580/edit) | [edited Jan 19 '11 at 16:49](http://stackoverflow.com/posts/4472580/revisions) | answered Dec 17 '10 at 16:27<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/b01c7808723a3a7ef4fe1342ed071876.png]]](http://stackoverflow.com/users/249672/khylo)<br>[khylo](http://stackoverflow.com/users/249672/khylo)<br>**2,166**11415 |

|     |     |
| --- | --- |
|     |     |

In this case left tabs are not used. All tags begin at first symbol of the line, like usual text. –  [Ruslan](http://stackoverflow.com/users/304380/ruslan) [Dec 23 '10 at 9:57](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4946813_4472580)

|     |     |
| --- | --- |
| **2** |     |

Add this line: serializer.setOutputProperty("{[xml.apache.org/xslt](http://xml.apache.org/xslt)}indent-amount", "2") –  [Sam](http://stackoverflow.com/users/414771/sam) [Dec 24 '10 at 5:32](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4955879_4472580)

|     |     |
| --- | --- |
|     |     |

Thanks Sam, I've added that to my example above.. –  [khylo](http://stackoverflow.com/users/249672/khylo) [Jan 5 '11 at 13:14](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment5059620_4472580)

|     |     |
| --- | --- |
|     |     |

don't you need to specify a charset when converting back and forth between bytes and string? –  [Will Glass](http://stackoverflow.com/users/32978/will-glass) [Dec 2 '11 at 1:18](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment10299937_4472580)

|     |     |
| --- | --- |
|     |     |

There should be no need to convert from and to byte arrays/String. At the very least you would have to specify charset when doing so. Better option would be to use StringReader and StringWriter classes wrapped in InputSource and StreamResult. –  [maximdim](http://stackoverflow.com/users/49573/maximdim) [Dec 21 '12 at 16:00](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment19313781_4472580)

[show **1** more comment](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#)

 21 

I've pretty printed in the past using the **org.dom4j.io.OutputFormat.createPrettyPrint()** method

    public String prettyPrint(final String xml){  
    
        if (StringUtils.isBlank(xml)) {
            throw new RuntimeException("xml was null or blank in prettyPrint()");
        }
    
        final StringWriter sw;
    
        try {
            final OutputFormat format = OutputFormat.createPrettyPrint();
            final org.dom4j.Document document = DocumentHelper.parseText(xml);
            sw = new StringWriter();
            final XMLWriter writer = new XMLWriter(sw, format);
            writer.write(document);
        }
        catch (Exception e) {
            throw new RuntimeException("Error pretty printing xml:\n" + xml, e);
        }
        return sw.toString();
    }

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/260314)\|[improve this answer](http://stackoverflow.com/posts/260314/edit) | [edited Nov 4 '08 at 0:17](http://stackoverflow.com/posts/260314/revisions) | answered Nov 3 '08 at 23:22<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/5caca904f2eae1941e839520b7fa3f60.png]]](http://stackoverflow.com/users/32993/mlo55)<br>[mlo55](http://stackoverflow.com/users/32993/mlo55)<br>**241**13 |

|     |     |
| --- | --- |
| **1** |     |

The accepted solution does not properly indent the nested tags in my case, this one does. –  [Chase Seibert](http://stackoverflow.com/users/7679/chase-seibert) [Nov 6 '08 at 17:37](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment124084_260314)

 16 

Here's a way of doing it using [dom4j](http://www.dom4j.org/dom4j-1.6.1/):

Imports:

    import org.dom4j.Document;  
    import org.dom4j.DocumentHelper;  
    import org.dom4j.io.OutputFormat;  
    import org.dom4j.io.XMLWriter;

Code:

    String xml = "<your xml='here'/>";  
    Document doc = DocumentHelper.parseText(xml);  
    StringWriter sw = new StringWriter();  
    OutputFormat format = OutputFormat.createPrettyPrint();  
    XMLWriter xw = new XMLWriter(sw, format);  
    xw.write(doc);  
    String result = sw.toString();

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/2599074)\|[improve this answer](http://stackoverflow.com/posts/2599074/edit) | [edited Mar 8 '11 at 1:59](http://stackoverflow.com/posts/2599074/revisions)<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/4affdf553c6b89251c86f8e55f373799.jpg]]](http://stackoverflow.com/users/45525/synesso)<br>[Synesso](http://stackoverflow.com/users/45525/synesso)<br>**9,392**1051104 | answered Apr 8 '10 at 10:29<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/df2385041c2449f404071930e98c9c28.jpg]]](http://stackoverflow.com/users/237733/scobal)<br>[Scobal](http://stackoverflow.com/users/237733/scobal)<br>**6,269**13053 |

|     |     |
| --- | --- |
|     |     |

This didnt work for me. It just gave something like: `<?xml version...` on one line and everything else on another line. –  [sixtyfootersdude](http://stackoverflow.com/users/251589/sixtyfootersdude) [Feb 3 '12 at 20:39](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment11481992_2599074)

 11 

Since you are starting with a `String`, you need to covert to a `DOM` object (e.g. `Node`) before you can use the `Transformer`. However, if you know your XML string is valid, and you don't want to incur the memory overhead of parsing a string into a DOM, then running a transform over the DOM to get a string back - you could just do some old fashioned character by character parsing. Insert a newline and spaces after every `</...>` characters, keep and indent counter (to determine the number of spaces) that you increment for every `<...>` and decrement for every `</...>` you see.

Disclaimer - I did a cut/paste/text edit of the functions below, so they may not compile as is.

    public static final Element createDOM(String strXML) 
        throws ParserConfigurationException, SAXException, IOException {
    
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource sourceXML = new InputSource(new StringReader(strXML))
        Document xmlDoc = db.parse(sourceXML);
        Element e = xmlDoc.getDocumentElement();
        e.normalize();
        return e;
    }
    
    public static final void prettyPrint(Node xml, OutputStream out)
        throws TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.transform(new DOMSource(xml), new StreamResult(out));
    }

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/139333)\|[improve this answer](http://stackoverflow.com/posts/139333/edit) | answered Sep 26 '08 at 12:58<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/ff7e738939ff8a3e98c8ecd98d595808.png]]](http://stackoverflow.com/users/22514/kevin-hakanson)<br>[Kevin Hakanson](http://stackoverflow.com/users/22514/kevin-hakanson)<br>**16.9k**974103 |

|     |     |
| --- | --- |
|     |     |

"However, if you know your XML string is valid ..." good point. See my solution based on this approach below. –  [David Easley](http://stackoverflow.com/users/65555/david-easley) [May 27 '10 at 10:51](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment2972685_139333)

 11 

If using a 3rd party XML library is ok, you can get away with something significantly simpler than what the currently [highest-voted](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java/139096#139096) [answers](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java/139333#139333) suggest.

It was stated that both input and output should be Strings, so here's a utility method that does just that, implemented with the **[XOM](http://xom.nu/)** library:

    import nu.xom.*;
    import java.io.*;
    
    [...]
    
    public static String format(String xml) throws ParsingException, IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Serializer serializer = new Serializer(out);
        serializer.setIndent(4);  // or whatever you like
        serializer.write(new Builder().build(xml, ""));
        return out.toString("UTF-8");
    }

I tested that it works, and the results _do not_ depend on your JRE version or anything like that. To see how to customise the output format to your liking, take a look at the [`Serializer`](http://xom.nu/apidocs/nu/xom/Serializer.html) API.

This actually came out longer than I thought - some extra lines were needed because `Serializer` wants an `OutputStream` to write to. But note that there's very little code for actual XML twiddling here.

(This answer is part of my evaluation of XOM, which was [suggested](http://stackoverflow.com/questions/831865/what-java-xml-library-do-you-recommend-to-replace-dom4j/833241#833241) as one option in my [question about the best Java XML library](http://stackoverflow.com/questions/831865/what-java-xml-library-do-you-recommend-to-replace-dom4j) to replace dom4j. For the record, with dom4j you could achieve this with similar ease using [`XMLWriter`](http://dom4j.org/dom4j-1.6.1/apidocs/org/dom4j/io/XMLWriter.html) and [`OutputFormat`](http://dom4j.org/dom4j-1.6.1/apidocs/org/dom4j/io/OutputFormat.html). **Edit**: ...as demonstrated in [mlo55's answer](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java/260314#260314).)

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/962225)\|[improve this answer](http://stackoverflow.com/posts/962225/edit) | [edited Jun 8 '09 at 17:39](http://stackoverflow.com/posts/962225/revisions) | answered Jun 7 '09 at 16:26<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/0bd656eb14c50299b2744f80e69459bf.jpg]]](http://stackoverflow.com/users/56285/jonik)<br>[Jonik](http://stackoverflow.com/users/56285/jonik)<br>**22k**26124178 |

|     |     |
| --- | --- |
| **1** |     |

Thanks, that's what I was looking for. If you have an XML already parsed with XOM in a "Document" object, you can pass it directly to serializer.write(document); –  [thibaultd](http://stackoverflow.com/users/2003763/thibaultd) [Aug 13 '13 at 6:07](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment26676294_962225)

 9 

Hmmm... faced something like this and it is a known bug ... just add this OutputProperty ..

    transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "8");

Hope this helps ...

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/1948577)\|[improve this answer](http://stackoverflow.com/posts/1948577/edit) | [edited Jan 31 at 15:39](http://stackoverflow.com/posts/1948577/revisions)<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/dc9d9e6dcf4587bc889ca1a7ab7a8a57.jpg]]](http://stackoverflow.com/users/211205/rzymek)<br>[rzymek](http://stackoverflow.com/users/211205/rzymek)<br>**3,719**11624 | answered Dec 22 '09 at 19:26<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/af212ec63c07eac26ccb9284e3e4667a.png]]](http://stackoverflow.com/users/237114/sandeep-phukan)<br>[Sandeep Phukan](http://stackoverflow.com/users/237114/sandeep-phukan)<br>**99**11 |

 6 

Using scala:

    import xml._
    val xml = XML.loadString("<tag><nested>hello</nested></tag>")
    val formatted = new PrettyPrinter(150, 2).format(xml)
    println(formatted)

You can do this in Java too, if you depend on the scala-library.jar. It looks like this:

    import scala.xml.*;
    
    public class FormatXML {
        public static void main(String[] args) {
            String unformattedXml = "<tag><nested>hello</nested></tag>";
            PrettyPrinter pp = new PrettyPrinter(150, 3);
            String formatted = pp.format(XML.loadString(unformattedXml), TopScope$.MODULE$);
            System.out.println(formatted);
        }
    }

The `PrettyPrinter` object is constructed with two ints, the first being max line length and the second being the indentation step.

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/5227490)\|[improve this answer](http://stackoverflow.com/posts/5227490/edit) | answered Mar 8 '11 at 1:58<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/4affdf553c6b89251c86f8e55f373799.jpg]]](http://stackoverflow.com/users/45525/synesso)<br>[Synesso](http://stackoverflow.com/users/45525/synesso)<br>**9,392**1051104 |

 5 

Regarding comment that "you must first build a DOM tree": No, you need not and should not do that.

Instead, create a StreamSource (new StreamSource(new StringReader(str)), and feed that to the identity transformer mentioned. That'll use SAX parser, and result will be much faster. Building an intermediate tree is pure overhead for this case. Otherwise the top-ranked answer is good.

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/592146)\|[improve this answer](http://stackoverflow.com/posts/592146/edit) | answered Feb 26 '09 at 19:54<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/9a657f7990c2dafca9885dee9c647d4e.png]]](http://stackoverflow.com/users/59501/staxman)<br>[StaxMan](http://stackoverflow.com/users/59501/staxman)<br>**38k**1196134 |

 5 

Just for future reference, here's a solution that worked for me (thanks to a comment that @George Hawkins posted in one of the answers):

    DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
    DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
    LSSerializer writer = impl.createLSSerializer();
    writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
    LSOutput output = impl.createLSOutput();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    output.setByteStream(out);
    writer.write(document, output);
    String xmlStr = new String(out.toByteArray());

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/7714473)\|[improve this answer](http://stackoverflow.com/posts/7714473/edit) | answered Oct 10 '11 at 14:43<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/xEtbP.jpg]]](http://stackoverflow.com/users/13379/michael)<br>[Michael](http://stackoverflow.com/users/13379/michael)<br>**10.6k**84663 |

 4 

Kevin Hakanson said: "However, if you know your XML string is valid, and you don't want to incur the memory overhead of parsing a string into a DOM, then running a transform over the DOM to get a string back - you could just do some old fashioned character by character parsing. Insert a newline and spaces after every characters, keep and indent counter (to determine the number of spaces) that you increment for every <...> and decrement for every you see."

Agreed. Such an approach is much faster and has far fewer dependencies.

Example solution:

    /**
     * XML utils, including formatting.
     */
    public class XmlUtils
    {
      private static XmlFormatter formatter = new XmlFormatter(2, 80);
    
      public static String formatXml(String s)
      {
        return formatter.format(s, 0);
      }
    
      public static String formatXml(String s, int initialIndent)
      {
        return formatter.format(s, initialIndent);
      }
    
      private static class XmlFormatter
      {
        private int indentNumChars;
        private int lineLength;
        private boolean singleLine;
    
        public XmlFormatter(int indentNumChars, int lineLength)
        {
          this.indentNumChars = indentNumChars;
          this.lineLength = lineLength;
        }
    
        public synchronized String format(String s, int initialIndent)
        {
          int indent = initialIndent;
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < s.length(); i++)
          {
            char currentChar = s.charAt(i);
            if (currentChar == '<')
            {
              char nextChar = s.charAt(i + 1);
              if (nextChar == '/')
                indent -= indentNumChars;
              if (!singleLine)   // Don't indent before closing element if we're creating opening and closing elements on a single line.
                sb.append(buildWhitespace(indent));
              if (nextChar != '?' && nextChar != '!' && nextChar != '/')
                indent += indentNumChars;
              singleLine = false;  // Reset flag.
            }
            sb.append(currentChar);
            if (currentChar == '>')
            {
              if (s.charAt(i - 1) == '/')
              {
                indent -= indentNumChars;
                sb.append("\n");
              }
              else
              {
                int nextStartElementPos = s.indexOf('<', i);
                if (nextStartElementPos > i + 1)
                {
                  String textBetweenElements = s.substring(i + 1, nextStartElementPos);
    
                  // If the space between elements is solely newlines, let them through to preserve additional newlines in source document.
                  if (textBetweenElements.replaceAll("\n", "").length() == 0)
                  {
                    sb.append(textBetweenElements + "\n");
                  }
                  // Put tags and text on a single line if the text is short.
                  else if (textBetweenElements.length() <= lineLength * 0.5)
                  {
                    sb.append(textBetweenElements);
                    singleLine = true;
                  }
                  // For larger amounts of text, wrap lines to a maximum line length.
                  else
                  {
                    sb.append("\n" + lineWrap(textBetweenElements, lineLength, indent, null) + "\n");
                  }
                  i = nextStartElementPos - 1;
                }
                else
                {
                  sb.append("\n");
                }
              }
            }
          }
          return sb.toString();
        }
      }
    
      private static String buildWhitespace(int numChars)
      {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numChars; i++)
          sb.append(" ");
        return sb.toString();
      }
    
      /**
       * Wraps the supplied text to the specified line length.
       * @lineLength the maximum length of each line in the returned string (not including indent if specified).
       * @indent optional number of whitespace characters to prepend to each line before the text.
       * @linePrefix optional string to append to the indent (before the text).
       * @returns the supplied text wrapped so that no line exceeds the specified line length + indent, optionally with
       * indent and prefix applied to each line.
       */
      private static String lineWrap(String s, int lineLength, Integer indent, String linePrefix)
      {
        if (s == null)
          return null;
    
        StringBuilder sb = new StringBuilder();
        int lineStartPos = 0;
        int lineEndPos;
        boolean firstLine = true;
        while(lineStartPos < s.length())
        {
          if (!firstLine)
            sb.append("\n");
          else
            firstLine = false;
    
          if (lineStartPos + lineLength > s.length())
            lineEndPos = s.length() - 1;
          else
          {
            lineEndPos = lineStartPos + lineLength - 1;
            while (lineEndPos > lineStartPos && (s.charAt(lineEndPos) != ' ' && s.charAt(lineEndPos) != '\t'))
              lineEndPos--;
          }
          sb.append(buildWhitespace(indent));
          if (linePrefix != null)
            sb.append(linePrefix);
    
          sb.append(s.substring(lineStartPos, lineEndPos + 1));
          lineStartPos = lineEndPos + 1;
        }
        return sb.toString();
      }
    
      // other utils removed for brevity
    }

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/2920419)\|[improve this answer](http://stackoverflow.com/posts/2920419/edit) | answered May 27 '10 at 10:50<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/80da13871179b7de36b0493a88333e6b.png]]](http://stackoverflow.com/users/65555/david-easley)<br>[David Easley](http://stackoverflow.com/users/65555/david-easley)<br>**681**822 |

|     |     |
| --- | --- |
|     |     |

Thanks! Only this worked for me (in a JSF environment). –  [Daniel Szalay](http://stackoverflow.com/users/157762/daniel-szalay) [May 1 '11 at 16:11](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment6719970_2920419)

 3 

If you're sure that you have a valid XML, this one is simple, and avoids XML DOM trees. Maybe has some bugs, do comment if you see anything

    public String prettyPrint(String xml) {
                if (xml == null || xml.trim().length() == 0) return "";
    
                int stack = 0;
                StringBuilder pretty = new StringBuilder();
                String[] rows = xml.trim().replaceAll(">", ">\n").replaceAll("<", "\n<").split("\n");
    
                for (int i = 0; i < rows.length; i++) {
                        if (rows[i] == null || rows[i].trim().length() == 0) continue;
    
                        String row = rows[i].trim();
                        if (row.startsWith("<?")) {
                                // xml version tag
                                pretty.append(row + "\n");
                        } else if (row.startsWith("</")) {
                                // closing tag
                                String indent = repeatString("    ", --stack);
                                pretty.append(indent + row + "\n");
                        } else if (row.startsWith("<")) {
                                // starting tag
                                String indent = repeatString("    ", stack++);
                                pretty.append(indent + row + "\n");
                        } else {
                                // tag data
                                String indent = repeatString("    ", stack);
                                pretty.append(indent + row + "\n");
                        }
                }
    
                return pretty.toString().trim();
        }

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/21736245)\|[improve this answer](http://stackoverflow.com/posts/21736245/edit) | answered Feb 12 at 18:16<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/2a1adcb8ed924ecd1045fd6252a7df18.png]]](http://stackoverflow.com/users/2102748/milosmns)<br>[milosmns](http://stackoverflow.com/users/2102748/milosmns)<br>**51**15 |

 2 

I had the same problem and I'm having great success with JTidy (http://jtidy.sourceforge.net/index.html)

Example:

    Tidy t = new Tidy();
    t.setIndentContent(true);
    Document d = t.parseDOM(
        new ByteArrayInputStream("HTML goes here", null);
    
    OutputStream out = new ByteArrayOutputStream();
    t.pprint(d, out);
    String html = out.toString();

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/3026021)\|[improve this answer](http://stackoverflow.com/posts/3026021/edit) | answered Jun 11 '10 at 20:30<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/9562d9d557d19ecbbffc5f3acd9db751.jpg]]](http://stackoverflow.com/users/299075/kristoffer-jansson)<br>[Kristoffer Jansson](http://stackoverflow.com/users/299075/kristoffer-jansson)<br>**1,218**817 |

|     |     |
| --- | --- |
|     |     |

Does jTidy work for pure XML, or is it only for (X)HTML? –  [khylo](http://stackoverflow.com/users/249672/khylo) [Dec 17 '10 at 16:32](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment4888999_3026021)

|     |     |
| --- | --- |
|     |     |

Doesn't seem to work for pure XML. Only HTMLS. –  [BeepDog](http://stackoverflow.com/users/423218/beepdog) [Jun 29 '11 at 19:38](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java#comment7683270_3026021)

 1 

there is a very nice command line xml utility called xmlstarlet(<http://xmlstar.sourceforge.net/>) that can do a lot of things which a lot of people use.

Your could execute this program programatically using Runtime.exec and then readin the formatted output file. It has more options and better error reporting than a few lines of Java code can provide.

download xmlstarlet : <http://sourceforge.net/project/showfiles.php?group_id=66612&package_id=64589>

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/139929)\|[improve this answer](http://stackoverflow.com/posts/139929/edit) | answered Sep 26 '08 at 14:38<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/bea5dab764a7a4945d874b9fecfc1802.png]]](http://stackoverflow.com/users/11142/anjanb)<br>[anjanb](http://stackoverflow.com/users/11142/anjanb)<br>**5,672**73771 |

 1 

XMLBeans can do a lot of fun things with your XML as well. :)

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/139956)\|[improve this answer](http://stackoverflow.com/posts/139956/edit) | answered Sep 26 '08 at 14:42<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/00e9091682bac83e8c63543cab096c99.png]]](http://stackoverflow.com/users/18673/ace)<br>[Ace](http://stackoverflow.com/users/18673/ace)<br>**3,086**52643 |

 1 

slightly improved version from [milosmns](http://stackoverflow.com/a/21736245/619587)...

    public static String getPrettyXml(String xml) {
        if (xml == null || xml.trim().length() == 0) return "";
    
        int stack = 0;
        StringBuilder pretty = new StringBuilder();
        String[] rows = xml.trim().replaceAll(">", ">\n").replaceAll("<", "\n<").split("\n");
    
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == null || rows[i].trim().length() == 0) continue;
    
            String row = rows[i].trim();
            if (row.startsWith("<?")) {
                pretty.append(row + "\n");
            } else if (row.startsWith("</")) {
                String indent = repeatString(--stack);
                pretty.append(indent + row + "\n");
            } else if (row.startsWith("<") && row.endsWith("/>") == false) {
                String indent = repeatString(stack++);
                pretty.append(indent + row + "\n");
                if (row.endsWith("]]>")) stack--;
            } else {
                String indent = repeatString(stack);
                pretty.append(indent + row + "\n");
            }
        }
    
        return pretty.toString().trim();
    }

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/24650999)\|[improve this answer](http://stackoverflow.com/posts/24650999/edit) | answered Jul 9 at 10:17<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/5a1beabf7cb845fed808382840a0eac8.png]]](http://stackoverflow.com/users/619587/codeskraps)<br>[codeskraps](http://stackoverflow.com/users/619587/codeskraps)<br>**153**17 |

 0 

I have found that in Java 1.6.0\_32 the normal method to pretty print an XML **_string_** (using a Transformer with a null or identity xslt) does not behave as I would like if tags are merely separated by whitespace, as opposed to having no separating text. I tried using `<xsl:strip-space elements="*"/>` in my template to no avail. The simplest solution I found was to strip the space the way I wanted using a SAXSource and XML filter. Since my solution was for logging I also extended this to work with incomplete XML fragments. Note the normal method seems to work fine if you use a DOMSource but I did not want to use this because of the incompleteness and memory overhead.

    public static class WhitespaceIgnoreFilter extends XMLFilterImpl
    {
    
        @Override
        public void ignorableWhitespace(char[] arg0,
                                        int arg1,
                                        int arg2) throws SAXException
        {
            //Ignore it then...
        }
    
        @Override
        public void characters( char[] ch,
                                int start,
                                int length) throws SAXException
        {
            if (!new String(ch, start, length).trim().equals("")) 
                   super.characters(ch, start, length); 
        }
    }
    
    public static String prettyXML(String logMsg, boolean allowBadlyFormedFragments) throws SAXException, IOException, TransformerException
        {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            transFactory.setAttribute("indent-number", new Integer(2));
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StringWriter out = new StringWriter();
            XMLReader masterParser = SAXHelper.getSAXParser(true);
            XMLFilter parser = new WhitespaceIgnoreFilter();
            parser.setParent(masterParser);
    
            if(allowBadlyFormedFragments)
            {
                transformer.setErrorListener(new ErrorListener()
                {
                    @Override
                    public void warning(TransformerException exception) throws TransformerException
                    {
                    }
    
                    @Override
                    public void fatalError(TransformerException exception) throws TransformerException
                    {
                    }
    
                    @Override
                    public void error(TransformerException exception) throws TransformerException
                    {
                    }
                });
            }
    
            try
            {
                transformer.transform(new SAXSource(parser, new InputSource(new StringReader(logMsg))), new StreamResult(out));
            }
            catch (TransformerException e)
            {
                if(e.getCause() != null && e.getCause() instanceof SAXParseException)
                {
                    if(!allowBadlyFormedFragments || !"XML document structures must start and end within the same entity.".equals(e.getCause().getMessage()))
                    {
                        throw e;
                    }
                }
                else
                {
                    throw e;
                }
            }
            out.flush();
            return out.toString();
        }

|     |     |
| --- | --- |
| [share](http://stackoverflow.com/a/11351356)\|[improve this answer](http://stackoverflow.com/posts/11351356/edit) | answered Jul 5 '12 at 19:36<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/4eb335dbf18628a794fe170d8f85fef3.png]]](http://stackoverflow.com/users/851774/jfk)<br>[JFK](http://stackoverflow.com/users/851774/jfk)<br>**190**211 |

 0 

The solutions I have found here for Java 1.6+ do not reformat the code if it is already formatted. The one that worked for me (and re-formatted already formatted code) was the following.

    import org.apache.xml.security.c14n.CanonicalizationException;
    import org.apache.xml.security.c14n.Canonicalizer;
    import org.apache.xml.security.c14n.InvalidCanonicalizerException;
    import org.w3c.dom.Element;
    import org.w3c.dom.bootstrap.DOMImplementationRegistry;
    import org.w3c.dom.ls.DOMImplementationLS;
    import org.w3c.dom.ls.LSSerializer;
    import org.xml.sax.InputSource;
    import org.xml.sax.SAXException;
    
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.ParserConfigurationException;
    import javax.xml.transform.TransformerException;
    import java.io.IOException;
    import java.io.StringReader;
    
    public class XmlUtils {
        public static String toCanonicalXml(String xml) throws InvalidCanonicalizerException, ParserConfigurationException, SAXException, CanonicalizationException, IOException {
            Canonicalizer canon = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_OMIT_COMMENTS);
            byte canonXmlBytes[] = canon.canonicalize(xml.getBytes());
            return new String(canonXmlBytes);
        }
    
        public static String prettyFormat(String input) throws TransformerException, ParserConfigurationException, IOException, SAXException, InstantiationException, IllegalAccessException, ClassNotFoundException {
            InputSource src = new InputSource(new StringReader(input));
            Element document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            Boolean keepDeclaration = input.startsWith("<?xml");
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            LSSerializer writer = impl.createLSSerializer();
            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
            writer.getDomConfig().setParameter("xml-declaration", keepDeclaration);
            return writer.writeToString(document);
        }
    }

It is a good tool to use in your unit tests for full-string xml comparison.

    private void assertXMLEqual(String expected, String actual) throws ParserConfigurationException, IOException, SAXException, CanonicalizationException, InvalidCanonicalizerException, TransformerException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        String canonicalExpected = prettyFormat(toCanonicalXml(expected));
        String canonicalActual = prettyFormat(toCanonicalXml(actual));
        assertEquals(canonicalExpected, canonicalActual);
    }

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/26361221)\|[improve this answer](http://stackoverflow.com/posts/26361221/edit) | [edited Oct 14 at 12:56](http://stackoverflow.com/posts/26361221/revisions) | answered Oct 14 at 12:47<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/fb59cc865cf7c719f14ec349452032fb.png]]](http://stackoverflow.com/users/2685402/wojtek)<br>[Wojtek](http://stackoverflow.com/users/2685402/wojtek)<br>**67**10 |

 0 

For those searching for a quick and dirty solution - which doesn't need the XML to be 100% valid. e.g. in case of REST / SOAP logging (you never know what the others send ;-))

I found and advanced a code snipped I found online which I think is still missing here as a valid possible approach:

    public static String prettyPrintXMLAsString(String xmlString) {
        /* Remove new lines */
        final String LINE_BREAK = "\n";
        xmlString = xmlString.replaceAll(LINE_BREAK, "");
        StringBuffer prettyPrintXml = new StringBuffer();
        /* Group the xml tags */
        Pattern pattern = Pattern.compile("(<[^/][^>]+>)?([^<]*)(</[^>]+>)?(<[^/][^>]+/>)?");
        Matcher matcher = pattern.matcher(xmlString);
        int tabCount = 0;
        while (matcher.find()) {
            String str1 = (null == matcher.group(1) || "null".equals(matcher.group())) ? "" : matcher.group(1);
            String str2 = (null == matcher.group(2) || "null".equals(matcher.group())) ? "" : matcher.group(2);
            String str3 = (null == matcher.group(3) || "null".equals(matcher.group())) ? "" : matcher.group(3);
            String str4 = (null == matcher.group(4) || "null".equals(matcher.group())) ? "" : matcher.group(4);
    
            if (matcher.group() != null && !matcher.group().trim().equals("")) {
                printTabs(tabCount, prettyPrintXml);
                if (!str1.equals("") && str3.equals("")) {
                    ++tabCount;
                }
                if (str1.equals("") && !str3.equals("")) {
                    --tabCount;
                    prettyPrintXml.deleteCharAt(prettyPrintXml.length() - 1);
                }
    
                prettyPrintXml.append(str1);
                prettyPrintXml.append(str2);
                prettyPrintXml.append(str3);
                if (!str4.equals("")) {
                    prettyPrintXml.append(LINE_BREAK);
                    printTabs(tabCount, prettyPrintXml);
                    prettyPrintXml.append(str4);
                }
                prettyPrintXml.append(LINE_BREAK);
            }
        }
        return prettyPrintXml.toString();
    }
    
    private static void printTabs(int count, StringBuffer stringBuffer) {
        for (int i = 0; i < count; i++) {
            stringBuffer.append("\t");
        }
    }
    
    public static void main(String[] args) {
        String x = new String(
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><soap:Fault><faultcode>soap:Client</faultcode><faultstring>INVALID_MESSAGE</faultstring><detail><ns3:XcbSoapFault xmlns=\"\" xmlns:ns3=\"http://www.someapp.eu/xcb/types/xcb/v1\"><CauseCode>20007</CauseCode><CauseText>INVALID_MESSAGE</CauseText><DebugInfo>Problems creating SAAJ object model</DebugInfo></ns3:XcbSoapFault></detail></soap:Fault></soap:Body></soap:Envelope>");
        System.out.println(prettyPrintXMLAsString(x));
    }

here is the output:

    <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
      <soap:Body>
        <soap:Fault>
            <faultcode>soap:Client</faultcode>
            <faultstring>INVALID_MESSAGE</faultstring>
            <detail>
                <ns3:XcbSoapFault xmlns="" xmlns:ns3="http://www.someapp.eu/xcb/types/xcb/v1">
                    <CauseCode>20007</CauseCode>
                    <CauseText>INVALID_MESSAGE</CauseText>
                    <DebugInfo>Problems creating SAAJ object model</DebugInfo>
                </ns3:XcbSoapFault>
            </detail>
        </soap:Fault>
      </soap:Body>
    </soap:Envelope>

|     |     |     |
| --- | --- | --- |
| [share](http://stackoverflow.com/a/19236572)\|[improve this answer](http://stackoverflow.com/posts/19236572/edit) | [edited Dec 2 at 21:30](http://stackoverflow.com/posts/19236572/revisions)<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/6efb26e6a6cac66df7d8be86fc51ef0d.jpg]]](http://stackoverflow.com/users/102510/tim)<br>[Tim](http://stackoverflow.com/users/102510/tim)<br>**412**513 | answered Oct 7 '13 at 23:32<br>[![[./_resources/How_to_pretty_print_XML_from_Java_-_Stack_Overflow_stackoverflow.com.resources/zPNr0.jpg]]](http://stackoverflow.com/users/767434/max)<br>[max](http://stackoverflow.com/users/767434/max)<br>**175**17 |

## Your Answer

### Sign up or [log in](http://stackoverflow.com/users/login?returnurl=%2fquestions%2f139076%2fhow-to-pretty-print-xml-from-java%23new-answer)

Sign up using Google

Sign up using Facebook

Sign up using Stack Exchange

### Post as a guest

**Name**
**Email**

By posting your answer, you agree to the [privacy policy](http://stackexchange.com/legal/privacy-policy) and [terms of service](http://stackexchange.com/legal/terms-of-service).

## Not the answer you're looking for? Browse other questions tagged [java](http://stackoverflow.com/questions/tagged/java) [xml](http://stackoverflow.com/questions/tagged/xml) [pretty-print](http://stackoverflow.com/questions/tagged/pretty-print) or [ask your own question](http://stackoverflow.com/questions/ask).

|     |     |
| --- | --- |
| asked | **6 years ago** |
| viewed | **207910 times** |
| active | **[8 days ago](http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java?lastactivity)** |

#### Linked

[0](http://stackoverflow.com/q/18607343?lq=1)[How to formate the xml in java dom parser?](http://stackoverflow.com/questions/18607343/how-to-formate-the-xml-in-java-dom-parser?lq=1)
[58](http://stackoverflow.com/q/376373?lq=1)[Pretty printing XML with javascript](http://stackoverflow.com/questions/376373/pretty-printing-xml-with-javascript?lq=1)
[62](http://stackoverflow.com/q/831865?lq=1)[What Java XML library do you recommend (to replace dom4j)?](http://stackoverflow.com/questions/831865/what-java-xml-library-do-you-recommend-to-replace-dom4j?lq=1)
[29](http://stackoverflow.com/q/1264849?lq=1)[Pretty-printing output from javax.xml.transform.Transformer with only standard java api (Indentation and Doctype positioning)](http://stackoverflow.com/questions/1264849/pretty-printing-output-from-javax-xml-transform-transformer-with-only-standard-j?lq=1)
[16](http://stackoverflow.com/q/161462?lq=1)[Java: Writing a DOM to an XML file (formatting issues)](http://stackoverflow.com/questions/161462/java-writing-a-dom-to-an-xml-file-formatting-issues?lq=1)
[14](http://stackoverflow.com/q/290326?lq=1)[StAX XML formatting in Java](http://stackoverflow.com/questions/290326/stax-xml-formatting-in-java?lq=1)
[19](http://stackoverflow.com/q/3364627?lq=1)[How to produce nicely formatted XML in Scala?](http://stackoverflow.com/questions/3364627/how-to-produce-nicely-formatted-xml-in-scala?lq=1)
[5](http://stackoverflow.com/q/5511096?lq=1)[Java : Convert formatted xml file to one line string](http://stackoverflow.com/questions/5511096/java-convert-formatted-xml-file-to-one-line-string?lq=1)
[6](http://stackoverflow.com/q/484995?lq=1)[Java/DOM: Get the XML content of a node](http://stackoverflow.com/questions/484995/java-dom-get-the-xml-content-of-a-node?lq=1)
[1](http://stackoverflow.com/q/2571866?lq=1)[Java XML Output - proper indenting for child items](http://stackoverflow.com/questions/2571866/java-xml-output-proper-indenting-for-child-items?lq=1)
[see more linked questions…](http://stackoverflow.com/questions/linked/139076?lq=1)

#### Related

[991](http://stackoverflow.com/q/352098?rq=1)[How can I pretty-print JSON?](http://stackoverflow.com/questions/352098/how-can-i-pretty-print-json?rq=1)
[58](http://stackoverflow.com/q/376373?rq=1)[Pretty printing XML with javascript](http://stackoverflow.com/questions/376373/pretty-printing-xml-with-javascript?rq=1)
[29](http://stackoverflow.com/q/1264849?rq=1)[Pretty-printing output from javax.xml.transform.Transformer with only standard java api (Indentation and Doctype positioning)](http://stackoverflow.com/questions/1264849/pretty-printing-output-from-javax-xml-transform-transformer-with-only-standard-j?rq=1)
[217](http://stackoverflow.com/q/1820908?rq=1)[How to turn off the Eclipse code formatter for certain sections of Java code?](http://stackoverflow.com/questions/1820908/how-to-turn-off-the-eclipse-code-formatter-for-certain-sections-of-java-code?rq=1)
[6](http://stackoverflow.com/q/7526542?rq=1)[Configurable XML pretty printer for java](http://stackoverflow.com/questions/7526542/configurable-xml-pretty-printer-for-java?rq=1)
[2](http://stackoverflow.com/q/8507518?rq=1)[Pretty Print XML in Eclipse Console from Display View](http://stackoverflow.com/questions/8507518/pretty-print-xml-in-eclipse-console-from-display-view?rq=1)
[0](http://stackoverflow.com/q/15074534?rq=1)[pretty-printing malformed xml](http://stackoverflow.com/questions/15074534/pretty-printing-malformed-xml?rq=1)
[0](http://stackoverflow.com/q/17053091?rq=1)[Should indenting XML in Java respect `xml:space=“preserve”`?](http://stackoverflow.com/questions/17053091/should-indenting-xml-in-java-respect-xmlspace-preserve?rq=1)
[1](http://stackoverflow.com/q/17538167?rq=1)[How to pretty print XML from Smalltalk?](http://stackoverflow.com/questions/17538167/how-to-pretty-print-xml-from-smalltalk?rq=1)
[0](http://stackoverflow.com/q/25864316?rq=1)[Pretty print XML in java 8](http://stackoverflow.com/questions/25864316/pretty-print-xml-in-java-8?rq=1)

#### [Hot Network Questions](http://stackexchange.com/questions?tab=hot)

* [Who can use magic scrolls?](http://rpg.stackexchange.com/questions/51979/who-can-use-magic-scrolls)

* [Sum the time durations](http://codegolf.stackexchange.com/questions/42300/sum-the-time-durations)
* [Someone I manage keeps cc'ing my boss](http://workplace.stackexchange.com/questions/37308/someone-i-manage-keeps-ccing-my-boss)
* [Can I cast spells that require a material component and still hold my hammer and shield?](http://rpg.stackexchange.com/questions/51976/can-i-cast-spells-that-require-a-material-component-and-still-hold-my-hammer-and)
* [Is it "perfectly legal" to walk topless in New York City](http://skeptics.stackexchange.com/questions/25112/is-it-perfectly-legal-to-walk-topless-in-new-york-city)
* [Binding const& of temporary: No compiler warning?](http://stackoverflow.com/questions/27423364/binding-const-of-temporary-no-compiler-warning)
* [Get minimal logging when loading data into temporary tables](http://dba.stackexchange.com/questions/85892/get-minimal-logging-when-loading-data-into-temporary-tables)
* [Is it unfair to regrade prior work after detecting cheating?](http://academia.stackexchange.com/questions/33041/is-it-unfair-to-regrade-prior-work-after-detecting-cheating)
* [Downloading software without bloatware](http://superuser.com/questions/850766/downloading-software-without-bloatware)
* [What is the function of "_initLayout" in magento?](http://magento.stackexchange.com/questions/48037/what-is-the-function-of-initlayout-in-magento)
* [Can we buy licenses for e-books and lend them to students?](http://academia.stackexchange.com/questions/33040/can-we-buy-licenses-for-e-books-and-lend-them-to-students)
* [What makes a good lecturer?](http://academia.stackexchange.com/questions/33021/what-makes-a-good-lecturer)
* [How can I start Hoard of the Dragon Queen with 4th level characters?](http://rpg.stackexchange.com/questions/51989/how-can-i-start-hoard-of-the-dragon-queen-with-4th-level-characters)
* [Can I combine different wheel sizes in one mtb?](http://bicycles.stackexchange.com/questions/27082/can-i-combine-different-wheel-sizes-in-one-mtb)
* [How would two ships travelling at light speed communicate with one another?](http://worldbuilding.stackexchange.com/questions/6327/how-would-two-ships-travelling-at-light-speed-communicate-with-one-another)
* [Is there a saying or proverb for a situation where the weakest party will always lose?](http://english.stackexchange.com/questions/212626/is-there-a-saying-or-proverb-for-a-situation-where-the-weakest-party-will-always)
* [Union of conjugates in p-groups](http://mathoverflow.net/questions/190467/union-of-conjugates-in-p-groups)
* [How (il)legal is to get data from a 100% accessible but not "exposed" API](http://webmasters.stackexchange.com/questions/73908/how-illegal-is-to-get-data-from-a-100-accessible-but-not-exposed-api)
* [Why would you place potatoes on salt when baking in the oven?](http://cooking.stackexchange.com/questions/50468/why-would-you-place-potatoes-on-salt-when-baking-in-the-oven)
* [I'm too tired to drive -grammatical BUT I'm tired to drive -ungrammatical. How?](http://ell.stackexchange.com/questions/42713/im-too-tired-to-drive-grammatical-but-im-tired-to-drive-ungrammatical-how)
* [Why is Wednesday called “Mittwoch”?](http://german.stackexchange.com/questions/18462/why-is-wednesday-called-mittwoch)
* [Career advice: How can I move on from my probable PhD flop?](http://academia.stackexchange.com/questions/33032/career-advice-how-can-i-move-on-from-my-probable-phd-flop)
* [What do we call 'ketchup', 'cheesy dip' , 'oregano' and things like that, as they aren't side dishes?](http://ell.stackexchange.com/questions/42722/what-do-we-call-ketchup-cheesy-dip-oregano-and-things-like-that-as-the)
* [Can you say berachot in your underwear?](http://judaism.stackexchange.com/questions/50287/can-you-say-berachot-in-your-underwear)

[question feed](http://stackoverflow.com/feeds/question/139076)

[tour](http://stackoverflow.com/tour) [help](http://stackoverflow.com/help) [blog](http://blog.stackoverflow.com/?blb=1) [chat](http://chat.stackoverflow.com/) [data](http://data.stackexchange.com/) [legal](http://stackexchange.com/legal) [privacy policy](http://stackexchange.com/legal/privacy-policy) [work here](http://stackexchange.com/work-here) [advertising info](http://stackexchange.com/mediakit)  **[contact us](http://stackoverflow.com/contact)** **[feedback](http://meta.stackoverflow.com/)**

| Technology |     |     | Life / Arts | Culture / Recreation | Science | Other |
| --- | --- | --- | --- | --- | --- | --- |
| 1. [Stack Overflow](http://stackoverflow.com/)<br>2. [Server Fault](http://serverfault.com/)<br>3. [Super User](http://superuser.com/)<br>4. [Web Applications](http://webapps.stackexchange.com/)<br>5. [Ask Ubuntu](http://askubuntu.com/)<br>6. [Webmasters](http://webmasters.stackexchange.com/)<br>7. [Game Development](http://gamedev.stackexchange.com/)<br>8. [TeX - LaTeX](http://tex.stackexchange.com/) | 1. [Programmers](http://programmers.stackexchange.com/)<br>2. [Unix & Linux](http://unix.stackexchange.com/)<br>3. [Ask Different (Apple)](http://apple.stackexchange.com/)<br>4. [WordPress Development](http://wordpress.stackexchange.com/)<br>5. [Geographic Information Systems](http://gis.stackexchange.com/)<br>6. [Electrical Engineering](http://electronics.stackexchange.com/)<br>7. [Android Enthusiasts](http://android.stackexchange.com/)<br>8. [Information Security](http://security.stackexchange.com/) | 1. [Database Administrators](http://dba.stackexchange.com/)<br>2. [Drupal Answers](http://drupal.stackexchange.com/)<br>3. [SharePoint](http://sharepoint.stackexchange.com/)<br>4. [User Experience](http://ux.stackexchange.com/)<br>5. [Mathematica](http://mathematica.stackexchange.com/)<br>6. [Salesforce](http://salesforce.stackexchange.com/)<br>7. [more (13)](http://stackexchange.com/sites#technology) | 1. [Photography](http://photo.stackexchange.com/)<br>2. [Science Fiction & Fantasy](http://scifi.stackexchange.com/)<br>3. [Graphic Design](http://graphicdesign.stackexchange.com/)<br>4. [Seasoned Advice (cooking)](http://cooking.stackexchange.com/)<br>5. [Home Improvement](http://diy.stackexchange.com/)<br>6. [Personal Finance & Money](http://money.stackexchange.com/)<br>7. [Academia](http://academia.stackexchange.com/)<br>8. [more (10)](http://stackexchange.com/sites#lifearts) | 1. [English Language & Usage](http://english.stackexchange.com/)<br>2. [Skeptics](http://skeptics.stackexchange.com/)<br>3. [Mi Yodeya (Judaism)](http://judaism.stackexchange.com/)<br>4. [Travel](http://travel.stackexchange.com/)<br>5. [Christianity](http://christianity.stackexchange.com/)<br>6. [Arqade (gaming)](http://gaming.stackexchange.com/)<br>7. [Bicycles](http://bicycles.stackexchange.com/)<br>8. [Role-playing Games](http://rpg.stackexchange.com/)<br>9. [more (21)](http://stackexchange.com/sites#culturerecreation) | 1. [Mathematics](http://math.stackexchange.com/)<br>2. [Cross Validated (stats)](http://stats.stackexchange.com/)<br>3. [Theoretical Computer Science](http://cstheory.stackexchange.com/)<br>4. [Physics](http://physics.stackexchange.com/)<br>5. [MathOverflow](http://mathoverflow.net/)<br>6. [more (7)](http://stackexchange.com/sites#science) | 1. [Stack Apps](http://stackapps.com/)<br>2. [Meta Stack Exchange](http://meta.stackexchange.com/)<br>3. [Area 51](http://area51.stackexchange.com/)<br>4. [Stack Overflow Careers](http://careers.stackoverflow.com/?utm_source=stackoverflow.com&utm_medium=site-ui&utm_campaign=footerlink) |

site design / logo © 2014 stack exchange inc; user contributions licensed under [cc by-sa 3.0](http://creativecommons.org/licenses/by-sa/3.0/) with [attribution required](http://blog.stackoverflow.com/2009/06/attribution-required/)
rev 2014.12.11.2098
