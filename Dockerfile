FROM ubuntu:latest  AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:21-jdk-slim

EXPOSE 8081

COPY --from=build /target/estoque-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]