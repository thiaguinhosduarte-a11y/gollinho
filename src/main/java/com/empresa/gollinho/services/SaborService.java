package com.empresa.gollinho.services;

import com.empresa.gollinho.model.Sabor;
import com.empresa.gollinho.repository.SaborRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaborService {

    private final SaborRepository saborRepository;

    public SaborService(SaborRepository saborRepository) {
        this.saborRepository = saborRepository;
    }

    public Sabor cadastrar(Sabor sabor) {
        return saborRepository.save(sabor);
    }

    public List<Sabor> listarTodos() {
        return saborRepository.findAll();
    }

    public Optional<Sabor> buscarPorId(Long id) {
        return saborRepository.findById(id);
    }

    public Sabor atualizar(Long id, Sabor sabor) {

        Sabor saborExistente = saborRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sabor não encontrado"));

        saborExistente.setNome(sabor.getNome());

        return saborRepository.save(saborExistente);
    }

    public void deletar(Long id) {

        if (!saborRepository.existsById(id)) {
            throw new RuntimeException("Sabor não encontrado");
        }

        saborRepository.deleteById(id);
    }
}
