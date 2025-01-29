# Use an official Maven image to build the app
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src /app/src

# Run Maven to build the project
RUN mvn clean package

# Use an official OpenJDK image to run the app
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/sphere-0.0.1-SNAPSHOT.jar /app/sphere.jar

# Command to run the JAR file
CMD ["java", "-jar", "/app/sphere.jar"]
