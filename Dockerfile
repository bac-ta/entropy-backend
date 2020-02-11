FROM java:8
FROM maven:alpine

WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
LABEL maintainer=bac93.it@gmail.com
ADD ./target/entropy-backend.jar entropy-backend.jar
ENTRYPOINT ["java","-jar","entropy-backend.jar.jar"]