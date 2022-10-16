package UNAB.APIquintoE.Services;

import UNAB.APIquintoE.Shared.AgendaDto;

public interface IAgendaService {
    
    public AgendaDto leerAgenda(String numeroDeDocumento); 

    public AgendaDto actualizarAgenda(AgendaDto agendaCrearDto); 

}
