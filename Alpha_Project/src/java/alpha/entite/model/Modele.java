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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author INTI0222
 */
@Entity
public class Modele implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_modele")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;

    @Basic(optional = false)
    @Column(name = "transportable")
    private boolean transportable;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MODELE_CATEGORIE", joinColumns = {
        @JoinColumn(name = "id_modele")}, inverseJoinColumns = {
        @JoinColumn(name = "id_categorie")})
    private Collection<Categorie> categories;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_marque", referencedColumnName = "id_marque")
    private Marque marque;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Forfait> forfaits;

    public Collection<Forfait> getForfaits() {
        return forfaits;
    }

    public void setForfaits(Collection<Forfait> forfaits) {
        this.forfaits = forfaits;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isTransportable() {
        return transportable;
    }

    public void setTransportable(boolean transportable) {
        this.transportable = transportable;
    }

    public Collection<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Categorie> categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
