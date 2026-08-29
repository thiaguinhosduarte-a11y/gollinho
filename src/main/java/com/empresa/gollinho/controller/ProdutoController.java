package com.empresa.gollinho.controller;

import com.empresa.gollinho.model.Produto;
import com.empresa.gollinho.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.cadastrar(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
}
