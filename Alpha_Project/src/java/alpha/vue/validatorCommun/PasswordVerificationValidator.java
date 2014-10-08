/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.vue.validatorCommun;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author INTI0224
 */
public class PasswordVerificationValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        UIInput pwd_new_field_component = (UIInput) component.getAttributes().get("pwd_new_param");
        String pwd_new_val = (String) pwd_new_field_component.getValue();
        String pwd_check_val = (String) value;

        if (pwd_check_val.isEmpty() && pwd_new_val.isEmpty()) {
        } else {
            if (!pwd_check_val.equals(pwd_new_val)) {
                pwd_new_field_component.setValid(false);
                throw new ValidatorException(
                        new FacesMessage(
                                FacesMessage.SEVERITY_ERROR,
                                "Erreur : ",
                                "Les mots de passe doivent correspondre."
                        )
                );
            } else {
                System.out.println("Les mots de passe correspondent !");
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Les mots de passe correspondent !");
                FacesContext.getCurrentInstance().addMessage("pwd2", msg);
            }
        }
    }

}
