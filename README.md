# 🥗 Pure Healthy Eats - Full-Stack Web Application

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Render](https://img.shields.io/badge/Deploy-Render-purple.svg)](https://render.com)

A modern, responsive web application for healthy meal ordering and delivery, built with **Spring Boot** backend and integrated frontend.

## 🌟 Features

### ✅ Current Implementation
- **Full-Stack Architecture**: Spring Boot backend + integrated frontend
- **Database**: H2 in-memory database with JPA/Hibernate
- **Responsive Design**: Modern CSS with mobile-first approach
- **User Management**: Registration, login, and profile system
- **Menu System**: Browse and customize healthy meal options
- **Shopping Cart**: Add, remove, and modify cart items
- **Order Processing**: Complete checkout and order placement
- **Admin Dashboard**: Menu and order management

### 🎯 Tech Stack
- **Backend**: Spring Boot 3.2.0, Spring Data JPA, Thymeleaf
- **Frontend**: HTML5, CSS3 (Grid/Flexbox), Vanilla JavaScript
- **Database**: H2 (dev) / MySQL (production-ready)
- **Build**: Maven with wrapper
- **Deployment**: Docker-ready, Render-optimized

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+ (or use included wrapper)

### Run Locally
```bash
# Clone repository
git clone https://github.com/yourusername/pure-healthy-eats.git
cd pure-healthy-eats

# Run application
./mvnw spring-boot:run
# Windows: .\mvnw.cmd spring-boot:run

# Access at http://localhost:8080
```

### 🐳 Docker
```bash
docker build -t pure-healthy-eats .
docker run -p 8080:8080 pure-healthy-eats
```

## 🌐 Live Demo

**Ready for Deployment**: This project is configured for instant deployment on Render, Railway, or any cloud platform.

- Main Site: `http://localhost:8080/`
- Database Console: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (blank)

## 🏗️ Architecture

```
pure-healthy-eats/
├── src/main/
│   ├── java/com/purehealthyeats/app/
│   │   ├── controller/     # REST controllers
│   │   ├── model/         # JPA entities
│   │   ├── repository/    # Data access layer
│   │   ├── service/       # Business logic
│   │   └── PureHealthyEatsApplication.java
│   └── resources/
│       ├── static/        # Frontend assets (CSS, JS, images)
│       ├── templates/     # Thymeleaf templates
│       └── application.properties
├── Dockerfile            # Container configuration
├── system.properties     # Java version for Render
└── pom.xml              # Maven dependencies
```

## 📊 Database Schema

- **Users**: Authentication and profile data
- **MenuItems**: Food items with pricing and descriptions
- **Orders**: Order tracking and history
- **CartItems**: Shopping cart functionality
- **OrderItems**: Order-item relationship

## 🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page |
| GET | `/menu` | Menu listing |
| GET | `/cart` | Shopping cart |
| POST | `/api/cart/add` | Add item to cart |
| POST | `/api/order/place` | Place order |
| GET | `/h2-console` | Database console (dev) |

## 🚀 Deployment

### Render Deployment (Recommended)
1. Fork this repository
2. Connect to [Render](https://render.com)
3. Deploy with these settings:
   ```
   Build Command: ./mvnw clean package -DskipTests
   Start Command: java -jar target/pure-healthy-eats-0.0.1-SNAPSHOT.jar
   ```

### Environment Variables
```bash
JAVA_VERSION=17
MAVEN_VERSION=3.9.5
```

## 🎨 Features Showcase

- **Responsive Design**: Works on desktop, tablet, and mobile
- **Modern UI**: Clean, intuitive interface with smooth animations
- **Real-time Cart**: Dynamic cart updates without page refresh
- **Form Validation**: Client and server-side validation
- **Database Integration**: Persistent data with H2/MySQL

## 🔮 Roadmap

- [ ] Spring Security integration
- [ ] Payment gateway integration
- [ ] Real-time order tracking
- [ ] Email notifications
- [ ] Admin analytics dashboard
- [ ] Mobile app API
- [ ] Multi-language support

## 🤝 Contributing

1. Fork the project
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 📄 License

MIT License - see [LICENSE](LICENSE) file

## 👨‍💻 Author

**Ved Manoj Baikar**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

---

⭐ **Star this repo if you found it helpful!**
