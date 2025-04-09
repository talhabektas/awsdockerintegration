FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/awsdocker-0.0.1-SNAPSHOT.jar app.jar

# Spring profili varsayılan olarak docker
ENV SPRING_PROFILES_ACTIVE=docker

EXPOSE 8080

# Healthcheck ekleyelim
HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:8080/ || exit 1

# Uygulamayı çalıştır
CMD ["java", "-jar", "app.jar"]