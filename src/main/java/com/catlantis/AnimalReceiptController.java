/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.catlantis;

import Model.Tables.AnimalData;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author DjRed
 */
public class AnimalReceiptController{

@FXML
TitledPane frmTitledPaneNewReceipt;

@FXML
private SplitPane formReceiptViewSplitPane;

@FXML
private TableView tableView_RescuedAnimals;

@FXML
private ComboBox comboBoxSelectRace, comboBoxSelectSpecies, comboBoxSelectGender, comboBoxSelectColor, comboBoxSelectAge, comboBoxSelectAgeYMW;

@FXML
private DatePicker datePickerReceiptDate, datePickerBirthDate, datePickerRescueDate;

@FXML
private Button btnSaveNewReceipt;

private final ObservableList<AnimalData> rescuedAnimals = FXCollections.observableArrayList(new AnimalData("1", "2023.04.14", "Macska", "Házimacska", "Taki", "Nőstény", "Fehér", "4 hét", "Ivartalanított", "Egészséges", "Sérülésmentes")
);

TitledPane ttlp = new TitledPane();


public AnimalReceiptController(){



}

public TableColumn createTableColumn (String columnDesc, String propertyName, int size){
        
        TableColumn columnName = new TableColumn(columnDesc);
        columnName.setMinWidth(size);
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        columnName.setCellValueFactory(new PropertyValueFactory<AnimalData, String>(propertyName));
        return columnName;
    }

public void createNewReceipt() {
        ttlp.toFront();
        
        frmTitledPaneNewReceipt.toFront();
        frmTitledPaneNewReceipt.setVisible(true);
        
       comboBoxSelectRace.getItems().addAll("Macska","Kutya","Hörcsög","Nyúl");
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
                
        tableView_RescuedAnimals.getColumns().addAll(rescuedAnimals);
        TableColumn animalIdCol = createTableColumn("Azonosító", "animalid", 50);
        TableColumn animalRaceCol = createTableColumn("Faj", "animalrace", 50);
    }
    

}


