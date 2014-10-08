/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesClient.managedBeans;

import alpha.entite.model.ClientEntreprise;
import alpha.metier.modelManager.ClientManager;
import alpha.metier.modelManager.generique.GeneriqueManager;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author INTI0222
 */
@ManagedBean
@SessionScoped
public class FicheClientEntrepriseManagedBean {

    private ClientEntreprise client;
    private String password_validation;
    private boolean passwordChecked = false;
    private GeneriqueManager cem;
    private boolean isSaveAllowed = false;

    //Debug Attributes
    ExternalContext ex;

    public FicheClientEntrepriseManagedBean() {
        ex = FacesContext.getCurrentInstance().getExternalContext();
        cem = new ClientManager();
        simulateSession();
        if (!isClientEntreprise()) {
        } else {
            client = (ClientEntreprise) ex.getSessionMap().get("connectedClient");
            if (client != null) {
                isSaveAllowed = true;
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc="Simulation">
    public void simulateSession() {
        ClientEntreprise clientEntreprise;

        //clientEntreprise.setCodepostal("44000");
        //clientEntreprise.setVille("Nantes");
        //clientEntreprise.setTelephone("0154896327");
        //clientEntreprise.setMdp("azerty");
        clientEntreprise = (ClientEntreprise) cem.getById(1);

        ex.getSessionMap().put("connectedClient", clientEntreprise);
        ex.getSessionMap().put("role", "ClientEntreprise");

    }
//</editor-fold>

    public boolean isClientEntreprise() {
        String role = (String) ex.getSessionMap().get("role");
        return (role.equals("ClientEntreprise"));
    }

//<editor-fold defaultstate="collapsed" desc="getters and setters">
    public boolean isPasswordChecked() {
        return passwordChecked;
    }

    public void setPasswordChecked(boolean passwordChecked) {
        this.passwordChecked = passwordChecked;
    }

    public ClientEntreprise getClient() {
        return client;
    }

    public void setClient(ClientEntreprise client) {
        this.client = client;
    }

    public String getPassword_validation() {
        return password_validation;
    }

    public void setPassword_validation(String password_validation) {
        if (!password_validation.isEmpty()) {
            this.password_validation = password_validation;
        }
    }
//</editor-fold>

    public void enregistrer() {
        if (isSaveAllowed) {
            cem.update(client);
            FacesMessage msg = new FacesMessage("Succès", "Les modifications ont été enregistrées");
            FacesContext.getCurrentInstance().addMessage("button", msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec", "Mise à jour refusée");
            FacesContext.getCurrentInstance().addMessage("button", msg);
        }
    }
}
