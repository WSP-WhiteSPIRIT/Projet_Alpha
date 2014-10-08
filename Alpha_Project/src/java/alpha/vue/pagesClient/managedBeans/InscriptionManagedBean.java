/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesClient.managedBeans;

import alpha.entite.model.ClientParticulier;
import alpha.metier.modelManager.ClientParticulierManager;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author INTI0224
 */
@RequestScoped
@ManagedBean
public class InscriptionManagedBean implements Serializable {

    private ClientParticulierManager clientParticulierManager;
    private ClientParticulier clientParticulier;

    /**
     * Creates a new instance of InscriptionManagedBean
     */
    public InscriptionManagedBean() {
        clientParticulierManager = new ClientParticulierManager();
        clientParticulier = new ClientParticulier();
    }

    public void enregistrer() {
        System.out.println("azert");
//        clientParticulierManager.create(clientParticulier);

    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public ClientParticulierManager getClientParticulierManager() {
        return clientParticulierManager;
    }
    
    public void setClientParticulierManager(ClientParticulierManager clientParticulierManager) {
        this.clientParticulierManager = clientParticulierManager;
    }
    public ClientParticulier getClientParticulier() {
        return clientParticulier;
    }
    
    public void setClientParticulier(ClientParticulier clientParticulier) {
        this.clientParticulier = clientParticulier;
    }
//</editor-fold>
}
