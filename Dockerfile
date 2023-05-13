FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1-alpine-slim

WORKDIR /app

COPY target/concesionario-0.0.1-SNAPSHOT.jar .

EXPOSE 9000
CMD ["java", "-jar", "concesionario-0.0.1-SNAPSHOT.jar", "--server.port=9000"]