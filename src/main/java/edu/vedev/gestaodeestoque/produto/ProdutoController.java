package edu.vedev.gestaodeestoque.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:3000")
    public ProdutoDTO create (@RequestBody ProdutoDTO produto) {
        return service.create(produto);
    }

    // listagem de produto
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Produto> listarProdutos() {
        return service.listarProdutos();
    }

    // buscar produto por id
    @GetMapping({"/{id}"})
    @CrossOrigin(origins = "http://localhost:3000")
    public Produto buscarProdutoPorId(@PathVariable UUID id) {
        Optional<Produto> produto = service.buscarPdodutoPorId(id);
        return produto.orElse(null);
    }

    // deletar produto
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void removerProduto(@PathVariable UUID id) {
        service.removerProduto(id);
    }

    //calcular o valor total do estoque
    @GetMapping("/valor-total")
    @CrossOrigin(origins = "http://estoque-copia-prd.up.railway.app/api/produtos/valor-total")
    public double calcularValorTotalEstoque(){
        return service.calcularValorTotalEstoque();
    }

}
