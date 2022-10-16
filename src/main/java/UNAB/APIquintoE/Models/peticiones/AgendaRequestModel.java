package UNAB.APIquintoE.Models.peticiones;

import java.sql.Date;
import java.sql.Time;

public class AgendaRequestModel {
    
    private String Nommbre; 
    private String numeroDeDocumento;
    private Date fechaCita; 
    private String numeroDeConsultorio; 
    private String tipoDeCita; 
    private String Notas; 
    private Time hora; 


    public String getNommbre() {
        return this.Nommbre;
    }

    public void setNommbre(String Nommbre) {
        this.Nommbre = Nommbre;
    }

    public String getNumeroDeDocumento() {
        return this.numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Date getFechaCita() {
        return this.fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNumeroDeConsultorio() {
        return this.numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(String numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }

    public String getTipoDeCita() {
        return this.tipoDeCita;
    }

    public void setTipoDeCita(String tipoDeCita) {
        this.tipoDeCita = tipoDeCita;
    }

    public String getNotas() {
        return this.Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public Time getHora() {
        return this.hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }


}

