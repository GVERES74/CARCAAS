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
public class AnimalConditionData {
   
    private SimpleStringProperty animalconditionid;
    private SimpleStringProperty receiptid;
    private SimpleStringProperty castredstatus;
    private SimpleStringProperty injurystatus;
    private SimpleStringProperty injurydesc;
    private SimpleStringProperty healthstatus;
    private SimpleStringProperty sicknessdesc;
    private SimpleStringProperty remarks;
        
    
    public AnimalConditionData(Integer animalConditionId, Integer receiptId, String castredStatus, String injuryStatus, String injuryDesc, String healthStatus, String sicknessDesc, String reMarks){
        
        this.animalconditionid = new SimpleStringProperty(String.valueOf(animalConditionId));
        this.receiptid = new SimpleStringProperty(String.valueOf(receiptId));
        this.castredstatus = new SimpleStringProperty(castredStatus);
        this.injurystatus = new SimpleStringProperty(injuryStatus);
        this.injurydesc = new SimpleStringProperty(injuryDesc);
        this.healthstatus = new SimpleStringProperty(healthStatus);
        this.sicknessdesc = new SimpleStringProperty(sicknessDesc);
        this.remarks = new SimpleStringProperty(reMarks);
        
    }

    public AnimalConditionData(String castredStatus, String injuryStatus, String injuryDesc, String healthStatus, String sicknessDesc, String reMarks){
        
        this.animalconditionid = new SimpleStringProperty(String.valueOf(""));
        this.receiptid = new SimpleStringProperty(String.valueOf(""));
        this.castredstatus = new SimpleStringProperty(castredStatus);
        this.injurystatus = new SimpleStringProperty(injuryStatus);
        this.injurydesc = new SimpleStringProperty(injuryDesc);
        this.healthstatus = new SimpleStringProperty(healthStatus);
        this.sicknessdesc = new SimpleStringProperty(sicknessDesc);
        this.remarks = new SimpleStringProperty(reMarks);
        
    }
    
    
  //insert code getters

    public String getAnimalconditionid() {
        return animalconditionid.get();
    }

    public String getReceiptid() {
        return receiptid.get();
    }

    public String getCastredstatus() {
        return castredstatus.get();
    }

    public String getInjurystatus() {
        return injurystatus.get();
    }

    public String getInjurydesc() {
        return injurydesc.get();
    }

    public String getHealthstatus() {
        return healthstatus.get();
    }

    public String getSicknessdesc() {
        return sicknessdesc.get();
    }

    public String getRemarks() {
        return remarks.get();
    }

    
   
}

