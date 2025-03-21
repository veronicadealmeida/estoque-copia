package edu.vedev.gestaodeestoque.produto;

import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDTO toDTO(Produto produto) {

        if (produto == null) {
            return null;
        }
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getPreco());
    }

    public Produto toEntity(ProdutoDTO produtoDTO) {

        if (produtoDTO == null) {
            return null;
        }

        Produto produto = new Produto();
        if (produtoDTO.id() != null ) {
            produto.setId(produtoDTO.id());
        }
        produto.setNome( produtoDTO.nome());
        produto.setQuantidade(produtoDTO.quantidade());
        produto.setPreco(produtoDTO.preco());

        return produto;
    }
}
