/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Reparation;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ReparationDAO extends GeneriqDAO<Reparation> {

    public ReparationDAO() {
        super(Reparation.class);
    }

    public ReparationDAO(Session session) {
        super(session, Reparation.class);
    }
}
