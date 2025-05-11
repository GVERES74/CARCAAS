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
public class AnimalData {
    
    private final SimpleStringProperty animalid; 
    private final SimpleStringProperty animalrace;
    private final SimpleStringProperty animalspecies;
    private final SimpleStringProperty animalsex;
    private final SimpleStringProperty animalname;
    private final SimpleStringProperty animalcolor;
    private final SimpleStringProperty animalbirthdate;
    private final SimpleStringProperty photoalbumid;
    private final SimpleStringProperty castredstatus;
    private final SimpleStringProperty healthstatus;
    private final SimpleStringProperty injurystatus;
    
    
    public AnimalData(String animalId, String animalRace, String animalSpecies, String animalSex, String animalName, String animalColor, String animalBirthdate, String photoAlbumId, String castredStatus, String healthStatus, String injuryStatus){
        
        this.animalid = new SimpleStringProperty(animalId);
        this.animalrace = new SimpleStringProperty(animalRace);
        this.animalspecies = new SimpleStringProperty(animalSpecies);
        this.animalsex = new SimpleStringProperty(animalSex);
        this.animalname = new SimpleStringProperty(animalName);
        this.animalcolor = new SimpleStringProperty(animalColor);
        this.animalbirthdate = new SimpleStringProperty(animalBirthdate);
        this.photoalbumid = new SimpleStringProperty(photoAlbumId);
        this.castredstatus = new SimpleStringProperty(castredStatus);
        this.healthstatus = new SimpleStringProperty(healthStatus);
        this.injurystatus = new SimpleStringProperty(injuryStatus);
    }    
    
    
    //Ha egy vagy több cella üresen jelenik meg, akkor ellenőrizni kell a getter-eket, vagy újra Insert Code -> Getter..
    public String getAnimalid() {
        return animalid.get();
    }

    public String getAnimalrace() {
        return animalrace.get();
    }

    public String getAnimalspecies() {
        return animalspecies.get();
    }

    public String getAnimalsex() {
        return animalsex.get();
    }

    public String getAnimalname() {
        return animalname.get();
    }

    public String getAnimalcolor() {
        return animalcolor.get();
    }

    public String getAnimalbirthdate() {
        return animalbirthdate.get();
    }

    public String getPhotoalbumid() {
        return photoalbumid.get();
    }

    public String getCastredstatus() {
        return castredstatus.get();
    }

    public String getHealthstatus() {
        return healthstatus.get();
    }

    public String getInjurystatus() {
        return injurystatus.get();
    }
        


    

    
}
