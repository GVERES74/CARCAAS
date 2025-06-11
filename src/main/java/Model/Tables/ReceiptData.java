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
public class ReceiptData {
   
    private SimpleStringProperty receiptid;
    private SimpleStringProperty animalid;
    private SimpleStringProperty personid; //PersonAddress nem kell, ez a PersonAddress táblában lesz összekapcsolva
    private SimpleStringProperty addressid;
    private SimpleStringProperty castredstatus;
    private SimpleStringProperty injurystatus;
    private SimpleStringProperty injurydesc;
    private SimpleStringProperty healthstatus;
    private SimpleStringProperty sicknessdesc;
    private SimpleStringProperty remarks;
    private SimpleStringProperty receiptdate;
    
    
    public ReceiptData(Integer receiptId, Integer animalId, Integer personId, Integer addressId, String castredStatus, String injuryStatus, String injuryDesc, String healthStatus, String sicknessDesc, String reMarks, String receiptDate){
        
        this.receiptid = new SimpleStringProperty(String.valueOf(receiptId));
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personid = new SimpleStringProperty(String.valueOf(personId));
        this.addressid = new SimpleStringProperty(String.valueOf(addressId));
        this.castredstatus = new SimpleStringProperty(castredStatus);
        this.injurystatus = new SimpleStringProperty(injuryStatus);
        this.injurydesc = new SimpleStringProperty(injuryDesc);
        this.healthstatus = new SimpleStringProperty(healthStatus);
        this.sicknessdesc = new SimpleStringProperty(sicknessDesc);
        this.remarks = new SimpleStringProperty(reMarks);
        this.receiptdate = new SimpleStringProperty(String.valueOf(receiptDate));
        
        
    }

    public ReceiptData(String castredStatus, String injuryStatus, String injuryDesc, String healthStatus, String sicknessDesc, String reMarks, String receiptDate){
        
        this.receiptid = new SimpleStringProperty("");
        this.animalid = new SimpleStringProperty("");
        this.personid = new SimpleStringProperty("");
        this.addressid = new SimpleStringProperty("");
        this.castredstatus = new SimpleStringProperty("");
        this.injurystatus = new SimpleStringProperty("");
        this.injurydesc = new SimpleStringProperty("");
        this.healthstatus = new SimpleStringProperty("");
        this.sicknessdesc = new SimpleStringProperty("");
        this.remarks = new SimpleStringProperty("");
        this.receiptdate = new SimpleStringProperty("");
        
        
    }
    
    
    
    public String getReceiptid() {
        return receiptid.get();
    }

    public void setReceiptid(SimpleStringProperty receiptid) {
        this.receiptid = receiptid;
    }

    public String getAnimalid() {
        return animalid.get();
    }

    public void setAnimalid(SimpleStringProperty animalid) {
        this.animalid = animalid;
    }

    public String getPersonid() {
        return personid.get();
    }

    public void setPersonid(SimpleStringProperty personid) {
        this.personid = personid;
    }

    public String getAddressid() {
        return addressid.get();
    }

    public void setAddressid(SimpleStringProperty addressid) {
        this.addressid = addressid;
    }

    public String getCastredstatus() {
        return castredstatus.get();
    }

    public void setCastredstatus(SimpleStringProperty castredstatus) {
        this.castredstatus = castredstatus;
    }

    public String getInjurystatus() {
        return injurystatus.get();
    }

    public void setInjurystatus(SimpleStringProperty injurystatus) {
        this.injurystatus = injurystatus;
    }

    public String getInjurydesc() {
        return injurydesc.get();
    }

    public void setInjurydesc(SimpleStringProperty injurydesc) {
        this.injurydesc = injurydesc;
    }

    public String getHealthstatus() {
        return healthstatus.get();
    }

    public void setHealthstatus(SimpleStringProperty healthstatus) {
        this.healthstatus = healthstatus;
    }

    public String getSicknessdesc() {
        return sicknessdesc.get();
    }

    public void setSicknessdesc(SimpleStringProperty sicknessdesc) {
        this.sicknessdesc = sicknessdesc;
    }

    public String getRemarks() {
        return remarks.get();
    }

    public void setRemarks(SimpleStringProperty remarks) {
        this.remarks = remarks;
    }

    public String getReceiptdate() {
        return receiptdate.get();
    }

    public void setReceiptdate(SimpleStringProperty receiptdate) {
        this.receiptdate = receiptdate;
    }

   
   
}
