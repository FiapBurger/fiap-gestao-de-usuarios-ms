FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY build/libs/ms-gestao-usuarios-0.0.1-SNAPSHOT.jar .

EXPOSE 8989

CMD ["java", "-jar", "ms-gestao-usuarios-0.0.1-SNAPSHOT.jar"]