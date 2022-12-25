FROM openjdk:8-jdk-alpine
EXPOSE 8082
ARG JAR_FILE=target/user-service.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]