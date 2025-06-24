# 1️⃣ Build Stage: Use Maven to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the project and skip tests for faster build
RUN mvn clean package -DskipTests

# 2️⃣ Run Stage: Use a lightweight JDK image to run the application
FROM eclipse-temurin:17-jdk

# Set working directory in the runtime container
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime container
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "app.jar"]
 
