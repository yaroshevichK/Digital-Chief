FROM maven:3.8.5-openjdk-17-slim as build
COPY . .
RUN mvn clean package

FROM openjdk:21-slim

ARG APP_JAR=target/*.jar
COPY ${APP_JAR} app.jar

ENV POSTGRES_PASSWORD=pasword
ENV POSTGRES_DB=digital_chief_db

ADD ./src/main/resources/docker/init.sql /docker-entrypoint-initdb.d/init.sql

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080
