/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boon;

import java.util.List;

/**
 *
 * @author Wouter
 */
public interface databank {
    
    public List<String> getNamesStudents();
    public List<String> findNames(String fragment);
    public List<String> getFriends();
    public List<String> getEnemies();
    
}
