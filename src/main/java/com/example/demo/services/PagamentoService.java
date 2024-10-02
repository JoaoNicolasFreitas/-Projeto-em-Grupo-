package com.example.demo.services;

import com.example.demo.entities.Pagamento;
import com.example.demo.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Adicione esta anotação para tornar a classe um serviço Spring
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> buscarTodosPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public boolean deletarPagamento(Long id) {
        if (pagamentoRepository.existsById(id)) {
            pagamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Pagamento> atualizarPagamento(Long id, Pagamento pagamentoAtualizado) {
        if (pagamentoRepository.existsById(id)) {
            pagamentoAtualizado.setPagamentoID(id); // Certifique-se de que o ID é atualizado
            return Optional.of(pagamentoRepository.save(pagamentoAtualizado));
        }
        return Optional.empty();
    }
}
