package com.empresa.gollinho.service;

import com.empresa.gollinho.model.Fardo;
import com.empresa.gollinho.repository.FardoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FardoService {

    private final FardoRepository repository;

    public FardoService(FardoRepository repository) {
        this.repository = repository;
    }

    public List<Fardo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Fardo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Fardo salvar(Fardo fardo) {
        return repository.save(fardo);
    }

    public Fardo atualizar(Long id, Fardo fardoAtualizado) {
        return repository.findById(id).map(fardo -> {
            fardo.setProduto(fardoAtualizado.getProduto());
            fardo.setQtdProduto(fardoAtualizado.getQtdProduto());
            fardo.setItemNf(fardoAtualizado.getItemNf());
            return repository.save(fardo);
        }).orElseThrow(() -> new RuntimeException("Fardo não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}