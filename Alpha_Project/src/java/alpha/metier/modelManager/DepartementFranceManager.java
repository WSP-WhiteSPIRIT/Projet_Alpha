/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.dao.DepartementFranceDAO;
import alpha.entite.model.DepartementFrance;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class DepartementFranceManager extends GeneriqueManager<DepartementFrance>{

    public DepartementFranceManager() {
        dao = new DepartementFranceDAO();
    }
       
}
