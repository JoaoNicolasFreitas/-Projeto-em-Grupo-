package com.example.demo.intefaces;

import com.example.demo.entities.MetodoPagamento;
import com.example.demo.entities.MetodoPagamento;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.List;

public interface IMetodoPagamentoInterface {
    List<MetodoPagamento> findAll();

    MetodoPagamento findById(int id);

    MetodoPagamento save(MetodoPagamento pagamento);

    MetodoPagamento update(int id, MetodoPagamento base);

    void deleteById(int id);


@Repository
public class IMetodoPagamentoInterfaceImpl implements IMetodoPagamentoInterface {

    private final List<MetodoPagamento> pagamentos = new ArrayList<>();

    @Override
    public List<MetodoPagamento> findAll() {
        return new ArrayList<>(pagamentos);
    }

    @Override
    public MetodoPagamento findById(int id) {
        return pagamentos.stream()
                .filter(pagamento -> pagamento.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public MetodoPagamento save(MetodoPagamento pagamento) {
        pagamentos.add(pagamento);
        return pagamento;
    }

    @Override
    public MetodoPagamento update(int id, MetodoPagamento base) {
        MetodoPagamento existing = findById(id);
        if (existing != null) {
            pagamentos.remove(existing);
            pagamentos.add(base);
            return base;
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        pagamentos.removeIf(pagamento -> pagamento.getId() == id);
    }
  }
}