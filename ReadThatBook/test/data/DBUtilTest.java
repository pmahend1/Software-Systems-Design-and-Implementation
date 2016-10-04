/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
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
    public void testCloseStatement() {
        System.out.println("closeStatement");
        Statement s = null;
        DBUtil.closeStatement(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closePreparedStatement method, of class DBUtil.
     */
    @Test
    public void testClosePreparedStatement() {
        System.out.println("closePreparedStatement");
        Statement ps = null;
        DBUtil.closePreparedStatement(ps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeResultSet method, of class DBUtil.
     */
    @Test
    public void testCloseResultSet() {
        System.out.println("closeResultSet");
        ResultSet rs = null;
        DBUtil.closeResultSet(rs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
