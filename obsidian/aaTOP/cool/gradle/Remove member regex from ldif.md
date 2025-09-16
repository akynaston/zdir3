This didn't quite work; so just did a dumb remova; seemed to be ok:

+
+task removeMemberLines {
+    def inputFile = file('exports/Entitlement Policies.ldif')
+    def outputFile = file('exports/Entitlement Policies.ldif.done')
+
+    doLast {
+        outputFile.withWriter { writer ->
+            inputFile.eachLine { line ->
+                if (!line.startsWith("member:")) {
+                    writer.write(line + '\n')
+                }
+            }
+        }
+        // Overwrite the original file with the content of the modified file
+        inputFile.text = outputFile.text
+        outputFile.delete();
+        /*
+        TODO:
+
+        Now, produce the final folder versions of each file:
+
+        outputFile.withWriter { writer ->
+            inputFile.eachLine { line ->
+                if (!line.contains("swaiddev")) {
+                    writer.write(line + '\n')
+                }
+            }
+        }
+
+        */
+
+
+
+    }
+}
+