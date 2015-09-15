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
@Table(name = "pft_proyecto_componentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftProyectoComponentes.findAll", query = "SELECT p FROM PftProyectoComponentes p"),
    @NamedQuery(name = "PftProyectoComponentes.findByProyCoId", query = "SELECT p FROM PftProyectoComponentes p WHERE p.proyCoId = :proyCoId")})
public class PftProyectoComponentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proy_co_id")
    private Integer proyCoId;
    @JoinColumn(name = "proy_co_id_comp_desarrollo", referencedColumnName = "comp_de_id")
    @ManyToOne
    private PftComponentesDesarrollo proyCoIdCompDesarrollo;
    @JoinColumn(name = "proy_co_id_proyecto", referencedColumnName = "pro_id")
    @ManyToOne
    private PftProyecto proyCoIdProyecto;

    public PftProyectoComponentes() {
    }

    public PftProyectoComponentes(Integer proyCoId) {
        this.proyCoId = proyCoId;
    }

    public Integer getProyCoId() {
        return proyCoId;
    }

    public void setProyCoId(Integer proyCoId) {
        this.proyCoId = proyCoId;
    }

    public PftComponentesDesarrollo getProyCoIdCompDesarrollo() {
        return proyCoIdCompDesarrollo;
    }

    public void setProyCoIdCompDesarrollo(PftComponentesDesarrollo proyCoIdCompDesarrollo) {
        this.proyCoIdCompDesarrollo = proyCoIdCompDesarrollo;
    }

    public PftProyecto getProyCoIdProyecto() {
        return proyCoIdProyecto;
    }

    public void setProyCoIdProyecto(PftProyecto proyCoIdProyecto) {
        this.proyCoIdProyecto = proyCoIdProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyCoId != null ? proyCoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftProyectoComponentes)) {
            return false;
        }
        PftProyectoComponentes other = (PftProyectoComponentes) object;
        if ((this.proyCoId == null && other.proyCoId != null) || (this.proyCoId != null && !this.proyCoId.equals(other.proyCoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftProyectoComponentes[ proyCoId=" + proyCoId + " ]";
    }
    
}
