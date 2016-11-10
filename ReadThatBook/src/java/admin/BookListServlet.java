/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.Rating;
import data.BookDB;
import data.RatingDB;
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
 * @author Sweet_Home
 */
@WebServlet(name = "BookListServlet", urlPatterns = {"/BookListServlet"})
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
       // String url = "/index.jsp";
        //String message = "";
        System.out.println("admin.BookListServlet.doPost()" + action);

        if (action == null) {
            
            String url = "/guestHome.jsp";
            //Book books = BookDB.viewBook(1);
            
            List<Book> books = BookDB.selectAllBooks();
            
            request.setAttribute("books", books);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            else if (action.equals("viewBook")) {
            
                String url = "/viewBook.jsp";
                String bookIdstring = request.getParameter("bookid");
                if(bookIdstring==null){
                    bookIdstring="nothing";
                }
                int bookId=0;

                bookId=Integer.parseInt(bookIdstring);
                System.out.println("admin.BookListServlet.doPost() bookIdstring"+bookIdstring +" int "+ bookId);
                Book book = BookDB.selectBook(bookId);
                Cookie[] cookies = request.getCookies();
                String userCookie = cookies[1].getValue();
                System.out.println(userCookie);
                int rating,votes=0;
                rating = RatingDB.getUserRating(bookId, userCookie);
                
                double[] averageArray = RatingDB.getAverageRating(bookId);
                votes = (int)averageArray[1];
                System.out.println("avgRating " + averageArray[0]);
                System.out.println("votes " + votes);
                
                request.setAttribute("avgRating", averageArray[0]);
                request.setAttribute("votes", votes);
                
                request.setAttribute("book", book);
                request.setAttribute("rating", rating);
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
                }
           
        }
}

