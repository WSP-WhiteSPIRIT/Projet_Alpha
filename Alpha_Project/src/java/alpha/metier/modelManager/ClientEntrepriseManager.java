/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.dao.ClientEntrepriseDAO;
import alpha.entite.model.ClientEntreprise;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class ClientEntrepriseManager extends GeneriqueManager<ClientEntreprise>{

    public ClientEntrepriseManager() {
        dao= new ClientEntrepriseDAO();
    }
    
    
    public ClientEntreprise getByMail(String mail){
        ClientEntrepriseDAO daotmp = (ClientEntrepriseDAO) dao;
        return daotmp.getByMail(mail);
    }
    
}
