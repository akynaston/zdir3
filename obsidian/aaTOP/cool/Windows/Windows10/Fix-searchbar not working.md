3/18/2024 3:33:58 PM
search bar wasn't working, from this page:

https://learn.microsoft.com/en-us/troubleshoot/windows-client/shell-experience/fix-problems-in-windows-search

I ran this:

msdt.exe -ep WindowsHelp id SearchDiagnostic

and while it was working, it seemed to have fixed my problem about half way through 

Results from troubleshooter after it did come back:

![Print](res://sdiageng.dll/print.png)

|   |   |
|---|---|
|Search and Indexing|[Publisher details](#Publisher)|

|   |   |   |
|---|---|---|
|Issues found|   |   |
|[Windows Search is not working](#3)<br><br>Windows Search is not working<br><br>You can't enter a search or you get incomplete search results.|Fixed|![Fixed](res://sdiageng.dll/check.png)|
|\|   \|   \|   \|<br>\|---\|---\|---\|<br>\|Restart the Windows Search application.\|Completed\|   \||   |   |   |

|   |   |   |
|---|---|---|
|Potential issues that were checked|   |   |
|[Incorrect permissions on Windows Search directories](#6)<br><br>Incorrect permissions on Windows Search directories<br><br>When permissions on the Windows Search data directories are set incorrectly, the search service might not be able to access or update the computer's search index. This can result in slow searches or incomplete search results.|Issue not present||
|[Search Filter Host process failed](#9)<br><br>Search Filter Host process failed<br><br>Problems with the Search Filter Host might indicate errors in the Windows Search service, which can cause searches to fail or return incomplete search results.|Issue not present||
|[Windows Search service shut down unexpectedly](#12)<br><br>Windows Search service shut down unexpectedly<br><br>When the Windows Search service is forcibly shut down while performing maintenance, searches might fail or return incomplete search results.|Issue not present||
|[Windows Search service shut down unexpectedly](#15)<br><br>Windows Search service shut down unexpectedly<br><br>When the Windows Search service is forcibly shut down, searches might fail or return incomplete search results.|Issue not present||
|[Windows Search service not running](#18)<br><br>Windows Search service not running<br><br>When the Windows Search service is not running, searches might be slower, and you might not be able to find all items.|Issue not present||
|[Windows Search service failed](#21)<br><br>Windows Search service failed<br><br>Problems with the Windows Search service can cause searches to fail or return incomplete search results.|Issue not present||
|[Search Protocol Host process failed](#24)<br><br>Search Protocol Host process failed<br><br>Problems with the Search Protocol Host might indicate errors in the Windows Search service, which can cause searches to fail or return incomplete search results.|Issue not present||

|   |   |
|---|---|
|Issues found|[Detection details](#Detection)|

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|6\|Windows Search is not working\|Fixed\|![Fixed](res://sdiageng.dll/check.png)\||
|You can't enter a search or you get incomplete search results.|
|\|   \|<br>\|---\|<br>\|\\|   \\|   \\|<br>\\|---\\|---\\|<br>\\|Restart the Windows Search application.\\|Completed\\|<br>\|Reset the Windows Search process (SearchUI.exe), remove any Windows Search cache files and folders, and clear any Recent activity.\||

|   |   |
|---|---|
|Potential issues that were checked|[Detection details](#Detection)|

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Incorrect permissions on Windows Search directories\|Issue not present\||
|When permissions on the Windows Search data directories are set incorrectly, the search service might not be able to access or update the computer's search index. This can result in slow searches or incomplete search results.|
||

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Search Filter Host process failed\|Issue not present\||
|Problems with the Search Filter Host might indicate errors in the Windows Search service, which can cause searches to fail or return incomplete search results.|
||

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Windows Search service shut down unexpectedly\|Issue not present\||
|When the Windows Search service is forcibly shut down while performing maintenance, searches might fail or return incomplete search results.|
||

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Windows Search service shut down unexpectedly\|Issue not present\||
|When the Windows Search service is forcibly shut down, searches might fail or return incomplete search results.|
||

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Windows Search service not running\|Issue not present\||
|When the Windows Search service is not running, searches might be slower, and you might not be able to find all items.|
||

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Windows Search service failed\|Issue not present\||
|Problems with the Windows Search service can cause searches to fail or return incomplete search results.|
||

|   |
|---|
|\|   \|   \|   \|   \|<br>\|---\|---\|---\|---\|<br>\|Search Protocol Host process failed\|Issue not present\||
|Problems with the Search Protocol Host might indicate errors in the Windows Search service, which can cause searches to fail or return incomplete search results.|
||

|   |   |
|---|---|
|Detection details|![Expand](res://sdiageng.dll/collapse.png)|

|   |
|---|
|![Informational](res://sdiageng.dll/info.png)<br><br>Directory|
|Windows Search data directory|
|\|   \|   \|<br>\|---\|---\|<br>\|Directory:\|C:\ProgramData\Microsoft\Search\Data\\||

|   |
|---|
|![Informational](res://sdiageng.dll/info.png)<br><br>Directory|
|Windows Search data directory|
|\|   \|   \|<br>\|---\|---\|<br>\|Directory:\|C:\ProgramData\Microsoft\Search\Data\\||

|   |
|---|
|![Informational](res://sdiageng.dll/info.png)<br><br>User-reported problems|
|\|   \|   \|<br>\|---\|---\|<br>\|Problem Type:\|SearchAppProblem\|<br>\|FilesMissingProblem\||

|   |
|---|
|![Informational](res://sdiageng.dll/info.png)<br><br>User-reported problems|
|\|   \|   \|<br>\|---\|---\|<br>\|Problem Type:\|SearchAppProblem\|<br>\|FilesMissingProblem\||

|   |   |
|---|---|
|Collection information|   |
|Computer Name:|SY4-HW2XSQ3|
|Windows Version:|10.0|
|Architecture:|x64|
|Time:|Monday, March 18, 2024 3:32:06 PM|

|   |   |
|---|---|
|Publisher details|![Expand](res://sdiageng.dll/expand.png)|

|   |   |
|---|---|
|Search and Indexing|   |
|Find and fix problems with Windows Search|   |
|Package Version:|1.0|
|Publisher:|Microsoft Windows|

|                                           |                       |
| ----------------------------------------- | --------------------- |
| Search and Indexing                       |                       |
| Find and fix problems with Windows Search |                       |
| Package Version:                          | 1.0                   |
| Publisher:                                | Microsoft Corporation |
