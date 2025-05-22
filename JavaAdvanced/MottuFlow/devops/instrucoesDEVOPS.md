# 🚀 MottuFlow - Deploy Automático com Azure e Docker

Este projeto automatiza a criação de uma VM no Azure, instalação do Docker e execução de uma aplicação containerizada usando um usuário sem privilégios administrativos.

---

## ✅ Pré-requisitos

- Azure CLI instalado e autenticado (`az login`)
- Dois arquivos prontos:
  - `vm-deploy.sh` – cria e configura a VM
  - `instalar-dockerVM.sh` – instala Docker e reinicia a VM

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

- Instala o Docker e suas dependências
- Adiciona o usuário `azureuser` ao grupo `docker`
- Reinicia a máquina para aplicar as permissões

---

## ✅ Etapa 2 – Executar os scripts

No terminal da sua máquina local, execute:

```bash
bash vm-deploy.sh 
````
ou

```bash
./vm-deploy.sh 
````

Esse comando irá:

* Criar toda a infraestrutura
* Instalar o Docker
* Reiniciar a VM automaticamente
---
### ⚠️ ATENÇÃO! Durante a instalação da VM serão solicitadas algumas interações:

> Como a **senha** → `MottuFlow-2025` ou uma **confirmação de permissão** → (`Y` / `YES`) para instalar o Docker dentro da máquina virtual.
> Portanto, durante esse processo de instalação, **fique atento!**
---

## ✅ Etapa 3 – Após o reboot da VM

A conexão SSH será encerrada automaticamente após a reinicialização da VM (isso é esperado).

### O que fazer:

1. Aguarde **1–2 minutos** até a VM estar novamente acessível
2. Conecte-se à VM via SSH:

```bash
ssh azureuser@<IP_PÚBLICO>
PASSWORD: MottuFlow-2025
```

> Substitua `<IP_PÚBLICO>` pelo IP exibido no terminal após a execução do script `vm-deploy.sh`.

---

## ✅ Etapa 4 – Rodar o container da aplicação

Dentro da VM, execute:

```bash
docker run -p 8080:8080 thejaobiel/mottuflow:sprint1
```

---

## ✅ Resultado Final

* Docker instalado corretamente
* Usuário `azureuser` com permissão para rodar Docker **sem `sudo`**
* Aplicação containerizada rodando e acessível em:

```
http://<IP_PÚBLICO>:8080
```

---

## Como acessar o H2(banco de dados)
> URL
```
http://<IP_PÚBLICO>:8080/h2-console
```

>Dentro do Console
```
Saved Settings: Generic H2 (Embedded)
Settings Name: Generic H2 (Embedded)

DriverClass: org.h2.Driver
JDBC URL: jdbc:h2:mem:MottuFlow
User Name: sa
Password: 
```
>Para ver o conteúdo das tabelas use:
```
SELECT * FROM FUNCIONARIO;
SELECT * FROM PATIO;
SELECT * FROM MOTO;
SELECT * FROM CAMERA;
SELECT * FROM ARUCO_TAG;
SELECT * FROM STATUS;
SELECT * FROM LOCALIDADE;
```
##### Obs: por padrão a tabela já vai vir com conteúdo.

---

### 7 Como excluir a VM
Após feito as utilização da API na VM para apagar a VM rode localmente o arquivo:
```
limparVM.sh
```

---
## 🧑‍💻 Créditos

Projeto desenvolvido para a disciplina **DevOps Tools & Cloud Computing** para o Challenge Sprint 1

Professor: Felipe Cavalcante Vilella de Oliveira
Turma: 2TDSB - 2025

Alunos:

* João Gabriel Boaventura Marques e Silva – RM554874 | 2TDSB-2025
* Leo Motta Lima – RM557851 | 2TDSB-2025
* Lucas Leal das Chagas – RM551124 | 2TDSB-2025

