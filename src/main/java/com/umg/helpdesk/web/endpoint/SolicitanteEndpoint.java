package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.SolicitanteService;
import com.umg.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SolicitanteEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final SolicitanteService solicitanteService;

    @Autowired
    public SolicitanteEndpoint(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSolicitanteByUsuarioIdRequest")
    @ResponsePayload
    public GetSolicitanteByUsuarioIdResponse getSolocitante(@RequestPayload GetSolicitanteByUsuarioIdRequest request) {
        GetSolicitanteByUsuarioIdResponse response = new GetSolicitanteByUsuarioIdResponse();
        Solicitante solicitante = solicitanteService.getSolicitanteByUsuarioId(request.getUsuarioId());
        response.setSolicitante(solicitante);
        return response;
}
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSolicitanteByCorreoRequest")
    @ResponsePayload
    public GetSolicitanteByCorreoResponse getSolicitante (@RequestPayload GetSolicitanteByCorreoRequest request) {
        GetSolicitanteByCorreoResponse response = new GetSolicitanteByCorreoResponse();
        Solicitante solicitante = solicitanteService.getSolicitanteByCorreo(request.getCorreo());
        response.setSolicitante(solicitante);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSolicitanteByIdRequest")
    @ResponsePayload
    public GetSolicitanteByIdResponse getSolicitante (@RequestPayload GetSolicitanteByIdRequest request) {
        GetSolicitanteByIdResponse response = new GetSolicitanteByIdResponse();
        Solicitante solicitante = solicitanteService.getSolicitanteById(request.getSolicitanteId());
        response.setSolicitante(solicitante);
        return response;
    }

}
