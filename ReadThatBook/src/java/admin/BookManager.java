/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import business.Rating;
import business.User;
import data.BookDB;
import data.RatingDB;
import data.UserDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Prateek
 */
@MultipartConfig
public class BookManager extends HttpServlet {

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
        String message = "";
        //User user = UserDB.selectUser(userStr);
        //System.out.println(user.getUserName() + " " + user.getRole());
        System.out.println("admin.BookManager.doPost()" + action);
        if (action == null) {
            action = "viewHome";
        } else if (action.equals("addBook")) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String ISBN_13Str = request.getParameter("ISBN_13");
            String ISBN_10Str = request.getParameter("ISBN_10");
            System.out.println("admin.BookManager.doPost()" + ISBN_13Str);
            System.out.println("admin.BookManager.doPost()" + ISBN_10Str);
            int ISBN_10 = 0;
            long ISBN_13 = 0;
            InputStream inputStream = null;
            //Collection coll = request.getParts();
            Part filePart = request.getPart("photo");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (filePart != null) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getContentType());

                inputStream = filePart.getInputStream();
            }
            try {
                ISBN_10 = Integer.parseInt(ISBN_10Str);
                System.out.println("inside try for ISBN_10Str");

            } catch (Exception e) {
                System.out.println("admin.BookManager.doPost()" + e);
            }
            try {
                ISBN_13 = Long.parseLong(ISBN_13Str);
                System.out.println("inside try for ISBN_13Str");

            } catch (Exception e) {
                System.out.println("admin.BookManager.doPost()" + e);
            }
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            String edition = request.getParameter("edition");
            String publisher = request.getParameter("publisher");
            System.out.println("admin.BookManager.doPost()" + title);
            System.out.println("admin.BookManager.doPost()" + description);
            System.out.println("admin.BookManager.doPost()" + ISBN_13);
            System.out.println("admin.BookManager.doPost()" + ISBN_10);
            System.out.println("admin.BookManager.doPost()" + author);
            System.out.println("admin.BookManager.doPost()" + genre);
            System.out.println("admin.BookManager.doPost()" + edition);
            System.out.println("admin.BookManager.doPost()" + publisher);

            Book newBook = new Book(title, author, ISBN_10Str, ISBN_13Str, genre, edition, publisher, description);
            BookDB.addBook(newBook);
            // String addedBookID = BookDB.selectBook(ISBN_13)
            if (inputStream != null) {
                BookDB.addBookImage(1, inputStream);
            }
            url = "/manageBooks.jsp";
            List<Book> bookList = BookDB.selectAllBooks();
            request.setAttribute("bookList", bookList);
            //byte[] imageBytes = getImageAsBytes();

//            response.setContentType("image/jpeg");
//            response.setContentLength(imageBytes.length);
//
//            response.getOutputStream().write(imageBytes);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("deleteBook")) {
            String bookIDStr = request.getParameter("bookID");
            System.out.println("admin.BookManager.doPost()" + " bookID = " + bookIDStr);
            int bookID = -1;
            System.out.println("admin.BookManager.doPost()" + " deleteBook");
            try {
                bookID = Integer.parseInt(bookIDStr);
                System.out.println("admin.BookManager.doPost()" + " bookIDInt = " + bookID);
            } catch (Exception e) {
                System.out.println(e);
                url = "/home.jsp";
                //request.setAttribute("booklist", booklist);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            BookDB.deleteBook(bookID);
            url = "/manageBooks.jsp";
            //request.setAttribute("user", user);
            List<Book> booklist = BookDB.selectAllBooks();
            request.setAttribute("bookList", booklist);
            getServletContext().getRequestDispatcher(url).forward(request, response);

        } else if (action.equals("manageBooks")) {
            url = "/manageBooks.jsp";
            List<Book> bookList = BookDB.selectAllBooks();

            request.setAttribute("bookList", bookList);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("addBookPage")) {
            url = "/addBooks.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if(action.equals("updateBookPage")){
            url="/updateBook.jsp";
            String bookIDStr = request.getParameter("bookID");
            System.out.println("Inside updateBookPage" );
            System.out.println("bookID is "+bookIDStr );
            int bookID=0;
            try {
                bookID = Integer.parseInt(bookIDStr);
            } catch (Exception e) {
                System.out.println(e);
            }
            Book updatableBook = BookDB.selectBook(bookID);
            System.out.println("book selected for update"+ updatableBook.getTitle());
            request.setAttribute("book", updatableBook);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(action.equals("updateBook")){
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String ISBN_13Str = request.getParameter("ISBN_13");
            String ISBN_10Str = request.getParameter("ISBN_10");
            System.out.println("admin.BookManager.doPost()" + ISBN_13Str);
            System.out.println("admin.BookManager.doPost()" + ISBN_10Str);
            int ISBN_10 = 0;
            long ISBN_13 = 0;
            InputStream inputStream = null;
            //Collection coll = request.getParts();
            Part filePart = request.getPart("photo");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            if (filePart != null) {
                System.out.println(filePart.getName());
                System.out.println(filePart.getContentType());

                inputStream = filePart.getInputStream();
            }
            try {
                ISBN_10 = Integer.parseInt(ISBN_10Str);
                System.out.println("inside try for ISBN_10Str");

            } catch (Exception e) {
                System.out.println("admin.BookManager.doPost()" + e);
            }
            try {
                ISBN_13 = Long.parseLong(ISBN_13Str);
                System.out.println("inside try for ISBN_13Str");

            } catch (Exception e) {
                System.out.println("admin.BookManager.doPost()" + e);
            }
            String author = request.getParameter("author");
            String genre = request.getParameter("genre");
            String edition = request.getParameter("edition");
            String publisher = request.getParameter("publisher");
            System.out.println("admin.BookManager.doPost()" + title);
            System.out.println("admin.BookManager.doPost()" + description);
            System.out.println("admin.BookManager.doPost()" + ISBN_13);
            System.out.println("admin.BookManager.doPost()" + ISBN_10);
            System.out.println("admin.BookManager.doPost()" + author);
            System.out.println("admin.BookManager.doPost()" + genre);
            System.out.println("admin.BookManager.doPost()" + edition);
            System.out.println("admin.BookManager.doPost()" + publisher);

            Book updateBook = new Book(title, author, ISBN_10Str, ISBN_13Str, genre, edition, publisher, description);
            BookDB.updateBook(updateBook);
            // String addedBookID = BookDB.selectBook(ISBN_13)
            if (inputStream != null) {
                BookDB.addBookImage(1, inputStream);
            }
            url = "/manageBooks.jsp";
            List<Book> bookList = BookDB.selectAllBooks();
            request.setAttribute("bookList", bookList);
            //byte[] imageBytes = getImageAsBytes();

//            response.setContentType("image/jpeg");
//            response.setContentLength(imageBytes.length);
//
//            response.getOutputStream().write(imageBytes);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        
        else if (action.equals("viewBooks")) {
            byte[] b = BookDB.getBookImage(8);
            OutputStream img = null;
            response.setContentType("image/png");
            img = response.getOutputStream();
            img.write(b);
            img.flush();
            img.close();
//                 request.setAttribute("param", 1);
//               response.setContentType("image/jpeg");
//            try {
//                response.setContentLength( (int) b.length());
//            } catch (SQLException ex) {
//                Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           // response.setContentLength(10);
//            InputStream is = null;
//            try {
//                is = b.getBinaryStream();
//            } catch (SQLException ex) {
//                Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            OutputStream os = response.getOutputStream();
//            byte buf[] = null;
//            try {
//                buf = new byte[(int) b.length()];
//            } catch (SQLException ex) {
//                Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            is.read(buf);
//            os.write(buf);
//            os.close();

        }
        else if (action.equals("searchBook")) {
            String bookName = request.getParameter("searchString");
            Book book = BookDB.searchBook(bookName);
            url="/viewBook.jsp";
            request.setAttribute("book", book);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
