/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import business.User;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sanju
 */
@WebServlet(name = "UserProfileManager", urlPatterns = {"/UserProfileManager"})
public class UserProfileManager extends HttpServlet {

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
            out.println("<title>Servlet UserProfileManager</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserProfileManager at " + request.getContextPath() + "</h1>");
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
        
        String action = request.getParameter("action");
        
        HttpSession session = request.getSession();
        
        String message = "";
        System.out.println("admin.UserProfileManager.doPost()" + action);
        
        String username = request.getParameter("username");
        System.out.println("username =" +username);

        if (action == null) {
            action = "viewHome";
        } else if (action.equals("viewprofile")) {
            User user = UserDB.selectUser(username);
            System.out.println(user.toString());
            request.setAttribute("user", user);
            String url = "/profile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (action.equals("editprofile")) {
            User user = UserDB.selectUser(username);
            System.out.println(user.toString());
            request.setAttribute("user", user);
            String url = "/editProfile.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (action.equals("updateProfile")) {
            System.out.println("admin.UserProfileManager.doPost()" + action + " else if");
            String passWord = request.getParameter("passWord");
            String rePassWord = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            System.out.println("admin.UserProfileManager.doPost()" + passWord);
            System.out.println("admin.UserProfileManager.doPost()" + rePassWord);
            System.out.println("admin.UserProfileManager.doPost()" + firstName);
            System.out.println("admin.UserProfileManager.doPost()" + lastName);
            System.out.println("admin.UserProfileManager.doPost()" + email);

            if (passWord.isEmpty() || rePassWord.isEmpty()
                    || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                lastName = "dummy";
                rePassWord = "dummy1";
                email = "dummy";
                firstName = "dummy";
                lastName = "dummy";
            } else if (passWord.equals(rePassWord)) {
                
                User updateUser = new User(username, firstName, lastName, email, passWord, "user");
                UserDB.update(updateUser);
                String url = "/home.jsp";
                User user = UserDB.selectUser(username);
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            
        }else if(action.equals("deleteaccount"))
        {
            System.out.println("admin.UserProfileManager.doPost() deleteaccount");
            UserDB.delete(username);
            String url = "/index.jsp";
            System.err.println("after deletion");
            getServletContext().getRequestDispatcher(url).forward(request, response);
            System.err.println("after redirect");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}