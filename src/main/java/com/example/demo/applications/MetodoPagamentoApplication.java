package com.example.demo.applications;

import com.example.demo.entities.MetodoPagamento;
import com.example.demo.intefaces.IMetodoPagamentoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MetodoPagamentoApplication {

    private final IMetodoPagamentoInterface metodoPagamentoRepository;

    @Autowired
    public MetodoPagamentoApplication(IMetodoPagamentoInterface metodoPagamentoRepository) {
        this.metodoPagamentoRepository = metodoPagamentoRepository;
    }

    public List<MetodoPagamento> findAll() {
        return this.metodoPagamentoRepository.findAll();
    }

    public Optional<MetodoPagamento> findById(int id) {
        return Optional.ofNullable(this.metodoPagamentoRepository.findById(id));
    }

    public MetodoPagamento save(MetodoPagamento metodoPagamento) {
        return this.metodoPagamentoRepository.save(metodoPagamento);
    }

    public MetodoPagamento update(int id, MetodoPagamento metodoPagamento) {
        Optional<MetodoPagamento> metodoPagamentoInDb = findById(id);

        if (metodoPagamentoInDb.isEmpty()) return null;

        return this.metodoPagamentoRepository.update(id, metodoPagamento);
    }

    public void deleteById(int id) {
        this.metodoPagamentoRepository.deleteById(id);
    }
}
