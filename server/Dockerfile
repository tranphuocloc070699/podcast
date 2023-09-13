FROM openjdk:17-jdk-slim as build

COPY target/server-0.0.1-SNAPSHOT.jar server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/server-0.0.1-SNAPSHOT.jar"]