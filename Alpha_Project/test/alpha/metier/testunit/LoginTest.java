package alpha.metier.testunit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import alpha.entite.model.ClientParticulier;
import alpha.metier.modelManager.ClientParticulierManager;
import alpha.vue.pagesPubliques.managedBeans.LoginManaged;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author INTI0220
 */
public class LoginTest {
    
    public LoginTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        ClientParticulierManager cpm = new ClientParticulierManager();
        ClientParticulier cp = new ClientParticulier();
        cp.setMail("test@test");
        cp.setMdp("test");
        cpm.create(cp);
        
        LoginManaged lm = new LoginManaged();
        lm.setMail("test@test");
        lm.setMdp("test");
        
        lm.login();
        
        ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
        
        assertFalse(ex.getSessionMap().isEmpty());
        
    }
}
