# API de Cliente

Foi construído uma API RestFul com os itens básicos para a operação de um cliente.

## O Projeto

Para que consiga executar o software se faz necessários a configuração e instalação dos seguintes itens.

### Pré-requisitos

- Java 11
- Maven
- Postgres
- Postman
- Docker (Opcional)

### Executando a aplicação

#### Maven
Deverá ser alterado os valores de conexão ao banco de dados no arquivo application.yml, apos a altereração
executar o comando:

    mvn spring-boot:run

#### Docker
Deverá ser executados os comandos seguindo a ordem :

    docker build -t client-0.0.1.jar .
Após a conclusão executar:

    docker-compose up -d

## Acesso API:
Para verificar a documentação basta acessar o Swagger após iniciar o projeto no endereço:

 - Local : [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
 - Remoto: [https://app-client-builders.herokuapp.com/swagger-ui.html](https://app-client-builders.herokuapp.com/swagger-ui.html) 

Caso queira podera ser importado o arquivo `Cliente.postman_collection.json` no aplicativo Postman 


## Autor

- Leonardo Augusto O Silva – Desenvolvedor