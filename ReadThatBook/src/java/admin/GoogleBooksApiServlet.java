/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.User;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import data.BookDB;
import data.UserDB;
import googleApi.BookSearch;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Prateek
 */
public class GoogleBooksApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request == null || response == null)
            return;
        System.out.println("Inside GoogleBooksApiServlet");
        String queryString = request.getParameter("query");
        String action = request.getParameter("action");
        
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userCookie")) {
                    user = UserDB.selectUser(cookie.getValue());
                    request.setAttribute("user", user);
                }
            }
        }
        //System.out.println(queryString);
        if (queryString == null) {
            queryString = "";
        }
        if(action == null) {
            action="";
        }
        if(action.equals("addGoogleBook")){
            System.out.println("Inside addGoogleBook");
            String googleBook =  (String) request.getAttribute("bookN");
            String googleBook1 =   request.getParameter("bookN");
            if(googleBook == null && googleBook1 == null) {
                System.out.println("Null");
            }
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String ISBN_13Str = request.getParameter("ISBN_13");
            String ISBN_10Str = request.getParameter("ISBN_10");
             String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            String edition = request.getParameter("edition");
            String publisher = request.getParameter("publisher");
            String imageLink = request.getParameter("imageLink");
            String messageText ="";
            Book newBook = new Book(title, author, ISBN_10Str, ISBN_13Str, genre, edition, publisher, description);
			
            int status = BookDB.addBook(newBook);
            
            if(status == 0 ){
                messageText="Book already exists in database";
                String url="/manageBooks.jsp";
                 List<Book> bookList = BookDB.selectAllBooks();
                request.setAttribute("bookList", bookList);
                request.setAttribute("messageText", messageText);
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher(url).forward(request, response);
                
            }
            InputStream inputStream = new URL(imageLink).openStream();
            int bookID = 0;
          
            
             if(ISBN_10Str !=null){
             bookID= BookDB.getBookIDByISBN(ISBN_10Str);
            }
            else if(ISBN_13Str != null){
                bookID= BookDB.getBookIDByISBN(ISBN_13Str);
            }
            if (inputStream != null && bookID!= 0) {
                System.out.println("Inside inputStream != null");
                if(BookDB.checkBookImageExists(bookID)){
                    BookDB.updateBookImage(bookID, inputStream);
                    System.out.println("updateBookImage method called in servlet ");
                }
                else{
                    BookDB.addBookImage(bookID, inputStream);
                    System.out.println("addBookImage method called in servlet ");
                }  
            }
            String url="/manageBooks.jsp";
            List<Book> books = BookDB.selectAllBooks();
            request.setAttribute("bookList", books);
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher(url).forward(request, response);

        }
        else{
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        System.out.println("Parsed query" + BookSearch.parseQuery(queryString));
        List<Book> bookList = new ArrayList();
        try {
            bookList = BookSearch.queryGoogleBooks(jsonFactory, queryString);
        } catch (Exception ex) {
            Logger.getLogger(GoogleBooksApiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(bookList!=null){
            for (Book book : bookList) {
            System.out.println("Book : " + book.getTitle());
            }
        request.setAttribute("books", bookList);
        String url = "/googleSearchResults.jsp";
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        }
        
        
    }

}
