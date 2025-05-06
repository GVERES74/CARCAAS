/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utils.Dialogs;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DjRed
 */
public class CatDBConnection {
    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String LOCALURL = "jdbc:derby:CatMainDBase;create=true";
    final String USERNAME = "Catlantis";
    final String PASSWORD = "zebracica";
    
    
    public CatDBConnection(){
        Connection connection = null;
        Statement createStatement = null;
        DatabaseMetaData dbMetaData = null;
                
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
                Logger.getLogger(CatDBConnection.class.getName()).log(Level.SEVERE, null, ex);
                Dialogs.showErrorAlert("Hiba", "CreateStatement", ex.getMessage());
            }
        }
        
            try {
                dbMetaData = connection.getMetaData();
            } catch (SQLException ex) {
                Logger.getLogger(CatDBConnection.class.getName()).log(Level.SEVERE, null, ex);
                Dialogs.showErrorAlert("Hiba", "GetMetaData", ex.getMessage());
            }
            
        try {
            ResultSet resultSetUsers = dbMetaData.getTables(null, "APP", "USERS", null);
                if (!resultSetUsers.next()){
                    createStatement.execute(RawSQL.CreateTableUsers); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
            ResultSet resultSetRescuedAnimals = dbMetaData.getTables(null, "APP", "RESCUEDANIMALS", null);
                if (!resultSetRescuedAnimals.next()){
                    createStatement.execute(RawSQL.CreateTableRescuedAnimals); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetPersons = dbMetaData.getTables(null, "APP", "PERSONS", null);
                if (!resultSetPersons.next()){
                    createStatement.execute(RawSQL.CreateTablePersons); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetAddresses = dbMetaData.getTables(null, "APP", "ADDRESSES", null);
                if (!resultSetAddresses.next()){
                    createStatement.execute(RawSQL.CreateTableAddresses); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetPersonAddress = dbMetaData.getTables(null, "APP", "PERSONADDRESS", null);
                if (!resultSetPersonAddress.next()){
                    createStatement.execute(RawSQL.CreateTablePersonAddress); //Ha nem létezik a tábla, akkor létrehozzuk
                }
                
                ResultSet resultSetReceipts = dbMetaData.getTables(null, "APP", "RECEIPTS", null);
                if (!resultSetReceipts.next()){
                    createStatement.execute(RawSQL.CreateTableReceipts); //Rögzítő felhasználó ID
                }
                
                
                
        } catch (SQLException ex) {
            Logger.getLogger(CatDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            Dialogs.showErrorAlert("Hiba", "Adattábla USERS nem lett létrehozva!", ex.getMessage());
        }
    }
    
} //end Class
