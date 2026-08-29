package com.empresa.gollinho.model;

import com.empresa.gollinho.enums.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo;

    @Column(nullable = false)
    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "posicao_origem_id")
    private PosicaoArmazem posicaoOrigem;

    @ManyToOne
    @JoinColumn(name = "posicao_destino_id")
    private PosicaoArmazem posicaoDestino;

    private String observacao;
}
