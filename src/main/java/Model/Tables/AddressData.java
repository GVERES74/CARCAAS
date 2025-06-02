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
public class AddressData {
    
    private final SimpleStringProperty addressid, personid, addresscountry, addresscounty, addresszipcode, addresscity, addressstreet, addressnumber;
    
    
    public AddressData(Integer addressId, Integer personId, String addressCountry, String addressCounty, String addressZipcode, String addressCity, String addressStreet, String addressNumber){
        
        this.addressid = new SimpleStringProperty(String.valueOf(addressId));
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.addresscountry = new SimpleStringProperty(addressCountry);
        this.addresscounty = new SimpleStringProperty(addressCounty);
        this.addresszipcode = new SimpleStringProperty(addressZipcode);
        this.addresscity = new SimpleStringProperty(addressCity);
        this.addressstreet = new SimpleStringProperty(addressStreet);
        this.addressnumber = new SimpleStringProperty(addressNumber);
    }
    
    
    
    public AddressData(String addressCountry, String addressCounty, String addressZipcode, String addressCity, String addressStreet, String addressNumber){
        
        this.addressid = new SimpleStringProperty("");
        this.personid = new SimpleStringProperty("");
        this.addresscountry = new SimpleStringProperty(addressCountry);
        this.addresscounty = new SimpleStringProperty(addressCounty);
        this.addresszipcode = new SimpleStringProperty(addressZipcode);
        this.addresscity = new SimpleStringProperty(addressCity);
        this.addressstreet = new SimpleStringProperty(addressStreet);
        this.addressnumber = new SimpleStringProperty(addressNumber);
    }

    public String getAddressid() {
        return addressid.get();
    }

    public String getPersonid() {
        return personid.get();
    }
      
    public String getAddresscountry() {
        return addresscountry.get();
    }

    public String getAddresscounty() {
        return addresscounty.get();
    }

    public String getAddresszipcode() {
        return addresszipcode.get();
    }

    public String getAddresscity() {
        return addresscity.get();
    }

    public String getAddressstreet() {
        return addressstreet.get();
    }

    public String getAddressnumber() {
        return addressnumber.get();
    }

    public void setPersonid(String personId){
        personid.set(personId);
    }
    
    public void setAddresscountry(String addressCountry){
        addresscountry.set(addressCountry);
    }
    
    public void setAddresscounty(String addressCounty){
        addresscounty.set(addressCounty);
    }
    
    public void setAddresszipcode(String addressZipcode){
        addresszipcode.set(addressZipcode);
    }
    
    public void setAddresscity(String addressCity){
        addresscity.set(addressCity);
    }
    
    public void setAddressstreet(String addressStreet){
        addressstreet.set(addressStreet);
    }
    
    public void setAddressnumber(String addressNumber){
        addressnumber.set(addressNumber);
    }
}
