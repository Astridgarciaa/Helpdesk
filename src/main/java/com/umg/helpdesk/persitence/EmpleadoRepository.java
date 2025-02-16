package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.EmpleadoCrudRepository;
import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository {
    private EmpleadoCrudRepository empleadoCrudRepository;

    public EmpleadoRepository(EmpleadoCrudRepository empleadoCrudRepository) {
        this.empleadoCrudRepository = empleadoCrudRepository;
    }

    public EmpleadoEntity getById(Integer id) {
        EmpleadoEntity empleado = empleadoCrudRepository.findById(id).orElse(null);
        System.out.println(empleado);
        return empleado;
    }

    public List<EmpleadoEntity> getAll() {
        return (List<EmpleadoEntity>) empleadoCrudRepository.findAll();
    }

    public EmpleadoEntity getByUsuario(UsuarioEntity usuarioEntity) {
        return empleadoCrudRepository.findByUsuario(usuarioEntity);
    }

    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return empleadoCrudRepository.save(empleado);
    }

    public void delete(Integer id) {
        empleadoCrudRepository.deleteById(id);
    }
}
