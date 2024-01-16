FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]
