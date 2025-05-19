package com.sprint.MottuFlow.service;

import com.sprint.MottuFlow.exception.ResourceNotFoundException;
import com.sprint.MottuFlow.model.Funcionario;
import com.sprint.MottuFlow.model.Moto;
import com.sprint.MottuFlow.model.Status;
import com.sprint.MottuFlow.repository.FuncionarioRepository;
import com.sprint.MottuFlow.repository.MotoRepository;
import com.sprint.MottuFlow.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Status findById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Status não encontrado com id: " + id));
    }

    public Status save(Status status) {
        Moto moto = motoRepository.findById(status.getMoto().getIdMoto())
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + status.getMoto().getIdMoto()));

        Funcionario funcionario = funcionarioRepository.findById(status.getFuncionario().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id: " + status.getFuncionario().getId()));

        status.setMoto(moto);
        status.setFuncionario(funcionario);

        return statusRepository.save(status);
    }

    public Status update(Long id, Status statusDetails) {
        Status status = findById(id);

        status.setTipoStatus(statusDetails.getTipoStatus());
        status.setDescricao(statusDetails.getDescricao());
        status.setDataStatus(statusDetails.getDataStatus());

        Moto moto = motoRepository.findById(statusDetails.getMoto().getIdMoto())
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + statusDetails.getMoto().getIdMoto()));

        Funcionario funcionario = funcionarioRepository.findById(statusDetails.getFuncionario().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id: " + statusDetails.getFuncionario().getId()));

        status.setMoto(moto);
        status.setFuncionario(funcionario);

        return statusRepository.save(status);
    }

    public void deleteById(Long id) {
        Status status = findById(id);
        statusRepository.delete(status);
    }
}
