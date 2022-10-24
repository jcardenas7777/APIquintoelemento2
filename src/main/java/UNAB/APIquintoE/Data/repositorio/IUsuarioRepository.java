package UNAB.APIquintoE.Data.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
    
    UsuarioEntity findByEmail(String email);
    UsuarioEntity findByIdUsuario(String id);
    UsuarioEntity findByUsername (String username);
    UsuarioEntity findByDocumento (String documento); 
    List <UsuarioEntity> findAll();


}
