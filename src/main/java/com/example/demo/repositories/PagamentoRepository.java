package com.example.demo.repositories;

import com.example.demo.entities.Pagamento;
import com.example.demo.intefaces.IPagamentoInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoRepository implements IPagamentoInterface {
    @Override
    public List<Pagamento> findAll() {
        return List.of();
    }

    @Override
    public Pagamento findById(int id) {
        return null;
    }

    @Override
    public Pagamento save(Pagamento pagamento) {
        return null;
    }

    @Override
    public Pagamento update(int id, Pagamento base) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
