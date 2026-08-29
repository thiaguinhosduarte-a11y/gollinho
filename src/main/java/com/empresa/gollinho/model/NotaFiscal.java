package com.empresa.gollinho.model;

import com.empresa.gollinho.enums.StatusNotaFiscal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    private StatusNotaFiscal status;
    @OneToMany(mappedBy = "notaFiscal")
    private List<ItemNF> itemNF;
    private String cnpjFrnecedor;
    private LocalDate data_emissao;
    private LocalDate data_movimentacao;
    private BigDecimal valorFinal;

}
