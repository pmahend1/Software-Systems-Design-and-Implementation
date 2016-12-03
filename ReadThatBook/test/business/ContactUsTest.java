/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
public class ContactUsTest {
    
    public ContactUsTest() {
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
     * Test of getContactUsId method, of class ContactUs.
     */
    @Test
    public void testGetContactUsId() {
        System.out.println("getContactUsId");
        ContactUs instance = new ContactUs();
        int expResult = 0;
        int result = instance.getContactUsId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setContactUsId method, of class ContactUs.
     */
    @Test
    public void testSetContactUsId() {
        System.out.println("setContactUsId");
        int contactUsId = 0;
        ContactUs instance = new ContactUs();
        instance.setContactUsId(contactUsId);

    }

    /**
     * Test of getUserName method, of class ContactUs.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        ContactUs instance = new ContactUs();
        String expResult = null;
        String result = instance.getUserName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUserName method, of class ContactUs.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        ContactUs instance = new ContactUs();
        instance.setUserName(userName);

    }

    /**
     * Test of getCategory method, of class ContactUs.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        ContactUs instance = new ContactUs();
        String expResult = null;
        String result = instance.getCategory();
        assertEquals(expResult, result);

    }

    /**
     * Test of setCategory method, of class ContactUs.
     */
    @Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String category = "";
        ContactUs instance = new ContactUs();
        instance.setCategory(category);

    }

    /**
     * Test of getDescription method, of class ContactUs.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        ContactUs instance = new ContactUs();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescription method, of class ContactUs.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        ContactUs instance = new ContactUs();
        instance.setDescription(description);

    }
    
}
