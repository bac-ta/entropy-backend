FROM java:8
COPY ./target/entropy-backend-0.0.1.jar /usr/src/app/entropy-backend.jar
WORKDIR /usr/src/app
LABEL maintainer=bac93.it@gmail.com
ENTRYPOINT ["java","-jar","entropy-backend.jar"]