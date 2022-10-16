package UNAB.APIquintoE.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UNAB.APIquintoE.Models.peticiones.PacienteRequestModel;
import UNAB.APIquintoE.Models.respuestas.PacienteDataRestModel;
import UNAB.APIquintoE.Services.IPacienteService;
import UNAB.APIquintoE.Shared.PacienteDto;

@RestController
@RequestMapping("/paciente")
public class ControllerSeccionPaciente {
    
    @Autowired
    ModelMapper modelMapper; 


    @Autowired
    PacienteRequestModel pacienteRequestModel; 

    @Autowired
    IPacienteService iPacienteService; 

    @RequestMapping (path="/registropaciente")
    @PostMapping
    public PacienteDataRestModel crearpaciente(@RequestBody PacienteRequestModel pacienteCrearRequestModel){
        
        PacienteDto pacienteCrearDto= modelMapper.map(pacienteCrearRequestModel, PacienteDto.class); 
        PacienteDto pacienteDto= iPacienteService.crearPaciente(pacienteCrearDto); 
        PacienteDataRestModel pacienteDataRestModel= modelMapper.map(pacienteDto, PacienteDataRestModel.class); 

    return pacienteDataRestModel; 
    }
}
