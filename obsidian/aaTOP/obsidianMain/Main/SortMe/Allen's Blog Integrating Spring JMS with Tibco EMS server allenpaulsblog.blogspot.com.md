# Allen's Blog: Integrating Spring JMS with Tibco EMS server [allenpaulsblog.blogspot.com]

# [Allen's Blog](http://allenpaulsblog.blogspot.com/)

## Sunday, October 3, 2010

### Integrating Spring JMS with Tibco EMS server

Today, I will try to demonstrate how the Spring JMS API can be used to Integrate Java based Apps with the Tibco JMS Server.
Spring JMS works on the fundamental concept of Dependency Injection which is core to the Spring framework. For a JMS Sender on a very high level, a Connection factory is injected along with the destination name to a JNDI template object, which again is then injected to the actual JMS Sender bean. The JMS Sender bean is a custom piece of code, but implements the JMSTemplate interface from Spring. Once implemented, basic JMS Operations can be easily performed.
Below I'm detailing the steps for implementing a JMS Queue Sender first, followed by a Queue Listener.
1) We will use the applicationContext.xml file to construct all our beans. First we configure the JNDI context parameters using Spring classes
Set the jndiTemplate class from Spring as a bean, and inject it's property constructor in the following manner:

<
bean id\="jndiTemplate" class\="org.springframework.jndi.JndiTemplate"\><property name\="environment"\><props\><prop key\="java.naming.factory.initial"\>com.tibco.tibjms.naming.TibjmsInitialContextFactory</prop\><prop key\="java.naming.provider.url"\>localhost</prop\></props\></property\>
Note the Tibco specific factory name.  I also have a Tibco EMS server running on my localhost, hence will be using localhost as the provider url ( If you use a different port, then port number needs to be part of the URL too. Please refer to the Tibco EMS documentation for more info)
2) Once the jndi template is created, we will now create the actual JNDI objects using Spring's JNDI Object Factory bean.
<

bean id\="internalJmsQueueConnectionFactory"class\="org.springframework.jndi.JndiObjectFactoryBean"\><property name\="jndiTemplate"\><ref bean\="jndiTemplate"/></property\><property name\="jndiName"\><value\>QueueConnectionFactory</value\></property\>
<!-- JMS Sender Destination -->
<bean id\="senderdestination"class\="org.springframework.jndi.JndiObjectFactoryBean"\><property name\="jndiTemplate"\><ref bean\="jndiTemplate"/></property\><property name\="jndiName"\><value\>jms/SPRING.SENDER.TEST</value\></property\>3) Now that we have created the JNDI template, it's time to create the JMS Queue template as below
<!-- JMS Queue Template --><bean id\="jmsTemplate" class\="org.springframework.jms.core.JmsTemplate"\><property name\="connectionFactory"\><ref bean\="internalJmsQueueConnectionFactory"/></property\><property name\="defaultDestination"\><ref bean\="senderdestination"/></property\><property name\="receiveTimeout"\><value\>30000</value\></property\>
4) Now we have a logical entity to send a JMS Message. But wait.. nothing refers to this entity. We need to create a simple Java bean which provides getter setter for the jmsTemplate and then use one of the factory methods to send a message. Once done the bean needs to be declared in the xml file too, so that it can be accessed by external programs ( like your jsp's and swing gui's)
EMSMessageSender.java
**
import
org.apache.commons.logging.Log;**
import
org.apache.commons.logging.LogFactory;**
import
org.springframework.jms.core.JmsTemplate;**
import

org.w3c.dom.Document;**
public

}

**class EMSMessageSender {**private **static Log _log = LogFactory._getLog_(EMSMessageSender.**class);**private JmsTemplate jmsTemplate;**public JmsTemplate getJmsTemplate() {**return jmsTemplate;/\*\*\* **@param jmsTemplate The jmsTemplate to set.\*/

}

}

}
}
5) The EMS Message Creator used by the EMS Message sender above is a simple class implementing the Spring MessageCreator interface. It retuns the TextMessage that needs to be sent to the JMS queue.
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.MessageCreator;
import org.w3c.dom.Document;
public class EMSMessageCreatorImpl implements MessageCreator {
 private static Log log = LogFactory.getLog(EMSMessageCreatorImpl.class);
 private Session sess;
 public Document doc;
 public EMSMessageCreatorImpl(Document doc){
  this.doc = doc;
 }
 @Override
 public Message createMessage(Session sess) throws JMSException {
  OutputStream byteOut = new ByteArrayOutputStream();
  DOMSource dom = new DOMSource(doc);
  TextMessage tm = null;
 
  try {     
   TransformerFactory transformerfactory = TransformerFactory.newInstance(); // Getting new TransformerFactory
   Transformer transformer = transformerfactory.newTransformer();  // Getting new Transformer
   transformer.transform(dom, new StreamResult(byteOut)); // Transforms DOMSource to StreamResult
   this.sess = sess;
   tm = sess.createTextMessage();
   tm.setText(byteOut.toString());
  }
  catch (Exception e) {
   String msg = "Failed to create a message - " + e.getMessage();
   log.fatal(msg, e);
   throw new JMSException(msg);
  }
  return tm;
 
 }
 public Session getSess(){
  return sess;
 }
}
6) Finally, we wire the bean along with the jms template, so that it can be used externally
<bean id\="jmsSender" class\="EMSMessageSender"\><property name\="jmsTemplate"\><ref bean\="jmsTemplate"/></property\></bean\>

7) That's it!! we're done. Let's test it out now

If our test program runs outside the application, then it will not have access to the application context, and hence the jms bean. We thus need to give it the application context manually. If our class is inside the application, we can implement the ApplicationContextAware interface by Spring, and bingo..
For our purpose, here's a test servlet. I'm using a test xml which will be converted into a DOM document, which will be then sent to the JMS queue.
  **java.io.IOException;**
import

java.io.\*;**
import
javax.servlet.ServletException;**
import
javax.servlet.http.HttpServletRequest;**
import
javax.servlet.http.HttpServletResponse;**
import

javax.servlet.\*;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
**
import
org.springframework.web.context.ServletContextAware;**
import
org.springframework.web.context.support.WebApplicationContextUtils;**import　org.springframework.web.context.\*;**
import
com.aoc.SpringEMS.EMSMessageSender;**import

ServletContext ctx =

JMSSender jmssender =

System.
WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(ctx);
EMSMessageSender emssender = (EMSMessageSender)wc.getBean(
dbf
\= DocumentBuilderFactory._newInstance_();doc = dbf.newDocumentBuilder().parse("C:/test.xml");

emssender.sendMessage(doc);
}

Writer resp = response.getWriter();
resp.write(
} 
}
That's it. You should have successfully been able to send the JMS message, once the servlet runs.**try{**catch ( Exception e){System.out.println(e.getMessage());}"Got request");****  com.aoc.SpringEMS.SendMessage;**public **class JMSSender **extends javax.servlet.http.HttpServlet {**static **final **long _serialVersionUID = 1L;**protected **void doGet(HttpServletRequest request, HttpServletResponse response) **throws ServletException, IOException {**this.getServletContext();**if (ctx == **null){System._out.println("");}**new JMSSender();_out.println("test");"jmsSender");_**_************_**********************************
import
**public **void setJmsTemplate(JmsTemplate jmsTemplate) {**this.jmsTemplate = jmsTemplate;**public **void sendMessage(Document doc) {**if (doc == **null) {_log.warn("Document is null.");jmsTemplate.send(**new EMSMessageCreatorImpl(doc));**_************************_****************</bean\> </bean\></bean\></bean\>

Posted by [Allen](http://www.blogger.com/profile/13733654594581482886) at [11:21 AM](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.html)
[Email This](http://www.blogger.com/share-post.g?blogID=8746948548879348721&postID=3835230176513450502&target=email)[BlogThis!](http://www.blogger.com/share-post.g?blogID=8746948548879348721&postID=3835230176513450502&target=blog)[Share to Twitter](http://www.blogger.com/share-post.g?blogID=8746948548879348721&postID=3835230176513450502&target=twitter)[Share to Facebook](http://www.blogger.com/share-post.g?blogID=8746948548879348721&postID=3835230176513450502&target=facebook)[Share to Pinterest](http://www.blogger.com/share-post.g?blogID=8746948548879348721&postID=3835230176513450502&target=pinterest)

Labels: [Spring Tibco EMS](http://allenpaulsblog.blogspot.com/search/label/Spring%20Tibco%20EMS)

#### 2 comments:

1. ![[./_resources/Allen's_Blog_Integrating_Spring_JMS_with_Tibco_EMS_server_allenpaulsblog.blogspot.com.resources/b36-rounded.png]]
	
	[Vincent](http://www.blogger.com/profile/15279721939809093339)[July 10, 2011 at 6:15 PM](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.html?showComment=1310346950237#c6739908391837076357)
	
	code is not readable. Would you please re-post the code? Thanks!
	
	[Reply](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.htmljavascript:;)
	
2. ![[./_resources/Allen's_Blog_Integrating_Spring_JMS_with_Tibco_EMS_server_allenpaulsblog.blogspot.com.resources/b36-rounded.png]]
	
	[Phoebe](http://www.blogger.com/profile/08671573953233255726)[July 8, 2012 at 9:33 AM](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.html?showComment=1341765211123#c7908291513802923601)
	
	Thanks you so much - your blog saved me hours of research, trial and errors! I was able to use your configuration (except the jmsTemplate) and I was able to durably subscribe to a topic using DefaultMessageListenerContainer.
	
	[Reply](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.htmljavascript:;)
	

[Load more...](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.htmljavascript:;)

<https://www.blogger.com/comment-iframe.g?blogID=8746948548879348721&postID=3835230176513450502&blogspotRpcToken=2135141>

[Home](http://allenpaulsblog.blogspot.com/)

Subscribe to: [Post Comments (Atom)](http://allenpaulsblog.blogspot.com/feeds/3835230176513450502/comments/default)

## Followers

## Blog Archive

* [Integrating Spring JMS with Tibco EMS server](http://allenpaulsblog.blogspot.com/2010/10/integrating-spring-jms-with-tibco-ems.html)

## About Me

[Allen](http://www.blogger.com/profile/13733654594581482886)

[View my complete profile](http://www.blogger.com/profile/13733654594581482886)

|     |     |
| --- | --- |
|     |     |

Ethereal template. Powered by [Blogger](http://www.blogger.com/).
