/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Tables;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author djver
 */
public class InvoiceData {
    
    private final SimpleStringProperty invoiceid;
    private final SimpleStringProperty invoicenumber; 
    private final SimpleStringProperty invoicecost; 
    private final SimpleStringProperty invoicedate; 
    private final SimpleStringProperty paymentduedate; 
    private final SimpleStringProperty paymentpaiddate; 
    private final SimpleStringProperty invoicestatus;
    
    
    public InvoiceData(Integer invoiceId, String invoiceNumber, Integer invoiceCost, LocalDate invoiceDate, LocalDate paymentDueDate, LocalDate paymentPaidDate, String invoiceStatus){
        
        this.invoiceid = new SimpleStringProperty(String.valueOf(invoiceId));
        this.invoicenumber = new SimpleStringProperty(invoiceNumber);
        this.invoicecost = new SimpleStringProperty(String.valueOf(invoiceCost));
        this.invoicedate = new SimpleStringProperty(String.valueOf(invoiceDate));
        this.paymentduedate = new SimpleStringProperty(String.valueOf(paymentDueDate));
        this.paymentpaiddate = new SimpleStringProperty(String.valueOf(paymentPaidDate));
        this.invoicestatus = new SimpleStringProperty(invoiceStatus);
        
    }

   //insert code getters

    public String getInvoiceid() {
        return invoiceid.get();
    }

    public String getInvoicenumber() {
        return invoicenumber.get();
    }

    public String getInvoicecost() {
        return invoicecost.get();
    }

    public String getInvoicedate() {
        return invoicedate.get();
    }

    public String getPaymentduedate() {
        return paymentduedate.get();
    }

    public String getPaymentpaiddate() {
        return paymentpaiddate.get();
    }

    public String getInvoicestatus() {
        return invoicestatus.get();
    }


}



