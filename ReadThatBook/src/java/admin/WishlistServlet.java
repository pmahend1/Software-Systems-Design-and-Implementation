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
import java.nio.file.Paths;
import java.sql.SQLException;
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
            String username= request.getParameter("username");
            String bookIdstring = request.getParameter("bookid");
            if(bookIdstring==null){
                bookIdstring="nothing";
            }
            int bookId=0;
            bookId=Integer.parseInt(bookIdstring);
            //System.out.println("admin.HomeServlet.doPost() bookIdstring"+bookIdstring +" int "+ bookId);
            WishlistDB.addBook(username,bookId);
            System.out.println("Added to wishlist");
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("viewWishlist")) {
            url = "/wishlist.jsp";
            String username= request.getParameter("username");
            System.out.println(username);
            User user = UserDB.selectUser(username);
            try {
                List<Book> books =WishlistDB.viewWishlist(username);
                
                request.setAttribute("books", books);
                request.setAttribute("username", username);
                request.setAttribute("user", user);
                System.out.println("Sent to wishlist");
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(WishlistServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        } else if (action.equals("deleteWishlist")) {
            url="/wishlist.jsp";
            String username= request.getParameter("username");
            String bookIdstring = request.getParameter("bookid");
            if(bookIdstring==null){
                bookIdstring="nothing";
            }
            int bookId=0;
            bookId=Integer.parseInt(bookIdstring);
            WishlistDB.deleteWishlist(username,bookId);
            //request.setAttribute("books", books);
            System.out.println("Removed from wishlist");
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        }  
    }
}
