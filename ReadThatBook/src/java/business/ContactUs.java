/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author Prateek
 */
public class ContactUs implements Serializable {
    private int contactUsId;
    private String userName;
    private String category;
    private String description;

   
    public int getContactUsId() {
        return contactUsId;
    }

    public void setContactUsId(int contactUsId) {
        this.contactUsId = contactUsId;
    }

        
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
