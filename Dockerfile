FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY build/libs/gestaoDeUsuarios-0.0.1-SNAPSHOT.jar .

EXPOSE 8989

CMD ["java", "-jar", "gestaoDeUsuarios-0.0.1-SNAPSHOT.jar"]