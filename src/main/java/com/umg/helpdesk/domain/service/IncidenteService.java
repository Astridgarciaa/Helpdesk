package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.IncidenteRepository;
import com.umg.helpdesk.persitence.entity.IncidenteEntity;
import com.umg.soapservice.Incidente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenteService {
    private final IncidenteRepository incidenteRepository;

    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }
// Buscar incidente por Id
    public Incidente getById(int incidenteId) {
        IncidenteEntity incidenteEntity = incidenteRepository.getById(incidenteId);
        Incidente incidente = new Incidente();
        incidente.setIncidenteId(incidenteEntity.getIncidenteId());
        incidente.setNombre(incidenteEntity.getNombre());
        incidente.setDescripcion(incidenteEntity.getDescripcion());
        incidente.setTipo(incidenteEntity.getTipo());
        incidente.setSla(incidenteEntity.getSla());
        return incidente;
    }

    //Buscar incidente por Tipo
    public List<Incidente> getByTipo(String tipo) {
        List<IncidenteEntity> incidentesEntity= incidenteRepository.findByTipo(tipo);
        List<Incidente> incidentes = new ArrayList<>();
        incidentesEntity.forEach((incidenteEntity -> {
            Incidente incidente = new Incidente();
            incidente.setIncidenteId(incidenteEntity.getIncidenteId());
            incidente.setNombre(incidenteEntity.getNombre());
            incidente.setDescripcion(incidenteEntity.getDescripcion());
            incidente.setTipo(incidenteEntity.getTipo());
            incidente.setSla(incidenteEntity.getSla());
            incidentes.add(incidente);
        }));
        return incidentes;
    }
}
