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
  
    
    private final SimpleStringProperty personid, personfirstname, personlastname,personphone, personemail;
    
    
    public PersonData(Integer personId, String personFirstName, String personLastName, String personPhone, String personEmail){
        
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.personname = new SimpleStringProperty(personName);
        this.personphone = new SimpleStringProperty(personPhone);
        this.personemail = new SimpleStringProperty(personEmail);
        
    }

        
    //insert code getters
       
}
