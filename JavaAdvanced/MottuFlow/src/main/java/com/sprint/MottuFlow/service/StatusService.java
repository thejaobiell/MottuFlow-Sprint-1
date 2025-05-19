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
    private StatusRepository sR;

    @Autowired
    private MotoRepository mR;

    @Autowired
    private FuncionarioRepository fR;

    public List<Status> findAllStatus() {
        return sR.findAll();
    }

    public Status findByIdStatus(Long id) {
        return sR.findById(id).orElseThrow(() -> new ResourceNotFoundException("Status não encontrado com id: " + id));
    }
    
    public List<Status> findByTipoStatus(String tipoStatus) {
        return sR.findByTipoStatus(tipoStatus);
    }

    public List<Status> findByDescricaoStatus(String descricao) {
        return sR.findByDescricao(descricao);
    }


    public Status saveStatus(Status status) {
        Moto moto = mR.findById(status.getMoto().getIdMoto()).orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + status.getMoto().getIdMoto()));

        Funcionario funcionario = fR.findById(status.getFuncionario().getId()).orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id: " + status.getFuncionario().getId()));

        status.setMoto(moto);
        status.setFuncionario(funcionario);

        return sR.save(status);
    }

    public Status updateStatus(Long id, Status statusAtualizado) {
        Status status = findByIdStatus(id);

        status.setTipoStatus(statusAtualizado.getTipoStatus());
        status.setDescricao(statusAtualizado.getDescricao());
        status.setDataStatus(statusAtualizado.getDataStatus());

        Moto moto = mR.findById(statusAtualizado.getMoto().getIdMoto()).orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com id: " + statusAtualizado.getMoto().getIdMoto()));

        Funcionario funcionario = fR.findById(statusAtualizado.getFuncionario().getId()).orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id: " + statusAtualizado.getFuncionario().getId()));

        status.setMoto(moto);
        status.setFuncionario(funcionario);

        return sR.save(status);
    }

    public void deleteByIdStatus(Long id) {
        Status status = findByIdStatus(id);
        sR.delete(status);
    }
}
