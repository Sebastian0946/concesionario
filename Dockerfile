FROM openjdk:17
VOLUME /tmp
EXPOSE 9000
ADD ./target/concesionario-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]