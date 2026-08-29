package com.empresa.gollinho.controller;

import com.empresa.gollinho.model.Fardo;
import com.empresa.gollinho.service.FardoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fardos")
public class FardoController {

    @Autowired
    private final FardoService service;

    public FardoController(FardoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Fardo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fardo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Fardo> criar(@RequestBody Fardo fardo) {
        Fardo novoFardo = service.salvar(fardo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFardo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fardo> atualizar(@PathVariable Long id, @RequestBody Fardo fardo) {
        try {
            Fardo fardoAtualizado = service.atualizar(id, fardo);
            return ResponseEntity.ok(fardoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}