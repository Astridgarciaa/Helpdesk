package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.SolicitanteCrudRepository;
import com.umg.helpdesk.persitence.entity.SolicitanteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolicitanteRepository {
    private SolicitanteCrudRepository solicitanteCrudRepository;

    public SolicitanteRepository(SolicitanteCrudRepository solicitanteCrudRepository) {
        this.solicitanteCrudRepository = solicitanteCrudRepository;
    }

    public SolicitanteEntity getById(Integer id) {
        return solicitanteCrudRepository.findById(id).orElse(null);
    }

    public List<SolicitanteEntity> getAll() {
        return (List<SolicitanteEntity>) solicitanteCrudRepository.findAll();
    }

    public SolicitanteEntity save(SolicitanteEntity solicitante) {
        return solicitanteCrudRepository.save(solicitante);
    }
    public SolicitanteEntity findByCorreo(String correo){
        return solicitanteCrudRepository.findByCorreo(correo);
    }

    public SolicitanteEntity findByUsuarioEntityByUsuarioId(Integer usuarioId){
        return solicitanteCrudRepository.findByUsuarioEntityByUsuarioId ( usuarioId);
    }

    public void delete(Integer id) {
        solicitanteCrudRepository.deleteById(id);
    }


}
