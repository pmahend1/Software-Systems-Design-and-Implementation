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
        ContactUs contactUs = new ContactUs();
        String username = "Sanju";
        String category = "Test";
        String description = "Test";
        String descriptionDB = "";
        int result = ContactUsDB.addContactUsDescription(username, category, description);
        List<ContactUs> all = ContactUsDB.selectAllContactUsDescriptions();
        if(all!=null){
            for(ContactUs c : all){
                
                System.out.println(c.getDescription());
                if(c.getUserName().equals("Sanju")){
                    descriptionDB=c.getDescription();
                }
            }
        }
        assertEquals(descriptionDB, description);

    }

    /**
     * Test of updateContactUsCategory method, of class ContactUsDB.
     */
    @Test
    public void testUpdateContactUsCategory() {
        System.out.println("updateContactUsCategory");
        String category = "new Category";
        int ID=1;
        int result = ContactUsDB.updateContactUsCategory(ID, category);
        assertNotEquals(0, result);

    }

    /**
     * Test of selectContactUsDescription method, of class ContactUsDB.
     */
    @Test
    public void testSelectContactUsDescription() {
        System.out.println("selectContactUsDescription");
        int contactUsID = 5;
        String expResult = "Test";
        ContactUs dbValue = ContactUsDB.selectContactUsDescription(contactUsID);
        String result = dbValue.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of selectAllContactUsDescriptions method, of class ContactUsDB.
     */
    @Test
    public void testSelectAllContactUsDescriptions() {
        System.out.println("selectAllContactUsDescriptions");
        List<ContactUs> result = ContactUsDB.selectAllContactUsDescriptions();
        int sum=0;
        if(result!=null){
            for(ContactUs c : result){
                System.out.println(c.getContactUsId());
                sum = sum + c.getContactUsId();
            }
        }
        assertTrue(sum>0);

    }
    
}
