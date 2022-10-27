package UNAB.APIquintoE.Data.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.HistorialEntity;


    @Repository
    public interface IHistorialRepository extends CrudRepository<HistorialEntity, Long>{
       
        public HistorialEntity findByDocumento(String documento);
        public HistorialEntity findByIdHistoria(String id);
        List<HistorialEntity> getByDocumento(String documento);
        @Query(nativeQuery = true,value = "SELECT * FROM historial ORDER BY Id  DESC LIMIT 10")
        List<HistorialEntity>historialCreado();
      





 
    }

