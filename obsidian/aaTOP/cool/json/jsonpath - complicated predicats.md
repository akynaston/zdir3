8/22/2025 2:18:14 PM

$.data.objects[?(@.defaultRoles[?(@.name=='Self-Service Reporting User')])].emails
$.data.objects[?(@.defaultRoles[?(@.name=='Targetprocess User')])].email



https://jsonpath.com/
https://mockoon.com/tools/json-object-path-evaluator/


$.data.objects[?(@.defaultRoles[*].name == 'bob')].email



jsonpath:
https://stackoverflow.com/questions/68926463/how-to-get-jsonpath-to-return-property-of-parent-of-matched-element
 - help to return a parent . .jsonpath-plus has a '^' parent operator . .
 - but without it, just start higher:
  $.recordList[?(@.customFieldList[*].value.name=='JEANS')].internalId



