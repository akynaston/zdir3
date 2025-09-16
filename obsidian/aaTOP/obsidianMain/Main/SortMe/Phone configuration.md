# Phone configuration

Add mobile data disable & hotspot:

in adb shell:

settings put secure sysui\_qs\_tiles "$(settings get secure sysui\_qs\_tiles),MobileData,Hotspot"
