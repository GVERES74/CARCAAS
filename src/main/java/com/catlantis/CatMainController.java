/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catlantis;


import Model.DBFunctions.CatDataBase;
import Model.Tables.AddressData;
import Model.Tables.AdoptionData;
import Model.Tables.AnimalConditionData;
import Model.Tables.AnimalData;
import Model.Tables.InvoiceData;
import Model.Tables.PersonAddressData;
import Model.Tables.PersonData;
import Model.Tables.ReceiptData;
import Model.Tables.ShelterData;
import Model.Tables.TreatmentData;
import Model.Tables.UserData;
import Model.Tables.VeterinaryData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import Utils.Calendar;
import Utils.Dialogs;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javax.imageio.ImageIO;




/**
 *
 * @author DjRed
 */

public class CatMainController implements Initializable{


private WebView webViewBrowser = new WebView();
private TableView tableViewNewReceipt = new TableView();
private TableView tableViewNewAnimal = new TableView();
private TableView tableViewNewPerson = new TableView();
private TableView tableViewNewAddress = new TableView();
private TableView tableViewBrowseAnimals = new TableView();
private TableView tableViewNewCastration = new TableView();
private TableView tableViewNewAnimalCondition = new TableView();
private TableView tableViewAllRecords = new TableView();
private TableView tableViewBrowseAnimalsInShelter = new TableView();

private Pane splashPane;
private Pane paneWebview;
private Button deleteButton;
private ImageView splashImageView;
private TreeMenuBuilder treeMenuBuilder = new TreeMenuBuilder();
public CatDataBase catlantisdb;
public String os_user_name = "";
private String animalimage_path = "";
private String animal_photo_dbase;

public final ObservableList<AddressData> new_address_data = FXCollections.observableArrayList();
public final ObservableList<AdoptionData> new_adoption_data = FXCollections.observableArrayList();
public final ObservableList<AnimalConditionData> new_animalcondition_data = FXCollections.observableArrayList();
public final ObservableList<AnimalData> new_animal_data = FXCollections.observableArrayList();
public final ObservableList<InvoiceData> new_invoice_data = FXCollections.observableArrayList();
public final ObservableList<PersonAddressData> new_personaddress_data = FXCollections.observableArrayList();
public final ObservableList<PersonData> new_person_data = FXCollections.observableArrayList();
public final ObservableList<ReceiptData> new_receipt_data = FXCollections.observableArrayList();
public final ObservableList<ShelterData> new_shelter_data = FXCollections.observableArrayList();
public final ObservableList<TreatmentData> new_treatment_data = FXCollections.observableArrayList();
public final ObservableList<UserData> new_user_data = FXCollections.observableArrayList();
public final ObservableList<VeterinaryData> new_veterinary_data = FXCollections.observableArrayList();

private enum AnimalStatus{
    Állományban,
    Örökbeadva,
    Elpusztult
}    

private enum CatSpecies{
    Házimacska,
   Ragdoll,
    Sziámi,
    MaineCoon
}    

private enum DogSpecies{
    Keverék,
    Tacskó,
    Foxterrier,
    Stafford,
    Labrador,
    Vizsla
}    

private enum CatColor{
    Fehér,
    Fekete,
    Barna,
    Szürke,
    Cirmos,
    Tarka,
    Tricolor
}    

private enum DogColor{
    Fehér,
    Fekete,
    Világosbarna,
    Sötétbarna,
    Tarka
}    

private enum CatGender{
    Nőstény,
    Kandúr
}    

private enum DogGender{
    Szuka,
    Kan
}    

    
@FXML
private StackPane mainContentStackPane;

@FXML
private TabPane tabPaneAdmin;

@FXML
private TreeView mainTreeViewAnimalCare, mainTreeViewFinancial, mainTreeViewDonations, mainTreeViewOrganization, mainTreeViewActions;

@FXML
private Label dateLabel, labelModulePath;

@FXML
private MenuItem menuItemAdmin;

@FXML
private TextField textFieldAnimalName, textFieldChipId;

@FXML
private TextField textFieldSaviorFirstName, textFieldSaviorLastName, textFieldSaviorPhone, textFieldSaviorEmail;

@FXML
private TextField textFieldSaviorAddressPostalCode, textFieldSaviorAddressCity, textFieldSaviorAddressStreet, textFieldSaviorAddressNum, textFieldSaviorAddressCountry, textFieldSaviorAddressCounty;

@FXML
private RadioButton radioButtonNotCastred, radioButtonCastred, radioButtonInjured, radioButtonNotInjured, radioButtonHealthy, radioButtonSick; 

@FXML
private ToggleGroup rbGroupCastred, rbGroupInjured, rbGroupHealth;

@FXML
private TextArea textAreaInjuryDetails, textAreaSicknessDetails, textAreaAdditionalInfo;


@FXML
private SplitPane splitPaneViewReceipt, splitPaneCreateNewReceipt, splitPaneNewCastration, splitPaneAllRecords;


@FXML
private AnchorPane anchorPaneGeneralInfo, anchorPaneNewReceiptTable, anchorPaneViewReceiptTable, anchorPaneViewAnimalTable, anchorPaneNewCastrationTable, anchorPaneViewPersonTable, anchorPaneViewAddressTable, anchorPaneAdminTables;

@FXML
private AnchorPane anchorPaneAllRecordsSearch, anchorPaneAllRecordsTable, anchorPaneViewConditionTable;

@FXML
private ComboBox comboBoxSelectRace, comboBoxSelectSpecies, comboBoxSelectGender, comboBoxSelectColor, comboBoxSelectAge, comboBoxSelectAgeYMW;

@FXML
private DatePicker datePickerReceiptDate, datePickerBirthDate;

@FXML
private VBox vBoxNewAnimal;

@FXML
private Button btnSaveNewReceipt, btnUploadPhoto;

@FXML
private ImageView imgViewAnimalAvatar;




//    @FXML
//    private void startModuleReceipt() throws IOException {
//        App.setRoot("Receipt");
//    }
    
    
//@FXML Methods Only!!
    @FXML
    private void exitCatMainApp() throws SQLException{
        if (Dialogs.showConfirmAlert("Kilépés a programból", null, "Biztosan kilép a programból?") == true){
            catlantisdb.connection.close();
            System.exit(0);
        }; 
    }
    
    @FXML
    private void saveNewReceipt(){
        if (Dialogs.showConfirmAlert("Új befogadás mentése", null, "Biztosan mented az adatokat?") == true){
            
            AnimalData new_animal = new AnimalData(
                comboBoxSelectRace.getValue().toString(),
                comboBoxSelectSpecies.getValue().toString(),
                comboBoxSelectGender.getValue().toString(),
                textFieldAnimalName.getText(),
                comboBoxSelectColor.getValue().toString(),
                datePickerBirthDate.getValue().toString(),
                Period.between(datePickerBirthDate.getValue(), LocalDate.now()).getYears(), //calculating the age of animal in year
                textFieldChipId.getText(),
                animalimage_path
                   
            );
            
            catlantisdb.addNewAnimal(new_animal);
            new_animal_data.addAll(new_animal);
            tableViewNewAnimal.setItems(new_animal_data);
            
            PersonData new_person = new PersonData(
                    textFieldSaviorFirstName.getText(),
                    textFieldSaviorLastName.getText(),
                    textFieldSaviorPhone.getText(),
                    textFieldSaviorEmail.getText()
            );
            
            catlantisdb.addNewPerson(new_person);
            new_person_data.addAll(new_person);
            tableViewNewPerson.setItems(new_person_data);
            
            
            AddressData new_address = new AddressData(
                    textFieldSaviorAddressCountry.getText(),
                    textFieldSaviorAddressCounty.getText(),
                    textFieldSaviorAddressPostalCode.getText(),
                    textFieldSaviorAddressCity.getText(),
                    textFieldSaviorAddressStreet.getText(),
                    textFieldSaviorAddressNum.getText()
            );
            
            catlantisdb.addNewAddress(new_address);
            new_address_data.addAll(new_address);
            tableViewNewAddress.setItems(new_address_data);


//            PersonAddressData new_personaddress = new PersonAddressData(
//                    222,333
////                    Integer.parseInt(new_personaddress.getPersonid()),
////                    Integer.parseInt(new_personaddress.getAddressid())
//            );
//            
//            catlantisdb.addNewPersonAddress(new_personaddress);
//            new_personaddress_data.addAll(new_personaddress);
//            tableViewNewAddress.setItems(new_personaddress_data);
//
//            ReceiptData new_receipt = new ReceiptData(
//                    444, 555,
////                    Integer.parseInt(new_receipt.getAnimalid()),
////                    Integer.parseInt(new_receipt.getPersonaddressid()),
//                    datePickerReceiptDate.getValue().toString(),
////                    Integer.parseInt(new_receipt.getShelterid()),
//                    666,
//                    "RESC_"+datePickerReceiptDate.getValue().toString()
//            );
//            
//            catlantisdb.addNewReceipt(new_receipt);
//            new_receipt_data.addAll(new_receipt);
//            tableViewNewReceipt.setItems(new_receipt_data);
            
            AnimalConditionData new_animalcondition = new AnimalConditionData(
                    
                    rbGroupCastred.getSelectedToggle().toString(),
                    rbGroupInjured.getSelectedToggle().toString(),
                    textAreaInjuryDetails.getText(),
                    rbGroupHealth.getSelectedToggle().toString(),
                    textAreaSicknessDetails.getText(),
                    textAreaAdditionalInfo.getText()
                    
                               
             );
            
            catlantisdb.addNewAnimalCondition(new_animalcondition);
            new_animalcondition_data.addAll(new_animalcondition);
            tableViewNewAnimalCondition.setItems(new_animalcondition_data);
            
        } 
        anchorPaneNewReceiptTable.getChildren().add(tableViewNewReceipt);
    }
    
        
    
    
    
    
//Java Methods Only!!    
    
    public void createCatlantisDataBaseConnection(){
        catlantisdb = new CatDataBase();
//        try{
//        catlantisdb.connection.createStatement().execute("DROP DATABASE catlantisdb");
//        }catch (SQLException e){
//            Dialogs.showInfoAlert("Adatbázis törlése", "FIGYELEM! BIZTOSAN TÖRÖLNI AKARJA AZ ADATBÁZIST?", "Kivétel: "+e);
//        }
    }
        
    public void showAdminTabPanes() throws SQLException{
        setActivePaneOn();
        tabPaneAdmin.toFront();
        tabPaneAdmin.setVisible(true);
        
        GridPane gridpane = new GridPane();
        gridpane.setVgap(10);
        gridpane.setHgap(10);
        TableView tblwDataTables = new TableView();
        
        ComboBox comboDataTables = new ComboBox();
        deleteButton = new Button("Törlés");
        
        gridpane.add(comboDataTables, 0, 0);
        gridpane.add(deleteButton, 0, 1);
        gridpane.add(tblwDataTables, 0, 2);
        
        
        ResultSet tables = catlantisdb.connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
            while (tables.next()){
                comboDataTables.getItems().add(tables.getString("TABLE_NAME"));    
            }
    
        anchorPaneAdminTables.getChildren().addAll(gridpane);
        
        deleteButton.setOnAction(e-> {
            catlantisdb.deleteTable(comboDataTables.getSelectionModel().getSelectedItem().toString());
        });
    }
    
    
    public void showProgInfo(){
           Dialogs.showInfoAlert("Application Information", null, "DjRed Software Development Private - 2022-2025");    
    }
    
    public void showWebInfo(){
        Alert webInfoAlert = new Alert(Alert.AlertType.INFORMATION);
        Hyperlink link1 = new Hyperlink("Visit us on Facebook");        
        Hyperlink link2 = new Hyperlink("Visit us on the Web");
        VBox vbox = new VBox();
        webInfoAlert.setTitle("Catlantis Web");
        webInfoAlert.setHeaderText("Visit us on the Web");
        webInfoAlert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("cat_info.jpg"))));
        webInfoAlert.getDialogPane().setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.getChildren().addAll(link1, link2);
                
        webInfoAlert.getDialogPane().setContent(vbox);
        webViewBrowser.prefHeightProperty().bind(mainContentStackPane.heightProperty());
        webViewBrowser.prefWidthProperty().bind(mainContentStackPane.widthProperty());
        paneWebview = new Pane(webViewBrowser);
                        
        link1.setOnAction(e-> {
            mainContentStackPane.getChildren().add(paneWebview);            
            paneWebview.toFront();
            webViewBrowser.getEngine().load("https://www.facebook.com/Catlantis-Macskament%C5%91-Egyes%C3%BClet-105195398541078");
            webInfoAlert.close();
        });
        
        link2.setOnAction(e-> {
           mainContentStackPane.getChildren().add(paneWebview);          
           paneWebview.toFront();
           webViewBrowser.getEngine().load("https://www.catlantis.hu");
           webInfoAlert.close();
        });
        
        webInfoAlert.showAndWait();
       
    }
    
    public void showSystemInfo(){
        String osname = System.getProperty("os.name");
        String osver = System.getProperty("os.version");
        Dialogs.showInfoAlert("System Information", "Operating System: "+ osname + " (Version: "+ osver+")", "User: "+os_user_name);
    }
    
    public void showBottomTitledPaneContent(){
        labelModulePath.setText("Catlantis.com");
        os_user_name = System.getProperty("user.name");
        
        Label dateLabel = new Label("Dátum: "+Calendar.calendar.getTime());
        Label userLabel = new Label("Felhasználó: "+os_user_name);
        GridPane gridPane = new GridPane();
        anchorPaneGeneralInfo.getChildren().add(gridPane);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(dateLabel, 0, 0, 1, 1);
        gridPane.add(userLabel, 1, 0, 1, 1);
   }
    
        
    private void startUpScreen(){
        setActivePaneOn();
                
        splashImageView = new ImageView();
        splashPane = new Pane(splashImageView);
        splashPane.setMaxHeight(mainContentStackPane.getMaxHeight());
        splashPane.setMaxWidth(mainContentStackPane.getMaxWidth());
        splashImageView.setFitHeight(splashPane.getMaxHeight());
        splashImageView.setFitWidth(splashPane.getMaxWidth());
        splashImageView.setPreserveRatio(true);
        splashImageView.setImage(new Image(getClass().getResourceAsStream("kitty.jpg")));
        mainContentStackPane.getChildren().add(splashPane);
        splashPane.setVisible(true);
       
    }
    
    private void setTreeViewRoots(){
        mainTreeViewAnimalCare.setRoot(treeMenuBuilder.treeItemRootAnimalCare); //Root
        mainTreeViewFinancial.setRoot(treeMenuBuilder.treeItemRootFinancial);
        mainTreeViewDonations.setRoot(treeMenuBuilder.treeItemRootDonations);
        mainTreeViewActions.setRoot(treeMenuBuilder.treeItemRootActions);
        mainTreeViewOrganization.setRoot(treeMenuBuilder.treeItemRootOrganization);
    
    }
    
   
    public void createListeners(){
        mainTreeViewAnimalCare.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>)newValue;
            String selectedMenuItem = selectedItem.getValue();
            labelModulePath.setText("/"+selectedItem.getParent().getValue()+"/"+selectedMenuItem);
                if (selectedMenuItem != null){
                    switch (selectedMenuItem){
                        case "Új bekerülés": {createNewReceipt();} break;
                        case "Bekerülés módosítása": {} break;
                        case "Bekerülések böngészése": {viewNewReceipt();} break;
                        case "Nyilvántartás megtekintése": {viewAllRecords();} break;
                        
                    }
       }});
        
       mainTreeViewFinancial.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>)newValue;
            String selectedMenuItem = selectedItem.getValue();
            labelModulePath.setText("/"+selectedItem.getParent().getValue()+"/"+selectedMenuItem);
                if (selectedMenuItem != null){
                    switch (selectedMenuItem){
                        case "Új beérkező számla": {} break;
                        case "Beérkező számla szerkesztése": {} break;
                        case "Beérkező számla megtekintése": {} break;
                    }
       }});
        
       mainTreeViewDonations.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>)newValue;
            String selectedMenuItem = selectedItem.getValue();
            labelModulePath.setText("/"+selectedItem.getParent().getValue()+"/"+selectedMenuItem);
                if (selectedMenuItem != null){
                    switch (selectedMenuItem){
                        case "Új beérkező adomány": {} break;
                        case "Új kimenő adomány": {} break;
                        case "Adomány szerkesztése": {} break;
                        case "Adományok megtekintése": {} break;
                    }
       }});
        
        
       mainTreeViewActions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>)newValue;
            String selectedMenuItem = selectedItem.getValue();
            labelModulePath.setText("/"+selectedItem.getParent().getValue()+"/"+selectedMenuItem);
                if (selectedMenuItem != null){
                    switch (selectedMenuItem){
                        case "Új ivartalanitás": {createNewCastration();} break;
                        case "Ivartalanitás szerkesztése": {} break;
                        case "Ivartalanitások megtekintése": {} break;
                       
                    }
       }});
        
        mainTreeViewOrganization.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>)newValue;
            String selectedMenuItem = selectedItem.getValue();
            labelModulePath.setText("/"+selectedItem.getParent().getValue()+"/"+selectedMenuItem);
                if (selectedMenuItem != null){
                    switch (selectedMenuItem){
                        case "Szervezeti felépítés megtekintése": {} break;
                        
                    }
       }});
        
        
        btnUploadPhoto.setOnAction(e -> {
            uploadAnimalPhoto();
        });
        
        menuItemAdmin.setOnAction(e-> {
            try { 
                showAdminTabPanes();
            } catch (SQLException ex) {
                Logger.getLogger(CatMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
    }
    
    public void uploadAnimalPhoto(){
       Stage openFileWindow = new Stage();
       FileChooser photoFileChooser = new FileChooser();
       openFileWindow.setTitle("Új kép feltöltése");
       photoFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Képfájlok, *.jpg, *.png", "*.jpg", "*.png"));
       
       File selectedPhotoFile = photoFileChooser.showOpenDialog(openFileWindow);
       Image animalphoto = new Image(selectedPhotoFile.toURI().toString());
       BufferedImage image = null;
       File sourcefile = null;
       File outfile = null;
       animalimage_path = "PID_"+textFieldAnimalName.getText()+"_"+datePickerReceiptDate.getValue().toString();
       System.out.println(animalimage_path);
       
       //reading source file
       try{
           sourcefile = new File(selectedPhotoFile.getAbsolutePath());
           image = ImageIO.read(sourcefile);
       } catch (IOException ex){
           Dialogs.showErrorAlert("Képfájl beolvasása", "Fájlnév: "+sourcefile.toString(),"");
       }
       
       //writing output file
       try{
           outfile = new File("C:/CATLANTISAPP/Animaldata/"+animalimage_path+"/Images/"+animalphoto.hashCode()+".jpg");
           ImageIO.write(image, "jpg", outfile);
       } catch (IOException ex){ 
           Dialogs.showErrorAlert("HIBA!", "Hiba a fájl mentésekor: "+outfile.toString(),"Hibakód: "+ex);
       }
       
       animal_photo_dbase = outfile.toURI().toString();
       imgViewAnimalAvatar.setImage(animalphoto);
               
            
    }
    
    
    
    
    public void createNewReceipt() {
        setActivePaneOn();
        splitPaneCreateNewReceipt.toFront();
        splitPaneCreateNewReceipt.setVisible(true);
                
        comboBoxSelectAge.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        comboBoxSelectAge.setValue(comboBoxSelectAge.getItems().get(0));
        comboBoxSelectAgeYMW.getItems().addAll("nap", "hét", "hónap", "év");
        comboBoxSelectAgeYMW.setValue(comboBoxSelectAgeYMW.getItems().get(0));
        comboBoxSelectRace.getItems().addAll("Macska", "Kutya");
        
        comboBoxSelectRace.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            comboBoxSelectSpecies.getItems().clear();
            comboBoxSelectColor.getItems().clear();
            comboBoxSelectGender.getItems().clear();
        
            String selectedRace = comboBoxSelectRace.getSelectionModel().getSelectedItem().toString();
            switch (selectedRace) {
                case "Macska" : 
                    comboBoxSelectSpecies.getItems().addAll(CatSpecies.values()); 
                    comboBoxSelectColor.getItems().addAll(CatColor.values());
                    comboBoxSelectGender.getItems().addAll(CatGender.values());
                 break;
                case "Kutya" : 
                    comboBoxSelectSpecies.getItems().addAll(DogSpecies.values()); 
                    comboBoxSelectColor.getItems().addAll(DogColor.values());
                    comboBoxSelectGender.getItems().addAll(DogGender.values());
                break;
            }            
            
        });    
        
        
        comboBoxSelectAgeYMW.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String selectedListItem = comboBoxSelectAgeYMW.getSelectionModel().getSelectedItem().toString();
            switch (selectedListItem){
                
                case "nap": {datePickerBirthDate.setValue(LocalDate.now().minusDays(Integer.parseInt(comboBoxSelectAge.getSelectionModel().getSelectedItem().toString())));} break;
                case "hét": {datePickerBirthDate.setValue(LocalDate.now().minusDays(7*Integer.parseInt(comboBoxSelectAge.getSelectionModel().getSelectedItem().toString())));} break;        
                case "hónap": {datePickerBirthDate.setValue(LocalDate.now().minusDays(30*Integer.parseInt(comboBoxSelectAge.getSelectionModel().getSelectedItem().toString())));} break;    
                case "év": {datePickerBirthDate.setValue(LocalDate.now().minusDays(365*Integer.parseInt(comboBoxSelectAge.getSelectionModel().getSelectedItem().toString())));} break;
            
            }
            
        });
    
        comboBoxSelectAge.setOnAction(e -> {
            datePickerBirthDate.setValue(LocalDate.now());
        });
   
    }
           
    public void viewNewReceipt(){
        setActivePaneOn();
        splitPaneViewReceipt.toFront();
        splitPaneViewReceipt.setVisible(true);
        //Ha hibaüzenetet kapsz (Modul elérési hiba, pl. Model, akkor a module-info.java-ba fel kell venni: opens Model to javafx.fxml; és exports Model;   
    }
    
    public void viewAllRecords(){
        setActivePaneOn();
        splitPaneAllRecords.toFront();
        splitPaneAllRecords.setVisible(true);
        //Ha hibaüzenetet kapsz (Modul elérési hiba, pl. Model, akkor a module-info.java-ba fel kell venni: opens Model to javafx.fxml; és exports Model;   
    }
    
    public void createNewCastration(){
        setActivePaneOn();
        splitPaneNewCastration.toFront();
        splitPaneNewCastration.setVisible(true);
    }
    
   
//SET TABLE COLUMNS    
    public void setNewReceiptTableColumns(){ //Data of a new receipt
        TableColumn receiptIdCol = createTableColumn("Mentés azonosító", "receiptid", 50);
        TableColumn animalIdCol = createTableColumn("Állat azonosító", "animnalid", 50);
        TableColumn personIdCol = createTableColumn("Mentő azonosító", "personid", 50);
        TableColumn addressIdCol = createTableColumn("Cím azonosító", "addressid", 50);
        TableColumn castredStatusCol = createTableColumn("Nemzőképesség", "castredstatus", 50);
        TableColumn injuryStatusCol = createTableColumn("Sérülések", "injurystatus", 50);
        TableColumn injuryDescCol = createTableColumn("Sérülés leírása", "injurydesc", 50);
        TableColumn healthStatuscCol = createTableColumn("Egészségi állapot", "healthstatus", 50);
        TableColumn sicknessDescCol = createTableColumn("Betegség leírása", "sicknessdesc", 50);
        TableColumn remarksCol = createTableColumn("Megjegyzések", "remarks", 50);
        TableColumn receiptDateCol = createTableColumn("Átvétel dátuma", "receiptdate", 50);
        
        tableViewNewReceipt.getColumns().addAll(receiptIdCol, animalIdCol, personIdCol, addressIdCol, castredStatusCol, injuryStatusCol, injuryDescCol, healthStatuscCol, sicknessDescCol, remarksCol, receiptDateCol);
        tableViewNewReceipt.setEditable(true);
        anchorPaneViewReceiptTable.getChildren().add(tableViewNewReceipt);
        new_receipt_data.addAll(catlantisdb.getReceipts());
        tableViewNewReceipt.setItems(new_receipt_data);
    }   
    
       
    
    public void setViewAnimalTableColumns(){ //Animals just received in the shelter
                  
        TableColumn animalIdCol = createTableColumn("Azonosító", "animalid", 50);
        TableColumn animalRaceCol = createTableColumn("Faj", "animalrace", 50);
        TableColumn animalSpeciesCol = createTableColumn("Fajta", "animalspecies", 50);
        TableColumn animalSexCol = createTableColumn("Neme", "animalsex", 50);
        TableColumn animalNameCol = createTableColumn("Név", "animalname", 50);
        TableColumn animalColorCol = createTableColumn("Szin", "animalcolor", 50);
        TableColumn animalBirthdateCol = createTableColumn("Születési dátum", "animalbirthdate", 50);
        TableColumn animalAgeCol = createTableColumn("Életkor", "animalage", 50);
        TableColumn animalChipIdCol = createTableColumn("Chip azonositó", "chipid", 50);
        TableColumn animalPhotoalbumIDCol = createTableColumn("Fényképalbum", "photoalbumid", 50);
        
        
        tableViewBrowseAnimals.getColumns().addAll(animalIdCol,animalRaceCol,animalSpeciesCol,animalSexCol,animalNameCol,animalColorCol,animalBirthdateCol, animalAgeCol, animalChipIdCol, animalPhotoalbumIDCol);
        tableViewBrowseAnimals.setEditable(true);
        anchorPaneViewAnimalTable.getChildren().add(tableViewBrowseAnimals);
        
        new_animal_data.addAll(catlantisdb.getAnimals());
        tableViewBrowseAnimals.setItems(new_animal_data);
    }    
        
         
    public void setViewPersonTableColumns(){
        TableColumn personIdCol = createTableColumn("Azonosító", "personid", 30);
        TableColumn personFirstNameCol = createTableColumn("Vezetéknév", "personfirstname", 50);
        TableColumn personLastNameCol = createTableColumn("Keresztnév", "personlastname", 50);
        TableColumn personPhoneCol = createTableColumn("Telefonszám", "personphone", 20);
        TableColumn personEmailCol = createTableColumn("E-mail", "personemail", 100);
        tableViewNewPerson.getColumns().addAll(personIdCol, personFirstNameCol, personLastNameCol, personPhoneCol, personEmailCol);
        tableViewNewPerson.setEditable(true);
        anchorPaneViewPersonTable.getChildren().add(tableViewNewPerson);
        new_person_data.addAll(catlantisdb.getPersons());
        tableViewNewPerson.setItems(new_person_data);
    }   

    public void setViewAddressTableColumns(){
        TableColumn addressIdCol = createTableColumn("Azonosító", "addressid", 30);
        TableColumn countryCol = createTableColumn("Ország", "addresscountry", 50);
        TableColumn countyCol = createTableColumn("Megye", "addresscounty", 50);
        TableColumn zipcodeCol = createTableColumn("Irányitószám", "addresszipcode", 50);
        TableColumn cityCol = createTableColumn("Település", "addresscity", 50);
        TableColumn streetCol = createTableColumn("Utca", "addressstreet", 50);
        TableColumn addressnumberCol = createTableColumn("Házszám", "addressnumber", 50);
        
        tableViewNewAddress.getColumns().addAll(addressIdCol, countryCol, countyCol, zipcodeCol, cityCol, streetCol, addressnumberCol);
        tableViewNewAddress.setEditable(true);
        anchorPaneViewAddressTable.getChildren().add(tableViewNewAddress);
        new_address_data.addAll(catlantisdb.getAddresses());
        tableViewNewAddress.setItems(new_address_data);
    }   
    
    public void setViewAnimalConditionTableColumns(){ //Receipt conditions
                 
        TableColumn animalConditionIdCol = createTableColumn("Azonosító", "animalconditionid", 50);
        TableColumn animalReceiptIdCol = createTableColumn("Befogadás azonositó", "receiptid", 50);
        TableColumn animalCastredStatusCol = createTableColumn("Nemzőképesség", "castredstatus", 50);
        TableColumn animalInjuryStatusCol = createTableColumn("Sérülés", "injurystatus", 150);
        TableColumn animalInjuryDescCol = createTableColumn("Sérülés leirása", "injurydesc", 250);
        TableColumn animalHealthStatusCol = createTableColumn("Egészségi állapot", "healthstatus", 150);
        TableColumn animalSicknessDescCol = createTableColumn("Betegség leirása", "sicknessdesc", 250);
        TableColumn remarksCol = createTableColumn("Megjegyzések", "remarks", 250);
        
        tableViewNewAnimalCondition.getColumns().addAll(animalConditionIdCol, animalReceiptIdCol, animalCastredStatusCol, animalInjuryStatusCol, animalInjuryDescCol, animalHealthStatusCol, animalSicknessDescCol, remarksCol);
        tableViewNewAnimalCondition.setEditable(true);
        anchorPaneViewConditionTable.getChildren().addAll(tableViewNewAnimalCondition);
        new_animalcondition_data.addAll(catlantisdb.getAnimalconditions());
        tableViewNewAnimalCondition.setItems(new_animalcondition_data);
                      
    }    
    
    
     public void setViewAnimalsInShelterColumns(){ //Animals in the shelter
                  
        TableColumn animalIdCol = createTableColumn("Azonosító", "animalid", 50);
        TableColumn animalRaceCol = createTableColumn("Faj", "animalrace", 50);
        TableColumn animalSpeciesCol = createTableColumn("Fajta", "animalspecies", 50);
        TableColumn animalSexCol = createTableColumn("Neme", "animalsex", 50);
        TableColumn animalNameCol = createTableColumn("Név", "animalname", 50);
        TableColumn animalColorCol = createTableColumn("Szin", "animalcolor", 50);
        TableColumn animalBirthdateCol = createTableColumn("Születési dátum", "animalbirthdate", 50);
        TableColumn animalAgeCol = createTableColumn("Életkor", "animalage", 50);
        TableColumn animalChipIdCol = createTableColumn("Chip azonositó", "chipid", 50);
        TableColumn animalPhotoalbumIDCol = createTableColumn("Fényképalbum", "photoalbumid", 50);
        
        
        tableViewBrowseAnimalsInShelter.getColumns().addAll(animalIdCol,animalRaceCol,animalSpeciesCol,animalSexCol,animalNameCol,animalColorCol,animalBirthdateCol, animalAgeCol, animalChipIdCol, animalPhotoalbumIDCol);
        tableViewBrowseAnimalsInShelter.setEditable(true);
        anchorPaneAllRecordsTable.getChildren().add(tableViewBrowseAnimalsInShelter);
//        new_animal_data.addAll(catlantisdb.getAnimals());
        tableViewBrowseAnimalsInShelter.setItems(new_animal_data);
    }    
    
    
    
    
//    public void setNewCastrationTableColumns(){
//        TableColumn animalIdCol = createTableColumn("Azonosító", "animalid", 50);
//        TableColumn animalRaceCol = createTableColumn("Faj", "animalrace", 50);
//        TableColumn animalNameCol = createTableColumn("Név", "animalname", 50);
//        TableColumn animalSpeciesCol = createTableColumn("Fajta", "animalspecies", 50);
//        TableColumn animalSexCol = createTableColumn("Neme", "animalsex", 50);
//        TableColumn animalColorCol = createTableColumn("Szin", "animalcolor", 50);
//        TableColumn animalBirthdateCol = createTableColumn("Születési dátum", "animalbirthdate", 50);
//        TableColumn animalHealthstatusCol = createTableColumn("Egészségi állapot", "healthstatus", 150);
//        TableColumn animalInjurystatusCol = createTableColumn("Sérülés", "injurystatus", 150);
//        tableViewNewCastration.getColumns().addAll(animalIdCol,animalRaceCol,animalSpeciesCol,animalSexCol,animalNameCol,animalColorCol,animalBirthdateCol,animalHealthstatusCol,animalInjurystatusCol);
//        
//        ScrollPane tblViewScrollPane = new ScrollPane(tableViewNewCastration);
//                   tblViewScrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
//        anchorPaneNewCastrationTable.getChildren().add(tblViewScrollPane);
//      
//    }    
     
     
//FUNCTIONS-----------------------------------------------------------------------------------------------------------------------------
    public void setActivePaneOn(){
        mainContentStackPane.getChildren().forEach(childrenPanes -> childrenPanes.setVisible(false)); //All children Panes set to invisible
        
    }
    
                
    public TableColumn createTableColumn (String columnDesc, String propertyName, int size){
        
        TableColumn columnName = new TableColumn(columnDesc);
        columnName.setMinWidth(size);
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnName.setCellValueFactory(new PropertyValueFactory<AnimalData, String>(propertyName));
        return columnName;
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        setTreeViewRoots();
        showBottomTitledPaneContent();
        createListeners();
        startUpScreen();
        createCatlantisDataBaseConnection();
        setNewReceiptTableColumns();
        setViewAnimalTableColumns();
        setViewPersonTableColumns();
        setViewAddressTableColumns();
//        setNewCastrationTableColumns();
        setViewAnimalConditionTableColumns();
        setViewAnimalsInShelterColumns();
        
    }
}  
