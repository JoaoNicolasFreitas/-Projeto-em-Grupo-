package com.example.demo.applications;

import com.example.demo.entities.Pagamento;
import com.example.demo.interfaces.IPagamentoInterface;
import com.example.demo.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoApplication {

    private final IPagamentoInterface pagamentosRepository;

    @Autowired
    public PagamentoApplication(PagamentoRepository pagamentoRepository) {
        this.pagamentosRepository = pagamentoRepository;
    }

    public List<Pagamento> findAll() {
        return this.pagamentosRepository.findAll();
    }

    public Pagamento findById(int id){ return this.pagamentosRepository.findById(id); }

    public Pagamento save(Pagamento pagamento){ return this.pagamentosRepository.save(pagamento);}

    public Pagamento update(int id, Pagamento pagamento) {
        Pagamento pagamentoInDb = pagamentosRepository.findById(id);

        if (pagamentoInDb == null) return null;

        return this.pagamentosRepository.update(id, pagamento);
    }
    public void deleteById(int id) { this.pagamentosRepository.deleteById(id);}

}

