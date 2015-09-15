/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftProyecto.findAll", query = "SELECT p FROM PftProyecto p"),
    @NamedQuery(name = "PftProyecto.findByProId", query = "SELECT p FROM PftProyecto p WHERE p.proId = :proId"),
    @NamedQuery(name = "PftProyecto.findByProTitulo", query = "SELECT p FROM PftProyecto p WHERE p.proTitulo = :proTitulo"),
    @NamedQuery(name = "PftProyecto.findByProDuracion", query = "SELECT p FROM PftProyecto p WHERE p.proDuracion = :proDuracion"),
    @NamedQuery(name = "PftProyecto.findByProComponenteTeorico", query = "SELECT p FROM PftProyecto p WHERE p.proComponenteTeorico = :proComponenteTeorico"),
    @NamedQuery(name = "PftProyecto.findByProComponentePractico", query = "SELECT p FROM PftProyecto p WHERE p.proComponentePractico = :proComponentePractico")})
public class PftProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Size(max = 45)
    @Column(name = "pro_titulo")
    private String proTitulo;
    @Size(max = 45)
    @Column(name = "pro_duracion")
    private String proDuracion;
    @Lob
    @Size(max = 65535)
    @Column(name = "pro_descripcion")
    private String proDescripcion;
    @Size(max = 45)
    @Column(name = "pro_componente_teorico")
    private String proComponenteTeorico;
    @Size(max = 45)
    @Column(name = "pro_componente_practico")
    private String proComponentePractico;
    @Lob
    @Size(max = 65535)
    @Column(name = "pro_proposito")
    private String proProposito;
    @OneToMany(mappedBy = "plaIdProyecto")
    private List<PftPlanificacion> pftPlanificacionList;
    @OneToMany(mappedBy = "aproIdProyecto")
    private List<PftAprobacion> pftAprobacionList;
    @OneToMany(mappedBy = "proyCoIdProyecto")
    private List<PftProyectoComponentes> pftProyectoComponentesList;
    @OneToMany(mappedBy = "histIdProyecto")
    private List<PftHistorialCambios> pftHistorialCambiosList;
    @JoinColumn(name = "pro_id_persona", referencedColumnName = "ENT_ID")
    @ManyToOne(optional = false)
    private PftPersona proIdPersona;
    @OneToMany(mappedBy = "proyCompIdProyecto")
    private List<PftProyectoCompetencia> pftProyectoCompetenciaList;

    public PftProyecto() {
    }

    public PftProyecto(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProTitulo() {
        return proTitulo;
    }

    public void setProTitulo(String proTitulo) {
        this.proTitulo = proTitulo;
    }

    public String getProDuracion() {
        return proDuracion;
    }

    public void setProDuracion(String proDuracion) {
        this.proDuracion = proDuracion;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public String getProComponenteTeorico() {
        return proComponenteTeorico;
    }

    public void setProComponenteTeorico(String proComponenteTeorico) {
        this.proComponenteTeorico = proComponenteTeorico;
    }

    public String getProComponentePractico() {
        return proComponentePractico;
    }

    public void setProComponentePractico(String proComponentePractico) {
        this.proComponentePractico = proComponentePractico;
    }

    public String getProProposito() {
        return proProposito;
    }

    public void setProProposito(String proProposito) {
        this.proProposito = proProposito;
    }

    @XmlTransient
    public List<PftPlanificacion> getPftPlanificacionList() {
        return pftPlanificacionList;
    }

    public void setPftPlanificacionList(List<PftPlanificacion> pftPlanificacionList) {
        this.pftPlanificacionList = pftPlanificacionList;
    }

    @XmlTransient
    public List<PftAprobacion> getPftAprobacionList() {
        return pftAprobacionList;
    }

    public void setPftAprobacionList(List<PftAprobacion> pftAprobacionList) {
        this.pftAprobacionList = pftAprobacionList;
    }

    @XmlTransient
    public List<PftProyectoComponentes> getPftProyectoComponentesList() {
        return pftProyectoComponentesList;
    }

    public void setPftProyectoComponentesList(List<PftProyectoComponentes> pftProyectoComponentesList) {
        this.pftProyectoComponentesList = pftProyectoComponentesList;
    }

    @XmlTransient
    public List<PftHistorialCambios> getPftHistorialCambiosList() {
        return pftHistorialCambiosList;
    }

    public void setPftHistorialCambiosList(List<PftHistorialCambios> pftHistorialCambiosList) {
        this.pftHistorialCambiosList = pftHistorialCambiosList;
    }

    public PftPersona getProIdPersona() {
        return proIdPersona;
    }

    public void setProIdPersona(PftPersona proIdPersona) {
        this.proIdPersona = proIdPersona;
    }

    @XmlTransient
    public List<PftProyectoCompetencia> getPftProyectoCompetenciaList() {
        return pftProyectoCompetenciaList;
    }

    public void setPftProyectoCompetenciaList(List<PftProyectoCompetencia> pftProyectoCompetenciaList) {
        this.pftProyectoCompetenciaList = pftProyectoCompetenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftProyecto)) {
            return false;
        }
        PftProyecto other = (PftProyecto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftProyecto[ proId=" + proId + " ]";
    }
    
}
