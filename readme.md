# API Marketplace

API Responsável por gerenciar produtos no marketplace.

## 🗒️ Informações

- Projeto referência para as aulas de testes de integração da Alura.

## 📋 Pré-requisitos

- [OpenJdk 21](https://download.java.net/java/GA/jdk21.0.2/f2283984656d49d69e91c558476027ac/13/GPL/openjdk-21.0.2_linux-x64_bin.tar.gz)
- [IntelliJ Comunity](https://www.jetbrains.com/idea/download/?section=linux)
- [Docker](https://www.docker.com/get-started/)

## 📦 Construindo

```mvn clean install -DskipTests```

## ▶️ Executando pacote

``` sh
docker compose up
```

``` sh
java -jar application/target/api-market-place.application-0.0.1-SNAPSHOT.jar
```

## 🎬 Executando imagem

``` sh
docker run -d -p 8080:8080 --name=api-market-place rodsordi/api-market-place:master
```

## 👌 Executando Testes

```mvn test```

## 🍿 Executando Testes de Integração

```mvn test -DintegrationTests```

## 📌 Versão

- [SemVer](https://semver.org/lang/pt-BR/)

## ✒ Autores

- [Rodrigo de Sordi](https://github.com/rodsordi)
