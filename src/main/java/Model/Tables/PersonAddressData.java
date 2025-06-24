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
public class PersonAddressData {
    
    private final SimpleStringProperty personaddressid;
    private final SimpleStringProperty personid; 
    private final SimpleStringProperty addressid;
        
    
    public PersonAddressData(Integer personAddressId, Integer personId, Integer addressId){
        
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.addressid = new SimpleStringProperty(String.valueOf(addressId));
                   
    }
    
    public PersonAddressData(Integer personId, Integer addressId){
        
        this.personaddressid = new SimpleStringProperty(String.valueOf(""));
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.addressid = new SimpleStringProperty(String.valueOf(addressId));
                   
    }
     

   //insert code getters

    public String getPersonaddressid() {
        return personaddressid.get();
    }

    public String getPersonid() {
        return personid.get();
    }

    public String getAddressid() {
        return addressid.get();
    }

}
