package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoCrudRepository extends CrudRepository<EmpleadoEntity, Integer> {
    EmpleadoEntity findByUsuario(UsuarioEntity usuarioEntity);
}
