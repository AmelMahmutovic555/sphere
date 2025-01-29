FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN apt-get update && apt-get install -y maven

RUN mvn clean package

CMD ["java", "-jar", "target/sphere-0.0.1-SNAPSHOT.jar"]
