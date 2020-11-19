# Stage 1 : build with maven builder image
FROM maven:3.6.0-jdk-11-slim AS BUILD
MAINTAINER Alexius Diakogiannis

COPY . /usr/app/

RUN mvn -f /usr/app/ clean package
# Stage 2 : copy from the previous container the jar file, put it in a java one and run it
FROM adoptopenjdk:11-jdk-openj9
WORKDIR /app

COPY --from=BUILD /usr/app/target/PaceCalculatorApp-runner.jar /app/

ENTRYPOINT ["java", "-jar", "/app/PaceCalculatorApp-runner.jar"]
