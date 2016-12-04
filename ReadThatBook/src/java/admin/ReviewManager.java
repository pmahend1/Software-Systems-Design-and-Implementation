/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.Review;
import business.User;
import data.BookDB;
import data.RatingDB;
import data.ReviewDB;
import data.UserDB;
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
 * @author sanju
 */
@WebServlet(name = "ReviewManager", urlPatterns = {"/ReviewManager"})
public class ReviewManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request == null || response == null)
            return;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReviewManager</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        if (request == null || response == null)
            return;
        String action = request.getParameter("action");
        String url = "/viewBook.jsp";
        String reviewStr = null;
        //String userStr = request.getParameter("user");
        System.out.println("action=" +action);
  
        System.out.println("admin.ReviewManager.doPost()");
        String userCookievalue = null;
        Cookie[] cookies = request.getCookies();
        User user = null;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(name.equals("userCookie"))
            {
                userCookievalue = cookie.getValue();
                user = UserDB.selectUser(cookie.getValue());
                request.setAttribute("user", user);
                System.out.println("Cookie : " + name + " - " + userCookievalue);
            }
            
        }
        if (action.equals("")) {
            action = "dummy";
        } else if (action.equals("reviewBook") || action.equals("editreview") || action.equals("editreviewBook")) {
            String bookIDStr = request.getParameter("bookID");
            reviewStr = request.getParameter("review");
            request.setAttribute("showtextarea", false);
            int bookID = 0;
            System.out.println("bookIDStr : " + bookIDStr);
            System.out.println("reviewStr : " + reviewStr);
            if (bookIDStr == null) {
                bookIDStr = "dummy";
            }
            if (reviewStr == null) {
                reviewStr = "dummy";
            }

            try {
                bookID = Integer.parseInt(bookIDStr);
                System.out.println("Book Id int : " + bookID);
            } catch (Exception e) {
                System.out.println(e);
            }
            //String userCookie = cookies[1].getValue();
            System.out.println("userCookievalue : " + userCookievalue);
            String buttonStatus = request.getParameter("buttonStatus");
            if (userCookievalue != null) {
                Review newReview = new Review(bookID, userCookievalue, reviewStr);
                if (ReviewDB.checkReviewExists(bookID, userCookievalue)) {
                    if (action.equals("editreview"))
                    {
                        
                        if (buttonStatus.compareTo("Edit") == 0)
                        {
                            request.setAttribute("showtextarea", true);
                            request.setAttribute("editreviewvalue", reviewStr);
                            System.out.println("Clicked edit review button: ");
                        }
                        else if(buttonStatus.compareTo("Delete") == 0)
                        {
                            System.out.println("Clicked delete review button: ");
                            ReviewDB.deleteReview(newReview);
                        }
                        
                    }
                    else if (action.equals("editreviewBook"))
                    {
                        System.out.println("updating review : ");
                        ReviewDB.updateReview(newReview);
                    }
                } else {
                    ReviewDB.insertReview(newReview);
                }
                url = "/viewBook.jsp";
                System.out.println("Insert review : ");

                List<Review> reviews = ReviewDB.getReviewsFromBookID(bookID);
                for (int i =0; i < reviews.size(); i++)
                {
                    Review review = (Review)reviews.get(i);
                    System.out.println("Review id : " + review.getReview());
                    if (review.getUserName().compareTo(userCookievalue) == 0)
                        reviewStr = review.getReview();
                    int userRating = RatingDB.getUserRating(bookID, review.getUserName());
                    review.setUserrating(userRating);
                    
                    String userRole = UserDB.getUserRole(review.getUserName());
                    review.setUserRole(userRole);
                    
                    if (userRole.compareTo("Critic") == 0)
                    {
                        reviews.remove(i);
                        reviews.add(0, review);
                    }
                }
                request.setAttribute("reviewlist", reviews);
                Book book = BookDB.selectBook(bookID);
                double[] averageArray = RatingDB.getAverageRating(bookID);
                System.out.println("avgReview " + averageArray[0]);
                System.out.println("votes " + averageArray[1]);

                int rating = RatingDB.getUserRating(bookID, userCookievalue);
                String avgRating = String.format("%.2f", averageArray[0]);
                request.setAttribute("avgRating", avgRating);
                request.setAttribute("votes", (int) averageArray[1]);
                request.setAttribute("review", newReview);
                System.out.println("action:"+action);
                if (action.equals("editreview") && buttonStatus.compareTo("Edit") == 0)
                {
                    System.out.println("admin.ReviewManager.doPost()" +reviewStr);
                    request.setAttribute("editreviewvalue", reviewStr);
                }
                request.setAttribute("rating", rating);
                request.setAttribute("book", book);
                request.setAttribute("userName", userCookievalue);
                request.setAttribute("user", user);
                boolean reviewExists = ReviewDB.checkReviewExists(bookID, userCookievalue);
                request.setAttribute("reviewexists", reviewExists);
                getServletContext().getRequestDispatcher(url).forward(request, response);


            }

        }
        
    }



}
