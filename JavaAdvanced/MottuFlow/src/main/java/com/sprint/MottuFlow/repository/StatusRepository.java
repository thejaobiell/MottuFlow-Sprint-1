package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("SELECT s FROM Status s WHERE s.tipoStatus = :tipoStatus")
    List<Status> findByTipoStatus(@Param("tipoStatus") String tipoStatus);

    @Query(value = "SELECT * FROM status WHERE descricao LIKE %:descricao%", nativeQuery = true)
    List<Status> findByDescricao(@Param("descricao") String descricao);
}
