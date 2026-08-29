package com.empresa.gollinho.service;

import com.empresa.gollinho.model.ItemNF;
import com.empresa.gollinho.repository.ItemNFRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemNFService {

    @Autowired
    private ItemNFRepository itemNFRepository;

    // CREATE - Salvar um novo ItemNF
    public ItemNF criar(ItemNF itemNF) {
        itemNF.setId(null);

        return itemNFRepository.save(itemNF);
    }

    // READ - Listar todos os ItemNF
    public List<ItemNF> listarTodos() {
        return itemNFRepository.findAll();
    }

    // READ - Buscar um ItemNF por ID
    public ItemNF buscarPorId(Long id) {
        return itemNFRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "ItemNF não encontrado com o ID: " + id
                        ));
    }

    // UPDATE - Atualizar um ItemNF existente
    public ItemNF atualizar(Long id, ItemNF itemNFAtualizado) {

        ItemNF itemExistente = buscarPorId(id);

        itemExistente.setValorTotal(itemNFAtualizado.getValorTotal());
        itemExistente.setQtdLitros(itemNFAtualizado.getQtdLitros());
        itemExistente.setNotaFiscal(itemNFAtualizado.getNotaFiscal());

        return itemNFRepository.save(itemExistente);
    }

    // DELETE - Remover um ItemNF por ID
    public void deletar(Long id) {

        ItemNF itemExistente = buscarPorId(id);

        itemNFRepository.delete(itemExistente);
    }
}