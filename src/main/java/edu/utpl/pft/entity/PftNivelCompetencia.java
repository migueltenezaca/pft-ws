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
@Table(name = "pft_nivel_competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftNivelCompetencia.findAll", query = "SELECT p FROM PftNivelCompetencia p"),
    @NamedQuery(name = "PftNivelCompetencia.findByNivCompId", query = "SELECT p FROM PftNivelCompetencia p WHERE p.nivCompId = :nivCompId"),
    @NamedQuery(name = "PftNivelCompetencia.findByNivCompNivel", query = "SELECT p FROM PftNivelCompetencia p WHERE p.nivCompNivel = :nivCompNivel")})
public class PftNivelCompetencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "niv_comp_id")
    private Integer nivCompId;
    @Size(max = 45)
    @Column(name = "niv_comp_nivel")
    private String nivCompNivel;
    @OneToMany(mappedBy = "proyCompIdNivelCompetencia")
    private List<PftProyectoCompetencia> pftProyectoCompetenciaList;

    public PftNivelCompetencia() {
    }

    public PftNivelCompetencia(Integer nivCompId) {
        this.nivCompId = nivCompId;
    }

    public Integer getNivCompId() {
        return nivCompId;
    }

    public void setNivCompId(Integer nivCompId) {
        this.nivCompId = nivCompId;
    }

    public String getNivCompNivel() {
        return nivCompNivel;
    }

    public void setNivCompNivel(String nivCompNivel) {
        this.nivCompNivel = nivCompNivel;
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
        hash += (nivCompId != null ? nivCompId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftNivelCompetencia)) {
            return false;
        }
        PftNivelCompetencia other = (PftNivelCompetencia) object;
        if ((this.nivCompId == null && other.nivCompId != null) || (this.nivCompId != null && !this.nivCompId.equals(other.nivCompId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftNivelCompetencia[ nivCompId=" + nivCompId + " ]";
    }
    
}
