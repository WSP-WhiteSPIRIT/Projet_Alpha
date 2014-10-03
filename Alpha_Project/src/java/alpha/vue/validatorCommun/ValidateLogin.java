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
public class ValidateLogin implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String saisie = (String) value;
        try {
              
            if(saisie.isEmpty()||!saisie.contains("@")){
          
                throw new Exception("Mail non valide.");
            }
            
            
        } catch (Exception ex) {
            throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }
        
    }
    
}
