package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.LocalidadeDTO;
import com.sprint.MottuFlow.model.Localidade;
import com.sprint.MottuFlow.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadeController {

    @Autowired
    private LocalidadeService localidadeService;

    private LocalidadeDTO convertToDTO(Localidade localidade) {
        return new LocalidadeDTO(
                localidade.getIdLocalidade(),
                localidade.getDataHora(),
                localidade.getMoto().getIdMoto(),
                localidade.getPatio().getIdPatio(),
                localidade.getPontoReferencia(),
                localidade.getCamera().getIdCamera()
        );
    }

    private Localidade convertToEntity(LocalidadeDTO dto) {
        Localidade localidade = new Localidade();
        localidade.setIdLocalidade(dto.getIdLocalidade());
        localidade.setDataHora(dto.getDataHora());
        localidade.setPontoReferencia(dto.getPontoReferencia());

        if (dto.getIdMoto() != 0) {
            var moto = new com.sprint.MottuFlow.model.Moto();
            moto.setIdMoto(dto.getIdMoto());
            localidade.setMoto(moto);
        }
        if (dto.getIdPatio() != 0) {
            var patio = new com.sprint.MottuFlow.model.Patio();
            patio.setIdPatio(dto.getIdPatio());
            localidade.setPatio(patio);
        }
        if (dto.getIdCamera() != 0) {
            var camera = new com.sprint.MottuFlow.model.Camera();
            camera.setIdCamera(dto.getIdCamera());
            localidade.setCamera(camera);
        }

        return localidade;
    }

    @GetMapping
    public List<LocalidadeDTO> getAll() {
        List<Localidade> localidades = localidadeService.findAll();
        return localidades.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> getById(@PathVariable Long id) {
        Localidade localidade = localidadeService.findById(id);
        return ResponseEntity.ok(convertToDTO(localidade));
    }

    @PostMapping
    public ResponseEntity<LocalidadeDTO> create(@RequestBody LocalidadeDTO localidadeDTO) {
        Localidade localidade = convertToEntity(localidadeDTO);
        Localidade saved = localidadeService.save(localidade);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> update(@PathVariable Long id, @RequestBody LocalidadeDTO localidadeDTO) {
        Localidade localidadeDetails = convertToEntity(localidadeDTO);
        Localidade updated = localidadeService.update(id, localidadeDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        localidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
