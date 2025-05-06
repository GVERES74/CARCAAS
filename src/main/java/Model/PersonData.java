/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DjRed
 */
public class PersonData {
  
    
    private final SimpleStringProperty personid, personname, personphone, personemail;
    
    
    public PersonData(String personName, String personPhone, String personEmail){
        
        this.personid = new SimpleStringProperty("");
        this.personname = new SimpleStringProperty(personName);
        this.personphone = new SimpleStringProperty(personPhone);
        this.personemail = new SimpleStringProperty(personEmail);
        
    }

    public SimpleStringProperty getPersonid() {
        return personid;
    }

    public SimpleStringProperty getPersonname() {
        return personname;
    }

    public SimpleStringProperty getPersonphone() {
        return personphone;
    }

    public SimpleStringProperty getPersonemail() {
        return personemail;
    }
    
    public void setPersonname(String personName){
        personname.set(personName);
    }
    
    public void setPersonphone(String personPhone){
        personphone.set(personPhone);
    }
    
    public void setPersonemail(String personEmail){
        personemail.set(personEmail);
    }
}
