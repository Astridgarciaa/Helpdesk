package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.SolicitanteEntity;
import org.springframework.data.repository.CrudRepository;

public interface SolicitanteCrudRepository extends CrudRepository<SolicitanteEntity, Integer> {
    SolicitanteEntity findByCorreo(String correo); // Buscar solicitante por correo
    SolicitanteEntity findByUsuarioEntityByUsuarioId(Integer usuarioId); // Buscar solicitante por usuario id
}