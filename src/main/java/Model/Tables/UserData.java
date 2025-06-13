/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Tables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DjRed
 */
public class UserData {
  
    
    private final SimpleStringProperty userid, username, userpassword personid;
    
    
    public UserData(Integer userId, String userName, String userPassword, Integer personId){
        
        this.userid = new SimpleStringProperty(String.valueOf(userId));
        this.username = new SimpleStringProperty(userName);
        this.userpassword = new SimpleStringProperty(userPassword);
        this.personid = new SimpleStringProperty(personId);
        
    }

    
         
    public String getUserid() {
        return userid.get();
    }

    public String getUsername() {
        return username.get();
    }
    
    public String getUserpassword() {
        return userpassword.get();
    }

    public String getPersonid() {
        return personid.get();
    }
  
}
