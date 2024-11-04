package com.example.demo.controllers;

import com.example.demo.entities.MetodoPagamento;
import com.example.demo.facade.MetodoPagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodopagamento")
public class MetodoPagamentoController {

    private final MetodoPagamentoFacade pagamentoFacade;

    @Autowired
    public MetodoPagamentoController(MetodoPagamentoFacade pagamentoFacade) { // Fixed constructor name
        this.pagamentoFacade = pagamentoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<MetodoPagamento>> findAll() {
        List<MetodoPagamento> pagamento = pagamentoFacade.findAll();
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<MetodoPagamento> findById(@PathVariable int id) {
        MetodoPagamento pagamento = pagamentoFacade.findById(id);

        if (pagamento == null)
            return ResponseEntity.notFound().build(); // Simplified not found response

        return ResponseEntity.ok(pagamento);
    }

    @PostMapping("/save")
    public ResponseEntity<MetodoPagamento> save(@RequestBody MetodoPagamento pagamento) {
        MetodoPagamento pagamentoSaved = pagamentoFacade.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoSaved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MetodoPagamento> update(
            @PathVariable int id,
            @RequestBody MetodoPagamento pagamento) {

        MetodoPagamento pagamentoUpdated = pagamentoFacade.update(id, pagamento);

        if (pagamentoUpdated == null)
            return ResponseEntity.notFound().build(); // Simplified not found response

        return ResponseEntity.ok(pagamentoUpdated);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        pagamentoFacade.deleteById(id);
        return ResponseEntity.ok().build(); // Simplified response for void return
    }
}
