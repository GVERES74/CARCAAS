/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DBFunctions;

import Model.Tables.UserData;
import Model.Tables.AnimalData;
import Model.Tables.PersonData;
import Model.Tables.AddressData;
import Model.Tables.PersonAddressData;
import Model.Tables.ReceiptData;
import Model.Tables.AdoptionData;
import Model.Tables.AnimalConditionData;
import Model.Tables.ShelterData;
import Model.Tables.VeterinaryData;
import Model.Tables.TreatmentData;
import Model.Tables.InvoiceData;



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
    final String LOCALURL = "jdbc:derby:CatlantisDBase;create=true";
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
            ResultSet resultSetRescuedAnimals = dbMetaData.getTables(null, "APP", "ANIMALS", null);
                if (!resultSetRescuedAnimals.next()){
                    createStatement.execute(CreateTables.CreateTableAnimals); //Ha nem létezik a tábla, akkor létrehozzuk
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
                    createStatement.execute(CreateTables.CreateTablePersonAddress); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla PERSONADDRESS nem lett létrehozva!", ex.getMessage());
            }     
             

	    try {     
            ResultSet resultSetReceipts = dbMetaData.getTables(null, "APP", "RECEIPTS", null);
                if (!resultSetReceipts.next()){
                    createStatement.execute(CreateTables.CreateTableReceipts); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla RECEIPTS nem lett létrehozva!", ex.getMessage());
            }
   
   
	    try {     
            ResultSet resultSetAdoptions = dbMetaData.getTables(null, "APP", "ADOPTIONS", null);
                if (!resultSetAdoptions.next()){
                    createStatement.execute(CreateTables.CreateTableAdoptions); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla ADOPTIONS nem lett létrehozva!", ex.getMessage());
            }


	    try {     
            ResultSet resultSetAnimalConditions = dbMetaData.getTables(null, "APP", "ANIMALCONDITIONS", null);
                if (!resultSetAnimalConditions.next()){
                    createStatement.execute(CreateTables.CreateTableAnimalConditions); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla ANIMALCONDITIONS nem lett létrehozva!", ex.getMessage());
            }


	    try {     
            ResultSet resultSetShelters = dbMetaData.getTables(null, "APP", "SHELTERS", null);
                if (!resultSetShelters.next()){
                    createStatement.execute(CreateTables.CreateTableShelters); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla SHELTERS nem lett létrehozva!", ex.getMessage());
            }
             

	    try {     
            ResultSet resultSetVeterinaries = dbMetaData.getTables(null, "APP", "VETERINARIES", null);
                if (!resultSetVeterinaries.next()){
                    createStatement.execute(CreateTables.CreateTableVeterinaries); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla VETERINARIES nem lett létrehozva!", ex.getMessage());
            }


	    try {     
            ResultSet resultSetTreatments = dbMetaData.getTables(null, "APP", "TREATMENTS", null);
                if (!resultSetTreatments.next()){
                    createStatement.execute(CreateTables.CreateTableTreatments); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla TREATMENTS nem lett létrehozva!", ex.getMessage());
            }


	    try {     
            ResultSet resultSetInvoices = dbMetaData.getTables(null, "APP", "INVOICES", null);
                if (!resultSetInvoices.next()){
                    createStatement.execute(CreateTables.CreateTableInvoices); 
                }
            } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla INVOICES nem lett létrehozva!", ex.getMessage());
            }

       
    } //end of creating tables


    public void addNewUser(UserData userdata){
       try{
            String sqladdnewuser = "insert into USERS("
//auto generated PK + "db_user_id,"
                    + "db_user_name,"
                    + "db_user_password,"
		    + "db_person_id)" //FK from table PERSONS
                    + "values (?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewuser);
            
            preparedStmt.setString(1, userdata.getUsername());
            preparedStmt.setString(2, userdata.getUserpassword());
            preparedStmt.setString(3, userdata.getPersonid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+userdata.getUsername()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új felhasználó hozzáadása:",userdata.getUsername()+" "+e);
				}
    }    

    public ArrayList<UserData> getUsers(){
        
        String usergetquery = "SELECT * from USERS";
        ArrayList<UserData> users =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(usergetquery);
            users = new ArrayList<>();
            while (rs.next()){
                UserData allusers = new UserData(
                        
                        rs.getInt("db_user_id"),
                        rs.getString("db_user_name"),
                        rs.getString("db_user_password"),
                        rs.getInt("db_person_id"));
                    
                users.add(allusers);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetUsers"," Hibakód: "+ex);
        			}
        return users;
    }		


    
    public void addNewAnimal(AnimalData animaldata){
       try{
            String sqladdnewanimal = "insert into ANIMALS("
//auto generated PK + "db_animal_id,"
                    + "db_animal_race,"
                    + "db_animal_species,"
                    + "db_animal_sex,"
                    + "db_animal_name,"
                    + "db_animal_color,"
                    + "db_animal_birthdate,"
                    + "db_animal_age,"
                    + "db_chip_id,"
		    + "db_photoalbum_id)"
                    + "values (?,?,?,?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewanimal);
            
            preparedStmt.setString(1, animaldata.getAnimalrace());
            preparedStmt.setString(2, animaldata.getAnimalspecies());
            preparedStmt.setString(3, animaldata.getAnimalsex());
            preparedStmt.setString(4, animaldata.getAnimalname());
            preparedStmt.setString(5, animaldata.getAnimalcolor());
            preparedStmt.setString(6, animaldata.getAnimalbirthdate());
            preparedStmt.setString(7, animaldata.getAnimalage());
            preparedStmt.setString(8, animaldata.getChipid());
            preparedStmt.setString(9, animaldata.getPhotoalbumid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+animaldata.getAnimalname()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új állat hozzáadása:",animaldata.getAnimalname()+" "+e);
				}
    }    

    public ArrayList<AnimalData> getAnimals(){
        
        String animalgetquery = "SELECT * from ANIMALS";
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
                        rs.getInt("db_animal_age"),
                        rs.getString("db_chip_id"),
                        rs.getString("db_photoalbum_id"));
                    
                animals.add(allanimals);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetAnimals"," Hibakód: "+ex);
        }
        return animals;
    }
    
    public void addNewPerson(PersonData persondata){
       try{
            String sqladdnewperson = "insert into PERSONS("
//auto generated PK + "db_person_id,"	
                    + "db_person_first_name,"
                    + "db_person_last_name,"
                    + "db_person_phone,"
                    + "db_person_email)"
                    + "values (?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewperson);
                       
            preparedStmt.setString(1, persondata.getPersonfirstname());
            preparedStmt.setString(2, persondata.getPersonlastname());
            preparedStmt.setString(3, persondata.getPersonphone());
            preparedStmt.setString(4, persondata.getPersonemail());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+persondata.getPersonfirstname()+" "+persondata.getPersonlastname()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új személy hozzáadása",persondata.getPersonemail()+" "+e);
           
        }
    }   
       
    public ArrayList<PersonData> getPersons(){
        
        String persongetquery = "SELECT * from PERSONS";
        ArrayList<PersonData> persons =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(persongetquery);
            persons = new ArrayList<>();
            while (rs.next()){
                PersonData allpersons = new PersonData(
                        
                        rs.getInt("db_person_id"),
                        rs.getString("db_person_first_name"),
                        rs.getString("db_person_last_name"),
                        rs.getString("db_person_phone"),    
                        rs.getString("db_person_email"));
                                            
                persons.add(allpersons);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetPersons"," Hibakód: "+ex);
        }
        return persons;
    }
    
    
    public void addNewAddress(AddressData addressdata){
       try{
            String sqladdnewaddress = "insert into ADDRESSES("
//auto generated PK + "db_address_id,"	                                        
                    + "db_address_country,"
                    + "db_address_county,"
                    + "db_address_zipcode,"
                    + "db_address_city,"
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
                Dialogs.showErrorAlert("Hiba!", "Új cim hozzáadása",addressdata.getAddressstreet()+" "+e);
        }
    }    

    public ArrayList<AddressData> getAddresses(){
        
        String addressgetquery = "SELECT * from ADDRESSES";
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
           Dialogs.showErrorAlert("CatDatabase","GetAddresses"," Hibakód: "+ex);
        }
        return addresses;
    }
    

    public void addNewPersonAddress(PersonAddressData personaddressdata){
       try{
            String sqladdnewpersonaddress = "insert into PERSONADDRESSES("
//auto generated PK + "db_personaddress_id,"
		    + "db_person_id," //FK from table PERSONS
		    + "db_address_id)" //FK from table ADDRESSES
                    + "values (?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewpersonaddress);
            
            preparedStmt.setString(1, personaddressdata.getPersonid());
            preparedStmt.setString(2, personaddressdata.getAddressid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+personaddressdata.getPersonaddressid()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új Személy+Cím hozzáadása:",personaddressdata.getPersonid()+" Hibakód: "+e);
				}
    }    

    public ArrayList<PersonAddressData> getPersonaddresses(){
        
        String personaddressgetquery = "SELECT * from PERSONADDRESSES";
        ArrayList<PersonAddressData> personaddresses =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(personaddressgetquery);
            personaddresses = new ArrayList<>();
            while (rs.next()){
                PersonAddressData allpersonaddresses = new PersonAddressData(
                        
                        rs.getInt("db_personaddress_id"),
                        rs.getInt("db_person_id"),
                        rs.getInt("db_address_id"));
                    
                personaddresses.add(allpersonaddresses);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetPersonAddress"," Hibakód: "+ex);
        			}
        return personaddresses;
    }		 	


    public void addNewReceipt(ReceiptData receiptdata){
        
        try{
            String sqladdnewreceipt = "insert into RECEIPTS("
//auto generated PK + "db_receipt_id,"	
                    + "db_animal_id," //FK from table ANIMALS
                    + "db_personaddress_id," //FK from table PERSONADDRESS
                    + "db_receipt_date,"
                    + "db_shelter_id," //FK from table SHELTERS
		    + "db_receipt_log_number)"
                    + "values (?,?,?,?,?)";
		   
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewreceipt);
            
            preparedStmt.setString(1, receiptdata.getAnimalid());
            preparedStmt.setString(2, receiptdata.getPersonaddressid());
            preparedStmt.setString(3, receiptdata.getReceiptdate());
            preparedStmt.setString(4, receiptdata.getShelterid());
            preparedStmt.setString(5, receiptdata.getReceiptlognumber());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+receiptdata.getReceiptlognumber()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új átvétel hozzáadása",receiptdata.getReceiptid()+" "+e);
       				}
    }


    public ArrayList<ReceiptData> getReceipts(){
        
        String receiptgetquery = "SELECT * from RECEIPTS";
        ArrayList<ReceiptData> receipts =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(receiptgetquery);
            receipts = new ArrayList<>();
            while (rs.next()){
                ReceiptData allreceipts = new ReceiptData(
                        rs.getInt("db_receipt_id"),
                        rs.getInt("db_animal_id"),
                        rs.getInt("db_personaddress_id"),    
                        rs.getString("db_receipt_date"),
                        rs.getInt("db_shelter_id"),
			rs.getString("db_receipt_log_number"));    
                        
                receipts.add(allreceipts);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetReceipts"," Hibakód: "+ex);
			        }
        return receipts;
    }
    
    
    public void addNewAdoption(AdoptionData adoptiondata){
        
        try{
            String sqladdnewadoption = "insert into ADOPTIONS("
//auto generated PK + "db_adoption_id,"	
                    + "db_animal_id," //FK from table ANIMALS
                    + "db_personaddress_id," //FK from table PERSONADDRESS
                    + "db_adoption_date,"
                    + "db_shelter_id," //FK from table SHELTERS
		    + "db_adoption_log_number)"	
                    + "values (?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewadoption);
            
            preparedStmt.setString(1, adoptiondata.getAnimalid());
            preparedStmt.setString(2, adoptiondata.getPersonaddressid());
            preparedStmt.setString(3, adoptiondata.getAdoptiondate());
            preparedStmt.setString(4, adoptiondata.getShelterid());
            preparedStmt.setString(5, adoptiondata.getAdoptionlognumber());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+adoptiondata.getAdoptionlognumber()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új örökbeadás hozzáadása",adoptiondata.getAdoptionlognumber()+" "+e);
       				}
    }


    public ArrayList<AdoptionData> getAdoptions(){
        
        String adoptiongetquery = "SELECT * from ADOPTIONS";
        ArrayList<AdoptionData> adoptions = null;
        
        try{
            ResultSet rs = createStatement.executeQuery(adoptiongetquery);
            adoptions = new ArrayList<>();
            while (rs.next()){
                AdoptionData alladoptions = new AdoptionData(
                        rs.getInt("db_adoption_id"),
                        rs.getInt("db_animal_id"),
                        rs.getInt("db_personaddress_id"),    
                        rs.getDate("db_adoption_date"),
                        rs.getInt("db_shelter_id"),
			rs.getInt("db_adoption_log_number"));    
                        
                adoptions.add(alladoptions);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetAdoptions"," Hibakód: "+ex);
			        }
        return adoptions;
    }
    
   
    
public void addNewAnimalCondition(AnimalConditionData animalconditiondata){
        
        try{
            String sqladdnewanimalcondition = "insert into ANIMALCONDITIONS(" 
//auto generated PK + "db_animalcondition_id",
                    + "db_receipt_id," //FK from table RECEIPTS
                    + "db_castred_status,"
                    + "db_injury_status,"
                    + "db_injury_desc,"
                    + "db_health_status,"
                    + "db_sickness_desc,"
		    + "db_remarks)"	
                    + "values (?,?,?,?,?,?,?)";
		    
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewanimalcondition);
            
            
            preparedStmt.setString(1, animalconditiondata.getReceiptid());
            preparedStmt.setString(2, animalconditiondata.getCastredstatus());
            preparedStmt.setString(3, animalconditiondata.getInjurystatus());
            preparedStmt.setString(4, animalconditiondata.getInjurydesc());
            preparedStmt.setString(5, animalconditiondata.getHealthstatus());
            preparedStmt.setString(6, animalconditiondata.getSicknessdesc());
            preparedStmt.setString(7, animalconditiondata.getRemarks());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+animalconditiondata.getRemarks()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új kórisme hozzáadása",animalconditiondata.getRemarks()+" Hibakód: "+e);
       				}
    }


    public ArrayList<AnimalConditionData> getAnimalconditions(){
        
        String animalconditiongetquery = "SELECT * from ANIMALCONDITIONS";
        ArrayList<AnimalConditionData> animalconditions = null;
        
        try{
            ResultSet rs = createStatement.executeQuery(animalconditiongetquery);
            animalconditions = new ArrayList<>();
            while (rs.next()){
                AnimalConditionData allanimalconditions = new AnimalConditionData(
                        rs.getInt("db_animalcondition_id"),
                        rs.getInt("db_receipt_id"),
                        rs.getString("db_castred_status"),    
                        rs.getString("db_injury_status"),    
                        rs.getString("db_injury_desc"),    
                        rs.getString("db_health_status"),    
                        rs.getString("db_sickness_desc"),    
			rs.getString("db_remarks"));    
                        
                animalconditions.add(allanimalconditions);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetAnimalConditions"," Hibakód: "+ex);
			        }
        return animalconditions;
    }

 
    public void addNewShelter(ShelterData shelterdata){
       try{
            String sqladdnewshelter = "insert into SHELTERS("
//auto generated PK + "db_shelter_id,"
		    + "db_shelter_name,"
		    + "db_shelter_taxnumber,"
		    + "db_shelter_bankaccount_number,"
		    + "db_animal_id," //FK from table ANIMALS
		    + "db_personaddress_id)" //FK from table PERSONADDRESS
                    + "values (?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewshelter);
            
            preparedStmt.setString(1, shelterdata.getSheltername());
	    preparedStmt.setString(2, shelterdata.getSheltertaxnumber());
	    preparedStmt.setString(3, shelterdata.getShelterbankaccountnumber());
            preparedStmt.setString(4, shelterdata.getAnimalid());
            preparedStmt.setString(5, shelterdata.getPersonaddressid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+shelterdata.getSheltername()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új menhely hozzáadása:",shelterdata.getSheltername()+" Hibakód: "+e);
				}
    }    

    public ArrayList<ShelterData> getShelters(){
        
        String sheltergetquery = "SELECT * from SHELTERS";
        ArrayList<ShelterData> shelters = null;
        
        try{
            ResultSet rs = createStatement.executeQuery(sheltergetquery);
            shelters = new ArrayList<>();
            while (rs.next()){
                ShelterData allshelters = new ShelterData(
                        
                        rs.getInt("db_shelter_id"),
                        rs.getString("db_shelter_name"),
			rs.getString("db_shelter_taxnumber"),
			rs.getString("db_shelter_bankaccount_number"),
                        rs.getInt("db_animal_id"),
                        rs.getInt("db_personaddress_id"));
                    
                shelters.add(allshelters);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetShelters"," Hibakód: "+ex);
        			}
        return shelters;
    }		 	



public void addNewVeterinary(VeterinaryData veterinarydata){
       try{
            String sqladdnewveterinary = "insert into VETERINARIES("
//auto generated PK + "db_vet_id,"
		    + "db_vet_name,"
		    + "db_vet_taxnumber,"
		    + "db_vet_bankaccount_number,"
		    + "db_personaddress_id)" //FK from table PERSONADDRESS
                    + "values (?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewveterinary);
            
            preparedStmt.setString(1, veterinarydata.getVeterinaryname());
	    preparedStmt.setString(2, veterinarydata.getVeterinarytaxnumber());
	    preparedStmt.setString(3, veterinarydata.getVeterinarybankaccountnumber());   
            preparedStmt.setString(4, veterinarydata.getPersonaddressid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+veterinarydata.getVeterinaryname()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új állatorvos hozzáadása:",veterinarydata.getVeterinaryname()+" Hibakód: "+e);
				}
    }    

    public ArrayList<VeterinaryData> getVeterinaries(){
        
        String veterinarygetquery = "SELECT * from VETERINARIES";
        ArrayList<VeterinaryData> veterinaries = null;
        
        try{
            ResultSet rs = createStatement.executeQuery(veterinarygetquery);
            veterinaries = new ArrayList<>();
            while (rs.next()){
                VeterinaryData allveterinaries = new VeterinaryData(
                        
                        rs.getInt("db_vet_id"),
                        rs.getString("db_vet_name"),
			rs.getString("db_vet_taxnumber"),
			rs.getString("db_vet_bankaccount_number"),
                        rs.getInt("db_personaddress_id"));
 //db_animal_id kell?                   
                veterinaries.add(allveterinaries);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetVeterinaries"," Hibakód: "+ex);
        			}
        return veterinaries;
    }		 	


public void addNewTreatment(TreatmentData treatmentdata){
       try{
            String sqladdnewtreatment = "insert into TREATMENTS("
//auto generated PK + "db_treatment_id,"
		    + "db_treatment_type,"
		    + "db_treatment_date,"
		    + "db_vet_id," //FK from table VETERINARIES
		    + "db_animal_id," //FK from table ANIMALS
		    + "db_invoice_id," //FK from table INVOICES
		    + "db_treatment_log_number)"
                    + "values (?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewtreatment);
            
            preparedStmt.setString(1, treatmentdata.getTreatmenttype());
            preparedStmt.setString(2, treatmentdata.getTreatmentdate());
            preparedStmt.setString(3, treatmentdata.getVetid());
	    preparedStmt.setString(4, treatmentdata.getAnimalid());
	    preparedStmt.setString(5, treatmentdata.getInvoiceid());
	    preparedStmt.setString(6, treatmentdata.getTreatmentlognumber());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+treatmentdata.getTreatmenttype()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új kezelés hozzáadása:",treatmentdata.getTreatmenttype()+" Hibakód: "+e);
				}
    }    

    public ArrayList<TreatmentData> getTreatments(){
        
        String treatmentgetquery = "SELECT * from TREATMENTS";
        ArrayList<TreatmentData> treatments = null;
        
        try{
            ResultSet rs = createStatement.executeQuery(treatmentgetquery);
            treatments = new ArrayList<>();
            while (rs.next()){
                TreatmentData alltreatments = new TreatmentData(
                        
                        rs.getInt("db_treatment_id"),
                        rs.getString("db_treatment_type"),
                        rs.getDate("db_treatment_date"),
			rs.getInt("db_vet_id"),
			rs.getInt("db_animal_id"),
			rs.getInt("db_invoice_id"),
			rs.getInt("db_treatment_log_number"));
                    
                treatments.add(alltreatments);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetTreatments"," Hibakód: "+ex);
        			}
        return treatments;
    }		 	


public void addNewInvoice(InvoiceData invoicedata){
       try{
            String sqladdnewinvoice = "insert into INVOICES("
//auto generated PK + "db_invoice_id,"
		    + "db_invoice_number,"
		    + "db_invoice_cost,"
		    + "db_invoice_date,"
		    + "db_payment_duedate,"
		    + "db_payment_paiddate,"
		    + "db_invoice_status)"
                    + "values (?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewinvoice);
            
            preparedStmt.setString(1, invoicedata.getInvoicenumber());
            preparedStmt.setString(2, invoicedata.getInvoicecost());
            preparedStmt.setString(3, invoicedata.getInvoicedate());
	    preparedStmt.setString(4, invoicedata.getPaymentduedate());
	    preparedStmt.setString(5, invoicedata.getPaymentpaiddate());
	    preparedStmt.setString(6, invoicedata.getInvoicestatus());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+invoicedata.getInvoicenumber()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Hiba!", "Új számla hozzáadása:",invoicedata.getInvoicenumber()+" Hibakód: "+e);
				}
    }    

    public ArrayList<InvoiceData> getInvoices(){
        
        String invoicegetquery = "SELECT * from INVOICES";
        ArrayList<InvoiceData> invoices = null;
        
        try{
            ResultSet rs = createStatement.executeQuery(invoicegetquery);
            invoices = new ArrayList<>();
            while (rs.next()){
                InvoiceData allinvoices = new InvoiceData(
                        
                        rs.getInt("db_invoice_id"),
                        rs.getString("db_invoice_number"),
                        rs.getInt("db_invoice_cost"),
			rs.getDate("db_invoice_date"),
			rs.getDate("db_payment_duedate"),
			rs.getDate("db_payment_paiddate"),
			rs.getString("db_invoice_status"));
                    
                invoices.add(allinvoices);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase","GetTreatments"," Hibakód: "+ex);
        			}
        return invoices;
    }		 	
//end of SQL INSERT and SELECT    
    

public void deleteTable(String tableName){
        try {
            createStatement.execute("drop table "+tableName);
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Tábla "+tableName+" sikeresen törölve!");
        } catch (SQLException ex) {
            Dialogs.showErrorAlert("Hiba az adattábla törléskor!", "Táblanév: "+tableName, "Hibakód: "+ex);
        }
}

    
    
} //end Class
