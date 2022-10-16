package UNAB.APIquintoE.Models.respuestas;

import java.util.Date;

public class UsuarioDataRestModel {
    
    private long id;
    private String idUsuario;
    private String nombres; 
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private Date   fechaDeNacimiento;
    private String email;
    private String username;
    private String direccion;
    private String celular;
    private Date creado;
    private RolDataRestModel rolEntity;

    
    
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public RolDataRestModel getRolEntity() {
        return rolEntity;
    }
    public void setRolEntity(RolDataRestModel rolEntity) {
        this.rolEntity = rolEntity;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getCreado() {
        return creado;
    }
    public void setCreado(Date creado) {
        this.creado = creado;
    }

    

    


    
}
