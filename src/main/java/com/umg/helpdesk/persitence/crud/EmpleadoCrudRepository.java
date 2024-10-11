package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoCrudRepository extends CrudRepository<EmpleadoEntity, Integer> {
}
