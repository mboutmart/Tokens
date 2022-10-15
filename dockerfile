FROM openjdk:8-jdk-alpine
EXPOSE 8080/tcp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} MyAppToken.jar
ENTRYPOINT ["java","-jar","/MyAppToken.jar"]
