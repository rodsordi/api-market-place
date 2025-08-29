FROM alpine/java:21-jdk

ENV PROFILES=local,infra_local

COPY application/target/api-market-place.application-*.jar api-market-place.jar

ENTRYPOINT ["java","-jar -Dspring.profiles.active=$PROFILES","/api-market-place.jar"]