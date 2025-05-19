package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatioRepository extends JpaRepository<Patio, Long> {
    @Query("SELECT p FROM Patio p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Patio> findByNomeContainingIgnoreCase(@Param("nome") String nome);
    
    @Query(value = "SELECT COUNT(*) FROM patio WHERE capacidade_maxima > :capacidade", nativeQuery = true)
    int countByCapacidadeMaiorQue(@Param("capacidade") int capacidade);
}
