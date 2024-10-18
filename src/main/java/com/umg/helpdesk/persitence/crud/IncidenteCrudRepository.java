package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.IncidenteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncidenteCrudRepository extends CrudRepository<IncidenteEntity, Integer> {
    List<IncidenteEntity> findByTipo(String tipo); // Buscar incidentes por tipo
}

