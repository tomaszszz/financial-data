FROM openjdk:23-jdk-slim

WORKDIR /app
COPY target/financial-data-0.0.1-SNAPSHOT.jar financial-data.jar
COPY src/main/resources/financial_data.csv app/resources/financial_data.csv
ENTRYPOINT ["java", "-jar", "financial-data.jar"]