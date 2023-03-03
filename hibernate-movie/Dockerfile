FROM openjdk:19-alpine
VOLUME tmp
ADD target/hibernate-movie-0.0.1-SNAPSHOT.jar hibernate-movie-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hibernate-movie-0.0.1-SNAPSHOT.jar"]
