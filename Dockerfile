FROM eclipse-temurin:17

WORKDIR /app

COPY target/HackerNewsApplication-0.0.1-SNAPSHOT.jar /app/HackerNewsApplication.jar

ENTRYPOINT ["java","-jar","HackerNewsApplication.jar"]