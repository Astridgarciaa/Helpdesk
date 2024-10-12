package com.umg.helpdesk.domain.service;
import com.umg.helpdesk.persitence.SolicitanteRepository;
import com.umg.helpdesk.persitence.UsuarioRepository;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;

import com.umg.soapservice.Solicitante;
import org.springframework.stereotype.Service;
@Service
public class SolicitanteService {
    private final SolicitanteRepository solicitanteRepository;

    public  SolicitanteService(SolicitanteRepository solicitanteRepository) {
        this.solicitanteRepository = solicitanteRepository;
    }

    public Solicitante getByUsuarioId(String usuarioId) {

    }
}
