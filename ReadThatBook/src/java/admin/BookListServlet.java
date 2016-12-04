/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.User;
import business.Rating;
import business.Review;
import data.BookDB;
import data.RatingDB;
import data.ReviewDB;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        if (request == null || response == null) {
            return;
        }
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        // String url = "/index.jsp";
        //String message = "";
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

        System.out.println("admin.BookListServlet.doPost()" + action);

        if (action == null) {

            String url = "/guestHome.jsp";

            List<Book> books = BookDB.selectAllBooks();
            request.setAttribute("user", user);
            request.setAttribute("books", books);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("viewBook")) {

            String url = "/viewBook.jsp";
            String bookIdstring = request.getParameter("bookid");
            if (bookIdstring == null) {
                bookIdstring = "nothing";
            }
            int bookId = 0;

            bookId = Integer.parseInt(bookIdstring);
            System.out.println("admin.BookListServlet.doPost() bookIdstring" + bookIdstring + " int " + bookId);
            List<Book> bookList = new ArrayList();
            Book book = BookDB.selectBook(bookId);
            bookList.add(book);
            String userCookie = null;
//            Cookie[] cookies = request.getCookies();
//            for (int i = 0; i < cookies.length; i++) {
//                if (cookies[i].getName().equals("userCookie")) {
//                    userCookie = cookies[i].getValue();
//                }
//            }
            System.out.println(userCookie);
            int rating, votes = 0;
            rating = RatingDB.getUserRating(bookId, userCookie);

            double[] averageArray = RatingDB.getAverageRating(bookId);
            votes = (int) averageArray[1];
            System.out.println("avgRating " + averageArray[0]);
            System.out.println("votes " + votes);

            String userCookievalue = null;

            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("userCookie")) {
                    userCookievalue = cookie.getValue();
                    System.out.println("Cookie : " + name + " - " + userCookievalue);
                }

            }
            boolean reviewExists = ReviewDB.checkReviewExists(bookId, userCookievalue);
            System.out.println("reviewExists " + reviewExists + " User name " + userCookievalue + " bookId " + bookId);
            request.setAttribute("reviewexists", reviewExists);

            List<Review> reviews = ReviewDB.getReviewsFromBookID(bookId);
            for (int i = 0; i < reviews.size(); i++) {
                Review review = (Review) reviews.get(i);
                System.out.println("Review id : " + review.getReview());

                int userRating = RatingDB.getUserRating(bookId, review.getUserName());
                review.setUserrating(userRating);

                String userRole = UserDB.getUserRole(review.getUserName());
                review.setUserRole(userRole);

                if (userRole.compareTo("Critic") == 0) {
                    reviews.remove(i);
                    reviews.add(0, review);
                }
            }
            request.setAttribute("reviewlist", reviews);

            String avgRating = String.format("%.2f", averageArray[0]);
            System.out.println("avgRating : " + avgRating);
            request.setAttribute("avgRating", avgRating);

            request.setAttribute("avgRatinginDouble", Math.round(averageArray[0]));
            request.setAttribute("votes", votes);
            request.setAttribute("bookResult", bookList);
            request.setAttribute("book", book);
            request.setAttribute("rating", rating);
            request.setAttribute("userName", userCookievalue);

            List<Book> similarBookList = null;
            String genre = BookDB.getGenreofBook(bookId);
            String author = BookDB.getAuthorOfBook(bookId);
            similarBookList = BookDB.searchSimilarBooks(genre, author, bookId);
            request.setAttribute("similarBookList", similarBookList);
            System.out.println("similarBookList " + similarBookList.toString());
            if (similarBookList != null) {
                for (Book b : similarBookList) {
                    System.out.println(b.getTitle());
                }
            }
            request.setAttribute("user", user);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        }

    }
}
