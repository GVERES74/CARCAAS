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
public class VeterinaryData {
   
    private SimpleStringProperty veterinaryid;
    private SimpleStringProperty veterinaryname;
    private SimpleStringProperty veterinarytaxnumber;
    private SimpleStringProperty veterinarybankaccountnumber;
    private SimpleStringProperty personaddressid;
        
        
    public VeterinaryData(Integer veterinaryId, String veterinaryName, String veterinaryTaxnumber, String veterinaryBankaccountnumber, Integer personAddressId){
        
        this.veterinaryid = new SimpleStringProperty(String.valueOf(veterinaryId));
        this.veterinarytaxnumber = new SimpleStringProperty(veterinaryTaxnumber);
        this.veterinarybankaccountnumber = new SimpleStringProperty(veterinaryBankaccountnumber);
        this.personaddressid = new SimpleStringProperty(String.valueOf(personAddressId));
        
    }

       
   

    public String getVeterinaryid() {
        return veterinaryid.get();
    }

    public String getVeterinaryname() {
        return veterinaryname.get();
    }

//insert code getters for taxnumber and bankaccount number


   
    public String getPersonaddressid() {
        return personaddressid.get();
    }
    
}
