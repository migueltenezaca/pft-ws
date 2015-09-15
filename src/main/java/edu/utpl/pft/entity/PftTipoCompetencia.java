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
@Table(name = "pft_tipo_competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftTipoCompetencia.findAll", query = "SELECT p FROM PftTipoCompetencia p"),
    @NamedQuery(name = "PftTipoCompetencia.findByTCompId", query = "SELECT p FROM PftTipoCompetencia p WHERE p.tCompId = :tCompId"),
    @NamedQuery(name = "PftTipoCompetencia.findByTCompTipo", query = "SELECT p FROM PftTipoCompetencia p WHERE p.tCompTipo = :tCompTipo")})
public class PftTipoCompetencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t_comp_id")
    private Integer tCompId;
    @Size(max = 100)
    @Column(name = "t_comp_tipo")
    private String tCompTipo;
    @OneToMany(mappedBy = "compIdTipo")
    private List<PftCompetencias> pftCompetenciasList;

    public PftTipoCompetencia() {
    }

    public PftTipoCompetencia(Integer tCompId) {
        this.tCompId = tCompId;
    }

    public Integer getTCompId() {
        return tCompId;
    }

    public void setTCompId(Integer tCompId) {
        this.tCompId = tCompId;
    }

    public String getTCompTipo() {
        return tCompTipo;
    }

    public void setTCompTipo(String tCompTipo) {
        this.tCompTipo = tCompTipo;
    }

    @XmlTransient
    public List<PftCompetencias> getPftCompetenciasList() {
        return pftCompetenciasList;
    }

    public void setPftCompetenciasList(List<PftCompetencias> pftCompetenciasList) {
        this.pftCompetenciasList = pftCompetenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tCompId != null ? tCompId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftTipoCompetencia)) {
            return false;
        }
        PftTipoCompetencia other = (PftTipoCompetencia) object;
        if ((this.tCompId == null && other.tCompId != null) || (this.tCompId != null && !this.tCompId.equals(other.tCompId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftTipoCompetencia[ tCompId=" + tCompId + " ]";
    }
    
}
