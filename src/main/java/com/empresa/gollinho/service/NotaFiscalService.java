package com.empresa.gollinho.service;

import com.empresa.gollinho.model.NotaFiscal;
import com.empresa.gollinho.repository.NotaFiscalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService {

    private final NotaFiscalRepository repository;

    public NotaFiscalService(NotaFiscalRepository repository) {
        this.repository = repository;
    }

    public List<NotaFiscal> listarTodas() {
        return repository.findAll();
    }

    public Optional<NotaFiscal> buscarPorId(String id) {
        return repository.findById(id);
    }

    public NotaFiscal salvar(NotaFiscal notaFiscal) {
        return repository.save(notaFiscal);
    }

    public NotaFiscal atualizar(String id, NotaFiscal notaFiscalAtualizada) {
        return repository.findById(id).map(nota -> {
            nota.setStatus(notaFiscalAtualizada.getStatus());
            nota.setItemNF(notaFiscalAtualizada.getItemNF());
            nota.setCnpjFrnecedor(notaFiscalAtualizada.getCnpjFrnecedor());
            nota.setData_emissao(notaFiscalAtualizada.getData_emissao());
            nota.setData_movimentacao(notaFiscalAtualizada.getData_movimentacao());
            nota.setValorFinal(notaFiscalAtualizada.getValorFinal());
            return repository.save(nota);
        }).orElseThrow(() -> new RuntimeException("Nota Fiscal não encontrada com o ID: " + id));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}