📚 Library API
Este repositório contém uma aplicação backend desenvolvida com Spring Boot que simula uma API de biblioteca, com autenticação via OAuth2, segurança com Spring Security, persistência de dados com JPA, e deploy na AWS.

O projeto foi criado durante um curso com foco em consolidar conhecimentos modernos em desenvolvimento de APIs seguras e escaláveis com o ecossistema Spring.

🚀 Tecnologias Utilizadas
✅ Java 17+

✅ Spring Boot

✅ Spring Security

✅ OAuth2 / Login Social (Google, GitHub, etc.)

✅ Spring Data JPA

✅ Hibernate

✅ Banco de Dados (H2/MySQL/PostgreSQL)

✅ Amazon AWS (EC2, RDS, S3, etc.)

✅ Maven

🔐 Funcionalidades
Login com provedores OAuth2 (Google, GitHub, etc.)

Controle de acesso por roles (USER, ADMIN)

CRUD de entidades da biblioteca (livros, autores, etc.)

Persistência com JPA e banco relacional

Deploy em produção usando AWS

🗂️ Estrutura do Projeto
bash
Copiar
Editar
Library-api/
├── src/
│   ├── main/
│   │   ├── java/com/kurzgesagttt/libraryapi/
│   │   │   ├── config/         # Configurações de segurança e OAuth2
│   │   │   ├── controller/     # Endpoints REST
│   │   │   ├── entity/         # Entidades JPA
│   │   │   ├── repository/     # Repositórios
│   │   │   └── service/        # Regras de negócio
│   └── resources/
│       ├── application.properties
│       └── static/templates (se aplicável)
💻 Como Rodar Localmente
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/Kurzgesagttt/Library-api.git
cd Library-api
Configure o arquivo application.properties com:

Dados do banco de dados

Credenciais OAuth2 (Google, GitHub, etc.)

properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.security.oauth2.client.registration.google.client-id=...
spring.security.oauth2.client.registration.google.client-secret=...
Execute a aplicação:

bash
Copiar
Editar
./mvnw spring-boot:run
Acesse via navegador:

arduino
Copiar
Editar
http://localhost:8080
☁️ Deploy na AWS
A aplicação foi implantada na Amazon Web Services (AWS) utilizando:

EC2: Servidor da aplicação

RDS: Banco de dados em nuvem

S3 (opcional): Armazenamento de arquivos

Security Groups: Configurados para liberar as portas necessárias

📘 Aprendizados
Durante a construção deste projeto, adquiri conhecimentos importantes sobre:

Autenticação segura com OAuth2

Boas práticas de segurança com Spring Security

Persistência eficiente com Spring Data JPA

Estruturação de projetos RESTful

Configuração e deploy de aplicações na nuvem com AWS

📎 Link do Projeto
🔗 https://github.com/Kurzgesagttt/Library-api
