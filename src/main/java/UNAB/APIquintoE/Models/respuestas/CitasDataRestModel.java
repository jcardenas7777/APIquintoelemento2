package UNAB.APIquintoE.Models.respuestas;


import java.sql.Date;


import UNAB.APIquintoE.Data.entidades.PacienteEntity;

public class CitasDataRestModel {

    private String idCita;
    private Date fechaDeCita;
    private String consultorio;
    private String hora;
    private String numeroDeDocumento;
    private boolean estado;
    private String tipoDeCita;
    private String notas;
    private PacienteEntity pacienteEntity;



    public String getIdCita() {
        return this.idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public Date getFechaDeCita() {
        return this.fechaDeCita;
    }

    public void setFechaDeCita(Date FechaDeCita) {
        this.fechaDeCita = FechaDeCita;
    }



    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
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

    public PacienteEntity getPacienteEntity() {
        return this.pacienteEntity;
    }

    public void setPacienteEntity(PacienteEntity pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

}

