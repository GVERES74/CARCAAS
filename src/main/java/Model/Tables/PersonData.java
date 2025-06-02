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
  
    
    private final SimpleStringProperty personid, animalid, addressid, personname, personphone, personemail;
    
    
    public PersonData(Integer personId, Integer animalId, Integer addressId, String personName, String personPhone, String personEmail){
        
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.addressid = new SimpleStringProperty(String.valueOf(addressId));
        this.personname = new SimpleStringProperty(personName);
        this.personphone = new SimpleStringProperty(personPhone);
        this.personemail = new SimpleStringProperty(personEmail);
        
    }

    public PersonData(String personName, String personPhone, String personEmail){
        
        this.personid = new SimpleStringProperty("");
        this.animalid = new SimpleStringProperty("");
        this.addressid = new SimpleStringProperty("");
        this.personname = new SimpleStringProperty(personName);
        this.personphone = new SimpleStringProperty(personPhone);
        this.personemail = new SimpleStringProperty(personEmail);
        
    }
    
    
    public String getPersonid() {
        return personid.get();
    }

    public String getAnimalid() {
        return animalid.get();
    }

    public String getAddressid() {
        return addressid.get();
    }
        
    public String getPersonname() {
        return personname.get();
    }

    public String getPersonphone() {
        return personphone.get();
    }

    public String getPersonemail() {
        return personemail.get();
    }
    
    public void setAnimalid(String animalId){
        animalid.set(animalId);
    }
    
    public void setAddressid(String addressId){
        addressid.set(addressId);
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
