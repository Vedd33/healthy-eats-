@echo off
echo Testing Pure Healthy Eats Application...
echo.

echo Checking Java installation...
java -version
if %ERRORLEVEL% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 17 or higher
    pause
    exit /b 1
)

echo.
echo Java is installed!
echo.

echo To run this application, you need either Maven or Gradle installed.
echo.
echo Option 1: Install Maven and run: mvn spring-boot:run
echo Option 2: Install Gradle and run: gradle bootRun
echo Option 3: Use an IDE like IntelliJ IDEA or Eclipse to run the application
echo.

echo For now, let's try to compile manually...
echo.

rem Create directories for compiled classes
if not exist "target\classes" mkdir target\classes

echo Attempting to compile Java files...
rem This is a simplified attempt - normally Spring Boot requires proper classpath
javac -cp "." -d target\classes src\main\java\com\purehealthyeats\app\*.java src\main\java\com\purehealthyeats\app\model\*.java src\main\java\com\purehealthyeats\app\repository\*.java src\main\java\com\purehealthyeats\app\service\*.java src\main\java\com\purehealthyeats\app\controller\*.java 2>nul

if %ERRORLEVEL% neq 0 (
    echo.
    echo Manual compilation failed (expected - Spring Boot needs proper dependencies)
    echo.
    echo RECOMMENDED SOLUTION:
    echo 1. Install Maven from: https://maven.apache.org/download.cgi
    echo 2. Add Maven to your PATH
    echo 3. Run: mvn spring-boot:run
    echo.
    echo OR
    echo.
    echo 1. Open this project in IntelliJ IDEA or Eclipse
    echo 2. Let the IDE download dependencies
    echo 3. Run PureHealthyEatsApplication.java
    echo.
) else (
    echo Compilation successful, but still need Spring Boot runtime...
)

pause
