/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.entite.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author INTI0222
 */
@Entity
public class DepartementFrance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_departementfrance")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "designation")
    private String designation;

    @Basic(optional = false)
    @Column(name = "numDep")
    private String numDep;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DEPARTEMENT_REPARATEUR", joinColumns = {
        @JoinColumn(name = "id_departementfrance")}, inverseJoinColumns = {
        @JoinColumn(name = "id_reparateur")})
    private Collection<Reparateur> reparateurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNumDep() {
        return numDep;
    }

    public void setNumDep(String numDep) {
        this.numDep = numDep;
    }

    public Collection<Reparateur> getReparateurs() {
        return reparateurs;
    }

    public void setReparateurs(Collection<Reparateur> reparateurs) {
        this.reparateurs = reparateurs;
    }

}
