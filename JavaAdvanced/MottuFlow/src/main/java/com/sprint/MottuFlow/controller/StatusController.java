package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.StatusDTO;
import com.sprint.MottuFlow.model.Status;
import com.sprint.MottuFlow.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

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
        List<Status> statuses = statusService.findAll();
        return statuses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getById(@PathVariable Long id) {
        Status status = statusService.findById(id);
        return ResponseEntity.ok(convertToDTO(status));
    }

    @PostMapping
    public ResponseEntity<StatusDTO> create(@RequestBody StatusDTO statusDTO) {
        Status status = convertToEntity(statusDTO);
        Status saved = statusService.save(status);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> update(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        Status statusDetails = convertToEntity(statusDTO);
        Status updated = statusService.update(id, statusDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
