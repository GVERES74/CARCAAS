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
    private SimpleStringProperty animalid;
    private SimpleStringProperty personaddressid;
        
        
    public ShelterData(Integer shelterId, String shelterName, Integer animalId, Integer personAddressId){
        
        this.shelterid = new SimpleStringProperty(String.valueOf(shelterId));
        this.sheltername = new SimpleStringProperty(shelterName);        
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        
    }

       
   //insert code getters

    public String getShelterid() {
        return shelterid.get();
    }

    public String getSheltername() {
        return sheltername.get();
    }

    public String getAnimalid() {
        return animalid.get();
    }

    public String getPersonaddressid() {
        return personaddressid.get();
    }
    
}
