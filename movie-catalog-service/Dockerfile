FROM openjdk:8
EXPOSE 8081
ADD target/movie-catalog-service-docker.jar movie-catalog-service-docker.jar
ENTRYPOINT ["java","-jar","/movie-catalog-service-docker.jar"]