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
@Table(name = "pft_proyecto_competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftProyectoCompetencia.findAll", query = "SELECT p FROM PftProyectoCompetencia p"),
    @NamedQuery(name = "PftProyectoCompetencia.findByProyCompId", query = "SELECT p FROM PftProyectoCompetencia p WHERE p.proyCompId = :proyCompId")})
public class PftProyectoCompetencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proy_comp_id")
    private Integer proyCompId;
    @JoinColumn(name = "proy_comp_id_competencia", referencedColumnName = "comp_id")
    @ManyToOne
    private PftCompetencias proyCompIdCompetencia;
    @JoinColumn(name = "proy_comp_id_nivel_competencia", referencedColumnName = "niv_comp_id")
    @ManyToOne
    private PftNivelCompetencia proyCompIdNivelCompetencia;
    @JoinColumn(name = "proy_comp_id_proyecto", referencedColumnName = "pro_id")
    @ManyToOne
    private PftProyecto proyCompIdProyecto;

    public PftProyectoCompetencia() {
    }

    public PftProyectoCompetencia(Integer proyCompId) {
        this.proyCompId = proyCompId;
    }

    public Integer getProyCompId() {
        return proyCompId;
    }

    public void setProyCompId(Integer proyCompId) {
        this.proyCompId = proyCompId;
    }

    public PftCompetencias getProyCompIdCompetencia() {
        return proyCompIdCompetencia;
    }

    public void setProyCompIdCompetencia(PftCompetencias proyCompIdCompetencia) {
        this.proyCompIdCompetencia = proyCompIdCompetencia;
    }

    public PftNivelCompetencia getProyCompIdNivelCompetencia() {
        return proyCompIdNivelCompetencia;
    }

    public void setProyCompIdNivelCompetencia(PftNivelCompetencia proyCompIdNivelCompetencia) {
        this.proyCompIdNivelCompetencia = proyCompIdNivelCompetencia;
    }

    public PftProyecto getProyCompIdProyecto() {
        return proyCompIdProyecto;
    }

    public void setProyCompIdProyecto(PftProyecto proyCompIdProyecto) {
        this.proyCompIdProyecto = proyCompIdProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyCompId != null ? proyCompId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftProyectoCompetencia)) {
            return false;
        }
        PftProyectoCompetencia other = (PftProyectoCompetencia) object;
        if ((this.proyCompId == null && other.proyCompId != null) || (this.proyCompId != null && !this.proyCompId.equals(other.proyCompId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftProyectoCompetencia[ proyCompId=" + proyCompId + " ]";
    }
    
}
