package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.SolicitanteEntity;
import org.springframework.data.repository.CrudRepository;
public interface SolicitanteCrudRepository extends CrudRepository<SolicitanteEntity, Integer> {
    SolicitanteEntity findByUsuarioId(Integer usuarioId);
}