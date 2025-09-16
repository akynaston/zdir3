
let userJson = JSON.parse(`
{
    "schemas":["urn:ietf:params:scim:schemas:core:2.0:User"],
    "userName":"Mickias.Abaye@wnco.com",
    "name":{
        "givenName":"Realuser#3testinvite",
        "familyName":"realuser"
    }
    
}
`)

console.log(userJson);
console.log(userJson.emails);

console.log(userJson.name.givenName === "firstname");

var newobj = new Object();
newobj.schemas = userJson.schemas;
newobj.username = userJson.emails[0].value;

console.log(newobj);


//var obj = `{
           //"name" : "Raj",
           //"age" : 32,
           //"married" : false,
           //}`;
           
   //var obj = new Object();
   //obj.name = "Raj";
   //obj.age  = 32;
   //obj.married = false;
   //var jsonString= JSON.stringify(obj);
   //let jsonobj = JSON.parse(userJson);
   //console.log(jsonobj.name);
   

//let obj = JSON.stringify(ecma)

////console.log("here" + obj);
//console.log("here2" + obj.aaron);

//var msg = JSON.parse('{"canApprove": "56856","hasDisplayed": false}');
//console.log(msg.canApprove);  //shows true.
//console.log(ecma.emails);  //shows true.

