package UNAB.APIquintoE.Data.repositorio;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.CitasEntity;

@Repository
public interface ICitasRepositorio extends CrudRepository<CitasEntity, Long> {
    
    CitasEntity findByFechaDeCita(Date fechaDeCita); 

    List<CitasEntity> findAllByNumeroDeConsultorio(String numeroDeConsultorio); 
   
    CitasEntity findByIdCita(String id); 

    List<CitasEntity> findAll(); 

    @Query(nativeQuery = true,value = "SELECT * FROM citas ORDER BY numeroDeConsultorio  DESC LIMIT 10")
    List<CitasEntity>citasPorConsultorio();

}

