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
@Table(name = "pft_problema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PftProblema.findAll", query = "SELECT p FROM PftProblema p"),
    @NamedQuery(name = "PftProblema.findByProId", query = "SELECT p FROM PftProblema p WHERE p.proId = :proId"),
    @NamedQuery(name = "PftProblema.findByProProblema", query = "SELECT p FROM PftProblema p WHERE p.proProblema = :proProblema")})
public class PftProblema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Size(max = 200)
    @Column(name = "pro_problema")
    private String proProblema;
    @Lob
    @Size(max = 65535)
    @Column(name = "pro_solucion")
    private String proSolucion;
    @Lob
    @Size(max = 65535)
    @Column(name = "pro_impacto")
    private String proImpacto;
    @OneToMany(mappedBy = "entProIdProblema")
    private List<PftEntregableProblema> pftEntregableProblemaList;

    public PftProblema() {
    }

    public PftProblema(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProProblema() {
        return proProblema;
    }

    public void setProProblema(String proProblema) {
        this.proProblema = proProblema;
    }

    public String getProSolucion() {
        return proSolucion;
    }

    public void setProSolucion(String proSolucion) {
        this.proSolucion = proSolucion;
    }

    public String getProImpacto() {
        return proImpacto;
    }

    public void setProImpacto(String proImpacto) {
        this.proImpacto = proImpacto;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PftProblema)) {
            return false;
        }
        PftProblema other = (PftProblema) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utpl.pft.entity.PftProblema[ proId=" + proId + " ]";
    }
    
}
