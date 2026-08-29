package com.empresa.gollinho.controller;

import com.empresa.gollinho.model.ItemNF;
import com.empresa.gollinho.service.ItemNFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-nf")
public class ItemNFController {

    @Autowired
    private ItemNFService itemNFService;

    // CREATE - POST /api/itens-nf
    @PostMapping
    public ResponseEntity<ItemNF> criar(@RequestBody ItemNF itemNF) {
        ItemNF novoItem = itemNFService.criar(itemNF);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    // READ - GET /api/itens-nf
    @GetMapping
    public ResponseEntity<List<ItemNF>> listarTodos() {
        List<ItemNF> itens = itemNFService.listarTodos();
        return ResponseEntity.ok(itens);
    }

    // READ - GET /api/itens-nf/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ItemNF> buscarPorId(@PathVariable Long id) {
        ItemNF item = itemNFService.buscarPorId(id);
        return ResponseEntity.ok(item);
    }

    // UPDATE - PUT /api/itens-nf/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ItemNF> atualizar(@PathVariable Long id, @RequestBody ItemNF itemNFAtualizado) {
        ItemNF itemAtualizado = itemNFService.atualizar(id, itemNFAtualizado);
        return ResponseEntity.ok(itemAtualizado);
    }

    // DELETE - DELETE /api/itens-nf/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemNFService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}