package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.EmpleadoService;

import com.umg.soapservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;


import java.util.List;

@Endpoint
public class EmpleadoEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final EmpleadoService empleadoService;
    private final DefaultWsdl11Definition empleados;

    @Autowired
    public EmpleadoEndpoint(EmpleadoService empleadoService, @Qualifier("empleados") DefaultWsdl11Definition empleados) {
        this.empleadoService = empleadoService;
        this.empleados = empleados;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadoByIdRequest")
    @ResponsePayload
    public GetEmpleadoByIdResponse getEmpleadoById(@RequestPayload GetEmpleadoByIdRequest request) {
        GetEmpleadoByIdResponse response = new GetEmpleadoByIdResponse();
        Empleado empleado = empleadoService.getById(request.getEmpleadoId());
        response.setEmpleado(empleado);
        return response;
    }

     @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadoByCargoRequest")
     @ResponsePayload
     public GetEmpleadoByCargoResponse getEmpleadoByCargo(@RequestPayload GetEmpleadoByCargoRequest request){
        GetEmpleadoByCargoResponse response = new GetEmpleadoByCargoResponse();
        List<Empleado> empleados = empleadoService.getByCargo(request.getCargo());
        response.getEmpleado().addAll(empleados);
      return response;
     }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadosByEmpresaIdRequest")
    @ResponsePayload
    public GetEmpleadosByEmpresaIdResponse getEmpleadosByEmpresaId(@RequestPayload GetEmpleadosByEmpresaIdRequest request) {
        GetEmpleadosByEmpresaIdResponse response = new GetEmpleadosByEmpresaIdResponse();
        List<Empleado> empleados = empleadoService.getByEmpresaId(request.getEmpresaId());
        response.getEmpleados().addAll(empleados);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpleadosByUsuarioIdRequest")
    @ResponsePayload
    public GetEmpleadosByUsuarioIdResponse getEmpleadosByUsuarioId(@RequestPayload GetEmpleadosByUsuarioIdRequest request) {
        GetEmpleadosByUsuarioIdResponse response = new GetEmpleadosByUsuarioIdResponse();
        Empleado empleado = empleadoService.getByUsuarioId(request.getUsuarioId());
        response.setEmpleado(empleado);
        return response;
    }
}





