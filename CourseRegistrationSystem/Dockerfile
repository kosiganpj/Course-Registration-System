# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Preload dependencies
RUN ./mvnw dependency:go-offline -B || apt-get update && apt-get install -y maven && mvn dependency:go-offline -B

# Copy source
COPY src ./src

# Build JAR
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]
