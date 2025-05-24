# 🚀 MottuFlow – Deploy Automatizado no Azure com Docker (API Java Containerizada)

Este projeto automatiza a criação de uma VM no Azure, instalação do Docker e execução de uma aplicação containerizada utilizando um usuário sem privilégios administrativos.

---

## 📚 Sumário

1. [✅ Pré-requisitos](#-pré-requisitos)  
2. [✅ Etapa 1 – Arquivos necessários](#-etapa-1--arquivos-necessários)  
3. [✅ Etapa 2 – Executar os scripts](#-etapa-2--executar-os-scripts)  
4. [✅ Etapa 3 – Após o reboot da VM](#-etapa-3--após-o-reboot-da-vm)  
5. [✅ Etapa 4 – Rodar o container da aplicação](#-etapa-4--rodar-o-container-da-aplicação)  
6. [💾 Como acessar o H2 (banco de dados)](#como-acessar-o-h2-banco-de-dados)  
7. [🗑️ Como excluir a VM](#-como-excluir-a-vm)  
8. [🧑‍💻 Créditos](#-créditos)  

---

## ✅ Pré-requisitos

- Azure CLI instalado e autenticado (`az login`)
- Fazer o git clone do [repositório da API em Java](https://github.com/thejaobiell/MottuFlowJava)
  >OBS: Lá dentro tem um pasta **devops**
- Dois arquivos prontos:
  - `vm-deploy.sh` – cria e configura a VM
  - `instalar-dockerVM.sh` – instala Docker e reinicia a VM
  > OBS: Ambos os arquivos devem estar na mesma pasta.

---

## ✅ Etapa 1 – Arquivos necessários

### 1. `vm-deploy.sh`

Script responsável por:

- Criar a infraestrutura no Azure
- Criar a VM Ubuntu
- Copiar o script de instalação para a VM
- Executar o script remotamente via SSH

### 2. `instalar-dockerVM.sh`

Script que será executado **dentro da VM**, com as seguintes responsabilidades:

- Instalar o Docker e suas dependências
- Adicionar o usuário `azureuser` ao grupo `docker`
- Reiniciar a máquina para aplicar as permissões

---

## ✅ Etapa 2 – Executar os scripts

No terminal da sua máquina local, execute:

```bash
bash vm-deploy.sh
# ou
./vm-deploy.sh
````

Esse comando irá:

* Criar toda a infraestrutura
* Instalar o Docker
* Reiniciar a VM automaticamente

---

### ⚠️ ATENÇÃO!

Durante a instalação da VM, serão solicitadas algumas interações:

> Como a **senha** do usuário (ex: `MottuFlow-2025`) ou uma **confirmação de permissão** (`Y` / `YES`) para instalar o Docker dentro da máquina virtual.
> Portanto, durante esse processo, **fique atento!**

---

## ✅ Etapa 3 – Após o reboot da VM

A conexão SSH será encerrada automaticamente após a reinicialização da VM (isso é esperado).

### O que fazer:

1. Aguarde **1-2 minutos** até a VM estar acessível novamente
2. Conecte-se à VM via SSH:

```bash
ssh azureuser@<IP_PÚBLICO>
# Senha: MottuFlow-2025
```

> Substitua `<IP_PÚBLICO>` pelo IP exibido no terminal após a execução do script `vm-deploy.sh`.

---

## ✅ Etapa 4 – Rodar o container da aplicação

Dentro da VM, execute:

```bash
docker run -p 8080:8080 thejaobiel/mottuflow:sprint1
```

---

## 💾 Como acessar o H2 (banco de dados)

### 🌐 URL

```
http://<IP_PÚBLICO>:8080/h2-console
```

### 🛠️ Configurações do Console

```
Saved Settings: Generic H2 (Embedded)
Settings Name: Generic H2 (Embedded)

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:MottuFlow
User Name: sa
Password: 
```

### 🔍 Consultas SQL:

```sql
SELECT * FROM FUNCIONARIO;
SELECT * FROM PATIO;
SELECT * FROM MOTO;
SELECT * FROM CAMERA;
SELECT * FROM ARUCO_TAG;
SELECT * FROM STATUS;
SELECT * FROM LOCALIDADE;
```

> ⚠️ Obs: Por padrão, as tabelas já estarão populadas com conteúdo significativo.

---

## 🗑️ Como excluir a VM

Após finalizar o uso da API na VM, execute localmente o script:

```bash
bash limparVM.sh
```

---

## 🧑‍💻 Créditos

Projeto desenvolvido para a disciplina **DevOps Tools & Cloud Computing** – Challenge Sprint 1
Professor: Felipe Cavalcante Vilella de Oliveira
Turma: 2TDSB - 2025

### 👨‍🎓 Alunos

* João Gabriel Boaventura Marques e Silva – RM554874
* Leo Motta Lima – RM557851
* Lucas Leal das Chagas – RM551124

🔗 [Repositório da API em Java no GitHub](https://github.com/thejaobiell/MottuFlowJava)

---

> 💡 **DEVOPS TOOLS & CLOUD COMPUTING – Sprint 1 Avaliação**
>
> * Spring Web para criação da API
> * Spring Data JPA para acesso ao banco de dados
> * Banco H2 (ou Oracle)
> * CRUD completo de pelo menos 2 entidades
> * Relacionamentos entre entidades
> * Dockerfile, scripts Azure CLI, README com instruções
