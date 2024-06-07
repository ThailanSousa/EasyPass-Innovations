Este é um guia básico sobre como consumir a API RESTful do Sistema de Ingressos EasyPassInnovations. A API foi desenvolvida usando Spring Boot e oferece endpoints para gerenciar promotores, eventos e clientes.

Ferramentas Recomendadas
Postman Collection
Para testar e explorar os endpoints da API de Sistema de Ingressos, recomendamos o uso do Postman. Você pode encontrar uma coleção pré-configurada com todas as solicitações necessárias no arquivo EasyPassInnovations.postman_collection.json.

Endpoints Disponíveis:

Promotores
•	Listar todos os promotores
o	Método: GET
o	Endpoint: /api/promotores

•	Buscar um promotor pelo ID
o	Método: GET
o	Endpoint: /api/promotores/{id}
o	Parâmetros de Path: {id} (ID do promotor)

•	Adicionar um novo promotor
o	Método: POST
o	Endpoint: /api/promotores
o	Corpo da solicitação: JSON contendo os detalhes do promotor

•	Atualizar um promotor existente
o	Método: PUT
o	Endpoint: /api/promotores/{id}
o	Parâmetros de Path: {id} (ID do promotor a ser atualizado)
o	Corpo da solicitação: JSON contendo os novos detalhes do promotor

•	Deletar um promotor
o	Método: DELETE
o	Endpoint: /api/promotores/{id}
o	Parâmetros de Path: {id} (ID do promotor a ser deletado)

Eventos
•	Listar todos os eventos
o	Método: GET
o	Endpoint: /api/eventos

•	Buscar um evento pelo ID
o	Método: GET
o	Endpoint: /api/eventos/{id}
o	Parâmetros de Path: {id} (ID do evento)

•	Adicionar um novo evento
o	Método: POST
o	Endpoint: /api/eventos
o	Corpo da solicitação: JSON contendo os detalhes do evento

•	Atualizar um evento existente
o	Método: PUT
o	Endpoint: /api/eventos/{id}
o	Parâmetros de Path: {id} (ID do evento a ser atualizado)
o	Corpo da solicitação: JSON contendo os novos detalhes do evento

•	Deletar um evento
o	Método: DELETE
o	Endpoint: /api/eventos/{id}
o	Parâmetros de Path: {id} (ID do evento a ser deletado)

Clientes
•	Listar todos os clientes
o	Método: GET
o	Endpoint: /api/clientes

•	Buscar um cliente pelo ID
o	Método: GET
o	Endpoint: /api/clientes/{id}
o	Parâmetros de Path: {id} (ID do cliente)

•	Adicionar um novo cliente
o	Método: POST
o	Endpoint: /api/clientes
o	Corpo da solicitação: JSON contendo os detalhes do cliente

•	Atualizar um cliente existente
o	Método: PUT
o	Endpoint: /api/clientes/{id}
o	Parâmetros de Path: {id} (ID do cliente a ser atualizado)
o	Corpo da solicitação: JSON contendo os novos detalhes do cliente

•	Deletar um cliente
o	Método: DELETE
o	Endpoint: /api/clientes/{id}
o	Parâmetros de Path: {id} (ID do cliente a ser deletado)

Ingressos
• Listar todos os ingressos
•	Método: GET
•	Endpoint: /api/ingressos

• Buscar um ingresso pelo ID
•	Método: GET
•	Endpoint: /api/ingressos/{id}
•	Parâmetros de Path: {id} (ID do ingresso)

• Adicionar um novo ingresso
•	Método: POST
•	Endpoint: /api/ingressos
•	Corpo da solicitação: JSON contendo os detalhes do ingresso

• Atualizar um ingresso existente
•	Método: PUT
•	Endpoint: /api/ingressos/{id}
•	Parâmetros de Path: {id} (ID do ingresso a ser atualizado)
•	Corpo da solicitação: JSON contendo os novos detalhes do ingresso

• Deletar um ingresso
•	Método: DELETE
•	Endpoint: /api/ingressos/{id}
•	Parâmetros de Path: {id} (ID do ingresso a ser deletado)

Ferramentas Recomendadas
SQLTools e SQLTools PostgreSQL
Se você está trabalhando com um banco de dados PostgreSQL e precisa interagir diretamente com ele, recomendamos a utilização das extensões SQLTools e SQLToolsPostgres.
•	SQLTools: Esta é uma extensão do Visual Studio Code que fornece uma interface para executar consultas SQL diretamente no editor de código. Ela suporta várias bases de dados, incluindo PostgreSQL.
•	SQLToolsPostgres: Esta é uma extensão complementar para o SQLTools que permite conectar-se a bancos de dados PostgreSQL.
Com essas extensões instaladas, você pode facilmente visualizar e manipular os dados do seu banco de dados PostgreSQL diretamente do Visual Studio Code.

