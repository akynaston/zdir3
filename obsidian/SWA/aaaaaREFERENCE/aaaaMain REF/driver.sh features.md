x266698@SY4-HW2XSQ3 MINGW64 /c/work/MCL (CSEE-3749)
$ ./driver.sh

./driver.sh [OPTION(S)]... [COMMAND]

Options

  -i                        Enable info level logs.
  -d                        Enable debugging level logs.
  -s                        Enable stacktraces.
  -e [ENV NAME]             Specify Environment for testing - default is dev.
  -k [ENCRYPTION KEY]       Specify Encryption Key - Default in local config
  -u [USER DN]              User DN
  -p [PASSWORD]             Specify Password
  -h [HOST]                 Specify Host
  -j [JAVA_PATH]            Specify Path to java exe

Commands

  list                List available standards.

  update              Set standard to latest.

  clean               Clean up workspace and standards directory.

  build               Start a build of the driver.

  test                Run unit tests for driver.
                           -e {environment}    i.e. alpha|dev|sat

  compare             Produce a diff of deployment artifact vs current state in specified environment.
                           -e {environment}    i.e. alpha|dev|sat

  deploy              Deploy driver to specified environment
                           -e {environment}    i.e. alpha|dev|sat

  version             Display driver versions

  migrate             migrate the driver to the gradle process

  encryptPassword     encrypt IDMUnit password

  decryptPassword     decrypt IDMUnit password

  dxcmdConnect        Validate dxcmd connectivity

  driverState         Check state of driver on server

  driverStop          Stop driver on server

  driverStart         Start driver on server

  driverRestart       Restart driver on server

  installCert         Install certificate for specified JVM.
                           -h {url}    default: 'nexus-tools.swacorp.com'
                           -j {java executable path}

  installCertGradle   Install certificate for gradle JVM.
                            -h {url}    default: 'nexus-tools.swacorp.com'

  showDeployConfig    Show the driverset deployment configuration.  Uses environment 'deploy_config' variable found in environments.yml
                            -e {environment}    i.e. alpha|dev|sat

  showSecrets         Shows all secrets.  Uses environment 'secrets_config' variable found in environments.yml
                            -e {environment}    i.e. alpha|dev|sat

  showSecret          Shows specified secret.  Uses environment 'secrets_config' variable found in environments.yml
                            -e {environment}    i.e. alpha|dev|sat
                            -k {secretName}     i.e. remoteLoaderPassword|namedPassword

  deleteSecret        Deletes specified secret.  Uses environment 'secrets_config' variable found in environments.yml
                            -e {environment}    i.e. alpha|dev|sat
                            -k {secretName}     i.e. remoteLoaderPassword|namedPassword

  setRemoteLoaderPassword   Sets remote loader password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat
                                 -p {password}

  deleteRemoteLoaderPassword   Deletes remote loader password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat

  setApplicationPassword    Sets application password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat
                                 -p {password}

  deleteApplicationPassword    Deletes application password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat

  setDriverObjectPassword   Sets driver object password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat
                                 -p {password}

  deleteDriverObjectPassword   Deletes driver object password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat

  showNamedPassword        Show specified named password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat
                                 -k {namedPassword}

  setNamedPassword         Sets specified named password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat
                                 -k {namedPassword}
                                 -p {password}

  deleteNamedPassword         Deletes specified named password.  Uses environment 'secrets_config' variable found in environments.yml
                                 -e {environment}    i.e. alpha|dev|sat
                                 -k {namedPassword}

  generateEnvFile              Generate environment file.  Will backup existing environments.yml

  generateIdmUnitConfig        Generate IDMUnit Configuration.  Will backup existing configuration, but will not keep substitution and data injections


x266698@SY4-HW2XSQ3 MINGW64 /c/work/MCL (CSEE-3749)
$

