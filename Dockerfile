FROM openjdk:11
EXPOSE 8080
COPY ./target/*.jar /app/lovetrend.jar
ENTRYPOINT java -jar /app/lovetrend.jar
