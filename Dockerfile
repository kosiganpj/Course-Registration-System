# Use JDK 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy only the Spring Boot project files from the subfolder
COPY CourseRegistrationSystem/mvnw .
COPY CourseRegistrationSystem/.mvn .mvn
RUN chmod +x mvnw

COPY CourseRegistrationSystem/pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copy the actual source code
COPY CourseRegistrationSystem/src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "target/*.jar"]


