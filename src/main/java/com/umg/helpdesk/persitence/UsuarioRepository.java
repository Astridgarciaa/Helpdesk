package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.UsuarioCrudRepository;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {
    private UsuarioCrudRepository usuarioCrudRepository;

    public UsuarioRepository(UsuarioCrudRepository usuarioCrudRepository) {
        this.usuarioCrudRepository = usuarioCrudRepository;
    }

    public UsuarioEntity getById(Integer id) {
        return usuarioCrudRepository.findById(id).orElse(null);
    }

    public List<UsuarioEntity> getAll() {
        return (List<UsuarioEntity>) usuarioCrudRepository.findAll();
    }

    public UsuarioEntity getByUsername(String username) {
        return usuarioCrudRepository.findByNombreUsuario(username);
    }

    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioCrudRepository.save(usuario);
    }

    public void delete(Integer id) {
        usuarioCrudRepository.deleteById(id);
    }

    public UsuarioEntity SolicitanteByUsuarioId(int usuarioId) {
        return null;
    }

    public UsuarioEntity UsuarioByNombre(String nombreDeUsuario) {
        return null;
    }
}
