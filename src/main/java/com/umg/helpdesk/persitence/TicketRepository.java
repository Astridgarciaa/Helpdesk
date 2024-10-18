package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.TicketCrudRepository;
import com.umg.helpdesk.persitence.entity.TicketEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {
    private TicketCrudRepository ticketCrudRepository;

    public TicketRepository(TicketCrudRepository ticketCrudRepository) {
        this.ticketCrudRepository = ticketCrudRepository;
    }

    public TicketEntity findById(Integer id) {
        return ticketCrudRepository.findById(id).orElse(null);
    }

    public List<TicketEntity> findAll() {
        return (List<TicketEntity>) ticketCrudRepository.findAll();
    }

    public List<TicketEntity> findByEstado(String estado){
        return (List<TicketEntity>) ticketCrudRepository.findByEstado(estado);
    }

    public TicketEntity save(TicketEntity ticket) {
        return ticketCrudRepository.save(ticket);
    }

    public List<TicketEntity> findBySolicitanteEntitySolicitanteId(Integer solicitanteId){
        return ticketCrudRepository.findBySolicitanteEntitySolicitanteId(solicitanteId);
    }

    public void delete(Integer id) {
        ticketCrudRepository.deleteById(id);
    }
}
