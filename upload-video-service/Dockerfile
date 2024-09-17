FROM openjdk:20-jdk
EXPOSE 8002
COPY ./target/upload-video-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


#if you want to build, you can use this
#FROM maven:3-amazoncorretto-20 AS builder
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline -B
#COPY src ./src
#RUN mvn clean package -DskipTests
#FROM amazoncorretto:20
#WORKDIR /app
#COPY --from=builder /app/target/*.jar app.jar
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]
