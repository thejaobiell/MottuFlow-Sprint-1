Claro! Abaixo está a documentação das APIs no estilo exato do exemplo que você forneceu, seguindo o mesmo padrão de seções com exemplos `http` e tabelas de parâmetros.

---

## 📘 Documentação da API - MottuFlow

---

### 👤 Funcionário API

#### Listar todos os funcionários

```http
GET /api/funcionarios
```

#### Buscar funcionário por ID

```http
GET /api/funcionarios/${id}
```

| Parâmetro | Tipo  | Descrição                          |
| --------- | ----- | ---------------------------------- |
| `id`      | `int` | **Obrigatório**. ID do funcionário |

#### Criar funcionário

```http
POST /api/funcionarios
```

| Corpo (JSON) | Tipo     | Descrição           |
| ------------ | -------- | ------------------- |
| `nome`       | `string` | Nome do funcionário |
| `cpf`        | `string` | CPF                 |
| `cargo`      | `string` | Cargo ou função     |
| `telefone`   | `string` | Telefone            |
| `usuario`    | `string` | Nome de usuário     |
| `senha`      | `string` | Senha               |

#### Atualizar funcionário

```http
PUT /api/funcionarios/${id}
```

Mesmos campos do POST.

#### Deletar funcionário

```http
DELETE /api/funcionarios/${id}
```

---

### 🏢 Pátio API

#### Listar todos os pátios

```http
GET /api/patios
```

#### Buscar pátio por ID

```http
GET /api/patios/${id}
```

| Parâmetro | Tipo  | Descrição                    |
| --------- | ----- | ---------------------------- |
| `id`      | `int` | **Obrigatório**. ID do pátio |

#### Criar pátio

```http
POST /api/patios
```

| Campo              | Tipo     | Descrição         |
| ------------------ | -------- | ----------------- |
| `nome`             | `string` | Nome do pátio     |
| `endereco`         | `string` | Endereço          |
| `capacidadeMaxima` | `int`    | Capacidade máxima |

#### Atualizar pátio

```http
PUT /api/patios/${id}
```

Mesmos campos do POST.

#### Deletar pátio

```http
DELETE /api/patios/${id}
```

---

### 🏍️ Moto API

#### Listar todas as motos

```http
GET /api/motos
```

#### Buscar moto por ID

```http
GET /api/motos/${id}
```

| Parâmetro | Tipo  | Descrição                   |
| --------- | ----- | --------------------------- |
| `id`      | `int` | **Obrigatório**. ID da moto |

#### Criar moto

```http
POST /api/motos
```

| Campo              | Tipo     | Descrição             |
| ------------------ | -------- | --------------------- |
| `placa`            | `string` | Placa da moto         |
| `modelo`           | `string` | Modelo                |
| `fabricante`       | `string` | Fabricante            |
| `ano`              | `int`    | Ano de fabricação     |
| `idPatio`          | `int`    | ID do pátio associado |
| `localizacaoAtual` | `string` | Localização no pátio  |

#### Atualizar moto

```http
PUT /api/motos/${id}
```

Mesmos campos do POST + `idMoto`.

#### Deletar moto

```http
DELETE /api/motos/${id}
```

---

### 🎥 Câmera API

#### Listar todas as câmeras

```http
GET /api/cameras
```

#### Buscar câmera por ID

```http
GET /api/cameras/${id}
```

| Parâmetro | Tipo  | Descrição                     |
| --------- | ----- | ----------------------------- |
| `id`      | `int` | **Obrigatório**. ID da câmera |

#### Criar câmera

```http
POST /api/cameras
```

| Campo               | Tipo     | Descrição                  |
| ------------------- | -------- | -------------------------- |
| `statusOperacional` | `string` | Status da câmera           |
| `localizacaoFisica` | `string` | Ponto físico de instalação |
| `idPatio`           | `int`    | ID do pátio associado      |

#### Atualizar câmera

```http
PUT /api/cameras/${id}
```

Mesmos campos do POST + `idCamera`.

#### Deletar câmera

```http
DELETE /api/cameras/${id}
```

---

### 🏷️ ArucoTag API

#### Listar todas as tags

```http
GET /api/aruco-tags
```

#### Buscar tag por ID

```http
GET /api/aruco-tags/${id}
```

| Parâmetro | Tipo  | Descrição                  |
| --------- | ----- | -------------------------- |
| `id`      | `int` | **Obrigatório**. ID da tag |

#### Criar tag

```http
POST /api/aruco-tags
```

| Campo    | Tipo     | Descrição     |
| -------- | -------- | ------------- |
| `codigo` | `string` | Código da tag |
| `idMoto` | `int`    | ID da moto    |
| `status` | `string` | Status da tag |

#### Atualizar tag

```http
PUT /api/aruco-tags/${id}
```

Mesmos campos do POST + `idTag`.

#### Deletar tag

```http
DELETE /api/aruco-tags/${id}
```

---

### 🔄 Status API

#### Listar todos os status

```http
GET /api/status
```

#### Buscar status por ID

```http
GET /api/status/${id}
```

| Parâmetro | Tipo  | Descrição                     |
| --------- | ----- | ----------------------------- |
| `id`      | `int` | **Obrigatório**. ID do status |

#### Criar status

```http
POST /api/status
```

| Campo           | Tipo     | Descrição                |
| --------------- | -------- | ------------------------ |
| `idMoto`        | `int`    | ID da moto               |
| `tipoStatus`    | `string` | Tipo do status           |
| `descricao`     | `string` | Descrição detalhada      |
| `idFuncionario` | `int`    | Responsável pela mudança |

#### Atualizar status

```http
PUT /api/status/${id}
```

Mesmos campos do POST + `idStatus`.

#### Deletar status

```http
DELETE /api/status/${id}
```

---

### 📍 Localidade API

#### Listar todas as localidades

```http
GET /api/localidades
```

#### Buscar localidade por ID

```http
GET /api/localidades/${id}
```

| Parâmetro | Tipo  | Descrição                         |
| --------- | ----- | --------------------------------- |
| `id`      | `int` | **Obrigatório**. ID da localidade |

#### Criar localidade

```http
POST /api/localidades
```

| Campo             | Tipo     | Descrição                                 |
| ----------------- | -------- | ----------------------------------------- |
| `dataHora`        | `string` | Data e hora ISO (ex: 2025-05-18T20:00:00) |
| `idMoto`          | `int`    | ID da moto                                |
| `idPatio`         | `int`    | ID do pátio                               |
| `pontoReferencia` | `string` | Referência geográfica                     |
| `idCamera`        | `int`    | ID da câmera captadora                    |

#### Atualizar localidade

```http
PUT /api/localidades/${id}
```

Mesmos campos do POST + `idLocalidade`.

#### Deletar localidade

```http
DELETE /api/localidades/${id}
```

---

Se quiser, posso gerar esse conteúdo como arquivo `README.md`. Deseja isso?
