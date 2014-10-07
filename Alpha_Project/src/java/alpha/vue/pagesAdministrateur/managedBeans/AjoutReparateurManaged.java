/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesAdministrateur.managedBeans;

import alpha.entite.model.DepartementFrance;
import alpha.entite.model.Marque;
import alpha.entite.model.Reparateur;
import alpha.metier.modelManager.DepartementFranceManager;
import alpha.metier.modelManager.MarqueManager;
import alpha.metier.modelManager.ReparateurManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BOTREL Jordan
 */
@RequestScoped
@ManagedBean
public class AjoutReparateurManaged implements Serializable {

    private Reparateur reparateur;
    private ReparateurManager reparateurManager;
    private Map<Integer, DepartementFrance> departement;
    private List<Integer> departementSelectionne;
    private Map<Integer, Marque> marques;
    private List<Integer> marquesSelectionne;

    /**
     * Creates a new instance of AjoutReparateurManaged
     */
    public AjoutReparateurManaged() {
        reparateurManager = new ReparateurManager();
        reparateur = new Reparateur();
        
        DepartementFranceManager departementFranceManager = new DepartementFranceManager();
        departement = new HashMap<Integer, DepartementFrance>();
        for (DepartementFrance df : departementFranceManager.getAll()) {
            departement.put(df.getId(), df);
        }
        departementSelectionne = new ArrayList<>();
        
        marques = new HashMap<>();
        MarqueManager marqueManager = new MarqueManager();
        for(Marque m : marqueManager.getAll()){
            marques.put(m.getId(), m);
        }
        marquesSelectionne = new ArrayList<>();
        
    }

    public Map<Integer, Marque> getMarques() {
        return marques;
    }

    public void setMarques(Map<Integer, Marque> marques) {
        this.marques = marques;
    }

    public List<Integer> getMarquesSelectionne() {
        return marquesSelectionne;
    }

    public void setMarquesSelectionne(List<Integer> marquesSelectionne) {
        this.marquesSelectionne = marquesSelectionne;
    }

    public Reparateur getReparateur() {
        return reparateur;
    }

    public void setReparateur(Reparateur reparateur) {
        this.reparateur = reparateur;
    }

    public Map<Integer, DepartementFrance> getDepartement() {
        return departement;
    }

    public void setDepartement(Map<Integer, DepartementFrance> departement) {
        this.departement = departement;
    }

    public List<Integer> getDepartementSelectionne() {
        return departementSelectionne;
    }

    public void setDepartementSelectionne(List<Integer> departementSelectionne) {
        this.departementSelectionne = departementSelectionne;
    }

    public void ajoutReparateur() {
        List<DepartementFrance> departementIntervention = new ArrayList<>();
        for (int key : departementSelectionne) {
            departementIntervention.add(departement.get(key));
        }
        reparateur.setDepartementFrances(departementIntervention);
        
        List<Marque> marqueIntervention = new ArrayList<>();
        for (int key : marquesSelectionne) {
            marqueIntervention.add(marques.get(key));
        }
        reparateur.setMarques(marqueIntervention);

        reparateurManager.create(reparateur);
    }    
    
}
