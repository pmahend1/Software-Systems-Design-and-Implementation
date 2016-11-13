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
    private Book book;
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        book = new Book();
	book.setAuthor("test");
	book.setTitle("test");
	book.setTitle("test");
	book.setDescription("test");
	book.setEdition("test");
	book.setISBN10("test");
	book.setISBN13("test");
        book.setGenre("test");
        book.setPublisher("test");
        book.setBookID(1001);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    
      @Test
    public void testGetAuthor() throws Exception {
        System.out.println("getAuthor");
        String expResult = "test";
        String result = book.getAuthor();
        assertEquals(expResult, result);
    }
 

    /**
     * Test of getBookID method, of class Book.
     */
    @Test
    public void testGetBookID() {
        System.out.println("getBookID");
        int expResult=1001;
        int result = book.getBookID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "test";
        String result = book.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Book.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "test";
        String result = book.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEdition method, of class Book.
     */
    @Test
    public void testGetEdition() {
        System.out.println("getEdition");
        String expResult = "test";
        String result = book.getEdition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGenre method, of class Book.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        String expResult = "test";
        String result = book.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   }

    /**
     * Test of getISBN_10 method, of class Book.
     */
    @Test
    public void testGetISBN_10() {
        System.out.println("getISBN_10");
        String expResult = "test";
        String result = book.getISBN10();
        assertEquals(expResult, result);
    }

    /**
     * Test of getISBN_13 method, of class Book.
     */
    @Test
    public void testGetISBN_13() {
        System.out.println("getISBN_13");
        String expResult = "test";
        String result = book.getISBN13();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        String expResult = "test";
        String result = book.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuthor method, of class Book.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "test";
        Book instance = new Book();
        instance.setAuthor(author);
        assertEquals(author, instance.getAuthor());
       
    }

    /**
     * Test of setBookID method, of class Book.
     */
    @Test
    public void testSetBookID() {
        System.out.println("setBookID");
        int bookID = 10;
        Book instance = new Book();
        instance.setBookID(bookID);
        assertEquals(bookID, instance.getBookID());
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "test";
        Book instance = new Book();
        instance.setTitle(title);
        assertEquals(title, instance.getTitle());
    }

    /**
     * Test of setDescription method, of class Book.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "test";
        Book instance = new Book();
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of setEdition method, of class Book.
     */
    @Test
    public void testSetEdition() {
        System.out.println("setEdition");
        String edition = "test";
        Book instance = new Book();
        instance.setEdition(edition);
        assertEquals(edition, instance.getEdition());
     }

    /**
     * Test of setISBN_10 method, of class Book.
     */
    @Test
    public void testSetISBN_10() {
        System.out.println("setISBN_10");
        String ISBN_10 = "test";
        Book instance = new Book();
        instance.setISBN10(ISBN_10);
        assertEquals(ISBN_10, instance.getISBN10());
    }

    /**
     * Test of setISBN_13 method, of class Book.
     */
    @Test
    public void testSetISBN_13() {
        System.out.println("setISBN_13");
        String ISBN_13 = "test";
        Book instance = new Book();
        instance.setISBN13(ISBN_13);
        assertEquals(ISBN_13, instance.getISBN13());
    }

    /**
     * Test of setGenre method, of class Book.
     */
    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        String genre = "test";
        Book instance = new Book();
        instance.setGenre(genre);
        assertEquals(genre, instance.getGenre());
    }

    /**
     * Test of setPublisher method, of class Book.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "test";
        Book instance = new Book();
        instance.setPublisher(publisher);
        assertEquals(publisher, instance.getPublisher());
    }

    /**
     * Test of getImageLink method, of class Book.
     */
    @Test
    public void testGetImageLink() {
        System.out.println("getImageLink");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getImageLink();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImageLink method, of class Book.
     */
    @Test
    public void testSetImageLink() {
        System.out.println("setImageLink");
        String imageLink = "";
        Book instance = new Book();
        instance.setImageLink(imageLink);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN10 method, of class Book.
     */
    @Test
    public void testGetISBN10() {
        System.out.println("getISBN10");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getISBN10();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBN13 method, of class Book.
     */
    @Test
    public void testGetISBN13() {
        System.out.println("getISBN13");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getISBN13();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setISBN10 method, of class Book.
     */
    @Test
    public void testSetISBN10() {
        System.out.println("setISBN10");
        String ISBN10 = "";
        Book instance = new Book();
        instance.setISBN10(ISBN10);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setISBN13 method, of class Book.
     */
    @Test
    public void testSetISBN13() {
        System.out.println("setISBN13");
        String ISBN13 = "";
        Book instance = new Book();
        instance.setISBN13(ISBN13);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
