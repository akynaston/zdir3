<?xml version="1.0" encoding="UTF-8"?><driver-configuration config-type="ECMAScriptResourceImpl" dn="cn=MCL,cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" driver-set-dn="cn=Driver Set v3,ou=DirXML,ou=Services,o=swaiddev" name="ECMATools">
	<children>
		<resource content-type="text/ecmascript;charset=UTF-8" name="ECMATools">
			<content contains="text"><![CDATA[   <content contains="text">/*
 *	Copyright © 2009 TriVir, LLC. All rights reserved.
 *
 *  Except as otherwise permitted by TriVir, LLC., this publication, or parts
 *  thereof, may not be reproduced in any form, by any method, for any purpose.
 */
importPackage(Packages.javax.naming.directory);
importClass(Packages.java.io.File);
importClass(Packages.java.io.FileInputStream);
importClass(Packages.java.lang.System);
importClass(Packages.java.security.KeyStore);
importClass(Packages.java.util.Hashtable);
importClass(Packages.javax.naming.Context);
importClass(Packages.org.w3c.dom.Document);
importClass(Packages.org.w3c.dom.Element);
importClass(Packages.com.novell.nds.dirxml.driver.Trace);
importClass(Packages.com.novell.xml.xpath.NodeSet);
importClass(Packages.com.novell.xml.dom.DocumentFactory);

// Used by getXMLfromURL() function
importClass(Packages.java.net.HttpURLConnection);
importClass(Packages.java.net.URL);
importClass(Packages.java.io.DataOutputStream);
importClass(Packages.java.io.InputStreamReader);
importClass(Packages.java.io.BufferedReader);
importClass(Packages.java.lang.StringBuffer);
importClass(Packages.java.lang.Integer);

var trustStore = null;
var trustStoreType = null;
var trustStorePassword = null;
var debug = false;

//see https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
if (!String.prototype.trim) {
  String.prototype.trim = function () {
    return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, '');
  };
}

function isString(string) {
	//TODO: do we need to do an instanceof test also?
    return (typeof string === 'string');
}

function isBlank(string) {
	return (!string || (isString(string) &amp;&amp; !string.trim()));
}

function addErrorStatus(document, ndsElement, error) {
	var outputElement = document.createElement("output");
	ndsElement.appendChild(outputElement);
	var statusElement = document.createElement("status");
	statusElement.setAttributeNS(null, "level", "error");
	statusElement.appendChild(document.createTextNode(error));
	outputElement.appendChild(statusElement);
}

 /**
 	Function wrapper for ldapsearch to help catch errors, and convert the result into a document for easier management
 */
function ldapSearchReturnAsDocument(host, useSSL, user, password, base, scope, filter, attrList) {
	try {
		nodeSetValue = ldapSearch(host, useSSL, user, password, base, scope, filter, attrList);
	} catch (e) {
		new Trace("ldapSearch").trace("Failed while executing ldap search, exception: " + e, 4);
		return "Failed while executing ldap search, exception: " + e;
	}

	try {
		nodeFirst = nodeSetValue.first();
	} catch(e) {
		new Trace("ldapSearch").trace("Failed while calling first: " + e);
		return "Failed while calling first: " + e;
	}

	try {
		return nodeFirst.getOwnerDocument();
	} catch(e) {
		new Trace("ldapSearch").trace("Failed while calling getownerdocument: " + e);
		return "Failed while calling getownerdocument: " + e;
	}

}

/**
 *  ldapSearch
 *
 * @param (String) host             DNS or IP-Address of LDAP server optionally including the listening port (e.g. 192.168.0.1:389)
 * @param (booelan) useSSL          Connect to the server using SSL
 * @param (String) user             Full distinguished name of LDAP account (e.g. sn=admin,o=users)
 * @param (String) password         Password for LDAP account
 * @param (String) base             Search base
 * @param (String) scope            Search scope, either base, one, or sub
 * @param (String) filter           LDAP search filter according to RFC2254
 * @param (String) attrList         Comma separated list of attributes to return
 * @return
 * @type Nodeset
 * @return NodeSet containing instances from search result, or status element with error message
 */
function ldapSearch(host, useSSL, user, password, base, scope, filter, attrList)
{
	var tracePrefix = "ldapSearch";
	var traceLevelDetails = 3;

	var trace = new Trace(tracePrefix);

	trace.trace("Validating parameters for ldapSearch...", traceLevelDetails);

	// Convert string to a full boolean so "if (useSSL)" compares properly:
	if (useSSL == 'true') {
		useSSL = true;
	} else {
		useSSL = false;
	}

	//TODO: if lowercase attr cotains 'password', do not trace the value
	trace.trace("host    : '" + host + "'");
	trace.trace("useSSL  : " + useSSL);
	trace.trace("user    : '" + user + "'");
	if (debug) {
		trace.trace("password: '" + password + "' (Turn off debug to remove this trace.)");
	}
	trace.trace("base    : '" + base + "'");
	trace.trace("scope   : '" + scope + "'");
	trace.trace("filter  : '" + filter + "'");
	trace.trace("attrList: '" + attrList + "'");

	if (isBlank(host)) {
		var msg = "Missing required 'host' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(password)) {
		var msg = "Missing required 'password' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	var nodeSet = new NodeSet();
	var document = DocumentFactory.newDocument();
	var ndsElement   = document.createElement("nds");
	document.appendChild(ndsElement);
	ndsElement.setAttributeNS(null, "dtdversion", "3.5");

    var ctls = new SearchControls();
    ctls.setCountLimit(0);
    ctls.setTimeLimit(0);
    if (scope.equalsIgnoreCase("base")) {
        ctls.setSearchScope(SearchControls.OBJECT_SCOPE);
    } else if (scope.equalsIgnoreCase("one")) {
        ctls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
    } else {
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
    }

	var attrArray = attrList.split(",");

	ctls.setReturningAttributes(attrArray);

	// Validate Trust Store if one is specified
    if (useSSL) {
        if (trustStore != null) {
            if (new File(trustStore).exists() == false) {
                addErrorStatus(document, ndsElement, "Keystore '" + trustStore + "' does not exist.");
                nodeSet.add(ndsElement);
                return nodeSet;
            }

            var keystore;
			try {
				keystore = KeyStore.getInstance(trustStoreType != null ? trustStoreType : KeyStore.getDefaultType());
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error initializing keystore: " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}

            // Load the keystore contents
            var inputStream;
			try {
				inputStream = new FileInputStream(trustStore);
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error opening keystore '" + trustStore + "': " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}

            try {
				keystore.load(inputStream, null);
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error loading keystore '" + trustStore + "': " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}

			try {
				inputStream.close();
			} catch (e) {
                addErrorStatus(document, ndsElement, "Error closing keystore '" + trustStore + "': " + e.javaException.getMessage());
                nodeSet.add(ndsElement);
                return nodeSet;
			}
        }
	}

    var env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, user);
    env.put(Context.SECURITY_CREDENTIALS, password);
    env.put("com.sun.jndi.ldap.connect.timeout", "5000");
    if (useSSL) {
        env.put(Context.PROVIDER_URL, "ldaps://" + host);
        if (trustStore != null) {
            System.setProperty("javax.net.ssl.trustStore", trustStore);
            if (trustStoreType != null) {
                System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);
            }
            if (trustStorePassword != null) {
                System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
            }
        }
        if (debug) {
            System.setProperty("javax.net.debug", "SSL,trustmanager");
        }
    } else {
        env.put(Context.PROVIDER_URL, "ldap://" + host);
	}

	var context = null;
    try {
        context = new InitialDirContext(env);
    } catch (e) {
        if (useSSL) {
            addErrorStatus(document, ndsElement, "Failed to obtain an SSL LDAP Connection: " + e.javaException.getMessage());
            nodeSet.add(ndsElement);
			return nodeSet;
        } else {
            addErrorStatus(document, ndsElement, "Failed to obtain an LDAP Connection: " + e.javaException.getMessage());
            nodeSet.add(ndsElement);
			return nodeSet;
        }
    }

	try {
		var outputElement = document.createElement("output");

		//Find objects with a matching filter
        var searchResults = context.search(base, filter, ctls);
        while (searchResults.hasMore()) {
			var nextEntry = searchResults.next();
        	var foundObjectDn;
        	if(nextEntry.getName() != null &amp;&amp; nextEntry.getName().length() &gt; 0) {
        		foundObjectDn = nextEntry.getName() + "," + base;
        	} else {
    			foundObjectDn = base;
        	}

			// create the instance node
			var instanceElement = document.createElement("instance");
			instanceElement.setAttributeNS(null,"src-dn", foundObjectDn);

			var attributeSet = nextEntry.getAttributes();
			var allAttributes = attributeSet.getAll();

			while (allAttributes.hasMore()) {
				var attribute =	allAttributes.next();
				var attrElement = document.createElement("attr");
				attrElement.setAttributeNS(null, "attr-name", attribute.getID());

				var allValues = attribute.getAll();

				if (allValues != null) {
					while(allValues.hasMoreElements()) {
						var value = allValues.nextElement();
						if (value instanceof String) {
						var valueElement = document.createElement("value");
							valueElement.appendChild(document.createTextNode(value));
						attrElement.appendChild(valueElement);
                        } else {
                            new Trace("ldapSearch").trace("Not adding value for '" + attribute.getID() + "' because it is not a String.", 4);
						}
					}
					instanceElement.appendChild(attrElement);
				}
			}
			outputElement.appendChild(instanceElement);
			nodeSet.add(instanceElement);
		}
		ndsElement.appendChild(outputElement);
	} catch(e) {
        document = DocumentFactory.newDocument();
		ndsElement = document.createElement("nds");
		document.appendChild(ndsElement);
		ndsElement.setAttributeNS(null, "dtdversion", "3.5");
        addErrorStatus(document, ndsElement, e.toString());
        nodeSet.add(ndsElement);
	}

	try {
		context.close();
	} catch (e) {
	}
	return nodeSet;
}

function addErrorStatus(document, ndsElement, error) {
	var outputElement = document.createElement("output");
	ndsElement.appendChild(outputElement);
	var statusElement = document.createElement("status");
	statusElement.setAttributeNS(null, "level", "error");
	statusElement.appendChild(document.createTextNode(error));
	outputElement.appendChild(statusElement);
}


function serialize(nodeSet)
{
	var stringWriter = new java.io.StringWriter();
	for (var node = nodeSet.first(); node; node=nodeSet.next())
	{
		var domWriter = new Packages.com.novell.xml.dom.DOMWriter(node, stringWriter);
		domWriter.setIndent(true);
		domWriter.write();
		domWriter.flush();
		stringWriter.write('\n');
	}
	return stringWriter.toString();
}

// File writer for debug logging
function writeFile(outputDir, driver, message) {

	if (outputDir.length &gt; 0) {
	    var logEntryTimeStamp = new java.text.SimpleDateFormat("yyyy-MM-dd-hh.mm.ss.S").format(new java.util.Date());
	    var logFileTimeStamp = new java.text.SimpleDateFormat("EEEE").format(new java.util.Date());
	    try {
	    	var pw = new java.io.PrintWriter(new java.io.FileWriter(outputDir + "/" + "idmDebug-" + driver + "-" + logFileTimeStamp + ".log", true));
	    	pw.println(logEntryTimeStamp + ": " + driver + " : " + message);
	    	pw.close();
	    } catch (e) {
	    	return "Error:" + e.toString();
	    }
	    return "Successfully wrote to file.";
	  }
	  return "No debug dir, skpping log."
}

// Very simle file writer for simple logging
function writeFileSimple(outputDir, message) {

	if (outputDir.length &gt; 0) {
	    var logEntryTimeStamp = new java.text.SimpleDateFormat("yyyy-MM-dd-hh.mm.ss.SSS").format(new java.util.Date());
	    var logFileTimeStamp = new java.text.SimpleDateFormat("EEEE").format(new java.util.Date());
	    try {
	    	var pw = new java.io.PrintWriter(new java.io.FileWriter(outputDir, true));
	    	pw.println(logEntryTimeStamp + " - " + message);
	    	pw.close();
	    } catch (e) {
	    	return "Error:" + e.toString();
	    }
	    return "Successfully wrote to file.";
	  }
	  return "No debug dir, skpping log."
}

// Expects to connect to a URL that returns an XML document.  Returns that doc as a String.
function getXMLFromURL(urlString)  {

	var url = new URL(urlString);
	var connection = url.openConnection();
	connection.setRequestMethod("GET");


	var responseCode = connection.getResponseCode();

//	var is = connection.getInputStream();
//  var isr = new InputStreamReader(is);
	var br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	var responseBuffer = new StringBuffer();
	var line;
	while ((line=br.readLine()) != null)  {
	  responseBuffer.append(line);
	}
  	br.close();
  	connection.disconnect();


  	var response = responseBuffer.toString();

  	// Sometimes the response begings with an unprintable character.
    if (response.charAt(0) != '&lt;')  {
      response = response.substring(1);
    }

  	return response;
}

importClass(Packages.com.novell.xml.util.Base64Codec);
importClass(java.io.ByteArrayOutputStream);
importClass(java.lang.System);
importClass(java.lang.Integer);

var JString = java.lang.String;

function buildDynamicGroupMemberQuery(tree, context, attrName, attrValue) {
  //00 00 00 00 02 00 00 00 2C 00 00 00
  //O = n o v e l l . t = g w a p p s t r e e
  //00 00 02 00 00 00 01 00 00 00
  //00 00 00 00 07 00 00 00 12 00 00 00
  //eDir-attr-name
  //00 00 00 00 10 00 00 00
  //eDir-attr-value
  //2A 00 00 00

  //Setup a default encoding if nothing is specified previously.
  encoding = System.getProperty("file.encoding")

  var byteData = new ByteArrayOutputStream();
  //outputStream.write(a);
  //outputStream.write(b);

  //Setting up the static part of the value.
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(2);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(hex2dec("2C"));  //Some kind of byte offset for context/tree length.  For 18 characters (36 bytes), 2C (44) is shown.
  //Example: dc=org,t=gwappstree = 19 chars = 38 bytes = 40 offset = 0x28
  var offsetLength = ((3 + tree.length + context.length) * 2) + 2;
  byteData.write(offsetLength);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);

  //return new JString(Base64Codec.encode(new JString(str).getBytes(encoding)));

  //Add in the context, then the tree.
  //byteData.write(new JString(context).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(context).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);
  byteData.write(hex2dec("2E"));
  byteData.write(0);
  byteData.write(hex2dec("74"));
  byteData.write(0);
  byteData.write(hex2dec("3D"));
  byteData.write(0);
  //byteData.write(new JString(tree).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(tree).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);

  //Add in more static stuff.
  byteData.write(0);
  byteData.write(0);
  byteData.write(2);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(1);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(7);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(hex2dec("12")); //Represents the number of bytes to offset for the attribute name.
  //'uniqueid' = 8 chars = 16 bytes = 18 = 0x12
  var offsetLength = ((attrName.length) * 2) + 2;
  byteData.write(offsetLength);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);

  //Add in the attribute name and, eventually, value.
  //byteData.write(new JString(attrName).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(attrName).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(hex2dec("10")); //Represents the number of bytes to offset for the value.
  //'test00*' = 7 chars = 14 bytes = 16 = 0x10
  var offsetLength = ((attrValue.length) * 2) + 2;
  byteData.write(offsetLength);
  byteData.write(0);
  byteData.write(0);
  byteData.write(0);
  //byteData.write(new JString(attrValue).getBytes(encoding));
  var byteArray = spliceBytesWithNulls(new JString(attrValue).getBytes(encoding));
  byteData.write(byteArray, 0, byteArray.length);
  byteData.write(0);
  byteData.write(0);

  //The value needs to have a number of bytes that is evenly disible by four, so make sure that happens padding with nulls.
  if(byteData.size() % 4) {
    byteData.write(0);
    byteData.write(0);
  }

  return new JString(Base64Codec.encode(byteData.toByteArray()));
}

/**
 * Silly function to put null bytes between other bytes in a byte array.
 */
function spliceBytesWithNulls(origByteArray) {
  var newByteArrayStream = new ByteArrayOutputStream();
  for(var ctr0 = 0; ctr0 &lt; origByteArray.length; ++ctr0) {
    newByteArrayStream.write(origByteArray[ctr0]);
    newByteArrayStream.write(0);
  }
  return newByteArrayStream.toByteArray();
}

/**
 * Convert a hex string into an integer.
 *
 * @param hexStr     hex string
 * @return intStr    int string
 */
function hex2dec(hexStr) {
  return Integer.parseInt(hexStr, 16);
}




/**
 *  ldapModifyAttr
 *
 * @param (String)  host            DNS or IP-Address of LDAP server optionally including the listening port (e.g. 192.168.0.1:389)
 * @param (boolean) useSSL          Connect to the server using SSL
 * @param (String)  user            Full distinguished name of LDAP account (e.g. sn=admin,o=users)
 * @param (String)  password        Password for LDAP account
 * @param (String)  dn              The DN of the object to modify
 * @param (String)  attr            The name of the attribute to modify
 * @param (String)  op              "add", "replace", or "remove"
 * @param (String)  value           The attribute value to modify
 * @return
 */
function ldapModifyAttr(host, useSSL, user, password, dn, attr, op, value)
{
	//comment out Trace references when testing outside of IDM (at least until we figure out how to register a customer trace handler)

	var tracePrefix = "ldapModifyAttr";
	var traceLevelDetails = 3;

	var trace = new Trace(tracePrefix);

	trace.trace("Validating parameters...", traceLevelDetails);

	// Convert string to a full boolean so "if (useSSL)" compares properly:
	if (useSSL == 'true') {
		useSSL = true;
	} else {
		useSSL = false;
	}



	//TODO: if lowercase attr cotains 'password', do not trace the value
	trace.trace("host    : '" + host + "'");
	trace.trace("useSSL  : " + useSSL);
	trace.trace("user    : '" + user + "'");
	if (debug) {
		trace.trace("password: '" + password + "'");
	}
	trace.trace("dn      : '" + dn + "'");
	trace.trace("attr    : '" + attr + "'");
	trace.trace("op      : '" + op + "'");
	trace.trace("value   : '" + value + "'");

	if (isBlank(host)) {
		var msg = "Missing required 'host' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(password)) {
		var msg = "Missing required 'password' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(dn)) {
		var msg = "Missing required 'dn' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(attr)) {
		var msg = "Missing required 'attr' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(op)) {
		var msg = "Missing required 'op' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	if (isBlank(value)) {
		var msg = "Missing required 'value' param value";
		trace.trace(msg);
		return "error: " + msg;
	}

	var operation;

	switch (op) {
		case "add":
			operation = DirContext.ADD_ATTRIBUTE
			break;
		case "remove":
			operation = DirContext.REMOVE_ATTRIBUTE
			break;
		case "replace":
			operation = DirContext.REPLACE_ATTRIBUTE
			break;
		default:
		    var msg = "Invalid 'op' param value: '" + op + "'";
			trace.trace(msg);
			return "error: " + msg;
	}

    if (useSSL == 'true') {
        if (trustStore != null) {
			trace.trace("Validating truststore...", traceLevelDetails);

            if (new File(trustStore).exists() == false) {
				var msg = "Keystore '" + trustStore + "' does not exist.";
				trace.trace(msg);
				return "error: " + msg;
            }

            var keystore;
			try {
				keystore = KeyStore.getInstance(trustStoreType != null ? trustStoreType : KeyStore.getDefaultType());
			} catch (e) {
				var msg = "Error initializing keystore: " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}

            // Load the keystore contents
            var inputStream;
			try {
				inputStream = new FileInputStream(trustStore);
			} catch (e) {
				var msg = "Error opening keystore '" + trustStore + "': " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}

            try {
				keystore.load(inputStream, null);
			} catch (e) {
				var msg = "Error loading keystore '" + trustStore + "': " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}

			try {
				inputStream.close();
			} catch (e) {
				var msg = "Error closing keystore '" + trustStore + "': " + e.javaException.getMessage();
				trace.trace(msg);
				return "error: " + msg;
			}
        }
	}

	trace.trace("Getting directory context...", traceLevelDetails);

    var env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, user);
    env.put(Context.SECURITY_CREDENTIALS, password);
    env.put("com.sun.jndi.ldap.connect.timeout", "5000");
    if (useSSL) {
        env.put(Context.PROVIDER_URL, "ldaps://" + host);
        if (trustStore != null) {
            System.setProperty("javax.net.ssl.trustStore", trustStore);
            if (trustStoreType != null) {
                System.setProperty("javax.net.ssl.trustStoreType", trustStoreType);
            }
            if (trustStorePassword != null) {
                System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
            }
        }
        if (debug) {
            System.setProperty("javax.net.debug", "SSL,trustmanager");
        }
    } else {
        env.put(Context.PROVIDER_URL, "ldap://" + host);
	}

	var context = null;
    try {
        context = new InitialDirContext(env);
    } catch (e) {
        if (useSSL) {
			var msg = "Failed to obtain a SSL directory context: " + e.javaException.getMessage();
			trace.trace(msg);
			return "error: " + msg;
        } else {
			var msg = "Failed to obtain a directory context: " + e.javaException.getMessage();
			trace.trace(msg);
			return "error: " + msg;
        }
    }

	trace.trace("Modifying attribute '" + attr + "'...", traceLevelDetails);

	try {
		var modItem = new ModificationItem(operation, new BasicAttribute(attr, value));
		var modItems = [modItem];
		context.modifyAttributes(dn, modItems);
	} catch(e) {
		var msg = "Unable to modify attribute '" + attr + "': " + e.javaException.getMessage();
		trace.trace(msg);
		return "error: " + msg;
	} finally {
		try {
			context.close();
        } catch (e) {
			trace.trace("Failed to close directory context: " + e.javaException.getMessage());
		    //ignore
        }
    }

	trace.trace("Done", traceLevelDetails);

	return "success";
}

/*
 *	Function to get the full count of days between two dates in the yyyy-MM-dd format.
 * Note: Before Aug13, 2018, this was getMonthsBetween; but months aren't clear enough - days are more deterministic; so we've moved to this format.
 */
function getDaysBetween(start, end) {
	var startLD = java.time.LocalDate.parse(start, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
	var endLD = java.time.LocalDate.parse(end, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
	return java.time.temporal.ChronoUnit.DAYS.between(startLD, endLD);
}

/*
 * calculateEventTime - Used to time some events.
 */
function calculateEventTimeSeconds (startTime, endTime) {
	return endTime-startTime;
}
function calculateEventTimeMinutes (startTime, endTime) {
	return (endTime-startTime)/60;
}

function canNotify(currentAttrName, currentAttrValueInSeconds, nowSecondsSince1970, trainingLifetimeSeconds) {
	if (currentAttrValueInSeconds.length == 0) {
		// Avoid the NumberFormatException if we see this:
		currentAttrValueInSeconds = "0";
	}

	if (currentAttrName == "abcTrainingLastCompleted") {
		currentAttrValueInSeconds = java.lang.Long.parseLong(currentAttrValueInSeconds) + java.lang.Long.parseLong(trainingLifetimeSeconds);
	}

	//return "currentAttrValueInSeconds: " + currentAttrValueInSeconds + "\nnowSecondsSince1970: " + nowSecondsSince1970;

	// If the current attr value is greater than our compare to value, it means that the date given us hasn't yet expired, so we don't want to
	//	 update the notification object, and return false;.
	if (java.lang.Long.parseLong(currentAttrValueInSeconds) &gt; java.lang.Long.parseLong(nowSecondsSince1970)) {
		return "false";
	}
	// otherwise, we'll notify on this attribute.
	return "true";
}
</content>
        </resource>
        <resource content-type="text/ecmascript;charset=UTF-8" name="WebLibrary">
            <content contains="text">importClass(com.novell.nds.dirxml.driver.Trace);


importClass(java.io.BufferedReader);
importClass(java.io.IOException);
importClass(java.io.InputStream);
importClass(java.io.InputStreamReader);
importClass(java.net.HttpURLConnection);
importClass(java.net.URL);
importClass(java.nio.file.Files);
importClass(java.nio.file.Paths);
importClass(java.nio.file.StandardCopyOption);
importClass(java.util.Map);

function executeHTTPGetToString(traceName, requestUrl, headers, timeout) {
    return executeRequestReturnResponseAsString(traceName, requestUrl, headers, timeout);
}

// traceName: String to prefix items in driver trace.
// requestURL: full url to pull down the user input file for SF driver.
// filePath: temporary full name to file to write (should end in something other than .xml
// finalExtension: extension that will be added to final file when the driver should process it.
function executeHTTPGetToFile(traceName, requestUrl, filePath, finalExtension, headers, timeout) {
    return executeRequestWriteResponseToFile(traceName, requestUrl, filePath, finalExtension, headers, timeout);
}

function executeRequestReturnResponseAsString(traceName, requestUrl, headers, timeout) {
    var trace = new Trace(traceName);
    var response = executeRequest(trace, requestUrl, headers, timeout);
    if (response != null) {
        try {
            var br = new BufferedReader(new InputStreamReader(response));
            trace.trace("Reading Response...", 5);
            var messageBody = new java.lang.StringBuilder();
            var c;
            while ((c = br.read()) !== -1) {
                messageBody.append(java.lang.Character.toString(c));
            }
            br.close();
            return messageBody.toString();
        } catch (e) {
            trace.trace(java.lang.String.format("ERROR: Unable to process response data: %s", e), 1);
        }
    }
    return null;
}

/*
    Must return a string of the success; do not throw from this function.
*/
function executeRequestWriteResponseToFile(traceName, requestUrl, filePath, finalExtension, headers, timeout) {
    var trace = new Trace(traceName);
    var is;
    try {
        trace.trace("about to execute");
        is = executeRequest(trace, requestUrl, headers, timeout);
        trace.trace("done: about");
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Failed to execute HTTP GET: %s", e);
        trace.trace(msg, 1);
        return msg;
    }

    trace.trace("checking is");

    if (is != null) {
        trace.trace(java.lang.String.format("Writing Response to file: %s", filePath), 5);

        // writing file to temporary place; then renaming below: this ensures the driver doesn't try to read partially downloaded file.
        try {
            Files.copy(is, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            is.close();
        } catch (e) {
            var msg = java.lang.String.format("ERROR: Unable to write response data to output file %s: %s", filePath, e);
            trace.trace(msg, 1);
            return msg;
        }

		// Renaming file so the driver can start processing:
        try {
            Files.copy(Paths.get(filePath), Paths.get(filePath + finalExtension), StandardCopyOption.REPLACE_EXISTING);
        } catch (e) {
            var msg = java.lang.String.format("ERROR: Unable to copy temporary file %s to final driverinput file %s: %s", filePath, (filePath + finalExtension), e);
            trace.trace(msg, 1);
            return msg;
        }
    } else {
        var msg = "ERROR: Failed to get input stream from URL, no additional information available!";
        trace.trace(msg, 1);
        return msg;
    }
    return "Success";
}


/*
 Throws an exception when it fails - must be caught and converted into a policy friendly value.
*/
function executeRequest(trace, requestUrl, headers, timeout) {
    trace.trace("(executeRequest)Retrieving data...", 5);
    var conn;
    try {
        var url = new URL(requestUrl);
        trace.trace("(executeRequest) . . .Opening connection (Timeout: " + timeout + ")", 5);
        conn = url.openConnection(); // doesn't actually connect here . .
		conn.setReadTimeout(timeout); //read timeout in milliseconds
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Unable to setup to connect to URL: %s", e);
        trace.trace(msg, 1);
        //return msg;
        throw msg;
    }
    trace.trace("(executeRequest) . . .Setting headers . .", 5);

    if (headers != null &amp;&amp; !headers.isEmpty()) {
        for (i = headers.entrySet().iterator(); i.hasNext();) {
            var headerItem = i.next();
            conn.setRequestProperty(headerItem.getKey(), headerItem.getValue());
        }
    }

    try {
       // Do an explicit connection to do a santicy check . .
       trace.trace("(executeRequest) . . .Testing connection to url:" + requestUrl, 5);
       conn.connect();
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Unable to connect to URL: %s", e)
        trace.trace(msg, 1);
        throw msg;
    }

    trace.trace("(executeRequest) . . .Checking response . .", 5);

  	var responseCode = conn.getResponseCode();
	trace.trace(("Exiting executeRequest response code: " + responseCode), 5);
    try {//It was proposed to move this up two lines above var. abcS never implemented that so it stays here for now - ckynaston
        if (conn.getResponseCode() &lt; 400) {
            return conn.getInputStream();
        } else {
            return conn.getErrorStream();
        }
    } catch (e) {
        var msg = java.lang.String.format("ERROR: Unable to acquire response data: %s", e)
        trace.trace(msg, 1);
        throw msg;
    }
    trace.trace("Exiting executeRequest . . .", 5);
}




// ****************************************************************************
// Use the following when testing out side of Rhino:
// ****************************************************************************
/*
Trace.registerImpl(com.trivir.ecma.lib.CustomTraceInterface, 1);

// test:trivir -
var basicAuth = "Basic dGVzdDp0cml2aXIx"
var headers = new java.util.HashMap();
headers.put("Authorization", basicAuth);
var destFileNameStaging = "output.xml"


//function executeHTTPGetToFile(traceName, requestUrl, filePath, finalExtension, headers,timeout) {
var response = executeHTTPGetToFile('SFFeed', 'http://172.17.2.110:3000/HRDataService.aspx?op=FN_EXPORT_AUTH_EXTRACT&amp;FMT=XML&amp;ACTION=DOWNLOAD&amp;SCHEMA=IGNORE', destFileNameStaging, '.xml', headers,4500000);

var trace = new Trace("FINAL");
trace.trace(response, 5);

*/]]></content>
		</resource>
	</children>
</driver-configuration>