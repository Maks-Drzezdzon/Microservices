FROM openjdk:8
EXPOSE 8083
ADD target/ratings-data-service-docker.jar ratings-data-service-docker.jar
ENTRYPOINT ["java","-jar","/ratings-data-service-docker.jar"]