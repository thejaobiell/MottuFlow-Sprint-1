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
    private CameraRepository cameraRepository;

    @Autowired
    private PatioRepository patioRepository;

    public List<Camera> findAll() {
        return cameraRepository.findAll();
    }

    public Camera findById(Long id) {
        return cameraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camera não encontrada com id: " + id));
    }

    public Camera save(Camera camera) {
        Patio patio = patioRepository.findById(camera.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + camera.getPatio().getIdPatio()));
        camera.setPatio(patio);

        return cameraRepository.save(camera);
    }

    public Camera update(Long id, Camera cameraDetails) {
        Camera camera = findById(id);

        camera.setStatusOperacional(cameraDetails.getStatusOperacional());
        camera.setLocalizacaoFisica(cameraDetails.getLocalizacaoFisica());

        Patio patio = patioRepository.findById(cameraDetails.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + cameraDetails.getPatio().getIdPatio()));
        camera.setPatio(patio);

        return cameraRepository.save(camera);
    }

    public void deleteById(Long id) {
        Camera camera = findById(id);
        cameraRepository.delete(camera);
    }
}
