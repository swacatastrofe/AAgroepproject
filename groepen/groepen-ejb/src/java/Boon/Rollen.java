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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "ROLLEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rollen.findAll", query = "SELECT r FROM Rollen r")
    , @NamedQuery(name = "Rollen.findByRid", query = "SELECT r FROM Rollen r WHERE r.rid = :rid")
    , @NamedQuery(name = "Rollen.findByRnaam", query = "SELECT r FROM Rollen r WHERE r.rnaam = :rnaam")})
public class Rollen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RID")
    private BigDecimal rid;
    @Size(max = 20)
    @Column(name = "RNAAM")
    private String rnaam;
    @JoinColumn(name = "RID", referencedColumnName = "GNR", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Gebruikers gebruikers;

    public Rollen() {
    }

    public Rollen(BigDecimal rid) {
        this.rid = rid;
    }

    public BigDecimal getRid() {
        return rid;
    }

    public void setRid(BigDecimal rid) {
        this.rid = rid;
    }

    public String getRnaam() {
        return rnaam;
    }

    public void setRnaam(String rnaam) {
        this.rnaam = rnaam;
    }

    public Gebruikers getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(Gebruikers gebruikers) {
        this.gebruikers = gebruikers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rollen)) {
            return false;
        }
        Rollen other = (Rollen) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boon.Rollen[ rid=" + rid + " ]";
    }
    
}
