package UNAB.APIquintoE.Controllers;

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
import UNAB.APIquintoE.Services.IUsuarioServices;
import UNAB.APIquintoE.Shared.PacienteDto;
import UNAB.APIquintoE.Shared.UsuarioDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@RestController
@RequestMapping("/recepcion")
public class ControllerSeccionPaciente {
    
    @Autowired
    ModelMapper modelMapper; 

  /*   @Autowired
    PacienteRequestModel pacienteRequestModel; 

    
 */
    @Autowired
    IUsuarioServices iUsuarioServices;

    @Autowired
    IPacienteService iPacienteService; 

    
    @PostMapping (path = "/crearpaciente")
    public PacienteDataRestModel crearpaciente(@RequestBody PacienteRequestModel pacienteCrearRequestModel){
        
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String username = authentication.getPrincipal().toString();
      
      UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);
  
      if (usuarioDtoLogin.getRolEntity().getId()==3 ) {  

    PacienteDto pacienteCrearDto= modelMapper.map(pacienteCrearRequestModel, PacienteDto.class); 
    PacienteDto pacienteDto= iPacienteService.crearPaciente(pacienteCrearDto); 
    PacienteDataRestModel pacienteDataRestModel= modelMapper.map(pacienteDto, PacienteDataRestModel.class); 

    return pacienteDataRestModel; 
    
    }
    return null;

  }

   @GetMapping(path = "/verpacientes")
    public List<PacienteDataRestModel> leerPacientes() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getPrincipal().toString();
    
    UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);

    if (usuarioDtoLogin.getRolEntity().getId()==3 ) {

      List<PacienteDto> pacienteDtoList= iPacienteService.leerListaPacientes(); 
      List<PacienteDataRestModel> pacienteDataRestModelList= new ArrayList<>(); 
      for (PacienteDto pacienteDto : pacienteDtoList) {
        PacienteDataRestModel pacienteDataRestModel= modelMapper.map(pacienteDto, PacienteDataRestModel.class);
        pacienteDataRestModelList.add(pacienteDataRestModel); 
      }

        return pacienteDataRestModelList;
      }
        return null; 
    }  
    
    @GetMapping(path = "/{idPaciente}")
    public PacienteDataRestModel detallePaciente(@PathVariable String idPaciente){
       /*  System.out.println("Salida #1" + id);  */

       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getPrincipal().toString();
       
       UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);
   
       if (usuarioDtoLogin.getRolEntity().getId()==3 ) {

        PacienteDto pacienteLeerDto= iPacienteService.leerDatosPaciente(idPaciente);
         
        PacienteDataRestModel leerPacienteDataRestModel= modelMapper.map(pacienteLeerDto, PacienteDataRestModel.class); 

        return leerPacienteDataRestModel; 
    } return null;


}

}