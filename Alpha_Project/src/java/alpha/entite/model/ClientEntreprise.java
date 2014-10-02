/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author INTI0222
 */
@Entity
public class ClientEntreprise extends Client  {
    private static final long serialVersionUID = 1L;


//    @Id
//    @Basic(optional = false)
//    @Column(name = "id_cliententreprise")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    //@OneToOne(cascade = CascadeType.ALL,mappedBy = "id")
//    private int id;

    @Basic(optional = false)
    @Column(name = "raisonSociale")
    private String raisonSociale;

    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;

    @Basic(optional = false)
    @Column(name = "codepostal")
    private String codepostal;

    @Basic(optional = false)
    @Column(name = "ville")
    private String ville;

    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;

    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;

    @Basic(optional = false)
    @Column(name = "mdp")
    private String mdp;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "clientEntreprise")
    private Collection<ParticulierEntreprise> particulierEntreprises;


    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Collection<ParticulierEntreprise> getParticulierEntreprises() {
        return particulierEntreprises;
    }

    public void setParticulierEntreprises(Collection<ParticulierEntreprise> particulierEntreprises) {
        this.particulierEntreprises = particulierEntreprises;
    }

}
