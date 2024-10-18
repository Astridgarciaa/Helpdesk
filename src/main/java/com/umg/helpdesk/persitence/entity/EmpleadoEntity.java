package com.umg.helpdesk.persitence.entity;

import jakarta.persistence.*;

import java.util.List;

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
    private UsuarioEntity usuarioEntity;

    @OneToMany(mappedBy = "empleadoEntity")
    private List<TicketEntity> ticketEntityList;

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

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public EmpresaEntity getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public List<TicketEntity> getTicketEntityList() {
        return ticketEntityList;
    }

    public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
        this.ticketEntityList = ticketEntityList;
    }
}
