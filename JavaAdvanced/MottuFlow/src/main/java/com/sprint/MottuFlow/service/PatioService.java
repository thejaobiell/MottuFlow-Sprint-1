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
    private PatioRepository pR;

    public List<Patio> findAll() {
        return pR.findAll();
    }

    public Patio findByIdPatio(Long id) {
        return pR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patio não encontrado com id: " + id));
    }
    
    public List<Patio> findByEnderecoPatio(String endereco) {
        return pR.findByEndereco(endereco);
    }

    public Patio savePatio(Patio patio) {
        return pR.save(patio);
    }

    public Patio updatePatio(Long id, Patio patioDetails) {
        Patio patio = findByIdPatio(id);

        patio.setNome(patioDetails.getNome());
        patio.setEndereco(patioDetails.getEndereco());
        patio.setCapacidadeMaxima(patioDetails.getCapacidadeMaxima());
        
        return pR.save(patio);
    }

    public void deletePatioPatio(Long id) {
        Patio patio = pR.findById(id).orElseThrow();
        patio.getMotos().size();
        patio.getCameras().size();
        patio.getLocalidades().size();

        pR.delete(patio);
    }

}
