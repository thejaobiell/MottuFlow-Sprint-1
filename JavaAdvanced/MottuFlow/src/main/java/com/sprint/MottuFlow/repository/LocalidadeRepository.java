package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

    @Query("SELECT l FROM Localidade l WHERE l.pontoReferencia LIKE %:ponto%")
    List<Localidade> findByPontoReferenciaContaining(@Param("ponto") String ponto);

    @Query(value = "SELECT * FROM localidade WHERE data_hora >= :dataInicio AND data_hora <= :dataFim", nativeQuery = true)
    List<Localidade> findBetweenDatesNative(@Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim);
}
