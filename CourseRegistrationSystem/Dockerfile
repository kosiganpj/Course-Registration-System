# ✅ Use stable Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Make mvnw executable (important on Linux containers)
RUN chmod +x mvnw

# Install Maven if wrapper fails
RUN ./mvnw dependency:resolve || (apt-get update && apt-get install -y maven && mvn -f pom.xml dependency:resolve)

# Build the Spring Boot JAR file
RUN ./mvnw clean package -DskipTests || mvn -f pom.xml clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/CourseRegistrationSystem-0.0.1-SNAPSHOT.jar"]





