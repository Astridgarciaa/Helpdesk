package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.AtencionALaIncidenciaService;
import com.umg.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class AtencionALaIncidenciaEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final AtencionALaIncidenciaService atencionALaIncidenciaService;

    @Autowired
    public AtencionALaIncidenciaEndpoint(AtencionALaIncidenciaService atencionALaIncidenciaService) {
        this.atencionALaIncidenciaService = atencionALaIncidenciaService;
    }

    // Endpoint para buscar atención a la incidencia por ID
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAtencionALaIncidenciaByIdRequest")
    @ResponsePayload
    public GetAtencionALaIncidenciaByIdResponse getAtencionALaIncidenciaById(@RequestPayload GetAtencionALaIncidenciaByIdRequest request) {
        GetAtencionALaIncidenciaByIdResponse response = new GetAtencionALaIncidenciaByIdResponse();
        AtencionALaIncidencia atencion = atencionALaIncidenciaService.getById(request.getAtencionId());
        response.setAtencionalancidencia(atencion);
        return response;
    }

    // Endpoint para buscar atención a la incidencia por ticket ID
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAtencionALaIncidenciaByticketIdRequest")
    @ResponsePayload
    public GetAtencionALaIncidenciaByticketIdResponse getAtencionALaIncidenciaByTicketId(@RequestPayload GetAtencionALaIncidenciaByticketIdRequest request) {
        GetAtencionALaIncidenciaByticketIdResponse response = new GetAtencionALaIncidenciaByticketIdResponse();
        List<AtencionALaIncidencia> atenciones = atencionALaIncidenciaService.getByTicketId(request.getTicketId());
        response.getAtencionalancidencia().addAll(atenciones);
        return response;
    }
}
