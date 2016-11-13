/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Review;
import business.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sanju
 */
public class ReviewDB {
    public static int insertReview(Review review) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("Inside data.ReviewDB.insertReview() starts");
        System.out.println(review.getBookID());
        System.out.println(review.getUserName());
        System.out.println(review.getReview());
        System.out.println("Inside data.ReviewDB.insertReview() ends");
        String query
                = "INSERT INTO REVIEW "
                + " VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, review.getBookID());
            ps.setString(2, review.getUserName());
            ps.setString(3, review.getReview());
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean checkReviewExists(int bookID, String userName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultCount = 0;
        boolean exist = false;
        System.out.println("Inside data.ReviewDB.checkReviewExists() starts");
        System.out.println(bookID);
        System.out.println(userName);
        System.out.println("Inside data.ReviewDB.checkReviewExists() ends");
        String query
                = "SELECT * FROM REVIEW  "
                + " WHERE BOOK_ID = ? "
                + " AND USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            ps.setString(2, userName);

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

    public static int updateReview(Review review) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("Inside data.ReviewDB.updateReview() starts");
        System.out.println(review.getBookID());
        System.out.println(review.getUserName());
        System.out.println(review.getReview());
        System.out.println("Inside data.ReviewDB.updateReview() ends");
        String query
                = "UPDATE REVIEW "
                + " SET REVIEW = ? "
                + " WHERE BOOK_ID = ?"
                + " AND USERNAME = ? ";
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, review.getReview());
            ps.setInt(2, review.getBookID());
            ps.setString(3, review.getUserName());

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Review> getUsersReview(int bookID, String userName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userReview = 0;

        String query
                = "SELECT * FROM REVIEW  "
                + " WHERE BOOK_ID = ? "
                + " AND USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            ps.setString(2, userName);
            rs = ps.executeQuery();
            Review review = null;
            ArrayList reviewList = new ArrayList();
            while (rs.next()) {
                review = new Review();
                review.setBookID(rs.getInt("BOOK_ID"));
                review.setUserName(rs.getString("UserName"));
                review.setReview(rs.getString("REVIEW"));
                reviewList.add(review);
            }
            return reviewList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Review> getReviewsFromBookID(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userReview = 0;

        String query
                = "SELECT * FROM REVIEW  "
                + " WHERE BOOK_ID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            
            rs = ps.executeQuery();
            Review review = null;
            ArrayList reviewList = new ArrayList();
            while (rs.next()) {
                review = new Review();
                review.setBookID(rs.getInt("BOOK_ID"));
                review.setUserName(rs.getString("UserName"));
                review.setReview(rs.getString("REVIEW"));
                reviewList.add(review);
            }
            return reviewList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int deleteReview(Review review) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("Inside data.ReviewDB.deleteReview() starts");
        System.out.println(review.getBookID());
        System.out.println(review.getUserName());
        System.out.println(review.getReview());
        System.out.println("Inside data.ReviewDB.deleteReview() ends");
        String query
                = "DELETE FROM REVIEW "
				+ " WHERE BOOK_ID = ? "
				+ " AND USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, review.getBookID());
            ps.setString(2, review.getUserName());

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
