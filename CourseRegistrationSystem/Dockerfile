# Use stable Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build the project (try Maven Wrapper first, then system Maven)
RUN ./mvnw clean package -DskipTests || (apt-get update && apt-get install -y maven && mvn clean package -DskipTests)

# Expose the default Spring Boot port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]

