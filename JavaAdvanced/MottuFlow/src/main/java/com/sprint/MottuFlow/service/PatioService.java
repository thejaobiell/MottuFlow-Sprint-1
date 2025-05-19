package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.Patio;
import com.sprint.MottuFlow.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    public List<Patio> findAll() {
        return patioRepository.findAll();
    }

    public Patio findById(Long id) {
        return patioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + id));
    }

    public Patio save(Patio patio) {
        return patioRepository.save(patio);
    }

    public Patio update(Long id, Patio patioDetails) {
        Patio patio = findById(id);

        patio.setNome(patioDetails.getNome());
        patio.setEndereco(patioDetails.getEndereco());
        patio.setCapacidadeMaxima(patioDetails.getCapacidadeMaxima());
        
        return patioRepository.save(patio);
    }

    public void deletePatio(Long id) {
        Patio patio = patioRepository.findById(id).orElseThrow();
        patio.getMotos().size();
        patio.getCameras().size();
        patio.getLocalidades().size();

        patioRepository.delete(patio);
    }

}
