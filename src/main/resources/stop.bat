@echo off

for /f "useback tokens=* delims=" %%# in (
  `wmic process where "CommandLine like '%%car-marketplace-demo-app.jar%%' and not CommandLine like '%%wmic%%' " get ProcessId /Format:Value`
) do (
  for /f "tokens=* delims=" %%a in ("%%#") do set "%%a"
)

echo Stopping Booking application with PID %processId%

taskkill /pid %processId% /f