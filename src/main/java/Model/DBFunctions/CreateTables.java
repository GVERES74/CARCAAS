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
    
    static String CreateTableReceipts = "create table Receipts("
                                    + "ReceiptID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "AnimalID INT,"
                                    + "RescuerPersonID varchar(10),"
                                    + "RescueAddressID varchar(10),"
                                    + "CastredStatus varchar(10),"
                                    + "InjuryStatus varchar(10),"
                                    + "InjuryDesc varchar (250),"
                                    + "HealthStatus varchar (10),"
                                    + "SicknessDesc varchar (250),"
                                    + "Remarks varchar (250),"
                                    + "ReceiptDate DATE),"
                                    + "UserID varchar (10)"; //Rögzítő felhasználó ID

    
    static String CreateTablePersonAddress = "create table PersonAddress("
                                    + "AssignID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "PersonID varchar(10) NOT NULL,"
                                    + "AddressID varchar(10) NOT NULL,"
                                    + "RelationType varchar(30) NOT NULL UNIQUE)";
    
    static String CreateTableAddresses = "create table Addresses("
                                    + "AddressID varchar(10) NOT NULL PRIMARY KEY,"
                                    + "AddressCountry varchar(30) NOT NULL,"
                                    + "AddressCounty varchar(30) NOT NULL,"
                                    + "AddressZipcode varchar(20) NOT NULL,"
                                    + "AddressCity varchar(30),"
                                    + "AddressStreet varchar(50),"
                                    + "AddressNumber varchar(20))";
    
    
    static String CreateTablePersons = "create table Persons("
                                    + "PersonID varchar(10) NOT NULL PRIMARY KEY,"
                                    + "PersonName varchar(30) NOT NULL,"
                                    + "PersonPhone varchar(20) NOT NULL,"
                                    + "PersonEmail varchar(50) NOT NULL, UNIQUE(PersonPhone, PersonEmail))";
    
    
    public static String CreateTableAnimals = "create table animals(db_animalid varchar(30), db_animalrace varchar(30), db_animalspecies varchar(30), db_animalsex varchar(20), db_animalname varchar(30) NOT NULL UNIQUE, db_animalcolor varchar (30), db_animalbirthdate varchar (30), db_photoalbumid varchar (50), db_castredstatus varchar(150), db_healthstatus varchar (150), db_injurystatus varchar(150))";
    
    static String CreateTableUsers = "create table Users("
                                    + "UserID varchar(10) NOT NULL PRIMARY KEY,"
                                    + "UserName varchar(30) NOT NULL,"
                                    + "UserCompany varchar(50) NOT NULL,"
                                    + "UserPassword varchar(20) NOT NULL, UNIQUE(UserName, UserPassword))";
    
   
    
}
