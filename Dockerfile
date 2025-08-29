FROM alpine/java:21-jdk

MAINTAINER rodsordi

COPY application/target/api-market-place.application-*.jar api-market-place.jar

ENTRYPOINT ["java","-jar","/api-market-place.jar"]