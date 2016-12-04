/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.User;
import data.BookDB;
import data.ContactUsDB;
import data.UserDB;
import data.SpamDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raka Choudhury
 */
@WebServlet(name = "BookListServlet", urlPatterns = {"/BookListServlet"})
public class SpamServlet extends HttpServlet {

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

        
        
        String url = "/index.jsp";
        if (action == null) {
            action = "viewHome";
        } else if (action.equals("reportSpam")) {
            url = "/home.jsp";
            String message,reporter = null;
            String username= request.getParameter("username");
            String reason= request.getParameter("reason");
            Cookie[] cookies = request.getCookies();
            
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            reporter = cookie.getValue();
            System.out.println(name + " " + reporter);
        }
            User user = UserDB.selectUser(reporter);
            List<Book> books = BookDB.selectAllBooks();   
            
            String bookIdstring = request.getParameter("bookID");
            if(bookIdstring==null){
                bookIdstring="nothing";
            }
            int bookId=0;
            bookId=Integer.parseInt(bookIdstring);
            int s=SpamDB.addSpam(username,bookId,reporter,reason);
            if(s==0)
            { 
                message="Review has been already reported as spam.";
            }
            else
            {
                message="Review has been successfully reported as spam.";
            }
            Book b=BookDB.selectBook(bookId);
            String description="Review for Book: "+b.getTitle() +" ID= "+bookId+" by User= "+username+" is a spam. Reason: "+reason+".Please delete this spam review.";
            ContactUsDB.addContactUsDescription(reporter,"Report Spam Review",description);
            request.setAttribute("wishMessage", message);
            request.setAttribute("books", books);
            request.setAttribute("username", reporter);
            request.setAttribute("user", user);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } 
    }
}
