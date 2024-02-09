FROM openjdk:21
LABEL maintainer="mihirMaintainer"
EXPOSE 8080
ADD target/grocery-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java","-jar","springboot-docker-demo.jar"]
