FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app
COPY build/libs/test-task-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]