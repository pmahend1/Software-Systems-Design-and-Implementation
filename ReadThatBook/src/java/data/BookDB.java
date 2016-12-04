package data;

import java.sql.*;

import business.Book;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookDB {

    public static int addBookImage(int bookID, InputStream inputStream) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String imageSql = "INSERT INTO BookImage (Book_id , Image) values (?, ?)";
        try {
            ps = connection.prepareStatement(imageSql);
            ps.setInt(1, bookID);
            ps.setBlob(2, inputStream);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static int updateBookImage(int bookID, InputStream inputStream) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String imageSql = "UPDATE Bookimage set "
                + "image = ? "
                + "where book_ID=?";
        try {
            ps = connection.prepareStatement(imageSql);
            ps.setBlob(1, inputStream);
            ps.setInt(2, bookID);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    public static boolean checkBookImageExists(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int resultCount = 0;
        boolean exist = false;

        String query
                = "SELECT * FROM BOOKIMAGE  "
                + " WHERE BOOK_ID = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);

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
            ps.setString(3, book.getISBN10());
            ps.setString(4, book.getISBN13());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getEdition());
            ps.setString(7, book.getPublisher());
            ps.setString(8, book.getDescription());
            System.out.println("Add book query is : " + ps.toString());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updateBook(Book book) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println("data.BookDB.updateBook()");
        String query
                = "UPDATE Book set "
                + " Title = ? ,"
                + " Author =  ? ,"
                + " ISBN10 = ? ,"
                + " ISBN13 = ? ,"
                + " Genre = ?,"
                + " Edition = ?,"
                + " Publisher = ?,"
                + " Description =? "
                + " WHERE bookID = ?";
        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getISBN10());
            ps.setString(4, book.getISBN13());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getEdition());
            ps.setString(7, book.getPublisher());
            ps.setString(8, book.getDescription());
            ps.setInt(9, book.getBookID());
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

    public static Book selectBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Book "
                + "WHERE BookID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            rs = ps.executeQuery();
            Book book = null;
            if (rs.next()) {
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

            }
            return book;
        } catch (Exception e) {
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
        } catch (Exception e) {
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
            System.out.println("Select all books query : " + ps.toString());
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

    public static byte[] getBookImage(int bookID) {
        //int img_id = bookID;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        OutputStream oImage;
        try {
            ps = connection.prepareStatement("select * from BookImage where book_ID = ?");
            ps.setInt(1, bookID);

            rs = ps.executeQuery();

            if (rs.next()) {
                byte barray[] = rs.getBytes("image");
                //Blob blob=rs.getBlob("image");
                //response.setContentType("image/gif");
                //oImage = response.getOutputStream();
                //oImage.write(barray);
                //oImage.flush();
                //oImage.close();
                return barray;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static List<Book> searchBook(String bookTitle) {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT * FROM book"+
                    " where upper(title) like ? || upper(Author) like ?" +
                    "|| upper(Genre) like ? || upper(ISBN10) like ?";
            System.out.println("data.BookDB.searchBook()"+ " query :" +query);
            System.out.println("bookTitle " + bookTitle);
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, "%"+bookTitle.toUpperCase()+"%");
                ps.setString(2, "%"+bookTitle.toUpperCase()+"%");
                ps.setString(3, "%"+bookTitle.toUpperCase()+"%");
                ps.setString(4, "%"+bookTitle.toUpperCase()+"%");
                
                rs = ps.executeQuery();
                ArrayList bookList = new ArrayList();
                Book book = null;
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
            }catch (SQLException e) {
                System.out.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                pool.freeConnection(connection);
            }
        }
    
    public static List<Book> searchSimilarBooks(String bookGenre, String bookAuthor, int bookId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM book"+
                " where (upper(Genre) like ? OR upper(Author) like ? ) AND BookID != ? " +
                "ORDER BY RAND() LIMIT 7";
        
        System.out.println("data.BookDB.searchSimilarBooks()"+ " query :" +query);
        System.out.println("bookGenre " + bookGenre);
        System.out.println("bookAuthor " + bookAuthor);
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%"+bookGenre.toUpperCase()+"%");
            ps.setString(2, "%"+bookAuthor.toUpperCase()+"%");
            ps.setInt(3, bookId);

            rs = ps.executeQuery();
            ArrayList bookList = new ArrayList();
            Book book = null;
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
        }catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Book> advSearchBook(String bookTitle,String bookAuthor,
                                            String bookGenre, String bookISBN) {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
          
            String query = "SELECT * FROM book" +
                    " where upper(title) like ? AND upper(Author) like ? AND " +
                    " upper(Genre) like ? AND upper(ISBN10) like ?";
            
            System.out.println("data.BookDB.searchBook()"+ " query :" +query);
            System.out.println(bookTitle+bookAuthor+bookGenre +bookISBN );
            try {
                ps = connection.prepareStatement(query);
                ps.setString(1, "%"+bookTitle.toUpperCase()+"%");
                ps.setString(2, "%"+bookAuthor.toUpperCase()+"%");
                ps.setString(3, "%"+bookGenre.toUpperCase()+"%");
                ps.setString(4, "%"+bookISBN.toUpperCase()+"%");
                rs = ps.executeQuery();
                
                ArrayList bookList = new ArrayList();
                while (rs.next()) {
                    Book book = new Book();
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
            }catch (Exception e) {
                System.out.println(e);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(ps);
                pool.freeConnection(connection);
            }
        }
    
    public static String getGenreofBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("getGenreofBook");
        String query = "SELECT Genre FROM BOOK "
                        + " where bookID = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            
            System.out.println("Check book id SQL is : " + ps.toString());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("data.BookDB.getGenreofBook()" + "search Genre of Book method");
                return rs.getString("Genre");
            }
            else{
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static String getAuthorOfBook(int bookID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("getAuthorOfBook");
        String query = "SELECT Author FROM BOOK "
                        + " where bookID = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookID);
            
            System.out.println("Check book id SQL is : " + ps.toString());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("data.BookDB.getAuthorOfBook()" + "search Author of Book method");
                return rs.getString("Author");
            }
            else{
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int getBookIDByISBN(String ISBN) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int length = ISBN.length();
        System.out.println("getBookIDByISBN");
        String query = "SELECT bookID FROM BOOK "
                        + " where (ISBN13 = ? " 
                        + " OR ISBN10 = ? )";
        
		try {
            ps = connection.prepareStatement(query);
            ps.setString(1, ISBN.toUpperCase());
            ps.setString(2, ISBN.toUpperCase());
            
                    System.out.println("Check book id SQL is : " + ps.toString());
            rs = ps.executeQuery();
            
 
            if (rs.next()) {
                System.out.println("data.BookDB.getBookIDByISBN()" + "search Book method");
                return rs.getInt("bookID");
            }
            else{
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
