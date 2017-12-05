/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonen;


import Boon.Groepen;
import Boon.Studenten;
import java.math.*;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author student
 */
@Stateless
public class docentenboon implements docentenboonRemote {
    @PersistenceContext private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List getGroepen (){
        List groepen = em.createNamedQuery("Groepen.findGroupNr").setParameter("gid",new BigDecimal(0)).getResultList();
        return groepen;
    }
    
    public void voegGroepToe(){
        Groepen gr = new Groepen();
        BigDecimal grpnr = (BigDecimal) em.createNamedQuery("Groepen.findBigNr").getSingleResult();
        grpnr = grpnr.add(new BigDecimal(1));
        gr.setGid(grpnr);
        gr.setGnaam("groep");
        gr.setFinaal(new BigInteger("0"));
        em.persist(gr);
    }
    
    public List getStudentenInGroep(String gid){
        BigDecimal groep = new BigDecimal(gid);
        Groepen gr =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",groep).getSingleResult();
        List nr = em.createNamedQuery("Studenten.findSnrByGid").setParameter("gid",gr).getResultList();
        List namen = new ArrayList();
        for (int i=0; i<nr.size() ;i++)
        {
            String naam = (String) em.createNamedQuery("Gebruikers.findNamebyGnr").setParameter("gnr",nr.get(i)).getSingleResult();
            namen.add(naam);
        }
        return namen;
    }
    
    public List getStudentenZonderGroep(){
        Groepen gr =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",new BigDecimal(0)).getSingleResult();
        List nr = em.createNamedQuery("Studenten.findSnrByGid").setParameter("gid",gr).getResultList();
        List namen = new ArrayList();
        for (int i=0; i<nr.size() ;i++)
        {
            String naam = (String) em.createNamedQuery("Gebruikers.findNamebyGnr").setParameter("gnr",nr.get(i)).getSingleResult();
            namen.add(naam);
        }
        return namen;
    }
    
    public void voegStudentToeAanGroep(String gid, String naam)
    {
        BigDecimal groep = new BigDecimal(gid);
        Groepen gr =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",groep).getSingleResult();
        BigDecimal snr = (BigDecimal) em.createNamedQuery("Gebruikers.findGnrByGebnaam").setParameter("gebnaam",naam).getSingleResult();
        Studenten s = (Studenten) em.createNamedQuery("Studenten.findBySnr").setParameter("snr",snr).getSingleResult();
        s.setGid(gr);
        em.persist(s);
    }
}
