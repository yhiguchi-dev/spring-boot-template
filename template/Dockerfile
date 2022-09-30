FROM amazoncorretto:19 as setup-builder

WORKDIR /app

COPY gradle/ ./gradle/
COPY *.gradle gradlew ./

RUN ./gradlew dependencies

FROM setup-builder as builder

COPY src/ ./src/

RUN ./gradlew clean build -x test -x check

FROM amazoncorretto:19 as runtime

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar ./

ENTRYPOINT ["java", "-jar", "app.jar"]
