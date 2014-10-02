package alpha.entite.testunit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import alpha.entite.dao.AdministrateurDAO;
import alpha.entite.dao.ClientDAO;
import alpha.entite.dao.ReparateurDAO;
import alpha.entite.dao.generiq.GeneriqDAO;
import alpha.entite.model.Administrateur;
import alpha.entite.model.Client;
import alpha.entite.model.ClientEntreprise;
import alpha.entite.model.Reparateur;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INTI0224
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testgetAdministrateur1() {
        GeneriqDAO dao = new AdministrateurDAO();
        Administrateur admin = (Administrateur) dao.getById(1);
        System.out.println(admin.getLogin() + " " + admin.getMdp());

        assertTrue(admin != null);

    }

    @Test
    public void testgetAdministrateurNotFound() {
        GeneriqDAO dao = new AdministrateurDAO();
        Administrateur admin = (Administrateur) dao.getById(0);
//        System.out.println(admin.getLogin() + " " + admin.getMdp());

        assertTrue(admin == null);

    }

    @Test
    public void testAjoutSupAdministrateur() {
        Administrateur admin = new Administrateur();
        admin.setLogin("testadmin");
        admin.setMdp("testadmin");

        GeneriqDAO dao = new AdministrateurDAO();

        dao.create(admin);
        //si la creation se fait bien
        dao.delete(admin);

        //si la delete marche 
        assertTrue(true);
    }

    @Test
    public void testAjoutClientDao() {
        ClientEntreprise ce = new ClientEntreprise();

        ce.setRaisonSociale("adaming");
        ce.setTelephone("0101010101");
        ce.setAdresse("lasa");
        ce.setCodepostal("123");
        ce.setMail("@@@@@@");
        ce.setParticulierEntreprises(null);
        ce.setVille("alouest");
        ce.setMdp("mai");

        GeneriqDAO dao = new ClientDAO();
        dao.create(ce);

        ClientEntreprise adaming = (ClientEntreprise) dao.getById(1);
        assertTrue(!adaming.equals(null));
        assertTrue(
                adaming.getRaisonSociale().equals(ce.getRaisonSociale())
                && adaming.getAdresse().equals(ce.getAdresse())
                && adaming.getCodepostal().equals(ce.getCodepostal())
                && adaming.getVille().equals(ce.getVille())
                && adaming.getMail().equals(ce.getMail())
                && adaming.getMdp().equals(ce.getMdp())
        );
    }

    @Test
    public void testAjoutReparateur() {
        Reparateur reparateur = new Reparateur();

        reparateur.setAdresse("adresse test");
        reparateur.setChargeMax(42);
        reparateur.setCodepostal("4242");
        
        reparateur.setMdp("test");
        reparateur.setVille("villetest");
        reparateur.setTelephone("684874");
        
        reparateur.setMail("mail.test");
        reparateur.setNom("testrep");
        
        GeneriqDAO dao = new ReparateurDAO();
        
        dao.create(reparateur);
        
        
        dao.delete(reparateur);
        
        
        assertTrue(true);
        

    }

}
