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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_planificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftPlanificacion.findAll", query = "SELECT p FROM PftPlanificacion p"),
    @NamedQuery(name = "PftPlanificacion.findByPlaId", query = "SELECT p FROM PftPlanificacion p WHERE p.plaId = :plaId")})
public class PftPlanificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pla_id")
    private Integer plaId;
    @Lob
    @Column(name = "pla_cronograma")
    private byte[] plaCronograma;
    @JoinColumn(name = "pla_id_proyecto", referencedColumnName = "pro_id")
    @ManyToOne
    private PftProyecto plaIdProyecto;
    @OneToMany(mappedBy = "plaEnIdPlanificacion")
    private List<PftPlanificacionEntregable> pftPlanificacionEntregableList;

    public PftPlanificacion() {
    }

    public PftPlanificacion(Integer plaId) {
        this.plaId = plaId;
    }

    public Integer getPlaId() {
        return plaId;
    }

    public void setPlaId(Integer plaId) {
        this.plaId = plaId;
    }

    public byte[] getPlaCronograma() {
        return plaCronograma;
    }

    public void setPlaCronograma(byte[] plaCronograma) {
        this.plaCronograma = plaCronograma;
    }

    public PftProyecto getPlaIdProyecto() {
        return plaIdProyecto;
    }

    public void setPlaIdProyecto(PftProyecto plaIdProyecto) {
        this.plaIdProyecto = plaIdProyecto;
    }

    @XmlTransient
    public List<PftPlanificacionEntregable> getPftPlanificacionEntregableList() {
        return pftPlanificacionEntregableList;
    }

    public void setPftPlanificacionEntregableList(List<PftPlanificacionEntregable> pftPlanificacionEntregableList) {
        this.pftPlanificacionEntregableList = pftPlanificacionEntregableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaId != null ? plaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftPlanificacion)) {
            return false;
        }
        PftPlanificacion other = (PftPlanificacion) object;
        if ((this.plaId == null && other.plaId != null) || (this.plaId != null && !this.plaId.equals(other.plaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftPlanificacion[ plaId=" + plaId + " ]";
    }
    
}
