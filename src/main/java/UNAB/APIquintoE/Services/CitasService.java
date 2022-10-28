package UNAB.APIquintoE.Services;


import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UNAB.APIquintoE.Data.entidades.CitasEntity;
import UNAB.APIquintoE.Data.entidades.PacienteEntity;
import UNAB.APIquintoE.Data.repositorio.ICitasRepositorio;
import UNAB.APIquintoE.Data.repositorio.IPacienteRepositorio;
import UNAB.APIquintoE.Shared.CitaDto;

@Service
public class CitasService implements ICitasService {

    @Autowired
    ModelMapper modelMapper; 

    @Autowired
    ICitasRepositorio iCitasRepositorio; 

    @Autowired
    IPacienteRepositorio iPacienteRepositorio;


    @Override
    public CitaDto programarCitas(CitaDto crearCitaDto) { 

        PacienteEntity pacienteEntity= iPacienteRepositorio.findByNumeroDeDocumento(crearCitaDto.getNumeroDeDocumento()); 

        CitasEntity citasEntity= modelMapper.map(crearCitaDto, CitasEntity.class); 
        citasEntity.setIdCita(UUID.randomUUID().toString()); 
        citasEntity.setPacienteEntity(pacienteEntity); 
        citasEntity.setEstado(true); 

        // if(iCitasRepositorio.findbyconsultorio(crearCitaDto.getNumeroDeConsultorio())!= null && 
         //  iCitasRepositorio.findbyhora(crearCitaDto.getHora())!=null){

           // throw new RuntimeException("Hora y fechas ocupados");
        // }  
        CitasEntity citasEntityCreado = iCitasRepositorio.save(citasEntity); 
        CitaDto citaDto=modelMapper.map(citasEntityCreado, CitaDto.class); 
        return citaDto;
    }

    @Override
    public CitaDto modificarCitas(CitaDto modificarCitaDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CitaDto leerCitas(String id) {
        
        CitasEntity citasEntity= iCitasRepositorio.findByIdCita(id);
        CitaDto CitaDto= modelMapper.map(citasEntity, CitaDto.class);  

        return CitaDto;
    }

    @Override
    public  List<CitaDto> obtenerCita() {

        List<CitasEntity> citasEntityList= iCitasRepositorio.findAll(); 

        List<CitaDto> citaDtoList= new ArrayList<>(); 

        for(CitasEntity citasEntity : citasEntityList){

            CitaDto citaDto= modelMapper.map(citasEntity,CitaDto.class); 
            citaDtoList.add(citaDto); 
        }
        return citaDtoList;
    }



    @Override
    public List<CitaDto> citasPorConsultorio(String Consultorio) {

        List<CitasEntity> citasEntityList = iCitasRepositorio.findAllByConsultorio(Consultorio);
        List<CitaDto> citaDtoList= new ArrayList<>(); 

      System.out.println("Salida numero #1.2" + citasEntityList); 

        for(CitasEntity citasEntity : citasEntityList){

        CitaDto citaDto =modelMapper.map(citasEntity, CitaDto.class); 
        citaDtoList.add(citaDto); 

        }
        return citaDtoList;
    }



}

