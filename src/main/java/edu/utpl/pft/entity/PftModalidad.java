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
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
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
@Table(name = "pft_modalidad")
@XmlRootElement
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "modalidadesTodo",
            resultClasses = PftModalidad.class,
            procedureName = "get_modalidades"
    )
}
)
public class PftModalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOD_ID")
    private Integer modId;
    @Size(max = 50)
    @Column(name = "MOD_CODIGO")
    private String modCodigo;
    @Size(max = 200)
    @Column(name = "MOD_NOMBRE")
    private String modNombre;
    @OneToMany(mappedBy = "modId")
    private List<PftPrograma> pftProgramaList;

    public PftModalidad() {
    }

    public PftModalidad(Integer modId) {
        this.modId = modId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModCodigo() {
        return modCodigo;
    }

    public void setModCodigo(String modCodigo) {
        this.modCodigo = modCodigo;
    }

    public String getModNombre() {
        return modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
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
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftModalidad)) {
            return false;
        }
        PftModalidad other = (PftModalidad) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftModalidad[ modId=" + modId + " ]";
    }

}
