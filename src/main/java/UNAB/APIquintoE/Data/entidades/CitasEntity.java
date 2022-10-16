package UNAB.APIquintoE.Data.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="citas")
public class CitasEntity implements Serializable{
private static final long serialVersionUID=1L; 
    
    @Id
    @GeneratedValue
    private long id; 

    @Column
    private Date fecha; 

    @Column
    private String numeroDeConsultorio; 

    @Column
    private String hora; 

    @Column
    private String numeroDeDocumento; 

    @Column
    private boolean estado; 


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroDeConsultorio() {
        return this.numeroDeConsultorio;
    }

    public void setNumeroDeConsultorio(String numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
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

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
