/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.vue.pagesReparateur.managedBeans;

import alpha.entite.model.Devis;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author INTI0220
 */
@ManagedBean
@SessionScoped
public class DevisManaged {

    private Devis devis;

    public DevisManaged() {
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
        
        this.devis = (Devis)ex.getSessionMap().get("DevisSelectionné");
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(String cout, String diagnostic) {
        GregorianCalendar date = new GregorianCalendar();
        double coutChiffre = Double.parseDouble(cout);
        this.devis.setDate(date);
        this.devis.setCout(coutChiffre);
        this.devis.setDiagnostic(diagnostic);
        
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    
    
    
}
