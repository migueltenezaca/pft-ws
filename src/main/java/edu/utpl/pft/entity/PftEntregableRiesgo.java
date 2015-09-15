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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_entregable_riesgo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftEntregableRiesgo.findAll", query = "SELECT p FROM PftEntregableRiesgo p"),
    @NamedQuery(name = "PftEntregableRiesgo.findByEntRiId", query = "SELECT p FROM PftEntregableRiesgo p WHERE p.entRiId = :entRiId")})
public class PftEntregableRiesgo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ent_ri_id")
    private Integer entRiId;
    @JoinColumn(name = "ent_ri_id_entregable", referencedColumnName = "ent_id")
    @ManyToOne
    private PftEntregable entRiIdEntregable;
    @JoinColumn(name = "ent_ri_id_riesgo", referencedColumnName = "ries_id")
    @ManyToOne
    private PftRiesgo entRiIdRiesgo;

    public PftEntregableRiesgo() {
    }

    public PftEntregableRiesgo(Integer entRiId) {
        this.entRiId = entRiId;
    }

    public Integer getEntRiId() {
        return entRiId;
    }

    public void setEntRiId(Integer entRiId) {
        this.entRiId = entRiId;
    }

    public PftEntregable getEntRiIdEntregable() {
        return entRiIdEntregable;
    }

    public void setEntRiIdEntregable(PftEntregable entRiIdEntregable) {
        this.entRiIdEntregable = entRiIdEntregable;
    }

    public PftRiesgo getEntRiIdRiesgo() {
        return entRiIdRiesgo;
    }

    public void setEntRiIdRiesgo(PftRiesgo entRiIdRiesgo) {
        this.entRiIdRiesgo = entRiIdRiesgo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entRiId != null ? entRiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftEntregableRiesgo)) {
            return false;
        }
        PftEntregableRiesgo other = (PftEntregableRiesgo) object;
        if ((this.entRiId == null && other.entRiId != null) || (this.entRiId != null && !this.entRiId.equals(other.entRiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftEntregableRiesgo[ entRiId=" + entRiId + " ]";
    }
    
}
