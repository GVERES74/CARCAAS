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

       
   //insert code getters
   
}
