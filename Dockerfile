FROM alpine/java:21-jdk

COPY api-market-place.application-0.0.1-SNAPSHOT.jar api-market-place.jar

ENV AWS_REGION=us-east-1

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local,infra_local","/api-market-place.jar"]