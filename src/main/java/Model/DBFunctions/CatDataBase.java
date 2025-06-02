/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DBFunctions;

import Model.Tables.AnimalData;
import Model.Tables.PersonData;
import Model.Tables.ReceiptData;
import Model.Tables.AddressData;
import Model.Tables.CompanyData;
import Model.Tables.UserData;
import Utils.Dialogs;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DjRed
 */
public class CatDataBase {
    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String LOCALURL = "jdbc:derby:CatMainDBase;create=true";
    final String USERNAME = "Catlantis";
    final String PASSWORD = "zebracica";
    public Connection connection = null;
    Statement createStatement = null;
    DatabaseMetaData dbMetaData = null;
    
        
    public CatDataBase(){
        
                
        try{
            connection = DriverManager.getConnection(LOCALURL);
        }catch (SQLException ex){
           Dialogs.showErrorAlert("Hiba", "Adatbázis kapcsolódási hiba!", ex.getMessage());
        }
        Dialogs.showInfoAlert("Információ", "Adatbázis kapcsolat létrejött!", LOCALURL);
        
        if (connection != null){
            try {
                createStatement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
                Dialogs.showErrorAlert("Hiba", "CreateStatement", ex.getMessage());
            }
        }
        
            try {
                dbMetaData = connection.getMetaData();
            } catch (SQLException ex) {
                Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
                Dialogs.showErrorAlert("Hiba", "GetMetaData", ex.getMessage());
            }
            
            try {
            ResultSet resultSetUsers = dbMetaData.getTables(null, "APP", "USERS", null);
                if (!resultSetUsers.next()){
                    createStatement.execute(CreateTables.CreateTableUsers); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla USERS nem lett létrehozva!", ex.getMessage());
            }
            
            try {
            ResultSet resultSetCompanies = dbMetaData.getTables(null, "APP", "COMPANIES", null);
                if (!resultSetCompanies.next()){
                    createStatement.execute(CreateTables.CreateTableCompanies); //Ha nem létezik a tábla, akkor létrehozzuk
                }    
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla COMPANIES nem lett létrehozva!", ex.getMessage());
            }    
            
            try {
            ResultSet resultSetRescuedAnimals = dbMetaData.getTables(null, "APP", "ANIMALS", null);
                if (!resultSetRescuedAnimals.next()){
                    createStatement.execute(CreateTables.CreateTableAnimals); //Ha nem létezik a tábla, akkor létrehozzuk
                    Dialogs.showInfoAlert("CatDataBase", "CreateTableAnimals", "Table created");
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla ANIMALS nem lett létrehozva!", ex.getMessage());
            }  
            
            try {
            ResultSet resultSetPersons = dbMetaData.getTables(null, "APP", "PERSONS", null);
                if (!resultSetPersons.next()){
                    createStatement.execute(CreateTables.CreateTablePersons); //Ha nem létezik a tábla, akkor létrehozzuk
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla PERSONS nem lett létrehozva!", ex.getMessage());
            }      
                
            try {    
            ResultSet resultSetAddresses = dbMetaData.getTables(null, "APP", "ADDRESSES", null);
                if (!resultSetAddresses.next()){
                    createStatement.execute(CreateTables.CreateTableAddresses); //Ha nem létezik a tábla, akkor létrehozzuk
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla ADDRESSES nem lett létrehozva!", ex.getMessage());
            } 
                
            try {           
            ResultSet resultSetPersonAddress = dbMetaData.getTables(null, "APP", "PERSONADDRESS", null);
                if (!resultSetPersonAddress.next()){
                    createStatement.execute(CreateTables.CreateTablePersonAddress); //Ha nem létezik a tábla, akkor létrehozzuk
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla PERSONADDRESS nem lett létrehozva!", ex.getMessage());
            }     
            
            try {     
            ResultSet resultSetReceipts = dbMetaData.getTables(null, "APP", "RECEIPTS", null);
                if (!resultSetReceipts.next()){
                    createStatement.execute(CreateTables.CreateTableReceipts); //Rögzítő felhasználó ID
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla RECEIPTS nem lett létrehozva!", ex.getMessage());
            }     
                
                
        
    }
    
    public void addNewAnimal(AnimalData animaldata){
       try{
            String sqladdnewanimal = "insert into animals("
                    
                    + "db_animal_race, "
                    + "db_animal_species, "
                    + "db_animal_sex, "
                    + "db_animal_name, "
                    + "db_animal_color, "
                    + "db_animal_birthdate, "
                    + "db_photoalbum_id)"
                    + "values (?,?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewanimal);
            
            preparedStmt.setString(1, animaldata.getAnimalrace());
            preparedStmt.setString(2, animaldata.getAnimalspecies());
            preparedStmt.setString(3, animaldata.getAnimalsex());
            preparedStmt.setString(4, animaldata.getAnimalname());
            preparedStmt.setString(5, animaldata.getAnimalcolor());
            preparedStmt.setString(6, animaldata.getAnimalbirthdate());
            preparedStmt.setString(7, animaldata.getPhotoalbumid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+animaldata.getAnimalname()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új állat hozzáadása",animaldata.getAnimalname()+" "+e);
                System.out.println("Figyelem! "+"Új állat hozzáadása"+" Hiba: !"+e);}
           
    }    
    public ArrayList<AnimalData> getAnimals(){
        
        String animalgetquery = "SELECT * from animals";
        ArrayList<AnimalData> animals =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(animalgetquery);
            animals = new ArrayList<>();
            while (rs.next()){
                AnimalData allanimals = new AnimalData(
                        rs.getInt("db_animal_id"),
                        rs.getString("db_animal_race"),
                        rs.getString("db_animal_species"),    
                        rs.getString("db_animal_sex"),
                        rs.getString("db_animal_name"),
                        rs.getString("db_animal_color"),
                        rs.getString("db_animal_birthdate"),
                        rs.getString("db_photoalbum_id"));
                    
                animals.add(allanimals);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase", "GetAnimals", ""+ex);
        }
        return animals;
    }
    
    public void addNewPerson(PersonData persondata){
       try{
            String sqladdnewperson = "insert into persons("
                    
                    + "db_person_name, "
                    + "db_person_phone, "
                    + "db_person_email) "
                    + "values (?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewperson);
            
            preparedStmt.setString(1, persondata.getPersonname());
            preparedStmt.setString(2, persondata.getPersonphone());
            preparedStmt.setString(3, persondata.getPersonemail());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+persondata.getPersonemail()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új személy hozzáadása",persondata.getPersonid()+" "+e);
                System.out.println("Figyelem! "+"Új személy hozzáadása"+" Hiba: !"+e);}
           
    }    
    public ArrayList<PersonData> getPersons(){
        
        String persongetquery = "SELECT * from persons";
        ArrayList<PersonData> persons =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(persongetquery);
            persons = new ArrayList<>();
            while (rs.next()){
                PersonData allpersons = new PersonData(
                        rs.getInt("db_person_id"),
                        rs.getString("db_person_name"),
                        rs.getString("db_person_phone"),    
                        rs.getString("db_person_email"));
                                            
                persons.add(allpersons);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase", "GetPersons", ""+ex);
        }
        return persons;
    }
    
    
    public void addNewAddress(AddressData addressdata){
       try{
            String sqladdnewaddress = "insert into addresses("
                    
                    + "db_address_country, "
                    + "db_address_county, "
                    + "db_address_zipcode,"
                    + "db_address_city, "
                    + "db_address_street,"
                    + "db_address_number)"
                    + "values (?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewaddress);
            
            preparedStmt.setString(1, addressdata.getAddresscountry());
            preparedStmt.setString(2, addressdata.getAddresscounty());
            preparedStmt.setString(3, addressdata.getAddresszipcode());
            preparedStmt.setString(4, addressdata.getAddresscity());
            preparedStmt.setString(5, addressdata.getAddressstreet());
            preparedStmt.setString(6, addressdata.getAddressnumber());
            
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+addressdata.getAddressid()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új cim hozzáadása",addressdata.getAddressid()+" "+e);
                System.out.println("Figyelem! "+"Új cim hozzáadása"+" Hiba: !"+e);}
           
    }    
    public ArrayList<AddressData> getAddresses(){
        
        String addressgetquery = "SELECT * from addresses";
        ArrayList<AddressData> addresses =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(addressgetquery);
            addresses = new ArrayList<>();
            while (rs.next()){
                AddressData alladdresses = new AddressData(
                        rs.getInt("db_address_id"),
                        rs.getString("db_address_country"),
                        rs.getString("db_address_county"),    
                        rs.getString("db_address_zipcode"),
                        rs.getString("db_address_city"),
                        rs.getString("db_address_street"),    
                        rs.getString("db_address_number"));
                                            
                addresses.add(alladdresses);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase", "GetAddresses", ""+ex);
        }
        return addresses;
    }
    
    public void addNewReceipt(ReceiptData receiptdata){
        
        try{
            String sqladdnewreceipt = "insert into receipts("
                    
                    + "db_castred_status, "
                    + "db_injury_status, "
                    + "db_injury_desc, "
                    + "db_health_status,"
                    + "db_sickness_desc,"
                    + "db_remarks,"
                    + "db_receipt_date)"
                    + "values (?,?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewreceipt);
            
            preparedStmt.setString(1, receiptdata.getCastredstatus());
            preparedStmt.setString(2, receiptdata.getInjurystatus());
            preparedStmt.setString(3, receiptdata.getInjurydesc());
            preparedStmt.setString(4, receiptdata.getHealthstatus());
            preparedStmt.setString(5, receiptdata.getSicknessdesc());
            preparedStmt.setString(6, receiptdata.getRemarks());
            preparedStmt.setString(7, receiptdata.getReceiptdate());
            
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+receiptdata.getReceiptid()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új átvétel hozzáadása",receiptdata.getReceiptid()+" "+e);
                System.out.println("Figyelem! "+"Új átvétel hozzáadása"+" Hiba: !"+e);} 
        
       
    }
    public ArrayList<ReceiptData> getReceipts(){
        
        String receiptgetquery = "SELECT * from receipts";
        ArrayList<ReceiptData> receipts =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(receiptgetquery);
            receipts = new ArrayList<>();
            while (rs.next()){
                ReceiptData allreceipts = new ReceiptData(
                        rs.getInt("db_receipt_id"),
                        rs.getInt("db_animal_id"),
                        rs.getInt("db_rescuer_person_id"),    
                        rs.getInt("db_rescue_address_id"),
                        rs.getString("db_castred_status"),
                        rs.getString("db_injury_status"),
                        rs.getString("db_injury_desc"),
                        rs.getString("db_health_status"),
                        rs.getString("db_sickness_desc"),
                        rs.getString("db_remarks"),
                        rs.getString("db_receipt_date"),
                        rs.getInt("db_user_id"));
                        
                receipts.add(allreceipts);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase", "GetReceipts", ""+ex);
        }
        return receipts;
    }
    
    
    
    
    
    public void deleteTable(String tableName){
        try {
            createStatement.execute("drop table "+tableName);
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Tábla "+tableName+" sikeresen törölve!");
        } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
} //end Class
