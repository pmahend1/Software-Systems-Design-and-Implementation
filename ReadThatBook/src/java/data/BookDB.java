package data;

import java.sql.*;

import business.Book;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BookDB {

    public static int addBookImage(int bookID, InputStream inputStream) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String imageSql = "INSERT INTO BookImage (Book_id , Image) values ( (select max(bookID) from book), ?)";
        try {
            ps = connection.prepareStatement(imageSql);
            ps.setBlob(1, inputStream);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static int addBook(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("data.BookDB.addBook()");
        String query
                = "INSERT INTO Book ( Title , Author, ISBN10, ISBN13, Genre ,Edition, Publisher ,Description ) "
                + "VALUES (?, ?, ? , ?, ?, ? ,? ,?)";
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getISBN_10());
            ps.setInt(4, book.getISBN_13());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getEdition());
            ps.setString(7, book.getPublisher());
            ps.setString(8, book.getDescription());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Book selectBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Book "
                + "WHERE BookName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            rs = ps.executeQuery();
            Book book = null;
            if (rs.next()) {
                book = new Book();
                ps.setInt(1, book.getBookID());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthor());
                ps.setInt(4, book.getISBN_10());
                ps.setInt(5, book.getISBN_13());
                ps.setString(6, book.getGenre());
                ps.setString(7, book.getEdition());
                ps.setString(8, book.getPublisher());
                ps.setString(9, book.getDescription());
            }
            return book;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int deleteBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("data.BookDB.deleteBook()");
        String query
                = "DELETE from Book where "
                + "bookID = ?";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, bookID);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static List<Book> selectAllBooks() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Book";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Book book = null;
            ArrayList bookList = new ArrayList();
            while (rs.next()) {
                book = new Book();
                book.setAuthor(rs.getString("Author"));
                book.setBookID(rs.getInt("BookID"));
                book.setEdition(rs.getString("Edition"));
                book.setPublisher(rs.getString("Publisher"));
                book.setDescription(rs.getString("Description"));
                book.setISBN_10(rs.getInt("ISBN10"));
                book.setISBN_13(rs.getInt("ISBN13"));
                book.setDescription(rs.getString("Description"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
