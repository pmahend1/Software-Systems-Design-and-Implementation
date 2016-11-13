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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookID method, of class Review.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 0;
        Review instance = new Review();
        instance.setBookID(bookID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class Review.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "";
        Review instance = new Review();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReview method, of class Review.
     */
    @Test
    public void testSetReview() {
        System.out.println("setReview");
        String review = "";
        Review instance = new Review();
        instance.setReview(review);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserrating method, of class Review.
     */
    @Test
    public void testSetUserrating() {
        System.out.println("setUserrating");
        int userrating = 0;
        Review instance = new Review();
        instance.setUserrating(userrating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Review.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Review instance = new Review();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
