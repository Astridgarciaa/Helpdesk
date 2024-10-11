package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioEntity, Integer> {
    UsuarioEntity findByNombreUsuario(String username);
}
