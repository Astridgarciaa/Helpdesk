package com.umg.helpdesk.persitence.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", insertable = false, updatable = false)
    private SolicitanteEntity solicitanteEntity;

    @ManyToOne
    @JoinColumn(name = "empleado_id", insertable = false, updatable = false)
    private EmpleadoEntity empleadoEntity;

    @ManyToOne
    @JoinColumn(name = "incidente_id", insertable = false, updatable = false)
    private IncidenteEntity incidenteEntity;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public SolicitanteEntity getSolicitanteEntity() {
        return solicitanteEntity;
    }

    public void setSolicitanteEntity(SolicitanteEntity solicitanteEntity) {
        this.solicitanteEntity = solicitanteEntity;
    }

    public EmpleadoEntity getEmpleadoEntity() {
        return empleadoEntity;
    }

    public void setEmpleadoEntity(EmpleadoEntity empleadoEntity) {
        this.empleadoEntity = empleadoEntity;
    }

    public IncidenteEntity getIncidenteEntity() {
        return incidenteEntity;
    }

    public void setIncidenteEntity(IncidenteEntity incidenteEntity) {
        this.incidenteEntity = incidenteEntity;
    }
}