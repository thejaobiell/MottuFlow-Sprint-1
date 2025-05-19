package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.Moto;
import com.sprint.MottuFlow.model.Patio;
import com.sprint.MottuFlow.repository.MotoRepository;
import com.sprint.MottuFlow.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PatioRepository patioRepository;

    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    public Moto findById(Long id) {
        return motoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + id));
    }

    public Moto save(Moto moto) {
        Patio patio = patioRepository.findById(moto.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + moto.getPatio().getIdPatio()));
        moto.setPatio(patio);

        return motoRepository.save(moto);
    }

    public Moto update(Long id, Moto motoDetails) {
        Moto moto = findById(id);

        moto.setPlaca(motoDetails.getPlaca());
        moto.setModelo(motoDetails.getModelo());
        moto.setFabricante(motoDetails.getFabricante());
        moto.setAno(motoDetails.getAno());
        moto.setLocalizacaoAtual(motoDetails.getLocalizacaoAtual());

        Patio patio = patioRepository.findById(motoDetails.getPatio().getIdPatio())
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + motoDetails.getPatio().getIdPatio()));
        moto.setPatio(patio);

        return motoRepository.save(moto);
    }

    public void deleteById(Long id) {
        Moto moto = findById(id);
        motoRepository.delete(moto);
    }
}
