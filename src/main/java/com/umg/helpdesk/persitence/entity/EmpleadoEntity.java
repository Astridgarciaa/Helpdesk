package com.umg.helpdesk.persitence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Empleado")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private Integer empleadoId;

    private String nombre;

    private String apellido;

    private String cargo;

    @ManyToOne
    @JoinColumn(name = "empresa_id", insertable = false, updatable = false)
    private EmpresaEntity empresaEntity;

    @OneToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private UsuarioEntity usuario;


    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public EmpresaEntity getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
