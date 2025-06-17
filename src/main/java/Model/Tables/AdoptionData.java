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
public class AdoptionData {
   
    private SimpleStringProperty adoptionid;
    private SimpleStringProperty animalid;
    private SimpleStringProperty personaddressid;
    private SimpleStringProperty adoptiondate;
    private SimpleStringProperty shelterid;
    private SimpleStringProperty adoptionlognumber;
    
    public AdoptionData(Integer adoptionId, Integer animalId, Integer personAddressId, LocalDate adoptionDate, Integer shelterId, Integer adoptionLogNumber){
        
        this.adoptionid = new SimpleStringProperty(String.valueOf(adoptionId));
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        this.adoptiondate = new SimpleStringProperty(String.valueOf(adoptionDate));
        this.shelterid = new SimpleStringProperty(String.valueOf(shelterId));
        this.adoptionlognumber = new SimpleStringProperty(String.valueOf(adoptionLogNumber));
        
    }

       
   //insert code getters

    public String getAdoptionid() {
        return adoptionid.get();
    }

    public String getAnimalid() {
        return animalid.get();
    }

    public String getPersonaddressid() {
        return personaddressid.get();
    }

    public String getAdoptiondate() {
        return adoptiondate.get();
    }

    public String getShelterid() {
        return shelterid.get();
    }

    public String getAdoptionlognumber() {
        return adoptionlognumber.get();
    }
    
}
