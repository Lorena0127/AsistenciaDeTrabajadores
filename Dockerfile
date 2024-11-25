# Usa una imagen base con Java preinstalado
FROM openjdk:latest

WORKDIR /app


COPY ./asistencia/target/asistencia-1.0-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
