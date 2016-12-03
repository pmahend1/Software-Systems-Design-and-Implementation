/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.ContactUs;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanju
 */
public class ContactUsDBTest {
    
    public ContactUsDBTest() {
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

    /**
     * Test of addContactUsDescription method, of class ContactUsDB.
     */
    @Test
    public void testAddContactUsDescription() {
        System.out.println("addContactUsDescription");
        String username = "";
        String category = "";
        String description = "";
        int expResult = 0;
        int result = ContactUsDB.addContactUsDescription(username, category, description);
        assertEquals(expResult, result);

    }

    /**
     * Test of updateContactUsCategory method, of class ContactUsDB.
     */
    @Test
    public void testUpdateContactUsCategory() {
        System.out.println("updateContactUsCategory");
        int ID = 0;
        String category = "";
        int expResult = 0;
        int result = ContactUsDB.updateContactUsCategory(ID, category);
        assertEquals(expResult, result);

    }

    /**
     * Test of selectContactUsDescription method, of class ContactUsDB.
     */
    @Test
    public void testSelectContactUsDescription() {
        System.out.println("selectContactUsDescription");
        int contactUsID = 0;
        ContactUs expResult = null;
        ContactUs result = ContactUsDB.selectContactUsDescription(contactUsID);
        assertEquals(expResult, result);

    }

    /**
     * Test of selectAllContactUsDescriptions method, of class ContactUsDB.
     */
    @Test
    public void testSelectAllContactUsDescriptions() {
        System.out.println("selectAllContactUsDescriptions");
        List<ContactUs> expResult = null;
        List<ContactUs> result = ContactUsDB.selectAllContactUsDescriptions();
        assertEquals(expResult, result);

    }
    
}
