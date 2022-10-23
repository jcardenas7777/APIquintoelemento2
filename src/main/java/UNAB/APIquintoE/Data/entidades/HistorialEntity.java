package UNAB.APIquintoE.Data.entidades;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/* import javax.persistence.Table; */

@Entity(name = "historial")
/* @Table(indexes = {


}) */
public class HistorialEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private long Id;

    @ Column(nullable = false)
    private String idHistoria;

    public String getIdHistoria() {
        return this.idHistoria;
    }

    public void setIdHistoria(String idHistoria) {
        this.idHistoria = idHistoria;
    }

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;
   
    @Column(nullable = false)
    private String documento;
    
    @Column(nullable = false)
    private Date fecha;
    
    @Column(nullable = false)
    private String antecedentes_personales;

    @Column(nullable = false)
    private String antecedentes_patologicos;
    
    @Column(nullable = false)
    private String motivo_consulta;

    @Column(nullable = false)
    private String enfermedad_actual;
    
    @Column(nullable = false)
    private String revision_sistema;
    
    @Column(nullable = false)
    private String examen_fisico;
    
    @Column(nullable = false)
    private String diagnostico;
    
    @Column(nullable = false)
    private String formula;

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

  

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAntecedentes_personales() {
        return this.antecedentes_personales;
    }

    public void setAntecedentes_personales(String antecedentes_personales) {
        this.antecedentes_personales = antecedentes_personales;
    }

    public String getAntecedentes_patologicos() {
        return this.antecedentes_patologicos;
    }

    public void setAntecedentes_patologicos(String antecedentes_patologicos) {
        this.antecedentes_patologicos = antecedentes_patologicos;
    }

    public String getMotivo_consulta() {
        return this.motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getEnfermedad_actual() {
        return this.enfermedad_actual;
    }

    public void setEnfermedad_actual(String enfermedad_actual) {
        this.enfermedad_actual = enfermedad_actual;
    }

    public String getRevision_sistema() {
        return this.revision_sistema;
    }

    public void setRevision_sistema(String revision_sistema) {
        this.revision_sistema = revision_sistema;
    }

    public String getExamen_fisico() {
        return this.examen_fisico;
    }

    public void setExamen_fisico(String examen_fisico) {
        this.examen_fisico = examen_fisico;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFormula() {
        return this.formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }


}
