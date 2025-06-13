ter/*
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
    private SimpleStringProperty personaddressid;
    private SimpleStringProperty receiptdate;
    private SimpleStringProperty shelterid;
    private SimpleStringProperty receiptlognumber;
    
    public ReceiptData(Integer receiptId, Integer animalId, Integer personAddressId, Date receiptDate, Integer shelterId, Integer receiptLogNumber){
        
        this.receiptid = new SimpleStringProperty(String.valueOf(receiptId));
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personid = new SimpleStringProperty(String.valueOf(personAddressId));
        this.receiptdate = new SimpleStringProperty(String.valueOf(receiptDate));
        this.shelterid = new SimpleStringProperty(String.valueOf(shelterId));
        this.receiptlognumber = new SimpleStringProperty(String.valueOf(receiptLogNumber));
        
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

    public String getPersonaddressid() {
        return personaddressid.get();
    }

    public void setPersonaddressid(SimpleStringProperty personaddressid) {
        this.personaddressid = personaddressid;
    }

    public String getReceiptdate() {
        return receiptdate.get();
    }

    public void setReceiptdate(SimpleStringProperty receiptdate) {
        this.receiptdate = receiptdate;
    }

    public String getShelterid() {
        return shelterid.get();
    }

    public void setShelterid(SimpleStringProperty shelterid) {
        this.shelterid = shelterid;
    }

   public String getReceiptlognumber() {
        return receiptlognumber.get();
    }

    public void setReceiptlognumber(SimpleStringProperty receiptlognumber) {
        this.receiptlognumber = receiptlognumber;
    }
   
}
