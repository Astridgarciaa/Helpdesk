package com.umg.helpdesk.domain.service;
import com.umg.helpdesk.persitence.SolicitanteRepository;
import com.umg.helpdesk.persitence.UsuarioRepository;
import com.umg.helpdesk.persitence.entity.SolicitanteEntity;
import com.umg.soapservice.Solicitante;
import org.springframework.stereotype.Service;


@Service
public class SolicitanteService {
    private final SolicitanteRepository solicitanteRepository;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public SolicitanteService(SolicitanteRepository solicitanteRepository, UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.solicitanteRepository = solicitanteRepository;
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    public Solicitante getSolicitanteByUsuarioId(int usuarioId) {
        SolicitanteEntity solicitante = solicitanteRepository.SolicitanteByUsuarioId(usuarioId );
        Solicitante solicitanteSoap = new Solicitante();
        solicitanteSoap.setSolicitanteId(solicitante.getSolicitanteId());
        solicitanteSoap.setNombreSolicitante(solicitanteSoap.getNombreSolicitante());
        solicitanteSoap.setApellidoSolicitante(solicitanteSoap.getApellidoSolicitante());
        solicitanteSoap.setCorreo(solicitante.getCorreo());
        solicitanteSoap.setTelefono(solicitante.getTelefono());
        solicitanteSoap.setUsuarioId(solicitanteSoap.getUsuarioId());
        return solicitanteSoap;
    }

    public Solicitante getSolicitanteByCorreo(String correo) {
        SolicitanteEntity solicitante = solicitanteRepository.SolicitanteByCorreo(correo);
        Solicitante solicitanteSoap = new Solicitante();
        solicitanteSoap.setSolicitanteId(solicitante.getSolicitanteId());
        solicitanteSoap.setNombreSolicitante(solicitanteSoap.getNombreSolicitante());
        solicitanteSoap.setApellidoSolicitante(solicitanteSoap.getApellidoSolicitante());
        solicitanteSoap.setCorreo(solicitante.getCorreo());
        solicitanteSoap.setTelefono(solicitante.getTelefono());
        solicitanteSoap.setUsuarioId(solicitanteSoap.getUsuarioId());
        return solicitanteSoap;
    }
    public Solicitante getSolicitanteById(String solicitanteId) {
        SolicitanteEntity solicitante = solicitanteRepository.SolicitanteById(solicitanteId);
        Solicitante solicitanteSoap = new Solicitante();
        solicitanteSoap.setSolicitanteId(solicitante.getSolicitanteId());
        solicitanteSoap.setNombreSolicitante(solicitanteSoap.getNombreSolicitante());
        solicitanteSoap.setApellidoSolicitante(solicitanteSoap.getApellidoSolicitante());
        solicitanteSoap.setCorreo(solicitante.getCorreo());
        solicitanteSoap.setTelefono(solicitante.getTelefono());
        solicitanteSoap.setUsuarioId(solicitanteSoap.getUsuarioId());
        return solicitanteSoap;
    }


}
