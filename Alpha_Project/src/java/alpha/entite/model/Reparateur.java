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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author INTI0222
 */
@Entity
public class Reparateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_reparateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;

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

    @Basic(optional = false)
    @Column(name = "chargeMax")
    private int chargeMax;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DEPARTEMENT_REPARATEUR", joinColumns = {
        @JoinColumn(name = "id_departementfrance")}, inverseJoinColumns = {
        @JoinColumn(name = "id_reparateur")})
//    @ManyToMany(mappedBy = "reparateurs")
    private Collection<DepartementFrance> departementFrances;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MARQUE_REPARATEUR", joinColumns = {
        @JoinColumn(name = "id_marque")}, inverseJoinColumns = {
        @JoinColumn(name = "id_reparateur")})
    private Collection<Marque> marques;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reparateur")
    private Collection<Devis> devis;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reparateur")
    private Collection<Reparation> reparations;

    public Collection<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(Collection<Reparation> reparations) {
        this.reparations = reparations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<DepartementFrance> getDepartementFrances() {
        return departementFrances;
    }

    public void setDepartementFrances(Collection<DepartementFrance> departementFrances) {
        this.departementFrances = departementFrances;
    }

    public Collection<Marque> getMarques() {
        return marques;
    }

    public void setMarques(Collection<Marque> marques) {
        this.marques = marques;
    }

    public Collection<Devis> getDevis() {
        return devis;
    }

    public void setDevis(Collection<Devis> devis) {
        this.devis = devis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public int getChargeMax() {
        return chargeMax;
    }

    public void setChargeMax(int chargeMax) {
        this.chargeMax = chargeMax;
    }

}
