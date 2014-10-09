/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesClient.managedBeans;

import alpha.entite.model.ClientParticulier;
import alpha.metier.modelManager.ClientParticulierManager;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author INTI0224
 */
@SessionScoped
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

    public String enregistrer() throws IOException {
        System.out.println("InscriptionManagedBean:enregistrer");
        clientParticulierManager.create(clientParticulier);
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();

        ex.getSessionMap().put("connectedClient", clientParticulier);
        ex.getSessionMap().put("role", "ClientParticulier");

        return  "indexTest";
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
