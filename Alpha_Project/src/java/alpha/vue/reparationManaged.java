/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue;

import alpha.entite.model.Devis;
import alpha.entite.model.Etat;
import alpha.entite.model.Reparateur;
import alpha.entite.model.Reparation;
import alpha.metier.modelManager.DevisManager;
import alpha.metier.modelManager.ReparationManager;
import java.io.Serializable;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author BOTREL Jordan
 */
@ManagedBean
@javax.faces.bean.SessionScoped
public class reparationManaged implements Serializable {

    private Reparation reparation;
    private ExternalContext ex;

    /**
     * Creates a new instance of reparationManaged
     */
    public reparationManaged() {
        ex = FacesContext.getCurrentInstance().getExternalContext();
        ex.getSessionMap().put("role", "Reparateur");
        //reparation = (Reparation) ex.getSessionMap().get("reparation");
        reparation = new Reparation();
    }

    public void reception() {
        if ("Forfait devis".equals(reparation.getForfait().getLibelle())) {
            reparation.setEtat(Etat.DIAGNOSTIC);
        } else {
            reparation.setEtat(Etat.REPARATION_EN_COURS);
        }
        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void devis(String description, String montant) {
        Devis devis = new Devis();
        devis.setCout(Double.parseDouble(montant));
        devis.setDate(new GregorianCalendar());
        devis.setDiagnostic(description);
        devis.setReparateur((Reparateur) ex.getSessionMap().get("connectedClient"));
        devis.setReparation(reparation);

        DevisManager dm = new DevisManager();
        dm.create(devis);

        reparation.setEtat(Etat.ATTENTE_VALIDATION_DEVIS);
        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void validate() {
        reparation.setEtat(Etat.REPARATION_EN_COURS);
        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void noValidate() {
        reparation.setEtat(Etat.PREPARATION_COLIS);
        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void avancement(String description) {
        reparation.getDescriptionReparation().concat("/n" + description);
        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void endRep() {
        reparation.setEtat(Etat.LIVRAISON);

        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void expedition() {
        reparation.setEtat(Etat.LIVRAISON);

        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public void finish() {
        reparation.setEtat(Etat.REPARATION_TERMINEE);

        ReparationManager rm = new ReparationManager();
        rm.update(reparation);
    }

    public Reparation getReparation() {
        return reparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public boolean etatExpedition() {
        return reparation.getEtat().equals(Etat.EXPEDITION);
    }

    public boolean etatDiagnostic() {
        return reparation.getEtat().equals(Etat.DIAGNOSTIC);
    }

    public boolean etatDevis() {
        return reparation.getEtat().equals(Etat.ATTENTE_VALIDATION_DEVIS);
    }

    public boolean etatRepEnCours() {
        return reparation.getEtat().equals(Etat.REPARATION_EN_COURS);
    }

    public boolean etatPrepColis() {
        return reparation.getEtat().equals(Etat.PREPARATION_COLIS);
    }
    
    public boolean etatLivraison() {
        return reparation.getEtat().equals(Etat.LIVRAISON);
    }

    
}
