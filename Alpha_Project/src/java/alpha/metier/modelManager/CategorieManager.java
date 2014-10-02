/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.dao.CategorieDAO;
import alpha.entite.model.Categorie;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class CategorieManager extends GeneriqueManager<Categorie>{

    public CategorieManager() {
        this.dao = new CategorieDAO();
    }
    
    
}
