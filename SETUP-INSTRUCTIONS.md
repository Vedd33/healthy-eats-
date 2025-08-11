# Setup Instructions for Pure Healthy Eats Application

## The Problem
Your page is not loading because Maven is not installed on your system. Maven is needed to download the Spring Boot dependencies and run the application.

## Quick Solution (Recommended)

### Option 1: Install Maven (5 minutes)

1. **Download Maven:**
   - Go to: https://maven.apache.org/download.cgi
   - Download "Binary zip archive" (apache-maven-3.9.5-bin.zip)

2. **Extract Maven:**
   - Create folder: `C:\Program Files\Apache\maven`
   - Extract the downloaded zip to this folder
   - You should have: `C:\Program Files\Apache\maven\apache-maven-3.9.5\`

3. **Set Environment Variables:**
   - Press `Win + R`, type `sysdm.cpl`, press Enter
   - Click "Environment Variables"
   - Under "System Variables", click "New":
     - Variable name: `MAVEN_HOME`
     - Variable value: `C:\Program Files\Apache\maven\apache-maven-3.9.5`
   - Find "Path" in System Variables, click "Edit", click "New":
     - Add: `%MAVEN_HOME%\bin`
   - Click OK on all dialogs

4. **Restart PowerShell/Command Prompt**

5. **Test Maven:**
   ```bash
   mvn --version
   ```

6. **Run the Application:**
   ```bash
   cd pure-healthy-eats
   mvn spring-boot:run
   ```

7. **Access the Application:**
   - Open browser: http://localhost:8080
   - You should see the registration page!

### Option 2: Use IDE (IntelliJ IDEA - Even Easier!)

1. **Download IntelliJ IDEA Community (Free):**
   - Go to: https://www.jetbrains.com/idea/download/
   - Download Community Edition (free)

2. **Open Project:**
   - Open IntelliJ IDEA
   - Click "Open" and select the `pure-healthy-eats` folder

3. **Wait for Dependencies:**
   - IntelliJ will automatically download all Spring Boot dependencies
   - This may take 2-3 minutes the first time

4. **Run Application:**
   - Find `PureHealthyEatsApplication.java` in the project
   - Right-click → "Run PureHealthyEatsApplication"

5. **Access the Application:**
   - Open browser: http://localhost:8080

## What You'll See

Once running, you can:
- **Register Page:** http://localhost:8080/register
- **Login Page:** http://localhost:8080/login (placeholder for now)
- **Database Console:** http://localhost:8080/h2-console (to see stored users)

## Current Features Working

✅ **Registration System**
- Form validation
- User data storage in H2 database
- Error handling
- Clean, professional UI

## Database Access (H2 Console)

To see the registered users:
1. Go to: http://localhost:8080/h2-console
2. Use these settings:
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User Name: `sa`
   - Password: (leave empty)
3. Click "Connect"
4. Run SQL: `SELECT * FROM USERS;`

## Troubleshooting

**If Maven installation fails:**
- Try Option 2 (IntelliJ IDEA) - it's actually easier!

**If port 8080 is busy:**
- Change port in `src/main/resources/application.properties`:
  ```
  server.port=8081
  ```

**If you get Java version errors:**
- The app needs Java 17+, you have Java 24, so you're good!

## Next Steps

After you get the registration working, we'll implement:
1. ✅ Registration (DONE)
2. 🚧 Login system
3. 🚧 Home page with company description
4. 🚧 Menu system (salads & juices)
5. 🚧 Customization feature
6. 🚧 Shopping cart
7. 🚧 Billing system
