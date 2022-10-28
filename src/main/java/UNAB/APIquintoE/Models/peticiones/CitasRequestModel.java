package UNAB.APIquintoE.Models.peticiones;



import java.sql.Date;

public class CitasRequestModel {
    
   
    private String numeroDeDocumento;
    private String consultorio; 
    private Date fechaDeCita; 
    private String hora;
    private String notas;
    private String tipoDeCita;
   

    // GETTERS AND SETTERS. 
  
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

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
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

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
}
