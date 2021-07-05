FROM maven:3.6.0-jdk-11-slim AS build
COPY ../commons/src /home/app/src
COPY ../commons/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM java:8-jre
MAINTAINER Adsware System

ADD ./target/jpa-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/jpa-0.0.1-SNAPSHOT.jar"]

EXPOSE 9091
