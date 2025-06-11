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
    private final SimpleStringProperty animalstatus; 
    
    
    
    public AnimalData(Integer animalId, String animalRace, String animalSpecies, String animalSex, String animalName, String animalColor, String animalBirthdate, String photoAlbumId, String animalStatus){
        
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.animalrace = new SimpleStringProperty(animalRace);
        this.animalspecies = new SimpleStringProperty(animalSpecies);
        this.animalsex = new SimpleStringProperty(animalSex);
        this.animalname = new SimpleStringProperty(animalName);
        this.animalcolor = new SimpleStringProperty(animalColor);
        this.animalbirthdate = new SimpleStringProperty(animalBirthdate);
        this.photoalbumid = new SimpleStringProperty(photoAlbumId);
        this.animalstatus = new SimpleStringProperty(animalStatus);
    }    
    
    public AnimalData(String animalRace, String animalSpecies, String animalSex, String animalName, String animalColor, String animalBirthdate, String photoAlbumId, String animalStatus){
        
        this.animalid = new SimpleStringProperty("");
        this.animalrace = new SimpleStringProperty("");
        this.animalspecies = new SimpleStringProperty("");
        this.animalsex = new SimpleStringProperty("");
        this.animalname = new SimpleStringProperty("");
        this.animalcolor = new SimpleStringProperty("");
        this.animalbirthdate = new SimpleStringProperty("");
        this.photoalbumid = new SimpleStringProperty("");
        this.animalstatus = new SimpleStringProperty("");
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

    public String getAnimalstatus() {
        return animalstatus.get();
    }
    
    public void setAnimalid(String animalId){
        animalid.set(animalId);
    }
 
    public void setAnimalrace(String animalRace){
        animalrace.set(animalRace);
    }
    
    public void setAnimalspecies(String animalSpecies){
        animalspecies.set(animalSpecies);
    }
    
}
