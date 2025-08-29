FROM alpine/java:21-jdk

COPY application/target/api-market-place.application-*.jar api-market-place.jar

ENTRYPOINT ["java","-jar","/api-market-place.jar"]