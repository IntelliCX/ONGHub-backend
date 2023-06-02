# Stage 1: Build stage
FROM maven:3.8.1-openjdk-17-slim AS builder

WORKDIR /usr/app

# Copy the Maven build files to the container
COPY pom.xml .
COPY src ./src

# Build the application with Maven
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /usr/app

# Copy the JAR file from the build stage
COPY --from=builder /usr/app/target/onghub-0.0.1-SNAPSHOT.jar onghub-0.0.1-SNAPSHOT.jar

# Expose the port on which your API will run
EXPOSE 8080

# Specify the command to run your API when the container starts
CMD ["java", "-jar", "onghub-0.0.1-SNAPSHOT.jar"]
