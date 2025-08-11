@echo off
echo Starting Pure Healthy Eats Application...
echo.
echo Setting JAVA_HOME...
set JAVA_HOME=C:\Program Files\Java\jdk-24

echo.
echo Starting Spring Boot application on port 8080...
echo Visit: http://localhost:8080
echo.

call mvnw.cmd spring-boot:run

pause
