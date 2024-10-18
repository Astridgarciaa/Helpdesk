package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.AtencionALaIncidenciaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AtencionALaIncidenciaCrudRepository extends CrudRepository<AtencionALaIncidenciaEntity, Integer> {
    List<AtencionALaIncidenciaEntity> findByTicketEntityTicketId(Integer ticketId); // Buscar atención por ID del ticket
}
