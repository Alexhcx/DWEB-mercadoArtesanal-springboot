# Mercado de produtos artesanais, API Rest com Spring Boot + postgresql

- API Rest Criada para o projeto da disciplina de desenvolvimento de software WEB.

- Verifique o arquivo "application.properties" para modificar o banco de dados e conseguir utilizar a API de modo satisfatorio. 

# Mercado Artesanal API

Este projeto é uma API REST para um mercado de produtos artesanais. Ele permite operações CRUD (Criar, Ler, Atualizar, Deletar) em produtos.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA/Hibernate
- MySQL

## Endpoints

A API possui os seguintes endpoints:

- `POST /produtosArtesanais`: Cria um novo produto artesanal.
- `GET /produtosArtesanais`: Lista todos os produtos artesanais.
- `GET /produtosArtesanais/{id}`: Busca um produto artesanal pelo ID.
- `PUT /produtosArtesanais/{id}`: Atualiza um produto artesanal pelo ID.
- `DELETE /produtosArtesanais/{id}`: Deleta um produto artesanal pelo ID.

## Como Rodar o Projeto

1. Clone o repositório para a sua máquina local usando `git clone`.
2. Navegue até o diretório do projeto.
3. Execute `mvn spring-boot:run` para iniciar a aplicação.
4. A aplicação estará disponível em `http://localhost:8080`.

## Contribuições

Contribuições são sempre bem-vindas. Sinta-se à vontade para abrir uma issue ou enviar um pull request.