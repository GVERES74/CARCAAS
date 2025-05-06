/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author DjRed
 */
public class Dialogs {
    
            
    public static void showInfoAlert(String title, String headertxt, String contenttxt){
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle(title);
        infoAlert.setHeaderText(headertxt);
        infoAlert.setContentText(contenttxt);
        infoAlert.showAndWait();
    }
    
        
    public static Boolean showConfirmAlert(String title, String headertxt, String contenttxt){
        Boolean selected = false;
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle(title);
        confirmAlert.setHeaderText(headertxt);
        confirmAlert.setContentText(contenttxt);
        Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                selected = true;
            } 
            return selected;
        
    }
    
     public static void showErrorAlert(String title, String headertxt, String contenttxt){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(headertxt);
        errorAlert.setContentText(contenttxt);
        errorAlert.showAndWait();
    }
     
     public static void showLoginAlert(String title, String headertxt, String contenttxt){
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(headertxt);
        errorAlert.setContentText(contenttxt);
        errorAlert.showAndWait();
    }
}
