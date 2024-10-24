package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.EmpresaRepository;
import com.umg.helpdesk.persitence.entity.EmpresaEntity;
import com.umg.soapservice.Empresa;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

   public Empresa getById (int empresaId) {
        EmpresaEntity empresaEntity = empresaRepository.getEmpresaById(empresaId);
        Empresa empresa = new Empresa();
        empresa.setEmpresaId(empresaEntity.getEmpresaId());
        empresa.setNombre(empresaEntity.getNombre());
        empresa.setDireccion(empresaEntity.getDireccion());
        return empresa;
   }

    public Empresa getByNombre(String nombre) {
        EmpresaEntity empresaEntity = empresaRepository.findByNombre(nombre);
        Empresa empresa = new Empresa();
        empresa.setEmpresaId(empresaEntity.getEmpresaId());
        empresa.setNombre(empresaEntity.getNombre());
        empresa.setDireccion(empresaEntity.getDireccion());
        return empresa;
    }
}
