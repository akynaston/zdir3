importPackage(Packages.com.novell.ldap);
importPackage(Packages.java.lang);
var tracer = new Packages.com.novell.nds.dirxml.driver.Trace("ldapModify");
/**
* ldapModify
*
* (String} host LDAP Server, either DNS or IP-Address
* (Number} port LDAP listening port
* (String} usetls (true | false | starttls)
* (String} keystore path to java keystore containing the trusted root cert to verify the server cert (used only with usetls="true")
* (String} keypass keystore password
* (String} user user account, full distinguished name, LDAP syntax
* (String} password the cleartext LDAP userpassword
* (String} object object to be updated
* (String} attrname name of attribute to be updated
* (String} attrvalue value to be set
* @type Nodeset
* @return NodeSet containing result or status element with error message
*/

function ldapModify(host, port, usetls, keystore, keypass, user, password, object, attrname, attrvalue) { var nodeSet = new Packages.com.novell.xml.xpath.NodeSet();
  var document = Packages.com.novell.xml.dom.DocumentFactory.newDocument();
  var ndsElement = document.createElement("nds");
  document.appendChild(ndsElement);
  ndsElement.setAttributeNS(null, "dtdversion", "3.5");
  var outputElement = document.createElement("output");
  ndsElement.appendChild(outputElement);
  try {
    if (usetls == "true" || usetls == "starttls") {
        if (keystore != "") {
          tracer.trace("Setting up TLS/SSL keystore", 3);
          tracer.trace(" usetls = " usetls, 5);
          tracer.trace(" keystore = " keystore, 5);
          tracer.trace(" keypass = " keypass, 5);
          // Sets the keystore that Java will use System.setProperty("javax.net.ssl.trustStore", keystore);
          if (keypass != "") { // Sets the keystore password System.setProperty("javax.net.ssl.trustStorePassword", keypass);
          }
      } if (usetls == "true") { // Creates an appropriate SecureSocketFactory tracer.trace("Preparing new TLS/SSL connection.", 3);
        var ssf = new LDAPJSSESecureSocketFactory();
      } else { tracer.trace("Preparing new StartTLS connection.", 3);
        var ssf = new LDAPJSSEStartTLSFactory();
      }
        var lc = new LDAPConnection(ssf);
    } else { tracer.trace("Preparing new plaintext connection.", 3);
      var lc = new LDAPConnection();
    }
    tracer.trace("Connecting to " host ":" port, 3);
    lc.connect(host, port);
    var connected = true;
    if (usetls == "starttls") {
      tracer.trace("Start TLS protocol on connection.", 3);
      lc.startTLS();
    }
    tracer.trace("Binding as user " user, 3);

    lc.bind(LDAPConnection.LDAP_V3, user, new java.lang.String(password).getBytes("UTF8"));

    tracer.trace("Executing modify.", 3);
    tracer.trace(" object = " object, 3);
    tracer.trace(" attrname = " attrname, 3);
    tracer.trace(" attrvalue = " attrvalue, 3);
    var ldapAttribute = new LDAPAttribute(attrname, attrvalue);
    var ldapModification = new LDAPModification(LDAPModification.REPLACE, ldapAttribute);
    lc.modify(object,ldapModification);
    if (usetls == "starttls") { tracer.trace("Stopping TLS protocol.", 3);
      lc.stopTLS();
    }
  } catch (e) { var errorMessage = e.toString();

  tracer.trace(errorMessage, 0);
  ar statusElement = document.createElement("status");
  statusElement.setAttributeNS(null, "level", "error");
  statusElement.appendChild(document.createTextNode(errorMessage));
  outputElement.appendChild(statusElement);
  nodeSet.add(statusElement);
  } finally {
    if (connected) {
      tracer.trace("Disconnecting from server.", 3);
      lc.disconnect();
    }
  } return nodeSet;
}
