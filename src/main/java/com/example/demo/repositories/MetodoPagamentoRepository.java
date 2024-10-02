package com.example.demo.repositories;

import com.example.demo.entities.MetodoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamento, Long> {
}
