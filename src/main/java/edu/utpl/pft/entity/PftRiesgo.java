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
import javax.persistence.Lob;
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
@Table(name = "pft_riesgo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftRiesgo.findAll", query = "SELECT p FROM PftRiesgo p"),
    @NamedQuery(name = "PftRiesgo.findByRiesId", query = "SELECT p FROM PftRiesgo p WHERE p.riesId = :riesId"),
    @NamedQuery(name = "PftRiesgo.findByRiesRiesgo", query = "SELECT p FROM PftRiesgo p WHERE p.riesRiesgo = :riesRiesgo")})
public class PftRiesgo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ries_id")
    private Integer riesId;
    @Size(max = 200)
    @Column(name = "ries_riesgo")
    private String riesRiesgo;
    @Lob
    @Size(max = 65535)
    @Column(name = "ries_acciones")
    private String riesAcciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "ries_impacto")
    private String riesImpacto;
    @OneToMany(mappedBy = "entRiIdRiesgo")
    private List<PftEntregableRiesgo> pftEntregableRiesgoList;

    public PftRiesgo() {
    }

    public PftRiesgo(Integer riesId) {
        this.riesId = riesId;
    }

    public Integer getRiesId() {
        return riesId;
    }

    public void setRiesId(Integer riesId) {
        this.riesId = riesId;
    }

    public String getRiesRiesgo() {
        return riesRiesgo;
    }

    public void setRiesRiesgo(String riesRiesgo) {
        this.riesRiesgo = riesRiesgo;
    }

    public String getRiesAcciones() {
        return riesAcciones;
    }

    public void setRiesAcciones(String riesAcciones) {
        this.riesAcciones = riesAcciones;
    }

    public String getRiesImpacto() {
        return riesImpacto;
    }

    public void setRiesImpacto(String riesImpacto) {
        this.riesImpacto = riesImpacto;
    }

    @XmlTransient
    public List<PftEntregableRiesgo> getPftEntregableRiesgoList() {
        return pftEntregableRiesgoList;
    }

    public void setPftEntregableRiesgoList(List<PftEntregableRiesgo> pftEntregableRiesgoList) {
        this.pftEntregableRiesgoList = pftEntregableRiesgoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (riesId != null ? riesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftRiesgo)) {
            return false;
        }
        PftRiesgo other = (PftRiesgo) object;
        if ((this.riesId == null && other.riesId != null) || (this.riesId != null && !this.riesId.equals(other.riesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftRiesgo[ riesId=" + riesId + " ]";
    }
    
}
