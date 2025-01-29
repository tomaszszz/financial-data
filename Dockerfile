FROM openjdk:23-jdk-slim

WORKDIR /app
COPY target/financial-data-0.0.1-SNAPSHOT.jar financial-data.jar
ENTRYPOINT ["java", "-jar", "financial-data.jar"]