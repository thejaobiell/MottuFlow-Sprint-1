package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query("SELECT f FROM Funcionario f WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Funcionario> findByNomeContainingIgnoreCase(@Param("nome") String nome);
    @Query(value = "SELECT * FROM funcionario WHERE cpf = :cpf", nativeQuery = true)
    Funcionario findByCpfNative(@Param("cpf") String cpf);
}
