package com.empresa.gollinho.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Produto {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;
    private String descricao;
    private BigDecimal valor;
    @OneToMany
    private Sabor sabor;

}


