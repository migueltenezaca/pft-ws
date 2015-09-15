/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "pft_seccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftSeccion.findAll", query = "SELECT p FROM PftSeccion p"),
    @NamedQuery(name = "PftSeccion.findBySecId", query = "SELECT p FROM PftSeccion p WHERE p.secId = :secId"),
    @NamedQuery(name = "PftSeccion.findBySecNombre", query = "SELECT p FROM PftSeccion p WHERE p.secNombre = :secNombre")})
public class PftSeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sec_id")
    private Integer secId;
    @Size(max = 100)
    @Column(name = "sec_nombre")
    private String secNombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "sec_descripcion")
    private String secDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perIdSeccion")
    private List<PftPersona> pftPersonaList;
    @JoinColumn(name = "sec_id_departamento", referencedColumnName = "dept_id")
    @ManyToOne
    private PftDepartamento secIdDepartamento;

    public PftSeccion() {
    }

    public PftSeccion(Integer secId) {
        this.secId = secId;
    }

    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }

    public String getSecNombre() {
        return secNombre;
    }

    public void setSecNombre(String secNombre) {
        this.secNombre = secNombre;
    }

    public String getSecDescripcion() {
        return secDescripcion;
    }

    public void setSecDescripcion(String secDescripcion) {
        this.secDescripcion = secDescripcion;
    }

    @XmlTransient
    public List<PftPersona> getPftPersonaList() {
        return pftPersonaList;
    }

    public void setPftPersonaList(List<PftPersona> pftPersonaList) {
        this.pftPersonaList = pftPersonaList;
    }

    public PftDepartamento getSecIdDepartamento() {
        return secIdDepartamento;
    }

    public void setSecIdDepartamento(PftDepartamento secIdDepartamento) {
        this.secIdDepartamento = secIdDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secId != null ? secId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftSeccion)) {
            return false;
        }
        PftSeccion other = (PftSeccion) object;
        if ((this.secId == null && other.secId != null) || (this.secId != null && !this.secId.equals(other.secId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftSeccion[ secId=" + secId + " ]";
    }
    
}
