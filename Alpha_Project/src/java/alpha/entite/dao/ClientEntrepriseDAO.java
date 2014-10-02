/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.ClientEntreprise;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ClientEntrepriseDAO extends GeneriqDAO<ClientEntreprise> {

    public ClientEntrepriseDAO() {
        super(ClientEntreprise.class);
    }

    public ClientEntrepriseDAO(Session session) {
        super(session, ClientEntreprise.class);
    }
}
