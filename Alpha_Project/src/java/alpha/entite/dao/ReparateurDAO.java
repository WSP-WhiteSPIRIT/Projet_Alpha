/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Reparateur;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ReparateurDAO extends GeneriqDAO<Reparateur> {

    public ReparateurDAO() {
        super(Reparateur.class);
    }

    public ReparateurDAO(Session session) {
        super(session, Reparateur.class);
    }
    
    public Reparateur getByMail(String mail){
        List<Reparateur> list = execFreeHQLQuery("from Reparateur R where R.mail="+mail);
        
        if (!list.isEmpty()){
            return list.get(0);
        }
        
        return null;
        
    }
}
