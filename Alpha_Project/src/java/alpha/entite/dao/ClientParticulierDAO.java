/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.ClientParticulier;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ClientParticulierDAO extends GeneriqDAO<ClientParticulier> {

    public ClientParticulierDAO() {
        super(ClientParticulier.class);
    }

    public ClientParticulierDAO(Session session) {
        super(session, ClientParticulier.class);
    }
    
    public ClientParticulier getByMail(String mail){
        List<ClientParticulier> list = execFreeHQLQuery("from ClientParticulier CP where CP.mail="+mail);
        
        if (!list.isEmpty()){
            return list.get(0);
        }
        
        return null;
        
    }
}
