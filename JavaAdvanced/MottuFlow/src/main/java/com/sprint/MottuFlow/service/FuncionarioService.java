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
    private FuncionarioRepository fR;

    public List<Funcionario> findAllFuncionario() {
        return fR.findAll();
    }

    public Funcionario findByIdFuncionario(Long id) {
        return fR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id: " + id));
    }
    
    public Funcionario findCpfFuncionario(String cpf) {
        return fR.findByCpfNative(cpf);
    }

    public Funcionario saveFuncionario(Funcionario funcionario) {
        return fR.save(funcionario);
    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = findByIdFuncionario(id);

        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setCpf(funcionarioAtualizado.getCpf());
        funcionario.setCargo(funcionarioAtualizado.getCargo());
        funcionario.setTelefone(funcionarioAtualizado.getTelefone());
        funcionario.setUsuario(funcionarioAtualizado.getUsuario());
        funcionario.setSenha(funcionarioAtualizado.getSenha());

        return fR.save(funcionario);
    }

    public void deleteByIdFuncionario(Long id) {
        Funcionario funcionario = findByIdFuncionario(id);
        fR.delete(funcionario);
    }
}
