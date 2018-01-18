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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    , @NamedQuery(name = "Studenten.findBySnr", query = "SELECT s FROM Studenten s WHERE s.snr = :snr")})
public class Studenten implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SNR")
    private BigDecimal snr;
    @JoinTable(name = "NIET", joinColumns = {
        @JoinColumn(name = "AANVRAGER", referencedColumnName = "SNR")}, inverseJoinColumns = {
        @JoinColumn(name = "VRIEND", referencedColumnName = "SNR")})
    @ManyToMany
    private Collection<Studenten> studentenCollection;
    @ManyToMany(mappedBy = "studentenCollection")
    private Collection<Studenten> studentenCollection1;
    @JoinTable(name = "WEL", joinColumns = {
        @JoinColumn(name = "HATER", referencedColumnName = "SNR")}, inverseJoinColumns = {
        @JoinColumn(name = "SLACHTOFFER", referencedColumnName = "SNR")})
    @ManyToMany
    private Collection<Studenten> studentenCollection2;
    @ManyToMany(mappedBy = "studentenCollection2")
    private Collection<Studenten> studentenCollection3;
    @JoinColumn(name = "SNR", referencedColumnName = "GNR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Gebruikers gebruikers;
    @JoinColumn(name = "GID", referencedColumnName = "GID")
    @ManyToOne
    private Groepen gid;

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

    @XmlTransient
    public Collection<Studenten> getStudentenCollection() {
        return studentenCollection;
    }

    public void setStudentenCollection(Collection<Studenten> studentenCollection) {
        this.studentenCollection = studentenCollection;
    }

    @XmlTransient
    public Collection<Studenten> getStudentenCollection1() {
        return studentenCollection1;
    }

    public void setStudentenCollection1(Collection<Studenten> studentenCollection1) {
        this.studentenCollection1 = studentenCollection1;
    }

    @XmlTransient
    public Collection<Studenten> getStudentenCollection2() {
        return studentenCollection2;
    }

    public void setStudentenCollection2(Collection<Studenten> studentenCollection2) {
        this.studentenCollection2 = studentenCollection2;
    }

    @XmlTransient
    public Collection<Studenten> getStudentenCollection3() {
        return studentenCollection3;
    }

    public void setStudentenCollection3(Collection<Studenten> studentenCollection3) {
        this.studentenCollection3 = studentenCollection3;
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
