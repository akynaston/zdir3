12/13/2024 2:20:17 PM
asked for drivers with this data


C:\work>type seanCarollsList.txt
swaSSNFull
swaPassportCOI
swaPassportDOE
swaPassportNumber
C:\work>grep --include="*.xml" -Rif seanCarollsList.txt  > allInstances.txt
ACCESStoID/exports/ACCESStoID.xml:                    <filter-attr attr-name="swaPassportNumber" publisher="sync"/>
IDtoACCESS/exports/IDtoACCESS.xml:                    <filter-attr attr-name="swaPassportNumber" subscriber="sync"/>
IDtoCSS/exports/IDtoCSS.xml:                    <filter-attr attr-name="swaPassportNumber" merge-authority="edir" publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
IDtoLDAP/exports/IDtoLDAP.xml:                    <filter-attr attr-name="swaPassportNumber" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
LDAPtoID/exports/LDAPtoID.xml:                    <filter-attr attr-name="swaPassportNumber" merge-authority="default" publisher="sync" publisher-optimize-modify="true" subscriber="ignore"/>
MCL/exports/MCL.xml:                    <filter-attr attr-name="swaPassportNumber" from-all-classes="true" merge-authority="default" publisher="ignore" publisher-optimize-modify="true" subscriber="sync"/>
SAPHR/exports/SAP-HR.xml:                    <filter-attr attr-name="swaPassportNumber" merge-authority="default" publisher="sync" publisher-optimize-modify="true" subscriber="ignore"/>
WorkdayHCM/exports/WorkdayHCM.xml:                    <filter-attr attr-name="swaPassportNumber" merge-authority="app" publisher="sync" publisher-optimize-modify="true" subscriber="reset"/>
