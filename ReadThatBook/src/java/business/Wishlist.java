/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Sweet_Home
 */

public class Wishlist {
    private  int bookID;
    private String username;
    
    public Wishlist() {
        username = "";
    }
    public Wishlist(String username,int bookID ) {

        this.username = username;
        this.bookID = bookID;
    }
    
    public String getUsername() {
        return username;
    }

    public int getBookID() {
        return bookID;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
