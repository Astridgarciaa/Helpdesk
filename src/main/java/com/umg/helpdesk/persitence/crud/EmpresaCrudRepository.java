package com.umg.helpdesk.persitence.crud;

import com.umg.helpdesk.persitence.entity.EmpresaEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaCrudRepository extends CrudRepository<EmpresaEntity, Integer> {
}
