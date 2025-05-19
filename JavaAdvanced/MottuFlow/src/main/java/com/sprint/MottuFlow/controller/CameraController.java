package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.CameraDTO;
import com.sprint.MottuFlow.model.Camera;
import com.sprint.MottuFlow.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cameras")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    private CameraDTO convertToDTO(Camera camera) {
        return new CameraDTO(
                camera.getIdCamera(),
                camera.getStatusOperacional(),
                camera.getLocalizacaoFisica(),
                camera.getPatio().getIdPatio()
        );
    }

    private Camera convertToEntity(CameraDTO dto) {
        Camera camera = new Camera();
        camera.setIdCamera(dto.getIdCamera());
        camera.setStatusOperacional(dto.getStatusOperacional());
        camera.setLocalizacaoFisica(dto.getLocalizacaoFisica());

        if (dto.getIdPatio() != 0) {
            var patio = new com.sprint.MottuFlow.model.Patio();
            patio.setIdPatio(dto.getIdPatio());
            camera.setPatio(patio);
        }
        return camera;
    }

    @GetMapping
    public List<CameraDTO> getAll() {
        List<Camera> cameras = cameraService.findAll();
        return cameras.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CameraDTO> getById(@PathVariable Long id) {
        Camera camera = cameraService.findById(id);
        return ResponseEntity.ok(convertToDTO(camera));
    }

    @PostMapping
    public ResponseEntity<CameraDTO> create(@RequestBody CameraDTO cameraDTO) {
        Camera camera = convertToEntity(cameraDTO);
        Camera saved = cameraService.save(camera);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CameraDTO> update(@PathVariable Long id, @RequestBody CameraDTO cameraDTO) {
        Camera cameraDetails = convertToEntity(cameraDTO);
        Camera updated = cameraService.update(id, cameraDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cameraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
