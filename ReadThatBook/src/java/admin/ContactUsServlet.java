package admin;

import business.User;
import data.ContactUsDB;
import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ContactUsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request == null || response == null) {
            return;
        }
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = "/index.jsp";
        String message = "";
        System.out.println("===========admin.ContactUsServlet.doPost()=========");
        System.out.println("action :" + action);
        Cookie[] cookies = request.getCookies();
        String userName = "";
        User user = null;
        int status = 0;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie : " + cookie.getName());
                System.out.print(" - " + cookie.getName());
                if (cookie.getName().equals("userCookie")) {
                    userName = cookie.getName();
                    user = UserDB.selectUser(userName);
                }
            }
        }
        if(action==null){
            action="";
        }

        switch (action) {
            case "contactUsPage":
                url = "/contactUs.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "contactUsForm":
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                System.out.println("category : " + category);
                System.out.println("description : " + description);
                if (category == null) {
                    category = "";
                    return;
                }
                if (description == null || (description.length()) < 50) {
                    url = "/home.jsp";
                    message = "Description should be at least 50 characters length";
                    request.setAttribute("messsage", message);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                } else if (userName != null) {
                    status = ContactUsDB.addContactUsDescription(userName, category, description);
                    if (status != 0) {
                        url = "/home.jsp";
                        message = "Contact Us info has been submitted";
                        request.setAttribute("messsage", message);
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                    } else {
                        url = "/contactUs.jsp";
                        message = "Error in contact us info submission";
                        request.setAttribute("messsage", message);
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                    }
                } else {
                    url = "/contactUs.jsp";
                    message = "Error in contact us info submission.Please retry";
                    request.setAttribute("messsage", message);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                }

            default:
                url = "/contactUs.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;

        }

        System.out.println("===========admin.ContactUsServlet.doPost()=========");
    }

}
