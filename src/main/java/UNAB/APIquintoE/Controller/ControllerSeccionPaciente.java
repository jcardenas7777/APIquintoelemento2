package UNAB.APIquintoE.Controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/paciente")
public class ControllerSeccionPaciente {
    
    @Autowired
    ModelMapper modelMapper; 

  /*   @Autowired
    PacienteRequestModel pacienteRequestModel; 
 */
    @Autowired
    IPacienteService iPacienteService; 

    
    @PostMapping
    public PacienteDataRestModel crearpaciente(@RequestBody PacienteRequestModel pacienteCrearRequestModel){
        
    PacienteDto pacienteCrearDto= modelMapper.map(pacienteCrearRequestModel, PacienteDto.class); 
    PacienteDto pacienteDto= iPacienteService.crearPaciente(pacienteCrearDto); 
    PacienteDataRestModel pacienteDataRestModel= modelMapper.map(pacienteDto, PacienteDataRestModel.class); 

    return pacienteDataRestModel; 
    }

   @GetMapping(path = "/leerpacientes")
    public List<PacienteDataRestModel> leerPacientes() {

      List<PacienteDto> pacienteDtoList= iPacienteService.leerListaPacientes(); 
      List<PacienteDataRestModel> pacienteDataRestModelList= new ArrayList<>(); 
      for (PacienteDto pacienteDto : pacienteDtoList) {
        PacienteDataRestModel pacienteDataRestModel= modelMapper.map(pacienteDto, PacienteDataRestModel.class);
        pacienteDataRestModelList.add(pacienteDataRestModel); 
      }

        return pacienteDataRestModelList; 
    }  
    
    @GetMapping(path = "/{idPaciente}")
    public PacienteDataRestModel detalleCita(@PathVariable String idPaciente){
       /*  System.out.println("Salida #1" + id);  */

        PacienteDto pacienteLeerDto= iPacienteService.leerDatosPaciente(idPaciente);
         
        PacienteDataRestModel leerPacienteDataRestModel= modelMapper.map(pacienteLeerDto, PacienteDataRestModel.class); 

        return leerPacienteDataRestModel; 
    }


}
