FROM gradle:7.6.4-jdk11-focal AS build

WORKDIR /home/gradle/src

COPY . .

RUN gradle build --no-daemon


FROM openjdk:11.0.16-slim-buster 

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/batch-scheduler.jar

ENTRYPOINT ["java", "-jar", "/app/batch-scheduler.jar"]
