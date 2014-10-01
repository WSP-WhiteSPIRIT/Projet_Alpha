/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier.metier.algo;

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
    
    
    public static Reparateur selectReparateurACharger(Marque marque, Departement departement){
        loadReparateursPotentiels();
        
        selectReparateursDisponibles(Marque marque, Departement departement);
        
        return selectBestReparateur();
    }
    
    private void loadReparateursPotentiels(){
        ManagerReparateur managerReparateur = new ManagerReparateur();
        reparateursPotentiels = managerReparateur.getAll();
    }
    
    private void selectReparateursDisponibles(Marque marque, Departement departement){
        List<Reparateur> reparateursMarque = new ArrayList<Reparateur>() ;
        for (Reparateur reparateur : reparateursPotentiels) {
            for (Marque marqueRep : reparateur.getMarques()) {
                if(marqueRep.equals(marque)){
                    reparateursMarque.add(reparateur);
                }
            }
        }
        
        for (Reparateur reparateur : reparateursMarque) {
            for (Departement departementRep : reparateur.getDepartements()) {
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
