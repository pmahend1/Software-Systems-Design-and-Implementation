/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googleApi;

import business.Book;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
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
public class BookSearchTest {
    
    public BookSearchTest() {
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
     * Test of queryGoogleBooks method, of class BookSearch.
     */
    @Test
    public void testQueryGoogleBooks() throws Exception {
        System.out.println("queryGoogleBooks");
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        String query = "Dan Brown";
        List<Book> result = BookSearch.queryGoogleBooks(jsonFactory, query);
        if(result!=null){
            for(Book b : result){
                System.out.println(b.getTitle());
            }
        }
        assertNotEquals(0, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parseQuery method, of class BookSearch.
     */
    @Test
    public void testParseQuery() {
        System.out.println("parseQuery");
        String args = "Harry";
        String expResult = "Harry";
        String result = BookSearch.parseQuery(args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
