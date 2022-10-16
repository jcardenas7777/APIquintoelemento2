package UNAB.APIquintoE.Models.respuestas;

import java.sql.Date;

public class AgendaDataRestModel {
    
    private String idUsuario; 
    private String numeroDeDocumento;
    private Date fechaDeCita;
    private String numeroDeConsultorio;
    private String nombre;
    private String notas;
    private String hora;
    private String tipoDeCita;


    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumeroDeDocumento() {
        return this.numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Date getFechaDeCita() {
        return this.fechaDeCita;
    }

    public void setFechaDeCita(Date fechaDeCita) {
        this.fechaDeCita = fechaDeCita;
    }

    public String getNumeroDeConsultorio() {
        return this.numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(String numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotas() {
        return this.notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoDeCita() {
        return this.tipoDeCita;
    }

    public void setTipoDeCita(String tipoDeCita) {
        this.tipoDeCita = tipoDeCita;
    }



}
