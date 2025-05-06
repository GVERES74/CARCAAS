/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DjRed
 */
public class RescuedAnimalData {
    
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
    
    
    public RescuedAnimalData(String animalId, String animalRace, String animalSpecies, String animalSex, String animalName, String animalColor, String animalBirthdate, String photoAlbumId, String castredStatus, String healthStatus, String injuryStatus){
        
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

    public SimpleStringProperty getAnimalID() {
        return animalid;
    }

    public SimpleStringProperty getAnimalRace() {
        return animalrace;
    }

    public SimpleStringProperty getAnimalSpecies() {
        return animalspecies;
    }

    public SimpleStringProperty getAnimalSex() {
        return animalsex;
    }

    public SimpleStringProperty getAnimalName() {
        return animalname;
    }

    public SimpleStringProperty getAnimalColor() {
        return animalcolor;
    }

    public SimpleStringProperty getAnimalbirthdate() {
        return animalbirthdate;
    }

    public SimpleStringProperty getCastredstatus() {
        return castredstatus;
    }

    public SimpleStringProperty getHealthstatus() {
        return healthstatus;
    }

    public SimpleStringProperty getInjurystatus() {
        return injurystatus;
    }

        
    
    public void setAnimalRace(String animalRace){
        animalrace.set(animalRace);
    }
    
    public void setAnimalSpecies(String animalSpecies){
        animalspecies.set(animalSpecies);
    }
    
    public void setAnimalSex(String animalSex){
        animalsex.set(animalSex);
    }
    
    public void setAnimalName(String animalName){
        animalname.set(animalName);
    }
    
    public void setAnimalColor(String animalColor){
        animalcolor.set(animalColor);
    }
    
    public void setAnimalbirthdate(String animalBirthdate){
        animalbirthdate.set(animalBirthdate);
    }

    public void setPhotoalbumid(String photoAlbumId) {
        photoalbumid.set(photoAlbumId);
    }

    public void setCastredstatus(String castredStatus) {
        castredstatus.set(castredStatus);
    }

    public void setHealthstatus(String healthStatus) {
        healthstatus.set(healthStatus);
    }

    public void setInjurystatus(String injuryStatus) {
        injurystatus.set(injuryStatus);
    }

    
}
