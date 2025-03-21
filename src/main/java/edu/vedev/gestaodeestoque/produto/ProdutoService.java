package edu.vedev.gestaodeestoque.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoDTO create(ProdutoDTO produto) {
        return  produtoMapper.toDTO(repository.save(produtoMapper.toEntity(produto)));
    }


    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPdodutoPorId(UUID id) {
        return repository.findById(id);
    }

    public void removerProduto( UUID id) {
        repository.deleteById(id);
    }

    public double calcularValorTotalEstoque() {
        List<Produto> produtos = repository.findAll();
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getQuantidade() * produto.getPreco();
        }
        return total;
    }


}
