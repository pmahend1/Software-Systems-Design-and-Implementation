/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.Rating;
import business.Review;
import data.BookDB;
import data.RatingDB;
import data.ReviewDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Prateek
 */
public class RatingManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "/viewBook.jsp";
        //String userStr = request.getParameter("user");
        System.out.println(action);
        HttpSession session = request.getSession();

        System.out.println("admin.RatingManager.doPost()");

        Cookie[] cookies = request.getCookies();
        String userCookievalue = null;

        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if(name.equals("userCookie"))
            {
                userCookievalue = cookie.getValue();
                System.out.println("Cookie : " + name + " - " + userCookievalue);
            }

        }
        if (action.equals("")) {
            action = "dummy";
        } else if (action.equals("rateBook")) {
            String bookIDStr = request.getParameter("bookID");
            String ratingStr = request.getParameter("rating");
            int rating = 0, bookID = 0;
            System.out.println("bookIDStr : " + bookIDStr);
            System.out.println("ratingStr : " + ratingStr);
            if (bookIDStr == null) {
                bookIDStr = "dummy";
            }
            if (ratingStr == null) {
                ratingStr = "dummy";
            }
            try {
                rating = Integer.parseInt(ratingStr);
                System.out.println("Rating int : " + rating);
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                bookID = Integer.parseInt(bookIDStr);
                System.out.println("Book Id int : " + bookID);
            } catch (Exception e) {
                System.out.println(e);
            }

            if (userCookievalue != null) {
                Rating newRating = new Rating(bookID, userCookievalue, rating);
                
                
                boolean reviewExists = ReviewDB.checkReviewExists(bookID, userCookievalue);
                System.out.println("reviewExists " + reviewExists + " User name " +userCookievalue+ " bookId " +bookID);
                request.setAttribute("reviewexists", reviewExists);
   
                if (RatingDB.checkRatingExists(newRating)) {
                    
                    if (rating == 0) {
                        RatingDB.deleteRating(newRating);
                        url = "/viewBook.jsp";
                        Book book = BookDB.selectBook(bookID);
                        double[] averageArray = RatingDB.getAverageRating(bookID);

                        request.setAttribute("avgRating", averageArray[0]);
                        request.setAttribute("votes", (int) averageArray[1]);
                        request.setAttribute("rating", rating);
                        request.setAttribute("book", book);
                        //getServletContext().getRequestDispatcher(url).forward(request, response);
                    } else {
                        RatingDB.updateRating(newRating);
                        url = "/viewBook.jsp";
                        Book book = BookDB.selectBook(bookID);
                        double[] averageArray = RatingDB.getAverageRating(bookID);
                        System.out.println("avgRating " + averageArray[0]);
                        System.out.println("votes " + averageArray[1]);

                        request.setAttribute("avgRating", averageArray[0]);
                        request.setAttribute("votes", (int) averageArray[1]);
                        request.setAttribute("rating", rating);
                        request.setAttribute("book", book);
                        //getServletContext().getRequestDispatcher(url).forward(request, response);
                    }

                } else {
                    RatingDB.insertRating(newRating);
                    url = "/viewBook.jsp";
                    Book book = BookDB.selectBook(bookID);
                    double[] averageArray = RatingDB.getAverageRating(bookID);
                        System.out.println("avgRating " + averageArray[0]);
                        System.out.println("votes " + averageArray[1]);

                        request.setAttribute("avgRating", averageArray[0]);
                        request.setAttribute("votes", (int) averageArray[1]);
                        request.setAttribute("rating", rating);
                    request.setAttribute("book", book);
                    //getServletContext().getRequestDispatcher(url).forward(request, response);
                }
                List<Review> reviews = ReviewDB.getReviewsFromBookID(bookID);
                for (int i =0; i < reviews.size(); i++)
                {
                    Review review = (Review)reviews.get(i);
                    System.out.println("Review id : " + review.getReview());

                    int userRating = RatingDB.getUserRating(bookID, review.getUserName());
                    review.setUserrating(userRating);
                }
                request.setAttribute("reviewlist", reviews);
                request.setAttribute("user", userCookievalue);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }

        }
    }

}
