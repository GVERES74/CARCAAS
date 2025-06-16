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
    
    private final SimpleStringProperty personaddressid, personid, addressid;
        
    
    public PersonAddressData(Integer personAddressId, Integer personId, Integer addressId){
        
        this.personaddressid = new SimpleStringProperty("");
        this.personid = new SimpleStringProperty(personId);
        this.addressid = new SimpleStringProperty(addressId);
   
                
    }

   //insert code getters

}
