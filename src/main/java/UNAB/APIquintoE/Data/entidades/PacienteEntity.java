package UNAB.APIquintoE.Data.entidades;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/* import javax.persistence.Index;
import javax.persistence.Table; */


@Entity(name="paciente")
// @Table(indexes = {@Index(columnList = "idPaciente",name = "Index_idpaciente",unique = true)})
public class PacienteEntity implements Serializable{
private static final long serialVersionUID=1L; 
    
    @Id
    @GeneratedValue
    private long id; 
    @Column
    private String idPaciente; 
    @Column
    private String nombre; 
    @Column
    private String apellido; 
    @Column
    private String sexo; 
    @Column
    private Date fechaDeNacimiento; 
    @Column
    private String edad; 
    @Column
    private String numeroDeDocumento; 
    @Column
    private String tipoDeDocumento; 
    @Column
    private String telefonoDeContacto; 
    @Column
    private String correo; 
    @Column
    private String direccion; 

// GETTERS ANS SETTERS. 
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaDeNacimiento() {
        return this.fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEdad() {
        return this.edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNumeroDeDocumento() {
        return this.numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public String getTipoDeDocumento() {
        return this.tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getTelefonoDeContacto() {
        return this.telefonoDeContacto;
    }

    public void setTelefonoDeContacto(String telefonoDeContacto) {
        this.telefonoDeContacto = telefonoDeContacto;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
}
