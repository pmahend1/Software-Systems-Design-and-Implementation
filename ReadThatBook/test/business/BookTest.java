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
 * @author Prateek
 */
public class BookTest {
    
    public BookTest() {
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
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookID method, of class Book.
     */
    @Test
    public void testGetBookID() {
        System.out.println("getBookID");
        Book instance = new Book();
        int expResult = 0;
        int result = instance.getBookID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Book.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEdition method, of class Book.
     */
    @Test
    public void testGetEdition() {
        System.out.println("getEdition");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getEdition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenre method, of class Book.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN_10 method, of class Book.
     */
    @Test
    public void testGetISBN_10() {
        System.out.println("getISBN_10");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getISBN10();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN_13 method, of class Book.
     */
    @Test
    public void testGetISBN_13() {
        System.out.println("getISBN_13");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getISBN13();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getPublisher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        Book instance = new Book();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookID method, of class Book.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 0;
        Book instance = new Book();
        instance.setBookID(bookID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Book instance = new Book();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Book.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Book instance = new Book();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEdition method, of class Book.
     */
    @Test
    public void testSetEdition() {
        System.out.println("setEdition");
        String edition = "";
        Book instance = new Book();
        instance.setEdition(edition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setISBN_10 method, of class Book.
     */
    @Test
    public void testSetISBN_10() {
        System.out.println("setISBN_10");
        String ISBN_10 = "";
        Book instance = new Book();
        instance.setISBN10(ISBN_10);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setISBN_13 method, of class Book.
     */
    @Test
    public void testSetISBN_13() {
        System.out.println("setISBN_13");
        String ISBN_13 = "";
        Book instance = new Book();
        instance.setISBN13(ISBN_13);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenre method, of class Book.
     */
    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        String genre = "";
        Book instance = new Book();
        instance.setGenre(genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublisher method, of class Book.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "";
        Book instance = new Book();
        instance.setPublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
