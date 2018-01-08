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
    
    public void finaliseerGroep(String nr){
        BigDecimal grpnr = new BigDecimal(nr);
        Groepen gr = (Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",grpnr).getSingleResult();
        gr.setFinaal(new BigInteger("1"));
        em.persist(gr);
    }
    
    public String isGroepFinaal (String nr)
    {
        BigDecimal grpnr = new BigDecimal(nr);
        Groepen gr = (Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",grpnr).getSingleResult();
        BigInteger f = gr.getFinaal();
        String fin = f.toString();
        return fin;
    }
    
    public List getStudentenInGroep(String gid){
        BigDecimal groep = new BigDecimal(gid);
        Groepen gr =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",groep).getSingleResult();
        List nr = em.createNamedQuery("Studenten.findSnrByGid").setParameter("gid",gr).getResultList();
        List namen = getNaam(nr);
        return namen;
    }
    
    public List getStudentenZonderGroep(){
        Groepen gr =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",new BigDecimal(0)).getSingleResult();
        List nr = em.createNamedQuery("Studenten.findSnrByGid").setParameter("gid",gr).getResultList();
        List namen = getNaam(nr);
        return namen;
    }
    
    public List getVrienden (String gid)
    {
        //Haal studenten op die in de groep zitten
        BigDecimal groep = new BigDecimal(gid);
        Groepen gr =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",groep).getSingleResult();
        List nr = em.createNamedQuery("Studenten.findSnrByGid").setParameter("gid",gr).getResultList();
        //Haal Studenten zonder groep
        Groepen g =(Groepen) em.createNamedQuery("Groepen.findByGid").setParameter("gid",new BigDecimal(0)).getSingleResult();
        List n = em.createNamedQuery("Studenten.findSnrByGid").setParameter("gid",g).getResultList();
        //Haal vrienden van studenten
        List vrienden = new ArrayList();
        for (int i=0; i<nr.size() ;i++)
        {
            Studenten s = (Studenten) em.createNamedQuery("Studenten.findBySnr").setParameter("snr",nr.get(i)).getSingleResult();
            List v = em.createNamedQuery("Wel.findFriends").setParameter("aanvrager",s).getResultList();
            vrienden.add(v);
        }
        List namen = verwijderHaakjes(vrienden);
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
    
    private List getNaam (List in)
    {
        List namen = new ArrayList();
        for (int i=0; i<in.size() ;i++)
        {
            String naam = (String) em.createNamedQuery("Gebruikers.findNamebyGnr").setParameter("gnr",in.get(i)).getSingleResult();
            namen.add(naam);
        }
        return namen;
    }
    
    private List verwijderHaakjes (List in)
    {
        List out = new ArrayList();
        for (int i=0; i<in.size() ;i++)
        {
            String naam = in.get(i).toString();
            out.add(naam.substring(1, naam.length()-1));
        }
        return out;
    }
}
