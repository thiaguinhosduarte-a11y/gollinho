package com.empresa.gollinho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Fardo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private int qtdProduto;
    @ManyToOne
    @JoinColumn(name = "item_nf_id")
    private ItemNF itemNf;

}
