package UNAB.APIquintoE.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UNAB.APIquintoE.Data.repositorio.IAgendaRepositorio;
import UNAB.APIquintoE.Shared.AgendaDto;

@Service
public class AgendaService implements IAgendaService {
    @Autowired
    ModelMapper modelMapper; 

    @Autowired
    IAgendaRepositorio iAgendaRepositorio; 

    @Override
    public AgendaDto leerAgenda(String numeroDeDocumento) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AgendaDto actualizarAgenda(AgendaDto agendaCrearDto) {
        // TODO Auto-generated method stub
        return null;
    }  

    
}
