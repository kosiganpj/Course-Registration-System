# ✅ Use a more reliable Java 17 base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build your Spring Boot app (try mvnw, fallback to system Maven)
RUN ./mvnw clean package -DskipTests || (apt-get update && apt-get install -y maven && mvn clean package -DskipTests)

# Expose Spring Boot default port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]


