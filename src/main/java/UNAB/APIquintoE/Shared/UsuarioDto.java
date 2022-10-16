package UNAB.APIquintoE.Shared;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDto implements Serializable{

    private static final long serialVersionUID=1L;

    private long id;
    private String idUsuario;
    private String nombres; 
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private Date   fechaDeNacimiento;
    private String email;
    private String username;
    private String password;
    private String passwordEncriptada;
    private String direccion;
    private String celular;
    private long nombreRol;
    private RolDto rolEntity;
    private Date creado;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
    public long getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(long nombreRol) {
        this.nombreRol = nombreRol;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordEncriptada() {
        return passwordEncriptada;
    }
    public void setPasswordEncriptada(String passwordEncriptada) {
        this.passwordEncriptada = passwordEncriptada;
    }
    public RolDto getRolEntity() {
        return rolEntity;
    }
    public void setRolEntity(RolDto rolEntity) {
        this.rolEntity = rolEntity;
    }
    public Date getCreado() {
        return creado;
    }
    public void setCreado(Date creado) {
        this.creado = creado;
    }
    
    
}
