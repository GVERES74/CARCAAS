/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Tables;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author djver
 */
public class CompanyData {
    
    private final SimpleStringProperty companyid, companyname, companytype, companypersonid, companyaddressid;
    
    
    public CompanyData(Integer companyId, String companyName, String companyType, Integer companyPersonId, Integer companyAddressId){
        
        this.companyid = new SimpleStringProperty(String.valueOf(companyId));
        this.companyname = new SimpleStringProperty(companyName);
        this.companytype = new SimpleStringProperty(companyType);
        this.companypersonid = new SimpleStringProperty(String.valueOf(companyPersonId));
        this.companyaddressid = new SimpleStringProperty(String.valueOf(companyAddressId));
        
    }

    public String getCompanyid() {
        return companyid.get();
    }

    public String getCompanyname() {
        return companyname.get();
    }

    public String getCompanytype() {
        return companytype.get();
    }

    public String getCompanypersonid() {
        return companypersonid.get();
    }

    public String getCompanyaddressid() {
        return companyaddressid.get();
    }

      
    public void setCompanyname(String companyName){
        companyname.set(companyName);
    }
    
    public void setCompanytype(String companyType){
        companytype.set(companyType);
    }

    


}



