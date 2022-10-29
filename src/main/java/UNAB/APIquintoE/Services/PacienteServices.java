package UNAB.APIquintoE.Services;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
            throw new RuntimeException("/**************/ Paciente ya registrado. /****************/"); 

        } 
        PacienteEntity pacienteEntityDto=modelMapper.map(crearPacienteDto, PacienteEntity.class); 
        pacienteEntityDto.setIdPaciente(UUID.randomUUID().toString()); 
        PacienteEntity pacienteEntity=iPacienteRepositorio.save(pacienteEntityDto); 

        PacienteDto pacienteDto= modelMapper.map(pacienteEntity, PacienteDto.class); 

        return pacienteDto;
    }

    @Override
    public PacienteDto leerDatosPaciente(String idPaciente) {

        PacienteEntity pacienteEntity= iPacienteRepositorio.findByIdPaciente(idPaciente);
        PacienteDto pacienteLeerDto= modelMapper.map(pacienteEntity, PacienteDto.class); 

        return pacienteLeerDto;
    }

    @Override
    public List<PacienteDto> leerListaPacientes() {
        
        List<PacienteEntity> pacienteEntityList = iPacienteRepositorio.findAll(); 

        List<PacienteDto> pacienteDtoList= new ArrayList<>(); 

        for(PacienteEntity pacienteEntity : pacienteEntityList){

         PacienteDto pacienteDto = modelMapper.map(pacienteEntity, PacienteDto.class); 
         pacienteDtoList.add(pacienteDto); 

        }
        return pacienteDtoList;
    }

    @Override
    public PacienteDto BuscarPorDocumento(String numeroDeDocumento) {
        
        PacienteEntity pacienteEntity = iPacienteRepositorio.findByNumeroDeDocumento(numeroDeDocumento);

        PacienteDto pacienteDto = modelMapper.map(pacienteEntity,PacienteDto.class);
        
        return pacienteDto;
    }
    
}

