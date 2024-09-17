FROM openjdk:20-jdk
EXPOSE 8003
COPY ./target/file-service-0.0.1-SNAPSHOT.jar app.jar
COPY ./target/file-uploads /file-uploads
ENTRYPOINT ["java","-jar","/app.jar"]