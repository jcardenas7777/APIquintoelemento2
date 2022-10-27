package UNAB.APIquintoE.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import UNAB.APIquintoE.Data.entidades.HistorialEntity;
import UNAB.APIquintoE.Data.repositorio.IHistorialRepository;
import UNAB.APIquintoE.Shared.HistorialDto;



@Service
public class HistorialService implements IHistorialServices {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IHistorialRepository iHistorialRepository;


 
    @Override
    public HistorialDto crearHistorial(HistorialDto crearHistorialDto) {

    if(iHistorialRepository.findByDocumento(crearHistorialDto.getDocumento())!=null){
            throw new RuntimeException("El historial ya se encuentra en la base de datos");
    }

       HistorialEntity historialEntityDto=modelMapper.map(crearHistorialDto, HistorialEntity.class);
       historialEntityDto.setIdHistoria(UUID.randomUUID().toString());

       HistorialEntity historialEntity=iHistorialRepository.save(historialEntityDto);
       
       HistorialDto historialDto=modelMapper.map(historialEntity, HistorialDto.class);
     
       
        return historialDto;
    }

    @Override
    public HistorialDto leerHistorial(String id) {
        
        HistorialEntity historialEntity=iHistorialRepository.findByDocumento(id);

        if(historialEntity==null){
            throw new UsernameNotFoundException(id);

        }
        HistorialDto historialDto=modelMapper.map(historialEntity, HistorialDto.class);
        return historialDto;
    }

    @Override
    public List<HistorialDto> verHistorial(String documento) {
       
        HistorialEntity historialEntity=iHistorialRepository.findByDocumento(documento);
        List<HistorialEntity>historialEntityList=iHistorialRepository.getByDocumento(historialEntity.getDocumento());

        List<HistorialDto> historialDtoList=new ArrayList<>();

        for(HistorialEntity historialEntity2: historialEntityList){
                HistorialDto historialDto=modelMapper.map(historialEntity2, HistorialDto.class);
                historialDtoList.add(historialDto);

        }
        return historialDtoList;
    }

    @Override
    public List<HistorialDto> historialesCreados() {
        List<HistorialEntity>historialEntityList=iHistorialRepository.historialCreado();

        List<HistorialDto>historialDtoList=new ArrayList<>();
        for (HistorialEntity historialEntity: historialEntityList) {
            HistorialDto historialDto2=modelMapper.map(historialEntity, HistorialDto.class);
            historialDtoList.add(historialDto2);
            
        }

        return historialDtoList;
    }
    @Override
    public HistorialDto actualizarHistorial(HistorialDto actualizaHistorialDto,String documento) {
       HistorialEntity historialEntity=iHistorialRepository.findByDocumento(documento);

       if(historialEntity.getDocumento() !=historialEntity.getDocumento()){

        throw new RuntimeException("No puede actualizar estos documentos");

       }
       historialEntity.setFecha(actualizaHistorialDto.getFecha());
       historialEntity.setAntecedentes_patologicos(actualizaHistorialDto.getAntecedentes_patologicos());
       historialEntity.setAntecedentes_personales(actualizaHistorialDto.getAntecedentes_personales());
       historialEntity.setMotivo_consulta(actualizaHistorialDto.getMotivo_consulta());
       historialEntity.setEnfermedad_actual(actualizaHistorialDto.getEnfermedad_actual());
       historialEntity.setRevision_sistema(actualizaHistorialDto.getRevision_sistema());
       historialEntity.setExamen_fisico(actualizaHistorialDto.getExamen_fisico());
       historialEntity.setDiagnostico(actualizaHistorialDto.getDiagnostico());
       historialEntity.setFormula(actualizaHistorialDto.getFormula());

       HistorialEntity historialEntityActualizado=iHistorialRepository.save(historialEntity);
       
       HistorialDto historialDto=modelMapper.map(historialEntityActualizado,HistorialDto.class);

       
        return historialDto ;
    }

    @Override
    public void eliminarHistorial(String idHistoria) {
       HistorialEntity historialEntityDto=iHistorialRepository.findByIdHistoria(idHistoria);
       historialEntityDto.setIdHistoria(UUID.randomUUID().toString());

      
       if(historialEntityDto.getIdHistoria() !=historialEntityDto.getIdHistoria()){

        throw new RuntimeException("No puede Eliminar este historial");

    }
    
     iHistorialRepository.delete(historialEntityDto);
    }
    
}