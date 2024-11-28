package com.example.demo.interfaces;

import com.example.demo.entities.Pagamento;

import java.util.List;

public interface IPagamentoInterface {
    List<Pagamento> findAll();

    Pagamento findById(int id);

    Pagamento save(Pagamento pagamento);

    public Pagamento update(int id, Pagamento base);

    public void deleteById(int id);
}
