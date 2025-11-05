# Use stable Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy only the project files (update path if your pom.xml is inside a folder)
COPY . .

# Move into correct folder if pom.xml is nested
WORKDIR /app

# Verify pom.xml is found, then build
RUN ls -l && ./mvnw clean package -DskipTests || (apt-get update && apt-get install -y maven && mvn -f pom.xml clean package -DskipTests)

# Expose Spring Boot default port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]



