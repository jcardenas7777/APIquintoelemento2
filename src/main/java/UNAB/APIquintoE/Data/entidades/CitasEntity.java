package UNAB.APIquintoE.Data.entidades;

import java.io.Serializable;
import java.sql.Date;  
import java.sql.Time;

                import javax.persistence.Column;
                import javax.persistence.Entity;
                import javax.persistence.GeneratedValue;
                import javax.persistence.Id;
/* import javax.persistence.Index;
import javax.persistence.JoinColumn; */
import javax.persistence.ManyToOne;
/* import javax.persistence.Table; */



@Entity(name="citas")
//@Table(indexes = {@Index(columnList = "id_cita", name = "index_id_cita", unique = true)})
public class CitasEntity implements Serializable{
private static final long serialVersionUID=1L; 
    
    @Id
    @GeneratedValue
    private long id; 

    @Column(nullable = false)
    private String idCita; 

    @Column(nullable = false)
    private Date fechaDeCita; 

    @Column(nullable = false)
    private String numeroDeConsultorio; 

    @Column(nullable = false)
    private Time hora;

    @Column(nullable = false)
    private String numeroDeDocumento;

    @Column(nullable = false)
    private String tipoDeCita;

    @Column(nullable = false)
    private String notas;

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne
//    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;


    // GETERS AND SETTERS. 
    

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getIdCita() {
        return this.idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
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

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public PacienteEntity getPacienteEntity() {
        return this.pacienteEntity;
    }

    public void setPacienteEntity(PacienteEntity pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }
       
}
