/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesAdministrateur.managedBeans;

import alpha.entite.model.ClientEntreprise;
import alpha.metier.modelManager.ClientEntrepriseManager;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BOTREL Jordan
 */
@RequestScoped
@ManagedBean
public class AjoutEntrepriseManagedBeans implements Serializable {

    private ClientEntrepriseManager clientEntrepriseManager;
    private ClientEntreprise clientEntreprise;

    /**
     * Creates a new instance of AjoutEntrepriseManagedBeans
     */
    public AjoutEntrepriseManagedBeans() {
        this.clientEntrepriseManager = new ClientEntrepriseManager();
        this.clientEntreprise = new ClientEntreprise();
    }

    public void enregistrer() {

        clientEntrepriseManager.create(clientEntreprise);

    }

    public ClientEntrepriseManager getClientEntrepriseManager() {
        return clientEntrepriseManager;
    }

    public void setClientEntrepriseManager(ClientEntrepriseManager clientEntrepriseManager) {
        this.clientEntrepriseManager = clientEntrepriseManager;
    }

    public ClientEntreprise getClientEntreprise() {
        return clientEntreprise;
    }

    public void setClientEntreprise(ClientEntreprise clientEntreprise) {
        this.clientEntreprise = clientEntreprise;
    }

}
