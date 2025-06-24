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
public class PersonData {
  
    
    private final SimpleStringProperty personid;
    private final SimpleStringProperty personfirstname;
    private final SimpleStringProperty personlastname; 
    private final SimpleStringProperty personphone; 
    private final SimpleStringProperty personemail;
    
    
    public PersonData(Integer personId, String personFirstName, String personLastName, String personPhone, String personEmail){
        
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.personfirstname = new SimpleStringProperty(personFirstName);
        this.personlastname = new SimpleStringProperty(personLastName);
        this.personphone = new SimpleStringProperty(personPhone);
        this.personemail = new SimpleStringProperty(personEmail);
        
    }

    public PersonData(String personFirstName, String personLastName, String personPhone, String personEmail){
        
        this.personid = new SimpleStringProperty("");
        this.personfirstname = new SimpleStringProperty(personFirstName);
        this.personlastname = new SimpleStringProperty(personLastName);
        this.personphone = new SimpleStringProperty(personPhone);
        this.personemail = new SimpleStringProperty(personEmail);
        
    }

    
    //insert code getters

    public String getPersonid() {
        return personid.get();
    }

    public String getPersonfirstname() {
        return personfirstname.get();
    }

    public String getPersonlastname() {
        return personlastname.get();
    }

    public String getPersonphone() {
        return personphone.get();
    }

    public String getPersonemail() {
        return personemail.get();
    }

    
       
}
