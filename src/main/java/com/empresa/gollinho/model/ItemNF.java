package com.empresa.gollinho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ItemNF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private BigDecimal valorTotal;
    private Double qtdLitros;
    @OneToMany(mappedBy = "itemNf", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fardos> fardos;
    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscal notaFiscal;


}
