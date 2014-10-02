/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Categorie;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class CategorieDAO extends GeneriqDAO<Categorie> {

    public CategorieDAO() {
        super(Categorie.class);
    }

    public CategorieDAO(Session session) {
        super(session, Categorie.class);
    }

}
