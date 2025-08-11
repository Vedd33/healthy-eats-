# Multi-stage build for Spring Boot application

# Stage 1: Build the application using Maven
FROM maven:3.9.5-openjdk-17-slim AS build

WORKDIR /app

# Install necessary packages for debugging
RUN apt-get update && apt-get install -y --no-install-recommends \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Copy pom.xml first for better Docker layer caching
COPY pom.xml .

# Verify Maven is working and show version
RUN mvn --version

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# List files to debug
RUN ls -la
RUN ls -la src/

# Build the application
RUN mvn clean package -DskipTests -B

# Verify the JAR file was created
RUN ls -la target/

# Stage 2: Create the runtime image
FROM openjdk:17-jre-slim

WORKDIR /app

# Create a non-root user for security
RUN addgroup --system spring && adduser --system --group spring

# Copy the built JAR from the build stage
COPY --from=build /app/target/pure-healthy-eats-0.0.1-SNAPSHOT.jar app.jar

# Change ownership of the app directory
RUN chown -R spring:spring /app

# Switch to non-root user
USER spring:spring

# Expose port (will be overridden by PORT env var)
EXPOSE 8080

# Run the application with proper JVM options for containers
CMD ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-Dserver.port=${PORT:-8080}", "-jar", "app.jar"]
