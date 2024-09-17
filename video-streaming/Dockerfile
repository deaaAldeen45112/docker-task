FROM openjdk:20-jdk
EXPOSE 8004
COPY ./target/video-streaming-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]