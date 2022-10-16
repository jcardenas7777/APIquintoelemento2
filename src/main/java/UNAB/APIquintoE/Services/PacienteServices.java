package UNAB.APIquintoE.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UNAB.APIquintoE.Data.entidades.PacienteEntity;
import UNAB.APIquintoE.Data.repositorio.IPacienteRepositorio;
import UNAB.APIquintoE.Shared.PacienteDto;

@Service
public class PacienteServices implements IPacienteService{

    @Autowired
    ModelMapper modelMapper; 

    @Autowired
    IPacienteRepositorio iPacienteRepositorio; 

    @Override
    public PacienteDto crearPaciente(PacienteDto crearPacienteDto) {
         if(iPacienteRepositorio.findByNumeroDeDocumento(crearPacienteDto.getNumeroDeDocumento())!= null){
            throw new RuntimeException("Esta todo 'creado' \n"); 

        } 
        PacienteEntity pacienteEntityDto=modelMapper.map(crearPacienteDto, PacienteEntity.class); 
        PacienteEntity pacienteEntity=iPacienteRepositorio.save(pacienteEntityDto); 

        PacienteDto pacienteDto=modelMapper.map(pacienteEntity, PacienteDto.class); 

        return pacienteDto;
    }

    @Override
    public PacienteDto leerDatosPaciente() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
