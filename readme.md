### Desafio de Programação em Java - Gestão de Estoque com API RESTful

#### Descrição do Desafio:

O desafio consiste em desenvolver uma aplicação web para gerenciamento de um **estoque de produtos**. A aplicação será composta por um **back-end** em Java, utilizando **Spring Boot** para criar uma API RESTful que permitirá realizar operações como adicionar, listar, remover produtos e calcular o valor total do estoque. O **front-end** será uma página simples em HTML, CSS e JavaScript para interagir com a API e exibir as informações de forma amigável ao usuário.

#### Requisitos do Desafio:

##### 1. **Back-End (Spring Boot)**:

- **Modelo Produto**: A aplicação deve armazenar informações sobre os produtos, como:
    - **ID** (único para cada produto),
    - **Nome** do produto,
    - **Quantidade** disponível em estoque,
    - **Preço** de venda.
- **API RESTful**:
    - **POST /api/produtos**: Criar um novo produto no estoque.
    - **GET /api/produtos**: Listar todos os produtos disponíveis no estoque.
    - **GET /api/produtos/{id}**: Buscar um produto pelo seu ID.
    - **DELETE /api/produtos/{id}**: Remover um produto do estoque.
    - **GET /api/produtos/valor-total**: Calcular o valor total do estoque (quantidade \* preço de cada produto).

##### 2. **Front-End (HTML, CSS, JavaScript)**:

- **Formulários**:
    - **Adicionar Produto**: Formulário para adicionar um produto, solicitando ID, nome, quantidade e preço.
    - **Remover Produto**: Campo para informar o ID do produto e removê-lo do estoque.
- **Exibição dos Produtos**: Lista dinâmica que exibe todos os produtos do estoque, com suas informações de ID, nome, quantidade e preço.
- **Valor Total do Estoque**: Um botão para calcular e exibir o valor total do estoque com base nos produtos cadastrados.
- **Interação com a API**: O front-end deve fazer requisições HTTP utilizando **JavaScript** (fetch API) para interagir com os endpoints da API, realizar operações como adicionar, listar, remover produtos e calcular o valor total.

#### Requisitos Funcionais:

1. **Adicionar Produto**: O usuário deve poder cadastrar um novo produto, informando o ID, nome, quantidade e preço.
2. **Listar Produtos**: O usuário pode visualizar todos os produtos armazenados no estoque, com suas informações.
3. **Remover Produto**: O usuário deve ser capaz de remover um produto do estoque informando o seu ID.
4. **Valor Total do Estoque**: O sistema deve calcular e exibir o valor total do estoque, multiplicando a quantidade de cada produto pelo seu preço.

#### Como Funciona:

- **Back-End**: O Spring Boot cria uma API RESTful que pode ser acessada por requisições HTTP. Cada operação de adicionar, listar, remover produtos ou calcular o valor total do estoque será manipulada por endpoints específicos na API.
- **Front-End**: A página HTML exibe um formulário simples para interagir com a API e permite ao usuário adicionar, remover produtos e ver as informações do estoque em tempo real. O JavaScript realiza as requisições para a API e exibe os dados de forma dinâmica.

#### Tecnologias Utilizadas:

1. **Back-End**:
    - **Spring Boot**: Framework Java para desenvolvimento de APIs RESTful.
    - **JPA/H2**: Para persistência dos dados em um banco de dados em memória (H2).
    - **Spring Web**: Para criação dos endpoints RESTful.
2. **Front-End**:
    - **HTML/CSS**: Para estruturação e estilo da interface.
    - **JavaScript**: Para interagir com a API e manipular os dados dinamicamente.

#### Como Testar:

1. **Back-End**:
    - Inicialize o back-end com Spring Boot. A API estará disponível em `http://localhost:8080/api/produtos`.
2. **Front-End**:
    - Salve os arquivos `index.html`, `styles.css` e `script.js` em uma pasta e abra o `index.html` no seu navegador.
    - O front-end se comunicará com o back-end, enviando e recebendo dados da API.

#### Exemplo de Fluxo de Interação:

1. O usuário acessa a página e preenche o formulário para adicionar um produto.
2. Ao clicar em "Adicionar Produto", o produto é enviado para o back-end e é adicionado ao estoque.
3. O usuário pode visualizar os produtos clicando no botão "Listar Produtos".
4. O usuário pode remover um produto informando seu ID e clicando no botão "Remover Produto".
5. O valor total do estoque pode ser calculado clicando no botão "Calcular Total".

#### Conclusão:

Este desafio visa testar suas habilidades em **desenvolvimento web full-stack**, abrangendo tanto a criação de uma **API RESTful** com **Spring Boot** quanto a construção de uma interface simples e funcional para interação com a API utilizando **HTML, CSS e JavaScript**. Ao final, você terá uma aplicação funcional de gestão de estoque.
