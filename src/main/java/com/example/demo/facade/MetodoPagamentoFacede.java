package com.example.demo.facade;

import com.example.demo.applications.MetodoPagamentoApplication;
import com.example.demo.entities.MetodoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetodoPagamentoFacade {

    private final MetodoPagamentoApplication pagamentoApplication;

    @Autowired
    public MetodoPagamentoFacade(MetodoPagamentoApplication pagamentoApplication) {
        this.pagamentoApplication = pagamentoApplication;
    }

    public void deleteById(int id) {
        this.pagamentoApplication.deleteById(id);
    }

    public MetodoPagamento update(int id, MetodoPagamento metodoPagamento) {
        return this.pagamentoApplication.update(id, metodoPagamento);
    }

    public MetodoPagamento findById(int id) {
        return this.pagamentoApplication.findById(id);
    }

    public List<MetodoPagamento> findAll() {
        return this.pagamentoApplication.findAll();
    }

    public MetodoPagamento save(MetodoPagamento metodoPagamento) {
        return this.pagamentoApplication.save(metodoPagamento);
    }
}
