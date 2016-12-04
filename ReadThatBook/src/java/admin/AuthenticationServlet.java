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
 * @author Prateek
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        if (request == null || response == null)
            return;
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = "/index.jsp";
        String message = "";
        System.out.println("admin.LoginServlet.doPost()" + action);

        if (action == null) {
            action = "viewHome";
        } else if (action.equals("login")) {
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            User user = UserDB.selectUser(userName);
            System.out.println("admin.LoginServlet.doPost()" + "userName " + userName);
            System.out.println("admin.LoginServlet.doPost()" + "passWord " + passWord);
            if (userName == null) {
                userName = "dummy";
            }
            if (passWord == null) {
                passWord = "dummy";
            }
            if (user == null) {
                System.out.println("admin.LoginServlet.doPost()" + "User Does not exist");
                url = "/guestHome.jsp";
                message= "User Does not exist";
                request.setAttribute("message", message);
                List<Book> books = BookDB.selectAllBooks();   
                request.setAttribute("books", books);
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            } else if (passWord.equals(user.getPassWord())&& userName.equals(user.getUserName())) {
                //user is registered
                url = "/home.jsp";
                Cookie userCookie = new Cookie("userCookie", userName);
                userCookie.setMaxAge(1*60*60);
                userCookie.setPath("/");
                response.addCookie(userCookie);
                request.setAttribute("user", user);

                List<Book> books = BookDB.selectAllBooks();   
                request.setAttribute("books", books);
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            } else {
                message = "Incorrect username or password";
                url = "/guestHome.jsp";
                List<Book> books = BookDB.selectAllBooks();   
                request.setAttribute("books", books);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher(url).forward(request, response);
            }

        } else if (action.equals("register")) {
            url = "/register.jsp";
            System.out.println("admin.LoginServlet.doPost()" + action + " else if");
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("registerForm")) {
            System.out.println("admin.LoginServlet.doPost()" + action + " else if");
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String rePassWord = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String userRole = request.getParameter("userRole");
            System.out.println("admin.LoginServlet.doPost()" + userName);

            System.out.println("admin.LoginServlet.doPost()" + passWord);
            System.out.println("admin.LoginServlet.doPost()" + rePassWord);
            System.out.println("admin.LoginServlet.doPost()" + firstName);
            System.out.println("admin.LoginServlet.doPost()" + lastName);
            System.out.println("admin.LoginServlet.doPost()" + email);
            System.out.println("admin.LoginServlet.doPost()" + userRole);

            if (userName.isEmpty() || passWord.isEmpty() || rePassWord.isEmpty()
                    || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                userName = "dummy";
                lastName = "dummy";
                rePassWord = "dummy1";
                email = "dummy";
                firstName = "dummy";
                lastName = "dummy";
                url="/guestHome.jsp";
                List<Book> books = BookDB.selectAllBooks();
                request.setAttribute("books", books);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } else if (passWord.equals(rePassWord)) {
                if (userRole.compareTo("Critic") == 0)
                {
                    System.out.println("Coming here");
                    userRole = "CriticPending";
                    String category = "Critic Access Request";
                    StringBuilder description = new StringBuilder("Hello, This is ");
                    description.append(userName);
                    description.append(". I would like to have Critic access. Please provide me the same");
                    ContactUsDB.addContactUsDescription(userName, category, description.toString());
                }
                System.out.println("Coming here 1");
                User newUser = new User(userName, firstName, lastName, email, passWord,userRole);
                UserDB.insert(newUser);
                url = "/home.jsp";
                User user = UserDB.selectUser(userName);    
                Cookie userCookie = new Cookie("userCookie", userName);
                userCookie.setMaxAge(1*60*60);
                userCookie.setPath("/");
                response.addCookie(userCookie);
                List<Book> books = BookDB.selectAllBooks();
                request.setAttribute("books", books);
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }else if (action.equals("logout")) {
            session=request.getSession();  
            session.invalidate();  
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userCookie")) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    request.removeAttribute("userCookie");
                }
            }

            System.out.println("Log out successful "); 
            message = "You are successfully logged out!";
            url = "/guestHome.jsp";
            request.setAttribute("message", message);
            
            List<Book> books = BookDB.selectAllBooks();   
            request.setAttribute("books", books);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (action.equals("viewProfile")) {
            url = "/userHomePage.jsp";
            //request.setAttribute("user", user);
            List<Book> books = BookDB.selectAllBooks();
            request.setAttribute("books", books);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (action.equals("backHome")) {
            url="/home.jsp";
            String username= request.getParameter("username");
            if(username == null){
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userCookie")) {
                        username = cookie.getValue();
                    }
                }
            }
            
            if(username == null)
                url="/guestHome.jsp";
            
            User user = UserDB.selectUser(username);
            List<Book> books = BookDB.selectAllBooks();   
            request.setAttribute("books", books);
            request.setAttribute("username", username);
            request.setAttribute("user", user);
            System.out.println("Back to homepage");
            
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
            
        }

    }

}
