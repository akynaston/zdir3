
last lctivity from api - requested, but not there . .
https://community.miro.com/developer-platform-and-apis-57/user-s-lastactivity-datetime-from-api-822

JSONPath working cat:

((JSONArray)mainResultJsonPath.read("$.Resources[0].members[?(@.displayName==\"Gokul\")].value")).get(0)


