package UNAB.APIquintoE.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UNAB.APIquintoE.Models.respuestas.AgendaDataRestModel;
import UNAB.APIquintoE.Services.IAgendaService;
import UNAB.APIquintoE.Services.IPacienteService;
import UNAB.APIquintoE.Shared.AgendaDto;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/secretaria") 
public class ControllerSeccionAgenda {
    
    @Autowired
    ModelMapper modelMapper; 

    @Autowired
    IAgendaService iAgendaService; 

    @Autowired
    IPacienteService iPacienteService; 

    @GetMapping(path = "/infodeagenda") 
    public AgendaDataRestModel LeerAgenda() {

        String fecha= "122332"; 

        AgendaDto agendaDto= iAgendaService.leerAgenda(fecha); 
        AgendaDataRestModel agendaDataRestModel= modelMapper.map(agendaDto, AgendaDataRestModel.class);

        return agendaDataRestModel; 
    }
    
    // Actualizar Agenda. 
    /* @PostMapping
    public AgendaDataRestModel crearAgendaController(@RequestBody AgendaRequestModel AgendaCrearRequestModel){

        AgendaDto agendacrearDto= modelMapper.map(AgendaCrearRequestModel, AgendaDto.class);  
        AgendaDto agendaDto = iAgendaService.actualizarAgenda(agendacrearDto); 
        AgendaDataRestModel usuaAgendaDataRestModel= modelMapper.map(agendaDto, AgendaDataRestModel.class); 

        return usuaAgendaDataRestModel; 
    } */


}
