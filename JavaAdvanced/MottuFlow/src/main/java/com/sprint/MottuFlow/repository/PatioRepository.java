package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatioRepository extends JpaRepository<Patio, Long> {
    @Query("SELECT p FROM Patio p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Patio> findByNome(@Param("nome") String nome);
    
    @Query("SELECT p FROM Patio p WHERE LOWER(p.endereco) LIKE LOWER(CONCAT('%', :endereco, '%'))")
    List<Patio> findByEndereco(@Param("endereco") String endereco);
}
