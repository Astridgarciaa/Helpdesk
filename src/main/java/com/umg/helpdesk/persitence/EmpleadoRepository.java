package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.EmpleadoCrudRepository;
import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository {
    private EmpleadoCrudRepository empleadoCrudRepository;

    public EmpleadoEntity getById(Integer id) {
        return empleadoCrudRepository.findById(id).orElse(null);
    }

    public List<EmpleadoEntity> getAll() {
        return (List<EmpleadoEntity>) empleadoCrudRepository.findAll();
    }

    public EmpleadoEntity save(EmpleadoEntity empleado) {
        return empleadoCrudRepository.save(empleado);
    }

    public void delete(Integer id) {
        empleadoCrudRepository.deleteById(id);
    }
}
