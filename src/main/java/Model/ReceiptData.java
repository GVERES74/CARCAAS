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
public class ReceiptData {
   
    private final SimpleStringProperty receiptid;
    private SimpleStringProperty animalid;
    private SimpleStringProperty personid; //PersonAddress nem kell, ez a PersonAddress táblában lesz összekapcsolva
    private SimpleStringProperty rescueaddressid;
    private SimpleStringProperty castredstatus;
    private SimpleStringProperty injurystatus;
    private SimpleStringProperty injurydesc;
    private SimpleStringProperty healthstatus;
    private SimpleStringProperty sicknessdesc;
    private SimpleStringProperty remarks;
    private SimpleStringProperty receiptdate;
    private SimpleStringProperty userid;
    
    public ReceiptData(String animalId, String personId, String personAddressId, String rescueAddressId, String castredStatus, String injuryStatus, String injuryDesc, String healthStatus, String sicknessDesc, String reMarks, LocalDate receiptDate, String userID){
        
        this.receiptid = new SimpleStringProperty("");
        this.animalid = new SimpleStringProperty(animalId);
        this.personid = new SimpleStringProperty(personId);
        this.rescueaddressid = new SimpleStringProperty(rescueAddressId);
        this.castredstatus = new SimpleStringProperty(castredStatus);
        this.injurystatus = new SimpleStringProperty(injuryStatus);
        this.injurydesc = new SimpleStringProperty(injuryDesc);
        this.healthstatus = new SimpleStringProperty(healthStatus);
        this.sicknessdesc = new SimpleStringProperty(sicknessDesc);
        this.remarks = new SimpleStringProperty(reMarks);
        this.receiptdate = new SimpleStringProperty(receiptDate.toString());
        this.userid = new SimpleStringProperty(userID);
        
    }

    public SimpleStringProperty getReceiptid() {
        return receiptid;
    }

    public SimpleStringProperty getAnimalid() {
        return animalid;
    }

    public SimpleStringProperty getPersonid() {
        return personid;
    }

    public SimpleStringProperty getRescueaddressid() {
        return rescueaddressid;
    }

    public SimpleStringProperty getCastredstatus() {
        return castredstatus;
    }

    public SimpleStringProperty getInjurystatus() {
        return injurystatus;
    }

    public SimpleStringProperty getInjurydesc() {
        return injurydesc;
    }

    public SimpleStringProperty getHealthstatus() {
        return healthstatus;
    }

    public SimpleStringProperty getSicknessdesc() {
        return sicknessdesc;
    }

    public SimpleStringProperty getRemarks() {
        return remarks;
    }

    public SimpleStringProperty getReceiptdate() {
        return receiptdate;
    }

    public SimpleStringProperty getUserid() {
        return userid;
    }
    
    

    /**
     * @param animalid the animalid to set
     */
    public void setAnimalid(String animalId) {
        animalid.set(animalId);
    }

    /**
     * @param personid the personid to set
     */
    public void setPersonid(String personId) {
        personid.set(personId);
    }

    /**
     * @param rescueaddressid the rescueaddressid to set
     */
    public void setRescueaddressid(String rescueaddressId) {
        rescueaddressid.set(rescueaddressId);
    }

    /**
     * @param castredstatus the castredstatus to set
     */
    public void setCastredstatus(String castredStatus) {
        castredstatus.set(castredStatus);
    }

    /**
     * @param injurystatus the injurystatus to set
     */
    public void setInjurystatus(String injuryStatus) {
        injurystatus.set(injuryStatus);
    }

    /**
     * @param injurydesc the injurydesc to set
     */
    public void setInjurydesc(String injuryDesc) {
        injurydesc.set(injuryDesc);
    }

    /**
     * @param healthstatus the healthstatus to set
     */
    public void setHealthstatus(String healthStatus) {
        healthstatus.set(healthStatus);
    }

    /**
     * @param sicknessdesc the sicknessdesc to set
     */
    public void setSicknessdesc(String sicknessDesc) {
        sicknessdesc.set(sicknessDesc);
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String reMarks) {
        remarks.set(reMarks);
    }

    /**
     * @param receiptdate the receiptdate to set
     */
    public void setReceiptdate(String receiptDate) {
        receiptdate.set(receiptDate);
    }
    
    public void setUserid(String userID) {
        userid.set(userID);
    }
    
}
