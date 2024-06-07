# Guia de Consumo da API RESTful do Sistema de Ingressos EasyPassInnovations

Este é um guia básico sobre como consumir a API RESTful do Sistema de Ingressos EasyPassInnovations. A API foi desenvolvida usando Spring Boot e oferece endpoints para gerenciar promotores, eventos, clientes e ingressos.

## Ferramentas Recomendadas

### Postman Collection
Para testar e explorar os endpoints da API de Sistema de Ingressos, recomendamos o uso do Postman. Você pode encontrar uma coleção pré-configurada com todas as solicitações necessárias no arquivo `EasyPassInnovations.postman_collection.json`.

### Extensões para Visual Studio Code

#### Spring Boot Extension Pack
Esta extensão reúne várias outras extensões úteis para o desenvolvimento de aplicativos Spring Boot no VS Code.

#### SQLTools e SQLTools PostgreSQL
Se você está trabalhando com um banco de dados PostgreSQL, recomendamos as seguintes extensões:

- **SQLTools**: Interface para executar consultas SQL diretamente no editor de código. Suporta várias bases de dados, incluindo PostgreSQL.
- **SQLTools PostgreSQL**: Extensão complementar para SQLTools, permitindo conectar-se a bancos de dados PostgreSQL.

## Endpoints Disponíveis

### Promotores

- **Listar todos os promotores**
  - Método: `GET`
  - Endpoint: `/api/promotores`

- **Buscar um promotor pelo ID**
  - Método: `GET`
  - Endpoint: `/api/promotores/{id}`
  - Parâmetros de Path: `{id}` (ID do promotor)

- **Adicionar um novo promotor**
  - Método: `POST`
  - Endpoint: `/api/promotores`
  - Corpo da solicitação: JSON contendo os detalhes do promotor

- **Atualizar um promotor existente**
  - Método: `PUT`
  - Endpoint: `/api/promotores/{id}`
  - Parâmetros de Path: `{id}` (ID do promotor a ser atualizado)
  - Corpo da solicitação: JSON contendo os novos detalhes do promotor

- **Deletar um promotor**
  - Método: `DELETE`
  - Endpoint: `/api/promotores/{id}`
  - Parâmetros de Path: `{id}` (ID do promotor a ser deletado)

### Eventos

- **Listar todos os eventos**
  - Método: `GET`
  - Endpoint: `/api/eventos`

- **Buscar um evento pelo ID**
  - Método: `GET`
  - Endpoint: `/api/eventos/{id}`
  - Parâmetros de Path: `{id}` (ID do evento)

- **Adicionar um novo evento**
  - Método: `POST`
  - Endpoint: `/api/eventos`
  - Corpo da solicitação: JSON contendo os detalhes do evento

- **Atualizar um evento existente**
  - Método: `PUT`
  - Endpoint: `/api/eventos/{id}`
  - Parâmetros de Path: `{id}` (ID do evento a ser atualizado)
  - Corpo da solicitação: JSON contendo os novos detalhes do evento

- **Deletar um evento**
  - Método: `DELETE`
  - Endpoint: `/api/eventos/{id}`
  - Parâmetros de Path: `{id}` (ID do evento a ser deletado)

### Clientes

- **Listar todos os clientes**
  - Método: `GET`
  - Endpoint: `/api/clientes`

- **Buscar um cliente pelo ID**
  - Método: `GET`
  - Endpoint: `/api/clientes/{id}`
  - Parâmetros de Path: `{id}` (ID do cliente)

- **Adicionar um novo cliente**
  - Método: `POST`
  - Endpoint: `/api/clientes`
  - Corpo da solicitação: JSON contendo os detalhes do cliente

- **Atualizar um cliente existente**
  - Método: `PUT`
  - Endpoint: `/api/clientes/{id}`
  - Parâmetros de Path: `{id}` (ID do cliente a ser atualizado)
  - Corpo da solicitação: JSON contendo os novos detalhes do cliente

- **Deletar um cliente**
  - Método: `DELETE`
  - Endpoint: `/api/clientes/{id}`
  - Parâmetros de Path: `{id}` (ID do cliente a ser deletado)

### Ingressos

- **Listar todos os ingressos**
  - Método: `GET`
  - Endpoint: `/api/ingressos`

- **Buscar um ingresso pelo ID**
  - Método: `GET`
  - Endpoint: `/api/ingressos/{id}`
  - Parâmetros de Path: `{id}` (ID do ingresso)

- **Adicionar um novo ingresso**
  - Método: `POST`
  - Endpoint: `/api/ingressos`
  - Corpo da solicitação: JSON contendo os detalhes do ingresso

- **Atualizar um ingresso existente**
  - Método: `PUT`
  - Endpoint: `/api/ingressos/{id}`
  - Parâmetros de Path: `{id}` (ID do ingresso a ser atualizado)
  - Corpo da solicitação: JSON contendo os novos detalhes do ingresso

- **Deletar um ingresso**
  - Método: `DELETE`
  - Endpoint: `/api/ingressos/{id}`
  - Parâmetros de Path: `{id}` (ID do ingresso a ser deletado)
