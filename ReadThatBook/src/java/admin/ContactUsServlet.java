package admin;

import business.ContactUs;
import business.User;
import data.ContactUsDB;
import data.UserDB;
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
                System.out.println("Cookie : " + cookie.getName() + " - " + cookie.getName());
                if (cookie.getName().equals("userCookie")) {
                    userName = cookie.getValue();
                    user = UserDB.selectUser(userName);
                }
            }
        }

        if (action == null) {
            action = "";
        }
        String userRole = "";
        if (user != null) {
            userRole = user.getRole();
            System.out.println("User role : " + userRole);
        }

        List<ContactUs> contactUsInfoList = null;

        switch (action) {
            case "contactUsPage":
                if (userRole == "admin") {
                    url = "/notifications.jsp";
                } else {
                    url = "/contactUs.jsp";
                }
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
                    url = "/contactUs.jsp";
                    message = "Description should be at least 50 characters length";
                    request.setAttribute("message", message);
                    System.out.println("message set is : " + message);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                } else if (userName != null) {
                    status = ContactUsDB.addContactUsDescription(userName, category, description);
                    if (status != 0) {
                        url = "/home.jsp";
                        message = "Contact Us info has been submitted";
                        request.setAttribute("message", message);
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    } else {
                        url = "/contactUs.jsp";
                        message = "Error in contact us info submission";
                        request.setAttribute("message", message);
                        getServletContext().getRequestDispatcher(url).forward(request, response);
                        break;
                    }
                } else {
                    url = "/contactUs.jsp";
                    message = "Error in contact us info submission.Please retry";
                    request.setAttribute("message", message);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }
            case "contactUsInfo": {
                String IDStr = request.getParameter("ID");
                int ID = 0;
                try {
                    ID = Integer.parseInt(IDStr);
                } catch (Exception e) {
                    System.out.println("Exception at Integer.parseInt(IDStr) :" + e);

                }
                if (ID != 0) {
                    url = "/notificationDetail.jsp";
                    ContactUs contactUsObj = ContactUsDB.selectContactUsDescription(ID);
                    request.setAttribute("notification", contactUsObj);
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                } else {
                    url = "/notifications.jsp";
                    //ContactUs contactUsObj = ContactUsDB.selectContactUsDescription(ID);
                    request.setAttribute("message", "Oops! Something went wrong..");
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    break;
                }

            }
            case "notificationdecision":
                String usertoApprove = request.getParameter("userName");
                String buttonType = request.getParameter("buttonStatus");
                System.out.println("usertoApprove = " + usertoApprove);
                System.out.println("buttontype = " + buttonType);

                String IDStr = request.getParameter("ID");
                int ID = 0;
                try {
                    ID = Integer.parseInt(IDStr);
                } catch (Exception e) {
                    System.out.println("Exception at Integer.parseInt(IDStr) :" + e);

                }
                if (ID != 0) {
                    url = "/notificationDetail.jsp";

                    if (buttonType.compareTo("Approve") == 0) {
                        System.out.println("notificationdecision approve");
                        UserDB.updateUserRole(usertoApprove, "Critic");
                        ContactUsDB.updateContactUsCategory(ID, "Critic");

                    } else {
                        System.out.println("notificationdecision discard");
                        UserDB.updateUserRole(usertoApprove, "User");
                        ContactUsDB.updateContactUsCategory(ID, "User");
                    }
                    ContactUs contactUsObj = ContactUsDB.selectContactUsDescription(ID);

                    request.setAttribute("notification", contactUsObj);
                    getServletContext().getRequestDispatcher(url).forward(request, response);

                } else {
                    url = "/notifications.jsp";
                    //ContactUs contactUsObj = ContactUsDB.selectContactUsDescription(ID);
                    request.setAttribute("message", "Oops! Something went wrong..");
                    getServletContext().getRequestDispatcher(url).forward(request, response);

                }
                break;
            default: {
                if (userRole.equals("admin")) {
                    url = "/notifications.jsp";
                    contactUsInfoList = ContactUsDB.selectAllContactUsDescriptions();
                    request.setAttribute("contactUsInfoList", contactUsInfoList);
                    System.out.println("hereX");
                } else if (userRole.equals("user")) {
                    url = "/contactUs.jsp";
                } else {
                    url = "/guestHome.jsp";
                }
                message = "Please log in to access this feature.";
                request.setAttribute("searchErrorMessage", message);
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            }

        }

        System.out.println("===========admin.ContactUsServlet.doPost()=========");
    }

}
