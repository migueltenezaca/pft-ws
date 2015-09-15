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
@Table(name = "pft_entregable_problema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftEntregableProblema.findAll", query = "SELECT p FROM PftEntregableProblema p"),
    @NamedQuery(name = "PftEntregableProblema.findByEntProId", query = "SELECT p FROM PftEntregableProblema p WHERE p.entProId = :entProId")})
public class PftEntregableProblema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ent_pro_id")
    private Integer entProId;
    @JoinColumn(name = "ent_pro_id_entregable", referencedColumnName = "ent_id")
    @ManyToOne
    private PftEntregable entProIdEntregable;
    @JoinColumn(name = "ent_pro_id_problema", referencedColumnName = "pro_id")
    @ManyToOne
    private PftProblema entProIdProblema;

    public PftEntregableProblema() {
    }

    public PftEntregableProblema(Integer entProId) {
        this.entProId = entProId;
    }

    public Integer getEntProId() {
        return entProId;
    }

    public void setEntProId(Integer entProId) {
        this.entProId = entProId;
    }

    public PftEntregable getEntProIdEntregable() {
        return entProIdEntregable;
    }

    public void setEntProIdEntregable(PftEntregable entProIdEntregable) {
        this.entProIdEntregable = entProIdEntregable;
    }

    public PftProblema getEntProIdProblema() {
        return entProIdProblema;
    }

    public void setEntProIdProblema(PftProblema entProIdProblema) {
        this.entProIdProblema = entProIdProblema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entProId != null ? entProId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftEntregableProblema)) {
            return false;
        }
        PftEntregableProblema other = (PftEntregableProblema) object;
        if ((this.entProId == null && other.entProId != null) || (this.entProId != null && !this.entProId.equals(other.entProId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftEntregableProblema[ entProId=" + entProId + " ]";
    }
    
}
