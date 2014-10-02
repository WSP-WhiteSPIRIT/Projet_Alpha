/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Administrateur;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class AdministrateurDAO extends GeneriqDAO<Administrateur> {
    public AdministrateurDAO() {
        super(Administrateur.class);
    }

    public AdministrateurDAO(Session session) {
        super(session, Administrateur.class);
    }    
}
