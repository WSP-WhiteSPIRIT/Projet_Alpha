/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.vue.validatorCommun;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author INTI0220
 */
public class ValidateCost implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
String saisie = (String) value;
Double cout = Double.parseDouble(saisie);

        try {
              
            if(saisie.isEmpty()||cout.isNaN()){
                throw new Exception("Le cout doit etre exprimé en chiffres.");
            }
            if(cout<0){
                throw new Exception("Le cout doit etre positif.");
            }
            
        } catch (Exception ex) {
            throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }    }
    
}
