package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.Camera;
import com.sprint.MottuFlow.model.Localidade;
import com.sprint.MottuFlow.model.Moto;
import com.sprint.MottuFlow.model.Patio;
import com.sprint.MottuFlow.repository.CameraRepository;
import com.sprint.MottuFlow.repository.LocalidadeRepository;
import com.sprint.MottuFlow.repository.MotoRepository;
import com.sprint.MottuFlow.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PatioRepository patioRepository;

    @Autowired
    private CameraRepository cameraRepository;

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Localidade findById(Long id) {
        return localidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Localidade não encontrada com id: " + id));
    }

    public Localidade save(Localidade localidade) {
        Moto moto = motoRepository.findById(localidade.getMoto().getIdMoto())
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + localidade.getMoto().getIdMoto()));

        Patio patio = patioRepository.findById(localidade.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + localidade.getPatio().getIdPatio()));

        Camera camera = cameraRepository.findById(localidade.getCamera().getIdCamera())
                .orElseThrow(() -> new ResourceNotFoundException("Camera não encontrada com id: " + localidade.getCamera().getIdCamera()));

        localidade.setMoto(moto);
        localidade.setPatio(patio);
        localidade.setCamera(camera);

        return localidadeRepository.save(localidade);
    }

    public Localidade update(Long id, Localidade localidadeDetails) {
        Localidade localidade = findById(id);

        localidade.setDataHora(localidadeDetails.getDataHora());
        localidade.setPontoReferencia(localidadeDetails.getPontoReferencia());

        Moto moto = motoRepository.findById(localidadeDetails.getMoto().getIdMoto())
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + localidadeDetails.getMoto().getIdMoto()));

        Patio patio = patioRepository.findById(localidadeDetails.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + localidadeDetails.getPatio().getIdPatio()));

        Camera camera = cameraRepository.findById(localidadeDetails.getCamera().getIdCamera())
                .orElseThrow(() -> new ResourceNotFoundException("Camera não encontrada com id: " + localidadeDetails.getCamera().getIdCamera()));

        localidade.setMoto(moto);
        localidade.setPatio(patio);
        localidade.setCamera(camera);

        return localidadeRepository.save(localidade);
    }

    public void deleteById(Long id) {
        Localidade localidade = findById(id);
        localidadeRepository.delete(localidade);
    }
}
