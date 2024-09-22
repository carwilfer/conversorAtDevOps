
# Título do Projeto

Conversor de Unidades Microserviços

Este repositório contém um projeto de microserviços desenvolvido em Java usando Spring Boot. O projeto é composto por três microserviços: "ConversorService", "GatewayService", e "DatabaseService". 
O objetivo do projeto é realizar conversões de unidades e registrar logs dessas conversões.

Estrutura do projeto

conversor_AT/
├── conversor/
│   ├── src/
│   ├── Dockerfile
├── gatewayService/
│   ├── src/
│   ├── Dockerfile
├── dataBase/
│   ├── src/
│   ├── Dockerfile
└── k8s
    ├── conversor-service.yaml
    ├── database-service.yaml
    ├── gateway-service.yaml

Microsserviço 1: ConversorService
GET /conversor/kmToMiles/{kilometers}`: Converte quilômetros para milhas.
GET /conversor/celsiusToFahrenheit/{celsius}`: Converte Celsius para Fahrenheit.

Microsserviço 2: GatewayService
GET /api/convertKmToMiles/{kilometers}: Chama o ConversorService para conversão de km para milhas.
GET /api/convertCelsiusToFahrenheit/{celsius}: Chama o ConversorService para conversão de Celsius para Fahrenheit.

Microsserviço 3: DatabaseService
POST /logs/salvar: Salva um log de conversão.

Os endpoints
 - Conversor: http://localhost:8093
 - Gateway: http://localhost:8094
 - Database: http://localhost:8095

Uteis:
 - Ferramentas necessárias: Java 17, Maven, Docker.
 - Banco de dados: H2 em memória.
 - Logs: Os logs das conversões são salvos no DatabaseService.


