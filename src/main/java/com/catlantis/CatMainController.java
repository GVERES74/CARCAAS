/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catlantis;


import Model.DBFunctions.CatDataBase;
import Model.Tables.AnimalData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import Utils.Calendar;
import Utils.Dialogs;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.GregorianCalendar;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;



/**
 *
 * @author DjRed
 */

public class CatMainController implements Initializable{


private WebView webViewBrowser = new WebView();
private Pane splashPane;
private Pane paneWebview;
private ImageView splashImageView;
private TreeMenuBuilder treeMenuBuilder = new TreeMenuBuilder();
public CatDataBase catlantisdb;
public AnimalReceiptController receiptController = new AnimalReceiptController();



@FXML
private MenuItem menuItemPopupAbout, menuItemSysInfo;

@FXML
private AnchorPane mainTreeMenuSplitPaneBottomAnchorPane, mainTreeMenuSplitPaneTopAnchorPane;

@FXML
private StackPane mainContentStackPane;

@FXML
private TreeView mainTreeViewAnimalCare, mainTreeViewFinancial, mainTreeViewDonations, mainTreeViewOrganization, mainTreeViewActions;

@FXML
private Label dateLabel, labelModulePath;

@FXML
private TextField textFieldAnimalName;

@FXML
private TextField textFieldSaviorName, textFieldSaviorPhone, textFieldSaviorEmail;

@FXML
private TextField textFieldSaviorAddressPostalCode, textFieldSaviorAddressCity, textFieldSaviorAddressStreet, textFieldSaviorAddressNum, textFieldSaviorAddressCountry, textFieldSaviorAddressCounty;

@FXML
private TextField textFieldRescueAddressCountry, textFieldRescueAddressCounty, textFieldRescueAddressCity, textFieldRescueAddressStreet, textFieldRescueAddressNum, textFieldRescueAddressPostalCode;

@FXML
private RadioButton radioButtonNotCastred, radioButtonCastred, radioButtonInjured, radioButtonNotInjured, radioButtonHealthy, radioButtonSick; 

@FXML
private ToggleGroup rbGroupCastred, rbGroupInjured, rbGroupHealth;

@FXML
private TextArea textAreaInjuryDetails, textAreaSicknessDetails, textAreaAdditionalInfo;


@FXML
private SplitPane formReceiptViewSplitPane, splitPaneNewReceipt;

@FXML
private TableView tableViewBrowseReceipts, tableViewNewReceipt;

@FXML
private ComboBox comboBoxSelectRace, comboBoxSelectSpecies, comboBoxSelectGender, comboBoxSelectColor, comboBoxSelectAge, comboBoxSelectAgeYMW;

@FXML
private DatePicker datePickerReceiptDate, datePickerBirthDate, datePickerRescueDate;

@FXML
private Button btnSaveNewReceipt;


public final ObservableList<AnimalData> newanimaldata = FXCollections.observableArrayList();

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
            AnimalData newanimal = new AnimalData(
                                                    datePickerReceiptDate.getValue().toString()+textFieldAnimalName.getText(),
                                                    
                                                    comboBoxSelectRace.getValue().toString(),
                                                    comboBoxSelectSpecies.getValue().toString(),
                                                    comboBoxSelectGender.getValue().toString(),
                                                    textFieldAnimalName.getText(),
                                                    comboBoxSelectColor.getValue().toString(),
//                                                    comboBoxSelectAge.getValue().toString()+" "+comboBoxSelectAgeYMW.getValue().toString(),
                                                    datePickerBirthDate.getValue().toString(),
                                                    textFieldAnimalName.getText()+"_"+Calendar.calendar.getTime(),
                                                    rbGroupCastred.getSelectedToggle().toString(),
                                                    rbGroupHealth.getSelectedToggle().toString(),
                                                    rbGroupInjured.getSelectedToggle().toString()
            
            
            
            );
            
            
            newanimaldata.addAll(newanimal);
            catlantisdb.addNewReceipt(newanimal);
            tableViewNewReceipt.setItems(newanimaldata);
            
        }; 
    }
    
    @FXML
    private void deleteTable(){
      catlantisdb.deleteTable("animals");
    } 
    
    
//Java Methods Only!!    
    
    public void createCatlantisDataBaseConnection(){
        catlantisdb = new CatDataBase();
        
    }
            
    public void showProgInfo(){
        
        Dialogs.showInfoAlert("Application Information", null, "DjRed Software Development Private - 2022");    
        
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
        String user = System.getProperty("user.name");
        Dialogs.showInfoAlert("System Information", "Operating System: "+ osname + " (Version: "+ osver+")", "User: "+user);
      
    }
    
    public void showBottomTitledPaneContent(){
        labelModulePath.setText("Catlantis.com");
        dateLabel.setText("Dátum: "+Calendar.calendar.getTime());
        
    }
    
        
    private void startUpScreen(){
        splashImageView = new ImageView();
        splashPane = new Pane(splashImageView);
        splashPane.setMaxHeight(mainContentStackPane.getMaxHeight());
        splashPane.setMaxWidth(mainContentStackPane.getMaxWidth());
        splashImageView.setFitHeight(splashPane.getMaxHeight());
        splashImageView.setFitWidth(splashPane.getMaxWidth());
        splashImageView.setPreserveRatio(true);
        splashImageView.setImage(new Image(getClass().getResourceAsStream("kitty.jpg")));
        mainContentStackPane.getChildren().add(splashPane);
        splashPane.toFront();
    }
    
    private void setTreeViewRoots(){
        mainTreeViewAnimalCare.setRoot(treeMenuBuilder.treeItemRootAnimalCare); //Root
        mainTreeViewFinancial.setRoot(treeMenuBuilder.treeItemRootFinancial);
        mainTreeViewDonations.setRoot(treeMenuBuilder.treeItemRootDonations);
        mainTreeViewActions.setRoot(treeMenuBuilder.treeItemCastration);
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
        
        mainTreeViewOrganization.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> selectedItem = (TreeItem<String>)newValue;
            String selectedMenuItem = selectedItem.getValue();
            labelModulePath.setText("/"+selectedItem.getParent().getValue()+"/"+selectedMenuItem);
                if (selectedMenuItem != null){
                    switch (selectedMenuItem){
                        case "Szervezeti felépítés megtekintése": {} break;
                        
                    }
                }});
     }
    
    
    public void createNewReceipt() {
                
        splitPaneNewReceipt.toFront();
        splitPaneNewReceipt.setVisible(true);
        
       comboBoxSelectRace.getItems().addAll("Macska","Kutya","Hörcsög","Nyúl");
       comboBoxSelectSpecies.getItems().addAll("Maine Coon", "Ragdoll", "Sziámi", "Labrador");
       comboBoxSelectColor.getItems().addAll("Fehér", "Fekete", "Barna", "Vörös", "Tricolor");
       comboBoxSelectGender.getItems().addAll("Hím", "Nőstény", "Kandúr", "Kan", "Szuka");
       comboBoxSelectAge.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
       comboBoxSelectAge.setValue(comboBoxSelectAge.getItems().get(0));
       comboBoxSelectAgeYMW.getItems().addAll("nap", "hét", "hónap", "év");
       comboBoxSelectAgeYMW.setValue(comboBoxSelectAgeYMW.getItems().get(0));
        
        
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
        formReceiptViewSplitPane.toFront();
        formReceiptViewSplitPane.setVisible(true);
        tableViewBrowseReceipts.setItems(newanimaldata);        
        //Ha hibaüzenetet kapsz (Modul elérési hiba, pl. Model, akkor a module-info.java-ba fel kell venni: opens Model to javafx.fxml; és exports Model;   
       
        
    }
    
    public TableColumn createTableColumn (String columnDesc, String propertyName, int size){
        
        TableColumn columnName = new TableColumn(columnDesc);
        columnName.setMinWidth(size);
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnName.setCellValueFactory(new PropertyValueFactory<AnimalData, String>(propertyName));
        return columnName;
    }
    
    public void setNewReceiptTableColumns(){
        TableColumn animalIdCol = createTableColumn("Azonosító", "animalid", 50);
//        TableColumn animalRescuedateCol = createTableColumn("Befogadás dátuma", "animalid", 50);
        TableColumn animalRaceCol = createTableColumn("Faj", "animalrace", 50);
        TableColumn animalNameCol = createTableColumn("Név", "animalname", 50);
        TableColumn animalSpeciesCol = createTableColumn("Fajta", "animalspecies", 50);
        TableColumn animalSexCol = createTableColumn("Neme", "animalsex", 50);
        
        TableColumn animalColorCol = createTableColumn("Szin", "animalcolor", 50);
        TableColumn animalBirthdateCol = createTableColumn("Születési dátum", "animalbirthdate", 50);
        TableColumn animalPhotoalbumIDCol = createTableColumn("Fényképalbum", "photoalbumid", 50);
        TableColumn animalCastredstatusCol = createTableColumn("Nemzőképesség", "castredstatus", 150);
        TableColumn animalHealthstatusCol = createTableColumn("Egészségi állapot", "healthstatus", 150);
        TableColumn animalInjurystatusCol = createTableColumn("Sérülés", "injurystatus", 150);
        tableViewNewReceipt.getColumns().addAll(animalIdCol,animalRaceCol,animalSpeciesCol,animalSexCol,animalNameCol,animalColorCol,animalBirthdateCol,animalPhotoalbumIDCol,animalCastredstatusCol,animalHealthstatusCol,animalInjurystatusCol);
    }    
    
    public void setViewReceiptTableColumns(){
                  
        TableColumn animalIdCol = createTableColumn("Azonosító", "animalid", 50);
        TableColumn animalRaceCol = createTableColumn("Faj", "animalrace", 50);
        TableColumn animalSpeciesCol = createTableColumn("Fajta", "animalspecies", 50);
        TableColumn animalSexCol = createTableColumn("Neme", "animalsex", 50);
        TableColumn animalNameCol = createTableColumn("Név", "animalname", 50);
        TableColumn animalColorCol = createTableColumn("Szin", "animalcolor", 50);
        TableColumn animalBirthdateCol = createTableColumn("Születési dátum", "animalbirthdate", 50);
        TableColumn animalPhotoalbumIDCol = createTableColumn("Fényképalbum", "photoalbumid", 50);
        TableColumn animalCastredstatusCol = createTableColumn("Nemzőképesség", "castredstatus", 50);
        TableColumn animalHealthstatusCol = createTableColumn("Egészségi állapot", "healthstatus", 50);
        TableColumn animalInjurystatusCol = createTableColumn("Sérülés", "injurystatus", 50);
              
        tableViewBrowseReceipts.getColumns().addAll(animalIdCol,animalRaceCol,animalSpeciesCol,animalSexCol,animalNameCol,animalColorCol,animalBirthdateCol,animalPhotoalbumIDCol,animalCastredstatusCol,animalHealthstatusCol,animalInjurystatusCol);
        newanimaldata.addAll(catlantisdb.getAnimals());
        
    }    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        setTreeViewRoots();
        showBottomTitledPaneContent();
        createListeners();
        startUpScreen();
        createCatlantisDataBaseConnection();
        setNewReceiptTableColumns();
        setViewReceiptTableColumns();
    }
}  
