2/5/2024 11:22:47 AM

HIt issue with git status most of the time: would take like 30 seconds, then crash!

"0 [main] sh (26644) C:\Program Files\Git\usr\bin\sh.exe: *** fatal error - add_item ("\??\C:\Program Files\Git", "/", ...) failed, errno 1"





C:\z>git --version
git version 2.43.0.windows.1


git 2.43.0 - 'failed errno 1 add_item'




Moving to Git-2.42.0.2-64-bit.exe, from: https://github.com/git-for-windows/git/releases

still having issues:

      0 [main] sh (26660) C:\Program Files\Git\usr\bin\sh.exe: *** fatal error - add_item ("\??\C:\Program Files\Git", "/", ...) failed, errno 1
Stack trace:
Frame         Function      Args
0007FFFFCD30  00021006118E (000210290E7A, 000210272B51, 00000000007F, 0007FFFF8B30) msys-2.0.dll+0x2118E
0007FFFFCD30  0002100469BA (000000000000, 0007FFFFCD30, 0001A1000010, 0007FFFFABF0) msys-2.0.dll+0x69BA
0007FFFFCD30  0002100469F2 (0007FFFF9BC0, 000000000001, 00000000007F, 000000000001) msys-2.0.dll+0x69F2
0007FFFFCD30  00021007E7D7 (000700000000, 000040000024, 000000000000, 000000000000) msys-2.0.dll+0x3E7D7
0007FFFFCD30  0002101832E5 (0002100731F4, 000000000000, 000000000000, 000000000000) msys-2.0.dll+0x1432E5
0007FFFFCD30  000210047012 (000000000000, 000000000000, 000000000000, 000000000000) msys-2.0.dll+0x7012
0007FFFFFFF0  000210045C86 (000000000000, 000000000000, 000000000000, 000000000000) msys-2.0.dll+0x5C86
0007FFFFFFF0  000210045D34 (000000000000, 000000000000, 000000000000, 000000000000) msys-2.0.dll+0x5D34
End of stack trace
Loaded modules:
000100400000 sh.exe
7FFC21810000 ntdll.dll
7FFC20A10000 KERNEL32.DLL
7FFC1F000000 KERNELBASE.dll
7FFBD8280000 ctiuser.dll
7FFC202B0000 USER32.dll
7FFC1F750000 win32u.dll
7FFC20930000 GDI32.dll
7FFC1EEE0000 gdi32full.dll
7FFC1F4B0000 msvcp_win.dll
000210040000 msys-2.0.dll
7FFC1F300000 ucrtbase.dll
7FFC215F0000 ADVAPI32.dll
7FFC212E0000 msvcrt.dll
7FFC1FA30000 sechost.dll
7FFC211B0000 RPCRT4.dll
7FFC1F550000 bcrypt.dll
7FFC09E50000 FLTLIB.DLL
7FFC21100000 IMM32.DLL
7FFC1E7A0000 CRYPTBASE.DLL
7FFC1F7D0000 bcryptPrimitives.dll


Testing Git-2.41.0.3-64-bit.exe . .

Still issues - moving to: Git-2.40.1-64-bit.exe - this should have been my original version.



So far, 2.40.1-64 seems to have fixed the issue.