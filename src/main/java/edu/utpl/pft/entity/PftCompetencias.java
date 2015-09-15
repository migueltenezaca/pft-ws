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
@Table(name = "pft_competencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftCompetencias.findAll", query = "SELECT p FROM PftCompetencias p"),
    @NamedQuery(name = "PftCompetencias.findByCompId", query = "SELECT p FROM PftCompetencias p WHERE p.compId = :compId"),
    @NamedQuery(name = "PftCompetencias.findByCompCompetencia", query = "SELECT p FROM PftCompetencias p WHERE p.compCompetencia = :compCompetencia")})
public class PftCompetencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_id")
    private Integer compId;
    @Size(max = 200)
    @Column(name = "comp_competencia")
    private String compCompetencia;
    @JoinColumn(name = "comp_id_tipo", referencedColumnName = "t_comp_id")
    @ManyToOne
    private PftTipoCompetencia compIdTipo;
    @OneToMany(mappedBy = "proyCompIdCompetencia")
    private List<PftProyectoCompetencia> pftProyectoCompetenciaList;

    public PftCompetencias() {
    }

    public PftCompetencias(Integer compId) {
        this.compId = compId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompCompetencia() {
        return compCompetencia;
    }

    public void setCompCompetencia(String compCompetencia) {
        this.compCompetencia = compCompetencia;
    }

    public PftTipoCompetencia getCompIdTipo() {
        return compIdTipo;
    }

    public void setCompIdTipo(PftTipoCompetencia compIdTipo) {
        this.compIdTipo = compIdTipo;
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
        hash += (compId != null ? compId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftCompetencias)) {
            return false;
        }
        PftCompetencias other = (PftCompetencias) object;
        if ((this.compId == null && other.compId != null) || (this.compId != null && !this.compId.equals(other.compId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftCompetencias[ compId=" + compId + " ]";
    }
    
}
