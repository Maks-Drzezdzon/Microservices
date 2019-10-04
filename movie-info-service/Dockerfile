FROM openjdk:8
EXPOSE 8080
ADD target/eureka-server-docker.jar eureka-server-docker.jar
ENTRYPOINT ["java","-jar","/eureka-server-docker.jar"]