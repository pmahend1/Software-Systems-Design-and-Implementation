/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Book;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
     * Test of addBook method, of class BookDB.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book book;
        book = new Book("E", "A", "4564", "645", "Fantasy", "1", "McGraw", "Book A");
        int result = BookDB.addBook(book);
        String title = "E";
        int bookidDB = BookDB.getBookIDByISBN("4564");
        Book bookDb = BookDB.selectBook(bookidDB);
        String titleDB = bookDb.getTitle();
        System.out.println(titleDB);
        assertEquals(title, titleDB);
    }

    /**
     * Test of updateBook method, of class BookDB.
     */
    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        Book book = BookDB.selectBook(BookDB.getBookIDByISBN("4564"));
        book.setTitle("new Title");
        int result = BookDB.updateBook(book);
        Book updatedBook = BookDB.selectBook(BookDB.getBookIDByISBN("4564"));
        String newTitle = updatedBook.getTitle();
        assertEquals(newTitle, "new Title");
    }
    
    /**
     * Test of addBookImage method, of class BookDB.
     */
    @Test
    public void testAddBookImage() throws UnsupportedEncodingException {
        System.out.println("addBookImage");
        int bookID = BookDB.getBookIDByISBN("4564");
        String imageUrl = "http://tse1.mm.bing.net/th?id=OIP.M7c14cc7de0243cc221aaca16f06a9eb5o2&w=246&h=183&c=7&rs=1&qlt=90&o=4&pid=1.1";
        InputStream inputStream = new ByteArrayInputStream(imageUrl.getBytes("UTF-8"));
        
        int result = BookDB.addBookImage(bookID, inputStream);
        byte[] dbValue = BookDB.getBookImage(bookID);
        String dbImageUrl = new String(dbValue,"UTF-8");
        System.out.println(dbImageUrl);
        assertEquals(imageUrl, dbImageUrl);
    }

    /**
     * Test of updateBookImage method, of class BookDB.
     */
    @Test
    public void testUpdateBookImage() throws UnsupportedEncodingException {
        System.out.println("updateBookImage");
        int bookID = 4;
        String testValue = "abc";
        InputStream is = new ByteArrayInputStream(testValue.getBytes("UTF-8"));
        BookDB.updateBookImage(bookID, is);
        byte[] dbValues = BookDB.getBookImage(bookID);
        String resultStringDB = new String(dbValues, "UTF-8");
        System.out.println(dbValues);
        System.out.println(resultStringDB);
        assertEquals(testValue, resultStringDB);
    }

    /**
     * Test of selectBook method, of class BookDB.
     */
    @Test
    public void testSelectBook() {
        System.out.println("selectBook");
        int bookID = 1;

        Book result = BookDB.selectBook(bookID);
        System.out.println(result.getTitle());

        assertEquals("Pride & Predujice", result.getTitle());
    }

    /**
     * Test of deleteBook method, of class BookDB.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        int bookID = BookDB.getBookIDByISBN("4564");
        int result = BookDB.deleteBook(bookID);
        Book retriveBook = BookDB.selectBook(bookID);
        assertEquals(retriveBook, null);
    }

    /**
     * Test of selectAllBooks method, of class BookDB.
     */
    @Test
    public void testSelectAllBooks() {
        System.out.println("selectAllBooks");
        List<Book> result = BookDB.selectAllBooks();
       
        //valid test case
        int sum=0;
        if(result!=null){
            for(Book book : result){
                System.out.println(book.getBookID());
                sum=sum+book.getBookID();
            }
        }
        assertTrue(sum>0);
    }

    /**
     * Test of getBookImage method, of class BookDB.
     */
    @Test
    public void testGetBookImage() throws UnsupportedEncodingException {
        System.out.println("getBookImage");
        int bookID = 4;
        
        String expResult = "abc";
        byte[] dbBytes = BookDB.getBookImage(bookID);
        String dbResult  = new String(dbBytes, "UTF-8");
        assertEquals(expResult, dbResult);
    }

    /**
     * Test of searchBook method, of class BookDB.
     */
    @Test
    public void testSearchBook() {
        System.out.println("searchBook");
        String bookTitle = "Pride & Predujice";
        List<Book> result = BookDB.searchBook(bookTitle);
        String dbBookTitle = BookDB.searchBook(bookTitle).get(0).getTitle();
        System.out.println(dbBookTitle);
        assertEquals(bookTitle, dbBookTitle);
    }

    /**
     * Test of checkBookImageExists method, of class BookDB.
     */
    @Test
    public void testCheckBookImageExists() {
        System.out.println("checkBookImageExists");
        int bookID = 1;
        boolean expResult = true;
        boolean result = BookDB.checkBookImageExists(bookID);
        assertEquals(expResult, result);

    }

    /**
     * Test of getBookIDByISBN method, of class BookDB.
     */
    @Test
    public void testGetBookIDByISBN() {
        System.out.println("getBookIDByISBN");
        String ISBN = "1234567890";
        int expBookId = 1;
        int result = BookDB.getBookIDByISBN(ISBN);
        assertEquals(expBookId, result);

    }

}
