package UNAB.APIquintoE.Data.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.RolEntity;

@Repository
public interface IRolRepository extends CrudRepository<RolEntity, Long>{

    RolEntity findById(long id);
    
}
