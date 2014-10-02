/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;

/**
 *
 * @author INTI0224
 */
import alpha.entite.model.DepartementFrance;
import org.hibernate.Session;

public class DepartementFranceDAO extends GeneriqDAO<DepartementFrance> {

    public DepartementFranceDAO() {
        super(DepartementFrance.class);
    }

    public DepartementFranceDAO(Session session) {
        super(session, DepartementFrance.class);
    }
}
