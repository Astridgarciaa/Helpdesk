package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.IncidenteService;
import com.umg.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class IncidenteEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final IncidenteService incidenteService;

    @Autowired
    public IncidenteEndpoint(IncidenteService incidenteService) {
        this.incidenteService = incidenteService;
    }

    // Endpoint para buscar incidente por ID
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIncidenteByIdRequest")
    @ResponsePayload
    public GetIncidenteByIdResponse getIncidenteById(@RequestPayload GetIncidenteByIdRequest request) {
        GetIncidenteByIdResponse response = new GetIncidenteByIdResponse();
        int incidenteId = request.getIncidenteId();
        Incidente incidente = incidenteService.getById(incidenteId);
        response.setIncidente(incidente);
        return response;
    }

    // Endpoint para buscar incidente por tipo
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIncidenteByTipoRequest")
    @ResponsePayload
    public GetIncidenteByTipoResponse getIncidenteByTipo(@RequestPayload GetIncidenteByTipoRequest request) {
        GetIncidenteByTipoResponse response = new GetIncidenteByTipoResponse();
        List<Incidente> incidentes = incidenteService.getByTipo(request.getTipo());
        response.getIncidente().addAll(incidentes);
        return response;
    }
}
