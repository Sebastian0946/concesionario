FROM openjdk:11
EXPOSE 9000
ADD ./target/concesionario-0.0.1-SNAPSHOT.jar concesionario.jar
ENTRYPOINT ["java", "-jar", "/concesionario.jar"]