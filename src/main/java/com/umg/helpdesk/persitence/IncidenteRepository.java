package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.IncidenteCrudRepository;
import com.umg.helpdesk.persitence.entity.IncidenteEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncidenteRepository {
    private IncidenteCrudRepository incidenteCrudRepository;

    public IncidenteRepository(IncidenteCrudRepository incidenteCrudRepository) {
        this.incidenteCrudRepository = incidenteCrudRepository;
    }

    public IncidenteEntity getById(Integer id) {
        return incidenteCrudRepository.findById(id).orElse(null);
    }

    public List<IncidenteEntity> getAll() {
        return (List<IncidenteEntity>) incidenteCrudRepository.findAll();
    }

    public IncidenteEntity save(IncidenteEntity incidente) {
        return incidenteCrudRepository.save(incidente);
    }

    public void delete(Integer id) {
        incidenteCrudRepository.deleteById(id);
    }
}
