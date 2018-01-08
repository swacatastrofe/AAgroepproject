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
@Table(name = "NIET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niet.findAll", query = "SELECT n FROM Niet n")
    , @NamedQuery(name = "Niet.findByNnr", query = "SELECT n FROM Niet n WHERE n.nnr = :nnr")
    , @NamedQuery(name = "Niet.findEnemy", query = "SELECT n.slachtoffer.snr FROM Niet n WHERE n.hater = :hater")})
public class Niet implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NNR")
    private BigDecimal nnr;
    @JoinColumn(name = "SLACHTOFFER", referencedColumnName = "SNR")
    @ManyToOne
    private Studenten slachtoffer;
    @JoinColumn(name = "HATER", referencedColumnName = "SNR")
    @ManyToOne
    private Studenten hater;

    public Niet() {
    }

    public Niet(BigDecimal nnr) {
        this.nnr = nnr;
    }

    public BigDecimal getNnr() {
        return nnr;
    }

    public void setNnr(BigDecimal nnr) {
        this.nnr = nnr;
    }

    public Studenten getSlachtoffer() {
        return slachtoffer;
    }

    public void setSlachtoffer(Studenten slachtoffer) {
        this.slachtoffer = slachtoffer;
    }

    public Studenten getHater() {
        return hater;
    }

    public void setHater(Studenten hater) {
        this.hater = hater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nnr != null ? nnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niet)) {
            return false;
        }
        Niet other = (Niet) object;
        if ((this.nnr == null && other.nnr != null) || (this.nnr != null && !this.nnr.equals(other.nnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boon.Niet[ nnr=" + nnr + " ]";
    }
    
}
