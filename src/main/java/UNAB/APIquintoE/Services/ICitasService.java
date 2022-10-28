package UNAB.APIquintoE.Services;


import java.util.List;

import UNAB.APIquintoE.Shared.CitaDto;

public interface ICitasService {
    
     CitaDto programarCitas(CitaDto crearCitaDto);  

     CitaDto modificarCitas(CitaDto modificarCitaDto); 

     CitaDto leerCitas(String id); 

     List<CitaDto> obtenerCita(); 

     List<CitaDto> citasPorConsultorio(String consultorio); 

}

