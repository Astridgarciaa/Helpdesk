package com.umg.helpdesk.web.endpoint;

import com.umg.helpdesk.domain.service.UsuarioService;
import com.umg.soapservice.GetUsuarioRequest;
import com.umg.soapservice.GetUsuarioResponse;
import com.umg.soapservice.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class UsuarioEndpoint {
    private static final String NAMESPACE_URI = "http://umg.com/soapservice";

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioEndpoint(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioRequest")
    @ResponsePayload
    public GetUsuarioResponse getUsuario(@RequestPayload GetUsuarioRequest request) {
        GetUsuarioResponse response = new GetUsuarioResponse();
        Usuario usuario = usuarioService.getByUsername(request.getNombreDeUsuario());
        response.setUsuario(usuario);
        return response;
    }
}
