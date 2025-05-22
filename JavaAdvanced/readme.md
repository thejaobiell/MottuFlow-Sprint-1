# 🚀 MottuFlow – API REST em Java

Este repositório contém a implementação da API REST **MottuFlow**, desenvolvida como parte da disciplina de **Java Advanced**, no curso de **Análise e Desenvolvimento de Sistemas**.

A API tem como objetivo oferecer funcionalidades completas de **CRUD** para o gerenciamento de:

* Funcionários
* Pátios
* Motos
* Câmeras
* ArUco Tags
* Status das motos
* Localidades

No contexto da disciplina de **IoT**, está sendo desenvolvida uma solução de **visão computacional** que utilizará câmeras para identificar motocicletas por meio de **ArUco Tags**.
👉 [Exemplo de imagem com ArUco Tag](https://docs.opencv.org/4.x/singlemarkersdetection.jpg)

A API será responsável pela comunicação com o banco de dados criado na disciplina de **Database**, facilitando o envio e recebimento de informações na infraestrutura do projeto.
Além disso, será futuramente integrada ao aplicativo mobile desenvolvido na disciplina de **Mobile Application Development**.

---

## 🔗 Link do Repositório

[https://github.com/thejaobiell/MottuFlowJava](https://github.com/thejaobiell/MottuFlowJava)

---

## 📚 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **Banco de Dados H2** (posteriormente será substituído por Oracle)
* **Maven** (gerenciador de dependências)

---

## ⚙️ Como Executar o Projeto

### 🔁 Clonar o repositório via terminal:

```bash
git clone https://github.com/thejaobiell/MottuFlowJava.git
cd MottuFlowJava/MottuFlow
```

---

### 📥 Ou importar o projeto no Eclipse IDE:

1. Abra o **Eclipse IDE**
2. Vá em **File > Import...**
3. Selecione **Maven > Existing Maven Projects**
4. Clique em **Browse** e selecione a pasta `MottuFlow`
5. Marque o arquivo `pom.xml`
6. Clique em **Finish** para concluir a importação

---

### 🛠️ Configuração do Banco de Dados H2

O projeto já está configurado para utilizar o banco de dados H2 em memória. As configurações estão definidas no arquivo:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:h2:mem:MottuFlow
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
```

### 🔁 Sobre o `data.sql`

**Para ativar a carga automática de dados de exemplo:**

* Deixe `spring.sql.init.mode=always`
* Mantenha a linha `spring.jpa.defer-datasource-initialization=true` **descomentada**

**Para desativar:**

* Altere `spring.sql.init.mode=never`
* Comente ou remova `spring.jpa.defer-datasource-initialization=true`

---

### ▶️ Executando a aplicação

#### Via terminal:

```bash
./mvnw spring-boot:run
```

#### Via Eclipse:

1. Navegue até: `MottuFlow/src/main/java/com/sprint/MottuFlow`
2. Abra o arquivo `MottuFlowApplication.java`
3. Clique com o botão direito e selecione **Run As > Java Application**

---

## 🔌 Acessando a API

### 💻 Console H2

Acesse pelo navegador:

```
http://localhost:8080/h2-console
```

Preencha com os dados:

* **JDBC URL:** `jdbc:h2:mem:MottuFlow`
* **User Name:** `sa`
* **Password:** *(deixe em branco)*
* **Driver Class:** `org.h2.Driver`

---

### 📮 Testes com Postman

1. Abra o **Postman**
2. Clique em **File > Import**
3. Selecione ou arraste a pasta **JSONS POSTMAN**
4. Realize os testes da API com os exemplos fornecidos

---

## ✅ Funcionalidades Disponíveis

A API oferece operações CRUD completas para as seguintes entidades:

* Funcionários
* Pátios
* Motos
* Câmeras
* ArUco Tags
* Status das motos
* Localidades

> Todas as requisições e respostas seguem o formato **JSON**.

---

## 🧭 Observações

* O projeto segue o padrão de arquitetura em camadas
* Utiliza **DTOs** para separar o modelo de domínio dos dados expostos

---

## 👥 Equipe de Desenvolvimento

* **João Gabriel Boaventura Marques e Silva** – RM554874 – 2TDSB2025
* **Léo Mota Lima** – RM557851 – 2TDSB2025
* **Lucas Leal das Chagas** – RM551124 – 2TDSB2025
