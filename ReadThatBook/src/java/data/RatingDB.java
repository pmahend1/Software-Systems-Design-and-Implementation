/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Prateek
 */
public class RatingDB {

    public static int insertRating(Rating rating) {
        if (rating == null)
            return 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("Inside data.RatingDB.insertRating() starts");
        System.out.println(rating.getBookID());
        System.out.println(rating.getUserName());
        System.out.println(rating.getRating());
        System.out.println("Inside data.RatingDB.insertRating() ends");
        String query
                = "INSERT INTO RATING "
                + " VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, rating.getBookID());
            ps.setString(2, rating.getUserName());
            ps.setInt(3, rating.getRating());
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean checkRatingExists(Rating rating) {
        if (rating == null)
            return false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultCount = 0;
        boolean exist = false;
        System.out.println("Inside data.RatingDB.checkRatingExists() starts");
        System.out.println(rating.getBookID());
        System.out.println(rating.getUserName());
        System.out.println(rating.getRating());
        System.out.println("Inside data.RatingDB.checkRatingExists() ends");
        String query
                = "SELECT * FROM RATING  "
                + " WHERE BOOK_ID = ? "
                + " AND USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, rating.getBookID());
            ps.setString(2, rating.getUserName());

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("values exist");
                exist = true;
            }
           
            return exist;
        } catch (Exception e) {
            System.out.println(e);
            exist = false;
            return exist;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updateRating(Rating rating) {
        if (rating == null)
            return 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("Inside data.RatingDB.updateRating() starts");
        System.out.println(rating.getBookID());
        System.out.println(rating.getUserName());
        System.out.println(rating.getRating());
        System.out.println("Inside data.RatingDB.updateRating() ends");
        String query
                = "UPDATE RATING "
                + " SET RATING = ? "
                + " WHERE BOOK_ID = ?"
                + " AND USERNAME = ? ";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, rating.getRating());
            ps.setInt(2, rating.getBookID());
            ps.setString(3, rating.getUserName());

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static double[] getAverageRating(int bookID) {
        
        if (bookID < 0)
            return null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        double[] averageArray = new double[2];
        averageArray[0] = 0;
        averageArray[1] = 0;
        
        System.out.println("Inside getAverageRating");

        String query
                = "SELECT AVG(RATING) AS AVERAGE , COUNT(1) AS COUNT FROM RATING  "
                + " WHERE BOOK_ID = ? ";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, bookID);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("avg" +rs.getDouble(1));
                System.out.println("votes " +rs.getInt(2));
                
                averageArray[0] = rs.getDouble(1);
               
               averageArray[1] = rs.getDouble(2);
              
                System.out.println("values exist");
            }

            return averageArray;

        } catch (Exception e) {
            System.out.println(e);
            return averageArray;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int getUserRating(int bookID, String userName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userRating = 0;

        String query
                = "SELECT RATING FROM RATING  "
                + " WHERE BOOK_ID = ? "
                + " AND USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, bookID);
            ps.setString(2, userName);

            rs = ps.executeQuery();

            while (rs.next()) {
                userRating = rs.getInt(1);
            }

            return userRating;

        } catch (Exception e) {
            System.out.println(e);
            return userRating;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int deleteRating(Rating rating) {
        if (rating == null)
            return 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("Inside data.RatingDB.deleteRating() starts");
        System.out.println(rating.getBookID());
        System.out.println(rating.getUserName());
        System.out.println(rating.getRating());
        System.out.println("Inside data.RatingDB.deleteRating() ends");
        String query
                = "DELETE FROM RATING "
				+ " WHERE BOOK_ID = ? "
				+ " AND USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, rating.getBookID());
            ps.setString(2, rating.getUserName());

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
