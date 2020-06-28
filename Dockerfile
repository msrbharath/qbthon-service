FROM openjdk:8-jdk-alpine
ADD target/qbthon-service-0.0.1-SNAPSHOT.jar qbapp.jar
ENTRYPOINT ["java","-jar","/qbapp.jar"]
EXPOSE 8090
