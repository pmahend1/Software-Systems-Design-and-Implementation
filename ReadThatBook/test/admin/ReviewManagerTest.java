/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ReviewManagerTest {
    
    public ReviewManagerTest() {
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
     * Test of processRequest method, of class ReviewManager.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ReviewManager instance = new ReviewManager();
        instance.processRequest(request, response);
    }

    /**
     * Test of doGet method, of class ReviewManager.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ReviewManager instance = new ReviewManager();
        instance.doGet(request, response);
    }

    /**
     * Test of doPost method, of class ReviewManager.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ReviewManager instance = new ReviewManager();
        instance.doPost(request, response);
    }

    /**
     * Test of getServletInfo method, of class ReviewManager.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        ReviewManager instance = new ReviewManager();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
    }   
}
