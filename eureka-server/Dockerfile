FROM openjdk:17-jdk-slim as build

COPY target/eureka-0.0.1-SNAPSHOT.jar eureka-0.0.1-SNAPSHOT.jar

RUN apt update && apt upgrade -y
RUN apt install -y wget

ENTRYPOINT ["java","-jar","/eureka-0.0.1-SNAPSHOT.jar"]