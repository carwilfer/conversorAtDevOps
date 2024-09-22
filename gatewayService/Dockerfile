# Usando a imagem base oficial do Java OpenJDK 17
FROM openjdk:17-jdk-alpine
LABEL authors="carlo"

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado para o container
COPY target/gatewayService-0.0.1-SNAPSHOT.jar gateway-service.jar

# Expõe a porta onde o serviço será executado
EXPOSE 8094

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]