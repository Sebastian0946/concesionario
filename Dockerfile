FROM openjdk:11

ADD ./concesionario-0.0.1-SNAPSHOT.jar concesionario-0.0.1-SNAPSHOT.jar 

ENTRYPOINT [ "java", "-jar", "concesionario-0.0.1-SNAPSHOT.jar" ]