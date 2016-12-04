/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sanju
 */
public class ConnectionPoolTest {
    
    public ConnectionPoolTest() {
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
     * Test of getConnection method, of class ConnectionPool.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        ConnectionPool instance = ConnectionPool.getInstance();
        Connection expResult = instance.getConnection();
        System.out.println(expResult.toString());
        assertNotEquals(expResult,null);
        // TODO review the generated test code and remove the default call to fail.
    }   

    /**
     * Test of getInstance method, of class ConnectionPool.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ConnectionPool pool = ConnectionPool.getInstance();
        System.out.println(pool.toString());
        assertNotEquals(pool, null);
    }

    /**
     * Test of freeConnection method, of class ConnectionPool.
     */
    @Test
    public void testFreeConnection() throws SQLException {
        System.out.println("freeConnection");
        Connection c = null;
        ConnectionPool instance = new ConnectionPool();
        c = instance.getConnection();
        instance.freeConnection(c);
        assertTrue(c.isClosed());
    }
}
