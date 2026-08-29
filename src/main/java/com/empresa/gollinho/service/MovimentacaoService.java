package com.empresa.gollinho.service;

import com.empresa.gollinho.model.Movimentacao;
import com.empresa.gollinho.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {
    private final MovimentacaoRepository repository;

    public MovimentacaoService(MovimentacaoRepository repository) {
        this.repository = repository;
    }

    public List<Movimentacao> listarTodos() { return repository.findAll(); }
    public Movimentacao buscarPorId(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Movimentação não encontrada: " + id)); }

    @Transactional
    public Movimentacao salvar(Movimentacao movimentacao) {
        movimentacao.setId(null);
        if (movimentacao.getDataHora() == null) movimentacao.setDataHora(LocalDateTime.now());
        return repository.save(movimentacao);
    }

    @Transactional
    public Movimentacao atualizar(Long id, Movimentacao dados) {
        Movimentacao existente = buscarPorId(id);
        existente.setTipo(dados.getTipo());
        existente.setDataHora(dados.getDataHora());
        existente.setPosicaoOrigem(dados.getPosicaoOrigem());
        existente.setPosicaoDestino(dados.getPosicaoDestino());
        existente.setObservacao(dados.getObservacao());
        return repository.save(existente);
    }

    public void deletar(Long id) { repository.delete(buscarPorId(id)); }
}
