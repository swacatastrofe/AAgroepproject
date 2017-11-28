/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boon;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wouter
 */
@Stateless
public class DatabankRemote implements databank {
    @PersistenceContext private EntityManager em;

    @Override
    public List<String> getNamesStudents() {
        return em.createNamedQuery("Gebruikers.getNamesStuds").getResultList();
    }

    @Override
    public List<String> findNames(String fragment) {
        return em.createNamedQuery("Gebruikers.findName").setParameter("naamfrag", fragment).getResultList();
    }

    @Override
    public List<String> getFriends() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getEnemies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
