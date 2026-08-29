package com.empresa.gollinho.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data

public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    private String nome;
    private String descricao;







}
