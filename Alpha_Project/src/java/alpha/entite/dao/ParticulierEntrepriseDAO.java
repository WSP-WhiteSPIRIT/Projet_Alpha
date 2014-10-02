/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.ParticulierEntreprise;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ParticulierEntrepriseDAO extends GeneriqDAO<ParticulierEntreprise> {

    public ParticulierEntrepriseDAO() {
        super(ParticulierEntreprise.class);
    }

    public ParticulierEntrepriseDAO(Session session) {
        super(session, ParticulierEntreprise.class);
    }

}
