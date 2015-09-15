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
@Table(name = "pft_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftRol.findAll", query = "SELECT p FROM PftRol p"),
    @NamedQuery(name = "PftRol.findByRolId", query = "SELECT p FROM PftRol p WHERE p.rolId = :rolId"),
    @NamedQuery(name = "PftRol.findByRolTipo", query = "SELECT p FROM PftRol p WHERE p.rolTipo = :rolTipo")})
public class PftRol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 100)
    @Column(name = "rol_tipo")
    private String rolTipo;
    @OneToMany(mappedBy = "perIdRol")
    private List<PftPersona> pftPersonaList;

    public PftRol() {
    }

    public PftRol(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(String rolTipo) {
        this.rolTipo = rolTipo;
    }

    @XmlTransient
    public List<PftPersona> getPftPersonaList() {
        return pftPersonaList;
    }

    public void setPftPersonaList(List<PftPersona> pftPersonaList) {
        this.pftPersonaList = pftPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftRol)) {
            return false;
        }
        PftRol other = (PftRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftRol[ rolId=" + rolId + " ]";
    }
    
}
