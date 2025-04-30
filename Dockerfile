FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY src /app/src
RUN javac src/Main.java
CMD ["java", "src.Main"]
