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
public class AddressData {
    
    private final SimpleStringProperty addressid, addresscountry, addresscounty, addresszipcode, addresscity, addressstreet, addressnumber;
    
    
    public AddressData(String addressCountry, String addressCounty, String addressZipcode, String addressCity, String addressStreet, String addressNumber){
        
        this.addressid = new SimpleStringProperty("");
        this.addresscountry = new SimpleStringProperty(addressCountry);
        this.addresscounty = new SimpleStringProperty(addressCounty);
        this.addresszipcode = new SimpleStringProperty(addressZipcode);
        this.addresscity = new SimpleStringProperty(addressCity);
        this.addressstreet = new SimpleStringProperty(addressStreet);
        this.addressnumber = new SimpleStringProperty(addressNumber);
    }

    public SimpleStringProperty getAddressid() {
        return addressid;
    }

    public SimpleStringProperty getAddresscountry() {
        return addresscountry;
    }

    public SimpleStringProperty getAddresscounty() {
        return addresscounty;
    }

    public SimpleStringProperty getAddresszipcode() {
        return addresszipcode;
    }

    public SimpleStringProperty getAddresscity() {
        return addresscity;
    }

    public SimpleStringProperty getAddressstreet() {
        return addressstreet;
    }

    public SimpleStringProperty getAddressnumber() {
        return addressnumber;
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
