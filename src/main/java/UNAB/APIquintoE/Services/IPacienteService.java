package UNAB.APIquintoE.Services;


import java.util.List;

import UNAB.APIquintoE.Shared.PacienteDto;

public interface IPacienteService {
    
    public PacienteDto crearPaciente(PacienteDto pacienteDto); 

    public PacienteDto leerDatosPaciente(String idPaciente); 

    PacienteDto BuscarPorDocumento (String numeroDeDocumento);

    public List<PacienteDto> leerListaPacientes(); 

}
