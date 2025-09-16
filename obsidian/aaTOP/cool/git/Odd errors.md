4/12/2024 9:54:17 PM
While doing an unshallow on zFull and adminFull


C:\fullrepos\zFull>git fetch --unshallow
remote: Enumerating objects: 14203, done.
remote: Counting objects: 100% (14203/14203), done.
remote: Compressing objects: 100% (6676/6676), done.
error: RPC failed; curl 18 transfer closed with outstanding read data remaining
error: 5712 bytes of body are still expected
fetch-pack: unexpected disconnect while reading sideband packet
fatal: early EOF
fatal: fetch-pack: invalid index-pack output



C:\fullrepos\adminFull>git fetch --tags
remote: Enumerating objects: 25238, done.
remote: Counting objects: 100% (726/726), done.
remote: Compressing objects: 100% (110/110), done.
error: RPC failed; curl 56 Failure when receiving data from the peer
error: 1139 bytes of body are still expected
fetch-pack: unexpected disconnect while reading sideband packet
fatal: early EOF
fatal: fetch-pack: invalid index-pack output



