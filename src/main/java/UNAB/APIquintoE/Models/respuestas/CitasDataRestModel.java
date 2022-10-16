package UNAB.APIquintoE.Models.respuestas;

import java.sql.Date;
import java.sql.Time;

public class CitasDataRestModel {
    private Date FechaDeCita; 
    private String numeroDeConsultorio; 
    private Time hora; 
    private String numeroDeDocumento; 
    private boolean estado;  
    private String tipoDeCita; 
    private String notas; 


    public Date getFechaDeCita() {
        return this.FechaDeCita;
    }

    public void setFechaDeCita(Date FechaDeCita) {
        this.FechaDeCita = FechaDeCita;
    }

    public String getNumeroDeConsultorio() {
        return this.numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(String numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }

    public Time getHora() {
        return this.hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNumeroDeDocumento() {
        return this.numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipoDeCita() {
        return this.tipoDeCita;
    }

    public void setTipoDeCita(String tipoDeCita) {
        this.tipoDeCita = tipoDeCita;
    }

    public String getNotas() {
        return this.notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }


}
