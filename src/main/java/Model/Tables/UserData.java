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
  
    
    private final SimpleStringProperty userid, usercatid, username, userphone, useremail, usercompanyid, userpassword;
    
    
    public UserData(Integer userId, String userCatId, String userName, String userPhone, String userEmail, String userCompanyId, String userPassword){
        
        this.userid = new SimpleStringProperty(String.valueOf(userId));
        this.usercatid = new SimpleStringProperty(userCatId);
        this.username = new SimpleStringProperty(userName);
        this.userphone = new SimpleStringProperty(userPhone);
        this.useremail = new SimpleStringProperty(userEmail);
        this.usercompanyid = new SimpleStringProperty(userCompanyId);
        this.userpassword = new SimpleStringProperty(userPassword);
        
    }

    
     public UserData(String userCatId, String userName, String userPhone, String userEmail, String userCompanyId, String userPassword){
        
        this.userid = new SimpleStringProperty("");
        this.usercatid = new SimpleStringProperty(userCatId);
        this.username = new SimpleStringProperty(userName);
        this.userphone = new SimpleStringProperty(userPhone);
        this.useremail = new SimpleStringProperty(userEmail);
        this.usercompanyid = new SimpleStringProperty(userCompanyId);
        this.userpassword = new SimpleStringProperty(userPassword);
    
    }
    
    public String getUserid() {
        return userid.get();
    }

    public String getUsercatid() {
        return usercatid.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getUserphone() {
        return userphone.get();
    }

    public String getUseremail() {
        return useremail.get();
    }

    public String getUsercompanyid() {
        return usercompanyid.get();
    }

    public String getUserpassword() {
        return userpassword.get();
    }

    
}
