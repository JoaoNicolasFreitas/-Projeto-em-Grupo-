package com.example.demo.services;

import com.example.demo.entities.MetodoPagamento;
import com.example.demo.repositories.MetodoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentos {

    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;

    // Método para salvar uma nova forma de pagamento
    public MetodoPagamento salvarMetodoPagamento(MetodoPagamento metodoPagamento) {
        return metodoPagamentoRepository.save(metodoPagamento);
    }

    // Método para listar todas as formas de pagamento
    public List<MetodoPagamento> listarMetodosPagamentos() {
        return metodoPagamentoRepository.findAll();
    }

    // Método para buscar uma forma de pagamento pelo ID
    public Optional<MetodoPagamento> buscarMetodoPagamentoPorId(Long id) {
        return metodoPagamentoRepository.findById(id);
    }

    // Método para deletar uma forma de pagamento pelo ID
    public boolean deletarMetodoPagamento(Long id) {
        if (metodoPagamentoRepository.existsById(id)) {
            metodoPagamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
