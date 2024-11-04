package com.example.demo.repositories;

import com.example.demo.entities.MetodoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamento, Integer>, IMetodoPagamentoInterface {
    // Additional custom methods can be defined here if needed
}
