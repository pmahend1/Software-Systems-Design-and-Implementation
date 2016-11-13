/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Review;
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
public class ReviewDBTest {
    
    public ReviewDBTest() {
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
     * Test of insertReview method, of class ReviewDB.
     */
    @Test
    public void testInsertReview() {
        System.out.println("insertReview");
        Review review = null;
        int expResult = 0;
        int result = ReviewDB.insertReview(review);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkReviewExists method, of class ReviewDB.
     */
    @Test
    public void testCheckReviewExists() {
        System.out.println("checkReviewExists");
        int bookID = 0;
        String userName = "";
        boolean expResult = false;
        boolean result = ReviewDB.checkReviewExists(bookID, userName);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateReview method, of class ReviewDB.
     */
    @Test
    public void testUpdateReview() {
        System.out.println("updateReview");
        Review review = null;
        int expResult = 0;
        int result = ReviewDB.updateReview(review);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsersReview method, of class ReviewDB.
     */
    @Test
    public void testGetUsersReview() {
        System.out.println("getUsersReview");
        int bookID = 0;
        String userName = "";
        List<Review> expResult = null;
        List<Review> result = ReviewDB.getUsersReview(bookID, userName);
        assertEquals(expResult, result);
     }

    /**
     * Test of getReviewsFromBookID method, of class ReviewDB.
     */
    @Test
    public void testGetReviewsFromBookID() {
        System.out.println("getReviewsFromBookID");
        int bookID = 0;
        List<Review> expResult = null;
        List<Review> result = ReviewDB.getReviewsFromBookID(bookID);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteReview method, of class ReviewDB.
     */
    @Test
    public void testDeleteReview() {
        System.out.println("deleteReview");
        Review review = null;
        int expResult = 0;
        int result = ReviewDB.deleteReview(review);
        assertEquals(expResult, result);
    }
    
}
