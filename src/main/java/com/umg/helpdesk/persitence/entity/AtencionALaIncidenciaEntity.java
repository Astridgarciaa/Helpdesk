package com.umg.helpdesk.persitence.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "AtencionALaIncidencia")
public class AtencionALaIncidenciaEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atencion_id")
    private Integer atencionId;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha")
    private String feha;

    @ManyToOne
    @JoinColumn(name = "ticket_id", insertable = false, updatable = false)
    private TicketEntity ticketEntity;

    public Integer getAtencionId() {
        return atencionId;
    }

    public void setAtencionId(Integer atencionId) {
        this.atencionId = atencionId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFeha() {
        return feha;
    }

    public void setFeha(String feha) {
        this.feha = feha;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }
}
