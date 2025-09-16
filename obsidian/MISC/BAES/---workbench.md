9/5/2024 3:42:15 PM
Fix for date comparison
[[Reliable date comparison]]

needed in 4 places in the Sf driver.


9/5/2024 5:46:03 PM
Deploying into BAES TEst, 10.5.7 just the latest sf driver - note on the BAES test proejct used on their workstatuion 

![[Pasted image 20240905174734.png]]
9/5/2024 5:48:44 PM
side note:
Thier version of designer is old . .this could cause deploy problem s. .

![[Pasted image 20240905174846.png]]

9/5/2024 5:53:51 PM
Confirmation that SF was at 10.5.3, now upping to 10.5.7
![[Pasted image 20240905175403.png]]9/5/2024 5:55:42 PM
Also annoying - they ahve the input job disabled:
![[Pasted image 20240905175548.png]]


9/5/2024 6:03:12 PM
10.5.7 deployed into baes test:
![[Pasted image 20240905180312.png]]

9/5/2024 6:27:07 PM
Now running latest tests from 10.5.7 idmunit:
package org.idmunit;
import junit.framework.Test; 
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.idmunit.parser.ExcelParser;

/**
 * Full test runner for all drivers. 
 * Each test is a standalone line to facilitate moving around tests or groups of tests very quickly.
 * @author Carl Kynaston
 */

public class AllTestsRunner extends TestCase {
    
	//Workbook names here in order to easily run tests in this java runner.
	private static final String env = "test/org/idmunit/EnvironmentTests.xls";
	private static final String fixture = "test/org/idmunit/SystemFixtureTests.xls";
	private static final String feed = "test/org/idmunit/FeedTests.xls";
	private static final String asst = "test/org/idmunit/AuthorisationServicesSystemTests.xls";
	private static final String greenlnk = "test/org/idmunit/GreenlnkTests.xls";
	private static final String table = "test/org/idmunit/TableSensitiveTests.xls";
	private static final String vrs = "test/org/idmunit/VRSTests.xls";
	private static final String sf = "test/org/idmunit/SuccessFactorsTests.xls";
	private static final String lms = "test/org/idmunit/LMSTests.xls";
	private static final String appx = "test/org/idmunit/AppxDIntegrationTests.xls";
	private static final String ECTrain = "test/org/idmunit/ECTrainingTests.xls";
   	private static final String SvcNow = "test/org/idmunit/ServiceNowTests.xls";
	private static final String dve = "test/org/idmunit/DVETests.xls";
	private static final String fuse = "test/org/idmunit/FuseTests.xls";
	private static final String idrt = "test/org/idmunit/initializeDirectReportsTests.xls";
	private static final String ksa_sap = "test/org/idmunit/KSA_SAPTests.xls";
	private static final String sandlnk = "test/org/idmunit/KSASandlnkTests.xls";
	private static final String Quartzlnk = "test/org/idmunit/QuartzlnkTests.xls";
	private static final String glMigration = "test/org/idmunit/GreenlnkAttrMigrationTests.xls";

	/*
	 * REMINDER EMAIL CONNECTOR IS OFF FOR NOW.
	 */	
	
	public static Test suite() throws IdMUnitException {
	    System.setProperty("com.sun.jndi.ldap.object.disableEndpointIdentification", "true");
	    TestSuite st = new TestSuite();

	    //Connection & Rights Testing - run these tests first to make sure the environment is up and functioning
		st.addTest(ExcelParser.parseSheets(env, "testConnEmailServer"));						//Tests connection to the email mail server
		st.addTest(ExcelParser.parseSheets(env, "testConn"));									//Test all the connections
		st.addTest(ExcelParser.parseSheets(env, "testSaIDMTempRights", "testWebAppRights"));  	//Tests the ACLs of the saWebApp & saIDMTemp service accounts to eDir

		
	    //Fixtures
//		st.addTest(ExcelParser.parseSheets(fixture, "testCleanupFixture")); 
//		st.addTest(ExcelParser.parseSheets(fixture, "testCreateFixtureGL"));
		//create fixtures for Sandlnk, Quartzlnk?
//		st.addTest(ExcelParser.parseSheets(fixture, "testCreateFixtureIDV"));
		st.addTest(ExcelParser.parseSheets(fixture, "testValidateFixture"));
//		st.addTest(ExcelParser.parseSheets(fixture, "testAddPeopleGroupMembers")); 
//		st.addTest(ExcelParser.parseSheets(fixture, "testValPeopleGroupMembers"));
		st.addTest(deleteAllNonFixtureTestData());									//Delete any data left over from previous test runs.


		//Feed Tests (ONLY RUN THESE IN THE TRIVIR ENVIRONMENT)
		//Leave commented out on checkin so we don't accidently run these in the BAES environment.
//		st.addTest(ExcelParser.parseSheets(feed, "testConnections"));	//Job Test
		//The following two tests are meant to test the code that reaches out to an SFTP server to retrieve a file and then process it
		//We've chosen to use the iManager install on the Greenlnk AD VM to attach to with our code and run the Job that retrieves the files to a local 
		//directory and then the DTF driver will process that file.		
//		st.addTest(ExcelParser.parseSheets(feed, "testSFTPFeed"));		//Job Test
//		st.addTest(ExcelParser.parseSheets(feed, "testHTTPFeed"));		//Job Test
//		st.addTest(ExcelParser.parseSheets(feed, "testHTTPFeedError"));	//Job Test
//		st.addTest(ExcelParser.parseSheets(feed, "testDynamicTables"));

		
		//Fuse Tests
		//IMPORTANT Note : All Fuse tests are broken because we are excluding the <Document> tag from the output file now. Tests would need several updates to get them to work again. OR go uncomment the document tags from ots-ReformatXml 
		//IMPORTANT Note 2: Fuse sends files to another folder with this job: Job-SendFilesToFuse. It runs every 30 minutes. 
		// If you are running this while testing, it is possible your files will get moved before IdMUnit has a chance 
		// to verify them. It is recommended to turn off the schedule on that job during IdmUnit testing.
/*		st.addTest(ExcelParser.parseSheets(fuse, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(fuse, "testFuseManagerDelete1", "testFuseManagerDelete2", "testFuseManagerDelete3"));
	    st.addTest(ExcelParser.parseSheets(fuse, "testSchema"));
		st.addTest(ExcelParser.parseSheets(fuse, "testFuseManagerCreate1"));
		st.addTest(ExcelParser.parseSheets(fuse, "testFuseManagerCreate2"));
	    st.addTest(ExcelParser.parseSheets(fuse, "testFuseManagerCreate3_FirstTimeManager"));
	    st.addTest(ExcelParser.parseSheets(fuse, "testCreateWithFuseIDVetoed"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test1.1.1a-NewSFIdvUserFuture"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test1.1.1b-NewSFIdvUserFutureNoMgrFuseID"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test1.1.2a-NewSAPIdvUserFuture"));				//KSA-SAP Fuse AC test
	    st.addTest(ExcelParser.parseSheets(fuse, "test1.2.1-NewSFIDVUserTimeBased"));				//This processes lots of users, maybe do not run in the BAES env
		st.addTest(ExcelParser.parseSheets(fuse, "test1.2.2-NewSAPIDVUserTimeBased"));				//KSA-SAP Fuse AC test
	    st.addTest(ExcelParser.parseSheets(fuse, "test1.3.1a-NewSFIDVUserCurrent"));
		st.addTest(ExcelParser.parseSheets(fuse, "test1.3.1b-NewIdvUserNoEmail"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test1.3.2-NewSAPIDVUser"));
		st.addTest(ExcelParser.parseSheets(fuse, "test1.4-FuseIDReceived"));
		////1.5 IDV User Matches Fuse User (Not Supported)											//Matching is not supported. No IdMUnit test.
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.1a-ModifyIDVUserPending"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.1b-ModifyIdvUserFutureDated"));				//Not in the AC maybe?   
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.2.1-SFIDVUserModified"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.2.2SAPUserModified"));						//KSA-SAP Fuse AC Test
	    st.addTest(ExcelParser.parseSheets(fuse, "testDisabledToSyncAssocChange"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.3.0-ModIDVUserPendingFuseID_to_Create"));	//Not in the AC. Unassociated modified user with pending baeFuseID yields a create - ckynaston 
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.3.1-baeFuseIDModInIDV"));					//Vetoed and logged
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.3.2-baeFuseIDModInFuse"));					//Vetoed and logged
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.4.1a-UserManagerSetPart1"));				//Multi-part test broken up to be able to validate first time managers (and managers becoming users).
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.4.1b-UserManagerSetPart2"));				//Multi-part test broken up to be able to validate first time managers (and managers becoming users).
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.4.1c-UserManagerSetPart3"));				//Multi-part test broken up to be able to validate first time managers (and managers becoming users).
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.4.2-UserManagerChanges"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.4.3-UserManagerRemoved"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test2.4.4a-UserManagerFuseIDWithDirectReports"));
	    ////DISABLED st.addTest(ExcelParser.parseSheets(fuse, "test2.4.4b-ManuallySetFuseIDOnManager"));// For this test to pass, the policy that vetoes and resets FuseID mods has to be disabled.
		st.addTest(ExcelParser.parseSheets(fuse, "test3.1a-IDVUserLeaves"));
		st.addTest(ExcelParser.parseSheets(fuse, "test3.1b-IDVUserLeavesKSASAP"));
 	    st.addTest(ExcelParser.parseSheets(fuse, "test3.2-IDVUserLeavesTimeBased"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test3.3-IDVUserLeavesNoFuseId"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test3.4-IDVUserDeleted"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test3.5.1-SFUserRehiredLWDSetToFuture"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test3.5.2-SFUserRehiredNewStartDateArrives"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test4.1-IDVUserMigratedWithoutFuseID"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test4.2-IDVUserMigratedWithFuseID"));
	    st.addTest(ExcelParser.parseSheets(fuse, "test5.1-TransferFileToFuse"));					//Not able to pass in the BAES env since it looks in local directories.
	    st.addTest(ExcelParser.parseSheets(fuse, "test5.2-TransferFileFromFuse"));					//Not able to pass in BAES env since it looks in local directories.
	    ////5.3 File Transfer to SFTP folder idv2wm Failure Notification							//No IdMUnit test. Not sure how to test - ckynaston	    
	    ////5.4 File Transfer from SFTP folder wm2idv Failure Notification							//No IdMUnit test. Not sure how to test - ckynaston 
		////5.5 No Files Received for 48 Hours
		st.addTest(ExcelParser.parseSheets(fuse, "testInitialMigration1CarLicense"));
		st.addTest(ExcelParser.parseSheets(fuse, "testInitialMigration2DirXML"));
		st.addTest(ExcelParser.parseSheets(fuse, "testInitialMigration3DirXMLAssociated"));
	    st.addTest(ExcelParser.parseSheets(fuse, "testFuseManagerCreate4_FirstTimeManager"));	//Manual testing for KSAIDV-111 Part 1
	    st.addTest(ExcelParser.parseSheets(fuse, "testCreateOneKSAUser"));		

		
		//ECTraining Tests
		st.addTest(ExcelParser.parseSheets(ECTrain, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"testSFCreate"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"test2.2.4.1ECAwTrainingExp"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"test2.2.4.2AwTrainingRenewed"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"test2.2.4.1EnhanTrainingExp"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"test2.2.4.4EnhanTranExpNoAw"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"test2.2.4.5EnhanTrainRenewWAw"));
		st.addTest(ExcelParser.parseSheets(ECTrain ,"test2.2.4.6EnhanTrainRenNoAw"));
        //test2.5.7UpdateTrainExpireDates tested in job tests.


		//LMS Tests
	    st.addTest(ExcelParser.parseSheets(lms, "testTempCreateSimpleDoc"));			//ECR 183 - Air format with multiple Permitted Legal Entities
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.2a_LMSLicenceMatched"));
	    st.addTest(ExcelParser.parseSheets(lms, "test1.4.2b_LMSLicMatchedAir"));		//Same as 1.4.2a, but for AIR with nested permitted legal entity.
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.2.1a_LMSMatchInvalid"));
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.2.2a_LMSMatchVALID"));
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.1a_LMSLicenceCreated"));
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.1b_LMSLicenceCreated"));	
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.1c_Dfct76MultChildTags"));
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.1d_Dfct131-MultiLicence"));
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.1e_VETOLMSLicenceCreate"));
		st.addTest(ExcelParser.parseSheets(lms, "test1.4.1g_LMSLicCreatManual"));		//ECR 183 - Just testing manual XML creation.
	    st.addTest(ExcelParser.parseSheets(lms, "test1.4.1h_LMSLicCreateAir"));			//ECR 183 - New XML format for Air
	    st.addTest(ExcelParser.parseSheets(lms, "test1.4.1i_LMSLicCreateBOTH"));		//ECR 183 - New and old format together.
	    st.addTest(ExcelParser.parseSheets(lms, "test1.4.1j_LMSLicCreatAirMult"));		//ECR 183 - Air format with multiple Permitted Legal Entities
	    st.addTest(ExcelParser.parseSheets(lms, "test1.4.1k_LMSLicCreatAirTONS"));		//ECR 183 - Air format with TONS of Permitted Legal Entities
	    st.addTest(ExcelParser.parseSheets(lms, "test2.4.1a_LicenceModLMS"));
		st.addTest(ExcelParser.parseSheets(lms, "test2.4.1b_LicenceModLMS"));
		st.addTest(ExcelParser.parseSheets(lms, "test2.4.1c_LicenceModLMSBlnkVals"));
		st.addTest(ExcelParser.parseSheets(lms, "test2.4.1d_LicenceModWebAppNot"));		//WebAppNotification testing ECSensitive attributes - Licence
		st.addTest(ExcelParser.parseSheets(lms, "test2.4.2LicenseRenameLMS"));
		st.addTest(ExcelParser.parseSheets(lms, "test2.4.3LicenseMoveLMS"));
		st.addTest(ExcelParser.parseSheets(lms, "test2.5.2LicenceRename"));
		st.addTest(ExcelParser.parseSheets(lms, "test3.5.1LicenceDeletedIDV"));


		//VRS Tests //Clean run May 9 2023 GK
		st.addTest(ExcelParser.parseSheets(vrs, "testDeleteTestObjects")); 
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.1VRSMatchGCINumber"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.2VRSMatchVRSID"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.3VRSMatchOldVRSID"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.4VRSMatchDOB-GN-SN"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.1.1a_VRSUserCreate"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.1.1b_VRSUserCreateMulti"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.1.1c_VRSMissingVRSIDVeto"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.1.1d_VRSDVEBug"));			//Manually confirm log just mentions one issue.
	    st.addTest(ExcelParser.parseSheets(vrs, "test1.1.1.1f_VRSCreateContingen"));
		st.addTest(ExcelParser.parseSheets(vrs, "test2.1.1a_VRSUserModSF"));
		st.addTest(ExcelParser.parseSheets(vrs, "test2.1.1b_VRSUserModSFBlnkTag"));
		st.addTest(ExcelParser.parseSheets(vrs, "test2.1.2VRSUserModNSF"));
		st.addTest(ExcelParser.parseSheets(vrs, "test2.1.4VRSRehireNSF"));
		st.addTest(ExcelParser.parseSheets(vrs, "test2.1.5RehireSFasNSF"));
		st.addTest(ExcelParser.parseSheets(vrs, "test3.1.1VRS-NSFTerm"));
		st.addTest(ExcelParser.parseSheets(vrs, "test3.1.2VRS-SecondTerm"));
		st.addTest(ExcelParser.parseSheets(vrs, "test3.1.1VRSTermServiceNowErr"));
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.5VRSMatchDOB-GN-PN"));  //Match IDV Given Name with VRS Preferred Name
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.6VRSMatchDOB-PN-PN"));  // Match IDV Preferred Name with VRS Preferred Name
		st.addTest(ExcelParser.parseSheets(vrs, "test1.1.2.7VRSMatchDOB-PN-GN"));   // Match IDV Preferred Name with VRS GIven Name

	
		


		//SuccessFactors Tests
/*		st.addTest(ExcelParser.parseSheets(sf, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFUserCreated"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFMax2038Dates"));	//Tests user create with extreme DOB and company start/end dates
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFDuration"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFUserCreatedMulti"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFUserCreaTrainDates"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-DefaultTableReadDNE"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-AddTrainCmpltAwrnss"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-ModTrainCmpltEnhncd"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-ModTrainCmpltBlank"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-ClearBlankNodes"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFNotificationTest"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFCreateContingent"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.1-SFContLWDCleared"));
**/
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.1-SFMatchesGCI")); 		// IdMUnit note: the HRDS emulated web server must be running: runHRDSListener.bat (or runHRDSListener-OnDevVM.bat in Designer on dev vm) 
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.1-SFUserMatch"));			//This is a GCI match like 1.2.2.1
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.1-SFUserMatch2"));			//Another GCI match use case
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.1-SFMatchesGCIAndSNSec"));	// match with secondment data NOT SURE THIS TESTS IS NEEDED
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.2-SFMatchDOBGivenSN"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.11bSFUserMatch-Defect80")); //Seems to just create a new user?
       	st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.3.1-SFMatchIDVSameJob"));        //GCI change but Contract type and start date the same
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.3.2-SFMatchIDVNewJob"));        //GCI change Contract Type different, start date in Future
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.3.3-SFMatchIDVOldJob"));        //Old Job	
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.3.3(a)-SFMatchIDVFutureStart"));        //Future Date same ContractType		
        st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.4-SFUserMatchDOBSN-GN-PN")); // Matches SN, DOB IDV GN/SF PN
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.5-SFUserMatchDOBSN-PN-PN")); // Matches SN, DOB IDV PN/SF PN
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.6-SFUserMatchDOBSN-PN-GN")); // Matches SN, DOB IDV PN/SF GN///		
        st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.7-SFUserMatchDOBGNNotSN")); // Matches DOB, GN but NOT SN	
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.2.8-SFMatchesEmail"));
/*
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.3-SecEffective"));	//Is this different from 1.2.1-SFUserCreated where secondment is active?
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.3-SecEffectiveDemand"));
		st.addTest(ExcelParser.parseSheets(sf, "test1.2.3-SecNOTEffective"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.1-MoveToSecondment"));	//There's some extra work going on in here
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.1-MoveToSecBlank"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.1cSetToPrimaryNoSec"));	//User created w/o secondment dates
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.2-PrimaryManagerChg"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.2.1-PrimaryManagerClear"));		//Added to show clearing a manager during Fuse development.
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.2.2-LineManagerChg"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.2.3-ManagerLookupFails"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.3-SecondmentManagerChg"));
		//WHERE ARE THE 2.2.4 TESTS FOR TRAINING DATES CHANGES, EXPIRATION, AND RENEWAL?  In a separate ECTraining Tests section above. Why are they separate? Why not include them with the SF tests?
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.5-UserRehireWithTerm"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.5-UserRehireEmptyLWD"));
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.6-RehireSFasNSF"));		//This test is incorrect. Can't hire in an NSF user in SF. Needs to be a VRS hire on the rehire
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.7-RehireNSFasSF"));		//Original hire not done via VRS; examine test for accuracy
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.8-HireNSFasSF"));		//Original hire not done via VRS; examine test for accuracy
		st.addTest(ExcelParser.parseSheets(sf, "test2.2.9-PassThroughUpdates"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.1-SFUserTerm"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.1-SFUserTermAssoc"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.1-SFTermWithVRS"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.1-SFUserTerm-OneNotifi"));	// IdMUnit note: the HRDS emulated web server must be running in the TrVir Dev env. runHRDSListener.bat (or runHRDSListener-OnDevVM.bat in Designer on dev vm)
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.1-TermFailedServiceCall"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.1-1899NotCauseTerm"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.2-SFUserSecondTerm"));
		st.addTest(ExcelParser.parseSheets(sf, "test3.2.3-DACTerminated"));			//Unnecessary test?
		st.addTest(ExcelParser.parseSheets(sf, "test-GCIChanged"));					//Do we have an AC for this?


		//Table Sensitive Tests
		st.addTest(ExcelParser.parseSheets(table, "test1.2.1e-DefaultTableRead"));
		st.addTest(ExcelParser.parseSheets(table, "test2.1.2bVRSUserModNSF"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.1.1aRegEmpFlagSetTRUE"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.1.1bRegEmpAdd-Cat1-True"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.1.1cRegEmpAdd-Cat2-True"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.1.1dRegEmpFlagWebNotify"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.1.2RegEmpFlagSetFALSE"));
		st.addTest(ExcelParser.parseSheets(table, "testAttrbaeBusGLADcompany"));
		st.addTest(ExcelParser.parseSheets(table, "testAttrbaeBusGLADcompany"));
		st.addTest(ExcelParser.parseSheets(table, "testAttrbaeBusGLADcompany"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.3cGLInitWResetOFF2"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.3cGLInitWResetOFF2-prt2"));
		st.addTest(ExcelParser.parseSheets(table, "test2.5.3c2COProcessing"));
		
        
		//Appendix X Tests
		st.addTest(ExcelParser.parseSheets(appx, "testECChangeUserFull"));				//WebAppNotification testing ECSensitive attributes - User
		st.addTest(ExcelParser.parseSheets(appx, "testECChangeUserECR181"));
		st.addTest(ExcelParser.parseSheets(appx, "testBaeIsUserCompNoGCIOnAdd"));
		st.addTest(ExcelParser.parseSheets(appx, "testECChangeUserExtraAttrs"));
		st.addTest(ExcelParser.parseSheets(appx, "testECChangeUserECR181Training"));
		st.addTest(ExcelParser.parseSheets(appx, "testECChangeUserECR181TrainingNoNotification"));
    	st.addTest(ExcelParser.parseSheets(appx ,"testECChangeLicence"));
		st.addTest(ExcelParser.parseSheets(appx ,"testECChangeLicenceECR183"));
		//Greenlnk Tests
		st.addTest(ExcelParser.parseSheets(greenlnk, "testAllADOperations"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.1-GreenlnkDontCreate"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.1-GreenlnkCreateNSF"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.2.1-GLADMatchBlankMgr"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.2.1-GLADMatch-GCIOnly"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.2.2GLADMatch-EUID"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.2.2GLADMatch-EUID-blnks"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test1.3.3-Scoping-Containers"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.2.2and2.2.3ManagerChange"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.3.1MgrPubReset"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.3.3GLOwnedAttrs"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.3.5IDVOwnedAttrs"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.5.3GLSubscriberAttrs"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.5.3GLSubscriberAttrsDis"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.5.3bGLInitWithReset"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.5.3cGLInitWithResetOFF"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.5.4GLWrtBckAttrsDisabled"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test2.5.5IDVUserRenamed"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test3.3.2SFUserTermLoseGL"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test3.3.3GLNSFTermWithVRS"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test3.3.3UserTermWithVRS"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "test-Defect165"));
		st.addTest(ExcelParser.parseSheets(greenlnk, "testPubVetoMoveRename"));



	       
		//Greenlnk Attribute Migration Tests  
	    st.addTest(ExcelParser.parseSheets(glMigration, "testDeleteTestObjects")); // 	
		st.addTest(ExcelParser.parseSheets(glMigration, "testMigrateUser"));   //
	
	
		//ServiceNow Tests
	    st.addTest(ExcelParser.parseSheets(SvcNow, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "ServiceNowSetup"));
	    st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.1UserAddNoDomains"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.1UserAddNoDomains_a"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.2SFUserAddedNoDomains"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.3KSAUserAddedNoDomains"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.4GreenlnkUserAdded"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.5QuartzlnkUserAdded"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test1.1.6SandlnkUserAdded"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.1UserModifyNoDomains"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.2SAPUserModifyNoDomains"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.3GreenlnkUserModify"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.4QuartzlnkUserModify"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.5SandlnkUserModify"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.6IDVUserModifywithDomains"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test2.1.6IDVUserModifywithDomains_a"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test3.1.1_IDV_User_Deleted"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "test4.1.1_IDV_User_Migrated"));

		
		//DVE Tests
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateSuccessAttrsSF"));
		////DISABLED st.addTest(ExcelParser.parseSheets(dve ,"testValidateSuccessAttrsVRS"));	//Broken since we disabled the baeSFEmail rule for VRS. Need feedback from BAES - ckynaston
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateSuccessAttrsLMS"));
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateFailAttrsSF"));
		////DISABLED st.addTest(ExcelParser.parseSheets(dve ,"testValidateFailAttrsVRS"));		//Broken since we disabled the baeSFEmail rule for VRS. Need feedback from BAES - ckynaston
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateFailAttrsLMS"));
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateDatesBadFormat"));
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateBadBusLevel2Code"));
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateDatesBadFormatRetainIDV"));
		st.addTest(ExcelParser.parseSheets(dve ,"testbaeContractTypeVeto"));
		st.addTest(ExcelParser.parseSheets(dve ,"testbaeSFEmailAddressChecks"));
		st.addTest(ExcelParser.parseSheets(dve ,"testbaeGCINumberVeto"));
		st.addTest(ExcelParser.parseSheets(dve ,"testbaeDOB"));
		st.addTest(ExcelParser.parseSheets(dve ,"testbaePhysicalDeliveryOfficeCodeVeto"));
		st.addTest(ExcelParser.parseSheets(dve ,"testbaeBusinessUnitLMSFail"));
		st.addTest(ExcelParser.parseSheets(dve ,"testINC1500949-PlaceOfWork-VRS"));
		st.addTest(ExcelParser.parseSheets(dve ,"testINC1500949-PlaceOfWork-HRDS"));
		st.addTest(ExcelParser.parseSheets(dve ,"testINC1500957-contractTypeFail-1-HRDS"));
		st.addTest(ExcelParser.parseSheets(dve ,"testINCINC1500951-SecondmentDates"));
		st.addTest(ExcelParser.parseSheets(dve ,"testINCNONE-baeCompanyEndDate-HRDS"));
		st.addTest(ExcelParser.parseSheets(dve ,"testValidateFailAttrsSFSecondment"));	// 44, 45 *** should 1899 be considered blank?
		st.addTest(ExcelParser.parseSheets(dve ,"testINC1501049-baeLastWorkingDay"));
		// ,"testDryRun" // Requires dry run to be enabled on driver set gcv: dveDryRun
		
                
		//AuthorisationServicesSystemTests (Non-Job)
		st.addTest(ExcelParser.parseSheets(asst, "test1.2.1aNewManagerPopulation"));		//Chuck and Justin
		st.addTest(ExcelParser.parseSheets(asst, "test1.2.1bCurrentManagerPopulation"));	//Chuck and Justin
		st.addTest(ExcelParser.parseSheets(asst, "test1.5.1-Reverse1.3.2.1-GCI-SN")); 	// Emulates SF by using GL: all we care about is the match attrs, the match and merge process; this is all on the GL driver.
		st.addTest(ExcelParser.parseSheets(asst, "test1.5.1-ReverseGCIOnly")); 			// Emulates SF by using GL: all we care about is the match attrs, the match and merge process; this is all on the GL driver.
		st.addTest(ExcelParser.parseSheets(asst, "test1.5.1-Reverse1.3.2.2EUID")); 		// Emulates SF by using GL: all we care about is the match attrs, the match and merge process; this is all on the GL driver.
		//,"test1.5.1-Reverse1.3.1ONHOLD" //  ON HOLD: DISCUSS WITH GLEN; MAY NOT BE VALID.  can use for c/co mapping: right now; map to the same ISO3166 maping.
		st.addTest(ExcelParser.parseSheets(asst, "test2.1.3ModSupervisorVRSID"));
		st.addTest(ExcelParser.parseSheets(asst, "test2.2.2ChangeManagers"));				//Chuck and Justin
		st.addTest(ExcelParser.parseSheets(asst, "test3.5.2bSimpleUserDeleteNoJob"));
		st.addTest(ExcelParser.parseSheets(asst, "test3.5.3UserDeletionDateCheck"));
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.11b-ManualCarLiceTest"));
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.11cLWDPassesNoJob"));				//Created to validate manual terms by setting LWD to the past toggles baeIsUserComplete to FALSE
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14ManagerChangeEmail"));			//Chuck and Justin
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.15.1MarkSFUserComplete"));
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.15.2MarkSFUserIncomplete"));  //CFS figure out
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.15.3MarkNSFUserComplete"));
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.15.4MarkNSFUserIncomplete"));
		st.addTest(ExcelParser.parseSheets(asst, "testIsUserComplete"));
		st.addTest(ExcelParser.parseSheets(asst, "testInitialMigrationSFUser")); 		// row 31: has VRS addprevioustosimple issue.
		st.addTest(ExcelParser.parseSheets(asst, "testInitialMigrationNSFUser"));
		st.addTest(ExcelParser.parseSheets(asst, "testInitialMigrationLMS-NOOP"));


		//SAP-KSA Tests (Job tests are last for running in TEST) //Clean run May 11, 2023 GK
//	    st.addTest(ExcelParser.parseSheets(ksa_sap, "testDeleteTestObjects"));					
//	    st.addTest(ExcelParser.parseSheets(ksa_sap, "testCreateManagers"));						
	    st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.1aNewSAPUserCreatedInIDV"));	
	    st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.1bNewSAPUserCreatedInIDV"));
	    st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.1.2VRSKSASAPUserCreated"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2aNewSAPUserVetoedMissingSurname"));
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2bNewSAPUserVetoedMissingGCI"));	
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2cNewSAPUserVetoedMissingStart"));	
	    st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2dNewSAPUserVetoedPastLWD"));	
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2.4aVRSKSASAPUserMatchNameDOB"));	
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2.4bVRSKSASAPUserMatchNoAssoc"));	
	    st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.2.4cVRSKSASAPUserMatchMultiple"));	
	    st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.3NewSAPUserMatchesClockNumInIDV"));
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.4NewSAPUserMatchesGCIInIDV"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.5a_SFUserCreatedForSAPMatch")); 	//KSA User Matches SF User Part 1 - Split into two tests due to column differences between tests.
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.5bKSA-SAPUserMatchSFUserOnGCI"));	//KSA User Matches SF User Part 2 - Split into two tests due to column differences between tests.
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.6NewSAPUserMAtchesNameDOB"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.6aNewSAPUserMAtchesNameDOBPastLWD"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test1.1.7NewSAPUserMatchesNoLWD"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test2.1.1UserModified"));					
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test2.1.2UserModified_GCI_Change"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test2.1.3UserModifiedGCIRemoved"));		
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test3.1.1aSAPUserTerminated"));			
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test3.1.1bSAPUserRehired"));					
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test2.2.1.1aSAPManagerUpdateJob"));			//Job Test
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test2.2.1.2ManagerWFIDFailed"));				//Job Test
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test4.1.1SAPUserTerminatedJob"));				//Job Test
		st.addTest(ExcelParser.parseSheets(ksa_sap, "test4.1.2SAPUserTerminatedRetroactivlyJob"));	//Job Test
//		st.addTest(ExcelParser.parseSheets(ksa_sap, "testDeleteManagers"));							//KSA-SAP AC test - Delete the test managers
		//No test to validate the file transfer job works. 


		//KSASandlnk Tests  //Clean run May 16, 2023 GK
	    st.addTest(ExcelParser.parseSheets(sandlnk, "testCreateSandlnkManagers"));
	    st.addTest(ExcelParser.parseSheets(sandlnk, "testSandlnkSchema"));
	    st.addTest(ExcelParser.parseSheets(sandlnk, "testIDVSchema"));
 	    st.addTest(ExcelParser.parseSheets(sandlnk, "testRequiredOUs"));
	    st.addTest(ExcelParser.parseSheets(sandlnk, "DeleteAllTestUsers"));
	    st.addTest(ExcelParser.parseSheets(sandlnk, "testWait30"));
		st.addTest(ExcelParser.parseSheets(sandlnk, "test1.1.1UserNotMatchGCI"));
		st.addTest(ExcelParser.parseSheets(sandlnk, "test1.1.2UserMatchGCI"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test1.1.3UserMatchSFUserGCI"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test1.1.4UserMovedinScope"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test1.2.1IDVUserMatchGCI"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test2.1.1SandlnkUserModify"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test2.1.2SandlnkUserMoveOutScope"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test2.1.3SandlnkUserMoveInScope"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test2.1.4SandlnkUserRename"));
        st.addTest(ExcelParser.parseSheets(sandlnk, "test3.1.1SandlnkUserDeleted"));

		//Quartzlnk Tests	//Clean run May, 11 2023 GK
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "testFixtureCreate")); //
	    st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.1.1_IDV_UserCreate")); //
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.1.2_IDV_UserCreateMatchQLUser")); //
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.1.3_IDV_UserCreateNonQatar")); //
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.2.1_QL_UsercreatedwVRSID"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.2.2_QL_UsercreatedWOutVRSID"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.2.3_QL_UsermatchVRSID"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test1.2.4_QL_UserNOmatchVRSID"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.1.1_IDV_UserMod"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.1_QL_UserMod"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.2_QL_UserModVRSIDMatch"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.3_QL_UserModVRSIDNotMatch"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.4.1_QL_UserWrongVRSIDMatch"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.4.2_QL_WrongVRSIDRemoved"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.4.3_QL_WrongVRSIDReplaced"));
	    st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.5_QL_UserRename"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.6_QL_AccountDisabled"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test2.2.7_QL_AccountEnable"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test3.2.1_QL_UserDelete"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test3.2.2_QL_UserMoveOUTofScope"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test3.2.3QuartzlnkUserMoveInScope"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test3.2.4_QL_MoveUserWinScope"));
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "test4.1.1_IDV_UserMigrated"));	    
		////st.addTest(ExcelParser.parseSheets(Quartzlnk, "testAllUserDelete")); // Not yet created
		st.addTest(ExcelParser.parseSheets(Quartzlnk, "testFixtureDelete")); //

 		
		///// Job Tests	/////
		//AuthorisationServicesSystemTests
		st.addTest(ExcelParser.parseSheets(asst, "test1.5.2VRSReverseMatching"));	//JOB // place holder; all combinations done in 16l tests.
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.8a_ECTrainingExpires"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.8b_ECTrainingExpires21Day"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.10TimeBasedSecExpires"));		//JOB		
		st.addTest(ExcelParser.parseSheets(asst, "test3.5.2AutoUserDeletion"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.11aLWDPasses"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.xLDWUpcoming"));	//JOB - TO BE DELETED WHEN NEW SERVICENOW DRIVER IS IMPLEMENTED
		//DISABLED - Not used anymore 		suite.addTest(ExcelParser.parseSheets(asst, "test2.5.12GLUserExpire"));	//JOB
		//DISABLED - Not used anymore 		suite.addTest(ExcelParser.parseSheets(asst, "test2.5.13GLUserExpire"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.2aManagerUpdateJob"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.2bMgrUpdJobNoMgrEmail"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.3MgrJobNoADMgr"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.4MgrUpdJobLookupFail"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.5aMgrUpdateVRSID"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.5bMgrUpdJobNoMgrEmail"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.6MgrUpdateVRSIDNoAD"));	//JOB
		st.addTest(ExcelParser.parseSheets(asst, "test2.5.14.7MgrUpdateVRSIDFails"));	//JOB
		//EC Training Attribute testing.
		st.addTest(ExcelParser.parseSheets(ECTrain, "test2.5.7UpdateTrainExpireDates"));	//Job
		st.addTest(ExcelParser.parseSheets(idrt, "testX.XinitialManagerPopulation"));

		
		// Test Cleanup		
		st.addTest(deleteAllNonFixtureTestData());		                           //Delete any data left over from this test run.
		st.addTest(ExcelParser.parseSheets(fixture, "testCleanupFixture"));		   //We do not need to tear down the test fixtures every time now, as it just wastes time for future test runs	

		// */	//End Test Runner Section
		return st;
	}
	
	public static Test deleteAllNonFixtureTestData() {
		TestSuite st = new TestSuite();
		st.addTest(ExcelParser.parseSheets(feed,"testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(greenlnk,"testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(vrs, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(lms, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(sf, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(table, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(appx, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(ECTrain, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(asst, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(dve, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(SvcNow, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(fuse, "testDeleteTestObjects"));
		st.addTest(ExcelParser.parseSheets(ksa_sap, "testDeleteTestObjects"));
		return st;
	}	
}



9/5/2024 6:44:01 PM
All tests passed, stored log in commit 8d108a5 in my BAES local git repo.

11/5/2024 1:25:07 PM
Deploying 10.5.9 - has another fix to 1.2.2.3.3. that Gary did.
Did secondary diff now:
![[Pasted image 20241105132529.png]]

restaring driver and running tests.

11/5/2024 2:59:34 PM - testing done; a few gl tests failed; but not worried about those, 10.5.9 sf driver is in place.

I rerolled 10.5.9 with the latest idmunit-config fixes I made to get the tests to pass: today plus 1 year was missing from sfxmlremote I think . .