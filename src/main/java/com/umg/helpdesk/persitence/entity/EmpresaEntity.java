package com.umg.helpdesk.persitence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Integer empresaId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) { this.empresaId = empresaId; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre;}

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }
}
