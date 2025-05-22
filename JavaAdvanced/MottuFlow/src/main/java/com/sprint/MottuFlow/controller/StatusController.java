package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.StatusDTO;
import com.sprint.MottuFlow.model.Status;
import com.sprint.MottuFlow.service.StatusService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService sS;

    private StatusDTO convertToDTO(Status status) {
        return new StatusDTO(
                status.getIdStatus(),
                status.getMoto().getIdMoto(),
                status.getTipoStatus(),
                status.getDescricao(),
                status.getDataStatus(),
                status.getFuncionario().getId()
        );
    }

    private Status convertToEntity(StatusDTO dto) {
        Status status = new Status();
        status.setIdStatus(dto.getIdStatus());
        status.setTipoStatus(dto.getTipoStatus());
        status.setDescricao(dto.getDescricao());
        status.setDataStatus(dto.getDataStatus());

        if (dto.getIdMoto() != 0) {
            var moto = new com.sprint.MottuFlow.model.Moto();
            moto.setIdMoto(dto.getIdMoto());
            status.setMoto(moto);
        }
        if (dto.getIdFuncionario() != 0) {
            var funcionario = new com.sprint.MottuFlow.model.Funcionario();
            funcionario.setId(dto.getIdFuncionario());
            status.setFuncionario(funcionario);
        }
        return status;
    }

    @GetMapping
    public List<StatusDTO> getAll() {
        List<Status> statuses = sS.findAllStatus();
        return statuses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StatusDTO> getById(@PathVariable Long id) {
        Status status = sS.findByIdStatus(id);
        return ResponseEntity.ok(convertToDTO(status));
    }
    
    @GetMapping("/tipo")
    public List<StatusDTO> getByTipoStatus(@RequestParam String tipoStatus) {
        List<Status> statuses = sS.findByTipoStatus(tipoStatus);
        return statuses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/descricao")
    public List<StatusDTO> getByDescricao(@RequestParam String descricao) {
        List<Status> statuses = sS.findByDescricaoStatus(descricao);
        return statuses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<StatusDTO> create(@RequestBody @Valid StatusDTO statusDTO) {
        Status status = convertToEntity(statusDTO);
        Status saved = sS.saveStatus(status);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> update(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        Status statusAtualizado = convertToEntity(statusDTO);
        Status updated = sS.updateStatus(id, statusAtualizado);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sS.deleteByIdStatus(id);
        return ResponseEntity.noContent().build();
    }
}
