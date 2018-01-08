/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boon;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "WEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wel.findAll", query = "SELECT w FROM Wel w")
    , @NamedQuery(name = "Wel.findByWnr", query = "SELECT w FROM Wel w WHERE w.wnr = :wnr")
    , @NamedQuery(name = "Wel.findFriends", query="SELECT w.vriend.snr FROM Wel w WHERE w.aanvrager= :aanvrager")})
public class Wel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WNR")
    private BigDecimal wnr;
    @JoinColumn(name = "VRIEND", referencedColumnName = "SNR")
    @ManyToOne
    private Studenten vriend;
    @JoinColumn(name = "AANVRAGER", referencedColumnName = "SNR")
    @ManyToOne
    private Studenten aanvrager;

    public Wel() {
    }

    public Wel(BigDecimal wnr) {
        this.wnr = wnr;
    }

    public BigDecimal getWnr() {
        return wnr;
    }

    public void setWnr(BigDecimal wnr) {
        this.wnr = wnr;
    }

    public Studenten getVriend() {
        return vriend;
    }

    public void setVriend(Studenten vriend) {
        this.vriend = vriend;
    }

    public Studenten getAanvrager() {
        return aanvrager;
    }

    public void setAanvrager(Studenten aanvrager) {
        this.aanvrager = aanvrager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wnr != null ? wnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wel)) {
            return false;
        }
        Wel other = (Wel) object;
        if ((this.wnr == null && other.wnr != null) || (this.wnr != null && !this.wnr.equals(other.wnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boon.Wel[ wnr=" + wnr + " ]";
    }
    
}
