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
        UsuarioEntity usuario = usuarioRepository.getByUsername(nombreDeUsuario);
        Usuario usuarioSoap = new Usuario();
        usuarioSoap.setUsuarioId(usuario.getUsuarioId());
        usuarioSoap.setNombreUsuario(usuario.getNombreUsuario());
        usuarioSoap.setPassword(usuario.getPassword());
        usuarioSoap.setTipoUsuario(usuario.getTipoUsuario());
        return usuarioSoap;
    }
    
}
