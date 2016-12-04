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
    ContactUs contactUs;
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
        contactUs = new ContactUs();
        contactUs.setCategory("Testing category");
        contactUs.setContactUsId(100);
        contactUs.setDescription("Testing description");
        contactUs.setUserName("sanjukh");
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

        expResult = 100;
        assertEquals(expResult, contactUs.getContactUsId());
    }

    /**
     * Test of setContactUsId method, of class ContactUs.
     */
    @Test
    public void testSetContactUsId() {
        System.out.println("setContactUsId");
        int contactUsId = 101;
        ContactUs instance = new ContactUs();
        instance.setContactUsId(contactUsId);
        
        assertEquals(instance.getContactUsId(), contactUsId);
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

        expResult = "sanjukh";
        assertEquals(expResult, contactUs.getUserName());
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

        userName = "sanjukh";
        instance.setUserName(userName);
        assertEquals(instance.getUserName(), userName);
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
        
        expResult = "Testing category";
        assertEquals(expResult, contactUs.getCategory());

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

        category = "Testing category";
        instance.setCategory(category);
        assertEquals(instance.getCategory(), category);
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

        expResult = "Testing description";
        assertEquals(expResult, contactUs.getDescription());
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

        description = "Testing description";
        instance.setDescription(description);
        assertEquals(instance.getDescription(), description);
    }
    
}
