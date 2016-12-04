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
public class WishlistTest {
    Wishlist wishlist;
    public WishlistTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        wishlist = new Wishlist();
        wishlist.setBookID(100);
        wishlist.setUsername("sanjukh");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class Wishlist.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Wishlist instance = new Wishlist();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        
        expResult = "sanjukh";
        assertEquals(expResult, wishlist.getUsername());
    }

    /**
     * Test of getBookID method, of class Wishlist.
     */
    @Test
    public void testGetBookID() {
        System.out.println("getBookID");
        Wishlist instance = new Wishlist();
        int expResult = 0;
        int result = instance.getBookID();
        assertEquals(expResult, result);
        
        expResult = 100;
        assertEquals(expResult, wishlist.getBookID());
    }

    /**
     * Test of setUsername method, of class Wishlist.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Wishlist instance = new Wishlist();
        instance.setUsername(username);
        assertEquals(instance.getUsername(), username);
        
        username = "sanjukh";
        instance.setUsername(username);
        assertEquals(instance.getUsername(), username);
    }

    /**
     * Test of setBookID method, of class Wishlist.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 0;
        Wishlist instance = new Wishlist();
        instance.setBookID(bookID);
        assertEquals(bookID, instance.getBookID());
        
        bookID = 100;
        instance.setBookID(bookID);
        assertEquals(instance.getBookID(), bookID);
    }
    
}
