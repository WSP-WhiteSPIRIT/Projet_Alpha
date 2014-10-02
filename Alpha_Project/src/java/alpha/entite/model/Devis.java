/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author INTI0222
 */
@Entity
public class Devis implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_devis")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_id_reparateur", referencedColumnName = "id_reparateur")
    private Reparateur reparateur;

    @Basic(optional = false)
    @Column(name = "diagnostic")
    private String diagnostic;

    @Basic(optional = false)
    @Column(name = "date")
    private GregorianCalendar date;

    @Basic(optional = false)
    @Column(name = "cout")
    private double cout;

    @OneToOne( mappedBy = "devis")
    private Reparation reparation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reparation getReparation() {
        return reparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    
    
    public Reparateur getReparateur() {
        return reparateur;
    }

    public void setReparateur(Reparateur reparateur) {
        this.reparateur = reparateur;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

}
