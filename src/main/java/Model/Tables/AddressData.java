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
    
    private final SimpleStringProperty addressid, addresscountry, addresscounty, addresszipcode, addresscity, addressstreet, addressnumber;
    
    
    public AddressData(Integer addressId, String addressCountry, String addressCounty, String addressZipcode, String addressCity, String addressStreet, String addressNumber){
        
        this.addressid = new SimpleStringProperty(String.valueOf(addressId));
        this.addresscountry = new SimpleStringProperty(addressCountry);
        this.addresscounty = new SimpleStringProperty(addressCounty);
        this.addresszipcode = new SimpleStringProperty(addressZipcode);
        this.addresscity = new SimpleStringProperty(addressCity);
        this.addressstreet = new SimpleStringProperty(addressStreet);
        this.addressnumber = new SimpleStringProperty(addressNumber);
    }
    
    
    
    public AddressData(String addressCountry, String addressCounty, String addressZipcode, String addressCity, String addressStreet, String addressNumber){
        
        this.addressid = new SimpleStringProperty("");
        this.addresscountry = new SimpleStringProperty(addressCountry);
        this.addresscounty = new SimpleStringProperty(addressCounty);
        this.addresszipcode = new SimpleStringProperty(addressZipcode);
        this.addresscity = new SimpleStringProperty(addressCity);
        this.addressstreet = new SimpleStringProperty(addressStreet);
        this.addressnumber = new SimpleStringProperty(addressNumber);
    }

    //insert code getters
}
