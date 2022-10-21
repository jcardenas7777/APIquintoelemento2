package UNAB.APIquintoE.Controllers; 

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* import UNAB.APIquintoE.Data.entidades.CitasEntity; */
import UNAB.APIquintoE.Models.peticiones.CitasRequestModel;
import UNAB.APIquintoE.Models.respuestas.CitasDataRestModel;
import UNAB.APIquintoE.Services.ICitasService;
import UNAB.APIquintoE.Shared.CitaDto;

@RestController
@RequestMapping("/citas") 

public class ControllerSeccionCitas {

    @Autowired
    ModelMapper modelMapper; 

   /*  @Autowired
    CitasRequestModel citasRequestModel;  */

    @Autowired
    ICitasService iCitasService;  
/* 
    @Autowired
    CitasEntity citasEntity; 
    */
    @PostMapping
    public CitasDataRestModel crearCita(@RequestBody CitasRequestModel crearCitasRequestModel){
        
            CitaDto crearCitaDto= modelMapper.map(crearCitasRequestModel, CitaDto.class); 
            //if (iCitasRepositorio.findbyfecha(crearCitaDto.getFechaDeCita())!=null) {
            CitaDto citaDto= iCitasService.programarCitas(crearCitaDto); 
            CitasDataRestModel citasDataRestModel=modelMapper.map(citaDto, CitasDataRestModel.class); 

            return citasDataRestModel; 
        //}
        //throw new RuntimeException("/********************/ Fecha ocupada. /***********************/");
    }

    @GetMapping
    public CitasDataRestModel citaPrueba(){
        return null;
    }


    
    @GetMapping(path = "/{id}")
    public CitasDataRestModel detalleCita(@PathVariable String id){
       /*  System.out.println("Salida #1" + id);  */

        CitaDto citaleerDto= iCitasService.leerCitas(id);
         
        CitasDataRestModel leercitDataRestModel= modelMapper.map(citaleerDto, CitasDataRestModel.class); 

        return leercitDataRestModel; 
    }

    @GetMapping(path = "/leercitas")
    public List<CitasDataRestModel> leercitas() {

      List<CitaDto> citaDtoList= iCitasService.obtenerCita(); 
      List<CitasDataRestModel> citasDataRestModelList= new ArrayList<>(); 

      for (CitaDto citaDto : citaDtoList) {

        CitasDataRestModel citaDataRestModel= modelMapper.map(citaDto, CitasDataRestModel.class); 
        citasDataRestModelList.add(citaDataRestModel); 
      }
        return citasDataRestModelList; 
    } 

    @GetMapping(path = "/numerodeconsultorio")
    public List<CitasDataRestModel> citasPorConsultorio(@RequestBody String  numeroDeConsultorio) {
        System.out.println("Salida numero #1" + numeroDeConsultorio);
      List<CitaDto> citaDtoList= iCitasService.citasPorConsultorio(); 
      List<CitasDataRestModel> citasDataRestModelList= new ArrayList<>(); 


      System.out.println("Salida numero #2"+citaDtoList); 

      for (CitaDto citaDto : citaDtoList) {

      System.out.println("Salida numero #3");

        CitasDataRestModel citaDataRestModel= modelMapper.map(citaDto, CitasDataRestModel.class); 
        citasDataRestModelList.add(citaDataRestModel); 

      System.out.println("Salida numero #5");

      }
        return citasDataRestModelList; 
    } 
}

