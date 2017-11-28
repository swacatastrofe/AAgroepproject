/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boon;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
 * @author student
 */
@Entity
@Table(name = "GROEPEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groepen.findAll", query = "SELECT g FROM Groepen g")
    , @NamedQuery(name = "Groepen.findByGid", query = "SELECT g FROM Groepen g WHERE g.gid = :gid")
    , @NamedQuery(name = "Groepen.findByGnaam", query = "SELECT g FROM Groepen g WHERE g.gnaam = :gnaam")
    , @NamedQuery(name = "Groepen.findByFinaal", query = "SELECT g FROM Groepen g WHERE g.finaal = :finaal")})
public class Groepen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GID")
    private BigDecimal gid;
    @Size(max = 50)
    @Column(name = "GNAAM")
    private String gnaam;
    @Column(name = "FINAAL")
    private BigInteger finaal;
    @OneToMany(mappedBy = "gid")
    private Collection<Studenten> studentenCollection;

    public Groepen() {
    }

    public Groepen(BigDecimal gid) {
        this.gid = gid;
    }

    public BigDecimal getGid() {
        return gid;
    }

    public void setGid(BigDecimal gid) {
        this.gid = gid;
    }

    public String getGnaam() {
        return gnaam;
    }

    public void setGnaam(String gnaam) {
        this.gnaam = gnaam;
    }

    public BigInteger getFinaal() {
        return finaal;
    }

    public void setFinaal(BigInteger finaal) {
        this.finaal = finaal;
    }

    @XmlTransient
    public Collection<Studenten> getStudentenCollection() {
        return studentenCollection;
    }

    public void setStudentenCollection(Collection<Studenten> studentenCollection) {
        this.studentenCollection = studentenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groepen)) {
            return false;
        }
        Groepen other = (Groepen) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boon.Groepen[ gid=" + gid + " ]";
    }
    
}
