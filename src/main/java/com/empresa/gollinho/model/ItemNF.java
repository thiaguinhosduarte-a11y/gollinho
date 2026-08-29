package com.empresa.gollinho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ItemNF {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    Long id;
    private Long codigoNf;
    private String idPallet;
    private int cnpj;
    @ManyToOne
    @JoinColumn(name = "'nota_fiscal_id'")
    private NotaFiscal notaFiscal;


}
