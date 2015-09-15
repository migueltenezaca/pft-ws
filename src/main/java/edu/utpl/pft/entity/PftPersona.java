/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_persona")
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "personasTodo",
            resultClasses = PftPersona.class,
            procedureName = "get_all_persona"
    ),
    @NamedStoredProcedureQuery(
            name = "personaPorCedula",
            procedureName = "get_persona_byIdentificacion",
            resultClasses = PftPersona.class,
            parameters = {
                @StoredProcedureParameter(name = "dni", type = String.class)
            }
    )
}
)
public class PftPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ENT_ID")
    private Integer entId;
    @Size(max = 15)
    @Column(name = "ENT_IDENTIFICACION")
    private String entIdentificacion;
    @Size(max = 100)
    @Column(name = "PER_GENERO_ID")
    private String perGeneroId;
    @Size(max = 10)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Size(max = 45)
    @Column(name = "PER_PRIMER_NOMBRE")
    private String perPrimerNombre;
    @Size(max = 30)
    @Column(name = "PER_SEGUNDO_NOMBRE")
    private String perSegundoNombre;
    @Size(max = 50)
    @Column(name = "PER_PRIMER_APELLIDO")
    private String perPrimerApellido;
    @Size(max = 45)
    @Column(name = "PER_SEGUNDO_APELLIDO")
    private String perSegundoApellido;
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Size(max = 45)
    @Column(name = "PER_USUARIO")
    private String perUsuario;
    @Size(max = 45)
    @Column(name = "PER_CLAVE")
    private String perClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ECV_ID")
    private int ecvId;
    @JoinColumn(name = "per_id_departamento", referencedColumnName = "dept_id")
    @ManyToOne
    private PftDepartamento perIdDepartamento;
    @JoinColumn(name = "PRA_ID", referencedColumnName = "PRA_ID")
    @ManyToOne
    private PftPrograma praId;
    @JoinColumn(name = "per_id_rol", referencedColumnName = "rol_id")
    @ManyToOne
    private PftRol perIdRol;
    @JoinColumn(name = "per_id_seccion", referencedColumnName = "sec_id")
    @ManyToOne(optional = false)
    private PftSeccion perIdSeccion;
    @OneToMany(mappedBy = "aproIdPersona")
    private List<PftAprobacion> pftAprobacionList;
    @OneToMany(mappedBy = "histIdPersona")
    private List<PftHistorialCambios> pftHistorialCambiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proIdPersona")
    private List<PftProyecto> pftProyectoList;

    public PftPersona() {
    }

    public PftPersona(Integer entId) {
        this.entId = entId;
    }

    public PftPersona(Integer entId, int ecvId) {
        this.entId = entId;
        this.ecvId = ecvId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntIdentificacion() {
        return entIdentificacion;
    }

    public void setEntIdentificacion(String entIdentificacion) {
        this.entIdentificacion = entIdentificacion;
    }

    public String getPerGeneroId() {
        return perGeneroId;
    }

    public void setPerGeneroId(String perGeneroId) {
        this.perGeneroId = perGeneroId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerPrimerNombre() {
        return perPrimerNombre;
    }

    public void setPerPrimerNombre(String perPrimerNombre) {
        this.perPrimerNombre = perPrimerNombre;
    }

    public String getPerSegundoNombre() {
        return perSegundoNombre;
    }

    public void setPerSegundoNombre(String perSegundoNombre) {
        this.perSegundoNombre = perSegundoNombre;
    }

    public String getPerPrimerApellido() {
        return perPrimerApellido;
    }

    public void setPerPrimerApellido(String perPrimerApellido) {
        this.perPrimerApellido = perPrimerApellido;
    }

    public String getPerSegundoApellido() {
        return perSegundoApellido;
    }

    public void setPerSegundoApellido(String perSegundoApellido) {
        this.perSegundoApellido = perSegundoApellido;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerUsuario() {
        return perUsuario;
    }

    public void setPerUsuario(String perUsuario) {
        this.perUsuario = perUsuario;
    }

    public String getPerClave() {
        return perClave;
    }

    public void setPerClave(String perClave) {
        this.perClave = perClave;
    }

    public int getEcvId() {
        return ecvId;
    }

    public void setEcvId(int ecvId) {
        this.ecvId = ecvId;
    }

    public PftDepartamento getPerIdDepartamento() {
        return perIdDepartamento;
    }

    public void setPerIdDepartamento(PftDepartamento perIdDepartamento) {
        this.perIdDepartamento = perIdDepartamento;
    }

    public PftPrograma getPraId() {
        return praId;
    }

    public void setPraId(PftPrograma praId) {
        this.praId = praId;
    }

    public PftRol getPerIdRol() {
        return perIdRol;
    }

    public void setPerIdRol(PftRol perIdRol) {
        this.perIdRol = perIdRol;
    }

    public PftSeccion getPerIdSeccion() {
        return perIdSeccion;
    }

    public void setPerIdSeccion(PftSeccion perIdSeccion) {
        this.perIdSeccion = perIdSeccion;
    }

    @XmlTransient
    public List<PftAprobacion> getPftAprobacionList() {
        return pftAprobacionList;
    }

    public void setPftAprobacionList(List<PftAprobacion> pftAprobacionList) {
        this.pftAprobacionList = pftAprobacionList;
    }

    @XmlTransient
    public List<PftHistorialCambios> getPftHistorialCambiosList() {
        return pftHistorialCambiosList;
    }

    public void setPftHistorialCambiosList(List<PftHistorialCambios> pftHistorialCambiosList) {
        this.pftHistorialCambiosList = pftHistorialCambiosList;
    }

    @XmlTransient
    public List<PftProyecto> getPftProyectoList() {
        return pftProyectoList;
    }

    public void setPftProyectoList(List<PftProyecto> pftProyectoList) {
        this.pftProyectoList = pftProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftPersona)) {
            return false;
        }
        PftPersona other = (PftPersona) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftPersona[ entId=" + entId + " ]";
    }

}
