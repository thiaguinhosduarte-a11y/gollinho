package com.empresa.gollinho.controller;

import com.empresa.gollinho.model.Movimentacao;
import com.empresa.gollinho.service.MovimentacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/movimentacoes", "/movimentacoes"})
public class MovimentacaoController {
    private final MovimentacaoService service;
    public MovimentacaoController(MovimentacaoService service) { this.service = service; }
    @GetMapping public List<Movimentacao> listar() { return service.listarTodos(); }
    @GetMapping("/{id}") public ResponseEntity<Movimentacao> buscar(@PathVariable Long id) { try { return ResponseEntity.ok(service.buscarPorId(id)); } catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
    @PostMapping public ResponseEntity<Movimentacao> criar(@RequestBody Movimentacao m) { return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(m)); }
    @PutMapping("/{id}") public ResponseEntity<Movimentacao> atualizar(@PathVariable Long id, @RequestBody Movimentacao m) { try { return ResponseEntity.ok(service.atualizar(id, m)); } catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
    @DeleteMapping("/{id}") public ResponseEntity<Void> deletar(@PathVariable Long id) { try { service.deletar(id); return ResponseEntity.noContent().build(); } catch (RuntimeException e) { return ResponseEntity.notFound().build(); } }
}
