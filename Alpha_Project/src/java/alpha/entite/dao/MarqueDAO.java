/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Marque;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class MarqueDAO extends GeneriqDAO<Marque> {

    public MarqueDAO() {
        super(Marque.class);
    }

    public MarqueDAO(Session session) {
        super(session, Marque.class);
    }
}
