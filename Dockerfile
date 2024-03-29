FROM openjdk:17

EXPOSE 8080

WORKDIR /app

COPY target/OnlineShop-0.0.1-SNAPSHOT.jar /app/your-app.jar

CMD ["java", "-jar", "your-app.jar"]
