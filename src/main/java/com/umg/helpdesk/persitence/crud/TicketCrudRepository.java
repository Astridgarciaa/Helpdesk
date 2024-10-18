package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketCrudRepository extends CrudRepository<TicketEntity, Integer> {
    List<TicketEntity> findByEstado(String estado);  // Buscar tickets por estado
    List<TicketEntity> findBySolicitanteEntitySolicitanteId(Integer solicitanteId); // Buscar tickets por ID del solicitante
}
