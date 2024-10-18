package com.umg.helpdesk.domain.service;

import com.umg.helpdesk.persitence.EmpleadoRepository;
import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import com.umg.helpdesk.persitence.entity.UsuarioEntity;
import com.umg.soapservice.Empleado;
import com.umg.soapservice.Usuario;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final UsuarioService usuarioService;

    public EmpleadoService(EmpleadoRepository empleadoRepository, UsuarioService usuarioService) {
        this.empleadoRepository = empleadoRepository;
        this.usuarioService = usuarioService;
    }

    public Empleado getById(int empleadoId) {
        EmpleadoEntity empleadoEntity = empleadoRepository.getById(empleadoId);
        Empleado empleado = new Empleado();
        empleado.setEmpleadoId(empleadoEntity.getEmpleadoId());
        empleado.setNombre(empleadoEntity.getNombre());
        empleado.setApellido(empleadoEntity.getApellido());
        empleado.setUsuarioId(empleadoEntity.getUsuarioEntity().getUsuarioId());
        return empleado;
    }

    public Empleado getByUsername(String nombreDeUsuario) {
       return null;
    }
}
