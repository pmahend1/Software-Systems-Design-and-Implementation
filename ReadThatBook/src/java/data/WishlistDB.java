/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import business.Book;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import static java.lang.System.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sweet_Home
 */
public class WishlistDB {
    public static int addBook(String username,int bookid) {
        String status="This book has been already added to your wishlist.";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                = "INSERT INTO wishlist (UserName, BookID) "
                + "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(2, bookid);
            ps.setString(1,username);
          
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static List<Book> viewWishlist(String username) throws Exception {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM book b inner join wishlist w on b.BookID=w.BookID where UserName=?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,username);
            rs = ps.executeQuery();
            Book book = null;
            ArrayList bookList = new ArrayList();
            while (rs.next()) {
                book = new Book();
                book.setBookID(rs.getInt("BookID"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("Author"));
                book.setISBN10(rs.getString("ISBN10"));
                book.setISBN13(rs.getString("ISBN13"));
                book.setGenre(rs.getString("Genre"));
                book.setEdition(rs.getString("Edition"));
                book.setPublisher(rs.getString("Publisher"));
                book.setDescription(rs.getString("Description"));
                bookList.add(book);
            }
            return bookList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int deleteWishlist(String username,int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query
                    = "DELETE from wishlist where "
                + "BookID=? and UserName=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            ps.setString(2, username);
            System.out.println(ps.toString());
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
