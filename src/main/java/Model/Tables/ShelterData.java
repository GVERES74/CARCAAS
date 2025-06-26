/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Tables;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DjRed
 */
public class ShelterData {
   
    private SimpleStringProperty shelterid;
    private SimpleStringProperty sheltername;
    private SimpleStringProperty sheltertaxnumber;
    private SimpleStringProperty shelterbankaccountnumber;
    private SimpleStringProperty animalid;
    private SimpleStringProperty personaddressid;
        
        
    public ShelterData(Integer shelterId, String shelterName, String shelterTaxnumber, String shelterBankaccountnumber, Integer animalId, Integer personAddressId){
        
        this.shelterid = new SimpleStringProperty(String.valueOf(shelterId));
        this.sheltername = new SimpleStringProperty(shelterName);        
        this.sheltername = new SimpleStringProperty(shelterTaxnumber);        
        this.sheltername = new SimpleStringProperty(shelterBankaccountnumber);        
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        
    }

   
    public String getShelterid() {
        return shelterid.get();
    }

    public String getSheltername() {
        return sheltername.get();
    }


//insert code getters for taxnumber and bankaccountnumber


   
    public String getAnimalid() {
        return animalid.get();
    }

    public String getPersonaddressid() {
        return personaddressid.get();
    }
    
}
