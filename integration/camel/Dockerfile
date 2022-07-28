FROM openjdk:11

#RUN mvn clean package

WORKDIR /code

ADD target/camel-0.0.1-SNAPSHOT.jar camel.jar
ENTRYPOINT ["java", "-jar","camel.jar"]

EXPOSE 8080