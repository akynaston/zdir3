# Fwd:

\>>> Application Account for Novell eDirectory <ediradmin@idmprodidm1.fcps.edu> 4/17/2015 4:09 PM >>>
#Check if /opt/novell is mounted as read only: if this returns a 1, it is read only, and I need to know about it.
#isReadOnly=\`touch /opt/novell/eDirectory/logs 2> /dev/null; echo $?\`
isReadOnly=\`touch /root 2> /dev/null; echo $?\`
if \[ $isReadOnly -eq 1 \]; then
    echo "151.188.9.62: /opt/novell is read only again! " | mail akynaston@fcps.edu
fi
