3/27/2024 4:17:58 PM
I needed to upload a DTF2Connector for IDtoDocunet that didn't exist in a repo at SWA; this is the response:

$ cat deployJarsWithMaven.sh
#!/bin/bash
mvn deploy:deploy-file -Durl=https://nexus-tools.swacorp.com/repository/thirdparty \
                        -DrepositoryId=swa-nexus \
                        -Dfile=dtf2-connector/dtf2-connector-1.0.1.jar \
                        -Dsources=dtf2-connector/dtf2-connector-1.0.1.jar \
                        -DgroupId=com.trivir.idmunit.connector \
                        -DartifactId=dtf2connector \
                        -Dversion=1.0.1 \
                        -DgeneratePom=true \
                        -Dpackaging=jar


![[Pasted image 20240327161758.png]]

