---
tags: ["#linux"]
---
# VerifyRootPrivileges()

VerifyRootPrivileges()
{
        UserID=\`id | awk '{print $1}' | awk -F"=" '{print $2}' | awk -F"(" '{pri
nt $1}'\`
        if \[ $UserID != 0 \]; then
                $ECHO $ErrorInsufficientRights
                exit 1
        fi
}
