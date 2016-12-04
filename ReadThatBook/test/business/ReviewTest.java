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
public class ReviewTest {
    private Review review;
    public ReviewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        review = new Review();
        review.setBookID(100);
        review.setUserName("sanjukh");
        review.setUserRole("Admin");
        review.setUserrating(4);
        review.setReview("Testing review");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBookID method, of class Review.
     */
    @Test
    public void testGetBookID() {
        System.out.println("getBookID");
        Review instance = new Review();
        int expResult = 0;
        int result = instance.getBookID();
        assertEquals(expResult, result);

        expResult = 100;
        assertEquals(expResult, review.getBookID());
    }

    /**
     * Test of setBookID method, of class Review.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 101;
        Review instance = new Review();
        instance.setBookID(bookID);
        assertEquals(bookID, instance.getBookID());
    }

    /**
     * Test of getUserName method, of class Review.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        
        expResult = "sanjukh";
        assertEquals(expResult, review.getUserName());
    }

    /**
     * Test of setUserName method, of class Review.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "sanjukh";
        Review instance = new Review();
        instance.setUserName(userName);
        assertEquals(review.getUserName(), userName);
    }

    /**
     * Test of getReview method, of class Review.
     */
    @Test
    public void testGetReview() {
        System.out.println("getReview");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getReview();
        assertEquals(expResult, result);
        
        expResult = "Testing review";
        assertEquals(expResult, review.getReview());
    }

    /**
     * Test of setReview method, of class Review.
     */
    @Test
    public void testSetReview() {
        System.out.println("setReview");
        String review = "My review";
        Review instance = new Review();
        instance.setReview(review);
        assertEquals(instance.getReview(), review);
    }

    /**
     * Test of getUserrating method, of class Review.
     */
    @Test
    public void testGetUserrating() {
        System.out.println("getUserrating");
        Review instance = new Review();
        int expResult = 0;
        int result = instance.getUserrating();
        assertEquals(expResult, result);
        
        expResult = 4;
        assertEquals(expResult, review.getUserrating());
    }

    /**
     * Test of setUserrating method, of class Review.
     */
    @Test
    public void testSetUserrating() {
        System.out.println("setUserrating");
        int userrating = 5;
        Review instance = new Review();
        instance.setUserrating(userrating);
        assertEquals(instance.getUserrating(), userrating);
   }

    /**
     * Test of getUserRole method, of class Review.
     */
    @Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getUserRole();
        assertEquals(expResult, result);

        expResult = "Admin";
        assertEquals(expResult, review.getUserRole());
    }

    /**
     * Test of setUserRole method, of class Review.
     */
    @Test
    public void testSetUserRole() {
        System.out.println("setUserRole");
        String userRole = "Admin";
        Review instance = new Review();
        instance.setUserRole(userRole);
        assertEquals(instance.getUserRole(), userRole);

    }



    
}
