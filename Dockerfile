FROM alpine/java:21-jdk

COPY application/target/api-market-place.application-*.jar api-market-place.jar

ENV AWS_REGION=us-east-1

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local,infra_local","/api-market-place.jar"]