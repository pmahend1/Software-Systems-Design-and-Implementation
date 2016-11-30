/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.ContactUs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prateek
 */
public class ContactUsDB {

    private static ConnectionPool pool;// = ConnectionPool.getInstance();
    private static Connection connection;// = pool.getConnection();
    private static PreparedStatement ps = null;
    private static String sql = "";
    private static ResultSet rs = null;

    public static int addContactUsDescription(String username, String category, String description) {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();
        sql = "INSERT INTO CONTACT_US (USERNAME ,CATEGORY , DESCRIPTION) VALUES (?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, category);
            ps.setString(3, description);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ContactUs selectContactUsDescription(int contactUsID) {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();

        String query = "SELECT * FROM Contact_Us "
                + "WHERE contactUsID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, contactUsID);
            System.out.println("Query : " + ps.toString());
            rs = ps.executeQuery();
            ContactUs contactus = new ContactUs();
            if (rs.next()) {
                contactus.setContactUsId(rs.getInt("contactUsID"));
                contactus.setUserName(rs.getString("username"));
                contactus.setCategory(rs.getString("category"));
                contactus.setDescription(rs.getString("description"));
                System.out.println("here" + contactus.getCategory());
            }
            return contactus;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static List<ContactUs> selectAllContactUsDescriptions() {
        pool = ConnectionPool.getInstance();
        connection = pool.getConnection();

        String query = "SELECT * FROM Contact_Us";

        try {
            ps = connection.prepareStatement(query);
            System.out.println("Query : " + ps.toString());
            rs = ps.executeQuery();
            List<ContactUs> contactUsList = new ArrayList();

            while (rs.next()) {
                ContactUs contactus = new ContactUs();
                contactus.setContactUsId(rs.getInt("contactUsID"));
                contactus.setUserName(rs.getString("username"));
                contactus.setCategory(rs.getString("category"));
                contactus.setDescription(rs.getString("description"));
                contactUsList.add(contactus);
                System.out.println("Object : " + contactus.getDescription());
            }
            return contactUsList;
        } catch (Exception e) {
            System.out.println("SQL Exception : " + e.toString());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
