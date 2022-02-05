@echo off
cd "C:\Optily\bin"
start java -cp h2-1.4.200.jar org.h2.tools.Server -tcp -web
%SystemRoot%\SSystem32\timeout.exe /T 5 /NOBREAK >nul
start java -Xmx2000M -Xms1000M -jar OptimalBudgeting-0.0.1-SNAPSHOT.jar
%SystemRoot%\SSystem32\timeout.exe /T 30 /NOBREAK >nul
start http://localhost:8080//swagger-ui.html#/app45controller
start http://localhost:8082/
exit