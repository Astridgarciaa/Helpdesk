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
    public Solicitante getById(int solicitanteId) {
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
    public Solicitante getByUsuarioId(int usuarioId) {
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
    public List<Solicitante> getByCorreo(String correo) {
        List<SolicitanteEntity> solicitantesEntity = solicitanteRepository.findByCorreo(correo);
        List<Solicitante> solicitantes = new ArrayList<>();

        solicitantesEntity.forEach(solicitanteEntity -> {
            Solicitante solicitante = new Solicitante();
            solicitante.setSolicitanteId(solicitanteEntity.getSolicitanteId());
            solicitante.setNombreSolicitante(solicitanteEntity.getNombre());
            solicitante.setApellidoSolicitante(solicitanteEntity.getApellido());
            solicitante.setCorreo(solicitanteEntity.getCorreo());
            solicitante.setTelefono(solicitanteEntity.getTelefono());
            solicitante.setUsuarioId(solicitanteEntity.getUsuarioEntity().getUsuarioId());
            solicitantes.add(solicitante);
        });

        return solicitantes;
    }
}
