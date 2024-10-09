package com.example.demo.controllers;

import com.example.demo.entities.Endereco;
import com.example.demo.entities.Localizacao;
import com.example.demo.facade.EnderecoFacade;
import com.example.demo.facade.LocalizacaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class EnderecoController {

    private final EnderecoFacade enderecoFacade;

    @Autowired
    public EnderecoController(EnderecoFacade EnderecoFacade) {
        this.enderecoFacade = enderecoFacade;
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> endereco = this.enderecoFacade.findAll();

        return new ResponseEntity<>(endereco, HttpStatus.OK);
}
    @GetMapping("/findById/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable int id) {
        Endereco endereco = this.enderecoFacade.findById(id);

        if (endereco == null)
            return new ResponseEntity<Endereco>(endereco, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        Endereco enderecoSaved = enderecoFacade.save(endereco);

        return new ResponseEntity<Endereco>(enderecoSaved, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Endereco> update(
            @PathVariable int id,
            @RequestBody Endereco endereco) {

        Endereco enderecoUpdated = enderecoFacade.update(id, endereco);

        if (enderecoUpdated == null)
            return new ResponseEntity<Endereco>(enderecoUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Endereco>(enderecoUpdated, HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        enderecoFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}