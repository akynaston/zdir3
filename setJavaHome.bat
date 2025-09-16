@echo off
xcopy *.bat C:\z\tools\bat /y/d
set JAVAHOME=
echo Setting JAVA_HOME . .
setx JAVA_HOME c:\Users\x266698\.jdks\azul-17.0.12
