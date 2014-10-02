/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.model.Forfait;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class ForfaitManager extends GeneriqueManager<Forfait>{

    public ForfaitManager() {
        dao = new ForfaitDao();
    }
    
}
