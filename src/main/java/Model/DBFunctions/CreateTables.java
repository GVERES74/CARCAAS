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
    
	

	public static String CreateTableAnimals = "create table ANIMALS("
            + "db_animal_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
            + "db_animal_race varchar(30),"
            + "db_animal_species varchar(30),"
            + "db_animal_sex varchar(20),"
            + "db_animal_name varchar(30) NOT NULL UNIQUE,"
            + "db_animal_color varchar (30),"
            + "db_animal_birthdate varchar (30),"
            + "db_animal_age INT,"
            + "db_chip_id varchar (20) UNIQUE,"
            + "db_photoalbum_id varchar (50))";
    

	public static String CreateTablePersons = "create table PERSONS("
           + "db_person_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_person_first_name varchar(20) NOT NULL,"
           + "db_person_last_name varchar(20) NOT NULL,"
           + "db_person_phone varchar(20) NOT NULL UNIQUE,"
           + "db_person_email varchar(50) NOT NULL UNIQUE)";

        
        public static String CreateTableUsers = "create table USERS("
            + "db_user_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
            + "db_user_name varchar (20) NOT NULL,"
            + "db_user_password varchar (20) NOT NULL,"
            + "db_person_id INT,"
            + "FOREIGN KEY (db_person_id) REFERENCES PERSONS)";
        
        
	public static String CreateTableAddresses = "create table ADDRESSES("
           + "db_address_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_address_country varchar(30) NOT NULL,"
           + "db_address_county varchar(30) NOT NULL,"
           + "db_address_zipcode varchar(20) NOT NULL,"
           + "db_address_city varchar(30),"
           + "db_address_street varchar(50),"
           + "db_address_number varchar(20))";
    
      
    
	public static String CreateTablePersonAddress = "create table PERSONADDRESS("
           + "db_personaddress_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_person_id INT,"
           + "db_address_id INT,"
           + "FOREIGN KEY (db_person_id) REFERENCES PERSONS,"
           + "FOREIGN KEY (db_address_id) REFERENCES ADDRESSES)";     


	public static String CreateTableReceipts = "create table RECEIPTS("
           + "db_receipt_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_animal_id INT,"
           + "db_personaddress_id INT,"
	   + "db_receipt_date varchar (10),"
	   + "db_shelter_id INT,"
	   + "db_receipt_log_number varchar(20),"
           + "FOREIGN KEY (db_animal_id) REFERENCES ANIMALS,"
           + "FOREIGN KEY (db_personaddress_id) REFERENCES PERSONADDRESS,"
           + "FOREIGN KEY (db_shelter_id) REFERENCES SHELTERS)";

                                    

	public static String CreateTableAdoptions = "create table ADOPTIONS("
           + "db_adoption_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_animal_id INT,"
           + "db_personaddress_id INT,"
	   + "db_adoption_date DATE,"
	   + "db_shelter_id INT,"
	   + "db_adoption_log_number INT,"
           + "FOREIGN KEY (db_animal_id) REFERENCES ANIMALS,"
           + "FOREIGN KEY (db_personaddress_id) REFERENCES PERSONADDRESS,"
           + "FOREIGN KEY (db_shelter_id) REFERENCES SHELTERS)";     


	public static String CreateTableAnimalConditions = "create table ANIMALCONDITIONS("
           + "db_animalcondition_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_receipt_id INT,"
           + "db_castred_status varchar (50),"
	   + "db_injury_status varchar (50),"
	   + "db_injury_desc varchar (250),"
           + "db_health_status varchar (50),"
	   + "db_sickness_desc varchar (250),"
	   + "db_remarks varchar (250),"
           + "FOREIGN KEY (db_receipt_id) REFERENCES RECEIPTS)";


	public static String CreateTableShelters = "create table SHELTERS("
           + "db_shelter_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_shelter_name varchar (50),"
           + "db_shelter_taxnumber varchar (50)," 
           + "db_shelter_bankaccount_number varchar (50),"     
           + "db_animal_id INT," 
           + "db_personaddress_id INT,"     
           + "FOREIGN KEY (db_animal_id) REFERENCES ANIMALS,"
	   + "FOREIGN KEY (db_personaddress_id) REFERENCES PERSONADDRESS)";


	public static String CreateTableVeterinaries = "create table VETERINARIES("
           + "db_vet_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_vet_name varchar (50),"
           + "db_vet_taxnumber varchar (50)," 
           + "db_vet_bankaccount_number varchar (50),"
           + "db_personaddress_id INT,"     
	   + "FOREIGN KEY (db_personaddress_id) REFERENCES PERSONADDRESS)";



	public static String CreateTableTreatments = "create table TREATMENTS("
           + "db_treatment_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_treatment_type varchar (30),"
           + "db_treatment_date DATE,"
           + "db_vet_id INT,"
           + "db_animal_id INT,"          
           + "db_invoice_id INT,"     
           + "db_treatment_log_number INT,"     
	   + "FOREIGN KEY (db_vet_id) REFERENCES VETERINARIES,"
	   + "FOREIGN KEY (db_animal_id) REFERENCES ANIMALS,"
	   + "FOREIGN KEY (db_invoice_id) REFERENCES INVOICES)";


	public static String CreateTableInvoices = "create table INVOICES("
           + "db_invoice_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
           + "db_invoice_number varchar (30) NOT NULL,"
           + "db_invoice_cost INT,"
	   + "db_invoice_date DATE,"
	   + "db_payment_duedate DATE,"
	   + "db_payment_paiddate DATE,"
	   + "db_invoice_status varchar (10))";




} //end of class
