# ✅ Use stable Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything into the container
COPY . .

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests || (apt-get update && apt-get install -y maven && mvn -f pom.xml clean package -DskipTests)

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]




