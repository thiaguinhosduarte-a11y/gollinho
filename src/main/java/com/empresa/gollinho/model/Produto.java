package com.empresa.gollinho.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    private String nomeProduto;

    @Column(name = "volume_garrafa", length = 20)
    private String volumeGarrafa;

    @Column(name = "fardos_por_palete")
    private Integer fardosPorPalete;

    @Column(name = "garrafas_por_fardo")
    private Integer garrafasPorFardo;

    @ManyToOne
    @JoinColumn(name = "sabor_id")
    private Sabor sabor;
}