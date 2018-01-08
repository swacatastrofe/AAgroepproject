/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boon;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "STUDENTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studenten.findAll", query = "SELECT s FROM Studenten s")
    , @NamedQuery(name = "Studenten.findBySnr", query = "SELECT s FROM Studenten s WHERE s.snr = :snr")
    , @NamedQuery(name = "Studenten.findSnrByGid", query = "SELECT s.snr FROM Studenten s WHERE s.gid = :gid")
    , @NamedQuery(name = "Studenten.gindGidBySnr", query = "SELECT s.gid FROM Studenten s WHERE s.snr = :snr")})
public class Studenten implements Serializable {


    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SNR")
    private BigDecimal snr;
    @JoinColumn(name = "SNR", referencedColumnName = "GNR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Gebruikers gebruikers;
    @JoinColumn(name = "GID", referencedColumnName = "GID")
    @ManyToOne
    private Groepen gid;
    @OneToMany(mappedBy = "slachtoffer")
    private Collection<Niet> nietCollection;
    @OneToMany(mappedBy = "hater")
    private Collection<Niet> nietCollection1;
    @OneToMany(mappedBy = "vriend")
    private Collection<Wel> welCollection;
    @OneToMany(mappedBy = "aanvrager")
    private Collection<Wel> welCollection1;

    public Studenten() {
    }

    public Studenten(BigDecimal snr) {
        this.snr = snr;
    }

    public BigDecimal getSnr() {
        return snr;
    }

    public void setSnr(BigDecimal snr) {
        this.snr = snr;
    }

    public Gebruikers getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(Gebruikers gebruikers) {
        this.gebruikers = gebruikers;
    }

    public Groepen getGid() {
        return gid;
    }

    public void setGid(Groepen gid) {
        this.gid = gid;
    }

    @XmlTransient
    public Collection<Niet> getNietCollection() {
        return nietCollection;
    }

    public void setNietCollection(Collection<Niet> nietCollection) {
        this.nietCollection = nietCollection;
    }

    @XmlTransient
    public Collection<Niet> getNietCollection1() {
        return nietCollection1;
    }

    public void setNietCollection1(Collection<Niet> nietCollection1) {
        this.nietCollection1 = nietCollection1;
    }

    @XmlTransient
    public Collection<Wel> getWelCollection() {
        return welCollection;
    }

    public void setWelCollection(Collection<Wel> welCollection) {
        this.welCollection = welCollection;
    }

    @XmlTransient
    public Collection<Wel> getWelCollection1() {
        return welCollection1;
    }

    public void setWelCollection1(Collection<Wel> welCollection1) {
        this.welCollection1 = welCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (snr != null ? snr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studenten)) {
            return false;
        }
        Studenten other = (Studenten) object;
        if ((this.snr == null && other.snr != null) || (this.snr != null && !this.snr.equals(other.snr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boon.Studenten[ snr=" + snr + " ]";
    }
    
}
