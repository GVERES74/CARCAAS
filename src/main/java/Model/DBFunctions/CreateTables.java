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
                                    + "db_receipt_id INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "db_animal_id INT NOT NULL,"
                                    + "db_rescuer_person_id varchar(10),"
                                    + "db_rescue_address_id varchar(10),"
                                    + "db_castred_status varchar(10),"
                                    + "db_injury_status varchar(10),"
                                    + "db_injury_desc varchar (250),"
                                    + "db_health_status varchar (10),"
                                    + "db_sickness_desc varchar (250),"
                                    + "db_remarks varchar (250),"
                                    + "db_receipt_date varchar(20),"
                                    + "db_user_id varchar (10))"; //Rögzítő felhasználó ID

    
    static String CreateTablePersonAddress = "create table personaddress("
                                    + "db_assign_id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "db_person_id INT NOT NULL,"
                                    + "db_address_id INT NOT NULL,"
                                    + "db_relation_type varchar(30) NOT NULL UNIQUE)";
    
    static String CreateTableAddresses = "create table addresses("
                                    + "db_address_id INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "db_address_country varchar(30) NOT NULL,"
                                    + "db_address_county varchar(30) NOT NULL,"
                                    + "db_address_zipcode varchar(20) NOT NULL,"
                                    + "db_address_city varchar(30),"
                                    + "db_address_street varchar(50),"
                                    + "db_address_number varchar(20))";
    
    
    static String CreateTablePersons = "create table persons("
                                    + "db_person_id INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "db_person_name varchar(30) NOT NULL,"
                                    + "db_person_phone varchar(20) NOT NULL,"
                                    + "db_person_email varchar(50) NOT NULL)";
    
    
    public static String CreateTableAnimals = "create table animals("
            + "db_animal_id INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "db_animal_race varchar(30), "
            + "db_animal_species varchar(30), "
            + "db_animal_sex varchar(20), "
            + "db_animal_name varchar(30) NOT NULL UNIQUE, "
            + "db_animal_color varchar (30), "
            + "db_animal_birthdate varchar (30), "
            + "db_photoalbum_id varchar (50))";
    
    
    static String CreateTableUsers = "create table users("
                                    + "user_id INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "user_cat_id varchar(9),"
                                    + "user_name varchar(30) NOT NULL,"
                                    + "user_phone varchar(30) NOT NULL,"
                                    + "user_email varchar(30) NOT NULL,"
                                    + "user_company_id INT NOT NULL,"
                                    + "user_password varchar(20) NOT NULL UNIQUE)";
    //user_cat_id = e.g. CAT105544
   
    
    static String CreateTableCompanies = "create table companies("
                                    + "company_id INT PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                                    + "company_name varchar(50) NOT NULL,"
                                    + "company_phone varchar(30) NOT NULL,"
                                    + "company_email varchar(30) NOT NULL,"
                                    + "company_address_zipcode varchar(30) NOT NULL,"
                                    + "company_address_country varchar(30),"
                                    + "company_address_county varchar(30),"
                                    + "company_address_city varchar(30),"
                                    + "company_address_street varchar(30),"
                                    + "company_address_number varchar(30))";
}
