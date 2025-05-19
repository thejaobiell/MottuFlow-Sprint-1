package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.Funcionario;
import com.sprint.MottuFlow.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id: " + id));
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(long id, Funcionario funcionarioDetails) {
        Funcionario funcionario = findById(id);

        funcionario.setNome(funcionarioDetails.getNome());
        funcionario.setCpf(funcionarioDetails.getCpf());
        funcionario.setCargo(funcionarioDetails.getCargo());
        funcionario.setTelefone(funcionarioDetails.getTelefone());
        funcionario.setUsuario(funcionarioDetails.getUsuario());
        funcionario.setSenha(funcionarioDetails.getSenha());

        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(long id) {
        Funcionario funcionario = findById(id);
        funcionarioRepository.delete(funcionario);
    }
}
