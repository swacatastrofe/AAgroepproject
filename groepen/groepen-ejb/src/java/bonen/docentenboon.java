/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonen;

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
        List groepen = em.createNamedQuery("Groepen.findGroups").setParameter("gid",new BigDecimal(0)).getResultList();
        return groepen;
    }

    @Override
    public void voegGroepToe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getStudents() {
        List studenten = em.createNamedQuery("Gebruikers.getNamesStud").getResultList();
        return studenten;
    }

    @Override
    public List getStudents(String frag) {
        List studenten = em.createNamedQuery("Gebruikers.findName").setParameter("naamfrag",frag).getResultList();
        return studenten;
    }
}
