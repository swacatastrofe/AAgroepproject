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
    public List getStudentenInGroep(String gid);
    public List getStudentenZonderGroep();
    public void voegStudentToeAanGroep(String gid, String naam);
}
