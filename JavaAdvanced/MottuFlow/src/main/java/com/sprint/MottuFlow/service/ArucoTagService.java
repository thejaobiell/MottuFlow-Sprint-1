package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.ArucoTag;
import com.sprint.MottuFlow.model.Moto;
import com.sprint.MottuFlow.repository.ArucoTagRepository;
import com.sprint.MottuFlow.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArucoTagService {

    @Autowired
    private ArucoTagRepository arucoTagRepository;

    @Autowired
    private MotoRepository motoRepository;

    public List<ArucoTag> findAll() {
        return arucoTagRepository.findAll();
    }

    public ArucoTag findById(Long id) {
        return arucoTagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ArucoTag não encontrada com id: " + id));
    }

    public ArucoTag save(ArucoTag arucoTag) {
        Moto moto = motoRepository.findById(arucoTag.getMoto().getIdMoto())
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + arucoTag.getMoto().getIdMoto()));
        arucoTag.setMoto(moto);

        return arucoTagRepository.save(arucoTag);
    }

    public ArucoTag update(Long id, ArucoTag arucoTagDetails) {
        ArucoTag arucoTag = findById(id);

        arucoTag.setCodigo(arucoTagDetails.getCodigo());
        arucoTag.setStatus(arucoTagDetails.getStatus());

        Moto moto = motoRepository.findById(arucoTagDetails.getMoto().getIdMoto())
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + arucoTagDetails.getMoto().getIdMoto()));
        arucoTag.setMoto(moto);

        return arucoTagRepository.save(arucoTag);
    }

    public void deleteById(Long id) {
        ArucoTag arucoTag = findById(id);
        arucoTagRepository.delete(arucoTag);
    }
}
