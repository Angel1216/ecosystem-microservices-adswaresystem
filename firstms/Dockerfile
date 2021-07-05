FROM java:8-jre
MAINTAINER Adsware System

ADD ./target/firstms.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/firstms.jar"]

EXPOSE 9090
