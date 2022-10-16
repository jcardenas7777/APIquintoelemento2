package UNAB.APIquintoE.Data.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.CitasEntity;

@Repository
public interface ICitasRepositorio extends CrudRepository<CitasEntity, Long> {
    
}
