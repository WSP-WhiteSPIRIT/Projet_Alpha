/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesClient.managedBeans;

import alpha.entite.model.ClientParticulier;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author INTI0222
 */
@ManagedBean
@SessionScoped
public class FicheClientManagedBean {

    private ClientParticulier client;
    private String password_validation;
    private boolean passwordChecked = false;

    public FicheClientManagedBean() {
        client = new ClientParticulier();
        client.setNom("adrien");
        client.setPrenom("Fehrn");
        client.setAdresse("5 rue des lauriers");
        client.setCodepostal("44000");
        client.setVille("Nantes");
        client.setMail("mail@test.moi");
        client.setMdp("devine");
        client.setTelephone("3606appelleperenoel");

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
        this.password_validation = password_validation;
    }
//</editor-fold>

    public void enregistrer() {
        FacesMessage msg = new FacesMessage("Succès", "Les modifications ont été enregistrées");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        System.out.println(client.getNom());
        System.out.println(client.getPrenom());
        System.out.println(client.getMail());
        System.out.println(client.getCodepostal());
        System.out.println(client.getAdresse());
        System.out.println(client.getVille());
        System.out.println(client.getMdp());
        System.out.println(client.getTelephone());
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
}
