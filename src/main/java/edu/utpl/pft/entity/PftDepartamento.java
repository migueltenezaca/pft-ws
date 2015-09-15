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
import javax.persistence.Lob;
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
@Table(name = "pft_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftDepartamento.findAll", query = "SELECT p FROM PftDepartamento p"),
    @NamedQuery(name = "PftDepartamento.findByDeptId", query = "SELECT p FROM PftDepartamento p WHERE p.deptId = :deptId"),
    @NamedQuery(name = "PftDepartamento.findByDeptNombre", query = "SELECT p FROM PftDepartamento p WHERE p.deptNombre = :deptNombre")})
public class PftDepartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dept_id")
    private Integer deptId;
    @Size(max = 100)
    @Column(name = "dept_nombre")
    private String deptNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "dept_descripcion")
    private String deptDescripcion;
    @OneToMany(mappedBy = "perIdDepartamento")
    private List<PftPersona> pftPersonaList;
    @OneToMany(mappedBy = "secIdDepartamento")
    private List<PftSeccion> pftSeccionList;

    public PftDepartamento() {
    }

    public PftDepartamento(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptNombre() {
        return deptNombre;
    }

    public void setDeptNombre(String deptNombre) {
        this.deptNombre = deptNombre;
    }

    public String getDeptDescripcion() {
        return deptDescripcion;
    }

    public void setDeptDescripcion(String deptDescripcion) {
        this.deptDescripcion = deptDescripcion;
    }

    @XmlTransient
    public List<PftPersona> getPftPersonaList() {
        return pftPersonaList;
    }

    public void setPftPersonaList(List<PftPersona> pftPersonaList) {
        this.pftPersonaList = pftPersonaList;
    }

    @XmlTransient
    public List<PftSeccion> getPftSeccionList() {
        return pftSeccionList;
    }

    public void setPftSeccionList(List<PftSeccion> pftSeccionList) {
        this.pftSeccionList = pftSeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftDepartamento)) {
            return false;
        }
        PftDepartamento other = (PftDepartamento) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftDepartamento[ deptId=" + deptId + " ]";
    }
    
}
