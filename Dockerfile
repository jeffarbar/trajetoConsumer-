FROM openjdk:8-jdk-alpine
RUN mkdir /app
COPY target/*.jar /app/trajetoConsumer.jar
WORKDIR /app
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "trajetoConsumer.jar"]