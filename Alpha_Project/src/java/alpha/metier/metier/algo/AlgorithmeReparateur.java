/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.metier.algo;

import alpha.entite.model.DepartementFrance;
import alpha.entite.model.Marque;
import alpha.entite.model.Reparateur;
import alpha.metier.modelManager.ReparateurManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author INTI0220
 */
public class AlgorithmeReparateur {
    
    private List<Reparateur> reparateursDisponibles= new LinkedList<>();
    private List<Reparateur> reparateursPotentiels;
    private Reparateur reparateurSelectionne;
    
    
    public Reparateur selectReparateurACharger(Marque marque, DepartementFrance departement){
        loadReparateursPotentiels();
        
        selectReparateursDisponibles(marque, departement);
        
        return selectBestReparateur();
    }
    
    private void loadReparateursPotentiels(){
        ReparateurManager managerReparateur = new ReparateurManager();
        reparateursPotentiels = managerReparateur.getAll();
    }
    
    private void selectReparateursDisponibles(Marque marque, DepartementFrance departement){
        List<Reparateur> reparateursMarque = new ArrayList<Reparateur>() ;
        for (Reparateur reparateur : reparateursPotentiels) {
            for (Marque marqueRep : reparateur.getMarques()) {
                if(marqueRep.equals(marque)){
                    reparateursMarque.add(reparateur);
                }
            }
        }
        
        for (Reparateur reparateur : reparateursMarque) {
            for (DepartementFrance departementRep : reparateur.getDepartementFrances()) {
                if(departementRep.equals(departement)){
                    reparateursDisponibles.add(reparateur);
                }
            }
        }
    }
    
    private Reparateur selectBestReparateur(){
        int chargeLibre=0;
        
        for (Reparateur reparateur : reparateursDisponibles) {
            int chargeLibreRep=reparateur.getChargeMax()-reparateur.getCharge();
            if(chargeLibreRep>chargeLibre){
                chargeLibre=chargeLibreRep;
                reparateurSelectionne=reparateur;
            }
        }
        
        if(chargeLibre==0)reparateurSelectionne=reparateursDisponibles.get(0);
        
        return reparateurSelectionne;
    }

}
