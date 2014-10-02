/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Modele;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ModeleDAO extends GeneriqDAO<Modele> {

    public ModeleDAO() {
        super(Modele.class);
    }

    public ModeleDAO(Session session) {
        super(session, Modele.class);
    }
}
