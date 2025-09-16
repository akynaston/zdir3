7/21/2023 11:44:40 AM
https://confluence-tools.swacorp.com/display/CYSEC/Setting+up+AWS+Environment

Now use awssaml select-active and log in!





old notes:
7/7/2023 2:53:28 PM
Confirmed Final working:

awssaml get-credentials --name "idm_developer_dev" --account-id 152290729253 --role swa/SWACSDeveloper --user-name x266698 --duration 14400
awssaml populate-aws-credentials
export AWS_DEFAULT_PROFILE=152290729253-SWACSDeveloper 
aws secretsmanager get-random-password --region us-east-1


possibly increase the duration: 14400 is 4 hours . . I'd like 8:
https://docs.aws.amazon.com/managedservices/latest/ctref/management-advanced-identity-and-access-management-iam-update-maxsessionduration.html



7/21/2023 11:21:49 AM
Note: example of lock issue . . ??

$ awssaml get-credentials --name "idm_developer_dev" --account-id 152290729253 --role swa/SWACSDeveloper --user-name x266698 --duration 14400
password: 
ping-mfa-value: 601741
ping-mfa-value: 601741
ERROR:2023-07-21T11:20:37-06:00:"msg"="{\"request_id\":\"289aa41e-99b2-4ff5-88ae-8d119bc96aa2\",\"errorId\":20524,\"errorMsg\":\"The user is locked\",\"status_code\":400}" "error"="{\"request_id\":\"289aa41e-99b2-4ff5-88ae-8d119bc96aa2\",\"errorId\
":20524,\"errorMsg\":\"The user is locked\",\"status_code\":400}" "request_id"="289aa41e-99b2-4ff5-88ae-8d119bc96aa2" "session_id"="webs_XyQYznngn-yHd986KOUlBuFfOKJPdFVRf7umuayEAO0" "unique_message_id"="webs_XyQYznngn-yHd986KOUlBuFfOKJPdFVRf7umuayE
AO0" "error_id"=30003 "error_msg"="Device push notification are disabled" "request_id"="289aa41e-99b2-4ff5-88ae-8d119bc96aa2" "error_id"=20524 "error_msg"="The user is locked"






Unable to load credentials from any of the providers in the chain AwsCredentialsProviderChain(credentialsProviders=[SystemPropertyCredentialsProvider), EnvironmentVariableCredentialsProvider(),WebIdentityTokenCredentialsProvider),ProfileCredentialsProviderprofileName=default,profileFile=ProfileFile (profilesAndSectionsMap= [{default=Profile (name=default, properties=[region, credential_process]), 152290729253-SWACSDeveloper=Profile (name=152290729253-SWACSDeveloper, properties= [duration_seconds, aws_session_token, aws_access_key_id, aws_secret_access_key])}, (}])),

ContainerCredentialsProvider(), InstanceProfileCredentialsProvider ()]) : [SystemPropertyCredentialsProvider (): Unable to load credentials from system settings. Access key must be specified either via environment variable (AWS_ACCESS_KEY_ID) or system property (aws. accessKeyId)., EnvironmentVariableCredentialsProvider): Unable to load credentials from system settings. Access key must be specified either via environment variable (AWS_ACCESS_KEY_ID) or system property (aws.accessKeyId) ., WebIdentityTokenCredentialsProvider(): Either the environment variable AWS_WEB_IDENTITY_TOKEN_FILE or the javaproperty aws. webIdentityTokenFile must be set., ProfileCredentialsProvider (profileName=default, profileFile=ProfileFile(profilesAndSectionsMap=[{default=Profile(name=default,properties=[region,credential_process]),

152290729253-SWACSDeveloper=Profile (name=152290729253-SWACSDeveloper, properties= [duration_seconds, aws_session_token, aws_access_key_id, aws_secret_access_key])}, (}])): Failed to refresh process-based credentials., ContainerCredentialsProvider (): Cannot fetch credentials from container - neither AWS_CONTAINER_CREDENTIALS_FULL_URI or AWS_CONTAINER_CREDENTIALS_RELATIVE_URI environment variables are set., InstanceProfileCredentialsProvider ():

Failed to load credentials from IMDS.]

software.amazon.awssdk.core.exception.SckClientException Create breakpoint: Unable to load credentials from any of the providers in the chain AwsCredentialsProviderChain(credentialsProviders=[SystemPropertyCredentialsProvider(),EnvironmentVariableCredentialsProvider(), WebIdentityTokenCredentialsProvider(), ProfileCredentialsProviderprofileName=default, profileFile=ProfileFile(profilesAndSectionsMap=[{default=Profile (name=default, properties=[region, credential_process]), 152290729253-SWACSDeveloper=Profile (name=152290729253-SWACSDeveloper, properties=[duration_seconds, aws_session_token, aws_access_key_id, aws_secret_access_key])}, {}])), ContainerCredentialsProvider (), InstanceProfileCredentialsProvider()]) : [SystemPropertyCredentialsProvider (): Unable to load credentials from system settings. Access key must be specified either via environment variable (AWS_ACCESS_KEY_ID) or system property (aws.accessKeyId)., EnvironmentVariableCredentialsProvider (): Unable to load credentials from system settings. Access key must be specified either via environment variable (AWS_ACCESS_KEY_ID) or system property (aws

•accessKeyId)., WebIdentityTokenCredentialsProvider(): Either the environment variable AWS_WEB_IDENTITY_TOKEN_FILE or the javaproperty aws .webIdentityTokenFile must be set., ProfileCredentialsProvider (profileName=default, profileFile=ProfileFile (profilesAndSectionsMap= [{default=Profile (name=default, properties=[region, credential_process]), 152290729253-SWACSDeveloper=Profile(name=152290729253-SWACSDeveloper, properties=[duration_seconds, aws_session_token, aws_access_key_id, aws_secret_access_key])}, {}])): Failed to refresh process-based credentials.,

ContainerCredentialsProvider): Cannot fetch credentials from container - neither AWS_CONTAINER_CREDENTIALS_FULL_URI or

AWS_CONTAINER_CREDENTIALS_RELATIVE_URI environment variables are set., InstanceProfileCredentialsProvider(): Failed to load credentials from IMDS. ]


Google search:
    https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
    
    
    

example of using the secrets manager:    
            //AWSSecretsManagerResolver awsResolver = new AWSSecretsManagerResolver();
        //String token = awsResolver.getValue("aws:dev/MiroSCIM_BearerToken");
        //System.setProperty("bearer-token", token);

