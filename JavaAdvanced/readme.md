# MottuFlow – API REST em Java

Este repositório contém a implementação da API REST **MottuFlow** desenvolvida na disciplina de **Java Advanced**, como parte do curso de **Análise e Desenvolvimento de Sistemas**.

O projeto tem como objetivo aplicar os conceitos avançados de desenvolvimento Java, incluindo a criação de serviços RESTful com **Spring Boot**, integração com banco de dados e boas práticas de engenharia de software. A aplicação oferece funcionalidades completas de **CRUD** para gerenciamento de:

- Funcionários  
- Pátios  
- Motos  
- Câmeras  
- ArUco Tags  
- Status das motos  
- Localidades  

> :bulb: Esta API será utilizada como parte de uma solução maior que inclui visão computacional (IoT), banco de dados Oracle, e integração com um app mobile.

---

## 🔗 Link do Repositório

[https://github.com/thejaobiell/MottuFlowJava](https://github.com/thejaobiell/MottuFlowJava)

---

## 📚 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Banco de Dados H2** (futuramente implementaremos a integração com o banco de dados ORACLE)
- **Maven** como gerenciador de dependências

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/thejaobiell/MottuFlowJava.git
cd MottuFlowJava
````

Claro! Aqui está a **versão melhorada** e mais clara desse trecho para incluir corretamente a explicação sobre o uso do `data.sql` com o banco H2:

---

2. **O projeto já está configurado para utilizar o banco de dados H2 em memória**.
   As configurações estão definidas no arquivo `src/main/resources/application.properties`.

> 💡 O projeto inclui um arquivo `data.sql` com comandos `INSERT` para popular automaticamente todas as tabelas com dados iniciais.

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

🔁 **Sobre o `data.sql`:**

* Para **ativar** a carga automática dos dados de exemplo:

  * Mantenha `spring.sql.init.mode=always`
  * Deixe **descomentada** a linha `spring.jpa.defer-datasource-initialization=true`

* Para **desativar** a carga do `data.sql`:

  * Altere para `spring.sql.init.mode=never`
  * Comente ou remova a linha `spring.jpa.defer-datasource-initialization=true`

3. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

4. **Como utilizar a API:**

> Pelo console H2 em:
```
URL: http://localhost:8080/h2-console
```

Utilize:
  * Saved Settings: Generic H2 (Embedded)
  * Settings Name: Generic H2 (Embedded)
  * DriverClass: ```org.h2.Driver```
  * JDBC URL: ```jdbc:h2:mem:MottuFlow```
  * User Name: ```sa```
  * Password: 


> Acessando pelo POSTMAN:
Importe a Pasta **JSONS POSTMAN** no POSTMAN em:
1. Clique em **File**;
2. Depois em **Import**;
3. Por fim **arraste a pasta até o retângulo de arraste** ou clique em **Select Folder** e selecione a pasta ***JSONS POSTMAN***
4. E enfim faça os testes da api.

---

## 📂 Estrutura de Diretórios

* `controller/` – Camada de controle com os endpoints da API
* `service/` – Regras de negócio
* `repository/` – Interfaces JPA para persistência
* `model/` – Entidades do sistema
* `dto/` – Objetos de Transferência de Dados
* `config/` – Configurações da aplicação

---

## ✅ Funcionalidades

A API oferece operações CRUD para as seguintes entidades:

* **Funcionários**
* **Pátios**
* **Motos**
* **Câmeras**
* **ArUco Tags**
* **Status das motos**
* **Localidades**

> Todas as requisições e respostas utilizam o formato JSON.

---

## 📎 Observações

* O projeto segue o padrão de arquitetura em camadas.
* Utiliza **DTOs** para separar modelo de domínio dos dados expostos.

---

## 👥 Equipe de Desenvolvimento

* **João Gabriel Boaventura Marques e Silva** – RM554874 – 2TDSB2025
* **Léo Mota Lima** – RM557851 – 2TDSB2025
* **Lucas Leal das Chagas** – RM551124 – 2TDSB2025