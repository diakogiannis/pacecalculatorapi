# Stage 1 : build with maven builder image
FROM maven:3.6.0-jdk-11-slim AS BUILD
MAINTAINER Alexius Diakogiannis

COPY . /usr/app/

RUN mvn -f /usr/app/ clean package

FROM adoptopenjdk:11-jdk-openj9
WORKDIR /app

COPY --from=BUILD /usr/app/target/PaceCalculatorApp-runner.jar /app/

ENTRYPOINT ["java", "-jar", "/app/PaceCalculatorApp-runner.jar"]
