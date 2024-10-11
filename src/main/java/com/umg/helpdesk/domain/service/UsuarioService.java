package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.UsuarioRepository;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;

import com.umg.soapservice.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getByUsername(String nombreDeUsuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.getByUsername(nombreDeUsuario);
        Usuario usuarioSoap = new Usuario();
        usuarioSoap.setUsuarioId(usuarioEntity.getUsuarioId());
        usuarioSoap.setNombreUsuario(usuarioEntity.getNombreUsuario());
        usuarioSoap.setPassword(usuarioEntity.getPassword());
        usuarioSoap.setTipoUsuario(usuarioEntity.getTipoUsuario());
        return usuarioSoap;
    }
}
