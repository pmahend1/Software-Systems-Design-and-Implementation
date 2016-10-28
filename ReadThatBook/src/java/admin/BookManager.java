/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.Book;
import data.BookDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookManager at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = "/index.jsp";
        String message = "";
        System.out.println("admin.BookManager.doPost()" + action);
        if (action == null) {
            action = "viewHome";
        } else if (action.equals("addBook")) {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String ISBN_13Str = request.getParameter("ISBN_13");
            String ISBN_10Str = request.getParameter("ISBN_10");
            
            int ISBN_10 = 0,ISBN_13 = 0;
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
                 ISBN_13 = Integer.parseInt(ISBN_13Str);
                 System.out.println("inside try");

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

            Book newBook = new Book(title, author, ISBN_10, ISBN_13, genre, edition, publisher, description);
            BookDB.addBook(newBook);
           // String addedBookID = BookDB.selectBook(ISBN_13)
            if(inputStream!=null){
                BookDB.addBookImage(1, inputStream);
            }
            url = "/manageBooks.jsp";
            List<Book> booklist =  BookDB.selectAllBooks();
            request.setAttribute("booklist", booklist);
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
                url = "/index.jsp";
                //request.setAttribute("booklist", booklist);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            BookDB.deleteBook(bookID);
            url = "/index.jsp";
            //request.setAttribute("booklist", booklist);
            getServletContext().getRequestDispatcher(url).forward(request, response);

        } else if (action.equals("manageBooks")) {
            url = "/manageBooks.jsp";
            List<Book> bookList = BookDB.selectAllBooks();
            System.out.println(bookList.get(0).getAuthor());
            request.setAttribute("bookList", bookList);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("addBookPage")) {
            url = "/addBooks.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
