FROM openjdk:17-oraclelinux8 as build
WORKDIR /opt/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17-oraclelinux8
VOLUME /tmp
ARG DEPEDENCY=/opt/app/target/dependency
COPY --from=build #{DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build #{DEPENDENCY}/META-INF /app/META-INF
COPY --from=build #{DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java",".cp","app:app/lib/*","com/helpdesk/helpdesk/HelpdeskApplication"]

EXPOSE 8080