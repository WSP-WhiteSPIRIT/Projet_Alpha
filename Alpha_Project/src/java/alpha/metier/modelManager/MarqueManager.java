/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.model.Marque;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class MarqueManager extends GeneriqueManager<Marque>{

    public MarqueManager() {
        dao = new MarqueDao();
    }
    
    
}
