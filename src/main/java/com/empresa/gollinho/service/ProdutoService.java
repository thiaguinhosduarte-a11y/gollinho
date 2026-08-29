package com.empresa.gollinho.service;

import com.empresa.gollinho.model.Produto;
import com.empresa.gollinho.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {

            produto.setVolumeGarrafa(produtoAtualizado.getVolumeGarrafa());
            produto.setFardosPorPalete(produtoAtualizado.getFardosPorPalete());
            produto.setGarrafasPorFardo(produtoAtualizado.getGarrafasPorFardo());

            return produtoRepository.save(produto);

        }).orElseThrow(() ->
                new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
