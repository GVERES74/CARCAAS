/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DBFunctions;

/**
 *
 * @author DjRed
 */
public class CreateTables {
    
    static String CreateTableReceipts = "create table receipts("
                                    + "db_receiptid varchar(50),"
                                    + "db_animalid varchar(50),"
                                    + "db_rescuerpersonid varchar(10),"
                                    + "db_rescueaddreid varchar(10),"
                                    + "db_castredstatus varchar(10),"
                                    + "db_injurystatus varchar(10),"
                                    + "db_injurydesc varchar (250),"
                                    + "db_healthstatus varchar (10),"
                                    + "db_sicknessdesc varchar (250),"
                                    + "db_remarks varchar (250),"
                                    + "db_receiptdate varchar(20),"
                                    + "db_userid varchar (10))"; //Rögzítő felhasználó ID

    
    static String CreateTablePersonAddress = "create table personaddress("
                                    + "db_assignid INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "db_personid varchar(10) NOT NULL,"
                                    + "db_addressid varchar(10) NOT NULL,"
                                    + "db_relationtype varchar(30) NOT NULL UNIQUE)";
    
    static String CreateTableAddresses = "create table addresses("
                                    + "db_addressid varchar(10) NOT NULL PRIMARY KEY,"
                                    + "db_addresscountry varchar(30) NOT NULL,"
                                    + "db_addresscounty varchar(30) NOT NULL,"
                                    + "db_addresszipcode varchar(20) NOT NULL,"
                                    + "db_addresscity varchar(30),"
                                    + "db_addressstreet varchar(50),"
                                    + "db_addressnumber varchar(20))";
    
    
    static String CreateTablePersons = "create table persons("
                                    + "db_personid varchar(50),"
                                    + "db_personname varchar(30) NOT NULL,"
                                    + "db_personphone varchar(20) NOT NULL,"
                                    + "db_personemail varchar(50) NOT NULL)";
    
    
    public static String CreateTableAnimals = "create table animals("
            + "db_animalid varchar(50), "
            + "db_animalrace varchar(30), "
            + "db_animalspecies varchar(30), "
            + "db_animalsex varchar(20), "
            + "db_animalname varchar(30) NOT NULL UNIQUE, "
            + "db_animalcolor varchar (30), "
            + "db_animalbirthdate varchar (30), "
            + "db_photoalbumid varchar (50))";
    
    
    static String CreateTableUsers = "create table users("
                                    + "userid varchar(10) NOT NULL PRIMARY KEY,"
                                    + "username varchar(30) NOT NULL,"
                                    + "usercompany varchar(50) NOT NULL,"
                                    + "userpassword varchar(20) NOT NULL, UNIQUE(UserName, UserPassword))";
    
   
    
}
