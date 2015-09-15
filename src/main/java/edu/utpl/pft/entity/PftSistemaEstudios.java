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
@Table(name = "pft_sistema_estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftSistemaEstudios.findAll", query = "SELECT p FROM PftSistemaEstudios p"),
    @NamedQuery(name = "PftSistemaEstudios.findBySisEstId", query = "SELECT p FROM PftSistemaEstudios p WHERE p.sisEstId = :sisEstId"),
    @NamedQuery(name = "PftSistemaEstudios.findBySisEstSistema", query = "SELECT p FROM PftSistemaEstudios p WHERE p.sisEstSistema = :sisEstSistema")})
public class PftSistemaEstudios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sis_est_id")
    private Integer sisEstId;
    @Size(max = 45)
    @Column(name = "sis_est_sistema")
    private String sisEstSistema;

    public PftSistemaEstudios() {
    }

    public PftSistemaEstudios(Integer sisEstId) {
        this.sisEstId = sisEstId;
    }

    public Integer getSisEstId() {
        return sisEstId;
    }

    public void setSisEstId(Integer sisEstId) {
        this.sisEstId = sisEstId;
    }

    public String getSisEstSistema() {
        return sisEstSistema;
    }

    public void setSisEstSistema(String sisEstSistema) {
        this.sisEstSistema = sisEstSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sisEstId != null ? sisEstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftSistemaEstudios)) {
            return false;
        }
        PftSistemaEstudios other = (PftSistemaEstudios) object;
        if ((this.sisEstId == null && other.sisEstId != null) || (this.sisEstId != null && !this.sisEstId.equals(other.sisEstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftSistemaEstudios[ sisEstId=" + sisEstId + " ]";
    }
    
}
