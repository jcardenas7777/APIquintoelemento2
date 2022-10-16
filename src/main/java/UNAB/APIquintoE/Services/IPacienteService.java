package UNAB.APIquintoE.Services;

import UNAB.APIquintoE.Shared.PacienteDto;

public interface IPacienteService {
    
    public PacienteDto crearPaciente(PacienteDto pacienteDto); 

    public PacienteDto leerDatosPaciente(); 

}
