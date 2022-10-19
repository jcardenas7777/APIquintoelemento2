package UNAB.APIquintoE.Data.repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.CitasEntity;

@Repository
public interface ICitasRepositorio extends CrudRepository<CitasEntity, Long> {
    
    CitasEntity findByFechaDeCita(Date fechaDeCita); 

    CitasEntity findByNumeroDeConsultorio(String consultorio); 
   
    CitasEntity findByIdCita(String id); 

    List<CitasEntity> findAll(); 

}
