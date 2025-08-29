FROM openjdk:21-jdk-alpine

MAINTAINER rodsordi

COPY application/target/api-market-place.application-*.jar api-market-place.jar

ENTRYPOINT ["java","-jar","/api-market-place.jar"]