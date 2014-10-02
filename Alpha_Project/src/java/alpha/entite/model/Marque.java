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
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_marque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Modele> modeles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MARQUE_REPARATEUR", joinColumns = {
        @JoinColumn(name = "id_marque")}, inverseJoinColumns = {
        @JoinColumn(name = "id_reparateur")})
    private Collection<Reparateur> reparateurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<Modele> getModeles() {
        return modeles;
    }

    public void setModeles(Collection<Modele> modeles) {
        this.modeles = modeles;
    }

}
