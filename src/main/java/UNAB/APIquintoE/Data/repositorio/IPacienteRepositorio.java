package UNAB.APIquintoE.Data.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import UNAB.APIquintoE.Data.entidades.PacienteEntity;

@Repository
public interface IPacienteRepositorio extends CrudRepository<PacienteEntity, Long> { 
    
    public PacienteEntity findByNumeroDeDocumento(String numeroDeDocumento); 
}
