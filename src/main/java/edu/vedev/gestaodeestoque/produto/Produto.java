package edu.vedev.gestaodeestoque.produto;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(ProdutoDTO data) {
        this.nome = data.nome();
        this.quantidade = data.quantidade();
        this.preco = data.preco();
    }
}
