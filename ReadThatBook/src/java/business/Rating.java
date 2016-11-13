/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Prateek
 */
public class Rating {
    
    private  int bookID;
    private String userName;
    private int rating;

    public Rating(int bookID, String userName, int rating) {
        this.bookID = bookID;
        this.userName = userName;
        this.rating = rating;
    }

    public Rating() {
        userName="";
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

   
    
    

    
}
