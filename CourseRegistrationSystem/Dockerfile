# ✅ Use stable Java 17 base image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Ensure the wrapper script is executable
RUN chmod +x mvnw

# Download dependencies (this step is cached, speeds up rebuilds)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of your source code
COPY src src

# Build the Spring Boot JAR
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot's default port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]






