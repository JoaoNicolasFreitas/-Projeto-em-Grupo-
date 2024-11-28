package com.example.demo.facade;

import com.example.demo.applications.PagamentoApplication;
import com.example.demo.entities.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoFacade {

    private PagamentoApplication pagamentoApplication;

    @Autowired
    public PagamentoFacade(PagamentoApplication pagamentoApplication) {
        this.pagamentoApplication = pagamentoApplication;
    }

    public List<Pagamento> findAll() {
        return this.pagamentoApplication.findAll();
    }

    public Pagamento findById(int id) {
        return this.pagamentoApplication.findById(id);
    }

    public Pagamento save(Pagamento pagamento) {
        return this.pagamentoApplication.save(pagamento);
    }

    public Pagamento update(int id, Pagamento pagamento) {
        return this.pagamentoApplication.update(id, pagamento);
    }


    public void deleteById(int id) {
        this.pagamentoApplication.deleteById(id);
    }
}