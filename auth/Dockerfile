FROM openjdk:20-jdk
EXPOSE 8001
COPY ./target/auth-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]