/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Tables;

import java.sql.Date;
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
    
    public ReceiptData(Integer receiptId, Integer animalId, Integer personAddressId, String receiptDate, Integer shelterId, String receiptLogNumber){
        
        this.receiptid = new SimpleStringProperty(String.valueOf(receiptId));
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        this.receiptdate = new SimpleStringProperty(receiptDate);
        this.shelterid = new SimpleStringProperty(String.valueOf(shelterId));
        this.receiptlognumber = new SimpleStringProperty(receiptLogNumber);
        
    }

     public ReceiptData(Integer animalId, Integer personAddressId, String receiptDate, Integer shelterId, String receiptLogNumber){
        
        this.receiptid = new SimpleStringProperty("");
        this.animalid = new SimpleStringProperty(String.valueOf(animalId));
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        this.receiptdate = new SimpleStringProperty(receiptDate);
        this.shelterid = new SimpleStringProperty(String.valueOf(shelterId));
        this.receiptlognumber = new SimpleStringProperty(receiptLogNumber);
        
    }
     
     
   //insert code getters

    public String getReceiptid() {
        return receiptid.get();
    }

    public String getAnimalid() {
        return animalid.get();
    }

    public String getPersonaddressid() {
        return personaddressid.get();
    }

    public String getReceiptdate() {
        return receiptdate.get();
    }

    public String getShelterid() {
        return shelterid.get();
    }

    public String getReceiptlognumber() {
        return receiptlognumber.get();
    }
   
}
