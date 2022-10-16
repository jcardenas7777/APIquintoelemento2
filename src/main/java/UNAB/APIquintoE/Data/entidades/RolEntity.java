package UNAB.APIquintoE.Data.entidades;

import java.io.Serializable;


// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity (name = "rol")
public class RolEntity implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue    
    private long id;

    @Column(nullable = false, length = 20)
    private String nombreRol;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }


}
