/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.dao.AdministrateurDAO;
import alpha.entite.model.Administrateur;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author INTI0220
 */
public class AdministrateurManager extends GeneriqueManager<Administrateur>{

    public AdministrateurManager() {
        this.dao = new AdministrateurDAO();
    }
    
    public Administrateur getByMail(String mail){
        AdministrateurDAO daotmp = (AdministrateurDAO) dao;
        return daotmp.getByMail(mail);
    }
    
}
