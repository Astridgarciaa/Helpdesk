package com.umg.helpdesk.persitence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Incidente")
public class IncidenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incidente_id")
    private Integer incidenteId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "sla")
    private Integer sla;

    public Integer getIncidenteId() {
        return incidenteId;
    }

    public void setIncidenteId(Integer incidenteId) {
        this.incidenteId = incidenteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getSla() {
        return sla;
    }

    public void setSla(Integer sla) {
        this.sla = sla;
    }
}