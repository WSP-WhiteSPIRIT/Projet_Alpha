/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.modelManager;

import alpha.entite.dao.ClientParticulierDAO;
import alpha.entite.model.ClientParticulier;
import alpha.metier.modelManager.generique.GeneriqueManager;

/**
 *
 * @author BOTREL Jordan
 */
public class ClientParticulierManager extends GeneriqueManager<ClientParticulier>{

    public ClientParticulierManager() {
        dao = new ClientParticulierDAO();
    }
    
    public ClientParticulier getByMail(String mail){
        ClientParticulierDAO daotmp = (ClientParticulierDAO) dao;
        return daotmp.getByMail(mail);
    }
}
