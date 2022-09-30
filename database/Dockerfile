FROM flyway/flyway:9.3.1-alpine as runtime

RUN apk add --no-cache expat=2.4.9-r0

FROM runtime

COPY ./migration /flyway/sql