#!/bin/bash
awssaml get-credentials --name "idm_developer_dev" --account-id 152290729253 --role swa/SWACSDeveloper --user-name x266698 --duration 14400
awssaml populate-aws-credentials
export AWS_DEFAULT_PROFILE=574486338175-SWACSDeveloper 
aws secretsmanager get-random-password --region us-east-1 | grep -q "\"RandomPassword\"" && echo "Login Success" || echo "Login Failure"