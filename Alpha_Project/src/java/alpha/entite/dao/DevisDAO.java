/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Devis;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class DevisDAO extends GeneriqDAO<Devis> {

    public DevisDAO() {
        super(Devis.class);
    }

    public DevisDAO(Session session) {
        super(session, Devis.class);
    }
}
