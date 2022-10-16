package UNAB.APIquintoE.Shared;

import java.util.ArrayList;
import java.util.List;

import UNAB.APIquintoE.Data.entidades.UsuarioEntity;

public class RolDto {
    
    private long id;
    private String nombreRol;
    private List<UsuarioEntity> usuarioEntityList =new ArrayList<>();
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public List<UsuarioEntity> getUsuarioEntityList() {
        return usuarioEntityList;
    }
    public void setUsuarioEntityList(List<UsuarioEntity> usuarioEntityList) {
        this.usuarioEntityList = usuarioEntityList;
    }
    public String getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    


}