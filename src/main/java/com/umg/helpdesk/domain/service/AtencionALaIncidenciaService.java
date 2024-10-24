package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.AtencionALaIncidenciaRepository;
import com.umg.helpdesk.persitence.entity.AtencionALaIncidenciaEntity;
import com.umg.soapservice.AtencionALaIncidencia;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtencionALaIncidenciaService {
    private final AtencionALaIncidenciaRepository atencionALaIncidenciaRepository;

    public AtencionALaIncidenciaService(AtencionALaIncidenciaRepository atencionALaIncidenciaRepository) {
        this.atencionALaIncidenciaRepository = atencionALaIncidenciaRepository;
    }

    // Buscar atención a la incidencia por ID
    public AtencionALaIncidencia getById(int atencionId) {
        AtencionALaIncidenciaEntity atencionEntity = atencionALaIncidenciaRepository.getById(atencionId);
        AtencionALaIncidencia atencion = new AtencionALaIncidencia();
        atencion.setAtencionId(atencionEntity.getAtencionId());
        atencion.setObservaciones(atencionEntity.getObservaciones());
     //   atencion.setFecha(atencionEntity.getFecha());
     //   atencion.setTicketId(atencionEntity.getTicketId());
        return atencion;
    }

    // Buscar atención a la incidencia por ticket ID
    public List<AtencionALaIncidencia> getByTicketId(int ticketId) {
        List<AtencionALaIncidenciaEntity> atencionesEntity = atencionALaIncidenciaRepository.findByTicketEntityTicketId(ticketId);
        List<AtencionALaIncidencia> atenciones = new ArrayList<>();

        atencionesEntity.forEach(atencionEntity -> {
            AtencionALaIncidencia atencion = new AtencionALaIncidencia();
            atencion.setAtencionId(atencionEntity.getAtencionId());
            atencion.setObservaciones(atencionEntity.getObservaciones());
        //    atencion.setFecha(atencionEntity.getFecha());
       //     atencion.setTicketId(atencionEntity.getTicketId());
            atenciones.add(atencion);
        });

        return atenciones;
    }
}
