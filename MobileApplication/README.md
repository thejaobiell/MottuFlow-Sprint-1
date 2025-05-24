# MottuFlow 📱

Projeto desenvolvido no curso de Análise e Desenvolvimento de Sistemas, com previsão de integração futura com as disciplinas de **Java Advanced, Database e IoT.**

## 📱 Sobre o App Mobile

Projeto para a matéria de **MOBILE APPLICATION DEVELOPMENT** desenvolvido durante a **Sprint 1**.

## 🔗 Protótipo no Figma

[Visualizar protótipo no Figma](https://www.figma.com/design/PvVbzAKpL9dI2E7Iho9Xe9/MottoFlow---SPRINT-1?node-id=0-1&t=gz6ldScA0ytk4MXl-1)

## ✨ Funcionalidades previstas

* Cadastrar motos
* Visualizar a localização das motos em tempo real
* Navegar por uma interface amigável

## 🔗 Integração com a API

Este aplicativo será integrado futuramente com a **API REST MottuFlow**, desenvolvida como parte da disciplina de **Java Advanced**. Por hora usaremos uma simulação feita no MockAPI

A API oferece funcionalidades completas de CRUD para o gerenciamento de:

* Funcionários
* Pátios
* Motos
* Câmeras
* ArUco Tags
* Status das motos
* Localidades

No contexto da disciplina de **IoT**, também está sendo desenvolvida uma solução de visão computacional que utiliza câmeras para identificar motocicletas por meio de **ArUco Tags**. 👉 [Exemplo de imagem com ArUco Tag](https://docs.opencv.org/4.x/singlemarkersdetection.jpg)

A API realiza a comunicação com o banco de dados criado na disciplina de **Database**, facilitando o envio e recebimento de informações essenciais para a infraestrutura do projeto. Ela será responsável por fornecer dados em tempo real para o app mobile, garantindo uma experiência rica e integrada.

## 🛠️ Tecnologias

* **React Native**
* **Expo**
* **Figma**
* **MockAPI**

## 🚀 Como rodar o projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/FIAP-MOBILE/challenge-mottuflow.git
   ```

2. Navegue até a pasta do projeto:

   ```bash
   cd challenge-mottuflow
   ```

3. Instale as dependências:

   ```bash
   npm install
   ```

4. Execute o projeto:

   ```bash
   npm start android
   ```

## 👥 Contribuidores

* [João Gabriel Boaventura Marques e Silva  | RM554874 | 2TDSB-2025](https://github.com/thejaobiell) – Desenvolvedor
* [Léo Mota Lima | RM557851 | 2TDSB-2025](https://github.com/leomotalima) – Desenvolvedor
* [Lucas Leal das Chagas | RM551124 | 2TDSB-2025](https://github.com/LucasLDC) – Desenvolvedor
