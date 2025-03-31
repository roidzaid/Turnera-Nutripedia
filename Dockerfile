# Usa una imagen base oficial de OpenJDK 8
FROM openjdk:8-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/turnera-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la API se ejecuta
EXPOSE 8090

# Define el comando para ejecutar la API
ENTRYPOINT ["java", "-jar", "/app/app.jar"]