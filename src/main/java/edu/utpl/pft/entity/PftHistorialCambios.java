/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_historial_cambios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftHistorialCambios.findAll", query = "SELECT p FROM PftHistorialCambios p"),
    @NamedQuery(name = "PftHistorialCambios.findByHistId", query = "SELECT p FROM PftHistorialCambios p WHERE p.histId = :histId"),
    @NamedQuery(name = "PftHistorialCambios.findByHistFecha", query = "SELECT p FROM PftHistorialCambios p WHERE p.histFecha = :histFecha")})
public class PftHistorialCambios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hist_id")
    private Integer histId;
    @Column(name = "hist_fecha")
    @Temporal(TemporalType.DATE)
    private Date histFecha;
    @JoinColumn(name = "hist_id_aprobacion", referencedColumnName = "apro_id")
    @ManyToOne
    private PftAprobacion histIdAprobacion;
    @JoinColumn(name = "hist_id_persona", referencedColumnName = "ENT_ID")
    @ManyToOne
    private PftPersona histIdPersona;
    @JoinColumn(name = "hist_id_proyecto", referencedColumnName = "pro_id")
    @ManyToOne
    private PftProyecto histIdProyecto;

    public PftHistorialCambios() {
    }

    public PftHistorialCambios(Integer histId) {
        this.histId = histId;
    }

    public Integer getHistId() {
        return histId;
    }

    public void setHistId(Integer histId) {
        this.histId = histId;
    }

    public Date getHistFecha() {
        return histFecha;
    }

    public void setHistFecha(Date histFecha) {
        this.histFecha = histFecha;
    }

    public PftAprobacion getHistIdAprobacion() {
        return histIdAprobacion;
    }

    public void setHistIdAprobacion(PftAprobacion histIdAprobacion) {
        this.histIdAprobacion = histIdAprobacion;
    }

    public PftPersona getHistIdPersona() {
        return histIdPersona;
    }

    public void setHistIdPersona(PftPersona histIdPersona) {
        this.histIdPersona = histIdPersona;
    }

    public PftProyecto getHistIdProyecto() {
        return histIdProyecto;
    }

    public void setHistIdProyecto(PftProyecto histIdProyecto) {
        this.histIdProyecto = histIdProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histId != null ? histId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftHistorialCambios)) {
            return false;
        }
        PftHistorialCambios other = (PftHistorialCambios) object;
        if ((this.histId == null && other.histId != null) || (this.histId != null && !this.histId.equals(other.histId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftHistorialCambios[ histId=" + histId + " ]";
    }
    
}
