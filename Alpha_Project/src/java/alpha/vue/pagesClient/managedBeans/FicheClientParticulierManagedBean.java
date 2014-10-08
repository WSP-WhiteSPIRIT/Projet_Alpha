/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesClient.managedBeans;

import alpha.entite.model.Client;
import alpha.entite.model.ClientEntreprise;
import alpha.entite.model.ClientParticulier;
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
public class FicheClientParticulierManagedBean {

    private ClientParticulier client;
    private Client c;
    private String password_validation;
    private boolean passwordChecked = false;
    private GeneriqueManager cpm;
    private boolean isSaveAllowed = false;

    //Debug Attributes
    ExternalContext ex;

    public FicheClientParticulierManagedBean() {
        ex = FacesContext.getCurrentInstance().getExternalContext();
        cpm = new ClientManager();
        simulateSession();
        if (!isClientParticulier()) {
        } else {
            client = (ClientParticulier) ex.getSessionMap().get("connectedClient");
            if (client != null) {
                isSaveAllowed = true;
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc="Simulation">
    public void simulateSession() {
        ClientParticulier clientParticulier;

        //clientParticulier.setId(1);
        //clientParticulier.setNom("Jean");
        //clientParticulier.setPrenom("Moulin");
        //clientParticulier.setMail("j.m@gmail.com");
        //clientParticulier.setAdresse("5 rue des lauriers");
        //clientParticulier.setCodepostal("44000");
        //clientParticulier.setVille("Nantes");
        //clientParticulier.setTelephone("0154896327");
        //clientParticulier.setMdp("azerty");
        clientParticulier = (ClientParticulier) cpm.getById(2);

        ex.getSessionMap().put("connectedClient", clientParticulier);
        ex.getSessionMap().put("role", "ClientParticulier");

    }
//</editor-fold>

    public boolean isClientParticulier() {
        String role = (String) ex.getSessionMap().get("role");
        return (role.equals("ClientParticulier"));
    }

//<editor-fold defaultstate="collapsed" desc="getters and setters">
    public boolean isPasswordChecked() {
        return passwordChecked;
    }

    public void setPasswordChecked(boolean passwordChecked) {
        this.passwordChecked = passwordChecked;
    }

    public ClientParticulier getClient() {
        return client;
    }

    public void setClient(ClientParticulier client) {
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
            cpm.update(client);
            FacesMessage msg = new FacesMessage("Succès", "Les modifications ont été enregistrées");
            FacesContext.getCurrentInstance().addMessage("button", msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Echec", "Mise à jour refusée");
            FacesContext.getCurrentInstance().addMessage("button", msg);
        }
    }
}
