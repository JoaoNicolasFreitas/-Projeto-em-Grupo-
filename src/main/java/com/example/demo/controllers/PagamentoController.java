package com.example.demo.controllers;

import com.example.demo.entities.Pagamento;
import com.example.demo.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // Endpoint para salvar um pagamento
    @PostMapping
    public Pagamento salvarPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.salvarPagamento(pagamento);
    }

    // Endpoint para listar todos os pagamentos
    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.buscarTodosPagamentos();
    }

    // Endpoint para buscar um pagamento pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@PathVariable Long id) {
        return pagamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um pagamento pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        if (pagamentoService.deletarPagamento(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para atualizar um pagamento
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamentoAtualizado) {
        return pagamentoService.atualizarPagamento(id, pagamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
