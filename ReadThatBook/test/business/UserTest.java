/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sweet_Home
 */
public class UserTest {
    private User user;
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user=new User();
        user.setUserName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test");
        user.setRole("test");
        user.setPassWord("test");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPassWord method, of class User.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "test";
        User instance = new User();
        instance.setPassWord(passWord);
        assertEquals(passWord, instance.getPassWord());
    }

    /**
     * Test of getPassWord method, of class User.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        String expResult = "test";
        String result = user.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRole method, of class User.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        String expResult = "test";
        String result = user.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        String expResult = "test";
        String result = user.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class User.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "test";
        User instance = new User();
        instance.setRole(role);
        assertEquals(role, instance.getRole());
    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "test";
        User instance = new User();
        instance.setUserName(userName);
        assertEquals(userName, instance.getUserName());
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "test";
        String result = user.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "test";
        User instance = new User();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "test";
        String result = user.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "test";
        User instance = new User();
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "test";
        String result = user.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "test";
        User instance = new User();
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "User{userName=test, firstName=test, lastName=test, email=test, passWord=test, role=test}";
        String result = user.toString();
        assertEquals(expResult, result);
    }  
}
