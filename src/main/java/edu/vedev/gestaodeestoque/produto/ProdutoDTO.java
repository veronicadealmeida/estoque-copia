package edu.vedev.gestaodeestoque.produto;

import java.util.UUID;

public record ProdutoDTO(java.util.UUID id, String nome, int quantidade, double preco ) {

}
