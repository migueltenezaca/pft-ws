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
@Table(name = "pft_aprobacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftAprobacion.findAll", query = "SELECT p FROM PftAprobacion p"),
    @NamedQuery(name = "PftAprobacion.findByAproId", query = "SELECT p FROM PftAprobacion p WHERE p.aproId = :aproId"),
    @NamedQuery(name = "PftAprobacion.findByAproCalificacion", query = "SELECT p FROM PftAprobacion p WHERE p.aproCalificacion = :aproCalificacion")})
public class PftAprobacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "apro_id")
    private Integer aproId;
    @Lob
    @Size(max = 65535)
    @Column(name = "apro_observaciones")
    private String aproObservaciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "apro_recomendaciones")
    private String aproRecomendaciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "apro_comentarios")
    private String aproComentarios;
    @Size(max = 45)
    @Column(name = "apro_calificacion")
    private String aproCalificacion;
    @JoinColumn(name = "apro_id_estado", referencedColumnName = "est_id")
    @ManyToOne
    private PftAproEstado aproIdEstado;
    @JoinColumn(name = "apro_id_persona", referencedColumnName = "ENT_ID")
    @ManyToOne
    private PftPersona aproIdPersona;
    @JoinColumn(name = "apro_id_proyecto", referencedColumnName = "pro_id")
    @ManyToOne
    private PftProyecto aproIdProyecto;
    @OneToMany(mappedBy = "histIdAprobacion")
    private List<PftHistorialCambios> pftHistorialCambiosList;

    public PftAprobacion() {
    }

    public PftAprobacion(Integer aproId) {
        this.aproId = aproId;
    }

    public Integer getAproId() {
        return aproId;
    }

    public void setAproId(Integer aproId) {
        this.aproId = aproId;
    }

    public String getAproObservaciones() {
        return aproObservaciones;
    }

    public void setAproObservaciones(String aproObservaciones) {
        this.aproObservaciones = aproObservaciones;
    }

    public String getAproRecomendaciones() {
        return aproRecomendaciones;
    }

    public void setAproRecomendaciones(String aproRecomendaciones) {
        this.aproRecomendaciones = aproRecomendaciones;
    }

    public String getAproComentarios() {
        return aproComentarios;
    }

    public void setAproComentarios(String aproComentarios) {
        this.aproComentarios = aproComentarios;
    }

    public String getAproCalificacion() {
        return aproCalificacion;
    }

    public void setAproCalificacion(String aproCalificacion) {
        this.aproCalificacion = aproCalificacion;
    }

    public PftAproEstado getAproIdEstado() {
        return aproIdEstado;
    }

    public void setAproIdEstado(PftAproEstado aproIdEstado) {
        this.aproIdEstado = aproIdEstado;
    }

    public PftPersona getAproIdPersona() {
        return aproIdPersona;
    }

    public void setAproIdPersona(PftPersona aproIdPersona) {
        this.aproIdPersona = aproIdPersona;
    }

    public PftProyecto getAproIdProyecto() {
        return aproIdProyecto;
    }

    public void setAproIdProyecto(PftProyecto aproIdProyecto) {
        this.aproIdProyecto = aproIdProyecto;
    }

    @XmlTransient
    public List<PftHistorialCambios> getPftHistorialCambiosList() {
        return pftHistorialCambiosList;
    }

    public void setPftHistorialCambiosList(List<PftHistorialCambios> pftHistorialCambiosList) {
        this.pftHistorialCambiosList = pftHistorialCambiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aproId != null ? aproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftAprobacion)) {
            return false;
        }
        PftAprobacion other = (PftAprobacion) object;
        if ((this.aproId == null && other.aproId != null) || (this.aproId != null && !this.aproId.equals(other.aproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftAprobacion[ aproId=" + aproId + " ]";
    }
    
}
