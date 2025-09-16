12/21/2023 1:05:53 PM

This works to install local jar and pom:
mvn install:install-file -Dpackaging=pom -Dfile=ldap-1.0.0.pom -DpomFile=ldap-1.0.0.pom

other attmepts:



mvn install:install-file \
   -Dfile=ldap-1.0.0.jar \
   -DgroupId=com.netiq \
   -DartifactId=your_artifact_id \
   -Dversion=your_version \
   -Dpackaging=jar \
   -DlocalRepositoryPath=path_to_project_repository




    implementation files('C:\Users\x266698\Downloads\ldap-jldap\ldap-1.0.0.jar')

