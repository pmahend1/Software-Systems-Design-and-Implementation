/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.User;
import business.Wishlist;
import data.BookDB;
import data.UserDB;
import data.WishlistDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Sweet_Home
 */
public class WishlistServlet extends HttpServlet {

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
        String action = request.getParameter("action");
        //String userStr = request.getParameter("user");
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + " " + value);
        }
        
        String url = "/index.jsp";
        if (action == null) {
            action = "viewHome";
        } else if (action.equals("addToWishlist")) {
            url = "/home.jsp";
            String message;
            String username= request.getParameter("username");
            User user = UserDB.selectUser(username);
            List<Book> books = BookDB.selectAllBooks();   
            
            String bookIdstring = request.getParameter("bookid");
            if(bookIdstring==null){
                bookIdstring="nothing";
            }
            int bookId=0;
            try {
                bookId=Integer.parseInt(bookIdstring);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("username :" + username);
            System.out.println("bookId :" + bookId);
            int s=WishlistDB.addBook(username,bookId);
            if(s==0)
            { message="This book has been already added to your wishlist.";}
            else
            {
                message="Book has been successfully added to your wishlist.";
            }
            request.setAttribute("wishMessage", message);
            request.setAttribute("books", books);
            request.setAttribute("username", username);
            request.setAttribute("user", user);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("viewWishlist")) {
            url = "/wishlist.jsp";
            String username= request.getParameter("username");
            System.out.println("inside wishlistservlet-viewwishlist action"+username);
            User user = UserDB.selectUser(username);
            try {
                List<Book> books =WishlistDB.viewWishlist(username);
                
                request.setAttribute("books", books);
                request.setAttribute("username", username);
                request.setAttribute("user", user);
                System.out.println("Sent to wishlist");
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(WishlistServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        } else if (action.equals("deleteWishlist")) {
            url="/wishlist.jsp";
            System.out.println("Inside deleteWishlist action : WishlistServlet");
            String username= request.getParameter("username");
            User user = UserDB.selectUser(username);
            String bookIdstring = request.getParameter("bookid");
            if(bookIdstring==null){
                bookIdstring="nothing";
            }
            if(username==null){
                username="";
            }
            System.out.println("username : " + username );
            int bookId=0;
            bookId=Integer.parseInt(bookIdstring);
            WishlistDB.deleteWishlist(username,bookId);
            List<Book> wishlist = new ArrayList();
            try {
                 wishlist = WishlistDB.viewWishlist(username);
            } catch (Exception ex) {
                Logger.getLogger(WishlistServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("books", wishlist);
            request.setAttribute("username", username);
            request.setAttribute("user", user);
            System.out.println("Removed from wishlist");
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
}
