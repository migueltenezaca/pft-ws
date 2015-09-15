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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel Tenezaca
 */
@Entity
@Table(name = "pft_nivel_academico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftNivelAcademico.findAll", query = "SELECT p FROM PftNivelAcademico p"),
    @NamedQuery(name = "PftNivelAcademico.findByNacId", query = "SELECT p FROM PftNivelAcademico p WHERE p.nacId = :nacId"),
    @NamedQuery(name = "PftNivelAcademico.findByNacNombre", query = "SELECT p FROM PftNivelAcademico p WHERE p.nacNombre = :nacNombre"),
    @NamedQuery(name = "PftNivelAcademico.findByNacDescripcion", query = "SELECT p FROM PftNivelAcademico p WHERE p.nacDescripcion = :nacDescripcion"),
    @NamedQuery(name = "PftNivelAcademico.findByNacCodigo", query = "SELECT p FROM PftNivelAcademico p WHERE p.nacCodigo = :nacCodigo")})
public class PftNivelAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAC_ID")
    private Integer nacId;
    @Size(max = 45)
    @Column(name = "NAC_NOMBRE")
    private String nacNombre;
    @Size(max = 45)
    @Column(name = "NAC_DESCRIPCION")
    private String nacDescripcion;
    @Size(max = 45)
    @Column(name = "NAC_CODIGO")
    private String nacCodigo;
    @OneToMany(mappedBy = "nacId")
    private List<PftPrograma> pftProgramaList;

    public PftNivelAcademico() {
    }

    public PftNivelAcademico(Integer nacId) {
        this.nacId = nacId;
    }

    public Integer getNacId() {
        return nacId;
    }

    public void setNacId(Integer nacId) {
        this.nacId = nacId;
    }

    public String getNacNombre() {
        return nacNombre;
    }

    public void setNacNombre(String nacNombre) {
        this.nacNombre = nacNombre;
    }

    public String getNacDescripcion() {
        return nacDescripcion;
    }

    public void setNacDescripcion(String nacDescripcion) {
        this.nacDescripcion = nacDescripcion;
    }

    public String getNacCodigo() {
        return nacCodigo;
    }

    public void setNacCodigo(String nacCodigo) {
        this.nacCodigo = nacCodigo;
    }

    @XmlTransient
    public List<PftPrograma> getPftProgramaList() {
        return pftProgramaList;
    }

    public void setPftProgramaList(List<PftPrograma> pftProgramaList) {
        this.pftProgramaList = pftProgramaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nacId != null ? nacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftNivelAcademico)) {
            return false;
        }
        PftNivelAcademico other = (PftNivelAcademico) object;
        if ((this.nacId == null && other.nacId != null) || (this.nacId != null && !this.nacId.equals(other.nacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftNivelAcademico[ nacId=" + nacId + " ]";
    }
    
}
