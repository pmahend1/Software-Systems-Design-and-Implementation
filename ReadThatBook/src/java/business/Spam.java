/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Raka Choudhury
 */
public class Spam {
    private  int bookID;
    private String username;
    private String reporter;
    private String reason;
    
    public Spam(String username,int bookID,String reporter) {

        this.username = username;
        this.bookID = bookID;
        this.reporter=reporter;
    }
    
    public String getUsername() {
        return username;
    }

    public int getBookID() {
        return bookID;
    }
    
    public String getReporter() {
        return reporter;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }
   
    public void setReason(String reason) {
        this.reason = reason;
    }
}
