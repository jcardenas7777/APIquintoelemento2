package UNAB.APIquintoE.Services;

import java.util.List;

import UNAB.APIquintoE.Shared.HistorialDto;

public interface IHistorialServices {
     /* CREAR UN HISTORIAL */
    public HistorialDto crearHistorial(HistorialDto crearHistorialDto);
    /* LEE LOS DATOS DEL HISTORIAL */
    public HistorialDto leerHistorial(String idHistoria);
    /* ACTUALIZAR HISTORIAL */
    public HistorialDto actualizarHistorial(HistorialDto actualizaHistorialDto,String documento);
    /* TRAE EL HISTORIAL POR NUMERO DE DOCUMENTO */
    public List<HistorialDto> verHistorial(String documento);
    /* TRAE TODOS LOS HISTORIALES DE LA BASE DE DATOS */
    List <HistorialDto> historialesCreados();

    public void eliminarHistorial(String idhistoria);
}
