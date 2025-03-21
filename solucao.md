Para refazer o desafio utilizando métodos HTTP como POST, GET, PUT, e DELETE, podemos construir uma aplicação mais orientada a APIs, utilizando um framework web em Java como o **Spring Boot**. O Spring Boot facilita a criação de aplicações Java baseadas em RESTful APIs, permitindo manipular dados através de requisições HTTP.

Aqui está um exemplo de como você pode criar um serviço RESTful para gerenciar o estoque de produtos utilizando Spring Boot:

### Dependências Necessárias:
Primeiro, você precisa adicionar as dependências do Spring Boot no seu `pom.xml` (caso esteja usando o Maven). Certifique-se de incluir as dependências para o Spring Web e Spring Boot Starter.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

### Estrutura do Projeto:

1. **Modelo Produto**
2. **Repositório Produto** (Interface para comunicação com banco de dados)
3. **Serviço Produto** (Lógica de negócios)
4. **Controlador Produto** (EndPoints da API)

### Passo 1: Criando o Modelo `Produto`

```java
package com.example.estoque.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
    @Id
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    // Construtores, Getters e Setters
    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
```

### Passo 2: Criando o Repositório `ProdutoRepository`

```java
package com.example.estoque.repository;

import com.example.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
```

### Passo 3: Criando o Serviço `ProdutoService`

```java
package com.example.estoque.service;

import com.example.estoque.model.Produto;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarProdutoPorId(int id) {
        return produtoRepository.findById(id);
    }

    public void removerProduto(int id) {
        produtoRepository.deleteById(id);
    }

    public double calcularValorTotalEstoque() {
        List<Produto> produtos = produtoRepository.findAll();
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getQuantidade() * produto.getPreco();
        }
        return total;
    }
}
```

### Passo 4: Criando o Controlador `ProdutoController`

```java
package com.example.estoque.controller;

import com.example.estoque.model.Produto;
import com.example.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Criar Produto (POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    // Listar Produtos (GET)
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Buscar Produto por ID (GET)
    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable int id) {
        Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
        return produto.orElse(null);
    }

    // Remover Produto (DELETE)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerProduto(@PathVariable int id) {
        produtoService.removerProduto(id);
    }

    // Calcular o valor total do estoque (GET)
    @GetMapping("/valor-total")
    public double calcularValorTotalEstoque() {
        return produtoService.calcularValorTotalEstoque();
    }
}
```

### Passo 5: Configuração Principal `Application`

```java
package com.example.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
    }
}
```

### Testando a API

Agora, com a aplicação em funcionamento, você pode testar as requisições HTTP utilizando ferramentas como **Postman** ou **cURL**. Aqui estão algumas requisições que você pode fazer:

1. **Adicionar Produto (POST)**
    - **URL**: `http://localhost:8080/api/produtos`
    - **Body (JSON)**:
      ```json
      {
        "id": 1,
        "nome": "Produto A",
        "quantidade": 10,
        "preco": 50.0
      }
      ```

2. **Listar Produtos (GET)**
    - **URL**: `http://localhost:8080/api/produtos`
    - **Resposta**:
      ```json
      [
        {
          "id": 1,
          "nome": "Produto A",
          "quantidade": 10,
          "preco": 50.0
        }
      ]
      ```

3. **Buscar Produto por ID (GET)**
    - **URL**: `http://localhost:8080/api/produtos/1`
    - **Resposta**:
      ```json
      {
        "id": 1,
        "nome": "Produto A",
        "quantidade": 10,
        "preco": 50.0
      }
      ```

4. **Remover Produto (DELETE)**
    - **URL**: `http://localhost:8080/api/produtos/1`

5. **Calcular Valor Total do Estoque (GET)**
    - **URL**: `http://localhost:8080/api/produtos/valor-total`
    - **Resposta**: `500.0` (dependendo dos produtos cadastrados)

### Explicação das Requisições HTTP:
- **POST**: Usado para criar um novo produto no estoque.
- **GET**: Usado para listar todos os produtos ou buscar um produto específico pelo ID.
- **DELETE**: Usado para remover um produto pelo ID.
- **GET** (para valor total): Usado para calcular o valor total do estoque.

### Conclusão:
Esse desafio utiliza o padrão de desenvolvimento RESTful para criar uma API em Java, onde é possível adicionar, listar, remover produtos e calcular o valor total do estoque. O uso de **POST**, **GET**, **DELETE** é adequado para manipulação de dados em um serviço web.