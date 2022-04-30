FROM openjdk:11
MAINTAINER Thiago dos Anjos
COPY build/libs/cart-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]