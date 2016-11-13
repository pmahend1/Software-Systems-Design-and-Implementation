/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Book;
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
public class WishlistDBTest {
    
    public WishlistDBTest() {
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
     * Test of addBook method, of class WishlistDB.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        String username = "";
        int bookid = 0;
        int expResult = 0;
        int result = WishlistDB.addBook(username, bookid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewWishlist method, of class WishlistDB.
     */
    @Test
    public void testViewWishlist() throws Exception {
        System.out.println("viewWishlist");
        String username = "";
        List<Book> expResult = null;
        List<Book> result = WishlistDB.viewWishlist(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteWishlist method, of class WishlistDB.
     */
    @Test
    public void testDeleteWishlist() {
        System.out.println("deleteWishlist");
        String username = "";
        int bookID = 0;
        int expResult = 0;
        int result = WishlistDB.deleteWishlist(username, bookID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
