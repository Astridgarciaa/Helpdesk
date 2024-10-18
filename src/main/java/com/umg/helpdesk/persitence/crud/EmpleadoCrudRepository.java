package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmpleadoCrudRepository extends CrudRepository<EmpleadoEntity, Integer> {
    EmpleadoEntity findByUsuarioEntityUsuarioId(Integer usuarioId);
    List<EmpleadoEntity> findByCargo(String cargo); // Buscar empleados por cargo
    List<EmpleadoEntity> findByEmpresaEntityEmpresaId(Integer empresaId); // Buscar empleados por empresa
}
