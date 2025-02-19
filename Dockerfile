FROM openjdk:17-jdk-slim

COPY target/app-example.jar  /app/app-example.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "/app/app-example.jar"]

EXPOSE 4467