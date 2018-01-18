/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonen;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author student
 */
@Remote
public interface docentenboonRemote {
    public List getGroepen ();
    public void voegGroepToe();
    public void finaliseerGroep(String nr);
    public String isGroepFinaal (String nr);
    public List getStudentenInGroep(String gid);
    public List getStudentenZonderGroep();
    public int getAantalStudenten ();
    public int getAantalStudentenZonderGroep ();
    public List getVriendenVanStudent (String student);
    public List getVijandenVanStudent (String student);
    public List getVrienden (String gid);
    public List getVijanden (String gid);
    public List getAantalConlficten ();
    public void voegStudentToeAanGroep(String gid, String naam);
}
