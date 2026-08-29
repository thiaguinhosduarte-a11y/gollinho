package com.empresa.gollinho.service;

import com.empresa.gollinho.model.PosicaoArmazem;
import com.empresa.gollinho.repository.PosicaoArmazemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicaoArmazemService {
    private final PosicaoArmazemRepository repository;

    public PosicaoArmazemService(PosicaoArmazemRepository repository) { this.repository = repository; }
    public List<PosicaoArmazem> listarTodos() { return repository.findAll(); }
    public PosicaoArmazem buscarPorId(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Posição de armazém não encontrada: " + id)); }
    public PosicaoArmazem salvar(PosicaoArmazem posicao) { posicao.setId(null); if (posicao.getOcupada() == null) posicao.setOcupada(false); return repository.save(posicao); }
    public PosicaoArmazem atualizar(Long id, PosicaoArmazem dados) { PosicaoArmazem p = buscarPorId(id); p.setCodigo(dados.getCodigo()); p.setCorredor(dados.getCorredor()); p.setEstante(dados.getEstante()); p.setNivel(dados.getNivel()); return repository.save(p); }
    public void deletar(Long id) { repository.delete(buscarPorId(id)); }
}
