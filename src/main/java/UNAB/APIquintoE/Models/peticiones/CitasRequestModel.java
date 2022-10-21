package UNAB.APIquintoE.Models.peticiones;


import java.sql.Time;
import java.sql.Date;

public class CitasRequestModel {
    
   
    private String numeroDeDocumento;
    private String numeroDeConsultorio; 
    private Date fechaDeCita; 
    private Time hora;
    private String notas;
    private String tipoDeCita;
   

    // GETTERS AND SETTERS. 
  
    public String getNumeroDeDocumento() {
        return this.numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }


    public String getNumeroDeConsultorio() {
        return this.numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(String numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }


    public Date getFechaDeCita() {
        return this.fechaDeCita;
    }

    public void setFechaDeCita(Date fechaDeCita) {
        this.fechaDeCita = fechaDeCita;
    }

    public Time getHora() {
        return this.hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNotas() {
        return this.notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getTipoDeCita() {
        return this.tipoDeCita;
    }

    public void setTipoDeCita(String TipoDeCita) {
        this.tipoDeCita = TipoDeCita;
    }
}
