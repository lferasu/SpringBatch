FROM openjdk:8-jdk-alpine
COPY target/batch-project.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]