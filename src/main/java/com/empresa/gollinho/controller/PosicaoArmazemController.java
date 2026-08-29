package com.empresa.gollinho.controller;

import com.empresa.gollinho.model.PosicaoArmazem;
import com.empresa.gollinho.service.PosicaoArmazemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/posicoes-armazem", "/posicoes-armazem"})
public class PosicaoArmazemController {
    private final PosicaoArmazemService service;
    public PosicaoArmazemController(PosicaoArmazemService service) { this.service = service; }
    @GetMapping public List<PosicaoArmazem> listar() { return service.listarTodos(); }
    @GetMapping("/{id}") public ResponseEntity<PosicaoArmazem> buscar(@PathVariable Long id) { try { return ResponseEntity.ok(service.buscarPorId(id)); } catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
    @PostMapping public ResponseEntity<PosicaoArmazem> criar(@RequestBody PosicaoArmazem p) { return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(p)); }
    @PutMapping("/{id}") public ResponseEntity<PosicaoArmazem> atualizar(@PathVariable Long id, @RequestBody PosicaoArmazem p) { try { return ResponseEntity.ok(service.atualizar(id, p)); } catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
    @DeleteMapping("/{id}") public ResponseEntity<Void> deletar(@PathVariable Long id) { try { service.deletar(id); return ResponseEntity.noContent().build(); } catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
}
