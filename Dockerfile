FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8090
ADD target/*.jar qbappapi.jar
ENTRYPOINT [ "sh", "-c", "java -jar /qbappapi.jar" ]