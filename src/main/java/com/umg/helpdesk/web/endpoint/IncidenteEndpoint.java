package com.umg.helpdesk.web.endpoint;
import com.umg.helpdesk.domain.service.IncidenteService;
import com.umg.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint

public class IncidenteEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final IncidenteService incidenteService;

    @Autowired
    public IncidenteEndpoint(IncidenteService incidenteService) {
        this.incidenteService = incidenteService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIncidenteByIdRequest")
    @ResponsePayload
    public GetIncidenteByIdResponse getIncidente (@RequestPayload GetIncidenteByIdRequest request) {
        GetIncidenteByIdResponse response = new GetIncidenteByIdResponse();
        Incidente incidente = incidenteService.getById(request.getIncidenteId());
        response.setIncidente(incidente);
        return response;
    }/*
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIncidenteByTipoRequest")
    @ResponsePayload
    public GetIncidenteByIdRequest getIncidente (@RequestPayload GetIncidenteByIdResponse  request) {
        GetIncidenteByIdResponse response = new GetIncidenteByIdResponse();
        Incidente incidente = incidenteService.getByTipo(request.getByTipo());
        response.getByTipo(incidente);
        return response;
    }*/

}
