package UNAB.APIquintoE.Data.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.AgendaEntity;

@Repository
public interface IAgendaRepositorio extends CrudRepository <AgendaEntity, Long>{
    
}
