@echo off
setlocal EnableDelayedExpansion

for /R %%f in (*.json) do (
    echo Processing "%%f..."
    jq . "%%f" > "%%f.tmp"
    move /y "%%f.tmp" "%%f"
)
endlocal
