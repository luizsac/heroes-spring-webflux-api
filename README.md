### Passos para executar a aplicação:

* Executar o DynamoDB na pasta onde se encontra o arquivo DynamoDBLocal.jar através do comando:
  
  `java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb`;

* Executar a classe HeroesTable para criar a tabela no banco de dados;
* Executar a classe HeroesData para inserir dados na tabela HeroesTable;
* Executar a classe HeroApplication para subir a aplicação.

Link para a Swagger UI: http://localhost:8080/swagger-ui-reactive-api.html
