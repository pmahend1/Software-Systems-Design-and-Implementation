/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Book;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akshay
 */
public class BookDBTest {
    
    public BookDBTest() {
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
     * Test of addBookImage method, of class BookDB.
     */
    @Test
    public void testAddBookImage() {
        System.out.println("addBookImage");
        int bookID = 0;
        InputStream inputStream = null;
        int expResult = 0;
        int result = BookDB.addBookImage(bookID, inputStream);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateBookImage method, of class BookDB.
     */
    @Test
    public void testUpdateBookImage() {
        System.out.println("updateBookImage");
        int bookID = 0;
        InputStream inputStream = null;
        int expResult = 0;
        int result = BookDB.updateBookImage(bookID, inputStream);
        assertEquals(expResult, result);
    }

    /**
     * Test of addBook method, of class BookDB.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book book = null;
        int expResult = 0;
        int result = BookDB.addBook(book);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateBook method, of class BookDB.
     */
    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        Book book = null;
        int expResult = 0;
        int result = BookDB.updateBook(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectBook method, of class BookDB.
     */
    @Test
    public void testSelectBook() {
        System.out.println("selectBook");
        int bookID = 0;
        Book expResult = null;
        Book result = BookDB.selectBook(bookID);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteBook method, of class BookDB.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        int bookID = 0;
        int expResult = 0;
        int result = BookDB.deleteBook(bookID);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectAllBooks method, of class BookDB.
     */
    @Test
    public void testSelectAllBooks() {
        System.out.println("selectAllBooks");
        List<Book> expResult = null;
        List<Book> result = BookDB.selectAllBooks();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBookImage method, of class BookDB.
     */
    @Test
    public void testGetBookImage() {
        System.out.println("getBookImage");
        int bookID = 0;
        byte[] expResult = null;
        byte[] result = BookDB.getBookImage(bookID);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of searchBook method, of class BookDB.
     */
    @Test
    public void testSearchBook() {
        System.out.println("searchBook");
        String bookTitle = "";
        Book expResult = null;
        List<Book> result = BookDB.searchBook(bookTitle);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkBookImageExists method, of class BookDB.
     */
    @Test
    public void testCheckBookImageExists() {
        System.out.println("checkBookImageExists");
        int bookID = 0;
        boolean expResult = false;
        boolean result = BookDB.checkBookImageExists(bookID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBookIDByISBN method, of class BookDB.
     */
    @Test
    public void testGetBookIDByISBN() {
        System.out.println("getBookIDByISBN");
        String ISBN = "";
        int expResult = 0;
        int result = BookDB.getBookIDByISBN(ISBN);
        assertEquals(expResult, result);
    }
    
}
