package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.FuncionarioDTO;
import com.sprint.MottuFlow.model.Funcionario;
import com.sprint.MottuFlow.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService fS;

    private FuncionarioDTO convertToDTO(Funcionario funcionario) {
        return new FuncionarioDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getCargo(),
                funcionario.getTelefone(),
                funcionario.getUsuario(),
                funcionario.getSenha()
        );
    }

    private Funcionario convertToEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setUsuario(dto.getUsuario());
        funcionario.setSenha(dto.getSenha());
        return funcionario;
    }

    @GetMapping
    public List<FuncionarioDTO> getAll() {
        List<Funcionario> funcionarios = fS.findAllFuncionario();
        return funcionarios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FuncionarioDTO> getById(@PathVariable Long id) {
        Funcionario funcionario = fS.findByIdFuncionario(id);
        return ResponseEntity.ok(convertToDTO(funcionario));
    }
    
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> getByCpf(@PathVariable String cpf) {
        Funcionario funcionario = fS.findCpfFuncionario(cpf);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDTO(funcionario));
    }

    
    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = convertToEntity(funcionarioDTO);
        Funcionario saved = fS.saveFuncionario(funcionario);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionarioDetails = convertToEntity(funcionarioDTO);
        Funcionario updated = fS.updateFuncionario(id, funcionarioDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fS.deleteByIdFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
