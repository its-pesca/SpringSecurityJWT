FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar discovery.jar
ENTRYPOINT ["java","-jar","/discovery.jar"]
