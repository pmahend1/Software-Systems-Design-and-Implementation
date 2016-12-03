/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import data.BookDB;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author sanju
 */
public class WishlistServletTest {
    
    public WishlistServletTest() {
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
     * Test of doGet method, of class WishlistServlet.
     */
    @Test
    public void test() throws Exception {
        Cookie c=new Cookie("username","pmahend1");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher rd = mock(RequestDispatcher.class);
        rd.include(request, response);
        ServletContext sc = mock(ServletContext.class);
        Cookie[] cookies={c};
        when(request.getParameter("action")).thenReturn("addToWishlist");
        when(request.getParameter("userName")).thenReturn("pmahend1");
        when(request.getCookies()).thenReturn(cookies);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        System.out.println("Step Test 1");
        new WishlistServlet().doPost(request, response);
        System.out.println("Step Test 2");
        List<Book> books = BookDB.selectAllBooks();
        verify(request, atLeast(1)).getParameter("action");

        String result = sw.getBuffer().toString().trim();

        System.out.println("Result: " + result);

        assertEquals("", result);
}

    /**
     * Test of doGet method, of class WishlistServlet.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        WishlistServlet instance = new WishlistServlet();
        instance.doGet(request, response);

    }

    /**
     * Test of doPost method, of class WishlistServlet.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        WishlistServlet instance = new WishlistServlet();
        instance.doPost(request, response);

    }
}
