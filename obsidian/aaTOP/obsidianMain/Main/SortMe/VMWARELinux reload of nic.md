---
tags: ["#vmware","#linux"]
---
# VMWARE/Linux: reload of nic

VMWARE/Linux: reload of nic

/etc/init.d/network stop
rmmod pcnet32
rmmod vmxnet
depmod -a
modprobe vmxnet
/etc/init.d/network start
