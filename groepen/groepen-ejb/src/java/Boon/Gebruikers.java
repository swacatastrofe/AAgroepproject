/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boon;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "GEBRUIKERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gebruikers.findAll", query = "SELECT g FROM Gebruikers g")
    , @NamedQuery(name = "Gebruikers.findByGnr", query = "SELECT g FROM Gebruikers g WHERE g.gnr = :gnr")
    , @NamedQuery(name = "Gebruikers.findByGebnaam", query = "SELECT g FROM Gebruikers g WHERE g.gebnaam = :gebnaam")
    , @NamedQuery(name = "Gebruikers.findByWw", query = "SELECT g FROM Gebruikers g WHERE g.ww = :ww")
    , @NamedQuery(name = "Gebruikers.findNamebyGnr", query = "SELECT g.gebnaam FROM Gebruikers g where g.gnr = :gnr")})
public class Gebruikers implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GNR")
    private BigDecimal gnr;
    @Size(max = 50)
    @Column(name = "GEBNAAM")
    private String gebnaam;
    @Size(max = 20)
    @Column(name = "WW")
    private String ww;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gebruikers")
    private Studenten studenten;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gebruikers")
    private Rollen rollen;

    public Gebruikers() {
    }

    public Gebruikers(BigDecimal gnr) {
        this.gnr = gnr;
    }

    public BigDecimal getGnr() {
        return gnr;
    }

    public void setGnr(BigDecimal gnr) {
        this.gnr = gnr;
    }

    public String getGebnaam() {
        return gebnaam;
    }

    public void setGebnaam(String gebnaam) {
        this.gebnaam = gebnaam;
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww;
    }

    public Studenten getStudenten() {
        return studenten;
    }

    public void setStudenten(Studenten studenten) {
        this.studenten = studenten;
    }

    public Rollen getRollen() {
        return rollen;
    }

    public void setRollen(Rollen rollen) {
        this.rollen = rollen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gnr != null ? gnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebruikers)) {
            return false;
        }
        Gebruikers other = (Gebruikers) object;
        if ((this.gnr == null && other.gnr != null) || (this.gnr != null && !this.gnr.equals(other.gnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boon.Gebruikers[ gnr=" + gnr + " ]";
    }
    
}
