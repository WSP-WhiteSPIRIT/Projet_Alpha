/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.metier.metier.algo;

import alpha.entite.model.DepartementFrance;
import alpha.entite.model.Etat;
import alpha.entite.model.Marque;
import alpha.entite.model.Reparateur;
import alpha.entite.model.Reparation;
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
            Reparateur rep = new ReparateurManager().getById(reparateur.getId());
            System.out.println("selectReparateursDisponibles : "+rep.getRaisonSociale());
            for (Marque marqueRep : rep.getMarques()) {
                if(marqueRep.getId()== marque.getId()){
                    reparateursMarque.add(reparateur);
                }
            }
        }
        
        for (Reparateur reparateur : reparateursMarque) {


            Reparateur rep = new ReparateurManager().getById(reparateur.getId());
            for (DepartementFrance departementRep : rep.getDepartementFrances()) {
                if(departementRep.getNumDep().equals(departement.getNumDep())){
                    reparateursDisponibles.add(reparateur);
                }
            }
        }
    }
    
    private Reparateur selectBestReparateur(){
        int chargeLibre=0;
        
        for (Reparateur reparateur : reparateursDisponibles) {
            int chargeLibreRep=reparateur.getChargeMax()-getChargeReparateur(reparateur);
            if(chargeLibreRep>chargeLibre){
                chargeLibre=chargeLibreRep;
                reparateurSelectionne=reparateur;
            }
        }
        
        if(chargeLibre==0)reparateurSelectionne=reparateursDisponibles.get(0);
        
        return reparateurSelectionne;
    }

    private int getChargeReparateur(Reparateur reparateur) {
        int charge = 0;
        Reparateur rep= new ReparateurManager().getById(reparateur.getId());
        for (Reparation reparation : rep.getReparations()) {
            if(reparation.getEtat()!=Etat.REPARATION_TERMINEE&&reparation.getEtat()!=Etat.LIVRAISON){
                charge++;
            }
        }
        return charge;
    }

}
