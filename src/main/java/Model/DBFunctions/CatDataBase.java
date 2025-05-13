/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DBFunctions;

import Model.Tables.AnimalData;
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
    
    public void addNewReceipt(AnimalData animaldata){
       try{
String sqladdnewanimal = "insert into animals(db_animalid, db_animalrace, db_animalspecies, db_animalsex, db_animalname, db_animalcolor, db_animalbirthdate, db_photoalbumid, db_castredstatus, db_healthstatus, db_injurystatus) values (?,?,?,?,?,?,?,?,?,?,?)";
                    
            PreparedStatement preparedStmt = connection.prepareStatement(sqladdnewanimal);
            preparedStmt.setString(1, animaldata.getAnimalid());
            preparedStmt.setString(2, animaldata.getAnimalrace());
            preparedStmt.setString(3, animaldata.getAnimalspecies());
            preparedStmt.setString(4, animaldata.getAnimalsex());
            preparedStmt.setString(5, animaldata.getAnimalname());
            preparedStmt.setString(6, animaldata.getAnimalcolor());
            preparedStmt.setString(7, animaldata.getAnimalbirthdate());
            preparedStmt.setString(8, animaldata.getPhotoalbumid());
            preparedStmt.setString(9, animaldata.getCastredstatus());
            preparedStmt.setString(10, animaldata.getHealthstatus());
            preparedStmt.setString(11, animaldata.getInjurystatus());
            preparedStmt.execute();
            
                 
        } catch 
                (SQLException e){
                Dialogs.showErrorAlert("Figyelem!", "addNewReceipt","Hiba: !"+e);
                System.out.println("Figyelem! "+"addNewReceipt"+" Hiba: !"+e);}
           
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
                        rs.getString("db_photoalbuiId"),
                        rs.getString("db_castredstatus"),
                        rs.getString("db_healthstatus"),
                        rs.getString("db_injurystatus"));
                    
                animals.add(allanimals);
            }               
        }catch (SQLException ex){
            
        }
        return animals;
    }
    
    public void deleteTable(){
        try {
            createStatement.execute("drop table Animals");
        } catch (SQLException ex) {
            Logger.getLogger(CatDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
} //end Class
