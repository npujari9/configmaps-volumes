FROM openjdk:17
EXPOSE 8080
ADD target/configmaps-volumes.jar configmaps-volumes.jar
ENTRYPOINT exec java -jar /configmaps-volumes.jar
