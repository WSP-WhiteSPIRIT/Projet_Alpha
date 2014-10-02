/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.dao.ParticulierEntrepriseDAO;
import alpha.entite.model.ParticulierEntreprise;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class ParticulierEntrepriseManager extends GeneriqueManager<ParticulierEntreprise>{

    public ParticulierEntrepriseManager() {
        dao = new ParticulierEntrepriseDAO();
    }
    
}
