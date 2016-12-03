/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Prateek
 */
public class DBUtilTest {
    
    public DBUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of closeStatement method, of class DBUtil.
     */
    @Test
    public void testCloseStatement() throws SQLException {
        System.out.println("closeStatement");
        Statement s = ConnectionPool.getInstance().getConnection().createStatement();
        DBUtil.closeStatement(s);
        if(s.isClosed()){
            System.out.println("Statement closed");
        }
        assertTrue(s.isClosed());
    }

    /**
     * Test of closePreparedStatement method, of class DBUtil.
     */
    @Test
    public void testClosePreparedStatement() throws SQLException {
        System.out.println("closePreparedStatement");
        String sql= "Select * from User";
        Statement ps = ConnectionPool.getInstance().getConnection().prepareStatement(sql);
        System.out.println(ps.toString());
        ResultSet rs = ps.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.toString());
        }
        DBUtil.closePreparedStatement(ps);
        System.out.println(ps.toString());
        assertTrue(ps.isClosed());
    }

    /**
     * Test of closeResultSet method, of class DBUtil.
     */
    @Test
    public void testCloseResultSet() throws SQLException {
        System.out.println("closeResultSet");
        
        String sql= "Select * from User";
        Statement ps = ConnectionPool.getInstance().getConnection().prepareStatement(sql);
        System.out.println(ps.toString());
        ResultSet rs = ps.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs.toString());
        }
        DBUtil.closePreparedStatement(ps);
        rs.close();
        System.out.println(ps.toString());
        assertTrue(rs.isClosed());
        
    }
    
}
