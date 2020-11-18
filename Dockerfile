# Stage 1 : build with maven builder image
FROM maven:3.6.3-jdk-11-slim AS build
MAINTAINER Alexius Diakogiannis
COPY . /usr/app/
RUN mvn -f /usr/app/pom.xml clean package

FROM adoptopenjdk:11-jdk-openj9
COPY --from=build /usr/app/target/*-runner.jar /work/application

ENTRYPOINT ["java","-jar","/usr/local/lib/*runner.jar"]
