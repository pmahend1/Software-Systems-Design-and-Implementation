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
 * @author ashwini
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
        User user = new User("new", "new", "newLastName", "new@new.com", "new", "user");
        int result = UserDB.insert(user);
        User userFromDB= UserDB.selectUser("new");
        
        assertEquals("new", userFromDB.getUserName());
    }

    /**
     * Test of update method, of class UserDB.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User user = UserDB.selectUser("new");
        String expected = "newFirstName";
        user.setFirstName(expected);
        int result = UserDB.update(user);
        User userFromDB = UserDB.selectUser("new");
        String firstName = userFromDB.getFirstName();
        assertEquals(expected, firstName);
    }
    
    /**
     * Test of selectUser method, of class UserDB.
     */
    @Test
    public void testSelectUser() {
        System.out.println("selectUser");
        String userName = "new";
        User userFromDB = UserDB.selectUser(userName);
        String lastName = userFromDB.getLastName();
        assertEquals("newLastName", lastName);
    }

    

    

    /**
     * Test of updateUserRole method, of class UserDB.
     */
    @Test
    public void testUpdateUserRole() {
        System.out.println("updateUserRole");
        String userName = "new";
        String role = "admin";
        String expResult = "admin";
        int result = UserDB.updateUserRole(userName, role);
        String dbResult = UserDB.selectUser(userName).getRole();
        assertEquals(expResult, dbResult);

    }

    /**
     * Test of getUserRole method, of class UserDB.
     */
    @Test
    public void testGetUserRole() {
        System.out.println("getUserRole");
        String userName = "new";
        String expResult = "admin";
        String result = UserDB.getUserRole(userName);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of delete method, of class UserDB.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String username = "new";
        int result = UserDB.delete(username);
        User userFromDB = UserDB.selectUser(username);
        assertEquals(userFromDB, null);
    }
    
}
