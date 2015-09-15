/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_planificacion_entregable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftPlanificacionEntregable.findAll", query = "SELECT p FROM PftPlanificacionEntregable p"),
    @NamedQuery(name = "PftPlanificacionEntregable.findByPlaEnId", query = "SELECT p FROM PftPlanificacionEntregable p WHERE p.plaEnId = :plaEnId")})
public class PftPlanificacionEntregable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pla_en_id")
    private Integer plaEnId;
    @JoinColumn(name = "pla_en_id_entregable", referencedColumnName = "ent_id")
    @ManyToOne
    private PftEntregable plaEnIdEntregable;
    @JoinColumn(name = "pla_en_id_planificacion", referencedColumnName = "pla_id")
    @ManyToOne
    private PftPlanificacion plaEnIdPlanificacion;

    public PftPlanificacionEntregable() {
    }

    public PftPlanificacionEntregable(Integer plaEnId) {
        this.plaEnId = plaEnId;
    }

    public Integer getPlaEnId() {
        return plaEnId;
    }

    public void setPlaEnId(Integer plaEnId) {
        this.plaEnId = plaEnId;
    }

    public PftEntregable getPlaEnIdEntregable() {
        return plaEnIdEntregable;
    }

    public void setPlaEnIdEntregable(PftEntregable plaEnIdEntregable) {
        this.plaEnIdEntregable = plaEnIdEntregable;
    }

    public PftPlanificacion getPlaEnIdPlanificacion() {
        return plaEnIdPlanificacion;
    }

    public void setPlaEnIdPlanificacion(PftPlanificacion plaEnIdPlanificacion) {
        this.plaEnIdPlanificacion = plaEnIdPlanificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaEnId != null ? plaEnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftPlanificacionEntregable)) {
            return false;
        }
        PftPlanificacionEntregable other = (PftPlanificacionEntregable) object;
        if ((this.plaEnId == null && other.plaEnId != null) || (this.plaEnId != null && !this.plaEnId.equals(other.plaEnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftPlanificacionEntregable[ plaEnId=" + plaEnId + " ]";
    }
    
}
