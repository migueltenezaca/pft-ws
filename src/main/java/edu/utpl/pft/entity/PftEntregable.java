/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_entregable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftEntregable.findAll", query = "SELECT p FROM PftEntregable p"),
    @NamedQuery(name = "PftEntregable.findByEntId", query = "SELECT p FROM PftEntregable p WHERE p.entId = :entId"),
    @NamedQuery(name = "PftEntregable.findByEntEntregable", query = "SELECT p FROM PftEntregable p WHERE p.entEntregable = :entEntregable"),
    @NamedQuery(name = "PftEntregable.findByEntSubEntregable", query = "SELECT p FROM PftEntregable p WHERE p.entSubEntregable = :entSubEntregable"),
    @NamedQuery(name = "PftEntregable.findByEntFechaInicio", query = "SELECT p FROM PftEntregable p WHERE p.entFechaInicio = :entFechaInicio"),
    @NamedQuery(name = "PftEntregable.findByEntFechaFin", query = "SELECT p FROM PftEntregable p WHERE p.entFechaFin = :entFechaFin")})
public class PftEntregable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ent_id")
    private Integer entId;
    @Size(max = 200)
    @Column(name = "ent_entregable")
    private String entEntregable;
    @Size(max = 200)
    @Column(name = "ent_sub_entregable")
    private String entSubEntregable;
    @Column(name = "ent_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date entFechaInicio;
    @Column(name = "ent_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date entFechaFin;
    @OneToMany(mappedBy = "entRiIdEntregable")
    private List<PftEntregableRiesgo> pftEntregableRiesgoList;
    @OneToMany(mappedBy = "plaEnIdEntregable")
    private List<PftPlanificacionEntregable> pftPlanificacionEntregableList;
    @OneToMany(mappedBy = "entProIdEntregable")
    private List<PftEntregableProblema> pftEntregableProblemaList;

    public PftEntregable() {
    }

    public PftEntregable(Integer entId) {
        this.entId = entId;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntEntregable() {
        return entEntregable;
    }

    public void setEntEntregable(String entEntregable) {
        this.entEntregable = entEntregable;
    }

    public String getEntSubEntregable() {
        return entSubEntregable;
    }

    public void setEntSubEntregable(String entSubEntregable) {
        this.entSubEntregable = entSubEntregable;
    }

    public Date getEntFechaInicio() {
        return entFechaInicio;
    }

    public void setEntFechaInicio(Date entFechaInicio) {
        this.entFechaInicio = entFechaInicio;
    }

    public Date getEntFechaFin() {
        return entFechaFin;
    }

    public void setEntFechaFin(Date entFechaFin) {
        this.entFechaFin = entFechaFin;
    }

    @XmlTransient
    public List<PftEntregableRiesgo> getPftEntregableRiesgoList() {
        return pftEntregableRiesgoList;
    }

    public void setPftEntregableRiesgoList(List<PftEntregableRiesgo> pftEntregableRiesgoList) {
        this.pftEntregableRiesgoList = pftEntregableRiesgoList;
    }

    @XmlTransient
    public List<PftPlanificacionEntregable> getPftPlanificacionEntregableList() {
        return pftPlanificacionEntregableList;
    }

    public void setPftPlanificacionEntregableList(List<PftPlanificacionEntregable> pftPlanificacionEntregableList) {
        this.pftPlanificacionEntregableList = pftPlanificacionEntregableList;
    }

    @XmlTransient
    public List<PftEntregableProblema> getPftEntregableProblemaList() {
        return pftEntregableProblemaList;
    }

    public void setPftEntregableProblemaList(List<PftEntregableProblema> pftEntregableProblemaList) {
        this.pftEntregableProblemaList = pftEntregableProblemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entId != null ? entId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftEntregable)) {
            return false;
        }
        PftEntregable other = (PftEntregable) object;
        if ((this.entId == null && other.entId != null) || (this.entId != null && !this.entId.equals(other.entId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftEntregable[ entId=" + entId + " ]";
    }
    
}
