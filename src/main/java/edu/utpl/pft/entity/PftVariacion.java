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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_variacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftVariacion.findAll", query = "SELECT p FROM PftVariacion p"),
    @NamedQuery(name = "PftVariacion.findByEcvId", query = "SELECT p FROM PftVariacion p WHERE p.ecvId = :ecvId"),
    @NamedQuery(name = "PftVariacion.findByEcvNombre", query = "SELECT p FROM PftVariacion p WHERE p.ecvNombre = :ecvNombre"),
    @NamedQuery(name = "PftVariacion.findByEcvTotalCreditos", query = "SELECT p FROM PftVariacion p WHERE p.ecvTotalCreditos = :ecvTotalCreditos")})
public class PftVariacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ECV_ID")
    private Integer ecvId;
    @Size(max = 200)
    @Column(name = "ECV_NOMBRE")
    private String ecvNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "ECV_DESCRIPCION")
    private String ecvDescripcion;
    @Column(name = "ECV_TOTAL_CREDITOS")
    private Integer ecvTotalCreditos;
    @JoinColumn(name = "PRA_ID", referencedColumnName = "PRA_ID")
    @ManyToOne
    private PftPrograma praId;

    public PftVariacion() {
    }

    public PftVariacion(Integer ecvId) {
        this.ecvId = ecvId;
    }

    public Integer getEcvId() {
        return ecvId;
    }

    public void setEcvId(Integer ecvId) {
        this.ecvId = ecvId;
    }

    public String getEcvNombre() {
        return ecvNombre;
    }

    public void setEcvNombre(String ecvNombre) {
        this.ecvNombre = ecvNombre;
    }

    public String getEcvDescripcion() {
        return ecvDescripcion;
    }

    public void setEcvDescripcion(String ecvDescripcion) {
        this.ecvDescripcion = ecvDescripcion;
    }

    public Integer getEcvTotalCreditos() {
        return ecvTotalCreditos;
    }

    public void setEcvTotalCreditos(Integer ecvTotalCreditos) {
        this.ecvTotalCreditos = ecvTotalCreditos;
    }

    public PftPrograma getPraId() {
        return praId;
    }

    public void setPraId(PftPrograma praId) {
        this.praId = praId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecvId != null ? ecvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftVariacion)) {
            return false;
        }
        PftVariacion other = (PftVariacion) object;
        if ((this.ecvId == null && other.ecvId != null) || (this.ecvId != null && !this.ecvId.equals(other.ecvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftVariacion[ ecvId=" + ecvId + " ]";
    }
    
}
