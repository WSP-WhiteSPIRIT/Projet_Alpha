/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.ClientParticulier;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ClientParticulierDAO extends GeneriqDAO<ClientParticulier> {

    public ClientParticulierDAO() {
        super(ClientParticulier.class);
    }

    public ClientParticulierDAO(Session session) {
        super(session, ClientParticulier.class);
    }
}
