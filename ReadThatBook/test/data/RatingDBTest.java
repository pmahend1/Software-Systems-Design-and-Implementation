/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Rating;
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
public class RatingDBTest {
    
    public RatingDBTest() {
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
     * Test of insertRating method, of class RatingDB.
     */
    @Test
    public void testInsertRating() {
        System.out.println("insertRating");
        Rating rating = null;
        int expResult = 0;
        int result = RatingDB.insertRating(rating);
    }

    /**
     * Test of checkRatingExists method, of class RatingDB.
     */
    @Test
    public void testCheckRatingExists() {
        System.out.println("checkRatingExists");
        Rating rating = null;
        boolean expResult = false;
        boolean result = RatingDB.checkRatingExists(rating);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateRating method, of class RatingDB.
     */
    @Test
    public void testUpdateRating() {
        System.out.println("updateRating");
        Rating rating = null;
        int expResult = 0;
        int result = RatingDB.updateRating(rating);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAverageRating method, of class RatingDB.
     */
    @Test
    public void testGetAverageRating() {
        System.out.println("getAverageRating");
        int bookID = -1;
        double[] expResult = null;
        double[] result = RatingDB.getAverageRating(bookID);
        assertArrayEquals(expResult, result, bookID);
    }

    /**
     * Test of getUserRating method, of class RatingDB.
     */
    @Test
    public void testGetUserRating() {
        System.out.println("getUserRating");
        int bookID = 0;
        String userName = "";
        int expResult = 0;
        int result = RatingDB.getUserRating(bookID, userName);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteRating method, of class RatingDB.
     */
    @Test
    public void testDeleteRating() {
        System.out.println("deleteRating");
        Rating rating = null;
        int expResult = 0;
        int result = RatingDB.deleteRating(rating);
        assertEquals(expResult, result);
    }
}
