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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_componentes_desarrollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftComponentesDesarrollo.findAll", query = "SELECT p FROM PftComponentesDesarrollo p"),
    @NamedQuery(name = "PftComponentesDesarrollo.findByCompDeId", query = "SELECT p FROM PftComponentesDesarrollo p WHERE p.compDeId = :compDeId"),
    @NamedQuery(name = "PftComponentesDesarrollo.findByCompDeComponente", query = "SELECT p FROM PftComponentesDesarrollo p WHERE p.compDeComponente = :compDeComponente")})
public class PftComponentesDesarrollo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comp_de_id")
    private Integer compDeId;
    @Size(max = 100)
    @Column(name = "comp_de_componente")
    private String compDeComponente;
    @OneToMany(mappedBy = "proyCoIdCompDesarrollo")
    private List<PftProyectoComponentes> pftProyectoComponentesList;

    public PftComponentesDesarrollo() {
    }

    public PftComponentesDesarrollo(Integer compDeId) {
        this.compDeId = compDeId;
    }

    public Integer getCompDeId() {
        return compDeId;
    }

    public void setCompDeId(Integer compDeId) {
        this.compDeId = compDeId;
    }

    public String getCompDeComponente() {
        return compDeComponente;
    }

    public void setCompDeComponente(String compDeComponente) {
        this.compDeComponente = compDeComponente;
    }

    @XmlTransient
    public List<PftProyectoComponentes> getPftProyectoComponentesList() {
        return pftProyectoComponentesList;
    }

    public void setPftProyectoComponentesList(List<PftProyectoComponentes> pftProyectoComponentesList) {
        this.pftProyectoComponentesList = pftProyectoComponentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compDeId != null ? compDeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftComponentesDesarrollo)) {
            return false;
        }
        PftComponentesDesarrollo other = (PftComponentesDesarrollo) object;
        if ((this.compDeId == null && other.compDeId != null) || (this.compDeId != null && !this.compDeId.equals(other.compDeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftComponentesDesarrollo[ compDeId=" + compDeId + " ]";
    }
    
}
