/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author sanju
 */
public class Review {
    private int bookID;
    private String userName;
    private String review;
    private int userrating;
    private String userRole;

    public Review(int bookID, String userName, String review) {
        this.bookID = bookID;
        this.userName = userName;
        this.review = review;
    }

    public Review() {
        userName = "";
        review = "";
        userRole = "";
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getUserrating() {
        return userrating;
    }

    public void setUserrating(int userrating) {
        this.userrating = userrating;
    }
    
    @Override
    public String toString() {
        return "Review{" + "bookID=" + bookID + ", userName=" + userName + ", review=" + review + '}';
    }
    
    
}
