/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.pagesPubliques.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author INTI0224
 */
public class NomInscriptionValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String saisie = (String) value;
        
        if (!saisie.isEmpty()) {
            
        } else {
            
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Nom invalide", "Ce champ est obligatoire."));
        }
    }
}
