# Use JDK 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and config files
COPY CourseRegistrationSystem/mvnw .
COPY CourseRegistrationSystem/.mvn .mvn
RUN chmod +x mvnw

# Copy pom.xml and download dependencies
COPY CourseRegistrationSystem/pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY CourseRegistrationSystem/src src

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot default port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "target/*.jar"]
