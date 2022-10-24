package UNAB.APIquintoE.Shared;

import java.io.Serializable;
import java.sql.Date;

public class HistorialDto implements Serializable {
    private static final long serialVersionUID=1L;
    
    private long ID;    
    private String idHistoria;
    private String nombre;
    private String apellidos;
    private String documento;
    private Date fecha;
    private String antecedentes_personales;
    private String antecedentes_patologicos;
    private String motivo_consulta;
    private String enfermedad_actual;
    private String revision_sistema;
    private String examen_fisico;
    private String diagnostico;
    private String formula;

    public String getIdHistoria() {
        return this.idHistoria;
    }

    public void setIdHistoria(String idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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
