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
public class PasswordInscriptionValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        UIInput pwd_new_field_component = (UIInput) component.getAttributes().get("pwd_new_param");
        String pwd_new_val = (String) pwd_new_field_component.getValue();
        String pwd_check_val = (String) value;
        String exception_msg_detail = "Erreur";
        boolean exceptionFound = false;

        if (pwd_check_val.isEmpty() && !pwd_new_val.isEmpty()) {
            exception_msg_detail = "Le champs de validation de \"Mot de Passe\" est obligatoire.";
            exceptionFound = true;
        }
        if (!pwd_check_val.equals(pwd_new_val)) {
            exception_msg_detail = "Les mots de passe doivent correspondre.";
            exceptionFound = true;
        }
        if (exceptionFound) {
            pwd_new_field_component.setValid(false);
            System.out.println(exception_msg_detail);
            throw new ValidatorException(
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Erreur : ",
                            exception_msg_detail
                    )
            );
        } else {
            System.out.println("Les mots de passe correspondent !");
            FacesMessage msg = new FacesMessage("Succès", "Les mots de passe correspondent !");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
