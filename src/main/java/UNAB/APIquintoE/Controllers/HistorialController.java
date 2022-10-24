package UNAB.APIquintoE.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import UNAB.APIquintoE.Models.peticiones.HistorialActualizarRequestModel;
import UNAB.APIquintoE.Models.peticiones.HistorialCrearRequestModel;
import UNAB.APIquintoE.Models.respuestas.HistorialDataRestModel;
import UNAB.APIquintoE.Models.respuestas.MensajeRestModel;
import UNAB.APIquintoE.Services.IHistorialServices;
import UNAB.APIquintoE.Services.IUsuarioServices;
import UNAB.APIquintoE.Shared.HistorialDto;
import UNAB.APIquintoE.Shared.UsuarioDto;

@RestController
@RequestMapping("/historial")
public class HistorialController {

  @Autowired
  ModelMapper modelMapper;
  @Autowired
  IHistorialServices iHistorialServices;

  @Autowired
  IUsuarioServices iUsuarioServices;

  @GetMapping
  public HistorialDataRestModel leerHistorial(){

    

    String documento="1214714596";
    HistorialDto historialDto=iHistorialServices.leerHistorial(documento);

    HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto,HistorialDataRestModel.class);
    return historialDataRestModel;

  }
   @GetMapping(path = "/mihistorial")
   public List<HistorialDataRestModel>verHistorial(){

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getPrincipal().toString();
    
    UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);

    if (usuarioDtoLogin.getRolEntity().getId()==2 ) {

        String documento="1214474";

        List<HistorialDto>historialDtoList= iHistorialServices.verHistorial(documento);

        List<HistorialDataRestModel> historialDataRestModelList=new ArrayList<>();

        for (HistorialDto historialDto : historialDtoList) {
          HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto,HistorialDataRestModel.class);
          historialDataRestModelList.add(historialDataRestModel);
          
        }

          return historialDataRestModelList;
    }   
    return null;
    
   }

  @PostMapping 
  public HistorialDataRestModel crearHistorial(@RequestBody HistorialCrearRequestModel historialCrearRequestModel){
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getPrincipal().toString();
        
        UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);

        if (usuarioDtoLogin.getRolEntity().getId()==2 ) {

            HistorialDto historialcrearDto=modelMapper.map(historialCrearRequestModel, HistorialDto.class);

            HistorialDto historialDto= iHistorialServices.crearHistorial(historialcrearDto);
            
            HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto, HistorialDataRestModel.class);

            return historialDataRestModel;

        }

        return null;
  }

  @GetMapping(path = "/historialcreado")
  public List<HistorialDataRestModel> historialesCreados(){
  
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String username = authentication.getPrincipal().toString();
        
      UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);

      if (usuarioDtoLogin.getRolEntity().getId()==2 ) {

          List<HistorialDto>historialDtoList= iHistorialServices.historialesCreados();

          List<HistorialDataRestModel> historialDataRestModelList=new ArrayList<>();

          for (HistorialDto historialDto: historialDtoList) {
            HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto, HistorialDataRestModel.class);
            historialDataRestModelList.add(historialDataRestModel);
          }
          return historialDataRestModelList;
      }

        return null;
  } 
  
  @PutMapping(path = "/actualizarhistorial")
  public HistorialDataRestModel actualizarhistorial(@RequestBody HistorialActualizarRequestModel historialActualizarRequestModel,String documento){

      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String username = authentication.getPrincipal().toString();
        
      UsuarioDto usuarioDtoLogin = iUsuarioServices.leerUsuario(username);

      if (usuarioDtoLogin.getRolEntity().getId()==2 ) {

          documento="1214474";
          HistorialDto historialDtoActualizar=modelMapper.map(historialActualizarRequestModel, HistorialDto.class);

          historialDtoActualizar.setDocumento(documento);
          HistorialDto historialDto= iHistorialServices.actualizarHistorial(historialDtoActualizar, documento);

          HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto, HistorialDataRestModel.class);

            return historialDataRestModel;
      }  
        return null;     
   }

  @DeleteMapping(path = "/{idHistoria}")
=======
  @DeleteMapping(path = "/{id_historia}")

  public MensajeRestModel eliminarHistorial(@PathVariable String idHistoria){
 
  HistorialDto historialDto=iHistorialServices.leerHistorial(idHistoria);
  MensajeRestModel mensajeRestModel= new MensajeRestModel();
  mensajeRestModel.setNombre("Eliminar");
  iHistorialServices.eliminarHistorial(historialDto.getIdHistoria());
  mensajeRestModel.setResultado("Historial eliminado");

   return mensajeRestModel;

 }

  } 
  

