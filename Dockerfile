FROM amazoncorretto:17 as setup-builder

WORKDIR app

COPY gradle/ ./gradle/
COPY *.gradle gradlew ./

RUN ./gradlew dependencies --console verbose

FROM setup-builder as builder

COPY ./ ./

RUN ./gradlew build -x test -x check --console verbose

FROM amazoncorretto:17 as runtime

WORKDIR app

COPY --from=builder /app/build/libs/*.jar ./