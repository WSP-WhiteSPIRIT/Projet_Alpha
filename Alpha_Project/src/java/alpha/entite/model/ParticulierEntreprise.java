/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.model;

import java.io.Serializable;
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

/**
 *
 * @author INTI0222
 */
@Entity
public class ParticulierEntreprise implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_particulierEntreprise")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "nomVendeur")
    private String nomVendeur;

    @OneToOne(optional = false)
    @JoinColumn(name = "fk_id_clientParticulier", referencedColumnName = "id_client")
    private ClientParticulier clientParticulier;

  
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_clientEntreprise", referencedColumnName = "id_client")
    private ClientEntreprise clientEntreprise;

    public ClientParticulier getClientParticulier() {
        return clientParticulier;
    }

    public void setClientParticulier(ClientParticulier clientParticulier) {
        this.clientParticulier = clientParticulier;
    }

    public ClientEntreprise getClientEntreprise() {
        return clientEntreprise;
    }

    public void setClientEntreprise(ClientEntreprise clientEntreprise) {
        this.clientEntreprise = clientEntreprise;
    }

    public String getNomVendeur() {
        return nomVendeur;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
