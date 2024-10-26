package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.SolicitanteRepository;
import com.umg.helpdesk.persitence.entity.SolicitanteEntity;
import com.umg.soapservice.Solicitante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitanteService {
    private final SolicitanteRepository solicitanteRepository;

    public SolicitanteService(SolicitanteRepository solicitanteRepository) {
        this.solicitanteRepository = solicitanteRepository;
    }

    // Buscar solicitante por ID
    public Solicitante getSolicitanteById(int solicitanteId) {
        SolicitanteEntity solicitanteEntity = solicitanteRepository.getById(solicitanteId);
        Solicitante solicitante = new Solicitante();
        solicitante.setSolicitanteId(solicitanteEntity.getSolicitanteId());
        solicitante.setNombreSolicitante(solicitanteEntity.getNombre());
        solicitante.setApellidoSolicitante(solicitanteEntity.getApellido());
        solicitante.setCorreo(solicitanteEntity.getCorreo());
        solicitante.setTelefono(solicitanteEntity.getTelefono());
        solicitante.setUsuarioId(solicitanteEntity.getUsuarioEntity().getUsuarioId());
        return solicitante;
    }

    // Buscar solicitante por usuario ID
    public Solicitante getSolicitanteByUsuarioId(int usuarioId) {
        SolicitanteEntity solicitanteEntity = solicitanteRepository.findByUsuarioEntityUsuarioId(usuarioId);
        Solicitante solicitante = new Solicitante();
        solicitante.setSolicitanteId(solicitanteEntity.getSolicitanteId());
        solicitante.setNombreSolicitante(solicitanteEntity.getNombre());
        solicitante.setApellidoSolicitante(solicitanteEntity.getApellido());
        solicitante.setCorreo(solicitanteEntity.getCorreo());
        solicitante.setTelefono(solicitanteEntity.getTelefono());
        solicitante.setUsuarioId(solicitanteEntity.getUsuarioEntity().getUsuarioId());
        return solicitante;
    }

    // Buscar solicitante por correo
    public Solicitante getSolicitanteByCorreo(String correo) {
        SolicitanteEntity solicitanteEntity = solicitanteRepository.findByCorreo(correo);

            Solicitante solicitante = new Solicitante();
            solicitante.setSolicitanteId(solicitanteEntity.getSolicitanteId());
            solicitante.setNombreSolicitante(solicitanteEntity.getNombre());
            solicitante.setApellidoSolicitante(solicitanteEntity.getApellido());
            solicitante.setCorreo(solicitanteEntity.getCorreo());
            solicitante.setTelefono(solicitanteEntity.getTelefono());
            solicitante.setUsuarioId(solicitanteEntity.getUsuarioEntity().getUsuarioId());

        return solicitante;
    }
}
