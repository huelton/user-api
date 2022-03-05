FROM adoptopenjdk/openjdk11:alpine

ADD target/spring-boot-mysql.jar spring-boot-mysql.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "spring-boot-mysql.jar"]