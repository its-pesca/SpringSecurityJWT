FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar produit.jar
ENTRYPOINT ["java","-jar","/produit.jar"]
