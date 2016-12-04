/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Book;
import java.sql.SQLException;
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
    public void testAddBook() throws SQLException {
        System.out.println("addBook");
        String username = "raka";
        int bookid = 1;
        
        int result = WishlistDB.addBook(username, bookid);
        List<Book> rakaWishList  = WishlistDB.viewWishlist(username);
        int dbBookID = rakaWishList.get(0).getBookID();
        assertEquals(dbBookID, bookid);
    }

    /**
     * Test of viewWishlist method, of class WishlistDB.
     */
    @Test
    public void testViewWishlist() throws Exception {
        System.out.println("viewWishlist");
        String username = "raka";
        List<Book> result = WishlistDB.viewWishlist(username);
        int sum=0;
        if(result!=null){
            for(Book b : result){
                System.out.println(b.getBookID());
                sum = sum + b.getBookID();
            }
        }
        assertTrue(sum>0);
    }

    /**
     * Test of deleteWishlist method, of class WishlistDB.
     */
    @Test
    public void testDeleteWishlist() throws SQLException {
        System.out.println("deleteWishlist");
        String username = "raka";
        int bookID = 1;
        int sum=0;
        int result = WishlistDB.deleteWishlist(username, bookID);
        List<Book> wishlist = WishlistDB.viewWishlist(username);
        if(wishlist!=null){
            for(Book wish : wishlist){
                System.out.println(wish.getBookID());
                sum = sum + wish.getBookID();
            }
                    
        }
        assertTrue(sum > result);
    }
    
}
