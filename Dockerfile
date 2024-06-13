# Используем официальный образ OpenJDK 17
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл jar вашего приложения в контейнер
COPY target/TrainPass-0.0.1-SNAPSHOT.jar /app/TrainPass.jar

# Копируем внешний файл конфигурации
COPY src/main/resources/application-dev.properties /app/application-dev.properties

# ENTRYPOINT для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/TrainPass.jar", "--spring.config.location=file:/app/application-dev.properties"]