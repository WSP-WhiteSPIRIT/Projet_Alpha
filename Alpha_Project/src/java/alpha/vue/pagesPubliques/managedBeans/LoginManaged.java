/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alpha.vue.pagesPubliques.managedBeans;

import alpha.entite.model.Administrateur;
import alpha.entite.model.ClientEntreprise;
import alpha.entite.model.ClientParticulier;
import alpha.entite.model.Reparateur;
import alpha.metier.modelManager.AdministrateurManager;
import alpha.metier.modelManager.ClientEntrepriseManager;
import alpha.metier.modelManager.ClientParticulierManager;
import alpha.metier.modelManager.ReparateurManager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author INTI0220
 */
@ManagedBean
@SessionScoped
public class LoginManaged {

    private String mail;
    private String mdp;
    /**
     * Creates a new instance of login
     */
    public LoginManaged() {
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the password
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the password to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public void login() throws Exception{
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
        
        
        ClientParticulierManager clientPManager = new ClientParticulierManager();
        ClientParticulier cp = clientPManager.getByMail(mail);
        if(cp!=null){
            if(cp.getMdp().equals(mdp)){
                ex.getSessionMap().put("connectedClient",cp);
                ex.getSessionMap().put("role","ClientParticulier");
            }else{
                throw new Exception("Mot de passe erroné");
            }
        }else{
            ReparateurManager reparateurManager = new ReparateurManager();
            Reparateur rp = reparateurManager.getByMail(mail);
            if(rp!=null){
                if(rp.getMdp().equals(mdp)){
                    ex.getSessionMap().put("connectedClient",rp);
                    ex.getSessionMap().put("role","Reparateur");
                }else{
                    throw new Exception("Mot de passe invalide");
                }
            }else{
                ClientEntrepriseManager clientEManager = new ClientEntrepriseManager();
                ClientEntreprise ce =clientEManager.getByMail(mail);
                if(ce!=null){
                    if(ce.getMdp().equals(mdp)){
                        ex.getSessionMap().put("connectedClient",ce);
                        ex.getSessionMap().put("role","ClientEntreprise");
                    }else{
                        throw new Exception("Mot de passe invalide");
                    }
                }else{
                    AdministrateurManager adminManager = new AdministrateurManager();
                    Administrateur ad = adminManager.getByMail(mail);
                    if(ad!=null){
                        if(ad.getMdp().equals(mdp)){
                            ex.getSessionMap().put("connectedClient",ad);
                            ex.getSessionMap().put("role","Administrateur");
                        }else{
                            throw new Exception("Mot de passe invalide");
                        }
                        }else{
                        throw new Exception("Mail non reconnu");
                    }
                }
            }
        }
        
        
        
        
    }
    
}
