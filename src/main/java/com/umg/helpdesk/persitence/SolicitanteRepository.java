package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.SolicitanteCrudRepository;
import com.umg.helpdesk.persitence.entity.SolicitanteEntity;
import org.springframework.stereotype.Repository;

@Repository
public class SolicitanteRepository {
    private SolicitanteCrudRepository solicitanteCrudRepository;
    public SolicitanteEntity getById(Integer id) {
        return solicitanteCrudRepository.findById(id).orElse(null);}
}
