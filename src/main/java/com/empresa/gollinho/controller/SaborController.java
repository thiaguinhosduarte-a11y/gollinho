package com.empresa.gollinho.controller;

import com.empresa.gollinho.model.Sabor;
import com.empresa.gollinho.services.SaborService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sabores")
public class SaborController {

    private final SaborService saborService;

    public SaborController(SaborService saborService) {
        this.saborService = saborService;
    }

    @PostMapping
    public ResponseEntity<Sabor> cadastrar(@RequestBody Sabor sabor) {

        Sabor saborSalvo = saborService.cadastrar(sabor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saborSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Sabor>> listarTodos() {

        return ResponseEntity.ok(
                saborService.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sabor> buscarPorId(@PathVariable Long id) {

        return saborService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sabor> atualizar(
            @PathVariable Long id,
            @RequestBody Sabor sabor) {

        try {

            Sabor saborAtualizado =
                    saborService.atualizar(id, sabor);

            return ResponseEntity.ok(saborAtualizado);

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        try {

            saborService.deletar(id);

            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
        }
    }
}
