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
    
    //static Review review;
    public ReviewDBTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        //review = new Review(2, "sanjukh", "Hello");
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
        
        review = new Review(2, "sanjukh", "Hello");
        result = ReviewDB.insertReview(review);
        assertNotEquals(expResult, result);
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
        
        result = ReviewDB.checkReviewExists(2, "sanjukh");
        assertEquals(true, result);
    }

    /**
     * Test of updateReview method, of class ReviewDB.
     */
    @Test
    public void testUpdateReview() {
        //invalid test case
        System.out.println("updateReview");
        Review review = null;
        int expResult = 0;
        int result = ReviewDB.updateReview(review);
        assertEquals(expResult, result);
        
        //valid test case
        review = new Review(2, "sanjukh", "Hello this is my book");
        result = ReviewDB.updateReview(review);
        System.out.println("testUpdateReview result" + result);
        assertNotEquals(expResult, result);
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
        
        //invalid test case
        List<Review> result = ReviewDB.getUsersReview(bookID, userName);
        assertEquals(0, result.size());
        
        //valid test case
        result = ReviewDB.getUsersReview(2, "sanjukh");
        assertNotEquals(0, result.size());
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
        
        review = new Review(2, "sanjukh", "Hello");
        result = ReviewDB.deleteReview(review);
        System.out.println("testDeleteReview result" + result);
        assertNotEquals(expResult, result);
    }
    
        /**
     * Test of getReviewsFromBookID method, of class ReviewDB.
     */
    
    @Test
    public void testGetReviewsFromBookID() {
        System.out.println("getReviewsFromBookID");
        int bookID = 1;
        
        List<Review> result = ReviewDB.getReviewsFromBookID(bookID);
        //assertEquals(0, result.size());
        int sum = 0;
        result = ReviewDB.getReviewsFromBookID(bookID);
        if(result!=null){
            for(Review r:result){
                System.out.println(r.getBookID());
                sum = sum+r.getBookID();
            }
        }
        System.out.println("testDeleteReview result" + result);
        assertTrue(sum>0);
    }
    
}
