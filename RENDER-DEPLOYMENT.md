# Render Deployment Guide for Pure Healthy Eats

## Overview
This guide will help you deploy your Spring Boot application with integrated frontend to Render.

## Prerequisites
- Render account (free tier available)
- Your project files (already prepared)

## Deployment Options

### Option 1: Deploy via GitHub (Recommended)

1. **Create GitHub Repository**
   - Go to https://github.com and create a new repository
   - Name it `pure-healthy-eats`
   - Don't initialize with README (we have files already)

2. **Upload Your Code** (since Git is not installed locally)
   - Download GitHub CLI or use GitHub web interface
   - Zip your project folder and upload via GitHub web interface:
     - Go to your new repository
     - Click "uploading an existing file"
     - Drag your entire project folder

3. **Deploy on Render**
   - Go to https://render.com and sign up/login
   - Click "New +" → "Web Service"
   - Connect your GitHub account
   - Select your `pure-healthy-eats` repository
   - Configure the service:

   **Build Settings:**
   ```
   Build Command: ./mvnw clean package -DskipTests
   Start Command: java -jar target/pure-healthy-eats-0.0.1-SNAPSHOT.jar
   ```

   **Environment:**
   ```
   JAVA_VERSION: 17
   ```

### Option 2: Deploy via Docker (Alternative)

If you prefer Docker deployment:

1. **Render Settings:**
   - Build Command: `docker build -t pure-healthy-eats .`
   - Start Command: `docker run -p 8080:8080 pure-healthy-eats`

### Option 3: Direct File Upload

1. **Zip your project:**
   - Create a zip file of your entire `pure-healthy-eats` folder
   
2. **Use Render's direct upload:**
   - Some hosting platforms support direct zip uploads
   - Check Render's documentation for current options

## Project Structure (Already Configured)
```
pure-healthy-eats/
├── src/
│   ├── main/
│   │   ├── java/com/purehealthyeats/app/
│   │   └── resources/
│   │       ├── static/          # Your frontend files (HTML, CSS, JS)
│   │       │   ├── index.html
│   │       │   ├── style.css
│   │       │   └── script.js
│   │       └── application.properties
├── Dockerfile                   # For Docker deployment
├── system.properties           # Java version specification
├── pom.xml                     # Maven configuration
└── .gitignore                  # Git ignore rules
```

## Configuration Details

### application.properties
- Configured for Render with `server.port=${PORT:8080}`
- Uses H2 in-memory database (no external DB needed)
- Ready for production deployment

### Frontend Integration
- Static files are served at the root URL
- Your HTML/CSS/JS files are accessible at:
  - `https://your-app.onrender.com/` (index.html)
  - `https://your-app.onrender.com/style.css`
  - `https://your-app.onrender.com/script.js`

## Expected URLs After Deployment
- **Main Website:** `https://your-app-name.onrender.com/`
- **H2 Database Console:** `https://your-app-name.onrender.com/h2-console`
- **API Endpoints:** `https://your-app-name.onrender.com/api/*` (if you add REST APIs)

## Free Tier Limitations
- Apps sleep after 15 minutes of inactivity
- Cold starts may take 30+ seconds
- 512MB RAM limit
- 400 build minutes/month

## Next Steps After Deployment
1. Test your deployed application
2. Add custom domain (optional, paid feature)
3. Set up CI/CD for automatic deployments
4. Add a production database (PostgreSQL on Render)

## Troubleshooting
- Check Render build logs if deployment fails
- Ensure Java 17 is specified in system.properties
- Verify Maven wrapper permissions in Dockerfile

## Cost
- Free tier available
- Paid tiers start at $7/month for always-on services
