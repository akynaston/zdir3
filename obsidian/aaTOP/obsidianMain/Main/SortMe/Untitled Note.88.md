# Untitled Note

Ports needed for password sync:

Jackie,

Per our conversation, here are the other ports that need to be opened,  following this documentation:  <https://www.netiq.com/documentation/idm45drivers/multidomain_ad/data/bow0k9b.html>

We need the following ports opened on the following servers:

135: The RPC endpoint mapper
137: NetBIOS name service
138: NetBIOS datagram service
139: NetBIOS session service

Opened between all 7 production DC's and our remote loaders:

[FCPSDC1.fcps.edu](http://fcpsdc1.fcps.edu/)
[FCPSDC2.fcps.edu](http://fcpsdc2.fcps.edu/)
[FCPSDC3.fcps.edu](http://fcpsdc3.fcps.edu/)
[FCPSDC4.fcps.edu](http://fcpsdc4.fcps.edu/)
[FCPSDC5.fcps.edu](http://fcpsdc5.fcps.edu/)
[FCPSDC6.fcps.edu](http://fcpsdc6.fcps.edu/)
[FCPSDC7.fcps.edu](http://fcpsdc7.fcps.edu/)

And on the remote loaders:

PRODIDMSTURLVM: 10.31.28.187
PRODIDMPSRLVM: 10.31.28.188
PRODIDMSTFRLVM: 10.31.28.189

For documentation purposes only and to keep our port requests together, I wanted to include the ports that we have already requested (and appear to be open as of now):

from idmprodidm1 to [PRODIDMSTFRLVM.fcps.edu](http://prodidmstfrlvm.fcps.edu/) on 8090 through 8099
from idmprodidm1 to [PRODIDMPSRLVM.fcps.edu](http://prodidmpsrlvm.fcps.edu/) on 8090 through 8099
from idmprodidm1 to [PRODIDMSTURLVM.fcps.edu](http://prodidmsturlvm.fcps.edu/) on 8090 through 8099
