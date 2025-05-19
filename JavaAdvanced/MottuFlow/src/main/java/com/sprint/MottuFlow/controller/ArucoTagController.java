package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.ArucoTagDTO;
import com.sprint.MottuFlow.model.ArucoTag;
import com.sprint.MottuFlow.service.ArucoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aruco-tags")
public class ArucoTagController {

    @Autowired
    private ArucoTagService arucoTagService;

    private ArucoTagDTO convertToDTO(ArucoTag tag) {
        return new ArucoTagDTO(
                tag.getIdTag(),
                tag.getCodigo(),
                tag.getMoto().getIdMoto(),
                tag.getStatus()
        );
    }

    private ArucoTag convertToEntity(ArucoTagDTO dto) {
        ArucoTag tag = new ArucoTag();
        tag.setIdTag(dto.getIdTag());
        tag.setCodigo(dto.getCodigo());

        if (dto.getIdMoto() != 0) {
            var moto = new com.sprint.MottuFlow.model.Moto();
            moto.setIdMoto(dto.getIdMoto());
            tag.setMoto(moto);
        }
        tag.setStatus(dto.getStatus());
        return tag;
    }

    @GetMapping
    public List<ArucoTagDTO> getAll() {
        List<ArucoTag> tags = arucoTagService.findAll();
        return tags.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArucoTagDTO> getById(@PathVariable Long id) {
        ArucoTag tag = arucoTagService.findById(id);
        return ResponseEntity.ok(convertToDTO(tag));
    }

    @PostMapping
    public ResponseEntity<ArucoTagDTO> create(@RequestBody ArucoTagDTO tagDTO) {
        ArucoTag tag = convertToEntity(tagDTO);
        ArucoTag saved = arucoTagService.save(tag);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArucoTagDTO> update(@PathVariable Long id, @RequestBody ArucoTagDTO tagDTO) {
        ArucoTag tagDetails = convertToEntity(tagDTO);
        ArucoTag updated = arucoTagService.update(id, tagDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        arucoTagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
