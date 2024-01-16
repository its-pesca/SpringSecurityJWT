FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar config.jar
ENTRYPOINT ["java","-jar","/config.jar"]
