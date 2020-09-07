FROM openjdk:11-jdk
VOLUME /tmp
COPY target/*.jar springboot-dynamodb.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "springboot-dynamodb.jar"]