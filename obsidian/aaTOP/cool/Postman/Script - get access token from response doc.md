2/18/2025 1:42:41 PM
New way - they like pm.response.json, not the old way (below)
pm.collectionVariables.set("SPRINKLER-TOKEN", pm.response.json().access_token);


old way:
var jsonData = JSON.parse(responseBody);

pm.collectionVariables.set("IDPTOKEN", jsonData.accessToken);