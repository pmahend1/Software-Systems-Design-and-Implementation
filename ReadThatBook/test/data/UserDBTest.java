/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akshay
 */
public class UserDBTest {
    
    public UserDBTest() {
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
     * Test of insert method, of class UserDB.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        User user = null;
        int expResult = 0;
        int result = UserDB.insert(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class UserDB.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User user = null;
        int expResult = 0;
        int result = UserDB.update(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class UserDB.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String username = "";
        int expResult = 0;
        int result = UserDB.delete(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectUser method, of class UserDB.
     */
    @Test
    public void testSelectUser() {
        System.out.println("selectUser");
        String userName = "";
        User expResult = null;
        User result = UserDB.selectUser(userName);
        assertEquals(expResult, result);
    }
    
}
