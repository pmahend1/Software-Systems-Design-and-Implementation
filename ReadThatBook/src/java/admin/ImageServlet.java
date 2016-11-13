/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import data.ConnectionPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Prateek
 */
@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    // content=blob, name=varchar(255) UNIQUE.
    private static final String SQL_FIND = "select image from bookimage where BOOK_ID = ?";

    @Resource(name = "jdbc/read_that_book") // For Tomcat, define as <Resource> in context.xml and declare as <resource-ref> in web.xml.
    private DataSource dataSource;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request == null || response == null)
            return;
        String imageIDstr = request.getPathInfo().substring(1); // Returns "foo.png".
        System.out.println(request);
        System.out.println(request.getPathInfo());
        System.out.println("Image for book ID " + imageIDstr);
        int imageID=0;
        try {
            imageID = Integer.parseInt(imageIDstr);
        } catch (Exception e) {
            System.out.println(e);
        }

        try (
                Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(SQL_FIND)) 
        {
            statement.setInt(1, imageID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    byte[] content = resultSet.getBytes("image");
                    
                    response.setContentType(getServletContext().getMimeType(imageIDstr));
                    response.setContentLength(content.length);
                    response.getOutputStream().write(content);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
                }
            }
        } catch (Exception e) {
            throw new ServletException("Something failed at SQL/DB level.", e);
        }
    }

}
