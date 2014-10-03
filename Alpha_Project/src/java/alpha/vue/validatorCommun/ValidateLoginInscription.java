/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.vue.validatorCommun;

import alpha.entite.model.Administrateur;
import alpha.entite.model.ClientEntreprise;
import alpha.entite.model.ClientParticulier;
import alpha.entite.model.Reparateur;
import alpha.metier.modelManager.AdministrateurManager;
import alpha.metier.modelManager.ClientEntrepriseManager;
import alpha.metier.modelManager.ClientParticulierManager;
import alpha.metier.modelManager.ReparateurManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author INTI0220
 */
public class ValidateLoginInscription implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String saisie = (String) value;
        try {
              
            if(saisie.isEmpty()||!saisie.contains("@")){
          
                throw new Exception("Mail non valide.");
            }
            List<String> allMail = new ArrayList<>();
            
            ClientParticulierManager clientPManager = new ClientParticulierManager();
            for(ClientParticulier client : clientPManager.getAll()){
                allMail.add(client.getMail());
            }
            ReparateurManager reparateurManager = new ReparateurManager();
            for(Reparateur reparateur : reparateurManager.getAll()){
                allMail.add(reparateur.getMail());
            }
            ClientEntrepriseManager clientEManager = new ClientEntrepriseManager();
            for(ClientEntreprise client : clientEManager.getAll()){
                allMail.add(client.getMail());
            }
            AdministrateurManager adminManager = new AdministrateurManager();
            for(Administrateur administrateur : adminManager.getAll()){
                allMail.add(administrateur.getLogin());
            }
            for (String string : allMail) {
                if(saisie.equals(string))throw new Exception("Mail déja existant.");
            }
            
        } catch (Exception ex) {
            throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }
        
    }
    
}
