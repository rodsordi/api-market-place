FROM alpine/java:21-jdk

ENV PROFILES=

COPY application/target/api-market-place.application-*.jar api-market-place.jar

ENTRYPOINT ["java","-Dspring.profiles.active=local,infra_local","-jar","/api-market-place.jar"]