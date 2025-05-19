package com.sprint.MottuFlow.controller;

import com.sprint.MottuFlow.dto.MotoDTO;
import com.sprint.MottuFlow.model.Moto;
import com.sprint.MottuFlow.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;

    private MotoDTO convertToDTO(Moto moto) {
        return new MotoDTO(
                moto.getIdMoto(),
                moto.getPlaca(),
                moto.getModelo(),
                moto.getFabricante(),
                moto.getAno(),
                moto.getPatio().getIdPatio(),
                moto.getLocalizacaoAtual()
        );
    }

    private Moto convertToEntity(MotoDTO dto) {
        Moto moto = new Moto();
        moto.setIdMoto(dto.getIdMoto());
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setFabricante(dto.getFabricante());
        moto.setAno(dto.getAno());

        // Para setar o Patio, só setar o objeto com id, o serviço cuidará do findById
        if (dto.getIdPatio() != 0) {
            var patio = new com.sprint.MottuFlow.model.Patio();
            patio.setIdPatio(dto.getIdPatio());
            moto.setPatio(patio);
        }
        moto.setLocalizacaoAtual(dto.getLocalizacaoAtual());

        return moto;
    }

    @GetMapping
    public List<MotoDTO> getAll() {
        List<Moto> motos = motoService.findAll();
        return motos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> getById(@PathVariable Long id) {
        Moto moto = motoService.findById(id);
        return ResponseEntity.ok(convertToDTO(moto));
    }

    @PostMapping
    public ResponseEntity<MotoDTO> create(@RequestBody MotoDTO motoDTO) {
        Moto moto = convertToEntity(motoDTO);
        Moto saved = motoService.save(moto);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @RequestBody MotoDTO motoDTO) {
        Moto motoDetails = convertToEntity(motoDTO);
        Moto updated = motoService.update(id, motoDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        motoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
