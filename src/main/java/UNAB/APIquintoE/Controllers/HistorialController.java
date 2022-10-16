package UNAB.APIquintoE.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UNAB.APIquintoE.Models.peticiones.HistorialActualizarRequestModel;
import UNAB.APIquintoE.Models.peticiones.HistorialCrearRequestModel;
import UNAB.APIquintoE.Models.respuestas.HistorialDataRestModel;
import UNAB.APIquintoE.Services.IHistorialServices;
import UNAB.APIquintoE.Shared.HistorialDto;

@RestController
@RequestMapping("/historial")
public class HistorialController {

  @Autowired
  ModelMapper modelMapper;
  
  @Autowired
  IHistorialServices iHistorialServices;
 
  @GetMapping
  public HistorialDataRestModel leerHistorial(){
    String documento="1214714596";
    HistorialDto historialDto=iHistorialServices.leerHistorial(documento);

    HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto,HistorialDataRestModel.class);
  return historialDataRestModel;

  }
   @GetMapping(path = "/mihistorial")
   public List<HistorialDataRestModel>verHistorial(){

   String documento="1214714596";

   List<HistorialDto>historialDtoList= iHistorialServices.verHistorial(documento);

   List<HistorialDataRestModel> historialDataRestModelList=new ArrayList<>();

   for (HistorialDto historialDto : historialDtoList) {
    HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto,HistorialDataRestModel.class);
    historialDataRestModelList.add(historialDataRestModel);
    
   }

    return historialDataRestModelList;

    
   }

  @PostMapping 
  public HistorialDataRestModel crearHistorial(@RequestBody HistorialCrearRequestModel historialCrearRequestModel){
   
    HistorialDto historialcrearDto=modelMapper.map(historialCrearRequestModel, HistorialDto.class);

    HistorialDto historialDto= iHistorialServices.crearHistorial(historialcrearDto);
    
    HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto, HistorialDataRestModel.class);

    return historialDataRestModel;
  }

  @GetMapping(path = "/historialcreado")
  public List<HistorialDataRestModel> historialesCreados(){

  List<HistorialDto>historialDtoList= iHistorialServices.historialesCreados();

  List<HistorialDataRestModel> historialDataRestModelList=new ArrayList<>();

  for (HistorialDto historialDto: historialDtoList) {
    HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto, HistorialDataRestModel.class);
    historialDataRestModelList.add(historialDataRestModel);
  }
  return historialDataRestModelList;

  } 
  
  @PutMapping(path = "/actualizarhistorial")
  public HistorialDataRestModel actualizarhistorial(@RequestBody HistorialActualizarRequestModel historialActualizarRequestModel,String documento){

   documento="1214714598";
  HistorialDto historialDtoActualizar=modelMapper.map(historialActualizarRequestModel, HistorialDto.class);

  historialDtoActualizar.setDocumento(documento);
   HistorialDto historialDto= iHistorialServices.actualizarHistorial(historialDtoActualizar, documento);

  HistorialDataRestModel historialDataRestModel=modelMapper.map(historialDto, HistorialDataRestModel.class);

    return historialDataRestModel;
   }
 

  } 
  

