/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Forfait;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ForfaitDAO extends GeneriqDAO<Forfait> {

    public ForfaitDAO() {
        super(Forfait.class);
    }

    public ForfaitDAO(Session session) {
        super(session, Forfait.class);
    }
}
