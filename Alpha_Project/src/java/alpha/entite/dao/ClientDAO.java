/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.dao;

import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Client;
import org.hibernate.Session;

/**
 *
 * @author INTI0224
 */
public class ClientDAO extends GeneriqDAO<Client> {

    public ClientDAO() {
        super(Client.class);
    }

    public ClientDAO(Session session) {
        super(session, Client.class);
    }
    
    }
