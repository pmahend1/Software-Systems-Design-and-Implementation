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
public class RatingTest {
    
    public RatingTest() {
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
     * Test of getBookID method, of class Rating.
     */
    @Test
    public void testGetBookID() {
        System.out.println("getBookID");
        Rating instance = new Rating();
        int expResult = 0;
        int result = instance.getBookID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookID method, of class Rating.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 0;
        Rating instance = new Rating();
        instance.setBookID(bookID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class Rating.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Rating instance = new Rating();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Rating.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        Rating instance = new Rating();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRating method, of class Rating.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        Rating instance = new Rating();
        int expResult = 0;
        int result = instance.getRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class Rating.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        int rating = 0;
        Rating instance = new Rating();
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
