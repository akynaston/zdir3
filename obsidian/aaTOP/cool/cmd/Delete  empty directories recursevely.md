Really just does a delete on all dirs, but the ones with files fail . .
for /f "delims=" %d in ('dir /s /b /ad ^| sort /r') do rd "%d"