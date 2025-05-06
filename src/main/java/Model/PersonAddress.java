/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DjRed
 */
public class PersonAddress {
    
     private final SimpleStringProperty assignid, personid, addressid;
    private SimpleStringProperty relationtype;
    
    
    public PersonAddress(String personId, String addressId, String relationType){
        
        this.assignid = new SimpleStringProperty("");
        this.personid = new SimpleStringProperty(personId);
        this.addressid = new SimpleStringProperty(addressId);
        this.relationtype = new SimpleStringProperty(relationType);
                
    }

    public SimpleStringProperty getAssignid() {
        return assignid;
    }

    public SimpleStringProperty getPersonid() {
        return personid;
    }

    public SimpleStringProperty getAddressid() {
        return addressid;
    }

    public SimpleStringProperty getRelationtype() {
        return relationtype;
    }
    
    public void setPersonid(String personId) {
        personid.set(personId);
    }
    
    public void setAddressid(String addressId) {
        addressid.set(addressId);
    }

    public void setRelationtype(String relationType) {
        relationtype.set(relationType);
    }
    
    

}
