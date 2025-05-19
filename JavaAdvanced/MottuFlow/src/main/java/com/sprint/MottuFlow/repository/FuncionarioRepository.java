package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    @Query(value = "SELECT * FROM funcionario WHERE cpf = :cpf", nativeQuery = true)
    Funcionario findByCpfNative(@Param("cpf") String cpf);
}
