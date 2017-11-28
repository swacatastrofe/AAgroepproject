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
}
