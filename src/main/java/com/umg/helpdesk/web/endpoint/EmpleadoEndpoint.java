package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.EmpleadoService;
import com.umg.soapservice.GetEmpleadoRequest;
import com.umg.soapservice.GetEmpleadoResponse;
import com.umg.soapservice.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmpleadoEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoEndpoint(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadoRequest")
    @ResponsePayload
    public GetEmpleadoResponse getEmpleado(@RequestPayload GetEmpleadoRequest request) {
        GetEmpleadoResponse response = new GetEmpleadoResponse();
        Empleado empleado = empleadoService.getById(request.getEmpleadoId());
        response.setEmpleado(empleado);
        return response;
    }
}
