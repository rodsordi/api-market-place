FROM alpine/java:21-jdk

COPY application/target/api-market-place.application-0.0.1-SNAPSHOT.jar api-market-place.jar

ENTRYPOINT ["java","-Dspring.profiles.active=local,infra_local","-jar","/api-market-place.jar"]