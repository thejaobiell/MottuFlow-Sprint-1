package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.PatioDTO;
import com.sprint.MottuFlow.model.Patio;
import com.sprint.MottuFlow.service.PatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patios")
public class PatioController {

    @Autowired
    private PatioService patioService;

    private PatioDTO convertToDTO(Patio patio) {
        return new PatioDTO(
                patio.getIdPatio(),
                patio.getNome(),
                patio.getEndereco(),
                patio.getCapacidadeMaxima()
        );
    }

    private Patio convertToEntity(PatioDTO dto) {
        Patio patio = new Patio();
        patio.setIdPatio(dto.getIdPatio());
        patio.setNome(dto.getNome());
        patio.setEndereco(dto.getEndereco());
        patio.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        return patio;
    }

    @GetMapping
    public List<PatioDTO> getAll() {
        List<Patio> patios = patioService.findAll();
        return patios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioDTO> getById(@PathVariable Long id) {
        Patio patio = patioService.findById(id);
        return ResponseEntity.ok(convertToDTO(patio));
    }

    @PostMapping
    public ResponseEntity<PatioDTO> create(@RequestBody PatioDTO patioDTO) {
        Patio patio = convertToEntity(patioDTO);
        Patio saved = patioService.save(patio);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioDTO> update(@PathVariable Long id, @RequestBody PatioDTO patioDTO) {
        Patio patioDetails = convertToEntity(patioDTO);
        Patio updated = patioService.update(id, patioDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patioService.deletePatio(id);
        return ResponseEntity.noContent().build();
    }
}
