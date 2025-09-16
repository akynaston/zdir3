3/23/2023 2:11:53 PM
-ea -Dcom.sun.jndi.ldap.object.disableEndpointIdentification=true



4/5/2022 7:13:34 PM
from idtocafm:
 <xsl:value-of select="query:getNamedPassword($srcQueryProcessor,'idv.wsdl.Password')"/>



See my objects created today:
(&
    (createTimestamp>=20220830000000Z)
    (!(objectClass=wd-Relation))
    (!(objectClass=nrfRequest))
    (!(objectClass=nrfResourceRequest))
    (!(objectClass=DirXML-WorkOrder))
)


    <target name="getGitBranchVersion">
        <!--
            Get the current branch:
            https://stackoverflow.com/questions/9429677/get-git-branch-name-in-build-process
        -->
        <exec executable="git" outputproperty="git.branch" failifexecutionfails="false">
            <arg line="rev-parse --abbrev-ref HEAD"/>
        </exec>

        <!--
            Get the most recent tag:
        -->
        <exec executable="git" outputproperty="git.tag" failifexecutionfails="false">
            <arg line="describe --tags --abbrev=0 HEAD"/>
        </exec>

        <echo message="New version to use for build: ${git.tag}-${git.branch}"/>
    </target>




11/7/2022 11:10:36 AM- Need to update state file:
/swa/opt/netiq/rdxmlrl/etc/opt/novell/dirxml/rdxml/WorkdayHCM


Get cert from edir server: . .might work from any ldaps . .?
openssl s_client -servername diridvsps.cis.dev.swacorp.com -connect diridvsps.cis.dev.swacorp.com:636 2>/dev/null </dev/null |  sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p'



4/24/2023 9:47:04 AM
To fix this:

C:\z>git fetch
warning: git-credential-manager-core was renamed to git-credential-manager
warning: see https://aka.ms/gcm/rename for more information



C:\z>git update-git-for-windows
Git for Windows 2.40.0.windows.1 (64-bit)
Up to date

C:\z>git config --show-origin --get-all credential.helper
file:C:/Program Files/Git/etc/gitconfig manager
file:C:/users/x266698/.gitconfig        manager-core

C:\z>git config --global --edit



was already on latest, but found .gitconfig in --global still had -core on it.

6/12/2023 9:31:52 AM
Avoid getting tags: handy for shallow clones:
git config remote.upstream.tagOpt --no-tags



6/12/2023 9:34:06 AM
Testing adding a new route to bypass vpn for local stuff:
route -p add 10.10.10.2 mask 255.255.255.255 10.10.10.1
