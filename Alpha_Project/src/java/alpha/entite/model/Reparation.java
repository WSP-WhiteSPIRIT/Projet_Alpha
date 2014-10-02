/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author INTI0222
 */
@Entity
public class Reparation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_reparation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_client", referencedColumnName = "id_client")

    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_forfait", referencedColumnName = "id_forfait")

    private Forfait forfait;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_reparateur", referencedColumnName = "id_reparateur")

    private Reparateur reparateur;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_devis", referencedColumnName = "id_devis")
    private Devis devis;

    @Basic(optional = false)
    @Column(name = "etat")
    private Etat etat;

    @Basic(optional = false)
    @Column(name = "descriptionReparation")
    private String descriptionReparation;

    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar date;

    @Basic(optional = true)
    @Column(name = "cout")
    private double cout;

    @Basic(optional = false)
    @Column(name = "adresseLivraison")
    private String adresseLivraison;

    @Basic(optional = false)
    @Column(name = "codePostalLivraison")
    private String codePostalLivraison;

    @Basic(optional = false)
    @Column(name = "villeLivraison")
    private String villeLivraison;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Forfait getForfait() {
        return forfait;
    }

    public void setForfait(Forfait forfait) {
        this.forfait = forfait;
    }

    public Reparateur getReparateur() {
        return reparateur;
    }

    public void setReparateur(Reparateur reparateur) {
        this.reparateur = reparateur;
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getDescriptionReparation() {
        return descriptionReparation;
    }

    public void setDescriptionReparation(String descriptionReparation) {
        this.descriptionReparation = descriptionReparation;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public String getCodePostalLivraison() {
        return codePostalLivraison;
    }

    public void setCodePostalLivraison(String codePostalLivraison) {
        this.codePostalLivraison = codePostalLivraison;
    }

    public String getVilleLivraison() {
        return villeLivraison;
    }

    public void setVilleLivraison(String villeLivraison) {
        this.villeLivraison = villeLivraison;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
