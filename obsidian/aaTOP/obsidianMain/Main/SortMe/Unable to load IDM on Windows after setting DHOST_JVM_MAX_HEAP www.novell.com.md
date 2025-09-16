# Unable to load IDM on Windows after setting DHOST_JVM_MAX_HEAP [www.novell.com]

# Unable to load IDM on Windows after setting DHOST\_JVM\_MAX\_HEAP

This document **(7006685)** _is provided subject to the [disclaimer](http://www.novell.com/support/viewContent.do?externalId=7006685&sliceId=1#disclaimer) at the end of this document._

### Environment

Novell Identity Manager 3.6.1
Microsoft Windows Server 2003 Enterprise Edition - 32 bits
Microsoft Windows Server 2003 Standard Edition - 32 bits

### Situation

After setting the DHOST\_JVM\_MAX\_HEAP as an environment variable with a given value, the eDirectory service starts, but when looking in the NDS Console, the dirxml module is not started.
Restarting the eDirectory service loads the service correctly and is able to allocate the requested memory.
When enabling the Misc trace tag, the following error can be seen (dstrace.dlm needs to be set to automatic load and the Misc option saved as default to be able to capture startup errors):
Misc    : jvmload: JNI\_CreateJavaVM returned -4

### Resolution

When the Java Virtual Machine loads, the sum of the max heap size and/or max perm size need to be available as a contiguous block for the JVM to start. If this is not the case, the JVM load code will return error code -4 (JNI\_ENOMEM).
Apparently on Windows startup the situation arises that the required contiguous block can not be allocated. This is indeed available later in the process. One approach that can be taken is to delay the load of the dhost process by setting a dependency on a service that starts relatively late in the startup process.
A better approach is to provide the dhost process with more memory by using the /3GB switch on Windows startup. For more information on how to set it, refer to this article:
http://technet.microsoft.com/en-us/library/bb124810%28EXCHG.65%29.aspx
A similar set of symptoms can occur if the memory being requested for the Max Heap size exceeds the maximum amount of memory available as a contiguous block inside the process. There are many factors that affect how memory is being assigned inside the dhost address space. In order to have an indication of how large the max heap size can be set to, a tool like VMMap  from Sysinternals can be used to determine the largest available free block.
When starting Windows normally, dhost has a maximum space available of 2 GB. It's normal then that the maximum contiguous free block will be of up to 800 MB. This means that the maximum size that can be allocated for the heap size is of approximately 700MB.
Starting Windows with the /3GB switch allows the service to utilize up to 3 GB of memory. The largest chunk of consecutive memory, though, is normally not much larger than 1 GB. This means that the maximum heap size in this configuration will be of around 950 MB.
If a larger value is necessary for the maximum heap size, the best approach would be to use a 64 bit operating system supported by eDirectory and IDM.

### Additional Information

When loading the JVM, a few error codes can be returned. Here is a list of them as reference:
JNI\_OK           0                 /\* success \*/
JNI\_ERR          (-1)              /\* unknown error \*/
JNI\_EDETACHED    (-2)              /\* thread detached from the VM \*/
JNI\_EVERSION     (-3)              /\* JNI version error \*/
JNI\_ENOMEM       (-4)              /\* not enough memory \*/
JNI\_EEXIST       (-5)              /\* VM already created \*/
JNI\_EINVAL       (-6)              /\* invalid arguments \*/

### Document

|     |     |
| --- | --- |
| **Document ID:** | 7006685 |
| **Creation Date:** | 08-20-2010 |
| **Modified Date:** | 08-20-2010 |
| **Novell Product:** | Identity Manager |

### Disclaimer

The Origin of this information may be internal or external to Novell. Novell makes all reasonable efforts to verify this information. However, the information provided in this document is for your information only. Novell makes no explicit or implied claims to the validity of this information.
Any trademarks referenced in this document are the property of their respective owners. Consult your product manuals for complete trademark information.
