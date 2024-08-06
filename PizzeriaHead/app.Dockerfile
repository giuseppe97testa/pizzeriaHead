FROM openjdk:19-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ./target/PizzeriaHead-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]