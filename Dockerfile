FROM openjdk:17-jdk-alpine
# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR dell'applicazione nella directory di lavoro
COPY target/*.jar campaign-service-0.0.1-SNAPSHOT.jar

# Espone la porta su cui l'app Spring Boot è in ascolto
EXPOSE 8089

# Comando per eseguire l'applicazione
ENTRYPOINT ["java", "-jar", "campaign-service-0.0.1-SNAPSHOT.jar"]