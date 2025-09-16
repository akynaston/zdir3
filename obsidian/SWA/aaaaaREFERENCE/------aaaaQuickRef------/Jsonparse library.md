2/3/2025 12:28:03 AM

Possibly can add the 'booleansToBlank' functionality below . . .instead, willjust add a blank XML value before we call this library; since this affects many drivers.

function attr2objmodify(el, booleansToBlank) {
    // https://www.netiq.com/documentation/identity-manager-developer/dtd-documentation/ndsdtd/attr.html
    var ret = {
        attrname: null,
        attrvalue: null
    };
    if (el.getAttributes().getNamedItem('attr-name') != null && el.getElementsByTagName('add-value').getLength() > 0) {  
        // Coercing attrname to ECMA String to avoid JSON conversion error
        ret.attrname = String(el.getAttributes().getNamedItem('attr-name').getNodeValue());
        ret.attrvalue = attrvalue2obj(el.getElementsByTagName('add-value').item(0).getElementsByTagName('value'));;
    } else if ( booleansToBlank === "true" && el.getAttributes().getNamedItem('attr-name') != null && el.getElementsByTagName('add-value').getLength() === 0 && el.getElementsByTagName('remove-value').getLength() > 0 ) {
    	//2025-03-25: On a remove value, we've chosen to provide a blank string to represent the value to be blanked out.
        ret.attrname = String(el.getAttributes().getNamedItem('attr-name').getNodeValue());
        ret.attrvalue = "";    	
    }
    return ret;
}