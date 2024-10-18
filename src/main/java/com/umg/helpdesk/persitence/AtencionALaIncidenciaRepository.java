package com.umg.helpdesk.persitence;

import com.umg.helpdesk.persitence.crud.AtencionALaIncidenciaCrudRepository;
import com.umg.helpdesk.persitence.entity.AtencionALaIncidenciaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AtencionALaIncidenciaRepository {
    private AtencionALaIncidenciaCrudRepository atencionCrudRepository;

    public AtencionALaIncidenciaRepository(AtencionALaIncidenciaCrudRepository atencionCrudRepository) {
        this.atencionCrudRepository = atencionCrudRepository;
    }

    public AtencionALaIncidenciaEntity getById(Integer id) {
        return atencionCrudRepository.findById(id).orElse(null);
    }

    public List<AtencionALaIncidenciaEntity> getAll() {
        return (List<AtencionALaIncidenciaEntity>) atencionCrudRepository.findAll();
    }

    public AtencionALaIncidenciaEntity save(AtencionALaIncidenciaEntity atencion) {
        return atencionCrudRepository.save(atencion);
    }

    public void delete(Integer id) {
        atencionCrudRepository.deleteById(id);
    }

    public  List<AtencionALaIncidenciaEntity> findByTicketEntityTicketId(Integer ticketId){
        return atencionCrudRepository.findByTicketEntityTicketId(ticketId);
    }
}
