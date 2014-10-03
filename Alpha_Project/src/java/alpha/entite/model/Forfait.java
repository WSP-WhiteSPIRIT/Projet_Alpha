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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author INTI0222
 */
@Entity
public class Forfait implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_forfait")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;

    @Basic(optional = false)
    @Column(name = "cout")
    private double cout;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_modele", referencedColumnName = "id_modele")
    private Modele modele;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forfait")
    private Collection<Reparation> reparations;

    public Collection<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(Collection<Reparation> reparations) {
        this.reparations = reparations;
    }

    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
