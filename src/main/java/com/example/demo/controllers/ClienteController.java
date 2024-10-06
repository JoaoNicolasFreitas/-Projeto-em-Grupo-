package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.facade.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteFacade clienteFacade;

    @Autowired
    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> pagamento = this.clienteFacade.findAll();

        return new ResponseEntity<>(pagamento, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable int id) {
        Cliente cliente = this.clienteFacade.findById(id);

        if (cliente == null)
            return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente clienteSaved = clienteFacade.save(cliente);

        return new ResponseEntity<Cliente>(clienteSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> update(
            @PathVariable int id,
            @RequestBody Cliente cliente) {

        Cliente clienteUpdated = clienteFacade.update(id, cliente);

        if (clienteUpdated == null)
            return new ResponseEntity<Cliente>(clienteUpdated, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Cliente>(clienteUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        clienteFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
