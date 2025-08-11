# Pure Healthy Eats - Restaurant Web Application

A modern Spring Boot web application for ordering healthy salads and fresh juices online.

## Features

- **User Registration & Authentication** - Sign up and log in to your account
- **Interactive Menu** - Browse salads and juices with filtering options
- **Customization** - Customize your salads and juices to your preference
- **Shopping Cart** - Add items to cart, update quantities, and manage orders
- **Order Processing** - Complete checkout with customer information
- **Bill Generation** - View order confirmation and receipt

## Tech Stack

- **Backend**: Spring Boot 3.2.0, Spring MVC, Spring Data JPA
- **Frontend**: Thymeleaf, HTML5, CSS3
- **Database**: H2 (development), MySQL ready for production
- **Build Tool**: Maven
- **Java Version**: 17+

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven (or use included wrapper)

### Running Locally

1. Clone the repository
```bash
git clone https://github.com/yourusername/pure-healthy-eats.git
cd pure-healthy-eats
```

2. Run the application
```bash
./mvnw spring-boot:run
```

3. Open your browser and visit: http://localhost:8080

### Building for Production

```bash
./mvnw clean package -DskipTests
java -jar target/pure-healthy-eats-0.0.1-SNAPSHOT.jar
```

## Deployment Options

### 1. Railway (Recommended)
1. Fork this repository to your GitHub
2. Visit [Railway.app](https://railway.app)
3. Connect your GitHub account
4. Deploy from repository
5. Railway will automatically detect the Spring Boot app

### 2. Render
1. Fork this repository to your GitHub
2. Visit [Render.com](https://render.com)
3. Create new "Web Service"
4. Connect your GitHub repository
5. Render will use the `render.yaml` configuration

### 3. Heroku
1. Install Heroku CLI
2. Login: `heroku login`
3. Create app: `heroku create your-app-name`
4. Deploy: `git push heroku main`

### 4. Docker
```bash
# Build image
docker build -t pure-healthy-eats .

# Run container
docker run -p 8080:8080 pure-healthy-eats
```

## API Endpoints

- `GET /` - Home page
- `GET /menu` - Menu page with filtering
- `GET /login` - Login page
- `POST /login` - Process login
- `GET /register` - Registration page
- `POST /register` - Process registration
- `GET /cart` - View cart
- `POST /cart/add` - Add item to cart
- `GET /checkout` - Checkout page
- `POST /checkout/process` - Process order
- `GET /bill/{orderId}` - Order receipt

## Database Schema

### Tables
- `users` - User accounts
- `menu_items` - Salads and juices
- `cart_items` - Shopping cart items
- `orders` - Customer orders
- `order_items` - Items in each order

## Configuration

### Development
- Database: H2 in-memory
- Port: 8080
- Profiles: default

### Production
- Database: H2 file-based (or MySQL)
- Port: Dynamic (from environment)
- Profiles: prod

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please contact [your-email@example.com]

# Pure Healthy Eats - Spring Boot Web Application

A Spring Boot web application for Pure Healthy Eats featuring user registration, login, menu browsing, and customization features.

## Features Implemented

### ✅ Registration System
- User registration with validation
- Password encryption using BCrypt
- Duplicate email prevention
- Error handling and user feedback

### 🚧 Coming Next
- Login system with Spring Security
- Home page with company description
- Menu system (salads and juices with photos)
- Customization feature for creating custom salads/juices
- Shopping cart functionality
- Billing system

## Prerequisites

1. **Java 17** or higher
2. **Maven 3.6+**
3. **MySQL 8.0+**
4. **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

## Setup Instructions

### 1. Database Setup
1. Install MySQL and start the service
2. Create database:
   ```sql
   CREATE DATABASE pure_healthy_eats;
   ```
3. Update database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### 2. Run the Application
1. Clone/download the project
2. Navigate to project directory:
   ```bash
   cd pure-healthy-eats
   ```
3. Run with Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Access the application at: `http://localhost:8080`

### 3. Test Registration
1. Go to `http://localhost:8080/register`
2. Fill in the registration form
3. Submit and verify the user is saved to database

## Project Structure

```
pure-healthy-eats/
├── src/
│   ├── main/
│   │   ├── java/com/purehealthyeats/app/
│   │   │   ├── PureHealthyEatsApplication.java
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   └── RegistrationController.java
│   │   │   ├── model/
│   │   │   │   └── User.java
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java
│   │   │   └── service/
│   │   │       └── UserService.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── css/
│   │       │       └── style.css
│   │       ├── templates/
│   │       │   └── register.html
│   │       └── application.properties
├── database-setup.sql
├── pom.xml
└── README.md
```

## Technologies Used

- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **Spring Security**
- **Thymeleaf** (Template Engine)
- **MySQL** (Database)
- **Maven** (Build Tool)
- **BCrypt** (Password Encryption)

## Next Steps

The registration system is now complete and ready for testing. The next phase will include implementing the login system with Spring Security authentication.

## Support

If you encounter any issues:
1. Verify MySQL is running
2. Check that the database `pure_healthy_eats` exists
3. Ensure Java 17+ is installed
4. Verify Maven dependencies are downloaded
