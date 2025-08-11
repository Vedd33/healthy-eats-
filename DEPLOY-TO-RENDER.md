# 🚀 Deploy Pure Healthy Eats to Render

## Quick Deploy Guide

Your Spring Boot application is now ready for deployment! Follow these steps to get it live on Render.

### 📋 Prerequisites
- ✅ GitHub repository: https://github.com/Vedd33/healthy-eats-.git
- ✅ Spring Boot application configured
- ✅ Frontend integrated
- ✅ All files committed and pushed

### 🎯 Deploy Steps

#### 1. Go to Render
- Visit: https://render.com
- Sign up or log in with your GitHub account

#### 2. Create New Web Service
- Click **"New +"** button
- Select **"Web Service"**

#### 3. Connect Repository
- Choose **"Build and deploy from a Git repository"**
- Click **"Connect GitHub"** (if not already connected)
- Search for and select: **"healthy-eats-"**

#### 4. Configure Service
Fill in these settings:

**Basic Settings:**
```
Name: pure-healthy-eats
Region: Choose closest to you
Branch: main
```

**Build & Deploy:**
```
Root Directory: (leave blank)
Runtime: Java
Build Command: ./mvnw clean package -DskipTests
Start Command: java -jar target/pure-healthy-eats-0.0.1-SNAPSHOT.jar
```

**Environment:**
```
JAVA_VERSION: 17
```

#### 5. Deploy
- Click **"Create Web Service"**
- Wait for deployment (usually 3-5 minutes)
- Your app will be available at: `https://your-app-name.onrender.com`

### 🌐 Your Live URLs
After deployment, your application will be accessible at:

- **Main Website**: `https://pure-healthy-eats-xxxx.onrender.com/`
- **Menu**: `https://pure-healthy-eats-xxxx.onrender.com/menu`
- **Cart**: `https://pure-healthy-eats-xxxx.onrender.com/cart`
- **Database Console**: `https://pure-healthy-eats-xxxx.onrender.com/h2-console`

### 🔧 Troubleshooting

If deployment fails, check:
1. **Build logs** in Render dashboard
2. **Java version** (should be 17)
3. **Maven wrapper** permissions
4. **Port configuration** (using `${PORT:8080}`)

### 📱 Free Tier Notes
- Apps sleep after 15 minutes of inactivity
- Cold starts may take 30+ seconds
- 512MB RAM limit
- Perfect for development and demos

### 🔄 Auto-Deploy
Once connected, every push to your `main` branch will automatically trigger a new deployment!

---

## Alternative: One-Click Deploy

You can also add a "Deploy to Render" button to your README:

```markdown
[![Deploy to Render](https://render.com/images/deploy-to-render-button.svg)](https://render.com/deploy?repo=https://github.com/Vedd33/healthy-eats-.git)
```

Happy deploying! 🚀
