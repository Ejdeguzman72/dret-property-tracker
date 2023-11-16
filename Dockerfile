FROM amazoncorretto:17
WORKDIR /app
COPY /target/property-tracker-0.0.1-SNAPSHOT.jar /app/property-tracker-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "property-tracker-0.0.1-SNAPSHOT.jar", "--server.port=8080"]