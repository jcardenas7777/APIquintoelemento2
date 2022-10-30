package UNAB.APIquintoE.Data.repositorio;


import java.util.Date;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.CitasEntity;

@Repository
public interface ICitasRepositorio extends CrudRepository<CitasEntity, Long> {
    
    CitasEntity findByFechaDeCitaOrderByIdDesc(Date fechaDeCita); 

    List<CitasEntity> findAllByConsultorio(String Consultorio); 
   
    CitasEntity findByIdCita(String id); 

    List<CitasEntity> findAll(); 



}

