
# Conversor

Conversor de Unidades Microserviços

Este repositório contém um projeto de microserviços desenvolvido em Java usando Spring Boot. 
O projeto é composto por três microserviços: "ConversorService", "GatewayService", e "DatabaseService". 
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

|── k8s
    ├── conversor-service.yaml
    ├── database-service.yaml
    ├── gateway-service.yaml

Microsserviço 1: ConversorService
GET /conversor/kmToMiles/{kilometers}`: Converte quilômetros para milhas.
GET /conversor/celsiusToFahrenheit/{celsius}`: Converte Celsius para Fahrenheit.

Microsserviço 2: GatewayService
GET /api/convertKmToMiles/{kilometers}: Chama o ConversorService para conversão de km para milhas.
GET /api/convertCelsiusToFahrenheit/{celsius}: Chama o ConversorService para conversão de Celsius para Fahrenheit.

Microsserviço 3: DatabaseService - Este micro registra os logs de conversões em um banco de dados.
POST /logs/salvar: Salva um log de conversão.


Os endpoints
 - Conversor: pode fazer diretamente por aqui, utilizando o verbo GET - URL: http://localhost:8093/conversor/kmToMiles/10 e http://localhost:8093/conversor/celsiusToFahrenheit/30
 - Gateway: pode fazer utilizando o verbo GET, no micro de conversão - URL: http://localhost:8094/api/convertKmToMiles/10 e http://localhost:8094/api/convertCelsiusToFahrenheit/30
 - Database: Se o Gateway estiver obtendo a resposta do conversor, o log de conversão está sendo salvo no Database. 
   Podemos enviar uma requisição POST, para testar a inserção de logs, através da URL: http://localhost:8095/logs/salvar
com o json na requisição:
{
"tipoConversao": "Km to Miles",
"valorEntrada": 10,
"valorSaida": 6.21371,
"dataHora": "2024-09-21T17:00:00"
}

Para realizar a execução desses micros usando Docker, precisará utilizar esses comandos dentro da pastas de cada micro correspondente.
docker build -t carwilfer/conversor-service:latest .
docker tag conversor-service:latest carwilfer/conversor-service:latest
docker push conversor-service/conversor-service:latest

OBS.: carwilfer é o nome do meu repositório Docker Hub, então deve ser trocado para não ir para mim a execução da imagem.
docker tag conversor-service:latest <seu-dockerhub>/conversor-service:latest

Para facilitar, seguem as imagens no Docker Hub
https://hub.docker.com/repository/docker/carwilfer/conversor-service

https://hub.docker.com/repository/docker/carwilfer/gateway-service

https://hub.docker.com/repository/docker/carwilfer/database-service


Para realizar a execução desses micros em um cluster Kubernets, precisa colocar os seguintes códigos:
Primeiro é necessário instalar o Minikube ou o kubernete, seguindo os passo que estão neste link - https://kubernetes.io/pt-br/

minikube version
minikube status
kubectl get pods
kubectl get nodes
kubectl cluster-info

kubectl apply -f conversor-service.yaml
kubectl apply -f gateway-service.yaml
kubectl apply -f database-service.yaml

Verifique se os pods estão rodando, pode utilizar o kubectl get pods

Caso queira acessar os serviços e usar no ambiente, precisa utilizar os port-forward

kubectl port-forward service/gateway-service 
Rodará nesta porta - 8094:8094
kubectl port-forward service/conversor-service 
Rodará nesta porta - 8093:8093
kubectl port-forward service/database-service 
Rodará nesta porta - 8095:8095

Uteis:
 - Ferramentas necessárias: Java 17, Maven, Docker.
 - Banco de dados: H2 em memória.
 - Logs: Os logs das conversões são salvos no DatabaseService.
