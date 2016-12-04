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
    Rating rating = new Rating();
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
        rating.setBookID(100);
        rating.setRating(4);
        rating.setUserName("sanjukh");
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
        
        expResult = 100;
        assertEquals(expResult, rating.getBookID());
    }

    /**
     * Test of setBookID method, of class Rating.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 100;
        Rating instance = new Rating();
        instance.setBookID(bookID);
        assertEquals(bookID, instance.getBookID());
        
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
        
        expResult = "sanjukh";
        assertEquals(expResult, rating.getUserName());
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
        assertEquals(instance.getUserName(), "");
        
        userName="sanjukh";
        instance.setUserName(userName);
        assertEquals(instance.getUserName(), "sanjukh");
        
        
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
        
        expResult = 4;
        assertEquals(expResult, rating.getRating());
    }

    /**
     * Test of setRating method, of class Rating.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        int rating = 5;
        Rating instance = new Rating();
        instance.setRating(rating);
        assertEquals(instance.getRating(), rating);
    }
    
}
