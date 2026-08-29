package com.empresa.gollinho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class ItemNF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private Long codigoNf;
    private String idPallet;
    private int cnpj;
    private String statusNf;
    private BigDecimal valorFinal;
    private String dataRecebimento;






}
