package com.example.demo.controllers;

import com.example.demo.entities.Pagamento;
import com.example.demo.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private PagamentoFacade pagamentoFacade;

    @Autowired
    public PagamentoController(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamento = this.pagamentoFacade.findAll();

        return new ResponseEntity<>(pagamento, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable int id) {
        Pagamento pagamento = this.pagamentoFacade.findById(id);

        if (pagamento == null)
            return new ResponseEntity<Pagamento>(pagamento, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Pagamento> save(@RequestBody Pagamento pagamento) {
        Pagamento pagamentoSaved = pagamentoFacade.save(pagamento);

        return new ResponseEntity<Pagamento>(pagamentoSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pagamento> update(
            @PathVariable int id,
            @RequestBody Pagamento pagamento) {

        Pagamento pagamentoUpdated = pagamentoFacade.update(id, pagamento);

        if (pagamentoUpdated == null)
            return new ResponseEntity<Pagamento>(pagamentoUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Pagamento>(pagamentoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        pagamentoFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
