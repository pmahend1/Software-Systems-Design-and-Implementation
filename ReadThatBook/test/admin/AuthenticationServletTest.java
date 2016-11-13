/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.User;
import data.BookDB;
import data.ConnectionPool;
import data.UserDB;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Prateek
 */
public class AuthenticationServletTest extends Mockito {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher rd;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher rd = mock(RequestDispatcher.class);
        rd.include(request, response);
        ServletContext sc = mock(ServletContext.class);
        
        when(request.getParameter("action")).thenReturn("login");
        when(request.getParameter("userName")).thenReturn("pmahend1");
        when(request.getParameter("passWord")).thenReturn("pmahend1");
//        when("url").thenReturn("/home.jsp");
     
        //when(pool.getConnection()).thenReturn(connection);
        //when(request.getParameter("rememberMe")).thenReturn("Y");
        when(request.getSession()).thenReturn(session);
        //when(request.getRequestDispatcher("/home.jsp")).thenReturn(rd);
        //when(request.getServletContext().getRequestDispatcher("/home.jsp")).thenReturn(rd);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        //when(response.getWriter()).thenReturn(pw);
        System.out.println("Step Test 1");
        new AuthenticationServlet().doPost(request, response);
        System.out.println("Step Test 2");
        List<Book> books = BookDB.selectAllBooks();

        //Verify the session attribute value
        //verify(request).setAttribute("books", books);

       // request.setAttribute("books", books);
        //verify(rd).forward(request, response);
       verify(request, atLeast(1)).getParameter("action");

        String result = sw.getBuffer().toString().trim();

        System.out.println("Result: " + result);

        assertEquals("", result);
    }
}
