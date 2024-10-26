package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.EmpresaService;
import com.umg.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmpresaEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaEndpoint(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpresaByIdRequest")
    @ResponsePayload
    public GetEmpresaByIdResponse getEmpresaById(@RequestPayload GetEmpresaByIdRequest request) {
        GetEmpresaByIdResponse response = new GetEmpresaByIdResponse();
        Empresa empresa = empresaService.getById(request.getEmpresaId());
        response.setEmpresa(empresa);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpresaByNombreRequest")
    @ResponsePayload
    public GetEmpresaByNombreResponse getEmpresaByNombre(@RequestPayload GetEmpresaByNombreRequest request) {
        GetEmpresaByNombreResponse response = new GetEmpresaByNombreResponse();
        Empresa empresa = empresaService.getByNombre(request.getNombre());
        response.setEmpresa(empresa);
        return response;
    }
}
