FROM openjdk:17-jdk-alpine
LABEL authors="Michael"
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
