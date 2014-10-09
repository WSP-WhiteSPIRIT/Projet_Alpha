/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import alpha.entite.model.Reparation;
import alpha.entite.model.Categorie;
import alpha.entite.model.Client;
import alpha.entite.model.ClientEntreprise;
import alpha.entite.model.ClientParticulier;
import alpha.entite.model.DepartementFrance;
import alpha.entite.model.Etat;
import alpha.entite.model.Forfait;
import alpha.entite.model.Marque;
import alpha.entite.model.Modele;
import alpha.entite.model.Reparateur;
import alpha.metier.metier.algo.AlgorithmeReparateur;
import alpha.metier.modelManager.CategorieManager;
import alpha.metier.modelManager.DepartementFranceManager;
import alpha.metier.modelManager.ForfaitManager;
import alpha.metier.modelManager.MarqueManager;
import alpha.metier.modelManager.ModeleManager;
import alpha.metier.modelManager.ReparationManager;
import alpha.metier.modelManager.generique.GeneriqueManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author INTI0224
 */
@ManagedBean
@SessionScoped
public class ReparationManagedBean implements Serializable {

    private Client client;
    private String role;

    private GeneriqueManager managerCategorie;
    private GeneriqueManager managerModele;
    private GeneriqueManager managerMarque;
    private GeneriqueManager managerForfait;

    private Map<Integer, Categorie> categories;
    private Map<Integer, Modele> modeles;
    private Map<Integer, Marque> marques;
    private Map<Integer, Forfait> forfaits;

    private Integer idCategorie;
    private Integer idModele;
    private Integer idMarque;
    private Integer idForfait;

    private int etape;

    private Reparation reparation;

    /**
     * Creates a new instance of ReparationManagedBean
     */
    public ReparationManagedBean() {
        categories = new HashMap<>();
        marques = new HashMap<>();
        modeles = new HashMap<>();
        forfaits = new HashMap<>();
        managerCategorie = new CategorieManager();
        managerModele = new ModeleManager();
        managerMarque = new MarqueManager();
        managerForfait = new ForfaitManager();
        reparation = new Reparation();
        refreshCategorie();
        initAdresse();

    }

    private void initAdresse() {
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();

        client = (Client) ex.getSessionMap().get("connectedClient");
        role = (String) ex.getSessionMap().get("role");

        System.out.println("Type du client : "+client.getClass().getSimpleName());

        if (client == null) {
            System.out.println("//TODO : redirection si le client n'est pas connecte"); //TODO : redirection si le client n'est pas connecte
            System.out.println(role);
        } else {
            switch (role) {
                case "ClientParticulier":
                    reparation.setAdresseLivraison(((ClientParticulier) client).getAdresse());
                    reparation.setCodePostalLivraison(((ClientParticulier) client).getCodepostal());
                    reparation.setVilleLivraison(((ClientParticulier) client).getVille());
                    break;
                case "ClientEntreprise":
                    reparation.setAdresseLivraison(((ClientEntreprise) client).getAdresse());
                    reparation.setCodePostalLivraison(((ClientEntreprise) client).getCodepostal());
                    reparation.setVilleLivraison(((ClientEntreprise) client).getVille());
                    break;
            }
        }

    }

    public String refreshCategorie() {

        System.out.println("refreshCategorie");
        // categories = new HashMap<>();
        etape = 0;
        Collection<Categorie> colCal = managerCategorie.getAll();
        System.out.println("Refresh cat nb =" + colCal.size());
        categories.clear();
        for (Categorie cat : colCal) {
            System.out.println(cat.getLibelle());
            categories.put(cat.getId(), cat);
        }
        return "";
    }

    public void refreshMarques() {
        System.out.println("refreshMarques");

        etape = 1;
        Collection<Marque> colMar = managerMarque.getAll();
        marques.clear();
        for (Marque mar : colMar) {
            System.out.println(mar.getLibelle());
            marques.put(mar.getId(), mar);
        }
    }

    public void refreshModeles() {
        System.out.println("refreshModeles");
        etape = 2;
        Marque marque = new MarqueManager().getById(idMarque);
        Collection<Modele> colModDeMar = marque.getModeles();
        
        Categorie categorie = new CategorieManager().getById(idCategorie);
        Collection<Modele> colModDeCat = categorie.getModeles();
        
        modeles.clear();
        for (Modele modDeMar : colModDeMar) {
            for (Modele modDeCat : colModDeCat) {
                if(modDeMar.getId() == modDeCat.getId()){
                    modeles.put(modDeCat.getId(), modDeCat);
                }
            }
            
        }
        //System.out.println(selectionCategorie.getId());
    }

    public void refreshForfait() {
        System.out.println("refreshForfait");
        etape = 3;
        Modele modele = (Modele) managerModele.getById(idModele);
        Collection<Forfait> colFor = modele.getForfaits();
        forfaits.clear();
        for (Forfait forfait : colFor) {
            forfaits.put(forfait.getId(), forfait);
        }
    }

    public void refreshValide() {
        System.out.println("refreshValide");
        etape = 5;
    }

    public String valider() {
        System.out.println("Validation");

        Forfait forfait = (Forfait) managerForfait.getById(idForfait);

        System.out.println("FORFAIT : " + forfait.getLibelle() + "  " + forfait.getCout());

        if (client != null) {
            reparation.setClient(client);
            reparation.setDate(new GregorianCalendar());
            reparation.setEtat(Etat.EXPEDITION);
            reparation.setCout(forfait.getCout()); //TODO : voir les taxes
            reparation.setForfait(forfait);
            String numDep = reparation.getCodePostalLivraison().substring(0, 2);

            Collection<DepartementFrance> colDep = new DepartementFranceManager().getAll();
            DepartementFrance dep = null;

            for (DepartementFrance tmpdep : colDep) {
                if (tmpdep.getNumDep().equals(numDep)) {
                    dep = tmpdep;
                    break;
                }
            }

            Marque marque = (Marque) managerMarque.getById(idMarque);
            Reparateur reparateur = null;
            if (dep != null && marque != null) {
                AlgorithmeReparateur algorithmeReparateur = new AlgorithmeReparateur();
                reparateur = algorithmeReparateur.selectReparateurACharger(marque, dep);
                System.out.println(reparateur.getRaisonSociale());
                reparation.setReparateur(reparateur);
                new ReparationManager().create(reparation);

            }
            if (reparateur == null) {
                // s'il n'y a pas de reparateur;
            }

            return "index";
        } else {
            // GO TO LOGIN
            ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
            ex.getSessionMap().put("reparation", reparation);
        }
//        new ModeleManager().create(m);
        return "index";
    }

    public Reparation getReparation() {
        return reparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public Collection<Categorie> getCategories() {
        if (categories == null) {
            return null;
        }
        return categories.values();
    }

    public void setCategories(Map<Integer, Categorie> categories) {
        this.categories = categories;
    }

    public Collection<Modele> getModeles() {
        if (modeles == null) {
            return null;
        }
        return modeles.values();
    }

    public void setModeles(Map<Integer, Modele> modeles) {
        this.modeles = modeles;
    }

    public Collection<Marque> getMarques() {
        if (marques == null) {
            return null;
        }
        return marques.values();
    }

    public void setMarques(Map<Integer, Marque> marques) {
        this.marques = marques;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdModele() {
        return idModele;
    }

    public void setIdModele(Integer idModele) {
        this.idModele = idModele;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public int getEtape() {
        return etape;
    }

    public void setEtape(int etape) {
        this.etape = etape;
    }

    public Collection<Forfait> getForfaits() {
        return forfaits.values();
    }

    public void setForfaits(Map<Integer, Forfait> forfaits) {
        this.forfaits = forfaits;
    }

    public Integer getIdForfait() {
        return idForfait;
    }

    public void setIdForfait(Integer idForfait) {
        this.idForfait = idForfait;
    }

}
