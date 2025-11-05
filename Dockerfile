# Use JDK 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy Maven wrapper and settings
COPY CourseRegistrationSystem/mvnw .
COPY CourseRegistrationSystem/.mvn .mvn
RUN chmod +x mvnw

# Copy pom.xml and download dependencies
COPY CourseRegistrationSystem/pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY CourseRegistrationSystem/src src

# Build the application
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar /app/target/*.jar"]

