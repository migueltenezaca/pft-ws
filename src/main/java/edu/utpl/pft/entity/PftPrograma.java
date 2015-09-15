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
import javax.persistence.JoinColumn;
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
@Table(name = "pft_programa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftPrograma.findAll", query = "SELECT p FROM PftPrograma p"),
    @NamedQuery(name = "PftPrograma.findByPraId", query = "SELECT p FROM PftPrograma p WHERE p.praId = :praId"),
    @NamedQuery(name = "PftPrograma.findByPraCodigo", query = "SELECT p FROM PftPrograma p WHERE p.praCodigo = :praCodigo"),
    @NamedQuery(name = "PftPrograma.findByPraNombre", query = "SELECT p FROM PftPrograma p WHERE p.praNombre = :praNombre")})
public class PftPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRA_ID")
    private Integer praId;
    @Size(max = 50)
    @Column(name = "PRA_CODIGO")
    private String praCodigo;
    @Size(max = 200)
    @Column(name = "PRA_NOMBRE")
    private String praNombre;
    @OneToMany(mappedBy = "praId")
    private List<PftVariacion> pftVariacionList;
    @OneToMany(mappedBy = "praId")
    private List<PftPersona> pftPersonaList;
    @JoinColumn(name = "NAC_ID", referencedColumnName = "NAC_ID")
    @ManyToOne
    private PftNivelAcademico nacId;
    @JoinColumn(name = "MOD_ID", referencedColumnName = "MOD_ID")
    @ManyToOne
    private PftModalidad modId;

    public PftPrograma() {
    }

    public PftPrograma(Integer praId) {
        this.praId = praId;
    }

    public Integer getPraId() {
        return praId;
    }

    public void setPraId(Integer praId) {
        this.praId = praId;
    }

    public String getPraCodigo() {
        return praCodigo;
    }

    public void setPraCodigo(String praCodigo) {
        this.praCodigo = praCodigo;
    }

    public String getPraNombre() {
        return praNombre;
    }

    public void setPraNombre(String praNombre) {
        this.praNombre = praNombre;
    }

    @XmlTransient
    public List<PftVariacion> getPftVariacionList() {
        return pftVariacionList;
    }

    public void setPftVariacionList(List<PftVariacion> pftVariacionList) {
        this.pftVariacionList = pftVariacionList;
    }

    @XmlTransient
    public List<PftPersona> getPftPersonaList() {
        return pftPersonaList;
    }

    public void setPftPersonaList(List<PftPersona> pftPersonaList) {
        this.pftPersonaList = pftPersonaList;
    }

    public PftNivelAcademico getNacId() {
        return nacId;
    }

    public void setNacId(PftNivelAcademico nacId) {
        this.nacId = nacId;
    }

    public PftModalidad getModId() {
        return modId;
    }

    public void setModId(PftModalidad modId) {
        this.modId = modId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (praId != null ? praId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftPrograma)) {
            return false;
        }
        PftPrograma other = (PftPrograma) object;
        if ((this.praId == null && other.praId != null) || (this.praId != null && !this.praId.equals(other.praId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftPrograma[ praId=" + praId + " ]";
    }
    
}
