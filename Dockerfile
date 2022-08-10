FROM amazoncorretto:17 as setup-builder

WORKDIR app

COPY gradle/ ./gradle/
COPY *.gradle gradlew ./

RUN ./gradlew dependencies --configuration compileClasspath

FROM setup-builder as builder

COPY ./ ./

RUN ./gradlew build -x test -x check

FROM amazoncorretto:17 as runtime

WORKDIR app

COPY --from=builder /app/build/libs/*.jar ./