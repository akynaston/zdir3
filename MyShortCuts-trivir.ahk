; IMPORTANT INFO ABOUT GETTING STARTED: Lines that start with a
; semicolon, such as this one, are comments.  They are not executed.

;!: Sends an ALT keystroke. For example, Send This is text!a would send the keys "This is text" and then press ALT+a. Note: !A produces a different effect in some programs than !a. This is because !A presses ALT+SHIFT+A and !a presses ALT+a. If in doubt, use lowercase.
;^: Sends a CONTROL keystroke. For example, Send ^!a would press CTRL+ALT+a, and Send ^{Home} would send CONTROL+HOME. Note: ^A produces a different effect in some programs than ^a. This is because ^A presses CONTROL+SHIFT+A and ^a presses CONTROL+a. If in doubt, use lowercase.
;+: Sends a SHIFT keystroke. For example, Send +abC would send the text "AbC", and Send !+a would press ALT+SHIFT+a.
;#: Sends a WIN keystroke, therefore Send #e would hold down the Windows key and then press the letter "e".

#SingleInstance force
; for modiyfing myshortcuts.ahk window to  into focus
; didn't work - july 20 2013 #WinActivateForce

CURRENTTIMESHEETID=28786

BROWSERCHOICE=C:\Program Files\Google\Chrome\Application\chrome.exe
MAINDIR=C:\z
MAINDIRROOT=C:\z
#EvernoteBinary=C:\Program Files (x86)\Evernote\Evernote\Evernote.exe
ObsidianBinary=C:\Program Files\Obsidian\obsidian.exe
NPP=C:\Program Files\Notepad++\notepad++.exe
SHADOWVM=C:\shadow0\vmware
MYSHORTCUTSAHK=c:\z\MyShortCuts-trivir.ahk

; Setup Z: to point at main backup directory:
;run cmd.exe /c "subst /d Z: C:\zbackup" > NUL
;run cmd.exe /c "subst Z: C:\zbackup" > NUL

Process, Priority, , High
; To allow substring match:
SetTitleMatchMode, 2
; to support evernote (STILL TO TEST:)
SetTitleMatchMode, Slow
return

;==============================================================================================
;Meta functions:
!x::doreload()
!z::doEditMainScripts()
;Esc::ExitApp  ;Escape key will exit, including stopping scripts.

doReload() {
    Reload
    Sleep 1000 ; If successful, the reload will close this instance during the Sleep, so the line below will never be reached.
    MsgBox, 4,, The script could not be reloaded. Would you like to open it for editing?
    IfMsgBox, Yes, Edit
    return
}

doEditMainScripts()
{
    IfWinExist %MYSHORTCUTSAHK%
    {
        WinActivate
    }

    else
    {
        RunWait "C:\Program Files\Notepad++\notepad++.exe" c:\z\MyShortCuts-trivir.ahk
        Sleep 500
        WinActivate
    }

    WinWaitActive MyShortCuts.ahk
    WinGetPos x, y
    WinMove, MyShortCuts.ahk,, x, y, 2200, 1500

    CenterWindow("MyShortCuts.ahk")

    return
}

;==============================================================================================

CenterWindow(WinTitle) {

	SysGet, Display_, Monitor, 2
	WinGetPos, x,y, Width, Height, %WinTitle%
    WinMove, %WinTitle%,, (A_ScreenWidth/2)-(Width/2), (A_ScreenHeight/2)-(Height/2)
	; trying to fix issue with not centering properly on second monitor when first monitor is super high res.
	;SysGet, Display_, Monitor, 1
	;WinGetPos,,, WinW, WinH, % WinTitle
	;WinMove, % WinTitle,, % Floor( (Display_Right/2)-(WinW/2) ), % Floor( (Display_Bottom/2)-(WinH/2) )
}

;Centers window with 'CenterWindow' call, then offsets the placement of the window slightly down and to the right.
CenterWindowAdjust(WinTitle, plusX, plusY)
{
    WinGetPos, x,y,,, %WinTitle%
    WinMove, %WinTitle%, x+plusx, plusy,
}
;====================================================================
;====================================================================
; Helper functions
;====================================================================
;====================================================================
ShowHelp()
{
IfWinExist AutoHotkey Help
    WinActivate
else
    Run C:\z\Main\AutoHotkey\AutoHotkey.chm

return
}

doSetSizeAndLocation()
{
    WinGetPos x, y
    WinMove, ,, x, y, 978, 962

;    WinGetPos,,, Width, Height, %WinTitle%
;   WinMove, %WinTitle%,, (A_ScreenWidth/2)-(Width/2), (A_ScreenHeight/2)-(Height/2)

}

;====================================================================

;===================================================================================================
;===================================================================================================
;Folder shortcuts
;===================================================================================================
;===================================================================================================


;====================================================================
^+!d::Run C:\t\downloads
return

;====================================================================
^!+e::
Run %ObsidianBinary%
Sleep 500
WinActivate Obsidian
WinWaitActive, Obsidian
IfWinExist, "Obsidian"
{
    msgbox "window was seen; waiting 3 seconds, then win-wait activating . .."
    Sleep 3000
    WinWaitActive, " Obsidian"
}
CenterWindow("Obsidian")
WinWaitActive, Obsidian
return

;====================================================================
^!+\::
	IfWinExist , C:\work\adminrepo
	{
		WinActivate
		WinWaitActive work\adminrepo
	} else {
		Run explorer C:\work\adminrepo
	}

	;sleep 50

	;IfWinExist , Authorisation Services (Export Control)
	;{
		;WinActivate
		;WinWaitActive Authorisation Services (Export Control)
	;} else {
		;Run explorer "C:\Users\akynaston\Google Drive\BAE\BAE Systems plc"
	;}

	;Send {shift down}{Tab}{shift up}

  CenterWindow("C:\work\adminrepo")

return

;====================================================================
^!+]::
DetectHiddenWindows, On
Run %BROWSERCHOICE% https://app.clickup.com/45049292/v/o/f/90115900892
return

;===================================================================================================
;===================================================================================================
; Program scripts
;===================================================================================================
;===================================================================================================
;====================================================================
^!+z::
IfWinExist workNotes.txt
{
    WinActivate
    WinWaitActive workNotes.txt
}
else
{
    Run, %NPP% C:\z\workNotes.txt
    WinActivate
    WinWaitActive workNotes.txt
}
WinMove workNotes.txt, , , , 1600, 1100
ControlFocus
CenterWindow("workNotes.txt")


IfWinExist workNotes-Trivir.txt
{
    WinActivate
    WinWaitActive workNotes-Trivir.txt
}
else
{
    Run, %NPP% C:\z\workNotes-Trivir.txt
    WinActivate
    WinWaitActive workNotes-Trivir.txt
}
WinMove workNotes-Trivir.txt, , , , 1600, 1100
ControlFocus
CenterWindow("workNotes-Trivir.txt")






return

;====================================================================
^!+a::
IfWinExist aaaToday.txt
{
    WinActivate
    WinWaitActive aaaToday.txt
}
else
{
    Run, %NPP% %MAINDIR%\aaaToday.txt
    WinActivate
    WinWaitActive aaaToday.txt
}

; 1800, 1100 good on work monitor.
WinMove aaaToday.txt, , , , 1900, 1200

ControlFocus
CenterWindow("aaaToday.txt")

return

;;====================================================================
^!+0::
Run C:\t
return

;====================================================================
;LShift & ~::
    ;InputBox, googleitem,Google item,googleitem,,200,100
    ;run www.google.com
    ;WinWaitActive Google
    ;StatusBarWait, Done, 60
    ;StatusBarWait, Done, 60
    ;mouseclick, left, 438,333
    ;SendInput %googleitem%
    ;SendInput {Enter}
;return

;=============================================
; Show VMWare folders
^+!v::
;Run C:\z\OFF-LOAD-ARCHIVE\vmware
;sleep 50
ifExist, C:\zbackupvmware
{
    run C:\zbackupvmware
}
sleep 50
ifExist, C:\zbackup\vmware
{
    run C:\zbackup\vmware
}
sleep 50
ifExist, C:\vmwareOnHold
{
    run C:\vmwareOnHold
}
;sleep 50
;run C:\vmwareOff
sleep 50
run C:\vmware
return

;====================================================================
^!+t::

IfWinExist TriVirTimes.ods
{
	WinActivate
}
else
{
	WinActivate
	SetWorkingDir %MAINDIRROOT%



;  run "C:\Program Files\Microsoft Office\root\Office16\EXCEL.EXE" "C:\z\TrivirTimes.ods"
RUN "C:\Program Files\LibreOffice\program\scalc.exe" "C:\z\TrivirTimes.ods"
;run "C:\Program Files (x86)\Microsoft Office\Office14\Excel.exe" C:\z\TriVirTimes.ods

	;Sleep 500
	;WinActivate
	;WinRestore, TrivirTimes
}

  WinGetPos x, y
  WinMove TriVirTimes.ods, , 518, 185, 1351, 953

return

;====================================================================
^!+s::
IfWinExist zstandup.txt
{
    WinActivate
    WinWaitActive zstandup.txt
}
else
{
    Run, %NPP% C:\z\zstandup.txt
    WinActivate
    WinWaitActive zstandup.txt
}
WinMove zstandup.txt, , , , 1600, 1100
ControlFocus
CenterWindow("zstandup.txt")

return

;====================================================================
^!+f9::
RunWait *runas C:\z\backupscripts\sync.exe
;msgbox Sync isn't being used any more . . .Disabled! It deletes vss snapshots!
return

;====================================================================
^!+q::
	IfWinExist OpenAir [www.openair.com]
		WinActivate
	else
		; Note: the sleeps are so that the pages come up in order:
		; Standard time cards:
		;Run "%BROWSERCHOICE%" --profile-directory="Profile 1"  https://www.openair.com/index.pl

    ; Active timecard!
    Run "%BROWSERCHOICE%" --profile-directory="Profile 1" https://trivir.app.openair.com/timesheet.pl?layout=open;action=grid;timesheet_id=%CURRENTTIMESHEETID%


    ; Rejected time cards:
		; not working: timesheet layout isn't right . .or something is msising . .Run "%BROWSERCHOICE%" --profile-directory="Profile 1"  https://www.openair.com/index.pl;_timesheet_layout=rejected;

return

;====================================================================
::qwer::
sendOutDate()
return

;====================================================================
::qwerty::
SendInput mtg-Daily{Tab}
SendInput 01/01/2000 8:30 am
SendInput {Tab}
SendInput 01/01/2000 9:00 am
SendInput {Tab}
SendInput Daily meetings with the team.
return


;==============================================================================================

sendOutDate() {
    ; sends out current time: 10:15:08 AM 9/29/2006
    FormatTime, output, dd/MM/yyyy hh:mm:ss tt R
    SendInput %output%
}

;====================================================================
^!+1::Run %EvernoteBinary% evernote:///view/698071/s4/29d45993-f92b-4007-b211-0752bff46ba9/29d45993-f92b-4007-b211-0752bff46ba9/

;====================================================================
^!+w::run "C:\Program Files\Windows Mail\wab.exe"

;====================================================================
; from: http://stackoverflow.com/questions/122404/how-to-copy-and-paste-code-without-rich-text-formatting
^+2::
    ; Convert any copied files, HTML, or other formatted text to plain text
    Clipboard = %Clipboard%

    ; Paste by pressing Ctrl+V
    SendInput, ^v
return

;====================================================================
;^!+f8::
Run https://www.youtube.com/watch?v=LI7-Cu-9wWM
return

;====================================================================
;^!+r::Run C:\Program Files (x86)\Desura\Common\robo-miner\RoboMiner.exe


;====================================================================
;+!^/::run C:\z\util\suspend.bat
+!^/::
; Call the Windows API function "SetSuspendState" to have the system suspend or hibernate.
; Parameter #1: Pass 1 instead of 0 to hibernate rather than suspend.
; Parameter #2: Pass 1 instead of 0 to suspend immediately rather than asking each application for permission.
; Parameter #3: Pass 1 instead of 0 to disable all wake events.
DllCall("PowrProf\SetSuspendState", "int", 0, "int", 0, "int", 0)
return

;====================================================================
^!+Space::
    ;Personal:
	Run "%BROWSERCHOICE%" --profile-directory="Profile 2" https://mail.google.com/mail/u/0/#inbox
return

;====================================================================
^!+g::
    ;TriVir:
	Run "%BROWSERCHOICE%" --profile-directory="Profile 1" https://mail.google.com/mail/u/0/#inbox
    ; gmail offline: run: https://mail.google.com/mail/mu/mp/57/?mui=ca#tl/priority/%5Esmartlabel_personal
return

;====================================================================
^`::
    Run "%BROWSERCHOICE%" --profile-directory="Profile 1"
return

;====================================================================
^!+2::
Run "%BROWSERCHOICE%" --profile-directory="Profile 2" --app-id=knipolnnllmklapflnccelgolnpehhpl
Run "%BROWSERCHOICE%" --profile-directory="Profile 1" --app-id=knipolnnllmklapflnccelgolnpehhpl
return

;====================================================================
^!+x::
IfWinExist noteshistory1.txt
{
    WinActivate
    WinWaitActive noteshistory1.txt
}
else
{
    Run, %NPP% %MAINDIRROOT%\noteshistory1.txt
    WinActivate
    WinWaitActive noteshistory1.txt
}

WinMove noteshistory1.txt, , 350, 260, 819, 819

return

;====================================================================
^!+M::
run net use N: \\10.10.10.5\ut /user:trivir trivir#1
run net use O: \\10.10.10.5\ut-alt /user:trivir trivir#1
run net use P: \\10.10.10.5\va /user:trivir trivir#1
run subst Z: C:\zbackup
return

;====================================================================
^!+,::
run net use N: /delete
run net use O: /delete
run net use P: /delete

return


;====================================================================
^NumpadEnter::
RunWait *runas C:\windows\system32\cmd.exe
return

;====================================================================
^!+j::
;run *runas cmd.exe /K "C: && cd\work\adminrepo && dir"
run cmd.exe /K "C: && cd\work\adminrepo && cls && dir && git s"
return

;====================================================================
^!+F5::
msgbox,,,Setting default Aaron file associations, please allow Administrative action . .,.75
RunWait *runas C:\z\setFileAssociations.bat
return

;====================================================================
^!+p::
  ;netsuite:
  ;Run "%BROWSERCHOICE%" --new-window --profile-directory="Profile 1" https://system.n.com/app/center/card.nl?c=455117
  Run "C:\Program Files (x86)\Ping Identity\PingID\PingID.exe"
return

doKill() {
    run taskkill /f /im chrome.exe
    run taskkill /f /im privacyiconclient.exe
    run taskkill /f /im applemobiledeviceservice.exe
    run taskkill /f /im itunes*
    run taskkill /f /im tpnumlkd.exe
    run taskkill /f /im SearchProtection.exe
    run taskkill /f /im Skype.exe
    run taskkill /f /im SanDiskSecureAccess_Manager.exe
    run taskkill /f /im iCloudServices.exe
    run taskkill /f /im SmileboxTray.exe
    ;run taskkill /f /im Origin.exe
    run taskkill /f /im SkypeC2CAutoUpdateSvc.exe
    run taskkill /f /im SkypeC2CPNRSvc.exe
    RUN TASKKILL /F /IM DESURA.EX.exe
    run taskkill /f /im evolve.eE
    run taskkill /f /im handyandyxe
    run taskkill /f /im evolveclient.exe
    run taskkill /f /im evolvetracker_64.exe
    run taskkill /f /im GalaxyClient.exe
    run taskkill /f /im GalaxyClientHelper.exe
    run taskkill /f /im LSCNotify.exe
    run taskkill /f /im mfac.exe
    run taskkill /f /im mfacupdate.exe
    run taskkill /f /im TSVNCache.exe
    run taskkill /f /im msedge.exe
    run taskkill /f /im passcode.exe
    run taskkill /f /im msedgewebview2.exe
  	run taskkill /f /im Teams.exe

}

;====================================================================
^!+6::
; Gitlab:

; this version shows all my MRs
Run %BROWSERCHOICE% https://southwest.gitlab-dedicated.com/groups/csiam/idm/-/merge_requests?scope=all&state=opened&author_username=x266698

; This version also excludes items I've seen by marking them as 'glasses'
Run %BROWSERCHOICE% https://southwest.gitlab-dedicated.com/groups/csiam/idm/-/merge_requests?scope=all&state=opened&not[approved_by_usernames][]=x266698&not[my_reaction_emoji]=eyeglasses&not[author_username][]=x266698

;https://southwest.gitlab-dedicated.com/groups/csiam/idm/-/merge_requests/?sort=created_date&state=opened&not%5Bapproved_by_usernames%5D%5B%5D=x266698&not%5Bmy_reaction_emoji%5D=eyeglasses&not%5Bauthor_username%5D%5B%5D=x266698&first_page_size=20

return

;====================================================================
^!+l::
Run %BROWSERCHOICE% https://confluence-tools.swacorp.com/display/CYSEC/LANDING+Setting+up+for+IAM+Development
return

;====================================================================
^!+i::
Run "C:\Users\akynaston\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\System Tools\Command Prompt" /K "cd C:\z && git s"
return

;====================================================================
^!+-::
SendInput mtg-Daily{Tab}
sendOutDate()
SendInput {Enter}
return


;====================================================================
^!+u::
run cmd.exe /c "C: && cd\zall && C:\zall\doPullFullrepos.bat"
return
