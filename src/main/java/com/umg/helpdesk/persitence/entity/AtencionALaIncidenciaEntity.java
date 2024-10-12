package com.umg.helpdesk.persitence.entity;

import com.umg.helpdesk.persitence.entity.EmpleadoEntity;
import jakarta.persistence.*;

import java.util.List;

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

}
