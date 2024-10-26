package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.EmpleadoRepository;
import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import com.umg.soapservice.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // Buscar empleado por ID
    public Empleado getById(int empleadoId) {
        EmpleadoEntity empleadoEntity = empleadoRepository.getById(empleadoId);
        Empleado empleado = new Empleado();
        empleado.setEmpleadoId(empleadoEntity.getEmpleadoId());
        empleado.setNombre(empleadoEntity.getNombre());
        empleado.setApellido(empleadoEntity.getApellido());
        empleado.setCargo(empleadoEntity.getCargo());
        empleado.setEmpresaId(empleadoEntity.getEmpresaEntity().getEmpresaId());
        empleado.setUsuarioId(empleadoEntity.getUsuarioEntity().getUsuarioId());
        return empleado;
    }

    // Buscar empleados por cargo
    public List<Empleado> getByCargo(String cargo) {
        List<EmpleadoEntity> empleadosEntity = empleadoRepository.findByCargo(cargo);
        List<Empleado> empleados = new ArrayList<>();

        empleadosEntity.forEach(empleadoEntity -> {
            Empleado empleado = new Empleado();
            empleado.setEmpleadoId(empleadoEntity.getEmpleadoId());
            empleado.setNombre(empleadoEntity.getNombre());
            empleado.setApellido(empleadoEntity.getApellido());
            empleado.setCargo(empleadoEntity.getCargo());
            empleado.setEmpresaId(empleadoEntity.getEmpresaEntity().getEmpresaId());
            empleado.setUsuarioId(empleadoEntity.getUsuarioEntity().getUsuarioId());
            empleados.add(empleado);
        });

        return empleados;
    }

    // Buscar empleados por ID de la empresa
    public List<Empleado> getByEmpresaId(int empresaId) {
        List<EmpleadoEntity> empleadosEntity = empleadoRepository.findByEmpresaEntityEmpresaId(empresaId);
        List<Empleado> empleados = new ArrayList<>();

        empleadosEntity.forEach(empleadoEntity -> {
            Empleado empleado = new Empleado();
            empleado.setEmpleadoId(empleadoEntity.getEmpleadoId());
            empleado.setNombre(empleadoEntity.getNombre());
            empleado.setApellido(empleadoEntity.getApellido());
            empleado.setCargo(empleadoEntity.getCargo());
            empleado.setEmpresaId(empleadoEntity.getEmpresaEntity().getEmpresaId());
            empleado.setUsuarioId(empleadoEntity.getUsuarioEntity().getUsuarioId());
            empleados.add(empleado);
        });

        return empleados;
    }

    // Buscar empleado por ID de usuario
    public Empleado getByUsuarioId(int usuarioId) {
        EmpleadoEntity empleadoEntity = empleadoRepository.findByUsuarioEntityUsuarioId(usuarioId);
        Empleado empleado = new Empleado();
        empleado.setEmpleadoId(empleadoEntity.getEmpleadoId());
        empleado.setNombre(empleadoEntity.getNombre());
        empleado.setApellido(empleadoEntity.getApellido());
        empleado.setCargo(empleadoEntity.getCargo());
        empleado.setEmpresaId(empleadoEntity.getEmpresaEntity().getEmpresaId());
        empleado.setUsuarioId(empleadoEntity.getUsuarioEntity().getUsuarioId());
        return empleado;
    }
}
