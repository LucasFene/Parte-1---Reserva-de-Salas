FROM eclipse-temurin:17-jdk-alpine
MAINTAINER reserva-salas.com

WORKDIR /app

COPY target/reserva-service-0.0.1-SNAPSHOT.jar reserva-service.jar

ENTRYPOINT ["java", "-jar", "reserva-service.jar"]

EXPOSE 8081