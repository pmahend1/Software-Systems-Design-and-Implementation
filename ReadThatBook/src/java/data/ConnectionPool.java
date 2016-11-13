package data;

import java.sql.*;
import java.util.Properties;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    public ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/read_that_book");
        } catch (Exception e) {
            System.out.println("Inside ConnectionPool() : " + e + " " + e.toString());
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
//            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//            String URL = "jdbc:mysql://localhost:3306/read_that_book";
//            String USER = "root";
//            String PASS = "admin";
//
//            Connection conn = DriverManager.getConnection(URL, USER, PASS);
//            return conn;
            return dataSource.getConnection();
        } catch (Exception e) {
            System.out.println("Exc inside getConnection :" + e + " " + e.toString());
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
