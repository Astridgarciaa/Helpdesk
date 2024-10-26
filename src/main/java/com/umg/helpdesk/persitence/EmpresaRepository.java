package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.EmpresaCrudRepository;
import com.umg.helpdesk.persitence.entity.EmpresaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpresaRepository {
    private EmpresaCrudRepository empresaCrudRepository;

    public EmpresaRepository(EmpresaCrudRepository empresaCrudRepository) {
        this.empresaCrudRepository = empresaCrudRepository;
    }

    public List<EmpresaEntity> getAll() {
        return (List<EmpresaEntity>) empresaCrudRepository.findAll();
    }

    public EmpresaEntity getEmpresaById(int id) {
        return empresaCrudRepository.findById(id).orElse(null);
    }

    public EmpresaEntity save(EmpresaEntity empresaEntity) {
        return empresaCrudRepository.save(empresaEntity);
    }

    public EmpresaEntity findByNombre(String nombre){
        return empresaCrudRepository.findByNombre(nombre);
    }

    public void delete(int id) {
        empresaCrudRepository.deleteById(id);
    }
}
