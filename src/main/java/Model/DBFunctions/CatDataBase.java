/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DBFunctions;

import Model.Tables.AnimalData;
import Model.Tables.PersonData;
import Model.Tables.AddressData;
import Model.Tables.ReceiptData;
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
                
            ResultSet resultSetRescuedAnimals = dbMetaData.getTables(null, "APP", "ANIMALS", null);
                if (!resultSetRescuedAnimals.next()){
                    createStatement.execute(CreateTables.CreateTableAnimals); //Ha nem létezik a tábla, akkor létrehozzuk
                    Dialogs.showInfoAlert("CatDataBase", "CreateTableAnimals", "Table created");
                }
                
                ResultSet resultSetPersons = dbMetaData.getTables(null, "APP", "PERSONS", null);
                if (!resultSetPersons.next()){
                    createStatement.execute(CreateTables.CreateTablePersons); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetAddresses = dbMetaData.getTables(null, "APP", "ADDRESSES", null);
                if (!resultSetAddresses.next()){
                    createStatement.execute(CreateTables.CreateTableAddresses); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetPersonAddress = dbMetaData.getTables(null, "APP", "PERSONADDRESS", null);
                if (!resultSetPersonAddress.next()){
                    createStatement.execute(CreateTables.CreateTablePersonAddress); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetReceipts = dbMetaData.getTables(null, "APP", "RECEIPTS", null);
                if (!resultSetReceipts.next()){
                    createStatement.execute(CreateTables.CreateTableReceipts); //Rögzítő felhasználó ID
                }
                
                
                
        } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla USERS nem lett létrehozva!", ex.getMessage());
        }
    }
    
    public void addNewAnimal(AnimalData animaldata){
       try{
            String sqladdnewanimal = "insert into animals("
                    + "db_animalid, "
                    + "db_animalrace, "
                    + "db_animalspecies, "
                    + "db_animalsex, "
                    + "db_animalname, "
                    + "db_animalcolor, "
                    + "db_animalbirthdate, "
                    + "db_photoalbumid)"
                    + "values (?,?,?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewanimal);
            preparedStmt.setString(1, animaldata.getAnimalid());
            preparedStmt.setString(2, animaldata.getAnimalrace());
            preparedStmt.setString(3, animaldata.getAnimalspecies());
            preparedStmt.setString(4, animaldata.getAnimalsex());
            preparedStmt.setString(5, animaldata.getAnimalname());
            preparedStmt.setString(6, animaldata.getAnimalcolor());
            preparedStmt.setString(7, animaldata.getAnimalbirthdate());
            preparedStmt.setString(8, animaldata.getPhotoalbumid());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+animaldata.getAnimalid()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új állat hozzáadása",animaldata.getAnimalid()+" "+e);
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
                        rs.getString("db_animalid"),
                        rs.getString("db_animalrace"),
                        rs.getString("db_animalspecies"),    
                        rs.getString("db_animalsex"),
                        rs.getString("db_animalname"),
                        rs.getString("db_animalcolor"),
                        rs.getString("db_animalbirthdate"),
                        rs.getString("db_photoalbumid"));
                    
                animals.add(allanimals);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase", "GetAnimals", ""+ex);
        }
        return animals;
    }
    
    
    public ArrayList<PersonData> getPersons(){
        
        String persongetquery = "SELECT * from persons";
        ArrayList<PersonData> persons =null;
        
        try{
            ResultSet rs = createStatement.executeQuery(persongetquery);
            persons = new ArrayList<>();
            while (rs.next()){
                PersonData allpersons = new PersonData(
                        rs.getString("db_personid"),
                        rs.getString("db_personname"),
                        rs.getString("db_personphone"),    
                        rs.getString("db_personemail"));
                                            
                persons.add(allpersons);
                
            }               
        }catch (SQLException ex){
           Dialogs.showErrorAlert("CatDatabase", "GetPersons", ""+ex);
        }
        return persons;
    }
    
    public void addNewPerson(PersonData persondata){
       try{
            String sqladdnewperson = "insert into persons("
                    + "db_personid, "
                    + "db_personname, "
                    + "db_personphone, "
                    + "db_personemail) "
                    + "values (?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewperson);
            preparedStmt.setString(1, persondata.getPersonid());
            preparedStmt.setString(2, persondata.getPersonname());
            preparedStmt.setString(3, persondata.getPersonphone());
            preparedStmt.setString(4, persondata.getPersonemail());
            preparedStmt.execute();
            
            Dialogs.showInfoAlert("Information", CatDataBase.class.getName(), "Rekord "+persondata.getPersonid()+" sikeresen hozzáadva!");     
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "Új személy hozzáadása",persondata.getPersonid()+" "+e);
                System.out.println("Figyelem! "+"Új személy hozzáadása"+" Hiba: !"+e);}
           
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
