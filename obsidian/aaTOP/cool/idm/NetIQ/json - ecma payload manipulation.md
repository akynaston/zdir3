10/24/2024 12:49:59 PM
Here's some code to set primary on first email
// Sets primary=true on the first email address
function EmailPrimary(input) {
    var inputParsed = JSON.parse(input);
    if (inputParsed.emails[0].value) {
    	inputParsed.emails[0]['primary'] = true;
	}
    return JSON.stringify(inputParsed);
}