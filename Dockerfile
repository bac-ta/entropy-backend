FROM maven:3.8.1-jdk-8-slim
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package


FROM java:8
COPY ./target/entropy-backend-0.0.1.jar /usr/src/app/entropy-backend.jar
WORKDIR /usr/src/app
LABEL maintainer=bac93.it@gmail.com
EXPOSE 1109
ENTRYPOINT ["java","-jar","entropy-backend.jar"]