package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    @Query("SELECT m FROM Moto m WHERE LOWER(m.fabricante) = LOWER(:fabricante)")
    List<Moto> findByFabricante(@Param("fabricante") String fabricante);
    
    @Query(value = "SELECT * FROM moto WHERE id_patio = :idPatio", nativeQuery = true)
    List<Moto> findByPatioIdNative(@Param("idPatio") long idPatio);
}
