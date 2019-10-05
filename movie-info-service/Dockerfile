FROM openjdk:8
EXPOSE 8082
ADD target/movie-info-service-docker.jar movie-info-service-docker.jar
ENTRYPOINT ["java","-jar","/movie-info-service-docker.jar"]