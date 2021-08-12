# 🚀 Fórum Alura Study 📚

Este projeto trata-se de uma POC usando Kotlin e Spring Boot usando algumas tecnologias como Flyway e Redis para fins de estudo.

[![GitHub stars](https://img.shields.io/github/stars/matheuscarv69/forum-alura-study?color=7159)](https://github.com/matheuscarv69/orange-talents-05-template-proposta/stargazers)
![Maven Central with version prefix filter](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven/3.6.3?color=7159)

## 🤔 O que é o Fórum Alura Study?

Esse é um projeto que foi inicialmente desenvolvido no curso "API REST com Kotlin e Spring Boot: Camada de persistência", porém por motivos de aprendizagem foram feitas algumas alterações na arquitetura utilizada e na utilização de novas tecnologias.

## 🛠 Pré-Requisitos

### 📍 Local

Antes de começar a mexer no código você precisa ter instalado em sua máquina as seguintes ferramentas:

- [Java JDK 11+](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.6.3](https://maven.apache.org/download.cgi)

### 🐳 Docker

Este projeto conta com um **docker-compose**, inclusive a própria imagem da aplicação já está configurada para ser
executada no docker. 

Os requisitos para isso são:

- [Docker](https://www.docker.com/products/docker-desktop) - Baixe de acordo com o seu SO
- [Docker-compose](https://docs.docker.com/compose/install/)

A imagem da aplicação também está disponível no Docker Hub:

- [matheuscarv69/forum-alura-study](https://hub.docker.com/r/matheuscarv69/forum-alura-study)

Caso queria executa-lá através dessa imagem, abaixo tem alguns comandos que podem ajudar:

## ⬇ 1. Pull

```shell
docker pull matheuscarv69/forum-alura-study
```
## 🏃‍♂️ 2. Running

```shell
docker run -d -p 8080:8080 -e POSTGRES_HOST="172.30.32.1:5432" -e DB_USER="postgres" -e D
B_PASSWORD="password" -e DB_SCHEMA="forum" -e CACHE_HOST="172.30.32.1" -e CACHE_PORT="6379" -e CACHE_EXPIRATION="10000" matheuscarv69/forum-alura-study
```

## 🎲 Executando a API com o docker-compose
Com esse repositório já clonado em sua máquina e com todos os pré-requisitos atendidos.

1. Você deve ir até a raiz do projeto onde o arquivo **docker-compose.yml** está.
2. Deve abrir um terminal na raiz do projeto.
3. Agora certifique-se que o seu Docker já está em execução.
4. Execute o seguinte comando no terminal:

```bash
docker-compose up -d
```

5. Com isso sua aplicação já está em execução por padrão na porta local 8080

## 📝Fazendo requisições - Insomnia

Esse serviço têm alguns endpoints que estão configurados no aplicativo **Insomnia**, clicando no botão abaixo você pode
baixar o workspace de requests utilizados nesse projeto.
<br/>
<br/>
[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=api-forum-study-requests&uri=https%3A%2F%2Fgist.githubusercontent.com%2Fmatheuscarv69%2F479dccc19228395368af8603b953a8f5%2Fraw%2F7e5602dd87940b210ab01a9d32b43bb899e64867%2Fforum-alura-study-requests)

## 🚀 Tecnologias 👩‍🚀

As seguintes tecnologias foram utilizadas no desenvolvimento do projeto.

- Kotlin 1.5.21
- Spring Boot 2.5.3
    - Web
    - Data JPA
    - Cache
    - Data Redis
    - Validation
    - Profiles (dev e prod)
- Flyway
- Postgres
- H2 Database

## ⚡ Flyway 👾
O [Flyway](https://flywaydb.org/) é uma ferramenta utilizada para versionamento de banco de dados, ele se propõe a trazer ordem e organização para os scripts SQL que são executados no banco de dados.

Entre as muitas possibilidades essa ferramenta oferece pode-se destacar:

- Sincronizar o banco de dados com a versão da aplicação;
- Saber quais scripts foram executados ou não;
- Automatizar a execução dos scripts;
- Criar banco de dados do zero
- Permite criar um rollback de mudanças

## 🎲 Redis 👾
O [Redis](https://redis.io/) é um armazenamento de estrutura de dados de chave-valor de código aberto e na memória. Ele pode ser usado como banco de dados, cache e agente de mensagens.

O Redis fornece estruturas de dados como strings, hashes, listas, conjuntos, conjuntos classificados com consultas de intervalo, bitmaps, hiperloglogs, índices geoespaciais e fluxos.

## 👨🏻‍💻 Autor

<br>
<a href="https://github.com/matheuscarv69">
 <img style="border-radius: 35%;" src="https://avatars1.githubusercontent.com/u/55814214?s=460&u=ffb1e928527a55f53df6e0d323c2fd7ba92fe0c3&v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Matheus Carvalho</b></sub></a> <a href="https://github.com/matheuscarv69" title="Matheus Carvalho">🚀</a>

Feito por Matheus Carvalho, entre em contato!✌🏻
 <p align="left">
    <a href="mailto:matheus9126@gmail.com" alt="Gmail" target="_blank">
      <img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white&link=mailto:matheus9126@gmail.com"/></a>
    <a href="https://www.linkedin.com/in/matheus-carvalho69/" alt="Linkedin" target="_blank">
        <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&link=https://www.linkedin.com/in/matheus-carvalho69/"/></a>  
    <a href="https://www.instagram.com/_mmcarvalho/" alt="Instagram" target="_blank">
      <img src="https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white&link=https://www.instagram.com/_mmcarvalho/"/></a>  
  </p>

