FROM openjdk:17-jdk-slim as build

COPY target/config-0.0.1-SNAPSHOT.jar config-0.0.1-SNAPSHOT.jar

RUN apt update && apt upgrade -y
RUN apt install -y wget

ENTRYPOINT ["java","-jar","/config-0.0.1-SNAPSHOT.jar"]