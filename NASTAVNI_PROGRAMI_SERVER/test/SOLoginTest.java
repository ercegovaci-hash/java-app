/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import baza.DBBroker;
import java.sql.SQLException;
import model.Predavac;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import so.login.SOLogin;

/**
 *
 * @author ivana
 */
public class SOLoginTest {

    private Predavac predavac;

    public SOLoginTest() {
    }

    @Before
    public void setUp() throws SQLException {
        predavac = new Predavac();
        predavac.setUsername("ivana123");
        predavac.setPassword("ivana123");
//        predavac.setIme("Ivana");
//        predavac.setPrezime("Ivkovic");
        DBBroker.getInstance().insert(predavac);
    }
    @Test(expected = Exception.class)
    public void testLoginPogresniKredencijali() throws Exception {
        SOLogin so = new SOLogin();
        Predavac pogresanPredavac = new Predavac();
        pogresanPredavac.setUsername("pogresno");
        pogresanPredavac.setPassword("pogresno");
        so.templateExecute(pogresanPredavac);
    }
    @Test
    public void testLoginTacniKredencijali() throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(predavac); 
        Predavac ulogovaniPredavac = so.getUlogovani();  
        assertNotNull(ulogovaniPredavac);
        assertEquals(predavac.getUsername(), ulogovaniPredavac.getUsername());
        assertEquals(predavac.getPassword(), ulogovaniPredavac.getPassword());

    }
}
