package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.Camera;
import com.sprint.MottuFlow.model.Patio;
import com.sprint.MottuFlow.repository.CameraRepository;
import com.sprint.MottuFlow.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cR;

    @Autowired
    private PatioRepository pR;

    public List<Camera> findAllCamera() {
        return cR.findAll();
    }

    public Camera findByIdCamera(Long id) {
        return cR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camera não encontrada com id: " + id));
    }
    
    public List<Camera> findByStatusOperacional(String status) {
        return cR.findByStatusOperacional(status);
    }

    public List<Camera> findByLocalizacaoFisica(String localizacao) {
        return cR.findByLocalizacaoFisica(localizacao);
    }

    public Camera saveCamera(Camera camera) {
        Patio patio = pR.findById(camera.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + camera.getPatio().getIdPatio()));
        camera.setPatio(patio);

        return cR.save(camera);
    }

    public Camera updateCamera(Long id, Camera cameraAtualizado) {
        Camera camera = findByIdCamera(id);

        camera.setStatusOperacional(cameraAtualizado.getStatusOperacional());
        camera.setLocalizacaoFisica(cameraAtualizado.getLocalizacaoFisica());

        Patio patio = pR.findById(cameraAtualizado.getPatio().getIdPatio()).orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + cameraAtualizado.getPatio().getIdPatio()));
        camera.setPatio(patio);

        return cR.save(camera);
    }

    public void deleteByIdCamera(Long id) {
        Camera camera = findByIdCamera(id);
        cR.delete(camera);
    }
}
